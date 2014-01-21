/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apj.rmi.libs;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author tuong
 */
public interface Conection extends Remote {
    public String GetNameServer() throws RemoteException;
    public void SetNameServer(String nameServer) throws RemoteException;
    public String GetNameClient() throws RemoteException;
    public void SetNameClient(String nameClient) throws RemoteException;
}


