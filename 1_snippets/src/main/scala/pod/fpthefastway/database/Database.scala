package pod.fpthefastway.database

import java.io.{BufferedWriter, File, FileWriter}
import scala.io.{BufferedSource, Source}
import scala.util.{Failure, Success, Try}

trait Database {

  def insert( record: String ): Try[Unit]

  def delete( index: Int ): Try[Int]

  def selectAll(): Try[Seq[String]]

}

class DatabaseInFile( fileName: String ) extends Database {

  private def writeToFile( lines: Seq[String], append: Boolean ): Try[Unit] = {
    var writer: BufferedWriter = null
    try {
      writer = new BufferedWriter(new FileWriter(new File(fileName), append))
      for (line <- lines) {
        writer.write(s"$line\n")
      }
      Success(true)
    } catch {
      case ex: Exception => Failure(ex)
    } finally {
      if (writer != null) {
        writer.close()
      }
    }
  }

  private def deleteFromFile(index: Int): Try[Int] = {
    for {
      rows <- selectAll()
      newRows = {
        val (first, second) = rows.splitAt(index)
        first ++ second.tail
      }
      deletedCount = rows.size - newRows.size
      _ <- writeToFile(newRows, false)
    } yield deletedCount
  }

  private def readFromFile(): Try[Seq[String]] = {
    var source: BufferedSource = null
    try {
      source = Source.fromFile(fileName)
      val lines: Iterator[String] = for (line <- source.getLines()) yield line
      Success(lines.toSeq)
    } catch {
      case ex: Exception => Failure(ex)
    } finally {
      if (source != null) {
        source.close()
      }
    }
  }

  def insert( record: String ): Try[Unit] = {
    writeToFile(Seq(record), true)
  }

  def delete( index: Int ): Try[Int] = {
    deleteFromFile( index )
  }

  def selectAll(): Try[Seq[String]] = {
    readFromFile()
  }

}