package monopoly;

import java.util.ArrayList;

public class RailProp extends Properties{
    
    public int []rent= new int[]{50,100,150,200}; 
    public RailProp(String name, int position) {
        super(name, position, 200, 4, "grey");
    }

    @Override
    void event(Player p, ArrayList<Player> listP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
