/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author tannm_b01522
 */
public class DbAccess {
    private String userName;
    private String password;
    private String serverName;

    public DbAccess(String userName, String password, String serverName) {
        this.userName = userName;
        this.password = password;
        this.serverName = serverName;
    }    
    
    public Connection getConnection() throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);
        String URL = "jdbc:sqlserver://" + this.serverName + ";Database=db_student";
        
        conn = DriverManager.getConnection(URL, connectionProps);
        
        return conn;
    }
    
}
    
