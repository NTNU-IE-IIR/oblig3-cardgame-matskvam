package no.ntnu.idata2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CardGameGUI extends Application {

  public void start(Stage stage) {
    BorderPane rootNode = new BorderPane();
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
    rightPane.setSpacing(30);

    rootNode.setRight(rightPane);


    rootNode.setPadding(new Insets(30));

    Scene scene = new Scene(rootNode, 800, 500);

    stage.setScene(scene);
    stage.setTitle("Card Game");

    stage.show();
  }
}
