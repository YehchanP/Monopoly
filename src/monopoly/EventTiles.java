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
public abstract class EventTiles extends Tiles{

    public EventTiles(String name, int position) {
        super(name, position);
    }
    
   

    @Override
    void event() {
        System.out.println("Event Tile");
    }
    
}
