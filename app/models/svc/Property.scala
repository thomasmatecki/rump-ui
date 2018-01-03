package models.svc

import clojure.lang.IRecord
import play.api.libs.json._

import scala.beans.BeanProperty


trait JsonEnum extends Enumeration {
  type Type = Value
  var jsonNames: Map[String, Value] = Map().withDefault(withName)

  protected final def Value(name: String, jsName: String, jsNames: String*): Value = {
    val value = super.Value(name)

    jsonNames ++= (jsNames :+ jsName) map (_ -> value)
    value
  }

  implicit val reads: Reads[Type] = {
    case JsString(s) => JsSuccess(jsonNames(s))
    case _ => JsError("JSON String Value Expected")
  }
}


object DataType extends JsonEnum {
  val string: DataType.Value = Value("string")
  val float: DataType.Value = Value("float")
  val long: DataType.Value = Value("long", "integer")
}

/**
  * @param name
  * @param dataType
  */

case class Property(@BeanProperty name: String,
                    @BeanProperty dataType: DataType.Type) extends IRecord
