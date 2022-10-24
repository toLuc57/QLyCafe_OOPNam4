package GUI;

import DTO.NhanVien;
import DTO.ThucDon;
import Util.dbUtil;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tranbathien
 */
public class Management_Staff_GUI extends javax.swing.JPanel {

    private boolean isEdit;
    int xacNhan;
    NhanVien nv = new NhanVien();

    public Management_Staff_GUI() {
        initComponents();
        ToggleEdit(false);
        LoadDBNhanVien();
        txtStaffCode.setVisible(false);

    }

    public void LoadDBNhanVien() {
        try {
            clear_Table();
            Connection conn = dbUtil.getConnection();
            String sql = "select * from NhanVien where HoTen like '%" + txtSearchStaff.getText() + "%'" + "or MaNhanVien like '%" + txtSearchStaff.getText() + "%'";
            ResultSet rs = dbUtil.ThucThiSelect(sql);
            DefaultTableModel tbModel = (DefaultTableModel) table_Staff_Management.getModel();
            Object[] obj = new Object[10];
            while (rs.next()) {
                obj[0] = table_Staff_Management.getRowCount() + 1;
                obj[1] = rs.getInt("MaNhanVien");
                obj[2] = rs.getString("HoTen");
                obj[3] = rs.getString("GioiTinh");
                obj[4] = rs.getString("NgaySinh");
                obj[5] = rs.getString("DiaChi");
                obj[6] = rs.getString("Email");
                obj[7] = rs.getString("SDT");
                obj[8] = rs.getString("Matkhau");

                if ("0".equals(rs.getString("isAdmin"))) {
                    obj[9] = "Nhân viên";
                } else {
                    obj[9] = "Quản lý";
                }
                tbModel.addRow(obj);

            }
            dbUtil.CloseConnection(conn);

        } catch (SQLException ex) {
            Logger.getLogger(Management_Staff_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void clear_Table() {
        DefaultTableModel tbModel = (DefaultTableModel) table_Staff_Management.getModel();
        tbModel.setNumRows(0);
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
        txtStaffCode = new UserControl.TextField();
        txtDatebirth = new UserControl.TextField();
        cbbChooseGender = new UserControl.JComboboxCustom();
        txtPassword = new UserControl.TextField();
        cbbLevel = new UserControl.JComboboxCustom();
        txtEmail = new UserControl.TextField();
        txtAddress = new UserControl.TextField();
        btnSave = new UserControl.JButtonCustom();
        btnCancel = new UserControl.JButtonCustom();
        txtSDT = new UserControl.TextField();

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
        btnDeleteStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStaffActionPerformed(evt);
            }
        });

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

            },
            new String [] {
                "ID", "Mã nhân viên", "Họ tên", "Giới tính", "Ngày sinh", "Địa chỉ", "Email", "Số điện thoại", "Mật khẩu", "Chức vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Staff_Management.setGridColor(new java.awt.Color(51, 51, 51));
        table_Staff_Management.setRowHeight(50);
        table_Staff_Management.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_Staff_ManagementMouseClicked(evt);
            }
        });
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

        txtStaffCode.setLabelText("Mã nhân viên");

        txtDatebirth.setText("");
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
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
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

        txtSDT.setLabelText("Số điện thoại");

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
                                .addComponent(txtStaffCode, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStaffCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
        LoadDBNhanVien();
    }//GEN-LAST:event_txtSearchStaffActionPerformed

    private void btnAddStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaffActionPerformed
        ToggleEdit(true);
        txtStaffCode.setVisible(true);
        xacNhan = 0;
        txtName.requestFocus();

    }//GEN-LAST:event_btnAddStaffActionPerformed

    private void btnChooseImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChooseImageMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnChooseImageMouseEntered

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        int cv;
        if (cbbLevel.getSelectedItem().equals("Nhân viên")) {
            cv = 0;
        } else {
            cv = 1;
        }
        //-----------Insert----------//
        if (xacNhan == 0) {
            if (txtName.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập tên Nhân viên");
            }
            if (txtStaffCode.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập Mã Nhân viên");
            }
            if (cbbChooseGender.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng chọn giới tính");
            }
            if (txtDatebirth.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập ngày sinh");
            }
            if (txtSDT.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập Số điện thoại");
            }
            if (txtPassword.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập Mật khẩu");
            }
            if (txtEmail.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập Email");
            }
            if (txtAddress.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập địa chỉ");
            }
            if (cbbLevel.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng chọn chức");
            } else {
                NhanVien.InsertNhanVien(Integer.parseInt(txtStaffCode.getText()), txtName.getText(), txtDatebirth.getText(), txtAddress.getText(), txtSDT.getText(), txtPassword.getText(), cv, txtEmail.getText(), String.valueOf(cbbChooseGender.getSelectedItem()));
            }
            LoadDBNhanVien();
            ToggleEdit(false);
            ClearEdit();
            txtStaffCode.setVisible(false);

            //------------Edit-----------//
        } else if (xacNhan == 1) {
            if (txtName.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập tên Nhân viên");
            } else if (cbbChooseGender.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng chọn giới tính");
            } else if (txtDatebirth.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập ngày sinh");
            } else if (txtSDT.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập Số điện thoại");
            } else if (txtPassword.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập Mật khẩu");
            } else if (txtEmail.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập Email");
            } else if (txtAddress.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập địa chỉ");
            } else if (cbbLevel.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng chọn chức");
            } else {
                NhanVien.EditNhanVien(txtName.getText(), txtDatebirth.getText(), txtAddress.getText(), txtSDT.getText(), txtPassword.getText(), cv, String.valueOf(cbbChooseGender.getSelectedItem()), txtEmail.getText(), Integer.parseInt(nv.getMaNhanVien()));
            }
            LoadDBNhanVien();
            ToggleEdit(false);
            ClearEdit();
            txtStaffCode.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập đủ thông tin");
        }

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

        if (nv.getMaNhanVien() == "") {
            JOptionPane.showMessageDialog(new JFrame(), "Vui lòng chọn nhân viên");
        } else {
            ToggleEdit(true);
            txtStaffCode.setEnabled(false);
            xacNhan = 1;
            txtName.requestFocus();
            txtStaffCode.setText(nv.getMaNhanVien());
            txtName.setText(nv.getHoTen());
            txtDatebirth.setText(nv.getNgaySinh());
            txtAddress.setText(nv.getDiaChi());
            txtEmail.setText(nv.getEmail());
            txtSDT.setText(nv.getSDT());
            if ("Nam".equals(nv.getGioiTinh())) {
                cbbChooseGender.setSelectedIndex(0);
            }
            if ("Nữ".equals(nv.getGioiTinh())) {
                cbbChooseGender.setSelectedIndex(1);
            } else {
                cbbChooseGender.setSelectedIndex(2);
            }
        }
        if (nv.getIsIsAdmin()) {
            cbbLevel.setSelectedIndex(1);
        } else {
            cbbLevel.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnUpdateStaffActionPerformed

    private void table_Staff_ManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_Staff_ManagementMouseClicked
        int x = table_Staff_Management.getSelectedRow();
        if (x >= 0) {
            nv.setMaNhanVien(String.valueOf(table_Staff_Management.getValueAt(x, 1)));
            nv.setHoTen(String.valueOf(table_Staff_Management.getValueAt(x, 2)));
            nv.setGioiTinh(String.valueOf(table_Staff_Management.getValueAt(x, 3)));
            nv.setNgaySinh(String.valueOf(table_Staff_Management.getValueAt(x, 4)));
            nv.setDiaChi(String.valueOf(table_Staff_Management.getValueAt(x, 5)));
            nv.setEmail(String.valueOf(table_Staff_Management.getValueAt(x, 6)));
            nv.setSDT(String.valueOf(table_Staff_Management.getValueAt(x, 7)));
            nv.setMatkhau(String.valueOf(table_Staff_Management.getValueAt(x, 8)));
            nv.setIsAdmin(Boolean.parseBoolean(String.valueOf(table_Staff_Management.getValueAt(x, 9))));
            System.err.println(nv.getMaNhanVien());

        }
    }//GEN-LAST:event_table_Staff_ManagementMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStaffActionPerformed
        if (nv.getMaNhanVien() == "") {
            JOptionPane.showMessageDialog(new JFrame(), "Vui lòng chọn món");

        } else {
            NhanVien.DeleteNhanVien(Integer.parseInt(nv.getMaNhanVien()));
            LoadDBNhanVien();
        }
    }//GEN-LAST:event_btnDeleteStaffActionPerformed


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
    private UserControl.TextField txtStaffCode;
    // End of variables declaration//GEN-END:variables
}
