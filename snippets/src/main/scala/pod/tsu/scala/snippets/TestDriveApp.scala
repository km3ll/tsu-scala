package pod.tsu.scala.snippets

import pod.tsu.scala.snippets.Helper._
import scala.io.Source

object TestDriveApp extends App {

  val path = "/home/kmell/Downloads/soa-baskets-prod.xml"
  val getter = getElement("<situs>", "</situs>")(_, _)
  val emptyTag = ""

  val lines: List[String] = readLines(path)
  val elements: List[String] = lines.flatMap(line => getter(line, List()))
  elements.foreach(println)

}

object Helper {

  def readLines(path: String): List[String] = {
    val source = Source.fromFile(path)
    val lines = source.getLines().toList.map(_.replace("\"", ""))
    source.close()
    lines
  }

  def getElement(openTag: String, closeTag: String)(line: String, elements: List[String]): List[String] = {
    if (!line.contains(openTag)) {
      elements
    } else {
      val subLine = line.splitAt(line.indexOf(openTag))._2
      val element = subLine.substring(0, subLine.indexOf(closeTag) + closeTag.size)
      getElement(openTag, closeTag)(line.replace(element, ""), elements :+ element)
    }
  }

}