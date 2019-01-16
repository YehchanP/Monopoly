package Monopoly;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.*;

public class GUI extends Application implements EventHandler{
    
    Stage window;
    
    private Button startBtn, loadBtn, twoPlayers, threePlayers, fourPlayers, back;
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        
        StackPane root = new StackPane();
        
        Scene titlePage = new Scene(root, 1000, 750);
        
        startBtn = new Button();
        startBtn.setText("Start New Game");
        startBtn.setOnAction(this);
        startBtn.setStyle("-fx-font-size: 20px; ");
        startBtn.setTranslateX(-270);
        startBtn.setTranslateY(150);
        
        loadBtn = new Button();
        loadBtn.setText("Load Game");
        loadBtn.setOnAction(this);
        loadBtn.setStyle("-fx-font-size: 20px; ");
        loadBtn.setTranslateX(250);
        loadBtn.setTranslateY(150);
        
        root.getChildren().add(startBtn);
        root.getChildren().add(loadBtn);
        
        primaryStage.setTitle("Monopoly");
        primaryStage.setScene(titlePage);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public void playerNumScene(Stage primaryStage){
        Text txt1 = new Text ("Number of Players:");
        
        StackPane root = new StackPane();
        
        Scene numPlayersPage = new Scene(root, 1000, 750);
        
        txt1.setStyle("-fx-font-size: 30px; ");
        txt1.setTranslateY(-100);
        
        twoPlayers = new Button();
        twoPlayers.setText("2");
        twoPlayers.setOnAction(this);
        twoPlayers.setStyle("-fx-font-size: 30px; ");
        twoPlayers.setTranslateX(-270);
        twoPlayers.setTranslateY(100);
        
        threePlayers = new Button();
        threePlayers.setText("3");
        threePlayers.setOnAction(this);
        threePlayers.setStyle("-fx-font-size: 30px; ");
        threePlayers.setTranslateX(0);
        threePlayers.setTranslateY(100);
        
        fourPlayers = new Button();
        fourPlayers.setText("4");
        fourPlayers.setOnAction(this);
        fourPlayers.setStyle("-fx-font-size: 30px; ");
        fourPlayers.setTranslateX(270);
        fourPlayers.setTranslateY(100);
        
        root.getChildren().addAll(twoPlayers, threePlayers, fourPlayers, txt1);
        
        primaryStage.setScene(numPlayersPage);
    }
    
    public void playerCreation(Stage primaryStage){
        StackPane root = new StackPane();
        
        Scene playerCreationScene = new Scene(root, 1000, 750);
        
        TextField name = new TextField("This is a Text");
        //name.set;
        
        root.getChildren().addAll(name);
        
        primaryStage.setScene(playerCreationScene);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void handle(Event event) {
        if(event.getSource() == startBtn){
            playerNumScene(window);
        }else if(event.getSource() == loadBtn){
            System.out.println("Loading");
        }else if(event.getSource() == twoPlayers){
            for (int i = 0; i < 2; i++) {
                playerCreation(window);
            }
        }else if(event.getSource() == threePlayers){
            for (int i = 0; i < 2; i++) {
                System.out.println("Player " + (i+1));
            }
        }else if(event.getSource() == fourPlayers){
            for (int i = 0; i < 2; i++) {
                System.out.println("Player " + (i+1));
            }
        }
    }
    
}
