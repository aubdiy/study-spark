package api

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by liujinxin on 16/7/11.
  */
object _00Commont {

  def getSparkContext: SparkContext = {
    new SparkContext(new SparkConf().setMaster("local").setAppName("self"))
  }

  def getReadeMeFileRDD: RDD[String] = {
    getSparkContext.textFile("/usr/local/Cellar/spark/1.0.1/README.md")

  }

}
