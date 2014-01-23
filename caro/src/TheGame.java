
import SocketNetwork.*;
import java.util.Scanner;

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
    public static void main(String[] args) {
        TheGame theGame = new TheGame();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1 for server | 2 for client");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                theGame.hostGame();
                break;
            case 2:
                theGame.joinGame();
                break;
            default:
                break;
        }
    }
    
    private void hostGame(){
        NetworkController nwCtrl = new NetworkController();
        boolean check = nwCtrl.openConnection();
        if(check)
            System.out.println("server ok");
        else
            System.out.println("server not ok");
        Data data;
        while( gameGoOn() ){
            data = nwCtrl.receiveData();
            System.out.println("Row: " + data.getRow());
            System.out.println("Col: " + data.getCol());
            System.out.println("Data received");
            break;
        }
        check = nwCtrl.closeConnection();
        if(check)
            System.out.println("close ok");
    }
    
    private void joinGame(){
        NetworkController nwCtrl = new NetworkController();
        boolean check = nwCtrl.connect("localhost");
        if(check)
            System.out.println("client ok");
        else
            System.out.println("client not ok");
        Data data = new Data(1, 2);
        while( gameGoOn() ){
            nwCtrl.sendData(data);
            System.out.println("Data sent");
            break;
        }
        check = nwCtrl.closeConnection();
        if(check)
            System.out.println("close ok");
    }
    
    private boolean gameGoOn(){
        return true;
    }
}
