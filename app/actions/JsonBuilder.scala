package actions

import auth.DefaultEnv
import com.mohiva.play.silhouette.api.Silhouette
import com.mohiva.play.silhouette.api.actions._
import play.api.Logger
import play.api.libs.json.{JsPath, JsValue, JsonValidationError, Reads}
import play.api.mvc.{Results, request, _}

import scala.concurrent.{ExecutionContext, Future}

trait JsonBuilder extends Results {

  def parse: PlayBodyParsers

  def defaultExecutionContext: ExecutionContext

  def Action: ActionBuilder[Request, AnyContent]

  val auth: Silhouette[DefaultEnv]


  implicit val executionContext: ExecutionContext = defaultExecutionContext
  implicit val parser: BodyParser[JsValue] = parse.json

  object JsonErrorBuilder {

    def apply(errors: Seq[(JsPath, Seq[JsonValidationError])]) =
      BadRequest {
        errors.map { case (path, validationErrors: Seq[JsonValidationError]) =>
          s"$path: ${
            validationErrors.map(_.message).reduce[String] {
              case (s0, s1) => s"$s0, $s1"
            }
          }"
        }.reduce[String] { case (s0, s1) => s"$s0\n$s1" }
      }

    val async: Seq[(JsPath, Seq[JsonValidationError])] => Future[Result] = errors => Future.successful {
      this.apply(errors)
    }
  }

  protected def JsonError: JsonErrorBuilder.type = JsonErrorBuilder

  def invoke[R <: Request[JsValue], D](request: R, reads: Reads[D], operation: D => Future[Result]) = {
    request.body.validate(reads).fold(JsonError.async, operation)
      .recover {
        case e: Exception =>
          Logger.info(e.getMessage)
          InternalServerError(e.getMessage)
      }
  }


  def JsonAction[D](block: Request[JsValue] => (D => Future[Result]))(implicit reads: Reads[D]): Action[JsValue] = {

    auth.UnsecuredAction.async(parser) {
      implicit request =>
        request.body.validate(reads).fold(JsonError.async, block(request))
          .recover {
            case e: Exception =>
              Logger.info(e.getMessage)
              InternalServerError(e.getMessage)
          }
    }
  }

  def JsonInvoke[D](block: Request[JsValue] => (D => Future[Result]))(implicit reads: Reads[D]): Action[JsValue] = {
    auth.UnsecuredAction.async(parser) {
      implicit request => invoke(request, reads, block(request))
    }
  }

  def JsonSecInvoke[D](block: SecuredRequest[DefaultEnv, JsValue] => (D => Future[Result]))(implicit reads: Reads[D]): Action[JsValue] = {
    auth.SecuredAction.async(parser) {
      implicit request => invoke(request, reads, block(request))
    }
  }
}


