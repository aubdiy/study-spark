package api

import org.apache.spark.rdd.RDD

/**
  * Created by liujinxin on 16/7/11.
  */
object _01WordCount {

  def main(args: Array[String]) {
    val readMe: RDD[String] = _00Commont.getReadeMeFileRDD

    val map: RDD[String] = readMe.flatMap(_.split(" "))
    println("=====>" + map.count())
  }

}


