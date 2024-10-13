package pod.tsu.scala.basics.testkit

import org.scalacheck.Gen

object Generator {

  val currencyCode: Gen[String] = Gen.oneOf( "CAD", "COP", "EUR", "GBP", "USD" )

}
