
package GUI;

/**
 *
 * @author tranbathien
 */
public class Management_extrafee_GUI extends javax.swing.JPanel {

    public Management_extrafee_GUI() {
        initComponents();
        panelAddUpdate.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Top = new javax.swing.JPanel();
        txtSearchExfee = new UserControl.TextFieldAnimation();
        btnAddExFee = new UserControl.GradientButtom();
        btnRepairExfee = new UserControl.GradientButtom();
        btnDeleteExfee = new UserControl.GradientButtom();
        Bottom = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_ExtraFee_Management = new UserControl.TableDark();
        panelAddUpdate = new javax.swing.JPanel();
        txtNameFee = new UserControl.TextField();
        txtMoney = new UserControl.TextField();
        jLabel1 = new javax.swing.JLabel();
        btnActive = new UserControl.SwitchButton();
        lblAcitve = new javax.swing.JLabel();
        btnaccept = new UserControl.JButtonCustom();
        btnClose = new UserControl.JButtonCustom();

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        Top.setBackground(new java.awt.Color(0, 102, 102));
        Top.setOpaque(false);

        txtSearchExfee.setAnimationColor(new java.awt.Color(0, 0, 51));
        txtSearchExfee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchExfeeActionPerformed(evt);
            }
        });

        btnAddExFee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_add_30px.png"))); // NOI18N
        btnAddExFee.setText("Thêm");
        btnAddExFee.setColor1(new java.awt.Color(51, 0, 153));
        btnAddExFee.setColor2(new java.awt.Color(102, 0, 102));
        btnAddExFee.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnAddExFee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddExFeeMouseClicked(evt);
            }
        });

        btnRepairExfee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_screwdriver_emoji_30px.png"))); // NOI18N
        btnRepairExfee.setText("Sửa");
        btnRepairExfee.setColor1(new java.awt.Color(0, 102, 102));
        btnRepairExfee.setColor2(new java.awt.Color(51, 102, 0));
        btnRepairExfee.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnRepairExfee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRepairExfeeMouseClicked(evt);
            }
        });

        btnDeleteExfee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_30px.png"))); // NOI18N
        btnDeleteExfee.setText("Xóa");
        btnDeleteExfee.setColor1(new java.awt.Color(255, 255, 0));
        btnDeleteExfee.setColor2(new java.awt.Color(255, 0, 0));
        btnDeleteExfee.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchExfee, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddExFee, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRepairExfee, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteExfee, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchExfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddExFee, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeleteExfee, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRepairExfee, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        add(Top, java.awt.BorderLayout.PAGE_START);

        Bottom.setBackground(new java.awt.Color(0, 0, 0));
        Bottom.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));

        table_ExtraFee_Management.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên phí", "Số tiền", "Hữu hiệu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_ExtraFee_Management.setGridColor(new java.awt.Color(51, 51, 51));
        table_ExtraFee_Management.setRowHeight(50);
        jScrollPane2.setViewportView(table_ExtraFee_Management);

        Bottom.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        panelAddUpdate.setBackground(new java.awt.Color(255, 255, 255));

        txtNameFee.setToolTipText("");
        txtNameFee.setLabelText("Tên phí");

        txtMoney.setLabelText("Số tiền");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_edit_100px.png"))); // NOI18N

        lblAcitve.setFont(new java.awt.Font("UTM Androgyne", 0, 18)); // NOI18N
        lblAcitve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAcitve.setText("Hữu hiệu:");

        btnaccept.setText("Chấp nhận");
        btnaccept.setFont(new java.awt.Font("UTM Akashi", 0, 14)); // NOI18N
        btnaccept.setRound(20);
        btnaccept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnacceptMouseClicked(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("UTM Akashi", 0, 14)); // NOI18N
        btnClose.setLabel("Hủy");
        btnClose.setRound(20);
        btnClose.setStyle(UserControl.JButtonCustom.ButtonStyle.DESTRUCTIVE);
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelAddUpdateLayout = new javax.swing.GroupLayout(panelAddUpdate);
        panelAddUpdate.setLayout(panelAddUpdateLayout);
        panelAddUpdateLayout.setHorizontalGroup(
            panelAddUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnaccept, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNameFee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMoney, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelAddUpdateLayout.createSequentialGroup()
                        .addComponent(lblAcitve, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(btnActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelAddUpdateLayout.setVerticalGroup(
            panelAddUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddUpdateLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtNameFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(panelAddUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAcitve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(btnaccept, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        Bottom.add(panelAddUpdate, java.awt.BorderLayout.LINE_END);

        add(Bottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    void ClearEdit(){
        txtMoney.setText("");
        txtNameFee.setText("");
        btnActive.setSelected(false);
    }
    private void txtSearchExfeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchExfeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchExfeeActionPerformed

    private void btnAddExFeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddExFeeMouseClicked
        panelAddUpdate.setVisible(true);
        lblAcitve.setVisible(false);
        btnActive.setVisible(false);
    }//GEN-LAST:event_btnAddExFeeMouseClicked

    private void btnacceptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnacceptMouseClicked
        ClearEdit();
        panelAddUpdate.setVisible(false);
    }//GEN-LAST:event_btnacceptMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        panelAddUpdate.setVisible(false);
        ClearEdit();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnRepairExfeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRepairExfeeMouseClicked
        panelAddUpdate.setVisible(true);
        lblAcitve.setVisible(true);
        btnActive.setVisible(true);
    }//GEN-LAST:event_btnRepairExfeeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bottom;
    private javax.swing.JPanel Top;
    private UserControl.SwitchButton btnActive;
    private UserControl.GradientButtom btnAddExFee;
    private UserControl.JButtonCustom btnClose;
    private UserControl.GradientButtom btnDeleteExfee;
    private UserControl.GradientButtom btnRepairExfee;
    private UserControl.JButtonCustom btnaccept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAcitve;
    private javax.swing.JPanel panelAddUpdate;
    private UserControl.TableDark table_ExtraFee_Management;
    private UserControl.TextField txtMoney;
    private UserControl.TextField txtNameFee;
    private UserControl.TextFieldAnimation txtSearchExfee;
    // End of variables declaration//GEN-END:variables
}
