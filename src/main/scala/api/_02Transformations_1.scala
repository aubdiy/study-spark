package api

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

/**
  * Created by liujinxin on 16/7/11.
  */
object _02Transformations_1 {
  def main(args: Array[String]) {
    val context: SparkContext = _00Commont.getSparkContext
    val list: RDD[Int] = context.parallelize(List(1, 2, 3, 3))
    list.persist()

    println(list.distinct().collect().mkString(","))

    println(list.sample(false, 0.5).collect().mkString(","))

  }
}
