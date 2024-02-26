package pod.tsu.scala.typelevel.app

import pod.tsu.scala.typelevel.app.application.Context
import pod.tsu.scala.typelevel.app.domain.model.User
import pod.tsu.scala.typelevel.app.domain.repository.UserRepository
import pod.tsu.scala.typelevel.app.domain.service.UserServiceImpl

object MainApp extends App {

  val context = Context.loadAppContext()

  val partialResult: UserRepository => Option[User] = UserServiceImpl.findUser("1100")(_)
  val result: Option[User] = partialResult(context.userRepository)

}
