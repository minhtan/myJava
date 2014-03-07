/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

//import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author Tan
 */
public class DatabaseDriver {
    private String server;
    private String username;
    private String psw;
    private CachedRowSetImpl crs;

    public DatabaseDriver(String server, String username, String psw) throws SQLException {
        this.server = server;
        this.username = username;
        this.psw = psw;
        
        this.crs = new CachedRowSetImpl();
        //this.crs = RowSetProvider.newFactory().createCachedRowSet();
        this.crs.setUrl("jdbc:sqlserver://" + this.server + ";Database=db_student");
        this.crs.setUsername(this.username);
        this.crs.setPassword(this.psw);
    }
    
    public CachedRowSetImpl selectFrom(String table) throws SQLException{
        CachedRowSetImpl newCrs = new CachedRowSetImpl();
        //CachedRowSet newCrs = RowSetProvider.newFactory().createCachedRowSet();
        newCrs.setUrl("jdbc:sqlserver://" + this.server + ";Database=db_student");
        newCrs.setUsername(this.username);
        newCrs.setPassword(this.psw);
        newCrs.setCommand("SELECT * FROM" + " " + table);
        newCrs.execute();
        return newCrs;
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
