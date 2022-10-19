
package UserControl;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author tranbathien
 */
public class TableDark extends JTable{
    private TableDarkHeader header;
    private TableDarkCell cell;

    public TableDark() {
        header = new TableDarkHeader();
        cell = new TableDarkCell();
        getTableHeader().setDefaultRenderer(header);
        getTableHeader().setPreferredSize(new Dimension(0, 35));
        setDefaultRenderer(Object.class, cell);
        setRowHeight(40);
        setOpaque(false);
        setBackground(Color.WHITE);
    }

    public void setColumnAlignment(int column, int align) {
        header.setAlignment(column, align);
    }

    public void setCellAlignment(int column, int align) {
        cell.setAlignment(column, align);
    }

    public void setColumnWidth(int column, int width) {
        getColumnModel().getColumn(column).setPreferredWidth(width);
        getColumnModel().getColumn(column).setMinWidth(width);
        getColumnModel().getColumn(column).setMaxWidth(width);
        getColumnModel().getColumn(column).setMinWidth(10);
        getColumnModel().getColumn(column).setMaxWidth(10000);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.setVerticalScrollBar(new ScrollbarCustom());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(248, 211, 202));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(new Color(0,0,0));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(248, 232, 233), 2));
    }

    private class TableDarkHeader extends DefaultTableCellRenderer {

        private Map<Integer, Integer> alignment = new HashMap<>();

        public void setAlignment(int column, int align) {
            alignment.put(column, align);
        }

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
            Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            com.setBackground(new Color(248, 211, 202));
            com.setForeground(new Color(0,0,0));
            com.setFont(com.getFont().deriveFont(Font.BOLD, 12));
            if (alignment.containsKey(i1)) {
                setHorizontalAlignment(alignment.get(i1));
            } else {
                setHorizontalAlignment(JLabel.LEFT);
            }
            return com;
        }
    }

    private class TableDarkCell extends DefaultTableCellRenderer {

        private Map<Integer, Integer> alignment = new HashMap<>();

        public void setAlignment(int column, int align) {
            alignment.put(column, align);
        }

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row, int column) {
            Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, row, column);
            if (isCellSelected(row, column)) {
                if (row % 2 == 0) {
                    com.setBackground(new Color(122, 207, 245));
                    
                } else {
                    com.setBackground(new Color(204, 225, 246));
                }
            } else {
                if (row % 2 == 0) {
                    com.setBackground(new Color(255, 255, 255));
                } else {
                    com.setBackground(new Color(242, 246, 249));
                }
            }
            com.setForeground(new Color(0,0,0));
            setBorder(new EmptyBorder(0, 2, 0, 2));
            if (alignment.containsKey(column)) {
                setHorizontalAlignment(alignment.get(column));
            } else {
                setHorizontalAlignment(JLabel.LEFT);
            }
            return com;
        }
    }
}
