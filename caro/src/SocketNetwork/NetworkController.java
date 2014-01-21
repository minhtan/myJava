/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketNetwork;

import java.io.*;
import java.net.*;
import java.util.logging.*;

/**
 *
 * @author tannm_b01522
 */
public class NetworkController {
    private ServerSocket svSoc;
    private Socket soc;
    private int PORT = 7777;
    private BufferedInputStream is;
    private BufferedOutputStream os;
    
    public NetworkController(){
    }
    
    public boolean openConnection(){
        try {
            this.svSoc = new ServerSocket(this.PORT);
            this.soc = svSoc.accept();
            this.is = new BufferedInputStream(this.soc.getInputStream());
            this.os = new BufferedOutputStream(this.soc.getOutputStream());
            
            return true;
        } catch (IOException ex) {
            Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);  
        }
        return false;
    }
    
    public boolean connect(String hostIP){
        try {
            this.soc = new Socket(hostIP, this.PORT);
            this.is = new BufferedInputStream(this.soc.getInputStream());
            this.os = new BufferedOutputStream(this.soc.getOutputStream());
            
            return true;
        } catch (UnknownHostException ex) {
            Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean sendData(int[] pos){
        
        return false;
    }
}
