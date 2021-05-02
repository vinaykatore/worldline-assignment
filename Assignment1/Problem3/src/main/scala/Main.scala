

import java.io.{File, PrintWriter}
import scala.collection.mutable.ListBuffer
import scala.io.Source

object Main extends App {

  val source = Source.fromFile(s"${System.getProperty("user.dir")}\\triangle.txt")
  var list = new ListBuffer[String]
  for (line <- source.getLines) {
    list+=line
  }
  source.close()

  var s = list.map(_.split(" ").map(_.toInt)).toArray
  s(1)(1) = s(1)(1)+s(0)(0)
  s(1)(0) = s(1)(0) + s(0)(0)

  var outerLoopCounter = 0
  for(i<-2 until s.length; j <- 1 until i) {
    {
      if(outerLoopCounter != i) {
        s(i)(0) = s(i)(0) + s(i-1)(0)
        s(i)(i) = s(i)(i) + s(i-1)(i-1)
        outerLoopCounter = i
      }
      s(i)(j) = Array(s(i)(j)+s(i-1)(j), s(i)(j)+s(i-1)(j-1)).max
    }
  }
  val sum  = s(s.length-1).max
  println(sum)
  val writer = new PrintWriter(new File(s"${System.getProperty("user.dir")}\\output.txt"))

  writer.write(s"Total maximum Sum is ${sum}")
  writer.close()

}