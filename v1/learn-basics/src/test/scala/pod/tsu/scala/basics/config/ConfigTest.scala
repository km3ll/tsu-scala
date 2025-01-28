package pod.tsu.scala.basics.config

import com.typesafe.config.ConfigFactory
import org.scalatest.funsuite.AnyFunSuite

class ConfigTest extends AnyFunSuite {

  test( "ConfigFactory loads application.conf file" ) {
    val config = ConfigFactory.load().getConfig( "pod.tsu.app" )
    val appName = config.getString( "name" )
    assert( appName == "test" )
  }

}