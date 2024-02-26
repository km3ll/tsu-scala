package pod.tsu.scala.typelevel.library.datatype

import cats.data.EitherT
import cats.syntax.all._
import monix.eval.Task
import org.scalatest.flatspec.AnyFlatSpec

/**
 * Reference: https://typelevel.org/cats/datatypes/eithert.html
 * EitherT[F[_], A, B] is a lightweight wrapper for F[Either[A, B]]
 * that makes it easy to compose Eithers and Fs together.
 */

class EitherTTest extends AnyFlatSpec {

  private type Error = String

  private def fetch(): Task[Either[Error, List[String]]] = {
    Task.now {
      List.empty[String].asRight[Error]
    }
  }

  "EitherT" should "allow for-comprehension" in {
    val result: EitherT[Task, Error, List[String]] =
      for {
        listOne <- EitherT( fetch() )
        listTwo <- EitherT( fetch() )
      } yield listOne ++ listTwo
  }

}
