
package UserControl;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.TableModel;

/**
 *
 * @author tranbathien
 */
public class TableCustom extends JTable{

    public TableCustom() {
        setBackground(new Color(0,0,0,0));
        getTableHeader().setFont(new Font("Roboto", Font.BOLD, 13));
        getTableHeader().setOpaque(false);
        getTableHeader().setBackground(new Color(32,136,203));
        getTableHeader().setForeground(new Color(255,255,255));
        setRowHeight(30);
        setFocusable(false);
    }
}
