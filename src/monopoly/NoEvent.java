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
public class NoEvent extends Tiles{
    public String eventSaying;
    
    
    public NoEvent(String name, int position, String eventSaying) {
        super(name, position);
        this.eventSaying = eventSaying;
    }
    
    @Override
    void event(Player p, ArrayList<Player> listP){
        System.out.println(eventSaying);
    }
}
