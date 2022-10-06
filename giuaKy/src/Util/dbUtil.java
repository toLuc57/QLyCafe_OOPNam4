package Util;

import DTO.Ban;
import DTO.ThucDon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tranbathien
 */
public class dbUtil {
    public static Connection conn = null;
    public static Connection getConnection() {
        try {
            String hostName = "localhost";
            String sqlInstanceName = "SQLEXPRESS";
            String database = "Coffee";
            String userName = "sa";
            String password = "1234";
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Cấu trúc URL Connection dành cho SQLServer
            // Ví dụ:
            // jdbc:sqlserver://ServerIp:1433/SQLEXPRESS;databaseName=Coffee
            String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
                    + ";instance=" + sqlInstanceName + ";databaseName=" + database;
            
            conn = DriverManager.getConnection(connectionURL, userName,
                    password);
            return conn;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(dbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
    
public ArrayList<ThucDon> GetThucDon(){
        ArrayList<ThucDon> arrThucDon = null;
        String sql;
 
            sql = "Select * From Product";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<>();
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
            arrBan = new ArrayList<>();
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
