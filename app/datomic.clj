(ns datomic

  (:require [clojure.core.async :refer (<!!)]
            [clojure.walk :as walk]
            [datomic.client :as client]
            )
  (:import (java.util Map)
           (clojure.lang IPersistentMap IRecord ISeq)
           (scala.collection Seq AbstractSeq JavaConverters)
           (scala.collection.immutable List)
           (scala.collection JavaConversions))

  (:gen-class
    :name api.datastore.datomic
    :methods [#^{:static true} [transxSchema [Object Object] Object]
              #^{:static true} [unpack
                                [Object]
                                clojure.lang.IPersistentMap]
              #^{:static true} [toClojure
                                [scala.collection.Seq]
                                Object]
              #^{:static true} [retVal
                                [Object]
                                String]

              ]))
(def conn
  (<!! (client/connect
         {:db-name    "hello"
          :account-id client/PRO_ACCOUNT
          :secret     "mysecret"
          :region     "none"
          :endpoint   "localhost:8998"
          :service    "peer-server"
          :access-key "myaccesskey"})))

(def movie-schema [{:db/ident       :movie/title
                    :db/valueType   :db.type/string
                    :db/cardinality :db.cardinality/one
                    :db/doc         "The title of the movie"}

                   {:db/ident       :movie/genre
                    :db/valueType   :db.type/string
                    :db/cardinality :db.cardinality/one
                    :db/doc         "The genre of the movie"}

                   {:db/ident       :movie/release-year
                    :db/valueType   :db.type/long
                    :db/cardinality :db.cardinality/one
                    :db/doc         "The year the movie was released in theaters"}])


(defn inner
  "docstring"
  [arg]
  (.println System/out
            (if (instance? AbstractSeq arg)
              "Some Sequence"
              (bean arg))))

(defn map-values
  "docstring"
  [f m]
  (into {} (for [[k v] m] [k (f v)])))

(defn scala-seq->vec
  "Convert a Scala Seq to a vector.
  *Arguments*:
    * `scala-seq`: a Scala Seq
  *Returns*:
    A PersistentVector with the contents of `scala-seq`."
  [scala-seq]

  )

(defn -toClojure
  "Convert a Scala Iterable to A Java Iterable, which is
  implemented by clojure.lang.ASeq"
  [scala-seq]
  (seq (JavaConverters/asJavaIterable scala-seq)))

(defn -unpack
  "docstring"
  [v0]
  (cond
    (instance? IRecord v0) (-unpack (bean v0))
    (map? v0) (map-values -unpack v0)
    (instance? AbstractSeq v0) (-unpack (-toClojure v0))
    (sequential? v0) (map -unpack v0)
    :else v0)
  )

(defn -transxSchema
  "Transact Service Schema in Datomic"
  [properties schema]

  (let [schema-map (bean schema)]
    (.println System/out schema-map))

  (.println System/out (.properties schema))

  )
