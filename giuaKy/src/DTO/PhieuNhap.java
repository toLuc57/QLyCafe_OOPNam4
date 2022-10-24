/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Util.dbUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author lenha
 */
public class PhieuNhap {
    int soPhieuNhap=0;
    String ngayNhap="";
    String tenSP="";
    int soLuong=0;

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    int tongTien=0;

    public PhieuNhap(int soPhieuNhap, String ngayNhap, int tongTien) {
        this.soPhieuNhap = soPhieuNhap;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }
    
    public PhieuNhap(){
    
    
    }

    public int getSoPhieuNhap() {
        return soPhieuNhap;
    }

    public void setSoPhieuNhap(int soPhieuNhap) {
        this.soPhieuNhap = soPhieuNhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
     public static int CreatePhieuNhap(int manv, double tongTien)
     {
        int insert = 0;
        Connection conn = dbUtil.getConnection();
        String sql = "Insert into PhieuNhap (NgayNhap, MaNhanVien, TongTien ) values (getdate(),"+manv+","+tongTien+")";
        try{
            Statement st = conn.createStatement();
            insert = st.executeUpdate(sql);
            dbUtil.CloseConnection(conn);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(new JFrame(), "Lỗi tạo phiếu nhập");
        }
        return insert;
    }
      public static int CreateChiTietPhieuNhap(int maSP, int soLuong)
     {
        int insert = 0;
        Connection conn = dbUtil.getConnection();
        String sql = "Insert into ChiTietNhap (SoPhieuNhap, MaSanPham, SoLuong ) values ((select max(SoPhieuNhap) from PhieuNhap),"+maSP+","+soLuong+")";
        try{
            Statement st = conn.createStatement();
            insert = st.executeUpdate(sql);
            dbUtil.CloseConnection(conn);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(new JFrame(), "Lỗi tạo chi tiết phiếu nhập");
        }
        return insert;
    }
        public static boolean DeletePhieuNhap(int soPhieuNhap){
        boolean check = false;
        Connection conn = dbUtil.getConnection();
          String sql = "Delete From ThucDon Where IDThucDon = "+soPhieuNhap;
        try{     
                Statement st = conn.createStatement();
                st.executeUpdate(sql);
                 JOptionPane.showMessageDialog(new JFrame(), "Xóa Phiếu thành công");
                check = true;
                dbUtil.CloseConnection(conn);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(new JFrame(), "lỗi xóa Phiếu");
        }
        return check;
    }
     
}
