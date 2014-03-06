/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingInterface;

import DatabaseDriver.*;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tan
 */
public class studentTableModel extends AbstractTableModel {

    private CachedRowSet studentsRowSet;
    private ResultSetMetaData metadata;
    private int noOfCol;
    private int noOfRow;
    private String[] headings;

    public studentTableModel(CachedRowSet rowSetArg) {
        try {
            this.studentsRowSet = rowSetArg;
            this.metadata = this.studentsRowSet.getMetaData();
            
            this.noOfCol = metadata.getColumnCount();
            this.headings = new String[this.noOfCol];

            this.studentsRowSet.beforeFirst();
            this.noOfRow = 0;
            while (this.studentsRowSet.next()) {
                this.noOfRow++;
            }
            this.studentsRowSet.beforeFirst();
            
            for(int i = 0; i < this.noOfCol; i ++){
                this.headings[i] = this.metadata.getColumnName(i+1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(studentTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return this.noOfRow;
    }

    @Override
    public int getColumnCount() {
        return this.noOfCol;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            this.studentsRowSet.absolute(rowIndex + 1);
            Object o = this.studentsRowSet.getObject(columnIndex + 1);
            if (o == null) {
                return null;
            } else {
                return o.toString();
            }
        } catch (SQLException e) {
            return e.toString();
        }
    }
}
