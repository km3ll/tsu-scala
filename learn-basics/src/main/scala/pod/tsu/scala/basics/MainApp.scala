package pod.tsu.scala.basics

import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.LazyLogging

object MainApp extends LazyLogging {

  def main( args: Array[String] ): Unit = {

    val config = ConfigFactory.load().getConfig( "pod.tsu.app" )
    val appName = config.getString( "name" )
    logger.info( s"Hello $appName" )

  }

}
