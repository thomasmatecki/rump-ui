package auth

import javax.inject.Inject

import com.mohiva.play.silhouette.api.{Environment, Silhouette}
import com.mohiva.play.silhouette.api.actions.{SecuredAction, UnsecuredAction, UserAwareAction}

trait SilhouetteActions extends Silhouette[DefaultEnv] {
  @inline override val env: Environment[DefaultEnv] = env
  @inline override val securedAction: SecuredAction = securedAction
  @inline override val unsecuredAction: UnsecuredAction = unsecuredAction
  @inline override val userAwareAction: UserAwareAction = userAwareAction
}
