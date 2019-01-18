package monopoly;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.*;

public class GUI extends Application implements EventHandler{

    private Player temp = new Player(".","..");

    private Scene previousScene;

    private Stage window;

    private Button startBtn, loadBtn, twoPlayers, threePlayers, fourPlayers, back, playerName;

    private Button carBtn, horseBtn, planeBtn, penguinBtn, scottTerrBtn, shipBtn;

    private TextField pName;

    private Image logo, tempImg;
    private final Image car = new Image("file:car.png");
    private final Image horse = new Image("file:horse.png");
    private final Image paperPlane = new Image("file:paperPlane.png");
    private final Image penguin = new Image("file:penguin.png");
    private final Image scottTerr = new Image("file:scottTerr.png");
    private final Image ship = new Image("file:ship.png");

    private int counter, numPlayers, counter2;
    private String tempName,tempToken;

    public ArrayList<Player> players = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        //Creates and displays the scene and stage
        primaryStage.setTitle("Monopoly");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
        titleScene(primaryStage);
    }

    public void titleScene(Stage primaryStage) {

        StackPane root = new StackPane();

        Scene titlePage = new Scene(root, 1000, 750);

        //Creates the start button
        startBtn = new Button();
        startBtn.setText("Start New Game");
        startBtn.setOnAction(this);
        startBtn.setStyle("-fx-font-size: 20px; ");
        startBtn.setTranslateX(-270);
        startBtn.setTranslateY(140);


        //Creates the loading button
        loadBtn = new Button();
        loadBtn.setText("Load Game");
        loadBtn.setOnAction(this);
        loadBtn.setStyle("-fx-font-size: 20px; ");
        loadBtn.setTranslateX(250);
        loadBtn.setTranslateY(140);

        //Creates a new image
        logo = new Image("file:monopolyLogo.png");

        //Allows the image to been seen and added to the scene
        ImageView iv = new ImageView();
        iv.setImage(logo);
        iv.setTranslateY(-70);

        //assigns previousScene a scene value for using the back button
        previousScene = titlePage;

        //Adds elements to the scene
        //Creates and displays the scene and stage
        primaryStage.setTitle("Monopoly");
        root.getChildren().addAll(startBtn, loadBtn, iv);
        primaryStage.setScene(titlePage);
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
        twoPlayers.setTranslateY(70);

        //Customization of JButton element
        threePlayers = new Button();
        threePlayers.setText("3");
        threePlayers.setOnAction(this);
        threePlayers.setStyle("-fx-font-size: 30px; ");
        threePlayers.setTranslateX(0);
        threePlayers.setTranslateY(70);

        //Customization of JButton element
        fourPlayers = new Button();
        fourPlayers.setText("4");
        fourPlayers.setOnAction(this);
        fourPlayers.setStyle("-fx-font-size: 30px; ");
        fourPlayers.setTranslateX(270);
        fourPlayers.setTranslateY(70);

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
        txt1.setTranslateY(-100);

        pName = new TextField();
        pName.setStyle("-fx-font-size: 20px; ");
        pName.setMaxSize(400, 20);

        playerName = new Button();
        playerName.setText("Enter");
        playerName.setOnAction(this);
        playerName.setStyle("-fx-font-size: 20px; ");
        playerName.setTranslateX(270);

        tempName = pName.getText();

        root.getChildren().addAll(txt1, pName, playerName);

        primaryStage.setScene(playerCreationPage);
    }

    public void tokenSelectionScene(Stage primaryStage) {

        StackPane root = new StackPane();

        FlowPane pane = new FlowPane();
        pane.setHgap(30);
        pane.setVgap(30);
        pane.setAlignment(Pos.CENTER);
        pane.setTranslateY(50);

        Text txt = new Text("Select a Token Piece for Player " + (counter2 + 1));
        txt.setStyle("-fx-font-size: 30px; ");
        txt.setTranslateY(-50);

        Scene tokenSelection = new Scene(root, 1000, 700);

        carBtn = new Button();
        horseBtn = new Button();
        planeBtn = new Button();
        penguinBtn = new Button();
        scottTerrBtn = new Button();
        shipBtn = new Button();

        carBtn.setGraphic(new ImageView(car));
        horseBtn.setGraphic(new ImageView(horse));
        planeBtn.setGraphic(new ImageView(paperPlane));
        penguinBtn.setGraphic(new ImageView(penguin));
        scottTerrBtn.setGraphic(new ImageView(scottTerr));
        shipBtn.setGraphic(new ImageView(ship));

        carBtn.setOnAction(this);
        horseBtn.setOnAction(this);
        planeBtn.setOnAction(this);
        penguinBtn.setOnAction(this);
        scottTerrBtn.setOnAction(this);
        shipBtn.setOnAction(this);

        pane.getChildren().addAll(carBtn, horseBtn, planeBtn, penguinBtn, scottTerrBtn, shipBtn);

        root.getChildren().addAll(pane, txt);

        primaryStage.setScene(tokenSelection);
    }

    //Method for handling button and any events
    @Override
    public void handle(Event event) {
        counter = 0;
        if(event.getSource() == startBtn){
            numPlayersScene(window);

        } else if (event.getSource() == loadBtn) {
            System.out.println("Loading");

        } else if (event.getSource() == twoPlayers) {
            counter = 0;
            playerCreationScene(window);
            numPlayers = 2;

        } else if (event.getSource() == threePlayers) {
            counter = 0;
            playerCreationScene(window);
            numPlayers = 3;

        } else if (event.getSource() == fourPlayers) {
            counter = 0;
            playerCreationScene(window);
            numPlayers = 4;

        } else if (event.getSource() == playerName) {

            Player user = new Player(tempName, tempToken);
            players.add(user);

            counter += 1;

            if (counter < numPlayers) {
                playerCreationScene(window);
            } else if (counter == numPlayers) {
                tokenSelectionScene(window);
                counter2 = 0;
            }

        } else if (event.getSource() == carBtn) {
            players.get(counter2).setToken("car");
            counter2 += 1;
            if (counter2 < numPlayers) {
                tokenSelectionScene(window);
            } else if (counter == numPlayers) {
                titleScene(window);
            }
        } else if (event.getSource() == horseBtn) {
            players.get(counter2).setToken("horse");
            counter2 += 1;
            if (counter2 < numPlayers) {
                tokenSelectionScene(window);
            } else if (counter == numPlayers) {
                titleScene(window);
            }
        } else if (event.getSource() == planeBtn) {
            players.get(counter2).setToken("plane");
            counter2 += 1;
            if (counter2 < numPlayers) {
                tokenSelectionScene(window);
            } else if (counter == numPlayers) {
                titleScene(window);
            }
        } else if (event.getSource() == penguinBtn) {
            players.get(counter2).setToken("penguin");
            counter2 += 1;
            if (counter2 < numPlayers) {
                tokenSelectionScene(window);
            } else if (counter == numPlayers) {
                titleScene(window);
            }
        } else if (event.getSource() == scottTerrBtn) {
            players.get(counter2).setToken("scottTerr");
            counter2 += 1;
            if (counter2 < numPlayers) {
                tokenSelectionScene(window);
            } else if (counter == numPlayers) {
                titleScene(window);
            }
        } else if (event.getSource() == shipBtn) {
            players.get(counter2).setToken("ship");
            counter2 += 1;
            if (counter2 < numPlayers) {
                tokenSelectionScene(window);
            } else if (counter == numPlayers) {
                titleScene(window);
            }
        }
    }

    //carBtn, horseBtn, lampBtn, planeBtn, penguinBtn, scottTerrBtn, shipBtn, wheelBarrowBtn
    public static void main(String[] args) {
        launch(args);
    }
}
