

import api.datastore.datomic
import models.svc.{DataType, Entity, Property, entityReads}
import org.scalatest.FunSuite
import play.api.libs.json.{JsResult, JsValue, Json}

class SchemaTransactionTest extends FunSuite {

  val jsonStr: String =
    """{"name":"movies",
        "properties":[
          {"name":"genre","dataType":"string"},
          {"name":"year", "dataType":"integer"}
    ]}"""

  lazy val properties: Seq[Property] = Seq(
    Property("genre", DataType.string),
    Property("year", DataType.long)
  )

  val entity = Entity("movies", properties)


  test("Parse Json") {

    val jsVal: JsValue = Json.parse(jsonStr)
    val jsRes: JsResult[Entity] = jsVal.validate(entityReads)
    val actualEntity = jsRes.get
    assert(actualEntity == entity)

  }

  test("Unpack Json Object") {

    val entity = Json.parse(jsonStr).validate(entityReads).get
    val r1 = datomic.unpack(entity)
    println(r1)
    assert(r1 != null)

  }

}
