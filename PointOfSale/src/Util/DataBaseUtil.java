package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {

    private Connection con = null;
    private String url = "jdbc:mysql://localhost:3306/pos";
    private String user = "root";
    private String password = "1234";
    private String driver = "com.mysql.cj.jdbc.Driver";

    public Connection getCon() {

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            java.util.logging.Logger.getLogger(DataBaseUtil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return con;
    }
}
