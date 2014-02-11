
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
public class RMIServer{
    public static void main(String[] args) {
        try {
            RemoteImplementation rmtImpl = new RemoteImplementation();
            Registry registry = LocateRegistry.createRegistry(RemoteInterface.port);
            Naming.rebind("rmi://localhost:" + RemoteInterface.port + "/rmi", rmtImpl);
            System.out.println("Server running");
        } catch (RemoteException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
