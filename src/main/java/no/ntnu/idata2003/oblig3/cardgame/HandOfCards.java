package no.ntnu.idata2003.oblig3.cardgame;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
  public HandOfCards (int numberOfCards) {
    // TODO: Catch
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
    int sum = 0;

    for (PlayingCard card : this.handOfCards) {
      sum += card.getFace();
    }

    return sum;
  }

  // TODO: showHearts (Hent ut bare kort som er av fargen "Hjerter", og vis i et tekstfelt på
  //  formen "H12 H9 H1". Dersom det ikke er noen Hjerter på hånd, kan tekstfeltet inneholde teksten
  //  "No Hearts", for eksempel.)

  /**
   * Returns all the cards that is of the suit hearts from the hand.
   *
   * @return all the cards that is of the suit hearts from the hand.
   */
  public ArrayList<PlayingCard> getHearts() {
    ArrayList<PlayingCard> hearts = new ArrayList<>();

    for (PlayingCard card : this.handOfCards) {
      if (card.getSuit() == 'H') {
        hearts.add(card);
      }
    }
    return hearts;
  }

  // TODO: checkQueenOfSpades (Sjekk om kortet "Spar dame" finnes blant kortene på hånden.)

  /**
   * Returns {@code true} if the hand of cards contains queen of spades, and {@code false}
   * otherwise.
   *
   * @return {@code true} if the hand of cards contains queen of spades, and {@code false}
   * otherwise.
   */
  public boolean checkQueenOfSpades() {
    boolean queenOfSpades = false;
    for (PlayingCard card : this.handOfCards) {
      if (card.getSuit() == 'S' && card.getFace() == 12) {
        queenOfSpades = true;
      }
    }
    return queenOfSpades;
  }

  // TODO: checkFlush (Sjekk om kortene på hånd utgjør en "5-flush". D.v.s. 5 kort av samme farge
  //  (5 hjerter eller 5 ruter eller 5 kløver eller 5 spar).)

  public boolean checkFlush() {
    // This code was made with the help of GitHub Copilot.
    boolean flush = false;
    int hearts = 0;
    int diamonds = 0;
    int clubs = 0;
    int spades = 0;

    for (PlayingCard card : this.handOfCards) {
      if (card.getSuit() == 'H') {
        hearts++;
      } else if (card.getSuit() == 'D') {
        diamonds++;
      } else if (card.getSuit() == 'C') {
        clubs++;
      } else if (card.getSuit() == 'S') {
        spades++;
      }
    }

    if (hearts >= 5 || diamonds >= 5 || clubs >= 5 || spades >= 5) {
      flush = true;
    }

    return flush;
  }
}
