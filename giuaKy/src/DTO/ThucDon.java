/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author ThangIKCU
 */
public class ThucDon {
    private String MaMon;
    private String TenMon;
    private String Loai; 
    private int DonGia;
   
   
    
    public ThucDon(){
        this.MaMon="";
        this.TenMon="";
        this.Loai="";
        this.DonGia=0;
    }
    public ThucDon(String mamon, String ten, String loai, int gia, String dvt){
        this.MaMon=mamon;
        this.TenMon=ten;
        this.Loai=loai;
        this.DonGia=gia;       
    }

    public ThucDon(String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public void SetLoai(String maloai){
        this.Loai=maloai;
    }
    public String GeLoai(){
        return this.Loai;
    }
    public void SetDonGia(int gia){
        this.DonGia=gia;
    }
    public int GetDonGia(){
        return this.DonGia;
    }
 
  public static boolean DeleteThucDon(int maTD){
        boolean check = false;
        Connection conn = dbUtil.getConnection();
          String sql = "Delete From ThucDon Where IDThucDon = "+maTD;
        try{     
                Statement st = conn.createStatement();
                st.executeUpdate(sql);
                System.err.println("Xoa thanh cong");
                check = true;
                dbUtil.CloseConnection(conn);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(new JFrame(), "lỗi xóa món");
        }
        return check;
    }
   public static int InsertThucDon(String TenMon, String Loai, int GiaTien){
        int insert = 0;
         Connection conn = dbUtil.getConnection();
        String sql = "Insert into ThucDon (TenThucDon, Loai, GiaTien, HinhAnh) values ('"+TenMon+"', '"+Loai+"', '"+GiaTien+"')";
        try{
            Statement st = conn.createStatement();
            insert = st.executeUpdate(sql);
            dbUtil.CloseConnection(conn);
        }catch(SQLException ex){
        }
        return insert;
    }
    

}
