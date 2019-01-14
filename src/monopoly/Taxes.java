/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

/**
 *
 * @author 324745561
 */
public class Taxes extends EventTiles{
    public int tax;
    public Taxes(String name, int position, int tax) {
        super(name, position);
        this.tax = tax;
    }
    


    @Override
    void event(Player p) {
        System.out.println(p.getName()+" loses $"+tax+" to "+name);
        p.loseMoney(tax);
    }
}
