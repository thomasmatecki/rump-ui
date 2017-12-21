import play.api.libs.json._

import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

val place0: JsValue = Json.parse(
  """
  {
    "name":"S",
    "location" : {
      "lat" : 51.235685,
      "long" : -1.309197
    },
    "residents" : [
      {
        "name" : "Fiver",
        "age" : 4,
        "role" : null
      }, {
        "name" : "Bigwig",
        "age":4,
        "role" : "Owsla"
      }
    ]
  }
  """)

case class Location(lat: Double, long: Double)

case class Resident(name: String, age: Int, role: Option[String])

case class Place(name: Option[String], location: Location, residents: Seq[Resident])

implicit val locationReads: Reads[Location] = (
  (JsPath \ "lat").read[Double] and
    (JsPath \ "long").read[Double]
  ) (Location.apply _)

implicit val residentReads: Reads[Resident] = (
  (JsPath \ "name").read[String](minLength[String](2)) and
    (JsPath \ "age").read[Int](min(0) keepAnd max(150)) and
    (JsPath \ "role").readNullable[String]
  ) (Resident.apply _)

implicit val placeReads: Reads[Place] = (
  (JsPath \ "name").readNullable(minLength[String](2)) and
    (JsPath \ "location").read[Location] and
    (JsPath \ "residents").read[Seq[Resident]]
  ) (Place.apply _)


val error: JsResult[Place] = place0.validate(placeReads)



error match {
  case JsError(list) => list

}

//  JsError(
//  List(
//    (/residents(1)/age,
//      List(JsonValidationError(List(error.path.missing),WrappedArray()))))
//  )
