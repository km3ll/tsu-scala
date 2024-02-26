package pod.tsu.scala.typelevel.app.domain.repository

import pod.tsu.scala.typelevel.app.domain.model.User

trait UserRepository {

  def find(id: String): Option[User]

}