package com.assignment1.problem2.translations

object Poker {
  def compare(hand1: Hand, hand2: Hand): Int = {

   /* println("hand 1 weight "+hand1.weight )
    println("hand 2 weight "+hand2.weight )*/
    if(hand1.weight > hand2.weight) 1 else if(hand1.weight < hand2.weight) 2 else 0
  }
}
