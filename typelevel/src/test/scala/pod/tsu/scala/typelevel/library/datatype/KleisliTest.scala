package pod.tsu.scala.typelevel.library.datatype

import cats.data.Kleisli
import cats.syntax.all._
import org.scalatest.flatspec.AnyFlatSpec

/**
 * Reference: https://typelevel.org/cats/datatypes/kleisli.html
 * Kleisli enables composition of functions that return a monadic value,
 * for instance an Option[Int] or a Either[String, List[Double]],
 * without having functions take an Option or Either as a parameter,
 */

class KleisliTest extends AnyFlatSpec {

  private case class User( name: String )

  private def fetchUser( id: String ): Option[User] = {
    User( "John Wick" ).some
  }

  "Kleisli" should "allow setup & run" in {

    // Given
    val fetchUserK: Kleisli[Option, String, User] = Kleisli {
      ( id: String ) => fetchUser( id )
    }
    // When
    val result: Option[User] = fetchUserK.run( "1100" )
    // Then
    assert( result.isDefined )

  }

  it should "allow composition & run" in {

    // Given
    val parse: String => Option[Int] = {
      ( s: String ) =>
        {
          if ( s.matches( "-?[0-9]+" ) ) Some( s.toInt )
          else None
        }
    }
    val reciprocal: Int => Option[Double] = {
      ( i: Int ) =>
        {
          if ( i != 0 ) Some( 1.0 / i )
          else None
        }
    }

    val parseK: Kleisli[Option, String, Int] = Kleisli {
      ( s: String ) => parse( s )
    }

    val reciprocalK: Kleisli[Option, Int, Double] = Kleisli {
      ( i: Int ) => reciprocal( i )
    }

    val parseAndReciprocalK: Kleisli[Option, String, Double] = Kleisli {
      ( s: String ) =>
        {
          for {
            parsed <- parseK.run( s )
            reciprocated <- reciprocalK.run( parsed )
          } yield reciprocated
        }
    }

    // When
    val result: Option[Double] = parseAndReciprocalK.run( "8" )

    // Then
    assert( result.contains( 0.125D ) )

  }

}
