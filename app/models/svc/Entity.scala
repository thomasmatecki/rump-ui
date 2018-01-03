package models.svc

import clojure.lang.IRecord

import scala.beans.BeanProperty

case class Entity(@BeanProperty name: String,
                  @BeanProperty properties: Seq[Property]) extends IRecord {
}
