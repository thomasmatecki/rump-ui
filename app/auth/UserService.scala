package auth

import javax.inject.Inject

import com.mohiva.play.silhouette.api.LoginInfo
import com.mohiva.play.silhouette.api.repositories.AuthInfoRepository
import com.mohiva.play.silhouette.api.services.IdentityService
import com.mohiva.play.silhouette.api.util.{PasswordHasher, PasswordInfo}
import com.mohiva.play.silhouette.impl.providers.CredentialsProvider
import models.user.{User, UserSignup, userTable}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

class UserService @Inject()(protected val dbConfigProvider: DatabaseConfigProvider,
                            passwordHasher: PasswordHasher,
                            authInfoRepository: AuthInfoRepository)
                           (implicit ec: ExecutionContext)
  extends IdentityService[User]
    with HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  override def retrieve(loginInfo: LoginInfo): Future[Option[User]] = db.run(
    userTable
      .filter(user => user.providerKey === loginInfo.providerKey && user.providerID === loginInfo.providerID)
      .result
      .headOption)

  def create(signup: UserSignup): Future[LoginInfo] = {

    val user = User(
      id = None,
      firstName = Some(signup.firstName),
      lastName = Some(signup.lastName),
      email = Some(signup.email),
      providerID = CredentialsProvider.ID,
      providerKey = signup.credentials.identifier)

    db.run {

      (userTable returning userTable.map(_.id)) += user

    } andThen {

      case Failure(_: Throwable) => None
      case Success(_: Option[Int]) =>
        val loginInfo: LoginInfo = LoginInfo(CredentialsProvider.ID, signup.email)
        val authInfo: PasswordInfo = passwordHasher.hash(signup.credentials.password)
        authInfoRepository.add(loginInfo, authInfo)
    } map { _ => LoginInfo(CredentialsProvider.ID, user.email.get) }

  }
}
