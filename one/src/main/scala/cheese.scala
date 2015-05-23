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

    println("Better RDD")

    val betterRDD = input.filter(
      line => List("Hi", "bye").exists(line.contains)
    )

    val betterRDDVerbose = input.filter(
      (line: String) => {
        // runs each itme in the lists until the function within exists returns
        // true.
        // the function inside exists checks to see if the line contains n.
        // n which would be each list item one at a time until true is returned
        List("Hi", "bye").exists((n) => line.contains(n))
      }
    )

    betterRDD.foreach(println)
    print("=====")
    betterRDDVerbose.foreach(println)
  }
}
