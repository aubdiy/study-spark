package api

import org.apache.spark.rdd.RDD

/**
  * Created by liujinxin on 16/7/11.
  */
object _03Actions_0 {
  def main(args: Array[String]) {
    val readMe: RDD[String] = _00Commont.getReadeMeFileRDD
    readMe.persist()

    println("=====>" + readMe.count() + ":")
    readMe.top(10).foreach(println(_))
    readMe.take(10).foreach(println(_))

    val map: RDD[Int] = readMe.map(_.length)
    val reduce: Int = map.reduce((a, b) => a + b)
    println("=====> tatal length:" + reduce)

    val key: RDD[(String, Int)] = readMe.flatMap(_.split(" ")).map((_, 1)).reduceByKey((x, y) => x + y)
    key.foreach(word => println(word._1, word._2))


  }

}
