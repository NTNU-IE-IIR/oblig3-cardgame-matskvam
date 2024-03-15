package no.ntnu.idata2003.oblig3.cardgame;

/**
 * Represents the controller for the CardGameGui class.
 */
public class CardGameController {
  private HandOfCards hand;
  private CardGameGui cardGame;

  public CardGameController(CardGameGui theCardGame) {
    this.hand = new HandOfCards(5);
    this.cardGame = theCardGame;
  }

  // TODO: deal hand

  // TODO: check hand

}
