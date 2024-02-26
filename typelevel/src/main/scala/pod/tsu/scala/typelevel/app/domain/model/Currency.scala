package pod.tsu.scala.typelevel.app.domain.model

sealed trait Currency

object CAD extends Currency
object COP extends Currency
object EUR extends Currency
object USD extends Currency