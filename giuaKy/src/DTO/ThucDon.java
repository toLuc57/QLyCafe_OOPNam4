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

/**
 *
 * @author ThangIKCU
 */
public class ThucDon {
    private String MaMon;
    private String TenMon;
    private String MaLoai; 
    private int DonGia;
    private String DVT;
   
    
    public ThucDon(){
        this.MaMon="";
        this.TenMon="";
        this.MaLoai="";
        this.DVT="";
        this.DonGia=0;
    }
    public ThucDon(String mamon, String ten, String maloai, int gia, String dvt){
        this.MaMon=mamon;
        this.TenMon=ten;
        this.MaLoai=maloai;
        this.DVT=dvt;
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
    public void SetMaLoai(String maloai){
        this.MaLoai=maloai;
    }
    public String GetMaLoai(){
        return this.MaLoai;
    }
    public void SetDonGia(int gia){
        this.DonGia=gia;
    }
    public int GetDonGia(){
        return this.DonGia;
    }
    public void SetDVT(String dvt){
        this.DVT=dvt;
    }
    public String GetDVT(){
        return this.DVT;
    }
    
    


}
