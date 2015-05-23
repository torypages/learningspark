import org.apache.spark.{SparkConf, SparkContext}

object cheese {
  def main(args: Array[String]): Unit = {
    println("Hello World!")

    val conf = new SparkConf().setMaster("local").setAppName("My App")
    val sc = new SparkContext(conf)
    val input = sc.textFile("/home/freyja/cool.txt")

    val hiRDD = input.filter(line => line.contains("hi"))
    hiRDD.foreach(println)

    println("--------")

    val byeRDD = input.filter(line => line.contains("bye"))
    byeRDD.foreach(println)

    println("--------")

    val greetings = hiRDD.union(byeRDD)

    greetings.foreach(println)
  }
}
