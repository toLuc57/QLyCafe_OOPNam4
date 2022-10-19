
package GUI;
import java.awt.Cursor;

/**
 *
 * @author tranbathien
 */
public class Management_Staff_GUI extends javax.swing.JPanel {
    private boolean isEdit;
    public Management_Staff_GUI() {
        initComponents();
        ToggleEdit(false);
    }

    private void ToggleEdit(boolean state) {
        isEdit = !state;
        btnCancel.setVisible(state);
        btnSave.setVisible(state);
        txtName.setEditable(state);
        txtDatebirth.setEditable(state);
        txtAddress.setEditable(state);
        txtEmail.setEditable(state);
        txtPassword.setEditable(state);
        txtSDT.setEditable(state);
        cbbChooseGender.setEnabled(state);
        cbbLevel.setEnabled(state);
        btnChooseImage.setEnabled(state);
    }
    private void ClearEdit() {
        txtName.setText("");
        txtAddress.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtSDT.setText("");
        cbbChooseGender.setSelectedItem(-1);
        cbbLevel.setSelectedItem(-1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datetimepicker = new DateTimePicker.DateChooser();
        Top = new javax.swing.JPanel();
        txtSearchStaff = new UserControl.TextFieldAnimation();
        btnUpdateStaff = new UserControl.GradientButtom();
        btnAddStaff = new UserControl.GradientButtom();
        btnDeleteStaff = new UserControl.GradientButtom();
        Bottom = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Staff_Management = new UserControl.TableDark();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnChooseImage = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtName = new UserControl.TextField();
        txtSDT = new UserControl.TextField();
        txtDatebirth = new UserControl.TextField();
        cbbChooseGender = new UserControl.JComboboxCustom();
        txtPassword = new UserControl.TextField();
        cbbLevel = new UserControl.JComboboxCustom();
        txtEmail = new UserControl.TextField();
        txtAddress = new UserControl.TextField();
        btnSave = new UserControl.JButtonCustom();
        btnCancel = new UserControl.JButtonCustom();

        datetimepicker.setTextRefernce(txtDatebirth);

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        Top.setBackground(new java.awt.Color(0, 102, 102));
        Top.setOpaque(false);

        txtSearchStaff.setAnimationColor(new java.awt.Color(255, 204, 0));
        txtSearchStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchStaffActionPerformed(evt);
            }
        });

        btnUpdateStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_screwdriver_emoji_30px.png"))); // NOI18N
        btnUpdateStaff.setText("Sửa");
        btnUpdateStaff.setColor1(new java.awt.Color(0, 102, 102));
        btnUpdateStaff.setColor2(new java.awt.Color(51, 102, 0));
        btnUpdateStaff.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnUpdateStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStaffActionPerformed(evt);
            }
        });

        btnAddStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_add_30px.png"))); // NOI18N
        btnAddStaff.setText("Thêm");
        btnAddStaff.setColor1(new java.awt.Color(51, 0, 153));
        btnAddStaff.setColor2(new java.awt.Color(102, 0, 102));
        btnAddStaff.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnAddStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStaffActionPerformed(evt);
            }
        });

        btnDeleteStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_30px.png"))); // NOI18N
        btnDeleteStaff.setText("Xóa");
        btnDeleteStaff.setColor1(new java.awt.Color(255, 255, 0));
        btnDeleteStaff.setColor2(new java.awt.Color(255, 0, 0));
        btnDeleteStaff.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnUpdateStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnDeleteStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(Top, java.awt.BorderLayout.PAGE_START);

        Bottom.setBackground(new java.awt.Color(0, 0, 0));
        Bottom.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));

        table_Staff_Management.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "fáadas", "món 1", "dsa", "1232131", null, null, null},
                {"2", "dá", "đá", "ád", "ádas", null, null, null},
                {"3", "dá", "ád", "ád", "ádasdas", null, null, null},
                {"4", "sad", "áda", "áda", "đấ", null, null, null},
                {"5", "ádas", "adasd", "đá", null, null, null, null}
            },
            new String [] {
                "ID", "Mã nhân viên", "Họ tên", "Ngày sinh", "Địa chỉ", "Email", "Số điện thoại", "Chức vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Staff_Management.setGridColor(new java.awt.Color(51, 51, 51));
        table_Staff_Management.setRowHeight(50);
        jScrollPane2.setViewportView(table_Staff_Management);
        if (table_Staff_Management.getColumnModel().getColumnCount() > 0) {
            table_Staff_Management.getColumnModel().getColumn(0).setResizable(false);
        }

        Bottom.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_circled_user_male_skin_type_6_128px.png"))); // NOI18N

        btnChooseImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChooseImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_camera_40px.png"))); // NOI18N
        btnChooseImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnChooseImageMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(btnChooseImage)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChooseImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtName.setLabelText("Tên nhân viên");

        txtSDT.setLabelText("Số điện thoại");

        txtDatebirth.setLabelText("Ngày sinh");

        cbbChooseGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ", "Khác" }));
        cbbChooseGender.setSelectedIndex(-1);
        cbbChooseGender.setLabeText("Giới tính");

        txtPassword.setLabelText("Mật khẩu cấp");

        cbbLevel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nhân viên", "Quản lý" }));
        cbbLevel.setSelectedIndex(-1);
        cbbLevel.setLabeText("Chức vụ");

        txtEmail.setLabelText("Địa chỉ Email");

        txtAddress.setLabelText("Địa chỉ thường trú");

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_save_40px.png"))); // NOI18N
        btnSave.setText("Lưu lại");
        btnSave.setFont(new java.awt.Font("UTM Cookies", 0, 24)); // NOI18N
        btnSave.setRound(20);
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveMouseEntered(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_close_30px_1_1.png"))); // NOI18N
        btnCancel.setText("Hủy");
        btnCancel.setFont(new java.awt.Font("UTM Cookies", 0, 24)); // NOI18N
        btnCancel.setRound(20);
        btnCancel.setStyle(UserControl.JButtonCustom.ButtonStyle.DESTRUCTIVE);
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbChooseGender, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDatebirth, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbLevel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDatebirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbChooseGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cbbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Bottom.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        add(Bottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchStaffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchStaffActionPerformed

    private void btnAddStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaffActionPerformed
        ClearEdit();
        ToggleEdit(true);
    }//GEN-LAST:event_btnAddStaffActionPerformed

    private void btnChooseImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChooseImageMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnChooseImageMouseEntered

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        ToggleEdit(false);
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        ClearEdit();
        ToggleEdit(false);
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnCancelMouseEntered

    private void btnUpdateStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStaffActionPerformed
        ToggleEdit(true);
    }//GEN-LAST:event_btnUpdateStaffActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bottom;
    private javax.swing.JPanel Top;
    private UserControl.GradientButtom btnAddStaff;
    private UserControl.JButtonCustom btnCancel;
    private javax.swing.JLabel btnChooseImage;
    private UserControl.GradientButtom btnDeleteStaff;
    private UserControl.JButtonCustom btnSave;
    private UserControl.GradientButtom btnUpdateStaff;
    private UserControl.JComboboxCustom cbbChooseGender;
    private UserControl.JComboboxCustom cbbLevel;
    private DateTimePicker.DateChooser datetimepicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private UserControl.TableDark table_Staff_Management;
    private UserControl.TextField txtAddress;
    private UserControl.TextField txtDatebirth;
    private UserControl.TextField txtEmail;
    private UserControl.TextField txtName;
    private UserControl.TextField txtPassword;
    private UserControl.TextField txtSDT;
    private UserControl.TextFieldAnimation txtSearchStaff;
    // End of variables declaration//GEN-END:variables
}
