/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tan
 */
public final class StudentTableModel extends DefaultTableModel{  
    private ArrayList<Student> studentList;
    private String[] studentProperties;

    public StudentTableModel(ArrayList<Student> studentList, String[] studentProperties) {
        super();
        this.studentList = studentList;
        this.studentProperties = studentProperties;
        this.populate();
    }
    
    public void populate(){
        for (String studentProperty : this.studentProperties) {
            this.addColumn(studentProperty);
        }
        for (Student student : this.studentList){
            this.addRow(new Object[]{
                student.getId(),
                student.getName(),
                student.getAddress(),
                student.getTelNo(),
                student.getDob(),
                ( student.getSex() != 0 ? (student.getSex() == 1 ? "Male" : "Female") : null)
            });
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
    
    public void updateRowAt(int i, Student student){
        this.removeRow(i);
        this.insertRow(
                i, 
                new Object[]{
                    student.getId(),
                    student.getName(),
                    student.getAddress(),
                    student.getTelNo(),
                    student.getDob(),
                    (student.getSex() != 0 ? (student.getSex() == 1 ? "Male" : "Female") : null)
                }
        );
    }
    
    public void addRow(Student student){
        this.addRow(new Object[]{
            student.getId(),
            student.getName(),
            student.getAddress(),
            student.getTelNo(),
            student.getDob(),
            (student.getSex() != 0 ? (student.getSex() == 1 ? "Male" : "Female") : null)
        });
    }
}
