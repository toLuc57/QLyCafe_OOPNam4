
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
    public static void main(String[] args) {
        lg();
    }
    public static void lg(){
        lg = new login_GUI();
        lg.setVisible(true);       
    }  
  
   
}
