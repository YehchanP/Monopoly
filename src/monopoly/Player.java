package monopoly;

import java.util.ArrayList;

public class Player {

    private int space = 0;
    private int money = 1500;
    private String name;
    private String token;
    private boolean inJail = false;
    private int turnsInJail = 0;
    private ArrayList<Properties> own = new ArrayList<>();
    private int playerNumber;//This is going to be used for ownership
    private static int amountOfPlayers = 0;

    public Player(String name, String token) {
        this.name = name;
        this.token = token;
        amountOfPlayers++;
        this.playerNumber = amountOfPlayers;
    }

    public int getSpace() {
        return space;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public boolean isInJail() {
        return inJail;
    }

    public int getTurnsInJail() {
        return this.turnsInJail;
    }

    public ArrayList<Properties> getOwn() {
        return own;
    }

    public void toJail() {
        System.out.println("Go to jail");
        this.setSpace(10);
        this.inJail = true;
    }

    public void leaveJail() {
        this.inJail = false;
        this.turnsInJail = 0;
    }

    public void endTurnInJail() {
        this.turnsInJail++;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void payPerson(Player other, int val) {
        this.loseMoney(val);
        other.addMoney(val);
    }

    public void addMoney(int val) {
        money += val;
    }

    public boolean loseMoney(int val) {
        money -= val;
        return (this.money > 0);
    }

    public void move() {
        space++;
        if (space >= 40) {
            this.addMoney(200);
            space = 0;
        }
    }

    public void addProp(Properties prop) {
        this.own.add(prop);
        
        //Updating amount owned by that player
        int amountOwn = 0;
        for (int i = 0; i < this.getOwn().size(); i++) {
            if (this.getOwn().get(i).getColour().equals(prop.getColour())) {
                amountOwn++;
            }
        }
        for (int i = 0; i < this.getOwn().size(); i++) {
            if (this.getOwn().get(i).getColour().equals(prop.getColour())) {
                prop.amountOwned=amountOwn;
            }
        }
        if (amountOwn == prop.getTotalAmount()) {
            for (int i = 0; i < this.getOwn().size(); i++) {
                if (this.getOwn().get(i).getColour().equals(prop.getColour())) {
                    this.getOwn().get(i).monopoly = true;
                }
            }
        }
        for (int i = 0; i < own.size(); i++) {
            for (int j = 0; j < own.size() - i; j++) {
                if ((j + 1) < own.size() && own.get(j).getPosition() > own.get(j + 1).getPosition()) {
                    
                    Properties temp = own.get(j);
                    
                    own.set(j, own.get(j + 1));
                    
                    own.set(j + 1, temp);
                }
            }
        }
        
        
    }

    public void removeProp(int pos) {
        for (int i = 0; i < this.own.size(); i++) {//Linear search
            if (this.own.get(i).getPosition() == pos) {
                this.own.remove(i);
            }
        }
    }
}
