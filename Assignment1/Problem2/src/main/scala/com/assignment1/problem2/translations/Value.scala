package com.assignment1.problem2.translations

sealed abstract class Value(val name: String,val rank :Int) extends Product with Serializable {
  def acesLowRanking: Int = this match {
    case Ace   => 1
    case Two   => 2
    case Three => 3
    case Four  => 4
    case Five  => 5
    case Six   => 6
    case Seven => 7
    case Eight => 8
    case Nine  => 9
    case Ten   => 10
    case Jack  => 11
    case Queen => 12
    case King  => 13
  }

  def acesHighRanking: Int = this match {
    case Two   => 2
    case Three => 3
    case Four  => 4
    case Five  => 5
    case Six   => 6
    case Seven => 7
    case Eight => 8
    case Nine  => 9
    case Ten   => 10
    case Jack  => 11
    case Queen => 12
    case King  => 13
    case Ace   => 14
  }
}

case object Ace   extends Value("A",14)
case object Two   extends Value("2",2)
case object Three extends Value("3",3)
case object Four  extends Value("4",4)
case object Five  extends Value("5",5)
case object Six   extends Value("6",6)
case object Seven extends Value("7",7)
case object Eight extends Value("8",8)
case object Nine  extends Value("9",9)
case object Ten   extends Value("T",10)
case object Jack  extends Value("J",11)
case object Queen extends Value("Q",12)
case object King  extends Value("K",13)

object Value {
  val acesLow: Ordering[Value] =
    Ordering.by(_.acesLowRanking)

  val acesHigh: Ordering[Value] =
    Ordering.by(_.acesHighRanking)
}
