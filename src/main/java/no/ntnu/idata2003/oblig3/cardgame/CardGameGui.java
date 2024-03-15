package no.ntnu.idata2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Represents the main window of the application.
 */
public class CardGameGui extends Application {
  private CardGameController controller;
  private Label sumLabel,cardOfHeartsLabel ,flushLabel ,queenOfSpadesLabel;
  private String path1, path2, path3, path4, path5;
  private ImageView cardImageView1, cardImageView2, cardImageView3, cardImageView4, cardImageView5;

  /**
   * Constructs the main window.
   *
   * @param stage the stage to populate with the scene graph
   */
  @Override
  public void start(Stage stage) {
    this.controller = new CardGameController(this);

    BorderPane rootNode = new BorderPane();
    rootNode.setPadding(new Insets(5));

    // Right pane --------------------
    Button buttonDeal = new Button("Deal hand");
    buttonDeal.setOnAction((ActionEvent action) -> {
      controller.doDealHand();
      controller.showHand();
    });

    Button buttonCheck = new Button("Check hand");
    buttonCheck.setOnAction((ActionEvent action) -> {
      controller.doCheckHand();
    });

    buttonDeal.setMaxWidth(200);
    buttonCheck.setMaxWidth(200);

    VBox rightPane = new VBox();
    rightPane.getChildren().addAll(buttonDeal, buttonCheck);
    rightPane.setSpacing(20);

    rootNode.setRight(rightPane);
    //rootNode.setPadding(new Insets(100, 30, 30, 30));
    BorderPane.setMargin(rightPane, new Insets(100, 20, 20, 20));

    // Bottom pane --------------------
    Label labelSumOfFaces = new Label("Sum of the faces:");
    Label labelCardsOfHearts = new Label("Cards of hearts:");
    Label labelFlush = new Label("Flush:");
    Label labelQueenOfSpades = new Label("Queen of spades:");

    this.sumLabel = new Label("-");
    this.sumLabel.setFont(Font.font("Regular", FontWeight.BOLD, 13));
    this.cardOfHeartsLabel = new Label("-");
    this.cardOfHeartsLabel.setFont(Font.font("Regular", FontWeight.BOLD, 13));
    this.flushLabel = new Label("-");
    this.flushLabel.setFont(Font.font("Regular", FontWeight.BOLD, 13));
    this.queenOfSpadesLabel = new Label("-");
    this.queenOfSpadesLabel.setFont(Font.font("Regular", FontWeight.BOLD, 13));

    GridPane bottomGrid = new GridPane();
    HBox bottomTLHBox = new HBox();
    HBox bottomTRHBox = new HBox();
    HBox bottomBLHBox = new HBox();
    HBox bottomBRHBox = new HBox();

    bottomTLHBox.getChildren().addAll(labelSumOfFaces, this.sumLabel);
    bottomTLHBox.setSpacing(5);

    bottomTRHBox.getChildren().addAll(labelCardsOfHearts, this.cardOfHeartsLabel);
    bottomTRHBox.setSpacing(5);

    bottomBLHBox.getChildren().addAll(labelFlush, this.flushLabel);
    bottomBLHBox.setSpacing(5);

    bottomBRHBox.getChildren().addAll(labelQueenOfSpades, this.queenOfSpadesLabel);
    bottomBRHBox.setSpacing(5);

    bottomGrid.add(bottomTLHBox, 0, 0);
    bottomGrid.add(bottomTRHBox, 1, 0);
    bottomGrid.add(bottomBLHBox, 0, 1);
    bottomGrid.add(bottomBRHBox, 1, 1);
    bottomGrid.setVgap(5);
    bottomGrid.setHgap(30);
    bottomGrid.setPadding(new Insets(10));

    rootNode.setBottom(bottomGrid);


    // Center pane --------------------
    // Background color
    BackgroundFill backgroundFillGreen = new BackgroundFill(
        Color.rgb(0, 150, 0), new CornerRadii(10), new Insets(0));
    Background backgroundCenter = new Background(backgroundFillGreen);

    FlowPane mainWindow = new FlowPane();
    mainWindow.setBackground(backgroundCenter);

    this.path1 = "card_pictures/joker.png";
    this.path2 = "card_pictures/joker.png";
    this.path3 = "card_pictures/joker.png";
    this.path4 = "card_pictures/joker.png";
    this.path5 = "card_pictures/joker.png";

    this.cardImageView1 = new ImageView(new Image(path1));
    this.cardImageView1.setFitHeight(200);
    this.cardImageView1.setFitWidth(138);

    this.cardImageView2 = new ImageView(new Image(path2));
    this.cardImageView2.setFitHeight(200);
    this.cardImageView2.setFitWidth(138);

    this.cardImageView3 = new ImageView(new Image(path3));
    this.cardImageView3.setFitHeight(200);
    this.cardImageView3.setFitWidth(138);

    this.cardImageView4 = new ImageView(new Image(path4));
    this.cardImageView4.setFitHeight(200);
    this.cardImageView4.setFitWidth(138);

    this.cardImageView5 = new ImageView(new Image(path5));
    this.cardImageView5.setFitHeight(200);
    this.cardImageView5.setFitWidth(138);

    Image cardImage1 = new Image(path1);
    ImageView imageView = new ImageView(cardImage1);
    //imageView.setImage(cardImage1);
    imageView.setFitHeight(200);
    imageView.setFitWidth(138);

    Image cardImage2 = new Image(path2);
    ImageView imageView1 = new ImageView();
    imageView1.setImage(cardImage2);
    imageView1.setFitHeight(200);
    imageView1.setFitWidth(138);

    Image cardImage3 = new Image(path3);
    ImageView imageView2 = new ImageView();
    imageView2.setImage(cardImage3);
    imageView2.setFitHeight(200);
    imageView2.setFitWidth(138);

    Image cardImage4 = new Image(path4);
    ImageView imageView3 = new ImageView();
    imageView3.setImage(cardImage4);
    imageView3.setFitHeight(200);
    imageView3.setFitWidth(138);

    Image cardImage5 = new Image(path5);
    ImageView imageView4 = new ImageView();
    imageView4.setImage(cardImage5);
    imageView4.setFitHeight(200);
    imageView4.setFitWidth(138);

    mainWindow.getChildren().addAll(
        cardImageView1, cardImageView2, cardImageView3, cardImageView4, cardImageView5);

    mainWindow.setVgap(5);
    mainWindow.setHgap(5);
    mainWindow.setPadding(new Insets(10));

    rootNode.setCenter(mainWindow);

    // Scene
    Scene scene = new Scene(rootNode, 800, 500);

    stage.setScene(scene);
    stage.setTitle("Card Game");

    stage.show();
  }

  public void setSumLabel(int sum) {
    this.sumLabel.setText(String.valueOf(sum));
  }

  public void setCardsOfHeartsLabel(String hearts) {
    this.cardOfHeartsLabel.setText(hearts);
  }

  public void setFlushLabel(String flush){
    this.flushLabel.setText(flush);
  }

  public void setQueenOfSpadesLabel(String queenOfSpades) {
    this.queenOfSpadesLabel.setText(queenOfSpades);
  }

  public void setImagePath(String card1, String card2, String card3, String card4, String card5) {
    this.path1 = "card_pictures/" + card1 + ".png";
    this.cardImageView1.setImage(new Image(path1));
    this.path2 = "card_pictures/" + card2 + ".png";
    this.cardImageView2.setImage(new Image(path2));
    this.path3 = "card_pictures/" + card3 + ".png";
    this.cardImageView3.setImage(new Image(path3));
    this.path4 = "card_pictures/" + card4 + ".png";
    this.cardImageView4.setImage(new Image(path4));
    this.path5 = "card_pictures/" + card5 + ".png";
    this.cardImageView5.setImage(new Image(path5));
  }

  // TODO: Create launcher.
}
