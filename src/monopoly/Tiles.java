package monopoly;

import java.util.ArrayList;

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
    public int getPosition() {
        return position;
    }


}
