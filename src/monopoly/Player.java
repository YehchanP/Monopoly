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

    public void setToken(String token) {
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
    
    public void addProp(Properties prop){
        this.own.add(prop);
        
    }
    
    public void removeProp(int pos){
        for (int i = 0; i < this.own.size(); i++) {//Linear search
            if (this.own.get(i).getPosition()==pos){
                this.own.remove(i);
            }
        }
    }
}
