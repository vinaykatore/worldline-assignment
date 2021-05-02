import com.assignment1.problem2.translations.{Hand, Poker, syntax}

import java.io.{File, PrintWriter}
import scala.io.Source

object Main extends App {


  var counter = 0;
  var winCount = 0;
  val source = Source.fromFile(s"${System.getProperty("user.dir")}\\poker.txt")
  for (line <- source.getLines) {
    counter += 1
    val player1hand = line.substring(0,14)
    val player2hand = line.substring(15,29)

    val hand1 = syntax.hand(player1hand)
    val hand2 = syntax.hand(player2hand)
    compare("Test " + counter, hand1, hand2)
  }

  source.close()
  val writer = new PrintWriter(new File(s"${System.getProperty("user.dir")}\\output.txt"))

  writer.write(s"player 1 wins ${winCount} times")
  writer.close()

  def compare(name: String, hand1: Hand, hand2: Hand)= {
    val ans = Poker.compare(hand1, hand2)
    if(ans ==1) winCount+=1
    println(s"Test case $name: $hand1 / $hand2 => $ans")
  }
}
