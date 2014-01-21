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
public interface Location extends Remote{
    public int getColClient() throws RemoteException;
    public int getRowClient() throws RemoteException;
    public int getValueClient() throws RemoteException;
    public void setValueClient(int value) throws RemoteException;
    public void setRowClient(int row) throws RemoteException;
    public void setColClient(int col) throws RemoteException;
//    public Location locationServer(int row, int col, int value) throws RemoteException;
}
