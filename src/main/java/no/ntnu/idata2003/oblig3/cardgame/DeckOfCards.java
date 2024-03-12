package no.ntnu.idata2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a deck of 52 cards.
 *
 * <p>The deck of cards has 4 suits, Spade, Hearts, Diamonds and Clubs, each with 13 faces.</p>
 */
public class DeckOfCards {
  private ArrayList<PlayingCard> deckOfCards;
  private final char[] suits = {'S', 'H', 'D', 'C'};

  /**
   * Creates an instance of a deck of cards, containing 4 suits with 13 faces of the total 52
   * cards.
   */
  public DeckOfCards() {
    this.deckOfCards = new ArrayList<>();
    this.createDeck();
  }

  /**
   * Creates a deck of 52 cards, that has 4 suits with 13 faces.
   */
  // This method was created with the help of GitHub Copilot.
  private void createDeck() {
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        this.deckOfCards.add(new PlayingCard(suit, face));
      }
    }
  }

  /**
   * Deals a given amount of cards from the deck of cards.
   *
   * <p>The number of cards to be dealt must be between 1 and 52.</p>
   *
   * @param n number of cards to be dealt between 1 and 52.
   * @return a given amount of cards from the deck of cards.
   */
  public ArrayList<PlayingCard> dealHand(int n) {
    ArrayList<PlayingCard> hand = new ArrayList<>();

    Random random = new Random();

    if (n >= 1 && n <= 52) {
      int num = 52;
      for (int i = 0; i < n; i++) {
        int randomInt = random.nextInt(num);
        hand.add(this.deckOfCards.get(randomInt));
        this.deckOfCards.remove(randomInt);
        num--;
      }
    }
    return hand;
  }

  // TODO: Should there be a reset/shuffle deck method?

  // Used for testing. Remove or move later.
  public static void main(String[] args) {
    DeckOfCards deck = new DeckOfCards();
//    for (PlayingCard card : deck.deckOfCards) {
//      System.out.println(card.getAsString());
//    }


//    for (PlayingCard card : deck.dealHand(1)) {
//      System.out.println(card.getAsString());
//    }

    HandOfCards hand = new HandOfCards(5);
    for (PlayingCard card : hand.getHandOfCards()) {
      System.out.println(card.getAsString());
    }

    System.out.println("The sum of the cards is: " + hand.checkSum());

    for (PlayingCard card : hand.getHearts()) {
      System.out.println(card.getAsString());
    }
    if (hand.getHearts().isEmpty()) {
      System.out.println("No Hearts");
    }

  }
}
