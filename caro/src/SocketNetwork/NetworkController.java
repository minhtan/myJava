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
    private ServerSocket svSoc = null;
    private Socket soc = null;
    private final int PORT = 7777;
    private ObjectInputStream objIn = null;
    private ObjectOutputStream objOut = null;
    
    public NetworkController(){
    }
    
    public boolean openConnection(){
        try {
            this.svSoc = new ServerSocket(this.PORT);
            this.soc = svSoc.accept();
            this.objOut = new ObjectOutputStream(new BufferedOutputStream ( this.soc.getOutputStream() ));
            this.objOut.flush();
            this.objIn = new ObjectInputStream(new BufferedInputStream ( this.soc.getInputStream() ));
            
            return true;
        } catch (IOException ex) {
            Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);  
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean connect(String hostIP){
        try {
            this.soc = new Socket(hostIP, this.PORT);
            this.objOut = new ObjectOutputStream(new BufferedOutputStream ( this.soc.getOutputStream() ));
            this.objOut.flush();
            this.objIn = new ObjectInputStream(new BufferedInputStream ( this.soc.getInputStream() ));  
            
            return true;
        } catch (UnknownHostException ex) {
            Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean closeConnection(){
        try {
            if(this.objIn != null)
                this.objIn.close();
            if(this.objOut != null)
                this.objOut.close();
            if(this.soc != null)
                this.soc.close();
            if(this.svSoc != null)
                this.svSoc.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean sendData(Data data){
        try {
            this.objOut.writeObject(data);
            this.objOut.flush();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Data receiveData(){
        Data data = null;
        try {
            data = (Data) this.objIn.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
