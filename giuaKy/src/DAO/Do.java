/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Util.dbUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lenha
 */
public class Do {
     public static ResultSet ThucThiLenhSelect(String SQL) {
        try {
            Connection conn = dbUtil.getConnection();
            Statement st = conn.createStatement();
            return st.executeQuery(SQL);
        } catch (SQLException ex) {
            System.out.println("Loi truy van");
        }

        return null;
    }
}
