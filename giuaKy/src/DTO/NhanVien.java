/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Util.dbUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author lenha
 */
public class NhanVien {
    static String MaNhanVien="";
    static String HoTen="";
    static String NgaySinh="";
    static String DiaChi="";
    static String SDT="";
    static String Matkhau="";
    static String Email="";
    static String GioiTinh="";

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        NhanVien.Email = Email;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        NhanVien.GioiTinh = GioiTinh;
    }
    boolean isAdmin;
    
    public NhanVien(String MaNhanVien, String HoTen, String NgaySinh, String DiaChi, String SDT, String Matkhau, boolean isAdmin, String Email, String GioiTinh) {
        this.MaNhanVien = MaNhanVien;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Matkhau = Matkhau;
        this.isAdmin = isAdmin;
        this.Email = Email;
        this.GioiTinh = GioiTinh;
    }


    public NhanVien(){

}
    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setMatkhau(String Matkhau) {
        this.Matkhau = Matkhau;
    }

    public boolean getIsIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
     public static int InsertNhanVien( int MaNV, String hoTen, String ngaySinh, String diaChi, String SDT, String Matkhau, int isAdmin, String Email, String GioiTinh ){
        int insert = 0;
        Connection conn = dbUtil.getConnection();
        String sql = "Insert into NhanVien (MaNhanVien, HoTen, NgaySinh, DiaChi, SDT, Matkhau, isAdmin, Email, GioiTinh) values ("+MaNV+",N'"+hoTen+"', CONVERT(datetime,'"+ngaySinh+"',105),N'"+diaChi+"','"+SDT+"','"+Matkhau+"',"+isAdmin+",'"+Email+"',N'"+GioiTinh+"')";
        try{
            Statement st = conn.createStatement();
            insert = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(new JFrame(), "Thêm Nhân viên  thành công");
            dbUtil.CloseConnection(conn);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(new JFrame(), "Loi Insert Nhan Vien");
        }
        return insert;
    }
      public static boolean DeleteNhanVien(int MaNV){
        boolean check = false;
        Connection conn = dbUtil.getConnection();
          String sql = "Delete From NhanVien Where MaNhanVien = "+MaNV;
        try{     
                Statement st = conn.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(new JFrame(), "Xóa nhân viên thành công");
                check = true;
                dbUtil.CloseConnection(conn);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(new JFrame(), "Loi xóa nhân viên");
        }
        return check;
    }
      public static int EditNhanVien(String HoTenNhanVien, String NgaySinh, String DiaChi, String SDT, String Matkhau, int isAdmin, String GioiTinh, String Email, int maNhanVien){
        int insert = 0;
         Connection conn = dbUtil.getConnection();
        String sql = "Update NhanVien set HoTen= N'"+HoTenNhanVien+"', CONVERT(datetime,'"+NgaySinh+"',105), DiaChi= N'"+DiaChi+"', SDT= N'"+SDT+"',Matkhau= N'"+Matkhau+"',isAdmin= "+isAdmin+",GioiTinh= N'"+GioiTinh+"',Email= '"+Email+"' where MaNhanVien ="+maNhanVien;
        try{
            Statement st = conn.createStatement();
            insert = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(new JFrame(), "Sửa Nhân viên thành công");
            dbUtil.CloseConnection(conn);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(new JFrame(), "Sửa Nhân viên không thành công :(");
        }
        return insert;
    }
      
       public static int UpdateMatKhau(int manv, String newPass){
  int update = 0;
        Connection conn = dbUtil.getConnection();
        String sql = "update NhanVien set Matkhau = '"+newPass+"' where MaNhanVien ="+ manv;
        try {
            Statement st = conn.createStatement();
            update = st.executeUpdate(sql);
            dbUtil.CloseConnection(conn);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Lỗi Update Mật khẩu nhân viên");
        }
        return update;

  }
}
