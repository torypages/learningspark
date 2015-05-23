import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object commonTrans {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("My App")
    val sc = new SparkContext(conf)

    // create RDD from range (1 to 55)
    // could have also List(1,2,3,...55)
    val i: RDD[Int] = sc.parallelize((1 to 55))
    // add .5 to each, notice type change
    val r: RDD[Double] = i.map(x => x + 0.5)
    // print that stuff out
    r.foreach(println)

    // alternatively
    println(r.collect().mkString(", "))
    println(r.take(10).mkString(", "))
  }
}
