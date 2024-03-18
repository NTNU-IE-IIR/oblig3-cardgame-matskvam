package no.ntnu.idata2003.oblig3.cardgame;

/**
 * Represents the controller for the CardGameGui class.
 */
public class CardGameController {
  private HandOfCards hand;
  private CardGameGui cardGame;

  /**
   * Creates a new instance of a controller for the card game.
   *
   * @param theCardGame the card game to control.
   */
  public CardGameController(CardGameGui theCardGame) {
    this.hand = new HandOfCards(5);
    this.hand.getHandOfCards().clear();
    this.cardGame = theCardGame;
  }

  /**
   * Handles the "deal hand" action.
   */
  public void doDealHand() {
    this.hand = new HandOfCards(5);
  }

  /**
   * Gets the values to show the hand of cards.
   */
  public void showHand() {
    char suit1 = this.hand.getHandOfCards().get(0).getSuit();
    int face1 = this.hand.getHandOfCards().get(0).getFace();

    char suit2 = this.hand.getHandOfCards().get(1).getSuit();
    int face2 = this.hand.getHandOfCards().get(1).getFace();

    char suit3 = this.hand.getHandOfCards().get(2).getSuit();
    int face3 = this.hand.getHandOfCards().get(2).getFace();

    char suit4 = this.hand.getHandOfCards().get(3).getSuit();
    int face4 = this.hand.getHandOfCards().get(3).getFace();

    char suit5 = this.hand.getHandOfCards().get(4).getSuit();
    int face5 = this.hand.getHandOfCards().get(4).getFace();

    String card1 = String.format("%s%s", face1, suit1);
    String card2 = String.format("%s%s", face2, suit2);
    String card3 = String.format("%s%s", face3, suit3);
    String card4 = String.format("%s%s", face4, suit4);
    String card5 = String.format("%s%s", face5, suit5);

    this.cardGame.setImagePath(card1, card2, card3, card4, card5);
  }

  /**
   * Handles the "check hand" action.
   */
  public void doCheckHand() {
    this.cardGame.setSumLabel(this.hand.checkSum());
    this.cardGame.setCardsOfHeartsLabel(this.hand.getHeartsAsString());
    this.cardGame.setFlushLabel(this.hand.getFlushAsString());
    this.cardGame.setQueenOfSpadesLabel(this.hand.getQueenOfSpadesAsString());
  }
}
