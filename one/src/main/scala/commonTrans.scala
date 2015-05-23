import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object commonTrans {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("My App")
    val sc = new SparkContext(conf)

    // create RDD from range (1 to 55)
    // could have also List(1,2,3,...55)
    val i = sc.parallelize(List(List(1,2,3), List(4,5,6)))
    val nums = i.flatMap(x => x)
    nums.foreach(x => {
      println("--")
      println(x)
    })
    println("======")
    println(nums.first())
  }
}
