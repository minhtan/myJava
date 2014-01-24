package Game;


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
public class TheGame {
    
    public void hostGame(int side){
        Data data;
        while( gameGoOn() ){
//            data = nwCtrl.receiveData();
//            System.out.println("Row: " + data.getRow());
//            System.out.println("Col: " + data.getCol());
//            System.out.println("Data received");
//            break;
        }
    }
    
    public void joinGame(String hostIP){       
        Data data = new Data(1, 2);
        while( gameGoOn() ){
//            nwCtrl.sendData(data);
//            System.out.println("Data sent");
//            break;
        }
    }
    
    private boolean gameGoOn(){
        return true;
    }
}
