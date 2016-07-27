package api

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

/**
  * Created by liujinxin on 16/7/11.
  */
object _04PairRDD_2 {
  def main(args: Array[String]) {
    val context: SparkContext = _00Commont.getSparkContext
    val pair: RDD[(Int, Int)] = context.parallelize(List((1, 2), (3, 4), (3, 6)))
    pair.persist()

    println("==========================")
    pair.countByKey().foreach((x) => println(x._1 + ":" + x._2))
    println("==========================")
    pair.collectAsMap().foreach((x) => println(x._1 + ":" + x._2))
    println("==========================")
    pair.lookup(3).foreach(println(_))


  }

}
