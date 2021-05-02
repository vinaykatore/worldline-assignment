package com.assignment1.problem2.translations

import com.assignment1.problem2.evaluators.EvaluatorFactory.StraightEvaluator.evaluateHighCard
import com.assignment1.problem2.evaluators.EvaluatorFactory.{FlushEvaluator, FourOfAKindEvaluator, FullHouseEvaluator, OnePairEvaluator, RoyalFlushEvaluator, StraightEvaluator, StraightFlushEvaluator, ThreeOfAKindEvaluator, TwoPairEvaluator}

case class Hand(cards: List[Card]) {

  def weight : Int ={
    if(RoyalFlushEvaluator.evaluate(this)){
      //println("RoyalFlushEvaluator")
      RoyalFlushEvaluator.evaluateWeight(this)
    }else if(StraightFlushEvaluator.evaluate(this)){
      //println("StraightFlushEvaluator")
      StraightFlushEvaluator.evaluateWeight(this)
    }else if(FourOfAKindEvaluator.evaluate(this)){
      //println("FourOfAKindEvaluator")
      FourOfAKindEvaluator.evaluateWeight(this)
    }else if(FullHouseEvaluator.evaluate(this)){
      //println("FullHouseEvaluator")
      FullHouseEvaluator.evaluateWeight(this)
    }else if(FlushEvaluator.evaluate(this)){
      //println("FlushEvaluator")
      FlushEvaluator.evaluateWeight(this)
    }else if(StraightEvaluator.evaluate(this)){
      //println("StraightEvaluator")
      StraightEvaluator.evaluateWeight(this)
    }else if(ThreeOfAKindEvaluator.evaluate(this)){
      //println("ThreeOfAKindEvaluator")
      ThreeOfAKindEvaluator.evaluateWeight(this)
    }else if(TwoPairEvaluator.evaluate(this)){
      //println("TwoPairEvaluator")
      TwoPairEvaluator.evaluateWeight(this)
    }else if(OnePairEvaluator.evaluate(this)){
      //println("OnePairEvaluator")
      OnePairEvaluator.evaluateWeight(this)
    }else evaluateHighCard(this)
  }
}

object Hand {
  def apply(cards: Card*): Hand = Hand(cards.toList)
}
