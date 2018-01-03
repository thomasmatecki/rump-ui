import models.svc.{DataType, Property, propertyReads}
import org.scalatest.FunSuite
import play.api.libs.json.{JsResult, Json}

class JsonTests extends FunSuite {

  test("Json `integer` DataType") {

    val propJson = Json.parse(
      """{"name":"genre",
          "dataType":"integer"}"""
    )

    val jsProp: JsResult[Property] = propJson.validate(propertyReads)
    val prop: Property = jsProp.get
    val dataType = prop.dataType

    assert(dataType == DataType.long)
  }

  test("Json `long` DataType") {

    val propJson = Json.parse(
      """{"name":"genre",
          "dataType":"long"}"""
    )

    val jsProp: JsResult[Property] = propJson.validate(propertyReads)
    val prop: Property = jsProp.get
    val dataType = prop.dataType

    assert(dataType == DataType.long)
  }


}
