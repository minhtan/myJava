
import DatabaseLayer.DbAccess;
import DatabaseLayer.DbQuery;
import Manager.StudentManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tannm_b01522
 */
public class Test {
//    public static void main(String[] args) {
//        try {
//            // test DbAccess
//            DbAccess dbAccess = new DbAccess(
//                    "admin", 
//                    "admin123", 
//                    "TAN-PC\\SQLEXPRESS"
//            );        
//            Connection conn = dbAccess.getConnection();
//            // test DbQuery
//            DbQuery dbQuery = new DbQuery(dbAccess);
//            ResultSet rs = dbQuery.selectFrom("Students");
//            // test StudentManager
//            StudentManager stdMng = new StudentManager(rs);
//            for(int i=0; i<stdMng.getStudentProperties().length; i++){
//                System.out.println(i + " " + stdMng.getStudentProperties()[i] + " ");
//            }
//            
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            System.out.println("connection error");
//        }
//        
//    }
}
