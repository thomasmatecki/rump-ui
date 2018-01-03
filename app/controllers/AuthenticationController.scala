package controllers

import javax.inject.Inject

import auth.{DefaultEnv, UserService}
import actions.JsonAction
import models.user.credentialsReads
import com.mohiva.play.silhouette.api.{LoginInfo, Silhouette}
import com.mohiva.play.silhouette.api.services.{AuthenticatorResult, AuthenticatorService}
import com.mohiva.play.silhouette.impl.providers.CredentialsProvider
import com.mohiva.play.silhouette.api.util.Credentials
import com.mohiva.play.silhouette.impl.authenticators.JWTAuthenticator
import play.api.libs.json.{JsPath, JsonValidationError}

import scala.concurrent.ExecutionContext.Implicits.global
import play.api.mvc._
import play.api.Logger

import scala.concurrent.Future

class AuthenticationController @Inject()(cc: ControllerComponents,
                                         auth: Silhouette[DefaultEnv],
                                         userService: UserService,
                                         credentialsProvider: CredentialsProvider)
  extends AbstractController(cc) {

  val authService: AuthenticatorService[JWTAuthenticator] = auth.env.authenticatorService

  def authenticate(implicit request: Request[AnyContent]): Future[Result] = {

    request.body.asJson.fold(

      Future.successful(BadRequest("No Body")))(jsVal => {

      jsVal.validate(credentialsReads).fold(
        (errors: Seq[(JsPath, Seq[JsonValidationError])]) => {
          Future.successful(BadRequest(

            errors.map { case (path, validationErrors: Seq[JsonValidationError]) =>
              s"$path: ${
                validationErrors.map(_.message).reduce[String] {
                  case (s0, s1) => s"$s0, $s1"
                }
              }"
            }.reduce[String] { case (s0, s1) => s"$s0\n$s1" }
          ))
        },

        (credentials: Credentials) => {

          credentialsProvider.authenticate(credentials)
            .flatMap(authService.create)
            .flatMap(authService.init)
            .flatMap(authService.embed(_, Ok("")))

        }).recover { case e: Exception =>

        Logger.info(e.getMessage)

        NotFound(e.getMessage)
      }
    })
  }



  def login(): Action[AnyContent] = auth.UnsecuredAction.async {
    implicit request: Request[AnyContent] => authenticate(request)
  }
/*  def signup(): Action[AnyContent] = auth.UnsecuredAction.async {
    implicit request: Request[AnyContent] =>


  }*/

}
