import java.lang

import api.datastore.datomic
import models.svc.{DataType, Entity, Property}
import org.scalatest.FunSuite

class ClojureApiTest extends FunSuite {

  val properties: Seq[Property] = Seq(
    Property("color", DataType.string),
    Property("season", DataType.long),
    Property("origin", DataType.string)
  )

  val entity = Entity("fruits", properties)

  test("Unpack Entity") {

    val r1 = datomic.unpack(entity)
    println(r1)
    assert(r1 != null)

  }

  test("Unpack Properties") {
    val r1: lang.Iterable[_] = datomic.unpack(properties)
    println(r1)
    assert(r1 != null)
  }
}
