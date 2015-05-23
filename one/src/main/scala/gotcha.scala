import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


class chocolate(val query: String) {
  def doesContain(s: String): Boolean = { s.contains(query) }

  // implicitly does contain == this.doesContain and thus the obj gets passed in
  def bad1(rdd: RDD[String]): RDD[Boolean] = {rdd.map(doesContain)}

  // same thing here, query == this.query and obj gets passed
  def bad2(rdd: RDD[String]): RDD[Array[String]] = {
    rdd.map(x => x.split(query))
  }

  // sol'n: copy by val first, and use that
  def good(rdd: RDD[String]): RDD[Array[String]] = {
    val q = this.query
    rdd.map(x => x.split(q))
  }
}

object gotcha {
  def main(args: Array[String]): Unit = {
    println("Hello World!")
  }
}
