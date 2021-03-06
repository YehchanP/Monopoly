package monopoly;

import java.util.ArrayList;
import java.util.Scanner;

public class RailProp extends Properties{

    Scanner in = new Scanner(System.in);
    public int []rent= new int[]{50,100,150,200};


    public RailProp(String name, int position) {
        super(name, position, 200, 4, "grey");
    }

    @Override
    void event(Player p, ArrayList<Player> listP) {


        if(this.owner<0){
            System.out.println("Would you like to purchase "+this.getName()+" for $"+this.getCost());
            System.out.println("Your current balance is $"+p.getMoney());
            String response = in.nextLine();
            if(response.equalsIgnoreCase("yes")){
                p.loseMoney(this.getCost());
                p.addProp(this);
                owner = p.getPlayerNumber();
            }
        }else{
            if(owner != p.getPlayerNumber()&&!this.isMortgage()){//If the current player does not own the owned property

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

    }

}
