/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apj.rmi.server;

import apj.rmi.libs.Conection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author tuong
 */
public class ConectionGame extends UnicastRemoteObject implements Conection{
    private String nameClient, nameServer;

    public void setValue(int value) {
        this.value = value;
    }
    private int value;

    public int getValue() {
        return value;
    }
    public ConectionGame() throws RemoteException {
        super();
    }
    
    @Override
    public String GetNameServer() throws RemoteException {
       return this.nameServer;
    }

    @Override
    public void SetNameServer(String nameServer) throws RemoteException {
        this.nameServer = nameServer;
    }

    @Override
    public String GetNameClient() throws RemoteException {
        return this.nameClient;
    }

    @Override
    public void SetNameClient(String nameClient) throws RemoteException {
        this.nameClient = nameClient;
    }


    
}
