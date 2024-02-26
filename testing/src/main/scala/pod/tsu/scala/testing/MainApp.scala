package pod.tsu.scala.testing

import com.typesafe.scalalogging.LazyLogging

case class Result(
  productType: String,
  pmin:        String,
  batchSize:   Int
)

object MainApp extends App with LazyLogging {

  //val appName = ConfigFactory.load().getString( "app" )
  //logger.info( s"$appName running" )

  val path = "/home/kmell/Downloads/can-beverage-extract-2024-01-04T21_14_15.193Z.csv"
  val bufferedSource = io.Source.fromFile( path )
  val lines = bufferedSource.getLines.filterNot( _.contains( "@" ) ).toList
  bufferedSource.close

  def getPmin( field: String ): String = {
    field.split( ":" )( 1 ).trim
  }

  val results = lines
    .map { line =>
      val cols = line.split( "," ).map( _.trim )

      val newRecipe = cols( 4 ).toInt
      val oldRecipe = cols( 5 ).toInt
      val altPmins = cols( 6 ).toInt
      val batchSize = 1 + newRecipe + oldRecipe + altPmins
      Result( cols( 3 ), getPmin( cols( 8 ) ), batchSize )
    }
  println( s"Line count: ${lines.size}" )

  val grouped = results.groupBy( _.batchSize )
  grouped.map { ( keyValue ) =>
    val ( size, records ) = keyValue
    println( s"Size: $size, count: ${records.size}" )
  }

}