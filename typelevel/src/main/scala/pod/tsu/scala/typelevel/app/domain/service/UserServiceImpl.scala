package pod.tsu.scala.typelevel.app.domain.service
import pod.tsu.scala.typelevel.app.domain.model.User
import pod.tsu.scala.typelevel.app.domain.repository.UserRepository

object UserServiceImpl extends UserService {

  def findUser( id: String )( repository: UserRepository ): Option[User] = {
    repository.find( id )
  }

}
