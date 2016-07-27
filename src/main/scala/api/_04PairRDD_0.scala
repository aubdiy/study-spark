package api

import org.apache.spark.{HashPartitioner, SparkContext}
import org.apache.spark.rdd.RDD

/**
  * Created by liujinxin on 16/7/11.
  */
object _04PairRDD_0 {
  def main(args: Array[String]) {
    val context: SparkContext = _00Commont.getSparkContext
    val pair: RDD[(Int, Int)] = context.parallelize(List((1, 2), (3, 4), (3, 6))).partitionBy(new HashPartitioner(10))
    pair.persist()

    println("==========================")
    pair.reduceByKey((x, y) => x + y, 5).foreach((x) => println(x._1 + ":" + x._2))

    println("==========================")
    pair.groupByKey().foreach(x => println(x._1 + ":" + x._2))

    println("==========================")
    pair.mapValues(_ + 1).foreach((x) => println(x._1 + ":" + x._2))

    println("==========================")
    pair.flatMapValues(_ to 5).foreach((x) => println(x._1 + ":" + x._2))

    println("==========================")
    pair.filter(_._1 > 1).foreach((x) => println(x._1 + ":" + x._2))
    pair.filter { case (x, y) => x > 1 }.foreach((x) => println(x._1 + ":" + x._2))

    println("==========================")
    pair.keys.foreach(print(_))

    println("==========================")
    pair.values.foreach(print(_))

    println("==========================")
    pair.sortByKey().foreach((x) => println(x._1 + ":" + x._2))

  }

}
