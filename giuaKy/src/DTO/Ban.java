/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author lenha
 */
public class Ban {
    String maBan;
    String loaiBan;
    int tinhTrang;
    int soLuongGhe;

    public Ban(String maBan, String loaiBan, int tinhTrang, int soLuongGhe) {
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
   

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
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

    public Ban(String maBan, String loaiBan, int soLuongGhe) {
        this.maBan = maBan;
        this.loaiBan = loaiBan;
        this.soLuongGhe = soLuongGhe;
    }


  

  
}
