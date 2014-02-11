
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Administrator
 */
public class RemoteImplementation extends UnicastRemoteObject implements RemoteInterface{
    public RemoteImplementation() throws RemoteException {
    }

    @Override
    public String doWork(String aString) throws RemoteException {
        aString = aString.toUpperCase();
        return aString;
    }
}
