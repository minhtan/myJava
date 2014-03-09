/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Manager;

import Model.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tan
 */
public class StudentManager {
    private ResultSet rs;
    private ArrayList<Student> studentList;
    private String[] studentProperties;
    private int lastID;

    public StudentManager(ResultSet rs) throws SQLException {
        this.rs = rs;
        this.studentList = new ArrayList<>();
        this.studentProperties = new String[rs.getMetaData().getColumnCount()];
        for(int i=1; i<rs.getMetaData().getColumnCount()+1; i++){
            this.studentProperties[i-1] = rs.getMetaData().getColumnName(i);
        }       
    }
    
    public ArrayList<Student> listStudent() throws SQLException{
        while(this.rs.next()){
            Student student = new Student(
                    this.rs.getInt("Student_ID"),
                    this.rs.getString("Name"),
                    this.rs.getString("Address"),
                    this.rs.getString("Tel_no"),
                    this.rs.getString("DOB"),
                    (this.rs.getString("Sex") == null 
                            ? 0
                            : ( "M".equals(this.rs.getString("Sex")) || "m".equals(this.rs.getString("Sex")) ? 1 : 2 )
                    )
            );
            this.studentList.add(student); 
        }
        this.rs.close();
        this.lastID = this.getStudent(this.studentList.size()-1).getId();
        return this.studentList;
    }
    
    public Student getStudent(int i){
        return this.studentList.get(i);
    }
    
        
    public void addStudent(Student std){
        this.studentList.add(std);
        this.lastID ++;
    }
    
    public void updateStudentAt(int i, Student std){
        this.studentList.remove(i);
        this.studentList.add(i, std);
    }
    
    public void removeStudent(int i){
        this.studentList.remove(i);
    }
    
    public int getLastIndex(){
        return this.studentList.size()-1;
    }
    
    public String[] getStudentProperties() {
        return studentProperties;
    }
    
    public int getLastId(){
        return this.lastID;
    }
}
