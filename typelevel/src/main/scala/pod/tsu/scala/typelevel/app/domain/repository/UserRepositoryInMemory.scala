package pod.tsu.scala.typelevel.app.domain.repository
import pod.tsu.scala.typelevel.app.domain.model.User

class UserRepositoryInMemory extends UserRepository {

  private val users: Set[User] = Set.empty;

  def find(id: String): Option[User] = {
    users.find(_.id == id)
  }

}
