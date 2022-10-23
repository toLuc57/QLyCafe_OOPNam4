
package GUI;
import UserControl.MessageDialog;
import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author tranbathien
 */
public class Management_Import_GUI extends javax.swing.JPanel {

    public Management_Import_GUI() {
        initComponents();
        ToggleEdit(false);
    }
    private void ToggleEdit(boolean state) {
        panelShowAddUpdate.setVisible(state);
    }
    private void ClearEdit() {
        cbbChosseProduct.setSelectedIndex(-1);
        nbrSLImport.setValue(0);
        clearTable();
        lblShowToltalMoney.setText("0 VNĐ");
    }
    private void clearTable(){
        DefaultTableModel tbmodel = (DefaultTableModel) tbImport.getModel();
        tbmodel.setNumRows(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateFrom = new DateTimePicker.DateChooser();
        dateTo = new DateTimePicker.DateChooser();
        Top = new javax.swing.JPanel();
        txtSearchImport = new UserControl.TextFieldAnimation();
        btnAddImport = new UserControl.GradientButtom();
        btnRepairImport = new UserControl.GradientButtom();
        btnDeleteImport = new UserControl.GradientButtom();
        cbbNameProductFilter = new UserControl.JComboboxCustom();
        cbbNameNvFilter = new UserControl.JComboboxCustom();
        txtDateFrom = new javax.swing.JTextField();
        txtDateto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnFilterImport = new UserControl.GradientButtom();
        Bottom = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Import_Management = new UserControl.TableDark();
        panelShowAddUpdate = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cbbChosseProduct = new UserControl.JComboboxCustom();
        nbrSLImport = new UserControl.Spinner();
        jLabel3 = new javax.swing.JLabel();
        jButtonCustom1 = new UserControl.JButtonCustom();
        jPanel2 = new javax.swing.JPanel();
        lblShowToltalMoney = new javax.swing.JLabel();
        btnAccept = new UserControl.JButtonCustom();
        btnCloseFormAddUpdate = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbImport = new UserControl.TableDark();

        dateFrom.setTextRefernce(txtDateFrom);

        dateTo.setTextRefernce(txtDateto);

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        Top.setBackground(new java.awt.Color(0, 102, 102));
        Top.setOpaque(false);

        txtSearchImport.setAnimationColor(new java.awt.Color(204, 0, 153));
        txtSearchImport.setHintText("Tìm theo mã phiếu...");
        txtSearchImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchImportMouseClicked(evt);
            }
        });
        txtSearchImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchImportActionPerformed(evt);
            }
        });

        btnAddImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_add_30px.png"))); // NOI18N
        btnAddImport.setText("Nhập");
        btnAddImport.setColor1(new java.awt.Color(51, 0, 153));
        btnAddImport.setColor2(new java.awt.Color(102, 0, 102));
        btnAddImport.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnAddImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImportActionPerformed(evt);
            }
        });

        btnRepairImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_screwdriver_emoji_30px.png"))); // NOI18N
        btnRepairImport.setText("Sửa phiếu");
        btnRepairImport.setColor1(new java.awt.Color(0, 102, 102));
        btnRepairImport.setColor2(new java.awt.Color(51, 102, 0));
        btnRepairImport.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnRepairImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepairImportActionPerformed(evt);
            }
        });

        btnDeleteImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_30px.png"))); // NOI18N
        btnDeleteImport.setText("Xóa");
        btnDeleteImport.setColor1(new java.awt.Color(255, 255, 0));
        btnDeleteImport.setColor2(new java.awt.Color(255, 0, 0));
        btnDeleteImport.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N

        cbbNameProductFilter.setBackground(new java.awt.Color(254, 201, 149));
        cbbNameProductFilter.setLabeText("Tên sản phẩm");

        cbbNameNvFilter.setBackground(new java.awt.Color(254, 201, 149));
        cbbNameNvFilter.setLabeText("Nhân viên nhập");

        jLabel1.setLabelFor(txtDateFrom);
        jLabel1.setText("Từ ngày:");

        jLabel2.setLabelFor(txtDateto);
        jLabel2.setText("Đến ngày:");

        btnFilterImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_filter_30px.png"))); // NOI18N
        btnFilterImport.setText("Lọc");
        btnFilterImport.setColor1(new java.awt.Color(102, 102, 255));
        btnFilterImport.setColor2(new java.awt.Color(153, 0, 255));
        btnFilterImport.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchImport, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbNameProductFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbNameNvFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDateto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFilterImport, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddImport, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRepairImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteImport, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopLayout.createSequentialGroup()
                        .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddImport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteImport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRepairImport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNameProductFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbNameNvFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFilterImport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(TopLayout.createSequentialGroup()
                        .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDateto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        add(Top, java.awt.BorderLayout.PAGE_START);

        Bottom.setBackground(new java.awt.Color(0, 0, 0));
        Bottom.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));

        table_Import_Management.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên sản phẩm", "Ngày nhập", "Số lượng", "Đơn giá nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Import_Management.setGridColor(new java.awt.Color(51, 51, 51));
        table_Import_Management.setRowHeight(50);
        jScrollPane2.setViewportView(table_Import_Management);

        Bottom.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        panelShowAddUpdate.setBackground(new java.awt.Color(255, 255, 255));
        panelShowAddUpdate.setMaximumSize(new java.awt.Dimension(1415, 197));
        panelShowAddUpdate.setMinimumSize(new java.awt.Dimension(1415, 197));
        panelShowAddUpdate.setPreferredSize(new java.awt.Dimension(1415, 197));
        panelShowAddUpdate.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 197));

        cbbChosseProduct.setLabeText("Chọn sản phẩm nhập");

        nbrSLImport.setLabelText("Đơn vị nhập");

        jLabel3.setFont(new java.awt.Font("UTM Amherst", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Chọn số lượng");

        jButtonCustom1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_add_48px.png"))); // NOI18N
        jButtonCustom1.setText("Chọn nhập");
        jButtonCustom1.setFont(new java.awt.Font("UTM Alexander", 0, 24)); // NOI18N
        jButtonCustom1.setRound(30);
        jButtonCustom1.setStyle(UserControl.JButtonCustom.ButtonStyle.DESTRUCTIVE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbChosseProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nbrSLImport, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbChosseProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nbrSLImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelShowAddUpdate.add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 197));

        lblShowToltalMoney.setFont(new java.awt.Font("UTM Flamenco", 0, 18)); // NOI18N
        lblShowToltalMoney.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblShowToltalMoney.setText("5,000,000 VNĐ");

        btnAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Checkmark_64px.png"))); // NOI18N
        btnAccept.setText("Xác nhận");
        btnAccept.setFont(new java.awt.Font("UTM Alexander", 0, 24)); // NOI18N
        btnAccept.setRound(30);
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnCloseFormAddUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCloseFormAddUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_descending_sorting_48px.png"))); // NOI18N
        btnCloseFormAddUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseFormAddUpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseFormAddUpdateMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblShowToltalMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCloseFormAddUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAccept, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblShowToltalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCloseFormAddUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelShowAddUpdate.add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(2147483647, 197));
        jPanel3.setLayout(new java.awt.BorderLayout());

        tbImport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên sản phẩm", "Đơn vị tính", "Số lượng", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbImport);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelShowAddUpdate.add(jPanel3, java.awt.BorderLayout.CENTER);

        Bottom.add(panelShowAddUpdate, java.awt.BorderLayout.PAGE_END);

        add(Bottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchImportActionPerformed
        
    }//GEN-LAST:event_txtSearchImportActionPerformed

    private void txtSearchImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchImportMouseClicked
            
    }//GEN-LAST:event_txtSearchImportMouseClicked

    private void btnAddImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImportActionPerformed
        ToggleEdit(true);
    }//GEN-LAST:event_btnAddImportActionPerformed

    private void btnCloseFormAddUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseFormAddUpdateMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnCloseFormAddUpdateMouseEntered

    private void btnCloseFormAddUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseFormAddUpdateMouseClicked
        MessageDialog m = new MessageDialog(new JFrame());
        m.showMessage("Khoan đã!", "Bạn có chắc chắn muốn đóng form nhập hàng chứ? Mọi thông tin nhập sẽ bị hủy bỏ?");
        if (m.getMessageType() == MessageDialog.MessageType.OK) {
            ToggleEdit(false);
            ClearEdit();
        }
        
    }//GEN-LAST:event_btnCloseFormAddUpdateMouseClicked

    private void btnRepairImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepairImportActionPerformed
        ToggleEdit(true);
        //vietcode lay du lieu o day
        
    }//GEN-LAST:event_btnRepairImportActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // viet code o day nhe quang
        
        
        
        
        ToggleEdit(false);
        ClearEdit(); 
    }//GEN-LAST:event_btnAcceptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bottom;
    private javax.swing.JPanel Top;
    private UserControl.JButtonCustom btnAccept;
    private UserControl.GradientButtom btnAddImport;
    private javax.swing.JLabel btnCloseFormAddUpdate;
    private UserControl.GradientButtom btnDeleteImport;
    private UserControl.GradientButtom btnFilterImport;
    private UserControl.GradientButtom btnRepairImport;
    private UserControl.JComboboxCustom cbbChosseProduct;
    private UserControl.JComboboxCustom cbbNameNvFilter;
    private UserControl.JComboboxCustom cbbNameProductFilter;
    private DateTimePicker.DateChooser dateFrom;
    private DateTimePicker.DateChooser dateTo;
    private UserControl.JButtonCustom jButtonCustom1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblShowToltalMoney;
    private UserControl.Spinner nbrSLImport;
    private javax.swing.JPanel panelShowAddUpdate;
    private UserControl.TableDark table_Import_Management;
    private UserControl.TableDark tbImport;
    private javax.swing.JTextField txtDateFrom;
    private javax.swing.JTextField txtDateto;
    private UserControl.TextFieldAnimation txtSearchImport;
    // End of variables declaration//GEN-END:variables
}
