package pod.tsu.scala.typelevel.app.domain.service

import pod.tsu.scala.typelevel.app.domain.model.User
import pod.tsu.scala.typelevel.app.domain.repository.UserRepository

trait UserService {

  def findUser( id: String )( repository: UserRepository ): Option[User]

}