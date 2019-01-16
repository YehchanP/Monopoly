package monopoly;

import java.util.ArrayList;
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

    private Scene previousScene;

    private Stage window;

    private Button startBtn, loadBtn, twoPlayers, threePlayers, fourPlayers, back, playerName;

    private TextField pName;

    private int counter;

    //public ArrayList <Player> players = new ArrayList <Player>();

    public ArrayList <String> test = new ArrayList <String>();

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        StackPane root = new StackPane();

        Scene titlePage = new Scene(root, 1000, 750);

        //Creates the start button
        startBtn = new Button();
        startBtn.setText("Start New Game");
        startBtn.setOnAction(this);
        startBtn.setStyle("-fx-font-size: 20px; ");
        startBtn.setTranslateX(-270);
        startBtn.setTranslateY(150);

        //Creates the loading button
        loadBtn = new Button();
        loadBtn.setText("Load Game");
        loadBtn.setOnAction(this);
        loadBtn.setStyle("-fx-font-size: 20px; ");
        loadBtn.setTranslateX(250);
        loadBtn.setTranslateY(150);

        //assigns previousScene a scene value for using the back button
        previousScene = titlePage;

        //Adds elements to the scene
        root.getChildren().addAll(startBtn, loadBtn);

        //Creates and displays the scene and stage
        primaryStage.setTitle("Monopoly");
        primaryStage.setScene(titlePage);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    //Method for creating the number of players page
    public void numPlayersScene(Stage primaryStage){

        //Declaration and initialization of variables
        Text txt1 = new Text ("Number of Players:");

        StackPane root = new StackPane();

        Scene numPlayersPage = new Scene(root, 1000, 750);

        //Customization of JText element
        txt1.setStyle("-fx-font-size: 30px; ");
        txt1.setTranslateY(-100);

        //Customization of JButton element
        twoPlayers = new Button();
        twoPlayers.setText("2");
        twoPlayers.setOnAction(this);
        twoPlayers.setStyle("-fx-font-size: 30px; ");
        twoPlayers.setTranslateX(-270);
        twoPlayers.setTranslateY(100);

        //Customization of JButton element
        threePlayers = new Button();
        threePlayers.setText("3");
        threePlayers.setOnAction(this);
        threePlayers.setStyle("-fx-font-size: 30px; ");
        threePlayers.setTranslateX(0);
        threePlayers.setTranslateY(100);

        //Customization of JButton element
        fourPlayers = new Button();
        fourPlayers.setText("4");
        fourPlayers.setOnAction(this);
        fourPlayers.setStyle("-fx-font-size: 30px; ");
        fourPlayers.setTranslateX(270);
        fourPlayers.setTranslateY(100);

        //Adds elements to the scene
        root.getChildren().addAll(twoPlayers, threePlayers, fourPlayers, txt1);

        //Sets new scene
        primaryStage.setScene(numPlayersPage);
    }

    //Method for character creation GUI
    public void playerCreationScene(Stage primaryStage){
        StackPane root = new StackPane();

        Scene playerCreationPage = new Scene(root, 1000, 750);

        Text txt1 = new Text ("Player " + (counter + 1) + " Name:");

        txt1.setStyle("-fx-font-size: 30px; ");
        txt1.setTranslateY(-150);

        pName = new TextField();
        pName.setStyle("-fx-font-size: 20px; ");
        pName.setMaxSize(400, 20);
        pName.setTranslateY(-50);

        playerName = new Button();
        playerName.setText("Enter");
        playerName.setOnAction(this);
        playerName.setStyle("-fx-font-size: 20px; ");
        playerName.setTranslateX(270);
        playerName.setTranslateY(-50);

        root.getChildren().addAll(txt1, pName, playerName);

        primaryStage.setScene(playerCreationPage);
    }

    public static void main(String[] args) {
        launch(args);
    }

    //Method for handling button and any events
    @Override
    public void handle(Event event) {
        counter = 0;
        if(event.getSource() == startBtn){
            numPlayersScene(window);

        }else if(event.getSource() == loadBtn){
            System.out.println("Loading");

        }else if(event.getSource() == twoPlayers){
            while(counter < 2) {
                playerCreationScene(window);
                if(event.getSource() == playerName){
                    Player user = new Player(pName,"..");
                    //players.add(user);
                    System.out.println(counter);
                }
                counter++;
                System.out.println("added");
            }

        }else if(event.getSource() == threePlayers){
            for (int i = 0; i < 2; i++) {
                playerCreationScene(window);
            }

        }else if(event.getSource() == fourPlayers){
            for (int i = 0; i < 2; i++) {
                playerCreationScene(window);
            }
        }
    }

}
