package pod.tsu.scala.basics.testing.property

import org.scalacheck.Prop.forAll
import org.scalacheck.Properties
import pod.tsu.scala.basics.testing.generator.Generator

object PropertyTest extends Properties( "Generator" ) {

  property( "currencyCode" ) = forAll( Generator.currencyCode ) {
    code => code.nonEmpty
  }

}