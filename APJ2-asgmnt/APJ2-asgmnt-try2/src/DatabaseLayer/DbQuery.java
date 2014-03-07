/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tannm_b01522
 */
public class DbQuery { 
    private DbAccess dbAccess;

    public DbQuery(DbAccess dbAccess) {
        this.dbAccess = dbAccess;
    }
    
    public ResultSet selectFrom(String table) throws SQLException{
        Connection conn = this.dbAccess.getConnection();
        Statement stmn = conn.createStatement();
        
        ResultSet rs = stmn.executeQuery("SELECT * FROM " + table);
        return rs;
    }
    
//    public int insertTo(String table) throws SQLException{
//        Connection conn = this.dbAccess.getConnection();
//        PreparedStatement stmn = conn.prepareStatement(table);
//        
//        int result = stmn.executeUpdate();
//        return result;
//    }
}
