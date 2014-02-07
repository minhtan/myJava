package Game;


import GameCore.Player;
import SocketNetwork.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class TheGame implements Runnable{
    private NetworkController network;
    private Player player;
    private String input;
    
    @Override
    public void run() {
        if(this.player.getPlayer() == 1)
            this.hostGame(Integer.parseInt(this.input));
        else if(this.player.getPlayer() == 2)
            this.joinGame(input);
    }

    public TheGame(Player player, String input) {
        this.network = new NetworkController();
        this.player = player;
        this.input = input;
    }
    
    public void hostGame(int side){
        this.network.openConnection();
        
        while( gameGoOn() ){
            System.out.println("host successfully");
            break;
        }
        
        this.network.closeConnection();
    }
    
    public void joinGame(String hostIP){       
        this.network.connect(hostIP);
        
        while( gameGoOn() ){
            System.out.println("join successfully");
            break;
        }
        
        this.network.closeConnection();
    }
    
    private boolean gameGoOn(){
        return true;
    }
    
}
