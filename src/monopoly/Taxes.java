package monopoly;

import java.util.ArrayList;

/**
 *
 * @author 324745561
 */
public class Taxes extends Tiles{
    public int tax;
    public Taxes(String name, int position, int tax) {
        super(name, position);
        this.tax = tax;
    }



    @Override
    void event(Player p, ArrayList<Player> listP) {
        System.out.println(p.getName()+" loses $"+tax+" to "+ this.getName());
        p.loseMoney(tax);
    }
}
