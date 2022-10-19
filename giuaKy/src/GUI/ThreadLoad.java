
package GUI;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tranbathien
 */
public class ThreadLoad extends Thread{

    @Override
    public void run() {
        synchronized(this){
            login_GUI l;
            try {
                l = new login_GUI();
                l.setVisible(true);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadLoad.class.getName()).log(Level.SEVERE, null, ex);
            }
            notify();
        }
        
    }
    
}
