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
public class CardTiles extends Tiles{
    public String[] cards;
    public CardTiles(String name, int position) {
        super(name, position);
    }

    @Override
    void event(Player p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
