package creatreaddeletupdate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DataBaseUtil;

public class CreatReadDeletUpdate {

    static DataBaseUtil db = new DataBaseUtil();
    static PreparedStatement ps;
    static String sql = "";

    public static void main(String[] args) {

        saveEmp("Raza", "raza@mail.com", 65000f);
        System.out.println("After Save");
        
        showAllEmp();
        System.out.println("--------------------------------");
        
        deletEmp(7);
        System.out.println("after delete");
        
        showAllEmp();
        System.out.println("--------------------------------");
        
        updateEmp(1, "RahmatUllah", "Rahmat@mail.com", 45000f);
        System.out.println("after update");
        
        showAllEmp();
        System.out.println("--------------------------------");

    }

    public static void saveEmp(String name, String email, float salary) {

        sql = "insert into employee(name,email,salary)values(?,?,?)";

        try {

            ps = db.getCon().prepareStatement(sql);
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

    public static void showAllEmp() {
        sql = "select * from employee";

        try {
            ps = db.getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                float salary = rs.getFloat("salary");
                System.out.println("ID: " + id + "Name: " + name + "Email: " + email + "Salary: " + salary);
            }
            rs.close();
            ps.close();
            db.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(CreatReadDeletUpdate.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public static void deletEmp(int id) {

        sql = "delete from employee where id=?";
        try {
            ps = db.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            db.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(CreatReadDeletUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateEmp(int id, String name, String email, float salary) {
        sql = "update employee set name=?, email=?, salary=? where id=?";
        try {
            ps = db.getCon().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setFloat(3, salary);
            ps.setInt(4, id);

            ps.executeUpdate();
            ps.close();
            db.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(CreatReadDeletUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
