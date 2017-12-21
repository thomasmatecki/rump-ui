import models.svc.{SvcEntity, SvcProperty}
import play.api.libs.json.{JsPath, Json, Reads}
import play.api.libs.functional.syntax._

import scala.beans.BeanProperty


package object controllers {

  implicit val svcPropertyReads: Reads[SvcProperty] = Json.reads[SvcProperty]
  implicit val svcEntityReads: Reads[SvcEntity] = Json.reads[SvcEntity]
}

