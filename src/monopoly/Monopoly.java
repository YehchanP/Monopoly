/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

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

        readTiles(tiles);

        System.out.println("Enter the number of players");
        int numOfPlayers = Integer.parseInt(in.next());
        Player[] p = new Player[numOfPlayers];
        for (int i = 0; i < p.length; i++) {
            System.out.println("Enter name for player " + (i + 1));
            String nameTemp = in.next();
            System.out.println("Enter token for player " + (i + 1));
            String tokenTemp = in.next();
            Player pTemp = new Player(nameTemp, tokenTemp);
            p[i] = pTemp;
            pTemp.setName(nameTemp);
        }

        int currentP = 0;
        String rolling = "no";
        boolean doub = false;
        int doubleCount = 0;
        while (!response.equalsIgnoreCase("save")) {//Game plays while no one says yes at the end of their turn

            do {//Rolls either the first time or doubles

                do {//Force to roll
                    System.out.println("Type 'roll' to roll, " + p[currentP].getName());
                    rolling = in.next();
                } while (!rolling.equalsIgnoreCase("roll"));//Doesn't yet players leave until they say they want to roll

                userDice1 = rng.nextInt(6) + 1;//Rolls dice
                userDice2 = rng.nextInt(6) + 1;

                System.out.println(p[currentP].getName() + " rolled " + userDice1 + " " + userDice2);//Outputs roll
                roll = userDice1 + userDice2;//Adds the value of the roll

                if (userDice1 == userDice2) {//Checks for doubles
                    doubleCount++;
                    if (doubleCount != 3) {//If they rolled a total of 3 doubles in their turn, go to jail for speeding
                        System.out.println("DOUBLES");
                        doub = true;
                    } else {//If they have 3 doubles it loads the jail event
                        doub = false;
                        doubleCount = 0;
                        p[currentP].toJail();
                        System.out.println(p[currentP].getName() + " is now at " + tiles[p[currentP].getSpace()]);
                    }
                } else {
                    doub = false;
                    doubleCount = 0;
                }

                if (!p[currentP].isInJail()) {
                    movement(roll, p[currentP]);
                    System.out.println(p[currentP].getName() + " is now at " + tiles[p[currentP].getSpace()]);
                }
                
                System.out.println(p[currentP].getName()+" has $"+p[currentP].getMoney());
                
                
                System.out.println("Type 'save' to quit");
                if (!doub) {
                    System.out.println("Type anything else to pass the turn");
                    currentP++;
                    if (currentP >= p.length) {
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
