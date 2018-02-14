package models

import com.mohiva.play.silhouette.api.Identity
import com.mohiva.play.silhouette.api.util.Credentials
import play.api.libs.json.{Json, Reads}
import slick.jdbc.MySQLProfile.api._
import slick.lifted.ProvenShape
import slick.lifted.ProvenShape.proveShapeOf


package object user {

  case class UserSignup(firstName: String,
                        lastName: String,
                        email: String,
                        credentials: Credentials) {
  }

  implicit val credentialsReads: Reads[Credentials] = Json.reads[Credentials]
  implicit val userSignupReads: Reads[UserSignup] = Json.reads[UserSignup]

  case class User(id: Option[Int],
                  firstName: Option[String],
                  lastName: Option[String],
                  email: Option[String],
                  providerID: String,
                  providerKey: String) extends Identity {
  }

  class Users(tag: Tag) extends Table[User](tag, "USER") {

    def id = column[Option[Int]]("USER_ID", O.PrimaryKey, O.AutoInc)

    def firstName = column[Option[String]]("FIRST_NAME")

    def lastName = column[Option[String]]("LAST_NAME")

    def email = column[Option[String]]("EMAIL")

    def providerID = column[String]("PROVIDER_ID")

    def providerKey = column[String]("PROVIDER_KEY")

    def * : ProvenShape[User] = (id, firstName, lastName, email, providerID, providerKey) <> (User.tupled, User.unapply)
  }

  case class Password(key: String,
                      hasher: String,
                      hash: String,
                      salt: Option[String])

  class Passwords(tag: Tag) extends Table[Password](tag, "PASSWORD") {
    def key = column[String]("PROVIDER_KEY", O.PrimaryKey)

    def hasher = column[String]("HASHER")

    def hash = column[String]("HASH")

    def salt = column[Option[String]]("SALT")

    def * = (key, hasher, hash, salt) <> (Password.tupled, Password.unapply)
  }

  val userTable = TableQuery[Users]
  val passwordTable = TableQuery[Passwords]
}
