package pod.tsu.scala.basics.testing.async

import org.scalatest.flatspec.AsyncFlatSpec

import scala.concurrent.{ ExecutionContext, Future }

class AsyncTest extends AsyncFlatSpec {

  implicit override def executionContext: ExecutionContext = {
    scala.concurrent.ExecutionContext.Implicits.global
  }

  def addNumbers( addends: Int* ): Future[Int] = Future { addends.sum }

  behavior of "addNumbers"

  it should "eventually compute a sum of passed Ints" in {
    addNumbers( 1, 2 )
      .map {
        sum => assert( sum == 3 )
      }
  }

}
