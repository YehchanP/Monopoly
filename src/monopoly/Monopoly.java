/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javafx.scene.image.*;

/**
 *
 * @author 324745561
 */
public class Monopoly {

    /**
     * @param args the command line arguments
     */
    static String[] tiles = new String[40];

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        Random rng = new Random();
        int userDice1 = 0;
        int userDice2 = 0;
        int roll = 0;
        String response = "s";
        Image tokenTemp = new Image("file:car.png");

        readTiles(tiles);

        System.out.println("Enter the number of players");
        int numOfPlayers = Integer.parseInt(in.next());
        ArrayList<Player> p = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Enter name for player " + (i + 1));
            String nameTemp = in.next();
            //System.out.println("Enter token for player " + (i + 1));
            //String tokenTemp = in.next();
            Player pTemp = new Player(nameTemp, tokenTemp);
            p.add(pTemp);
            pTemp.setName(nameTemp);
        }

        int currentP = 0;
        String rolling = "no";
        boolean doub = false;
        int doubleCount = 0;
        while (!response.equalsIgnoreCase("save")) {//Game plays while no one says yes at the end of their turn

            do {//Rolls either the first time or doubles
                
                if(!p.get(currentP).isInJail()) {//If they aren't in Jail, roll normally
                    do {//Force to roll
                        System.out.println("Type 'roll' to roll, " + p.get(currentP).getName());
                        rolling = in.next();
                    } while (!rolling.equalsIgnoreCase("roll"));//Doesn't yet players leave until they say they want to roll
                }else{//If they are in jail
                    do {//Force to roll or pay
                        System.out.println("Type 'roll' to roll, " + p.get(currentP).getName());
                        System.out.println("Or type 'pay' to pay to get out of jail");
                        rolling = in.next();
                    } while (!rolling.equalsIgnoreCase("roll")&&!rolling.equalsIgnoreCase("pay"));
                    if(rolling.equalsIgnoreCase("pay")||p.get(currentP).getTurnsInJail()==3){//Technically against the rules but the code becomes easier and a very rare case that it does not work. You would need to be in jail and lose (5/6) three times and be bankrupt
                        p.get(currentP).loseMoney(50);
                        p.get(currentP).leaveJail();
                    }
                }
                
                userDice1 = rng.nextInt(6) + 1;//Rolls dice
                userDice2 = rng.nextInt(6) + 1;

                System.out.println(p.get(currentP).getName() + " rolled " + userDice1 + " " + userDice2);//Outputs roll
                roll = userDice1 + userDice2;//Adds the value of the roll

                if (userDice1 == userDice2) {//Checks for doubles
                    if (!p.get(currentP).isInJail()) {
                        doubleCount++;
                        if (doubleCount != 3) {//If they rolled a total of 3 doubles in their turn, go to jail for speeding
                            System.out.println("DOUBLES");
                            doub = true;
                        } else {//If they have 3 doubles it loads the jail event
                            doub = false;                                                    
                            doubleCount = 0;
                            p.get(currentP).toJail();
                            System.out.println(p.get(currentP).getName() + " is now at " + tiles[p.get(currentP).getSpace()]);
                        }
                    }else{
                        p.get(currentP).leaveJail();
                    }
                } else {
                    if(p.get(currentP).isInJail()){
                        p.get(currentP).endTurnInJail();
                    }
                    doub = false;
                    doubleCount = 0;
                }

                if (!p.get(currentP).isInJail()) {
                    movement(roll, p.get(currentP));
                    System.out.println(p.get(currentP).getName() + " is now at " + tiles[p.get(currentP).getSpace()]);
                }
                
                System.out.println(p.get(currentP).getName()+" has $"+p.get(currentP).getMoney());
                
                
                System.out.println("Type 'save' to quit");
                if (!doub) {
                    System.out.println("Type anything else to pass the turn");
                    currentP++;
                    if (currentP >= p.size()) {
                        currentP = 0;
                    }
                } else {
                    System.out.println("Type anything else to roll again");
                }
                response = in.next();

            } while (doub);
        }
    }

    public static void movement(int roll, Player player) {

        //Psuedo code for animation thing. Movement animation should be based of this
        System.out.println(player.getName() + " is now passing " + tiles[player.getSpace()]);
        if (player.getSpace() < 10) {
            System.out.println(" horizontally left");
        } else if (player.getSpace() < 20) {
            System.out.println(" vertically up");
        } else if (player.getSpace() < 30) {
            System.out.println(" horizontally right");
        } else if (player.getSpace() < 40) {
            System.out.println(" vertically down");
        }
        player.move();
        roll--;
        if (roll > 0) {
            movement(roll, player);

        }
    }

    public static void readTiles(String[] tiles) {
        try {
            BufferedReader BR = new BufferedReader(new FileReader("Tiles.txt"));
            String line = "";
            line = BR.readLine();
            int i = 0;
            while (line != null) {
                tiles[i] = line;
                line = BR.readLine();
                i++;
            }
            BR.close();
        } catch (IOException e) {
            System.err.format("Error reading file");
        }
    }
}
