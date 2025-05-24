/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package showcrud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.database;

/**
 *
 * @author Admin
 */
public class ShowCrud {

    static database db=new database();
    static PreparedStatement ps;
    static String sql = "";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        saveProduct("PC", "afganisthan", 6500000f);
//           saveProduct("Keybord", "mirpur", 150500f);
//            saveProduct("Mouse", "germany", 50500f);
//             saveProduct("Monitor", "brazil", 950500f);
//              saveProduct("Cable", "canada", 88000f);
//               saveProduct("starlink", "Russia", 1590500f);
//        System.out.println("After Save");
        
        showAllProduct();
        System.out.println("--------------------------------");
        
        deletProduct(7);
        System.out.println("after delete");
        
        showAllProduct();
        System.out.println("--------------------------------");
        
        updateProduct(1, "Mobile", "france", 45000f);
        System.out.println("after update");
        
        showAllProduct();
        System.out.println("--------------------------------");
        
        
        
        
        
        
        
        
        
    }
    
    public static void saveProduct(String product, String shipping, float price){
    
    sql="insert into productdetails(product,shipping,price)values(?,?,?)";
    
        try {
            ps=db.getCon().prepareStatement(sql);
            ps.setString(1, product);
            ps.setString(2, shipping);
            ps.setFloat(3, price);

            ps.executeUpdate();
            ps.close();
            db.getCon().close();
System.out.println("Data Save");
            System.out.println("------------------------------");
            
        } catch (SQLException ex) {
            Logger.getLogger(ShowCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
     public static void showAllProduct() {
        sql = "select * from productdetails";
        try {
            ps=db.getCon().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String product = rs.getString("product");
                String shipping = rs.getString("shipping");
                float price = rs.getFloat("price");
                System.out.println("ID: " + id + "product: " + product + "shipping: " + shipping + "price: " + price);
            }
            rs.close();
            ps.close();
            db.getCon().close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ShowCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     }
    
    
      public static void deletProduct(int id) {

        sql = "delete from productdetails where id=?";
        
        try {
            ps=db.getCon().prepareStatement(sql);
            
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            db.getCon().close();
        
        } catch (SQLException ex) {
            Logger.getLogger(ShowCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
      } 
        
    public static void updateProduct(int id, String product, String shipping, float price) {
        sql = "update productdetails set product=?, shipping=?, price=? where id=?";    
        
        try {
            ps=db.getCon().prepareStatement(sql);
            ps.setString(1, product);
            ps.setString(2, shipping);
            ps.setFloat(3, price);
            ps.setInt(4, id);

            ps.executeUpdate();
            ps.close();
            db.getCon().close();
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ShowCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
        
        
        
        
      }
     
    
