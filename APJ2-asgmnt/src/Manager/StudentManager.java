/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Manager;

import DatabaseLayer.DatabaseDriver;
import DatabaseLayer.StudentTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;
import javax.sql.rowset.spi.SyncProviderException;

/**
 *
 * @author tan
 */
public class StudentManager {
    private DatabaseDriver dbDriver;
    private StudentTableModel stdTblMdl;
    //private CachedRowSet studentRowSet;
    private CachedRowSetImpl studentRowSet;

    public StudentManager(DatabaseDriver dbDriver) {
        this.dbDriver = dbDriver;
    }

    public void listStudent() throws SQLException{
        this.studentRowSet = this.dbDriver.selectFrom("Students");
        this.stdTblMdl = new StudentTableModel(this.studentRowSet);
    }

    public StudentTableModel getStdTblMdl() {
        return this.stdTblMdl;
    }
    
    public void insertRow(){
        try {
            this.studentRowSet.moveToInsertRow();
            this.studentRowSet.updateString("Name", "New Student");
            this.studentRowSet.updateString("Address", "New Student address");
            this.studentRowSet.updateString("Tel_no", "New Student tel");
            this.studentRowSet.updateString("DOB", "1987-12-30");
            this.studentRowSet.updateString("Sex", "M");
            
            this.studentRowSet.insertRow();
            this.studentRowSet.moveToCurrentRow();
        } catch (SQLException e) {
            e.printStackTrace();
//            do {
//                System.out.println("SQLState:" + e.getSQLState());
//                System.out.println("Error Code:" + e.getErrorCode());
//                System.out.println("Message:" + e.getMessage());
//                Throwable t = e.getCause();
//                while (t != null) {
//                    System.out.println("Cause:" + t);
//                    t = t.getCause();
//                }
//                e = e.getNextException();
//            } while (e != null);
        }
    }
    
    public void update(){
        try {
            this.studentRowSet.acceptChanges();
        } catch (SyncProviderException ex) {
            Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
