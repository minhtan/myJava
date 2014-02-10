package Game;


import GameCore.*;
import SocketNetwork.*;
import SwingInterface.GameInterface;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class TheGame{
    private GameController gameCtrl;
    private NetworkController networkCtrl;
    private GameInterface swing;
    private Player player;
    private Data data;
    public static final Object lock = new Object();
    
    public static void main(String args[]) { 
        TheGame game = new TheGame();
        game.swing = new GameInterface();
        Thread swingThread = new Thread(game.swing);
        swingThread.start();     
               
        synchronized (TheGame.lock) {
            try {
                TheGame.lock.notify();
                TheGame.lock.wait();          
            } catch (InterruptedException ex) {
                Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            switch (game.swing.getPlayerNo()) {
                case 1:
                    game.hostGame(game.swing.getSide());
                    break;
                case 2:
                    game.joinGame(game.swing.getHostIP());
                    break;
                default:
                    break;
            }
        }
    }

    public TheGame() {
        this.networkCtrl = new NetworkController();
        this.data = new Data(0, 0);
    }
    
    public void hostGame(int side){
        this.player = new Player(1);       
        this.networkCtrl.openConnection();
        this.data.setCol(side);
        this.networkCtrl.sendData(this.data);
        this.gameCtrl = new GameController(side);
        
        synchronized(TheGame.lock){
            try {
                TheGame.lock.notify();
                TheGame.lock.wait();
                  
            } catch (InterruptedException ex) {
                Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        while( gameGoOn() ){
            System.out.println("host successfully");
            break;
        }
        
        this.networkCtrl.closeConnection();
    }
    
    public void joinGame(String hostIP){      
        this.player = new Player(2);
        this.networkCtrl.connect(hostIP);
        this.data = networkCtrl.receiveData();
        this.gameCtrl = new GameController(data.getCol());
        this.swing.setSide(data.getCol());
        
        synchronized (TheGame.lock) {
            try {
                TheGame.lock.notify();
                TheGame.lock.wait();

            } catch (InterruptedException ex) {
                Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        while( gameGoOn() ){
            System.out.println("join successfully");
            break;
        }
        
        this.networkCtrl.closeConnection();
    }
    
    private boolean gameGoOn(){
        return true;
    }
    
}
