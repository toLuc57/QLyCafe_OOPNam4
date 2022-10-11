
package GUI;
import UserControl.JButtonCustom;
import UserControl.tableObject;
import UserControl.WrapLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Home_GUI extends javax.swing.JFrame {

    public Home_GUI() {
        initComponents();
        pnlListTables.setLayout(new WrapLayout(WrapLayout.LEFT,25,10));
        for(int i=1;i<=20;i++){
            tableObject btn = new tableObject();
            btn.setIDTable(String.valueOf(i));
            btn.setSlot(5);
            btn.setStatusTable("Có khách");
            pnlListTables.add(btn);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        top = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnAcount4 = new javax.swing.JLabel();
        btnManagement4 = new javax.swing.JLabel();
        btnClose4 = new javax.swing.JLabel();
        bottom = new javax.swing.JPanel();
        bottomLeft = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnSwitch = new UserControl.JButtonCustom();
        btnAdd = new UserControl.JButtonCustom();
        lblTableID = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBill = new UserControl.TableDark();
        jPanel11 = new javax.swing.JPanel();
        lblTotalMoney = new javax.swing.JLabel();
        btnDiscount = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        lblSurcharge = new javax.swing.JTextField();
        btnSurchange = new UserControl.JButtonCustom();
        btnCheckout = new UserControl.JButtonCustom();
        bottomRight = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlListTables = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setName("frm_Home"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        main.setBackground(new java.awt.Color(0, 51, 51));
        main.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.white, new java.awt.Color(204, 204, 204), java.awt.Color.white));
        main.setLayout(new java.awt.BorderLayout());

        top.setBackground(new java.awt.Color(255, 255, 255));
        top.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        btnAcount4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAcount4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAcount4.setText("Tài khoản");
        btnAcount4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAcount4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAcount4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAcount4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAcount4MouseExited(evt);
            }
        });

        btnManagement4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnManagement4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnManagement4.setText("Chủ quán");
        btnManagement4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManagement4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManagement4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManagement4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnManagement4MouseExited(evt);
            }
        });

        btnClose4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_close_window_30px.png"))); // NOI18N
        btnClose4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClose4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClose4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClose4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnManagement4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAcount4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 877, Short.MAX_VALUE)
                .addComponent(btnClose4)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnManagement4)
                        .addComponent(btnAcount4))
                    .addComponent(btnClose4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        top.add(jPanel7, java.awt.BorderLayout.CENTER);

        main.add(top, java.awt.BorderLayout.PAGE_START);

        bottom.setBackground(new java.awt.Color(255, 255, 255));
        bottom.setLayout(new java.awt.BorderLayout());

        bottomLeft.setOpaque(false);
        bottomLeft.setLayout(new java.awt.BorderLayout());

        jPanel8.setOpaque(false);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        btnSwitch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Switch_50px_3.png"))); // NOI18N
        btnSwitch.setText("Chuyển bàn");
        btnSwitch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSwitch.setRound(30);
        btnSwitch.setStyle(UserControl.JButtonCustom.ButtonStyle.DESTRUCTIVE);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Add_Property_50px.png"))); // NOI18N
        btnAdd.setText("Thêm món");
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setRound(30);
        btnAdd.setStyle(UserControl.JButtonCustom.ButtonStyle.DESTRUCTIVE);

        lblTableID.setFont(new java.awt.Font("UTM Alexander", 1, 18)); // NOI18N
        lblTableID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTableID.setText("Bàn số : 1 (Khu A)");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTableID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSwitch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTableID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.BorderLayout());

        tbBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên món", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbBill);

        jPanel10.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        lblTotalMoney.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotalMoney.setText("0.00 VND");
        lblTotalMoney.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel5.setBackground(new java.awt.Color(250, 244, 244));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel5.setText("Giảm giá:");

        lblSurcharge.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblSurcharge.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lblSurcharge.setText("0.00 VND");
        lblSurcharge.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        btnSurchange.setText("Phụ thu");
        btnSurchange.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnSurchange.setRound(10);
        btnSurchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSurchangeActionPerformed(evt);
            }
        });

        btnCheckout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_checkout_50px.png"))); // NOI18N
        btnCheckout.setText("Thanh toán");
        btnCheckout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCheckout.setRound(40);
        btnCheckout.setStyle(UserControl.JButtonCustom.ButtonStyle.DESTRUCTIVE);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDiscount))
                    .addComponent(lblTotalMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSurcharge)
                    .addComponent(btnSurchange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSurchange, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSurcharge, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bottomLeft.add(jPanel8, java.awt.BorderLayout.CENTER);

        bottom.add(bottomLeft, java.awt.BorderLayout.LINE_START);

        bottomRight.setOpaque(false);
        bottomRight.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        pnlListTables.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlListTablesLayout = new javax.swing.GroupLayout(pnlListTables);
        pnlListTables.setLayout(pnlListTablesLayout);
        pnlListTablesLayout.setHorizontalGroup(
            pnlListTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
        );
        pnlListTablesLayout.setVerticalGroup(
            pnlListTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pnlListTables);

        bottomRight.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        bottom.add(bottomRight, java.awt.BorderLayout.CENTER);

        main.add(bottom, java.awt.BorderLayout.CENTER);

        getContentPane().add(main, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcount4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAcount4MouseClicked
        btnAcount4.setForeground(Color.RED);
    }//GEN-LAST:event_btnAcount4MouseClicked

    private void btnAcount4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAcount4MouseEntered
        btnAcount4.setForeground(Color.BLUE);
    }//GEN-LAST:event_btnAcount4MouseEntered

    private void btnAcount4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAcount4MouseExited
        btnAcount4.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnAcount4MouseExited

    private void btnManagement4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagement4MouseClicked
        btnManagement4.setForeground(Color.RED);
    }//GEN-LAST:event_btnManagement4MouseClicked

    private void btnManagement4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagement4MouseEntered
        btnManagement4.setForeground(Color.BLUE);
    }//GEN-LAST:event_btnManagement4MouseEntered

    private void btnManagement4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagement4MouseExited
        btnManagement4.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnManagement4MouseExited

    private void btnClose4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClose4MouseClicked

        try {
            int select = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất không?");
            if(select==0){
                this.dispose();
                new login_GUI().setVisible(true);
            }
        } catch (IOException ex) {
            Logger.getLogger(Home_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnClose4MouseClicked

    private void btnClose4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClose4MouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/icons8_close_window_30px_1.png"));
        btnClose4.setIcon(ii);
    }//GEN-LAST:event_btnClose4MouseEntered

    private void btnClose4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClose4MouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/icons8_close_window_30px.png"));
        btnClose4.setIcon(ii);
    }//GEN-LAST:event_btnClose4MouseExited

    private void btnSurchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSurchangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSurchangeActionPerformed

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
            java.util.logging.Logger.getLogger(Home_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottom;
    private javax.swing.JPanel bottomLeft;
    private javax.swing.JPanel bottomRight;
    private javax.swing.JLabel btnAcount;
    private javax.swing.JLabel btnAcount1;
    private javax.swing.JLabel btnAcount2;
    private javax.swing.JLabel btnAcount3;
    private javax.swing.JLabel btnAcount4;
    private UserControl.JButtonCustom btnAdd;
    private UserControl.JButtonCustom btnCheckout;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnClose1;
    private javax.swing.JLabel btnClose2;
    private javax.swing.JLabel btnClose3;
    private javax.swing.JLabel btnClose4;
    private javax.swing.JSpinner btnDiscount;
    private javax.swing.JLabel btnManagement;
    private javax.swing.JLabel btnManagement1;
    private javax.swing.JLabel btnManagement2;
    private javax.swing.JLabel btnManagement3;
    private javax.swing.JLabel btnManagement4;
    private UserControl.JButtonCustom btnSurchange;
    private UserControl.JButtonCustom btnSwitch;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lblSurcharge;
    private javax.swing.JLabel lblTableID;
    private javax.swing.JLabel lblTotalMoney;
    private javax.swing.JPanel main;
    private javax.swing.JPanel pnlListTables;
    private UserControl.TableDark tbBill;
    private javax.swing.JPanel top;
    // End of variables declaration//GEN-END:variables
}
