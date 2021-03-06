package com.assignment1.problem2.translations

object syntax {
  /**
   * Helper that enables string-interpolator-style syntax:
   *
   * - `hand"2C 3C 4C"` creates a `Hand`;
   * - `card"2C"` creates a `Card`.
   *
   * Note that this doesn't support interpolation properly,
   * so hand"${foo}" won't provide the expected result.
   */



    def hand(str: String): Hand =
      parseHand(str).getOrElse(
        throw new Exception(s"Could not parse hand: $str")
      )

    def card(str: String): Card =
      parseCard(str).getOrElse(
        throw new Exception(s"Could not parse card: $str")
      )

    def parseHand(str: String): Option[Hand] =
      Some(Hand(str.split(" ").toList.flatMap(parseCard)))

    val cardRegex = "([A-Z0-9])([A-Z])".r

    def parseCard(str: String): Option[Card] =
      str match {
        case cardRegex(value, suit) =>
          for {
            value <- parseValue(value)
            suit <- parseSuit(suit)
          } yield Card(value, suit)

        case _ => None
      }

    def parseValue(str: String): Option[Value] =
      str match {
        case Ace.name => Some(Ace)
        case Two.name => Some(Two)
        case Three.name => Some(Three)
        case Four.name => Some(Four)
        case Five.name => Some(Five)
        case Six.name => Some(Six)
        case Seven.name => Some(Seven)
        case Eight.name => Some(Eight)
        case Nine.name => Some(Nine)
        case Ten.name => Some(Ten)
        case Jack.name => Some(Jack)
        case Queen.name => Some(Queen)
        case King.name => Some(King)
        case _ => None
      }

    def parseSuit(str: String): Option[Suit] =
      str match {
        case Clubs.name => Some(Clubs)
        case Diamonds.name => Some(Diamonds)
        case Hearts.name => Some(Hearts)
        case Spades.name => Some(Spades)
        case _ => None
      }


}
