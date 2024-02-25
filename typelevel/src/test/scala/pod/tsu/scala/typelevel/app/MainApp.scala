package pod.tsu.scala.typelevel.app

import pod.tsu.scala.typelevel.app.context.Context

object MainApp extends App {

  val context = Context.loadAppContext()
  println( s"Typelevel App started using context: $context" )

}
