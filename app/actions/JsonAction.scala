package actions

import javax.inject.Inject

import play.api.libs.json.{JsPath, JsValue, JsonValidationError, Reads}
import play.api.mvc._
import play.api.mvc.Results

import scala.concurrent.{ExecutionContext, Future}

case class JsonAction[A] @Inject()(op: (A => Result), parser: BodyParser[AnyContent])
                                  (implicit val executionContext: ExecutionContext,
                                   implicit val reads: Reads[A]) extends Action[AnyContent] {

  protected def errorHandler(errors: Seq[(JsPath, Seq[JsonValidationError])]): Result = {
    Results.BadRequest(errors.toString())
  }

  override def apply(request: Request[AnyContent]): Future[Result] = Future.successful(
    request.body.asJson.fold(Results.BadRequest("Missing Body"))(jsVal => {
      jsVal.validate(reads).fold[Result](errorHandler, op)
    }))
}
