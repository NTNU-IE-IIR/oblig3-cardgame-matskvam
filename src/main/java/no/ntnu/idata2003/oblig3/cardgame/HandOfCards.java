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

  // TODO: showHearts (Hent ut bare kort som er av fargen "Hjerter", og vis i et tekstfelt på
  //  formen "H12 H9 H1". Dersom det ikke er noen Hjerter på hånd, kan tekstfeltet inneholde teksten
  //  "No Hearts", for eksempel.)

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

  // TODO: checkQueenOfSpades (Sjekk om kortet "Spar dame" finnes blant kortene på hånden.)

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

  public String getQueenOfSpadesAsString() {
    String queen = "";

    if (this.checkQueenOfSpades()) {
      queen = "Yes";
    } else {
      queen = "No";
    }
    return queen;
  }

  // TODO: checkFlush (Sjekk om kortene på hånd utgjør en "5-flush". D.v.s. 5 kort av samme farge
  //  (5 hjerter eller 5 ruter eller 5 kløver eller 5 spar).)

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
