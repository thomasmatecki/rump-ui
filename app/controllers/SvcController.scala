package controllers

import java.util
import javax.inject._

import play.api.libs.json._
import play.api.mvc._

import scala.collection.JavaConverters._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._
import api.datastore.datomic
import play.Logger
import play.api.mvc._
import clojure.lang.PersistentArrayMap
import models.svc.SvcEntity

@Singleton
class SvcController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  val appOrg = "acme"
  val appUser = "thomas"

  def save(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>

    request.body.asJson.fold(BadRequest("Missing Body"))(jsVal => {

      jsVal.validate(svcEntityReads).fold(

        (errors: Seq[(JsPath, Seq[JsonValidationError])]) => {

          BadRequest("Missing Body")

        }, (entity: SvcEntity) => {

          val x: (util.List[_], Any) => Unit = datomic.transxSchema

          val res: Object = datomic.transxSchema(entity.properties.asJava, entity)

          print(res)

          Ok("got it!")
        })
    })
  }
}
