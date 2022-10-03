/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import DTO.Ban;
import DTO.ThucDon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tranbathien
 */
public class dbUtil {
<<<<<<< HEAD
    public static Connection getConnection() {
     Connection conn = null;
     String url = "jdbc:sqlserver://localhost:1433;databaseName=qlcafe";
=======
    public static Connection conn = null;
     public static Connection getConnection() {
     
     String url = "jdbc:sqlserver://localhost:1433;databaseName=Coffee2";
     String user = "sa";
     String password ="sa";
>>>>>>> Cafe/master
     try {
  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    conn = DriverManager.getConnection(url);
  if (conn != null)
  {
      System.out.println("Ket noi thanh cong");
  }
     } catch (Exception e) {
         System.out.println("Ket noi that bai");
     }
     return conn;
}
public ArrayList<ThucDon> GetThucDon(){
        ArrayList<ThucDon> arrThucDon = null;
        String sql;
 
            sql = "Select * From Product";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<ThucDon>();
            while(rs.next()){
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrThucDon.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return arrThucDon;        
    }
public ArrayList<Ban> GetBan(){
        ArrayList<Ban> arrBan = null;
        String sql;
            sql = "Select * From Ban";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrBan = new ArrayList<Ban>();
            while(rs.next()){
                Ban sp = new Ban(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                arrBan.add(sp);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrBan; 
    } 
}
