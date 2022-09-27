/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GUI.Home_GUI;
import GUI.login_GUI;
import java.io.IOException;


/**
 *
 * @author ThangIKCU
 */
public class Run {
    public static Home_GUI QlCafe;
    public static login_GUI frmlg;
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        lg();
    }
    public static void lg() throws IOException{
        frmlg = new login_GUI();
        frmlg.setVisible(true);       
    }  
    public static void QLCF(){
        QlCafe = new Home_GUI();
        QlCafe.setVisible(true);       
    }
   
   
}
