/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Util.dbUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author lenha
 */
public class SanPhamTho {
    int maSanPhan=0;
    String tenSanPham="";
    int soLuong=0;
    String donViTinh="";
    int GiaTien=0;

    public SanPhamTho() {
    }

    public int getMaSanPhan() {
        return maSanPhan;
    }

    public void setMaSanPhan(int maSanPhan) {
        this.maSanPhan = maSanPhan;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(int GiaTien) {
        this.GiaTien = GiaTien;
    }
    
     public static boolean DeleteSanPham(int maSP){
        boolean check = false;
        Connection conn = dbUtil.getConnection();
          String sql = "Delete From SanPhamTho Where MaSanPham = "+maSP;
        try{     
                Statement st = conn.createStatement();
                st.executeUpdate(sql);
                 JOptionPane.showMessageDialog(new JFrame(), "Xóa món thành công");
                check = true;
                dbUtil.CloseConnection(conn);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(new JFrame(), "lỗi xóa món");
        }
        return check;
    }
   public static int InsertSanPham(String TenSP, String Loai, int GiaTien){
        int insert = 0;
         Connection conn = dbUtil.getConnection();
        String sql = "Insert into ThucDon (TenThucDon, Loai, GiaTien, HinhAnh) values (N'"+TenSP+"', N'"+Loai+"', "+GiaTien+",null)";
        try{
            Statement st = conn.createStatement();
            insert = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(new JFrame(), "Thêm món thành công");
            dbUtil.CloseConnection(conn);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(new JFrame(), "Thêm món không thành công :(");
        }
        return insert;
    }
    
   public static int EditThucDon(int maMon,String TenMon, String Loai, int GiaTien){
        int insert = 0;
         Connection conn = dbUtil.getConnection();
        String sql = "Update ThucDon set TenThucDon= N'"+TenMon+"', Loai=N'"+Loai+"', GiaTien= "+GiaTien+" where IDThucDon ="+maMon;
        try{
            Statement st = conn.createStatement();
            insert = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(new JFrame(), "Sửa món thành công");
            dbUtil.CloseConnection(conn);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(new JFrame(), "Sửa món không thành công :(");
        }
        return insert;
    }
}
