package com.assignment1.problem2.translations

sealed abstract class Suit(val name: String) extends Product with Serializable{
  def suitRanking: Int = this match {
    case Spades   => 1
    case Hearts   => 2
    case Diamonds => 3
    case Clubs    => 4
  }
}

case object Clubs    extends Suit("C")
case object Diamonds extends Suit("D")
case object Hearts   extends Suit("H")
case object Spades   extends Suit("S")

object Suit {

  /**
    * While poker hands don't distinguish on suit,
    * it is sometimes useful to have a stable ordering
    * to avoid selecting different permutations of the same cards.
    */
   implicit  val ordering: Ordering[Suit] =
    Ordering.by(_.suitRanking)
}
