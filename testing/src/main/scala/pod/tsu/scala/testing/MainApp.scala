package pod.tsu.scala.testing

import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.LazyLogging

object MainApp extends App with LazyLogging {

  val appName = ConfigFactory.load().getString( "app" )
  logger.info( s"$appName running" )

}