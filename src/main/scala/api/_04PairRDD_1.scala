package api

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

/**
  * Created by liujinxin on 16/7/11.
  */
object _04PairRDD_1 {
  def main(args: Array[String]) {
    val context: SparkContext = _00Commont.getSparkContext
    val pair1: RDD[(Int, Int)] = context.parallelize(List((1, 2), (3, 4), (3, 6)))
    pair1.persist()
    val pair2: RDD[(Int, Int)] = context.parallelize(List((3, 9)))
    pair2.persist()

    println("==========================")
    pair1.subtractByKey(pair2).foreach((x) => println(x._1 + ":" + x._2))
    println("==========================")
    pair1.join(pair2).foreach((x) => println(x._1 + ":" + x._2))
    println("==========================")
    pair1.leftOuterJoin(pair2).foreach((x) => println(x._1 + ":" + x._2))
    println("==========================")
    pair1.rightOuterJoin(pair2).foreach((x) => println(x._1 + ":" + x._2))
    println("==========================")
    pair1.cogroup(pair2).foreach((x) => println(x._1 + ":" + x._2))

  }

}
