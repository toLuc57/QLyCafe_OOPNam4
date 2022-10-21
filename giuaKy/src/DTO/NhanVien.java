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
    boolean isAdmin;
    
    public NhanVien(String MaNhanVien, String HoTen, String NgaySinh, String DiaChi, String SDT, String Matkhau, boolean isAdmin) {
        this.MaNhanVien = MaNhanVien;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Matkhau = Matkhau;
        this.isAdmin = isAdmin;
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

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
     public static int InsertNhanVien(int maNV, String hoTen, String ngaySinh, String diaChi, String SDT, String Matkhau, int isAdmin ){
        int insert = 0;
        Connection conn = dbUtil.getConnection();
        String sql = "Insert into NhanVien (MaNhanVien, HoTen, NgaySinh, DiaChi, SDT, Matkhau, isAdmin) values ('"+maNV+"','"+hoTen+"', '"+ngaySinh+"','"+diaChi+"','"+SDT+"','"+Matkhau+"','"+isAdmin+"')";
        try{
            Statement st = conn.createStatement();
            insert = st.executeUpdate(sql);
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
                System.err.println("Xoa thanh cong");
                check = true;
                dbUtil.CloseConnection(conn);
        }catch(SQLException ex){
            
        }
        return check;
    }
}
