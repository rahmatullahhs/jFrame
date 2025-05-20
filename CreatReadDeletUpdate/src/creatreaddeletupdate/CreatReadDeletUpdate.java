
package creatreaddeletupdate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DataBaseUtil;


public class CreatReadDeletUpdate {
static DataBaseUtil db=new DataBaseUtil();
static PreparedStatement ps;
static String sql="";
    public static void main(String[] args) {
        
        saveEmp("Rahmat", "Rahmat@mail.com", 9999999f);
        System.out.println("After Save");
      
        
        
        
        
        
        
        
    }
    public static void saveEmp(String name,String email,float salary){
    
    sql="insert into employee(name,email,salary)values(?,?,?)";
    
    try {
        ps=db.getCon().prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setFloat(3, salary);
        
     ps.executeUpdate();
        ps.close();
        db.getCon().close();
   
         System.out.println("Data Save");
            System.out.println("------------------------------");
        
    } catch (SQLException ex) {
        Logger.getLogger(CreatReadDeletUpdate.class.getName()).log(Level.SEVERE, null, ex);
    }
    
 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
