package pod.tsu.scala.basics.testing

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import pod.tsu.scala.basics.testkit.Generator

object PropertyTest extends Properties( "Generator" ) {

  property( "currencyCode" ) = forAll( Generator.currencyCode ) {
    code => code.nonEmpty
  }

}