package com.assignment1.problem2.utility

import com.assignment1.problem2.translations.{Card, Hand, Suit, Value}

import scala.util.Sorting

object Utility {

  def sortBySuit(hand: Hand) = {
   hand.cards.sortBy(_.suit)
  }

  def sortByRank(hand: Hand) = {
    hand.cards.sortBy(_.value)(Value.acesHigh)
  }
}
