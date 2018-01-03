package models

import play.api.libs.json._


package object svc {
  implicit val propertyReads: Reads[Property] = Json.reads[Property]
  implicit val entityReads: Reads[Entity] = Json.reads[Entity]
}
