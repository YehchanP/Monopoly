/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.ArrayList;

/**
 *
 * @author 324745561
 */
public abstract class Tiles {
    private String name;
    private int position;

    public Tiles(String name, int position) {
        this.name = name;
        this.position = position;
    }
    
    abstract void event(Player p, ArrayList<Player> listP);

    public String getName() {
        return name;
    }
<<<<<<< HEAD
=======

    public int getPosition() {
        return position;
    }
>>>>>>> parent of 4534f53... Merge branch 'master' of https://github.com/YehchanP/Monopoly
    
    
}
