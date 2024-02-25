package pod.tsu.scala.typelevel.app.context

import com.typesafe.config.{ Config, ConfigFactory }

sealed trait Context {
  val config: Config
}

case class AppContext(
  config: Config
) extends Context

// Companion Object
object Context {

  def loadAppContext(): Context = {
    val config = ConfigFactory.load().getConfig( "pod.tsu.typelevel" )
    AppContext( config )
  }

}