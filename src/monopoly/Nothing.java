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
public class Nothing extends EventTiles{
    public String eventSaying;
    
    
    public Nothing(String name, int position, String eventSaying) {
        super(name, position);
        this.eventSaying = eventSaying;
    }
    
    @Override
    void event(Player p){
        System.out.println(eventSaying);
    }
}
