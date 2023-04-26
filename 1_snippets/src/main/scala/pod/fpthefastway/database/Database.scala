package pod.fpthefastway.database

import scala.util.Try

trait Database {

  def insert( record: String ): Try[String]

  def delete( index: Int ): Try[Int]

  def selectAll(): Try[Seq[String]]

}

class DatabaseInFile( fileName: String ) extends Database {

  def insert( record: String ): Try[String] = ???

  def delete( index: Int ): Try[Int] = ???

  def selectAll(): Try[Seq[String]] = ???

}