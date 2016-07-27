package api

import org.apache.spark.rdd.RDD

/**
  * Created by liujinxin on 16/7/11.
  */
object _02Transformations_0 {
  def main(args: Array[String]) {

    val readMe: RDD[String] = _00Commont.getReadeMeFileRDD
    readMe.persist()

    println("=====>lines: " + readMe.count())

    val filter: RDD[String] = readMe.filter(_.startsWith("›"))
    println("=====>lines('>'): " + filter.count())

    val lineWords: RDD[Array[String]] = readMe.map(_.split(" "))
    println("=====>words: " + lineWords.count())

    val words: RDD[String] = readMe.flatMap(_.split(" "))
    println("=====>words: " + words.count())


  }

}
