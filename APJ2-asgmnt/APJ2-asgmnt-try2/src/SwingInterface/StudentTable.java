/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SwingInterface;

import Model.StudentTableModel;
import java.sql.SQLException;
import javax.swing.JTable;
import static javax.swing.ListSelectionModel.*;

/**
 *
 * @author Tan
 */
public class StudentTable extends JTable{

    public StudentTable(StudentTableModel stdTblMdl) throws SQLException {
        this.setModel(stdTblMdl);
        this.setSelectionMode(SINGLE_SELECTION);
    }    

}
