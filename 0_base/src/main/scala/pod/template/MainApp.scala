package pod.template

import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.LazyLogging

object MainApp extends App with LazyLogging {

  val config = ConfigFactory.load()
  val app = config.getString( "app" )
  logger.info( s"$app running" )

}