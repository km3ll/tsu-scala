package pod.tsu.scala.typelevel.app.application

import com.typesafe.config.{Config, ConfigFactory}
import pod.tsu.scala.typelevel.app.domain.repository.{UserRepository, UserRepositoryInMemory}

sealed trait Context {
  val config: Config
  val userRepository: UserRepository
}

case class AppContext(
  config: Config,
  userRepository: UserRepository
) extends Context

// Companion Object
object Context {

  def loadAppContext(): Context = {
    val config = ConfigFactory.load().getConfig( "pod.tsu.typelevel" )
    val userRepository = new UserRepositoryInMemory()
    AppContext( config, userRepository )
  }

}