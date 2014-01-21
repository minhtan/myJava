
package Serverkarogame;

public class PlayerKaro {
    //PlayerKaro player;
    String namePlayer;
    int value;
    public PlayerKaro(){}
    public PlayerKaro(String namePlayer,int value){
        this.namePlayer = namePlayer;

        this.value = value;
    }
    
    public void setName(String name){
        this.namePlayer = namePlayer;
    }
    public String getName(){
        return this.namePlayer;
    }
    public void setValue(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
}
