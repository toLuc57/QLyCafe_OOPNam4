/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import GUI.Home_GUI;
import GUI.login_GUI;
import java.io.IOException;

/**
 *
 * @author lenha
 */
public class main {
   public static Home_GUI home;
    public static login_GUI lg;
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        lg();
    }
    public static void lg() throws IOException{
        lg = new login_GUI();
        lg.setVisible(true);       
    }  
  
   
}
