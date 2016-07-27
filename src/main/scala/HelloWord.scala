import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by liujinxin on 16/7/4.
  */
object HelloWord {
  def main(args: Array[String]) {
    val conf: SparkConf = new SparkConf().setMaster("local").setAppName("self")
    val sc: SparkContext = new SparkContext(conf)

    val file: RDD[String] = sc.textFile("/Users/liujinxin/tmp/study-spark.txt")
    val filter: RDD[String] = file.filter(line => line.contains("h"))
    val count: Long = filter.count()
    println(count)

    val words: RDD[String] = file.flatMap(line => line.split(" "))
    val result: RDD[(String, Int)] = words.map(word=>(word,1)).reduceByKey{case (x,y)=>x+y}
    result.collect().foreach(one => println(one._1 + ":" + one._2))

  }
}
