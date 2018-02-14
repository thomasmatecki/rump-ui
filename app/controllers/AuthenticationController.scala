package controllers

import javax.inject.Inject

import actions.JsonBuilder
import auth.{DefaultEnv, UserService}
import com.mohiva.play.silhouette.api.actions.{SecuredRequest, UserAwareActionBuilder}
import com.mohiva.play.silhouette.api.{LoginInfo, Silhouette}
import com.mohiva.play.silhouette.api.services.AuthenticatorResult
import com.mohiva.play.silhouette.api.util.Credentials
import com.mohiva.play.silhouette.impl.providers.CredentialsProvider
import models.user.{UserSignup, credentialsReads}
import play.api.Logger
import play.api.libs.json._
import play.api.mvc._

import scala.concurrent.Future

class AuthenticationController @Inject()(cc: ControllerComponents,
                                         val auth: Silhouette[DefaultEnv],
                                         userService: UserService,
                                         credentialsProvider: CredentialsProvider)
  extends AbstractController(cc)
    with JsonBuilder {

  private val authService = auth.env.authenticatorService

  private def signin(result: Result)(implicit request: Request[JsValue]): PartialFunction[LoginInfo, Future[Result]] = {

    case loginInfo: LoginInfo =>

      Logger.info(s"Signing In User ${loginInfo.providerID}:${loginInfo.providerKey}")

      authService.create(loginInfo)
        .flatMap(authService.init)
        .flatMap(authService.embed(_, result))
  }

  def signup(): Action[JsValue] = JsonAction[UserSignup] {

    implicit request =>

      signup: UserSignup =>

        lazy val loginInfo = LoginInfo(CredentialsProvider.ID, signup.email)
        userService.retrieve(loginInfo)
          .flatMap(_.fold {

            Logger.info(s"Signing Up User ${signup.email}")
            userService.create(signup).flatMap(signin(Ok))

          } {
            _ => Future.successful(Redirect(routes.HomeController.index()))
          })
  }

  def login(): Action[JsValue] = JsonAction[Credentials] {

    implicit request: Request[JsValue] =>

      (credentials: Credentials) =>
        credentialsProvider.authenticate(credentials)
          .flatMap(signin(Ok))
          .recover { case e: Exception =>
            Logger.info(e.getMessage)
            AuthenticatorResult(NotFound)
          }
  }

  def foo: Action[JsValue] = JsonSecInvoke[Credentials] {

    implicit request: Request[JsValue] =>

      (credentials: Credentials) =>
        credentialsProvider.authenticate(credentials)
          .flatMap(signin(Ok))
          .recover { case e: Exception =>
            Logger.info(e.getMessage)
            AuthenticatorResult(NotFound)
          }
  }

  def logout(): Action[AnyContent] = auth.SecuredAction.async {
    implicit request: SecuredRequest[DefaultEnv, AnyContent] =>
      authService.discard(request.authenticator, Redirect("/login"))
  }

}
