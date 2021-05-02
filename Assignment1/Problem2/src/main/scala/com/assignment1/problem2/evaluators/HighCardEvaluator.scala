package com.assignment1.problem2.evaluators

import com.assignment1.problem2.translations.Hand
import com.assignment1.problem2.utility.Utility

trait HighCardEvaluator {

  def evaluateWeight : Hand => Int

  def evaluateHighCard : Hand => Int = { hand =>
    val cards = Utility.sortByRank(hand)
    val weight = cards.head.value.rank + 14*cards(1).value.rank + 14*14*cards(2).value.rank + 14*14*14*cards(3).value.rank + 14*14*14*14*cards(4).value.rank
    weight
  }
}
