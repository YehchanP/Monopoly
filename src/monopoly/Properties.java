package monopoly;

import java.util.ArrayList;

public class Properties extends Tiles{

    private int cost;
    public int amountOwned = 0;
    private int totalAmount;
    public boolean monopoly = false;
    public int owner = -1;
    private String colour;
    private boolean mortgage = false;
    
    public Properties(String name, int position, int cost, int totalAmount, String colour) {
        super(name, position);
        this.cost = cost;
        this.totalAmount = totalAmount;
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public int getCost() {
        return cost;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public boolean isMortgage() {
        return mortgage;
    }

    public void setMortgage(boolean mortgage) {
        this.mortgage = mortgage;
    }

    @Override
    void event(Player p, ArrayList<Player> listP) {
    }

    
    
}
