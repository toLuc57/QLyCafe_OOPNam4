
package Util;

import DTO.ChiTietHD;
import DTO.Loai;
import DTO.ThucDon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class dbUtil {
    public static Connection getConnection() {
     Connection conn = null;
     String url = "jdbc:sqlserver://localhost:1433;databaseName=qlcafe";
     String user = "sa";
     String password ="sa";
     try {
  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    conn = DriverManager.getConnection(url,user,password);
  if (conn != null)
  {
      System.out.println("Ket noi thanh cong");
  }
     } catch (Exception e) {
         System.out.println("Ket noi that bai");
     }
     return conn;
}
}
