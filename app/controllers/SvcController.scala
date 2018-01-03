package controllers

import javax.inject._

import api.datastore.datomic
import models.svc.{Entity, entityReads}
import play.api.libs.json._
import play.api.mvc._

@Singleton
class SvcController @Inject()(cc: ControllerComponents)

  extends AbstractController(cc) {

  val appOrg = "acme"
  val appUser = "thomas"
  val appVersion = "1"

  def save(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>

    request.body.asJson.fold(BadRequest("Missing Body"))(jsVal => {

      jsVal.validate(entityReads).fold(
        (errors: Seq[(JsPath, Seq[JsonValidationError])]) => {
          BadRequest(errors.toString())
        }, (entity: Entity) => {

          val dres = datomic.makeTuple(entity, s"${appOrg}.${appUser}")
          Ok(dres.toString)

        })
    })
  }

}
