
package UserControl;

import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.Dimension;
/**
 *
 * @author tranbathien
 */
public class ScrollbarCustom extends JScrollBar{
    public ScrollbarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(48, 144, 216));
        setBackground(Color.WHITE);
    }
}
