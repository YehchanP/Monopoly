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

/**
 *
 * @author 324745561
 */
public class Monopoly {

    /**
     * @param args the command line arguments
     */
//    static String[] tiles = new String[40];
    static ArrayList<Tiles> board = new ArrayList<>(40);

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        Random rng = new Random();
        int userDice1 = 0;
        int userDice2 = 0;
        int roll = 0;
        String response = "s";

//        readTiles(tiles);
        
        System.out.println("Enter the number of players");
        int numOfPlayers = Integer.parseInt(in.next());
        ArrayList<Player> p = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Enter name for player " + (i + 1));
            String nameTemp = in.next();
            System.out.println("Enter token for player " + (i + 1));
            String tokenTemp = in.next();
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
                            System.out.println(p.get(currentP).getName() + " is now at " + board.get(p.get(currentP).getSpace()).name);
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
                    System.out.println(p.get(currentP).getName() + " is now at " + board.get(p.get(currentP).getSpace()).name);
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
        System.out.println(player.getName() + " is now passing " + board.get(player.getSpace()).name);
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

//    public static void readTiles(String[] tiles) {
//        try {
//            BufferedReader BR = new BufferedReader(new FileReader("Tiles.txt"));
//            String line = "";
//            line = BR.readLine();
//            int i = 0;
//            while (line != null) {
//                tiles[i] = line;
//                line = BR.readLine();
//                i++;
//            }
//            BR.close();
//        } catch (IOException e) {
//            System.err.format("Error reading file");
//        }
//    }
    
    public static void createTiles(){
        
        
        
        try {//Creates properties
            
            BufferedReader BR = new BufferedReader(new FileReader("Properties.txt"));
            int pos = 0;
            String line = "";
            pos = BR.read();
            line = BR.readLine();
            while (line != null) {
                Tiles temp = null;
                if (pos <= 1) {
                    temp = new HouseProp(line, pos, 60, 2, "brown", 2, 10, 30, 90, 160, 250, 50);
                } else if (pos <= 3) {
                    temp = new HouseProp(line, pos, 60, 2, "brown", 4, 20, 60, 180, 320, 450, 50);
                } else if (pos <= 5) {
                    temp = new RailProp(line, pos);
                } else if (pos <= 8) {
                    temp = new HouseProp(line, pos, 100, 3, "light blue", 6, 30, 90, 270, 400, 550, 50);
                } else if (pos <= 9) {
                    temp = new HouseProp(line, pos, 120, 3, "light blue", 8, 40, 100, 300, 450, 600, 50);
                } else if (pos <= 11) {
                    temp = new HouseProp(line, pos, 140, 3, "pink", 10, 50, 150, 450, 625, 750, 100);
                } else if (pos <= 12) {
                    //Temporary for the electric company
                    temp = new HouseProp(line, pos, 150, 2, "util", 30, 30, 50, 50, 25, 50, 100000);
                } else if (pos <= 13) {
                    temp = new HouseProp(line, pos, 140, 3, "pink", 10, 50, 150, 450, 625, 750, 100);
                } else if (pos <= 14) {
                    temp = new HouseProp(line, pos, 160, 3, "pink", 12, 60, 180, 500, 700, 900, 100);
                } else if (pos <= 15) {
                    temp = new RailProp(line, pos);
                } else if (pos <= 18) {
                    temp = new HouseProp(line, pos, 180, 3, "orange", 14, 70, 200, 550, 750, 950, 100);
                } else if (pos <= 19) {
                    temp = new HouseProp(line, pos, 180, 3, "orange", 16, 80, 220, 600, 800, 1000, 100);
                } else if (pos <= 23) {
                    temp = new HouseProp(line, pos, 220, 3, "red", 18, 90, 250, 700, 875, 1050, 150);
                } else if (pos <= 24) {
                    temp = new HouseProp(line, pos, 240, 3, "red", 20, 100, 300, 750, 925, 1100, 150);
                } else if (pos <= 25) {
                    temp = new RailProp(line, pos);
                } else if (pos <= 27) {
                    temp = new HouseProp(line, pos, 260, 3, "yellow", 22, 110, 330, 800, 975, 1100, 150);
                } else if (pos <= 28) {
                    //Temporary for the water works
                    temp = new HouseProp(line, pos, 150, 2, "util", 30, 30, 50, 50, 25, 50, 100000);
                } else if (pos <= 29) {
                    temp = new HouseProp(line, pos, 260, 3, "yellow", 22, 110, 330, 800, 975, 1100, 150);
                } else if (pos <= 32) {
                    temp = new HouseProp(line, pos, 300, 3, "green", 26, 130, 390, 900, 1100, 1275, 200);
                } else if (pos <= 34) {
                    temp = new HouseProp(line, pos, 320, 3, "green", 28, 150, 450, 1000, 1200, 1400, 200);
                } else if (pos <= 35) {
                    temp = new RailProp(line, pos);
                } else if (pos <= 37) {
                    temp = new HouseProp(line, pos, 350, 2, "dark blue", 35, 175, 500, 1100, 1300, 1500, 200);
                } else if (pos <= 39) {
                    temp = new HouseProp(line, pos, 350, 2, "dark blue", 35, 175, 500, 1100, 1300, 1500, 200);
                }

                board.set(pos, (Tiles) temp);
                line = BR.readLine(); 
            }
            BR.close();
        } catch (IOException e) {
            System.err.format("Error reading file");
        }
        
    }
}
