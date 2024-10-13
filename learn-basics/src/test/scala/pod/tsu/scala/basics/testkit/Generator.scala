package pod.tsu.scala.basics.testkit

import org.scalacheck.Gen

object Generator {

  val currencyCode: Gen[String] = Gen.oneOf( "CAD", "COP", "EUR", "GBP", "USD" )

  val email: Gen[String] = for {
    name <- Gen.listOfN( 5, Gen.alphaLowerChar ).map( _.mkString )
    domain <- Gen.oneOf( "@aol.com", "@gmail.com", "@hotmail.com", "@msn.com", "@outlook.com", "@protonmail.com", "@yahoo.com" )
  } yield name + domain

}
