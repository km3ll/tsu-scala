package pod.tsu.scala.spark

import com.typesafe.scalalogging.LazyLogging
import org.apache.spark.rdd.RDD
import org.apache.spark.{ SparkConf, SparkContext }

object RddsApp extends App with LazyLogging {

  val conf = new SparkConf()
    .setAppName( "RddsApp" )
    .setMaster( "local[*]" )
  val sc: SparkContext = new SparkContext( conf )

  val rdd: RDD[Int] = sc.parallelize( Array( 1, 2, 3, 4, 5 ) )
  val dataset = rdd.collect().mkString( " - " )
  logger.info( s"Dataset: $dataset" )

  sc.stop()

}