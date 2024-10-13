package pod.tsu.scala.basics.logging

import java.util.UUID

case class Context(
  transactionId: String
)

object Context {

  def apply(): Context = {
    new Context( UUID.randomUUID().toString )
  }

  def apply( transactionId: String ): Context = {
    new Context( transactionId )
  }

}