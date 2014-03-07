/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SwingInterface;

import Manager.StudentManager;
import Model.StudentTableModel;
import java.sql.SQLException;
import javax.swing.JTable;
import static javax.swing.ListSelectionModel.*;

/**
 *
 * @author Tan
 */
public class StudentTable extends JTable{
    private StudentManager stdMng;
    private StudentTableModel stdTblMdl;
    
    public StudentTable(StudentManager stdMng) throws SQLException {
        this.stdMng = stdMng;
        this.stdTblMdl = new StudentTableModel(
                this.stdMng.listStudent(), 
                this.stdMng.getStudentProperties()
        );
        this.setModel(this.stdTblMdl);
        this.setSelectionMode(SINGLE_SELECTION);
    }    

    public StudentManager getStdMng() {
        return stdMng;
    }
    
    
}
