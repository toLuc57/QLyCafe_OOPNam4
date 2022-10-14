/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import DTO.Ban;
import DTO.ThucDon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tranbathien
 */
public class dbUtil {

    public static Connection conn = null;

    public static Connection getConnection() {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=TheCoffee";
        String user = "sa";
        String password = "sa";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Ket noi thanh cong");

            }
        } catch (Exception e) {
            System.out.println("Ket noi that bai");
        }

        return conn;
    }

    public static void CloseConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Ngat ket noi");
            }

        } catch (Exception e) {

        }

    }

    public static ResultSet ThucThiSelect(String sql) throws SQLException {
        Statement st;
        try {
            st = conn.createStatement();
            System.out.println("Thuc Thi Lenh thanh cong");

            return st.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println("Loi thuc thi lenh");
        }

        return null;
    }

    public ArrayList<ThucDon> GetThucDon(String txt, String loai) {

        ArrayList<ThucDon> arrThucDon = null;
        String sql;
        sql = "Select * From ThucDon where TenThucDon like '%" + txt + "%'";
        if (!loai.equals("All")) {
            String phanloai = " and Loai = N'" + loai + "'";
            sql += phanloai;
        }
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<>();
            while (rs.next()) {
                ThucDon td = new ThucDon(rs.getString("IDThucDon"), rs.getString("TenThucDon"), rs.getString("Loai"), rs.getInt("GiaTien"), rs.getString("HinhAnh"));
                arrThucDon.add(td);

            }
            CloseConnection(conn);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return arrThucDon;
    }

    public List<String> GetLoaiThucDon() {
        String Loai = "";
        List<String> ls = new ArrayList<>();
        Connection conn = dbUtil.getConnection();
        String sql = "Select distinct Loai from ThucDon";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ls.add("All");
            while (rs.next()) {
                ls.add(rs.getString("Loai"));
            }

        } catch (SQLException ex) {
            System.out.println("Loi Get Loai Thuc Don");
        }
        return ls;
    }

    public ArrayList<Ban> GetBan() {
        ArrayList<Ban> arrBan = null;
        String sql;
        sql = "Select * From Ban";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrBan = new ArrayList<Ban>();
            while (rs.next()) {
                Ban sp = new Ban(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                arrBan.add(sp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetBan");
        }
        return arrBan;
    }

}
