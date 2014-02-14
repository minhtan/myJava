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
public class TheGame implements Runnable{
    private GameController gameCtrl;
    private NetworkController networkCtrl;
    private GameInterface swing;
    private Player player;
    private Data data;
    public static final Object lock = new Object();
    
    public static void main(String args[]) { 
        try {
            TheGame game = new TheGame();
            game.swing = new GameInterface();
            
            Thread swingThread = new Thread(game.swing);
            swingThread.start();
            
            Thread gameThread = new Thread(game);
            gameThread.start();
            
            gameThread.join();
            swingThread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void run() {
        synchronized(TheGame.lock){         
            try { 
                TheGame.lock.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        switch (this.swing.getPlayerNo()) {
            case 1:
                this.hostGame(this.swing.getSide());
                break;
            case 2:
                this.joinGame(this.swing.getHostIP());
                break;
            default:
                break;
        }
    }
    
    public TheGame() {
        this.networkCtrl = new NetworkController();
        this.data = new Data(0, 0, 0);
    }
    
    public void hostGame(int side){
        this.player = new Player(1);       
        this.networkCtrl.openConnection();
        this.data.setCol(side);
        this.networkCtrl.sendData(this.data);
        this.gameCtrl = new GameController(side);
        
        synchronized(TheGame.lock){
            TheGame.lock.notify();
            while (gameGoOn()) {
                try {
                    this.swing.setFlag(true);
                    TheGame.lock.wait();
                    
                    this.data = this.swing.getData();
                    this.gameCtrl.makeAMove(this.data.getRow(), this.data.getCol(), this.data.getPlayer());
                    this.networkCtrl.sendData(data);
                    
                    this.swing.setFlag(false);
                    this.data = this.networkCtrl.receiveData();
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        this.networkCtrl.closeConnection();
    }
    
    public void joinGame(String hostIP){      
        this.player = new Player(2);
        this.networkCtrl.connect(hostIP);
        this.data = networkCtrl.receiveData();
        this.gameCtrl = new GameController(this.data.getCol());
        this.swing.setSide(this.data.getCol());
        
        synchronized (TheGame.lock) {
            TheGame.lock.notify();
            while (gameGoOn()) {
                try {
                    this.swing.setFlag(false);
                    
                    this.data = this.networkCtrl.receiveData();
                    this.gameCtrl.makeAMove(this.data.getRow(), this.data.getCol(), this.data.getPlayer());
                    this.swing.getPlayField().getButton(this.data.getRow(), this.data.getCol()).update(this.data.getPlayer());
                    
                    this.swing.setFlag(true);
                    TheGame.lock.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
  
        this.networkCtrl.closeConnection();
    }
    
    private boolean gameGoOn(){
        return true;
    }
    
}
