package monopoly;

import java.util.ArrayList;

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
