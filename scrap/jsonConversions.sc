import models.svc.{Property, propertyReads}
import play.api.libs.json.{JsResult, _}

val propJson = Json.parse("""{"name":"genre", "dataType":"integer"}""")

val jsProp: JsResult[Property] = propJson.validate(propertyReads)

val prop: Property = jsProp.get

val dataType = prop.dataType
