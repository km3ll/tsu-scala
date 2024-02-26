package pod.tsu.scala.typelevel.app.infrastructure.dto

import cats.syntax.either._

sealed trait Dto {
  val id: String
}

case class RequestDto( id: String ) extends Dto
case class ResponseDto( id: String ) extends Dto

object Dto {

  def requestDto( id: String ): Either[String, RequestDto] = {
    if ( id.isEmpty ) "Request ID is required".asLeft
    else RequestDto( id ).asRight
  }

  def responsetDto( id: String ): Either[String, ResponseDto] = {
    if ( id.isEmpty ) "Request ID is required".asLeft
    else ResponseDto( id ).asRight
  }

}