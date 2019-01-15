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
public class HouseProp extends Properties{
    
    public int rent[] = new int[5];
    public int houseCost;
    
    public HouseProp(String name, int position, int cost, int rent, int rent1, int rent2, int rent3, int rent4, int rent5, int hCost) {
        super(name, position, cost);
        
    }

    @Override
    void event(Player p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
