package spark.example

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark._
import org.apache.spark.graphx._
// To make some of the examples work we will also need RDD
import org.apache.spark.rdd.RDD

import scala.util.MurmurHash


object SimpleScalaSpark {

  def main(args: Array[String]) {
//    val logFile = "Slashdot0902.txt" // Should be some file on your system
val logFile = "test.txt"
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val file = sc.textFile(logFile, 2).cache()


//}


//
    val edgesRDD: RDD[(VertexId, VertexId)] = file.map(line => line.split("\t"))
      .map(line =>(line(0).toLong,line(1).toLong))
    val graph = Graph.fromEdgeTuples(edgesRDD, 1)
    graph.edges.foreach(x=>{

      println("ID "+x.srcId+"\tto "+x.dstId)
    })
//    graph.vertices.foreach(x=>{
//      println(x._2)
//    })



  }

}