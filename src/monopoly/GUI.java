package monopoly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.*;

public class GUI extends Application implements EventHandler<ActionEvent>{

    //Variable declarations
    private Scene previousScene;

    private Stage window;
    
    private StackPane playerInfo, main, buyPane;

    private Button startBtn, twoPlayers, threePlayers, fourPlayers, back, playerName;
    private Button carBtn, horseBtn, planeBtn, penguinBtn, scottTerrBtn, shipBtn;
    private Button buyBtn;

    private TextField pName;

    private Image logo, tempToken;
    private final Image car = new Image("file:car.png");
    private final Image horse = new Image("file:horse.png");
    private final Image paperPlane = new Image("file:paperPlane.png");
    private final Image penguin = new Image("file:penguin.png");
    private final Image scottTerr = new Image("file:scottTerr.png");
    private final Image ship = new Image("file:ship.png");
    private final Image monopolyBoard = new Image ("file:monopolyBoard.png");
    private final Image block_1 = new Image("file:block_1.png");
    private final Image block_2 = new Image("file:block_2.png");
    private final Image block_3 = new Image("file:block_3.png");
    private final Image block_4 = new Image("file:block_4.png");
    private final Image block_5 = new Image("file:block_5.png");
    private final Image block_6 = new Image("file:block_6.png");
    private final Image inJailIMG = new Image("file:inJail.png");
    private final Image redPropImg = new Image("file:redProp.png");
    private final Image greenPropImg = new Image("file:greenProp.png");
    private final Image bluePropImg = new Image("file:skyblueProp.png");
    private final Image navyPropImg = new Image("file:navyProp.png");
    private final Image orangePropImg = new Image("file:orangeProp.png");
    private final Image yellowPropImg = new Image("file:yellowProp.png");
    private final Image brownPropImg = new Image("file:brownProp.png");
    private final Image magentaPropImg = new Image("file:magentaProp.png");

    private int counter, numPlayers, counter2, counter3;
    
    private boolean start = true;
    
    private String tempName;

    public ArrayList<Player> players = new ArrayList<>();
    
    private final ImageView diceBlock1 = new ImageView(block_1);
    private final ImageView diceBlock2 = new ImageView(block_2);
    
    public ArrayList<ImageView> playerTokens = new ArrayList<>();
    
    static ArrayList<Tiles> board = new ArrayList<>();
    
    private Button rollBtn;
    
    private int userDice1 = 0;
    private int userDice2 = 0;
    
    private final Random rng = new Random();
    
    @Override
    public void start(Stage primaryStage) {
        
        //Saves the stage so that it could be used as the stage in other scene method's parameters
        window = primaryStage;

        //Creates and displays the scene and stage
        primaryStage.setTitle("Monopoly");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
        titleScene(primaryStage);
    }

    //Method for creating the title page scene
    public void titleScene(Stage primaryStage) {

        StackPane root = new StackPane();

        Scene titlePage = new Scene(root, 1000, 750);

        //Creates the start button
        startBtn = new Button();
        startBtn.setText("Start New Game");
        startBtn.setOnAction(this);
        startBtn.setStyle("-fx-font-size: 20px; ");
        startBtn.setTranslateY(140);

        //Creates a new image
        logo = new Image("file:monopolyLogo.png");

        //Allows the image to been seen and added to the scene
        ImageView iv = new ImageView();
        iv.setImage(logo);
        iv.setFitWidth(950);
        iv.setFitHeight(270);
        iv.setTranslateY(-70);

        //assigns previousScene a scene value for using the back button
        previousScene = titlePage;

        //Adds elements to the scene
        //Creates and displays the scene and stage
        primaryStage.setTitle("Monopoly");
        root.getChildren().addAll(startBtn, iv);
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

        //txt1 properties & modifications
        txt1.setStyle("-fx-font-size: 30px; ");
        txt1.setTranslateY(-100);

        //pName initialization and modifications
        pName = new TextField();
        pName.setStyle("-fx-font-size: 20px; ");
        pName.setMaxSize(400, 20);

        //playerName Button initialization and modifications
        playerName = new Button();
        playerName.setText("Enter");
        playerName.setOnAction(this);
        playerName.setStyle("-fx-font-size: 20px; ");
        playerName.setTranslateX(270);

        Text txt2 = new Text("No more than 15 characters");
        txt2.setTranslateY(-50);
        
        
        //Adds JavaFX nodes/elements to the StackPane
        root.getChildren().addAll(txt1, txt2, pName, playerName);

        //Displays the scene
        primaryStage.setScene(playerCreationPage);
    }

    //Method for making the token selection page
    public void tokenSelectionScene(Stage primaryStage) {

        StackPane root = new StackPane();

        //Creation and modifications for FlowPane
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

    //Method for playing and starting the game as well as showing the board
    public void boardScene(Stage primaryStage){
        main = new StackPane();
        
        StackPane dicePane = new StackPane();
                
        playerInfoBar();
                
        diceBlock1.setFitHeight(50);
        diceBlock1.setFitWidth(50);
        diceBlock1.setTranslateX(-30);
        diceBlock1.setTranslateY(-50);
        
        diceBlock2.setFitHeight(50);
        diceBlock2.setFitWidth(50);
        diceBlock2.setTranslateX(30);
        diceBlock2.setTranslateY(-50);
        
        rollBtn = new Button();
        rollBtn.setText("Roll Dice");
        rollBtn.setOnAction(this);
        rollBtn.setStyle("-fx-font-size: 15px; ");
        
        dicePane.getChildren().addAll(diceBlock1, diceBlock2, rollBtn);
        dicePane.setTranslateX(125);
        dicePane.setTranslateY(-75);
                
        ImageView boardImg = new ImageView(monopolyBoard);
        boardImg.setFitWidth(750);
        boardImg.setFitHeight(750);
        boardImg.setTranslateX(125);
        
        main.getChildren().addAll(boardImg, playerInfo, dicePane);
        
        if(start){
            playerStart();
            start = false;
        }
        
        Scene boardScene = new Scene(main, 1000, 750);
        
        primaryStage.setScene(boardScene);
        primaryStage.setTitle("Monopoly");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
    
    public void playerInfoBar(){
        StackPane[] playerInfoBox;
        playerInfoBox = new StackPane[numPlayers];
        
        playerInfo = new StackPane();
        
        for (int i = 0; i < numPlayers; i++) {
            playerInfoBox[i] = new StackPane();
            
            Text pNameTxt = new Text();
            pNameTxt.setText(players.get(i).getName() + "\n$" + Integer.toString(players.get(i).getMoney()));
            pNameTxt.setTranslateX(65);
            pNameTxt.setTranslateY(-65);
            pNameTxt.setStyle("-fx-font-size: 15px; ");
                        
            ImageView pToken = new ImageView(players.get(i).getToken());
            pToken.setFitHeight(50);
            pToken.setFitWidth(50);
            pToken.setTranslateX(5);
            pToken.setTranslateY(-50);
            
            ImageView inJail = new ImageView(inJailIMG);
                inJail.setTranslateX(180);
                inJail.setTranslateY(-65);
                 
            if(players.get(i).isInJail()){
                playerInfoBox[i].getChildren().add(inJail);
            }

            playerInfoBox[i].setMaxSize(250, 187.5);
            playerInfoBox[i].setAlignment(Pos.CENTER_LEFT);
            playerInfoBox[i].setStyle("-fx-border-color:black; -fx-background-color:lightgray; -fx-border-width: 3; -fx-border-style: solid;");
            playerInfoBox[i].getChildren().addAll(pNameTxt, pToken);
        }
        
        for (int i = 0; i < numPlayers; i++) {
            playerInfoBox[i].setTranslateY(187.5*i);
            playerInfo.getChildren().add(playerInfoBox[i]);
        }
        
        playerInfo.setAlignment(Pos.TOP_LEFT);
    }
    
    public void playerStart(){    

        for (int i = 0; i < numPlayers; i++) {
            playerTokens.get(i).setFitHeight(60);
            playerTokens.get(i).setFitWidth(60);
            
            playerTokens.get(i).setTranslateX(450);
            playerTokens.get(i).setTranslateY(325);
            
            main.getChildren().add(playerTokens.get(i));
        }
        counter3 = 0;
    }
    
    public void playerMovement(int roll, Player player){
        if (player.getSpace() < 10) {
            playerTokens.get(player.getPlayerNumber()-1).setTranslateX(playerTokens.get(player.getPlayerNumber()-1).getTranslateX()-63);
            
        } else if (player.getSpace() < 20) {
            playerTokens.get(player.getPlayerNumber()-1).setTranslateY(playerTokens.get(player.getPlayerNumber()-1).getTranslateY()-63);
            
        } else if (player.getSpace() < 30) {
            playerTokens.get(player.getPlayerNumber()-1).setTranslateX(playerTokens.get(player.getPlayerNumber()-1).getTranslateX() + 63);
            
        } else if (player.getSpace() < 40) {
            playerTokens.get(player.getPlayerNumber()-1).setTranslateY(playerTokens.get(player.getPlayerNumber()-1).getTranslateY() + 63);
        }
        player.move();
        roll--;
        if (roll > 0) {
            playerMovement(roll, player);
        }
    }  

    //Method for handling button and any events
    @Override
    public void handle(ActionEvent event) {
        //Starts the game and opens number of players selection scene
        if(event.getSource() == startBtn){
            numPlayersScene(window);

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
            Player user = new Player(pName.getText(), tempToken);
            players.add(user);

            counter += 1;

            if (counter < numPlayers) {
                playerCreationScene(window);
            } else if (counter == numPlayers) {
                tokenSelectionScene(window);
                counter2 = 0;
            }

        } else if (event.getSource() == carBtn) {
            players.get(counter2).setToken(car);
            playerTokens.add(new ImageView(players.get(counter2).getToken()));
            counter2 += 1;
            if (counter2 < numPlayers) {
                tokenSelectionScene(window);
            } else if (counter2 == numPlayers) {
                boardScene(window);
            }
        } else if (event.getSource() == horseBtn) {
            players.get(counter2).setToken(horse);
            playerTokens.add(new ImageView(players.get(counter2).getToken()));
            counter2 += 1;
            if (counter2 < numPlayers) {
                tokenSelectionScene(window);
            } else if (counter2 == numPlayers) {
                boardScene(window);
            }
        } else if (event.getSource() == planeBtn) {
            players.get(counter2).setToken(paperPlane);
            playerTokens.add(new ImageView(players.get(counter2).getToken()));
            counter2 += 1;
            if (counter2 < numPlayers) {
                tokenSelectionScene(window);
            } else if (counter2 == numPlayers) {
                boardScene(window);
            }
        } else if (event.getSource() == penguinBtn) {
            players.get(counter2).setToken(penguin);
            playerTokens.add(new ImageView(players.get(counter2).getToken()));
            counter2 += 1;
            if (counter2 < numPlayers) {
                tokenSelectionScene(window);
            } else if (counter2 == numPlayers) {
                boardScene(window);
            }
        } else if (event.getSource() == scottTerrBtn) {
            players.get(counter2).setToken(scottTerr);
            playerTokens.add(new ImageView(players.get(counter2).getToken()));
            counter2 += 1;
            if (counter2 < numPlayers) {
                tokenSelectionScene(window);
            } else if (counter2 == numPlayers) {
                boardScene(window);
            }
        } else if (event.getSource() == shipBtn) {
            players.get(counter2).setToken(ship);
            playerTokens.add(new ImageView(players.get(counter2).getToken()));
            counter2 += 1;
            if (counter2 < numPlayers) {
                tokenSelectionScene(window);
            } else if (counter2 == numPlayers) {
                boardScene(window);
            }
        }else if(event.getSource() == rollBtn){
            
            userDice1 = rng.nextInt(6) + 1;//Rolls dice
            userDice2 = rng.nextInt(6) + 1;
            
            if(counter3 >= numPlayers){
                counter3 = 0;
            }
            
            playerMovement((userDice1 + userDice2), players.get(counter3));
                        
            switch (userDice1) {
                case 1:
                    diceBlock1.setImage(block_1);
                    break;
                case 2:
                    diceBlock1.setImage(block_2);
                    break;
                case 3:
                    diceBlock1.setImage(block_3);
                    break;
                case 4:
                    diceBlock1.setImage(block_4);
                    break;
                case 5:
                    diceBlock1.setImage(block_5);
                    break;
                case 6:
                    diceBlock1.setImage(block_6);
                    break;
                default:
                    break;
            }
            switch (userDice2) {
                case 1:
                    counter3 += 1;
                    diceBlock2.setImage(block_1);
                    break;
                case 2:
                    counter3 += 1;
                    diceBlock2.setImage(block_2);
                    break;
                case 3:
                    counter3 += 1;
                    diceBlock2.setImage(block_3);
                    break;
                case 4:
                    counter3 += 1;
                    diceBlock2.setImage(block_4);
                    break;
                case 5:
                    counter3 += 1;
                    diceBlock2.setImage(block_5);
                    break;
                case 6:
                    counter3 += 1;
                    diceBlock2.setImage(block_6);
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
