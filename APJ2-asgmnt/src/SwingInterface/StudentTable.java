/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SwingInterface;

import DatabaseLayer.StudentTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Tan
 */
public class StudentTable extends JTable{
    private StudentTableModel tm;
    private int selectedRow;

    public StudentTable(StudentTableModel tm) {
        this.tm = tm;
        this.setModel(tm);
        for (int i = 0; i < this.getColumnCount(); i++) {
            TableColumn columnTemp = this.getTableHeader().getColumnModel().getColumn(i);
            columnTemp.setHeaderValue(this.tm.getHeadings()[i]);
        }
        this.getTableHeader().setReorderingAllowed(false);
        
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    // do some action if appropriate column
                    System.out.println(row + " " + column);
                    //this.selectedRow = row;

            }
        });
    }
    
    public StudentTableModel getModel(){
        return this.tm;
    }
    
    
}
