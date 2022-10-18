
package UserControl;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author tranbathien
 */
public class showFormAddUpdate {
    JDialog dialog;
    int margin = 2;
    public showFormAddUpdate(JFrame fram, JPanel pan){
        dialog = new JDialog(fram);
        dialog.setUndecorated(true);
        dialog.setFocusableWindowState(false);
        dialog.add(pan);
        dialog.setSize(pan.getPreferredSize());
        dialog.setLocation(fram.getWidth()+fram.getX()-dialog.getWidth()-margin,fram.getY()+margin);  
    }
    public void show(){
        dialog.show();
    }
    public void hide(){
        dialog.hide();
    }
    
}
