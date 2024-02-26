package pod.tsu.scala.typelevel.library.monix

import monix.eval.Task
import org.scalatest.flatspec.AnyFlatSpec

// Reference: https://monix.io/docs/current/eval/task.html
class TaskTest extends AnyFlatSpec {

  "Task.now" should "run" in {
    Task.now {
      println( "Side effect" )
      "Hello"
    }
  }

}
