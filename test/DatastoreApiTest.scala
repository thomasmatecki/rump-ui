import java.util

import org.scalatest.FunSuite
import api.datastore.datomic
import clojure.lang.{IPersistentMap, IRecord, ISeq, RT}

import scala.collection.JavaConverters._
import scala.beans.BeanProperty

sealed case class Property(@BeanProperty name: String,
                           @BeanProperty dataType: String) extends IRecord

sealed case class Entity(@BeanProperty name: String,
                         @BeanProperty properties: Seq[Property]) extends IRecord

class ClojureApiTest extends FunSuite {

  //implicit def asClojureISeq[T](xs: Seq[T]): ISeq = RT.seq(xs.asJava)

  def invokeClojureFunc[T, R](fn: T => R, args: T): R = {
    fn.apply(args)
  }

  test("Call unpack") {

    val properties = Seq(
      Property("color", "string"),
      Property("season", "string"),
      Property("origin", "string")
    )

    val entity = Entity("fruits", properties)
    val r1: IPersistentMap = datomic.unpack(entity)

    print(r1)

    assert(r1 != null)
  }
}
