package pod.tsu.scala.basics.logging

import com.typesafe.scalalogging.LazyLogging

object LoggerApp extends LazyLogging {
  def main( args: Array[String] ): Unit = {
    logger.info( "Hello Pod" )
  }
}