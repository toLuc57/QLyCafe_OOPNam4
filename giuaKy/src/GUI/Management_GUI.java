package GUI;
import UserControl.MessageDialog;
import UserControl.loading;
import java.awt.Component;
import java.awt.Cursor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author tranbathien
 */
public class Management_GUI extends javax.swing.JFrame {
    public Management_GUI() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        menu.addEvent((int index) -> {
            switch (index) {
                case 0 ->
                    showForm(new Management_Menu_GUI());
                case 1 ->
                    showForm(new Management_Staff_GUI());
                case 2 ->
                    showForm(new Management_Product_GUI());
                case 3 ->
                    showForm(new Management_Import_GUI());
                case 4 ->
                    showForm(new Management_Bill_GUI());
                case 5 ->
                    showForm(new Management_Tables_GUI());
                case 6 ->
                    showForm(new Management_extrafee_GUI());
                case 7 ->
                    showForm(new Management_Statistical_GUI());
                default -> {
                }
            }
        });
    }

    private void showForm(Component com) {
        managementForm.removeAll();
        managementForm.add(com);
        managementForm.repaint();
        managementForm.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainForm = new javax.swing.JPanel();
        left = new javax.swing.JPanel();
        menu = new UserControl.Menu();
        right = new javax.swing.JPanel();
        rightTop = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        managementForm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));
        setUndecorated(true);

        mainForm.setBackground(new java.awt.Color(254, 201, 149));
        mainForm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        mainForm.setLayout(new java.awt.BorderLayout());

        left.setBackground(new java.awt.Color(0, 51, 51));
        left.setOpaque(false);

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainForm.add(left, java.awt.BorderLayout.LINE_START);

        right.setBackground(new java.awt.Color(0, 51, 51));
        right.setOpaque(false);
        right.setLayout(new java.awt.BorderLayout());

        rightTop.setBackground(new java.awt.Color(242, 66, 77));
        rightTop.setOpaque(false);

        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_close_window_30px.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });

        javax.swing.GroupLayout rightTopLayout = new javax.swing.GroupLayout(rightTop);
        rightTop.setLayout(rightTopLayout);
        rightTopLayout.setHorizontalGroup(
            rightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightTopLayout.createSequentialGroup()
                .addGap(0, 976, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        rightTopLayout.setVerticalGroup(
            rightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        right.add(rightTop, java.awt.BorderLayout.PAGE_START);

        managementForm.setOpaque(false);
        managementForm.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("UTM Aristote", 0, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(175, 20, 45));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logoquan.png"))); // NOI18N
        jLabel1.setText("  Giao diện quản lý");
        managementForm.add(jLabel1, java.awt.BorderLayout.CENTER);

        right.add(managementForm, java.awt.BorderLayout.CENTER);

        mainForm.add(right, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainForm, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        MessageDialog m = new MessageDialog(this);
        m.showMessage("Khoan đã!", "Bạn có chắc chắn muốn đóng giao diện quản lý không?");
        if (m.getMessageType() == MessageDialog.MessageType.OK) {
            this.setVisible(false);
            this.dispose();
            Home_GUI h = new Home_GUI();
            h.setVisible(true);
        }
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        btnClose.setCursor(new Cursor(HAND_CURSOR));
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/icons8_close_window_30px_1.png"));
        btnClose.setIcon(ii);
    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/icons8_close_window_30px.png"));
        btnClose.setIcon(ii);
    }//GEN-LAST:event_btnCloseMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Management_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Management_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Management_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Management_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Management_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel left;
    private javax.swing.JPanel mainForm;
    private javax.swing.JPanel managementForm;
    private UserControl.Menu menu;
    private javax.swing.JPanel right;
    private javax.swing.JPanel rightTop;
    // End of variables declaration//GEN-END:variables
}
