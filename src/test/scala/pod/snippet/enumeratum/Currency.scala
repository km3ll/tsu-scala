package pod.snippet.enumeratum

import enumeratum._
import scala.collection.immutable.IndexedSeq

sealed abstract class Currency( val code: String ) extends EnumEntry

object Currency extends Enum[Currency] {

  case object Euro extends Currency( "EUR" )
  case object JapaneseYen extends Currency( "JPY" )
  case object Sterling extends Currency( "GBP" )
  case object US_Dollar extends Currency( "USD" )

  val values: IndexedSeq[Currency] = findValues

  def apply( code: String ): Option[Currency] = {
    values.find( _.code.toLowerCase == code.toLowerCase )
  }

}