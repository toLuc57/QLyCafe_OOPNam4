/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author lenha
 */
public class addMenu {
    String tenmon;
    int mamon,soluong;
    int gia;

    public addMenu(String tenmon, int mamon, int soluong, int gia) {
        this.tenmon = tenmon;
        this.mamon = mamon;
        this.soluong = soluong;
        this.gia = gia;
    }

    public addMenu() {
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getMamon() {
        return mamon;
    }

    public void setMamon(int mamon) {
        this.mamon = mamon;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
     
}
