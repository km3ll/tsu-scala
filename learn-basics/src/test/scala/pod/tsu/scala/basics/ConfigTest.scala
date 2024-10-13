package pod.tsu.scala.basics

import com.typesafe.config.ConfigFactory
import org.scalatest.funsuite.AnyFunSuite

class ConfigTest extends AnyFunSuite {

  test( "File application.conf is loaded" ) {
    val config = ConfigFactory.load().getConfig( "pod.tsu.app" )
    val appName = config.getString( "name" )
    assert( appName == "test" )
  }

}