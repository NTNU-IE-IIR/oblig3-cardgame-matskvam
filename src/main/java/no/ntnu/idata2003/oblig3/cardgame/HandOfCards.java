package no.ntnu.idata2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a hand of playing cards.
 */
public class HandOfCards {

  private ArrayList<PlayingCard> handOfCards;

  /**
   * Creates a hand of playing cards.
   *
   * <p>The number of cards in the hand must be between 1 and 52.</p>
   *
   * @param numberOfCards number of cards in the hand between 1 and 52.
   */
  public HandOfCards(int numberOfCards) {
    // This exception is not caught due to the limited functionality of the game.
    if (numberOfCards < 1 || numberOfCards > 52) {
      throw new IllegalArgumentException("Number of cards must be between 1 and 52.");
    }
    DeckOfCards deckOfCards = new DeckOfCards();
    this.handOfCards = deckOfCards.dealHand(numberOfCards);
  }

  /**
   * Returns the hand of cards.
   *
   * @return the hand of cards.
   */
  public ArrayList<PlayingCard> getHandOfCards() {
    return this.handOfCards;
  }

  /**
   * Calculates the sum of all values of the cards in the hand.
   *
   * @return the sum of all values of the cards in the hand.
   */
  public int checkSum() {
    // This method was made with help from MS Copilot.
    return this.handOfCards.stream()
        .mapToInt(PlayingCard::getFace)
        .sum();
  }

  /**
   * Returns all the cards with the suit hearts from the hand.
   *
   * @return all the cards with the suit hearts from the hand.
   */
  public List<PlayingCard> getHearts() {
    // This method was made with help from MS Copilot.
    return this.handOfCards.stream()
        .filter(card -> card.getSuit() == 'H')
        .collect(Collectors.toList());
  }

  /**
   * Returns a single string with all the cards with the suit hearts from the hand.
   *
   * @return a single string with all the cards with the suit hearts from the hand.
   */
  public String getHeartsAsString() {
    String hearts = "";

    if (getHearts().isEmpty()) {
      hearts = "No hearts";
    } else {
      // Made with the help of GitHub Copilot.
      hearts = this.getHearts().stream()
          .map(PlayingCard::getAsString)
          .collect(Collectors.joining(" "));

    }
    return hearts;
  }

  /**
   * Returns {@code true} if the hand of cards contains queen of spades, and {@code false}
   * otherwise.
   *
   * @return {@code true} if the hand of cards contains queen of spades, and {@code false}
   *     otherwise.
   */
  public boolean checkQueenOfSpades() {
    // This method was made with help from MS Copilot.
    return this.handOfCards.stream()
        .anyMatch(card -> (card.getSuit() == 'S') && (card.getFace() == 12));
  }

  /**
   * Returns a string with "Yes" if the hand of cards contains queen of spades, and "No" otherwise.
   *
   * @return a string with "Yes" if the hand of cards contains queen of spades, and "No" otherwise.
   */
  public String getQueenOfSpadesAsString() {
    String queen = "";

    if (this.checkQueenOfSpades()) {
      queen = "Yes";
    } else {
      queen = "No";
    }
    return queen;
  }

  /**
   * Returns {@code true} if the hand of cards contains a flush, and {@code false} otherwise.
   *
   * @return {@code true} if the hand of cards contains a flush, and {@code false} otherwise.
   */
  public boolean checkFlush() {
    // This method was made with help from MS Copilot.
    return this.handOfCards.stream()
        // PlayingCard::getSuit is the same as (PlayingCard p) -> p.getSuit().
        .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()))
        .values()
        .stream()
        .anyMatch(count -> count >= 5);
  }

  /**
   * Returns a string with "Yes" if the hand of cards contains a flush, and "No" otherwise.
   *
   * @return a string with "Yes" if the hand of cards contains a flush, and "No" otherwise.
   */
  public String getFlushAsString() {
    String flush = "";
    if (this.checkFlush()) {
      flush = "Yes";
    } else {
      flush = "No";
    }
    return flush;
  }
}
