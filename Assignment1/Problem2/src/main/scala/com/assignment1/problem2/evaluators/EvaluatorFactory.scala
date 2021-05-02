package com.assignment1.problem2.evaluators
import com.assignment1.problem2.translations.Hand
import com.assignment1.problem2.utility._

object EvaluatorFactory  {


  object RoyalFlushEvaluator extends HandEvaluator with HighCardEvaluator {
    val RoYAL_FLUSH = 9000000

    override def evaluate: Hand => Boolean = { a =>
      if(a.cards.size!=5) false
      else {
        if(FlushEvaluator.evaluate (a) && StraightEvaluator.evaluate (a) ) {
          val cards = Utility.sortByRank(a)
          if(cards.head.value.rank ==10) true else false
        } else false
      }
    }
    override def evaluateWeight: Hand => Int = { hand =>
      RoYAL_FLUSH + evaluateHighCard(hand)
    }
  }

  object StraightFlushEvaluator extends HandEvaluator with HighCardEvaluator {
    val STRAIGHT_FLUSH = 8000000

    override def evaluate: Hand => Boolean = { a =>
      if(a.cards.size!=5) false
      else {
       if(FlushEvaluator.evaluate (a) && StraightEvaluator.evaluate (a)) true else false
      }
    }
    override def evaluateWeight: Hand => Int = { hand =>
      STRAIGHT_FLUSH + evaluateHighCard(hand)
    }
  }

  object FourOfAKindEvaluator extends HandEvaluator with HighCardEvaluator {
    val FOUR_OF_A_KIND = 7000000
    override def evaluate: Hand => Boolean = { hand =>
      val cards = Utility.sortByRank(hand)

      val scenario1 = cards.head.value.rank == cards(1).value.rank  && cards(1).value.rank == cards(2).value.rank && cards(2).value.rank  == cards(3).value.rank
      val scenario2 = cards(1).value.rank == cards(2).value.rank  && cards(2).value.rank == cards(3).value.rank && cards(3).value.rank  == cards(4).value.rank

      scenario1 || scenario2

    }

    override def evaluateWeight: Hand => Int = { hand =>
      val cards = Utility.sortByRank(hand)

      FOUR_OF_A_KIND + cards(2).value.rank
    }
  }

  object FullHouseEvaluator extends HandEvaluator with HighCardEvaluator {
    val FULL_HOUSE = 6000000
    override def evaluate: Hand => Boolean = { hand =>
      val cards = Utility.sortByRank(hand)

      val scenario1 = cards.head.value.rank == cards(1).value.rank  && cards(1).value.rank == cards(2).value.rank && cards(3).value.rank  == cards(4).value.rank
      val scenario2 = cards.head.value.rank == cards(1).value.rank  && cards(2).value.rank == cards(3).value.rank && cards(3).value.rank  == cards(4).value.rank

      scenario1 || scenario2
    }

    override def evaluateWeight: Hand => Int = { hand =>
      val cards = Utility.sortByRank(hand)

      FULL_HOUSE + cards(2).value.rank
    }
  }


  object FlushEvaluator extends HandEvaluator with HighCardEvaluator {
    val FLUSH = 5000000
    override def evaluate: Hand => Boolean = { a =>
                if(a.cards.size!=5) false
                else {
                  val cards = Utility.sortBySuit(a)
                  if(cards.head.suit.name.equalsIgnoreCase(cards.last.suit.name)) true else false
                }
    }
    override def evaluateWeight: Hand => Int = { hand =>
       FLUSH + evaluateHighCard(hand)
    }
  }

  object StraightEvaluator extends HandEvaluator with HighCardEvaluator {
    val STRAIGHT = 4000000
    override def evaluate: Hand => Boolean = { hand =>

      val cards = Utility.sortByRank(hand)
      if(cards(4).value.name.equalsIgnoreCase("A")){
        val a = cards(0).value.name.equalsIgnoreCase("2") &&
          cards(1).value.name.equalsIgnoreCase("3") &&
          cards(2).value.name.equalsIgnoreCase("4") &&
          cards(3).value.name.equalsIgnoreCase("5")
        val b = cards(0).value.name.equalsIgnoreCase("T") &&
          cards(1).value.name.equalsIgnoreCase("J") &&
          cards(2).value.name.equalsIgnoreCase("Q") &&
          cards(3).value.name.equalsIgnoreCase("K")
        if(a || b ) true else false
      } else{

          val temp = cards.head.value.rank +1
          var counter = 0;
          var  isStraight = true

          for (x <- cards.toArray) {
            if (counter != 0) {
              if (x.value.rank != temp)
                isStraight = false
            }
            counter += 1
          }
          isStraight
      }

    }

    override def evaluateWeight: Hand => Int = { hand =>
      STRAIGHT + evaluateHighCard(hand)
    }
  }





  object ThreeOfAKindEvaluator extends HandEvaluator with HighCardEvaluator {
    val SET = 3000000
    override def evaluate: Hand => Boolean = { hand =>
      if(FullHouseEvaluator.evaluate(hand) || FourOfAKindEvaluator.evaluate(hand)) false else{
        val cards = Utility.sortByRank(hand)
        val scenario1 = cards.head.value.rank == cards(1).value.rank  && cards(1).value.rank == cards(2).value.rank
        val scenario2 = cards(1).value.rank == cards(2).value.rank  && cards(2).value.rank == cards(3).value.rank
        val scenario3 = cards(2).value.rank == cards(3).value.rank  && cards(3).value.rank == cards(4).value.rank
        scenario1 || scenario2 || scenario3
      }

    }

    override def evaluateWeight: Hand => Int = { hand =>
      val cards = Utility.sortByRank(hand)

      SET + cards(2).value.rank
    }
  }

  object TwoPairEvaluator extends HandEvaluator with HighCardEvaluator {
    val TWO_PAIRS = 2000000
    override def evaluate: Hand => Boolean = { hand =>
      if (FullHouseEvaluator.evaluate(hand) || FourOfAKindEvaluator.evaluate(hand) || ThreeOfAKindEvaluator.evaluate(hand)) false else {
        val cards = Utility.sortByRank(hand)
        val scenario1 = cards.head.value.rank == cards(1).value.rank && cards(2).value.rank == cards(3).value.rank
        val scenario2 = cards.head.value.rank == cards(1).value.rank && cards(3).value.rank == cards(4).value.rank
        val scenario3 = cards.head.value.rank == cards(2).value.rank && cards(3).value.rank == cards(4).value.rank
        scenario1 || scenario2 || scenario3

      }
    }

    override def evaluateWeight: Hand => Int = { hand =>
      val cards = Utility.sortByRank(hand)

      val cardval = if(cards.head.value.rank == cards(1).value.rank && cards(2).value.rank == cards(3).value.rank) 14*14*cards(2).value.rank + 14*cards.head.value.rank + cards(4).value.rank
      else if(cards.head.value.rank == cards(1).value.rank && cards(3).value.rank == cards(4).value.rank) 14*14*cards(3).value.rank + 14*cards.head.value.rank + cards(2).value.rank
      else 14*14*cards(3).value.rank + 14*cards(1).value.rank + cards(0).value.rank

      TWO_PAIRS + cardval

    }
  }
    object OnePairEvaluator extends HandEvaluator with HighCardEvaluator {
      val ONE_PAIR = 1000000
      override def evaluate: Hand => Boolean = { hand =>
        if (FullHouseEvaluator.evaluate(hand) || FourOfAKindEvaluator.evaluate(hand) || ThreeOfAKindEvaluator.evaluate(hand) || TwoPairEvaluator.evaluate(hand)) false else {
          val cards = Utility.sortByRank(hand)
          val scenario1 = cards.head.value.rank == cards(1).value.rank
          val scenario2 = cards(1).value.rank == cards(2).value.rank
          val scenario3 = cards(2).value.rank == cards(3).value.rank
          val scenario4 = cards(3).value.rank == cards(4).value.rank
          scenario1 || scenario2 || scenario3 || scenario4
        }
      }

      override def evaluateWeight: Hand => Int = { hand =>
        val cards = Utility.sortByRank(hand)

        val cardval = if(cards.head.value.rank == cards(1).value.rank)   14*14*14*cards.head.value.rank +cards(2).value.rank + 14*cards(3).value.rank + 14*14*cards(4).value.rank
        else if(cards(1).value.rank == cards(2).value.rank)  14*14*14*cards(1).value.rank +cards(0).value.rank + 14*cards(3).value.rank + 14*14*cards(4).value.rank
        else if(cards(2).value.rank == cards(3).value.rank)  14*14*14*cards(2).value.rank +cards(0).value.rank + 14*cards(1).value.rank + 14*14*cards(4).value.rank
        else 14*14*14*cards(3).value.rank +cards(0).value.rank + 14*cards(1).value.rank + 14*14*cards(2).value.rank

        ONE_PAIR + cardval

      }
    }

}

