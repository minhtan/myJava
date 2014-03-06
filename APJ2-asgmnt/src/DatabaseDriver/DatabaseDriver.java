/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseDriver;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Tan
 */
public class DatabaseDriver {
    private String server;
    private String username;
    private String psw;
    private CachedRowSet crs;

    public DatabaseDriver(String server, String username, String psw) {
        this.server = server;
        this.username = username;
        this.psw = psw;
        try {
            this.crs = new CachedRowSetImpl();
            this.crs.setUrl("jdbc:sqlserver://" + this.server + ";Database=db_student");
            this.crs.setUsername(this.username);
            this.crs.setPassword(this.psw);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDriver.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public CachedRowSet selectFrom(String table){
        try {
            this.crs.setCommand("SELECT * FROM" + " " + table);
            this.crs.execute();
            return this.crs;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDriver.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }  
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
    
}
