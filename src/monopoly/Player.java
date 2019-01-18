package monopoly;

import javafx.scene.image.*;

public class Player {
    private int space = 0;
    private int money = 1500;
    private String name;
    private Image token;
    private boolean inJail = false;
    private int turnsInJail = 0;
    private int playerNumber;//This is going to be used for ownership
    private static int amountOfPlayers = 0;
    
    public Player(String name, Image token) {
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

    public Image getToken() {
        return token;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
    
    public boolean isInJail() {
        return inJail;
    }
    
    public int getTurnsInJail(){
        return this.turnsInJail;
    }
    
    public void toJail(){
        System.out.println("Go to jail");
        this.setSpace(10);
        this.inJail = true;
    }
    
    public void leaveJail(){
        this.inJail = false;
        this.turnsInJail = 0;
    }
    
    public void endTurnInJail(){
        this.turnsInJail++;
    }
    
    public void setSpace(int space) {
        this.space = space;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void Image(Image token) {
        this.token = token;
    }
    
    public void payPerson(Player other, int val){
        this.loseMoney(val);
        other.addMoney(val);
    }
    
    public void addMoney(int val){
        money+=val;
    }
    
    public boolean loseMoney(int val){
        money-=val;
        return (this.money>0);
    }
    
    public void move(){
        space++;
        if(space>=40){
            this.addMoney(200);
            space = 0;
        }
    }

    void setToken(Image car) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
