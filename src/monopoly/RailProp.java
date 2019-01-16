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
public class RailProp extends Properties{
    
    public int []rent= new int[]{50,100,150,200}; 
    public RailProp(String name, int position) {
        super(name, position, 200);
    }

    @Override
    void event(Player p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
