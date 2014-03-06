/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Manager;

import DatabaseLayer.DatabaseDriver;
import DatabaseLayer.StudentTableModel;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;

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

    public StudentTableModel listStudent(){
        this.studentRowSet = this.dbDriver.selectFrom("Students");
        this.stdTblMdl = new StudentTableModel(this.studentRowSet);
        return this.stdTblMdl;
    }

    public StudentTableModel getStdTblMdl() {
        return this.stdTblMdl;
    }
    
}
