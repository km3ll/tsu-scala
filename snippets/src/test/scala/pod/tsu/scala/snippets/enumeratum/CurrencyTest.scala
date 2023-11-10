package pod.tsu.scala.snippets.enumeratum

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CurrencyTest extends AnyFlatSpec with Matchers {

  "Enum" should "map a valid code" in {
    val result: Option[Currency] = Currency( "eur" )
    result.contains( Currency.Euro ) shouldBe true
  }

  it should "reject an invalid code" in {
    val result: Option[Currency] = Currency( "ABC" )
    result.isEmpty shouldBe true
  }

}