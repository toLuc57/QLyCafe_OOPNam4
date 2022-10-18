
package UserControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
/**
 *
 * @author tranbathien
 */
public class Menu extends javax.swing.JPanel{
    private List<EventMenu> events;

    public Menu() {
        initComponents();
        setOpaque(false);
        events = new ArrayList<>();
        panel.setLayout(new MigLayout("wrap, fill, inset 0", "[center]", "[center]"));
        addSpace(20);
        addItem("drink", 0);
        addItem("staff", 1);
        addItem("product", 2);
        addItem("import",3);
        addItem("bill", 4);
        addItem("table", 5);
        addItem("extra", 6);
        addItem("static", 7);
        addSpace(20);
        repaint();
        revalidate();
    }

    private void addSpace(int size) {
        panel.add(new JLabel(), "h " + size + "!");
    }

    private void addItem(String icon, int index) {
        MenuItem item = new MenuItem();
        item.setImage(new ImageIcon(getClass().getResource("/Images/" + icon + ".png")).getImage());
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                runEvent(index);
            }
        });
        panel.add(item, "w 50!, h 50!");
    }

    public void addEvent(EventMenu event) {
        events.add(event);
    }

    private void runEvent(int index) {
        for (EventMenu event : events) {
            event.menuSelected(index);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new PanelRound();

        panel.setRoundBottomRight(50);
        panel.setRoundTopRight(50);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private PanelRound panel;
}
