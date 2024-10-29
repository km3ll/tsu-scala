package pod.tsu.scala.basics.circe

import io.circe.{Json, ParsingFailure}
import io.circe.generic.auto._
import io.circe.syntax._
import io.circe.parser._
import org.scalatest.funsuite.AnyFunSuite

import scala.util.Try

// Automatic derivation
class AutomaticDerivationTest extends AnyFunSuite {

  case class Currency( code: String, name: String )

  test( "Case class is converted to JSON" ) {

    val currency = Currency( "USD", "US Dollar" )

    val res1: Json = currency.asJson
    val res2: String = currency.asJson.noSpaces
    val res3: String = currency.asJson.noSpacesSortKeys

    println( res1)
    println( res2 )
    println( res3 )

  }

  test( "JSON is converted to case class" ) {

    val json = """
      |{
      |  "code" : "USD",
      |  "name" : "US Dollar"
      |}
      |""".stripMargin

    val res1: Either[ParsingFailure, Json] = parse(json)
    val res2: Try[Json] = parse(json).toTry
    val res3: Option[Json] = parse(json).toOption

    println( res1 )
    println( res2 )
    println( res3 )

  }

}
