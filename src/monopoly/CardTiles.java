package monopoly;

import java.util.ArrayList;
import java.util.Random;

public class CardTiles extends Tiles{

    public CardTiles(String name, int position) {
        super(name, position);
    }
    
    @Override
    void event(Player p, ArrayList<Player> listP) {
        Random rng = new Random();
        System.out.println("You stopped being a realtor for a bit to play the stock market, this went horribly wrong");
        System.out.println("Lose $50 and a random amount of money since you doubled down on a bad investment");
        int coin = rng.nextInt(2);
        do {
            p.loseMoney(50);
            System.out.println("Lost another $50");
            coin = rng.nextInt(2);
        } while (coin < 1);
    }

    void collectMoney(Player p, int amount){
        
    }
    
    void loseMoney(Player p, int amount){
        
    }
    
    void move(Player p, int position){
    
    }
    
    void moveBack(Player p){
    
    }
}
