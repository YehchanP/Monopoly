/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 324745561
 */
public class HouseProp extends Properties{
    Scanner in = new Scanner(System.in);
    private int rent[] = new int[5];
    private int houseCost;
    private int amountOfHouses = 0;
    
    
    public HouseProp(String name, int position, int cost, int totalAmount, String colour, int rent, int rent1, int rent2, int rent3, int rent4, int rent5, int hCost) {
        super(name, position, cost, totalAmount, colour);
        
    }

    public int[] getRent() {
        return rent;
    }

    public int getHouseCost() {
        return houseCost;
    }
    
    public void buyHouse(Player p) {
        if (this.monopoly) {
            p.loseMoney(houseCost);
            this.amountOfHouses++;
        }
    }
    
    @Override
    void event(Player p, ArrayList<Player> listP) {
        if(this.owner<0){
            System.out.println("Would you like to purchase "+this.name+" for $"+this.cost);
            System.out.println("Your current balance is $"+p.getMoney());
            String response = in.nextLine();
            if(response.equalsIgnoreCase("yes")){
                p.loseMoney(this.cost);
                owner = p.getPlayerNumber();
            }
        }else{
            if(owner != p.getPlayerNumber()){//If the current player does not own the owned property
                
                int trueOwner = 0;//Finding the real owner
                for (int i = 0; i < listP.size(); i++) {
                    if(listP.get(i).getPlayerNumber()==owner){
                        trueOwner = listP.get(i).getPlayerNumber();
                        break;
                    }
                }
                int currentRent = 0;
                if(!this.monopoly){
                    currentRent = rent[0];
                }else{
                    currentRent = rent[amountOfHouses];
                    if(amountOfHouses==0){
                        currentRent = currentRent*2;
                    }
                }
                p.loseMoney(currentRent);//Steal money for rent
                
                listP.get(trueOwner).addMoney(currentRent);//Collect Rent money
            }
        }
    }
    
}
