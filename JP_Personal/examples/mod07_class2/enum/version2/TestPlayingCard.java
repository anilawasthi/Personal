package cards.tests;

import cards.domain.PlayingCard;
import cards.domain.Suit;

public class TestPlayingCard {
  public static void main(String[] args) {

    PlayingCard card1
      = new PlayingCard(Suit.SPADES, 2);
    System.out.println("card1 is the " + card1.getRank()
                       + " of " + card1.getSuitName());

    // PlayingCard card2 = new PlayingCard(47, 2);
    // This will not compile.
  }
}
