package pod.tsu.baseapp.testing

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import pod.tsu.baseapp.testkit.Generator

object PropertyTest extends Properties( "Generator" ) {

  property( "currencyCode" ) = forAll( Generator.currencyCode ) {
    code => code.nonEmpty
  }

}