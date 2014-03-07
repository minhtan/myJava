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
import javax.sql.rowset.spi.SyncProviderException;

/**
 *
 * @author tan
 */
public class StudentManager {
    private DatabaseDriver dbDriver;
    private StudentTableModel stdTblMdl;
    private CachedRowSet studentRowSet;

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
            this.studentRowSet.insertRow();
            this.studentRowSet.moveToCurrentRow();
        } catch (SQLException e) {
            do {
                System.out.println("SQLState:" + e.getSQLState());
                System.out.println("Error Code:" + e.getErrorCode());
                System.out.println("Message:" + e.getMessage());
                Throwable t = e.getCause();
                while (t != null) {
                    System.out.println("Cause:" + t);
                    t = t.getCause();
                }
                e = e.getNextException();
            } while (e != null);
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
