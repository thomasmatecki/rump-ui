package models

import java.util

import scala.beans.BeanProperty
import clojure.lang.IRecord
import clojure.lang.ISeq
import clojure.lang.RT

import scala.collection.JavaConverters._


package object svc {



  case class SvcProperty(@BeanProperty name: String,
                         @BeanProperty dataType: String) extends IRecord

  case class SvcEntity(@BeanProperty name: String,
                       @BeanProperty properties: Seq[SvcProperty])

}
