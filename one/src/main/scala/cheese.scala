import org.apache.spark.{SparkConf, SparkContext}

object cheese {
  def main(args: Array[String]): Unit = {
    println("Hello World!")

    val conf = new SparkConf().setMaster("local").setAppName("My App")
    val sc = new SparkContext(conf)
    val input = sc.textFile("/home/freyja/cool.txt")

    val hibyeRDD = input.filter(
      (line: String) => {
        List("Hi", "bye").exists((n) => line.contains(n))
      }
    )

    println("------")
    hibyeRDD.foreach(println)
    println("------")
    hibyeRDD.take(2).foreach(println)
  }
}
