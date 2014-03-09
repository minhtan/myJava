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
import static java.sql.Types.*;

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
    
    public int insertToStudent(String name, String address, String tel, String dob, String sex) throws SQLException{
        Connection conn = this.dbAccess.getConnection();
        String query = "INSERT INTO Students (Name, [Address], Tel_no, DOB, Sex) VALUES(?,?,?,?,?)";
        
        PreparedStatement stmn = conn.prepareStatement(query);
        // check name
        if(name != null)
            stmn.setString(1, name);
        else
            stmn.setNull(1, VARCHAR);
        // check address
        if(address != null)
            stmn.setString(2, address);
        else
            stmn.setNull(2, VARCHAR);
        // check telephone
        if(tel != null){
            try{
                stmn.setInt(3, Integer.parseInt(tel));
            }catch(NumberFormatException e){
                stmn.setNull(3, INTEGER);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else
            stmn.setNull(3, INTEGER);
        // check dob
        if(dob != null)
            stmn.setString(4, dob);
        else
            stmn.setNull(4, DATE);
        // check sex
        if(sex != null)
            stmn.setString(5, sex);
        else
            stmn.setNull(5, VARCHAR);
        
        int result = stmn.executeUpdate();
        return result;
    }
    
    public int deleteRow(String table, String colName, String value) throws SQLException{
        Connection conn = this.dbAccess.getConnection();
        String query = "DELETE FROM " + table + " WHERE " + colName + " = " + value;
        
        Statement stmn = conn.createStatement();        
        
        int result = stmn.executeUpdate(query);
        return result;     
    }
    
    public int updateStudent(String name, String address, String tel, String dob, String sex, int id) throws SQLException{
        Connection conn = this.dbAccess.getConnection();
        String query = "UPDATE Students "
                + "SET Name = ?, "
                + "[Address] = ?, "
                + "Tel_no = ?, "
                + "DOB = ?, "
                + "Sex = ? "
                + "WHERE Student_ID = ?";
        
        PreparedStatement stmn = conn.prepareStatement(query);
        stmn.setInt(6, id);
        // check name
        if (name != null) {
            stmn.setString(1, name);
        } else {
            stmn.setNull(1, VARCHAR);
        }
        // check address
        if (address != null) {
            stmn.setString(2, address);
        } else {
            stmn.setNull(2, VARCHAR);
        }
        // check telephone
        if (tel != null) {
            try {
                stmn.setInt(3, Integer.parseInt(tel));
            } catch (NumberFormatException e) {
                stmn.setNull(3, INTEGER);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            stmn.setNull(3, INTEGER);
        }
        // check dob
        if (dob != null) {
            stmn.setString(4, dob);
        } else {
            stmn.setNull(4, DATE);
        }
        // check sex
        if (sex != null) {
            stmn.setString(5, sex);
        } else {
            stmn.setNull(5, VARCHAR);
        }

        int result = stmn.executeUpdate();
        return result;
    }

}
