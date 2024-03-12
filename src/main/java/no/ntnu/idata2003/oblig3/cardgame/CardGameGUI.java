package no.ntnu.idata2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CardGameGUI extends Application {

  public void start(Stage stage) {
    BorderPane rootNode = new BorderPane();
    rootNode.setPadding(new Insets(5));

    // Right pane --------------------
    VBox rightPane = new VBox();

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

    rightPane.getChildren().addAll(buttonDeal, buttonCheck);
    rightPane.setSpacing(20);

    rootNode.setRight(rightPane);
    //rootNode.setPadding(new Insets(100, 30, 30, 30));
    BorderPane.setMargin(rightPane, new Insets(100, 20, 20, 20));

    // Bottom pane --------------------
    Text textSumOfFaces = new Text("Sum of the faces:"); // Change to label? (Label label)
    Text textCardsOfHearts = new Text("Cards of hearts:");
    Text textFlush = new Text("Flush:");
    Text textQueenOfSpades = new Text("Queen of spades:");

    Label labelSumOfFaces = new Label("Sum of the faces:");
    Label labelCardsOfHearts = new Label("Cards of hearts:");
    Label labelFlush = new Label("Flush:");
    Label labelQueenOfSpades = new Label("Queen of spades:");

    Text textVarSumOfFaces = new Text("sumOfFaces");
    textVarSumOfFaces.setFont(Font.font( "Regular", FontWeight.BOLD, 13));
    textVarSumOfFaces.setFill(Color.RED);
    Text textVarCardsOfHearts = new Text("cardsOfHearts");
    textVarCardsOfHearts.setFont(Font.font( "Regular", FontWeight.BOLD, 13));
    textVarCardsOfHearts.setFill(Color.RED);
    Text textVarFlush = new Text("flush");
    textVarFlush.setFont(Font.font( "Regular", FontWeight.BOLD, 13));
    textVarFlush.setFill(Color.RED);
    Text textVarQueenOfSpades = new Text("queenOfSpades");
    textVarQueenOfSpades.setFont(Font.font( "Regular", FontWeight.BOLD, 13));
    textVarQueenOfSpades.setFill(Color.RED);

    GridPane bottomGrid = new GridPane();
    HBox bottomTLHBox = new HBox();
    HBox bottomTRHBox = new HBox();
    HBox bottomBLHBox = new HBox();
    HBox bottomBRHBox = new HBox();

    bottomTLHBox.getChildren().addAll(labelSumOfFaces, textVarSumOfFaces);
    bottomTLHBox.setSpacing(5);

    bottomTRHBox.getChildren().addAll(labelCardsOfHearts, textVarCardsOfHearts);
    bottomTRHBox.setSpacing(5);

    bottomBLHBox.getChildren().addAll(labelFlush, textVarFlush);
    bottomBLHBox.setSpacing(5);

    bottomBRHBox.getChildren().addAll(labelQueenOfSpades, textVarQueenOfSpades);
    bottomBRHBox.setSpacing(5);

    bottomGrid.add(bottomTLHBox, 0,0);
    bottomGrid.add(bottomTRHBox, 1, 0);
    bottomGrid.add(bottomBLHBox, 0, 1);
    bottomGrid.add(bottomBRHBox, 1, 1);
    bottomGrid.setVgap(5);
    bottomGrid.setHgap(30);
    bottomGrid.setPadding(new Insets(10));

    rootNode.setBottom(bottomGrid);


    // May use Text for changing information.
    // TODO: set flowpane in center. Add flowpane to pane?
    // TODO: create a class for hand.

    // Center pane --------------------
    // Background color
    Pane pane = new Pane();
    BackgroundFill backgroundFillGreen = new BackgroundFill(
        Color.rgb(0,150,0), new CornerRadii(10), new Insets(0));
    Background backgroundCenter = new Background(backgroundFillGreen);
    pane.setBackground(backgroundCenter);
    rootNode.setCenter(pane);

    // Scene
    Scene scene = new Scene(rootNode, 800, 500);

    stage.setScene(scene);
    stage.setTitle("Card Game");

    stage.show();
  }

  // TODO: Create launcher.
}
