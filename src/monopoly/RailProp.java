/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.ArrayList;

/**
 *
 * @author 324745561
 */
public class RailProp extends Properties{
<<<<<<< HEAD
    Scanner in = new Scanner(System.in);
    public int []rent= new int[]{50,100,150,200};
=======
    
    public int []rent= new int[]{50,100,150,200}; 
>>>>>>> parent of 2cc73db... Added method to remove and add properties to players
    public RailProp(String name, int position) {
        super(name, position, 200, 4, "grey");
    }

    @Override
    void event(Player p, ArrayList<Player> listP) {
<<<<<<< HEAD

        if(this.owner<0){
            System.out.println("Would you like to purchase "+this.getName()+" for $"+this.cost);
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
                        trueOwner = i;
                        break;
                    }
                }
                int currentRent = 0;
                currentRent = rent[this.amountOwned];
                p.loseMoney(currentRent);//Steal money for rent

                listP.get(trueOwner).addMoney(currentRent);//Collect Rent money
            }
        }

=======
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
>>>>>>> parent of 2cc73db... Added method to remove and add properties to players
    }

}
