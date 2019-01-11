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
public class Player {
    public int space = 0;
    private int money = 1500;
    private String name;
    private String token;
    private boolean inJail = false;
    public int turnsInJail = 0;
    
    public Player(String name, String token) {
        this.name = name;
        this.token = token;
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

    public boolean isInJail() {
        return inJail;
    }

    
    
    public void toJail(){
        System.out.println("Go to jail");
        this.setSpace(10);
        this.inJail = true;
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
    
    public void loseMoney(int val){
        money-=val;
    }
    
    public void move(){
        space++;
        if(space>=40){
            this.addMoney(200);
            space = 0;
        }
    }
    
    
    
}
