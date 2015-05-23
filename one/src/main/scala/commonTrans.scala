import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object commonTrans {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("My App")
    val sc = new SparkContext(conf)

    // create RDD from range (1 to 55)
    // could have also List(1,2,3,...55)
    val i = sc.parallelize(List("cheese", "rooster", "duck", "rooster"))
    val ii = sc.parallelize(List("bird", "cheese", "rabbit"))

    println("i", i.collect.mkString(", "))
    println("ii", ii.collect.mkString(", "))
    println("distinct i", i.distinct().collect.mkString(", "))
    println("union", i.union(ii).collect.mkString(", "))
    println("intersection", i.intersection(ii).collect.mkString(", "))
    println("i - ii", i.subtract(ii).collect.mkString(", "))
    println("all possible pairs of i and ii", i.cartesian(ii).collect.mkString(", "))
  }
}
