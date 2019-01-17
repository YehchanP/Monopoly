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
public abstract class Properties extends Tiles{

    public int cost;
    public int amountOwned = 0;
    public int totalAmount;
    public boolean monopoly = false;
    public int owner = -1;
    private String colour;
    
    public Properties(String name, int position, int cost, int totalAmount, String colour) {
        super(name, position);
        this.cost = cost;
        this.totalAmount = totalAmount;
        this.colour = colour;
    }

    
    
}
