package Util;

import DTO.Ban;
import DTO.ThucDon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author tranbathien
 */
public class dbUtil {
    private static Connection conn;
    
    static {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=TheCoffee";
        String user = "sa";
        String password ="1234";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            e.printStackTrace();
            conn = null;
        }
    }
    public static Connection getConnection() {
        return conn;
    }
    public static void closeQuietly() {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
    public static ResultSet ThucThiSelect(String sql) throws SQLException{
        Statement st;
        try {
            st = conn.createStatement();
            System.out.println("Select thanh cong");
            return st.executeQuery(sql);               
        } catch (SQLException ex) {
            System.out.println("Loi thuc thi lenh");
        }
        conn.close();
        return null;
    }
     
public ArrayList<ThucDon> GetThucDon(String txt, String loai){
        ArrayList<ThucDon> arrThucDon = null;
        String sql;
        sql = "Select * From ThucDon where TenThucDon like '%"+txt+"%'";
        if(!loai.equals("All")){
            String phanloai = " and Loai = N'"+loai+"'";
            sql += phanloai;
        }
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<>();
            while(rs.next()){
                ThucDon td = new ThucDon(rs.getString("IDThucDon"), rs.getString("TenThucDon"), rs.getString("Loai"), rs.getInt("GiaTien"), rs.getString("HinhAnh"));
                arrThucDon.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return arrThucDon;        
    }
public List<String> GetLoaiThucDon(){
     String Loai = "";
     List<String> ls = new ArrayList<>();
      Connection conn = dbUtil.getConnection();
      String sql = "Select distinct Loai from ThucDon";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ls.add("All");
            while(rs.next()){
                ls.add(rs.getString("Loai"));
            }
           
            
        } catch (SQLException ex) {
            System.out.println("Loi Get Loai Thuc Don");
        }
        return ls;
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
                Ban sp = new Ban(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                arrBan.add(sp);
            }
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi GetBan");
        }
        return arrBan; 
    } 
}