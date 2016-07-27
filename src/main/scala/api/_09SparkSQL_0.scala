package api

import org.apache.spark.SparkContext
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.hive.HiveContext

/**
  * Created by liujinxin on 16/7/12.
  */
object _09SparkSQL_0 {

  def main(args: Array[String]) {
    val context: SparkContext = _00Commont.getSparkContext
    //    val sqlCtx: SQLContext = new SQLContext(context)
    val sqlCtx: HiveContext = new HiveContext(context)

    val input: DataFrame = sqlCtx.jsonFile("/Users/liujinxin/Baiduyun/Workspace/IdeaWS/study-spark/src/main/resources/testweet.json")

    input.registerTempTable("tweets")
    val result: DataFrame = sqlCtx.sql("select text from tweets")
    result.foreach(x => println(x.getString(0)))
  }

}
