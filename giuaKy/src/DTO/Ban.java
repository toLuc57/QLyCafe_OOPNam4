
package DTO;

import Util.dbUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Ban {
    int maBan=0;
    String loaiBan="";
    int tinhTrang;
    int soLuongGhe=0;
  




    public Ban(int maBan, String loaiBan, int tinhTrang, int soLuongGhe) {
        this.maBan = maBan;
        this.loaiBan = loaiBan;
        this.tinhTrang = tinhTrang;
        this.soLuongGhe = soLuongGhe;
      
    }

  
    
    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
   

    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public String getLoaiBan() {
        return loaiBan;
    }

    public void setLoaiBan(String loaiBan) {
        this.loaiBan = loaiBan;
    }

    public int getSoLuongGhe() {
        return soLuongGhe;
    }

    public void setSoLuongGhe(int soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
    }

    public Ban() {
    }

    public Ban(int maBan, String loaiBan, int soLuongGhe) {
        this.maBan = maBan;
        this.loaiBan = loaiBan;
        this.soLuongGhe = soLuongGhe;
    }


  public static int UpdateTrangThaiBan(int maBan){
  int update = 0;
        Connection conn = dbUtil.getConnection();
        String sql = "update Ban set TinhTrang = 0 where SoBan ="+ maBan;
        try {
            Statement st = conn.createStatement();
            update = st.executeUpdate(sql);
            dbUtil.CloseConnection(conn);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Loi Update Trang Thai Ban");
        }
        return update;

  }


  
}
