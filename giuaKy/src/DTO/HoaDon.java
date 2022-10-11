/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import GUI.Menu_GUI;
import Util.dbUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.Statement;
/**
 *
 * @author ThangIKCU
 */
public class HoaDon {
    private String TenMon, MaMon, DVT; 
    private int Gia, SoLuong, MaHoaDon, SoBan, TongTien, TrangThai;

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public int getSoBan() {
        return SoBan;
    }

    public void setSoBan(int SoBan) {
        this.SoBan = SoBan;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }
    String MaNhanVien;
    
    public HoaDon(){
        TenMon = MaMon = DVT = "";
        Gia = SoLuong = MaHoaDon = 0;
    }
    public HoaDon(String mamon, String tenmon, String dvt, int soluong, int gia, int mahd){
        MaMon = mamon;
        MaHoaDon = mahd;
        TenMon = tenmon;
        DVT = dvt;
        Gia= gia;
        SoLuong = soluong;
    }
    public void SetMaHD(int mahd){
        MaHoaDon = mahd;
    }
    public int GetMaHD(){
        return MaHoaDon;
    }    
    public void SetMaMon(String mamon){
        this.MaMon=mamon;
    }
    public String GetMaMon(){
        return this.MaMon;
    }
    public void SetTenMon(String ten){
        this.TenMon=ten;
    }
    public String GetTenMon(){
        return this.TenMon;
    }    
    public void SetDVT(String dvt){
        this.DVT=dvt;
    }
    public String GetDVT(){
        return this.DVT;
    }
    public void SetSoLuong(int soluong){
        SoLuong = soluong;
    }
    public int GetSoLuong(){
        return SoLuong;
    }
    public void SetGia(int gia){
        Gia = gia;
    }
    public int GetGia(){
        return Gia;
    }    
 public static int InsertHoaDon(int soban, String manv){
        int insert = 0;
        Connection cn = dbUtil.getConnection();
        String sql = "Insert into HoaDon (SoBan,TrangThai, MaNhanVien) values ("+soban+", 'false', "+manv+")";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(new JFrame(), "Loi Insert HoaDon");
        }
        return insert;
    }
  public static int InsertChiTietHoaDon(int mathucdon, int soluong, int tongtien){
        int insert = 0;
        Connection cn = dbUtil.getConnection();
        String sql = "Insert into ChiTietHoaDon (MaHoaDon,IDThucDon,SoLuong,TongTien) values ((select max(MaHoaDon) from HoaDon), '"+mathucdon+"', '"+soluong+"', '"+tongtien+"') ";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(new JFrame(), "Loi Insert HoaDon");
        }
        return insert;
    }
}
