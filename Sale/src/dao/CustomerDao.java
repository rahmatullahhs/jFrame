
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.DataBaseUtil;


public class CustomerDao {
   
    DataBaseUtil util=new DataBaseUtil();
    PreparedStatement ps;
    public void saveCustomer( String name,String cell,String email,String address){
    
    String sql=" insert into customer(name,cell,email,address) values(?,?,?,?)";
        try {
            ps=util.getCon().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, cell);
            ps.setString(3, email);
            ps.setString(4, address);
            
            ps.executeUpdate();
            
            ps.close();
            util.getCon().close();
            JOptionPane.showMessageDialog(null, "Customer details saved successfylly");
            
            
            
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Customer details not saved");
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
