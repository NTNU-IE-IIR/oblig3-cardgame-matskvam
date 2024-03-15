package no.ntnu.idata2003.oblig3.cardgame;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Represents the main window of the application.
 */
public class CardGameGui extends Application {
  private CardGameController controller;
  private Label sumLabel;
  private Label cardOfHeartsLabel;
  private Label flushLabel;
  private Label queenOfSpadesLabel;

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
      System.out.println("Dealing hand...");
    });

    Button buttonCheck = new Button("Check hand");
    buttonCheck.setOnAction((ActionEvent action) -> {
      System.out.println("Checking hand...");
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

    Label labelVarSumOfFaces = new Label("-");
    labelVarSumOfFaces.setFont(Font.font("Regular", FontWeight.BOLD, 13));
    labelVarSumOfFaces.setStyle("-fx-text-fill: red;");
    Label labelVarCardsOfHearts = new Label("-");
    labelVarCardsOfHearts.setFont(Font.font("Regular", FontWeight.BOLD, 13));
    labelVarCardsOfHearts.setStyle("-fx-text-fill: red;");
    Label labelVarFlush = new Label("-");
    labelVarFlush.setFont(Font.font("Regular", FontWeight.BOLD, 13));
    labelVarFlush.setStyle("-fx-text-fill: red;");
    Label labelVarQueenOfSpades = new Label("-");
    labelVarQueenOfSpades.setFont(Font.font("Regular", FontWeight.BOLD, 13));
    labelVarQueenOfSpades.setStyle("-fx-text-fill: red;");

    GridPane bottomGrid = new GridPane();
    HBox bottomTLHBox = new HBox();
    HBox bottomTRHBox = new HBox();
    HBox bottomBLHBox = new HBox();
    HBox bottomBRHBox = new HBox();

    bottomTLHBox.getChildren().addAll(labelSumOfFaces, labelVarSumOfFaces);
    bottomTLHBox.setSpacing(5);

    bottomTRHBox.getChildren().addAll(labelCardsOfHearts, labelVarCardsOfHearts);
    bottomTRHBox.setSpacing(5);

    bottomBLHBox.getChildren().addAll(labelFlush, labelVarFlush);
    bottomBLHBox.setSpacing(5);

    bottomBRHBox.getChildren().addAll(labelQueenOfSpades, labelVarQueenOfSpades);
    bottomBRHBox.setSpacing(5);

    bottomGrid.add(bottomTLHBox, 0, 0);
    bottomGrid.add(bottomTRHBox, 1, 0);
    bottomGrid.add(bottomBLHBox, 0, 1);
    bottomGrid.add(bottomBRHBox, 1, 1);
    bottomGrid.setVgap(5);
    bottomGrid.setHgap(30);
    bottomGrid.setPadding(new Insets(10));

    rootNode.setBottom(bottomGrid);


    // TODO: set flowpane in center. Add flowpane to pane?

    // Center pane --------------------
    // Background color
    BackgroundFill backgroundFillGreen = new BackgroundFill(
        Color.rgb(0, 150, 0), new CornerRadii(10), new Insets(0));
    Background backgroundCenter = new Background(backgroundFillGreen);

    FlowPane mainWindow = new FlowPane();
    mainWindow.setBackground(backgroundCenter);

    Image image = new Image("card_pictures/1C.png");
    ImageView imageView = new ImageView();
    imageView.setImage(image);
    imageView.setFitHeight(200);
    imageView.setFitWidth(138);

    Image image1 = new Image("card_pictures/1D.png");
    ImageView imageView1 = new ImageView();
    imageView1.setImage(image1);
    imageView1.setFitHeight(200);
    imageView1.setFitWidth(138);

    Image image2 = new Image("card_pictures/1H.png");
    ImageView imageView2 = new ImageView();
    imageView2.setImage(image2);
    imageView2.setFitHeight(200);
    imageView2.setFitWidth(138);

    Image image3 = new Image("card_pictures/1S.png");
    ImageView imageView3 = new ImageView();
    imageView3.setImage(image3);
    imageView3.setFitHeight(200);
    imageView3.setFitWidth(138);

    Image image4 = new Image("card_pictures/13H.png");
    ImageView imageView4 = new ImageView();
    imageView4.setImage(image4);
    imageView4.setFitHeight(200);
    imageView4.setFitWidth(138);

    mainWindow.getChildren().addAll(imageView, imageView1, imageView2, imageView3, imageView4);

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

  private void printHearts() {
    // String heartAsString = getAsString(hand.getHearts);
  }

  // TODO: Create launcher.
}
