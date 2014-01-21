/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apj.rmi.server;

import apj.rmi.libs.Conection;
import apj.rmi.libs.Location;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author tuong
 */
public class LocationCell extends UnicastRemoteObject implements Location{
    private LocationCell locationServer;
    private int row, col, value;
    public LocationCell() throws RemoteException{}
    
    public LocationCell(int row, int col,int value) throws RemoteException {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    @Override
    public int getColClient() throws RemoteException {
        return col;
    }

    @Override
    public int getRowClient() throws RemoteException {
        return row;
    }

    @Override
    public int getValueClient() throws RemoteException {
        return value;
    }


//    @Override
//    public Location locationServer(int row, int col, int value) throws RemoteException {
//       return this.locationServer;
//    }

    @Override
    public void setValueClient(int value) throws RemoteException {
        this.value = value;
    }

    @Override
    public void setRowClient(int row) throws RemoteException {
        this.row = row;
    }

    @Override
    public void setColClient(int col) throws RemoteException {
        this.col = col;
    }

 

    
}
