package no.ntnu.idata2003.oblig3.cardgame;

import java.util.ArrayList;

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

  // Used for testing. Remove or move later.
  public static void main(String[] args) {
    DeckOfCards deck = new DeckOfCards();
    for (PlayingCard card : deck.deckOfCards) {
      System.out.println(card.getAsString());
    }
  }
}
