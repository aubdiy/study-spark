package api

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

/**
  * Created by liujinxin on 16/7/11.
  */
object _03Actions_1 {
  def main(args: Array[String]) {
    val context: SparkContext = _00Commont.getSparkContext
    val list: RDD[Int] = context.parallelize(List(1, 2, 3))

    val result = list.aggregate((0, 0))(
      (x, y) => (x._1 + y, x._2 + 1),
      (x, y) => (x._1 + y._1, x._2 + y._2)
    )

    println("=====>" + result._1 / result._2)

  }

}
