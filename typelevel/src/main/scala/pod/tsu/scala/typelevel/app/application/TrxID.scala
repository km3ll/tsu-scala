package pod.tsu.scala.typelevel.app.application

import java.util.UUID

/**
 * Transaction ID
 * @param correlationId
 */
case class TrxID(
  correlationId: String
)

object TrxID {

  def apply(): TrxID = {
    println("Assigning new correlation ID")
    apply(UUID.randomUUID().toString)
  }

  def apply(correlationId: String): TrxID = {
    new TrxID(correlationId)
  }

}