import org.apache.spark.{SparkConf, SparkContext}

object reduce {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("My App")
    val sc = new SparkContext(conf)

    val i = sc.parallelize(List(1,2,3,4,5,6,7))

    // looks like on the first iteration it took the first two items in the
    // list, that is, 1 and 2, thus, x=1 and y=2 on the first iteration.
    // from then on x is the previous result and y is the next value
    val sum = i.reduce((x,y) => {
      println("x", x)
      println("y", y)
      println("====")
      x + y
    })
    println(sum)
  }
}
