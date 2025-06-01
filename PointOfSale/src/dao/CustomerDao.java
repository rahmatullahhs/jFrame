/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Util.DataBaseUtil;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CustomerDao {
    
    DataBaseUtil util=new DataBaseUtil();
    PreparedStatement ps;
    public  void saveCustomer( String name,String cell,String email,String address) {
        
        String sql="insert into customerdetails (name,email,cell,address)values (?,?,?,?)";
        try {
            ps=util.getCon().prepareStatement(sql);
            ps.setString(1, name);
             ps.setString(2, email);
              ps.setString(3, cell);
               ps.setString(4, address);
               ps.executeUpdate();
               ps.close();
               util.getCon().close();
              JOptionPane.showMessageDialog(null,"Costomers details save successfully");
               
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Customer details not saved");
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
