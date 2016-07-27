package api

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

/**
  * Created by liujinxin on 16/7/11.
  */
object _02Transformations_2 {
  def main(args: Array[String]) {
    val context: SparkContext = _00Commont.getSparkContext
    val list1: RDD[Int] = context.parallelize(List(1, 2, 3))
    list1.persist()
    val list2: RDD[Int] = context.parallelize(List(3, 4, 5))
    list2.persist()



    println("===>union:" + list1.union(list2).collect().mkString(","))
    println("===>intersection:" + list1.intersection(list2).collect().mkString(","))
    println("===>subtract:" + list1.subtract(list2).collect().mkString(","))
    println("===>cartesian:" + list1.cartesian(list2).collect().mkString(","))

  }
}
