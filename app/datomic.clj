(ns datomic

  (:require [clojure.core.async :refer (<!!)]
            [clojure.walk :as walk]
            [datomic.client :as client]
            )
  (:import (java.util Map)
           (clojure.lang IPersistentMap IRecord ISeq)
           (scala.collection Seq AbstractSeq JavaConverters)
           (scala.collection.immutable List)
           (scala.collection JavaConversions)
           (scala Enumeration)
           (models.svc JsonEnum))

  (:gen-class
    :name ^{javax.inject.Singleton true} api.datastore.datomic
    :methods [#^{:static true} [unpack
                                [Object]
                                java.lang.Iterable]

              #^{:static true} [makeTuple
                                [clojure.lang.IRecord java.lang.String]
                                java.lang.Object]
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


;(def movie-schema [{:db/ident       :movie/title
;                    :db/valueType   :db.type/string
;                    :db/cardinality :db.cardinality/one
;                      :db/doc         "The title of the movie"}
;
;                   {:db/ident       :movie/genre
;                    :db/valueType   :db.type/string
;                    :db/cardinality :db.cardinality/one
;                    :db/doc         "The genre of the movie"}
;
;                   {:db/ident       :movie/release-year
;                    :db/valueType   :db.type/long
;                    :db/cardinality :db.cardinality/one
;                    :db/doc         "The year the movie was released in theaters"}])


(defn map-values
  "docstring"
  [f m]
  (into {} (for [[k v] m] [k (f v)])))


(defn toClojure
  "Convert a Scala Iterable to A Java Iterable, which is
  implemented by clojure.lang.ASeq"
  [scala-seq]
  (seq (JavaConverters/asJavaIterable scala-seq)))

(defn -unpack
  "docstring"
  [record]

  (cond
    (instance? IRecord record) (-unpack (bean record))
    (map? record) (map-values -unpack record)
    (instance? AbstractSeq record) (-unpack (toClojure record))
    (sequential? record) (map -unpack record)
    :else (.toString record))
  )

(defn -makeTuple
  "docstring"
  [entityRec prefix]

  (<!! (client/transact
         conn
         {:tx-data (let
                     [entityM (-unpack entityRec)
                      tuple (:name entityM)
                      properties (:properties entityM)]
                     (map
                       (fn [m]
                         {:db/ident       (keyword (str prefix "." tuple "/" (:name m)))
                          :db/valueType   (keyword (str "db.type/" (:dataType m)))
                          :db/cardinality :db.cardinality/one
                          :db/doc         ""})
                       properties))})

       )
  )
