
import com.assignment1.problem1.datacheck.DataCheck

import java.io.{File, PrintWriter}
import java.time.{DayOfWeek, LocalDate, Month}

object App extends App {

  val dataChecker = DataCheck.isItMonday
  var startDate = LocalDate.of(1901, Month.JANUARY, 1)
  val endDate = LocalDate.of(2001, Month.JANUARY, 1)
  val days = Stream.iterate(startDate)(currentDate => currentDate.plusMonths(1)).takeWhile(currentDate => currentDate.isBefore(endDate)).map(dataChecker).sum

  val writer = new PrintWriter(new File(s"${System.getProperty("user.dir")}\\output.txt"))

  writer.write(s"Total number of Sundays are ${days}")
  println(s"Total number of Sundays are ${days}")
  writer.close()

}
