package GUI;

import java.awt.Cursor;
import DTO.NhanVien;
import DTO.ThucDon;
import UserControl.loading;
import javax.swing.JFrame;
import UserControl.showFormAddUpdate;
import Util.dbUtil;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tranbathien
 */
public class Management_Menu_GUI extends javax.swing.JPanel {

    ThucDon td = new ThucDon();
    int xacNhan;

    public Management_Menu_GUI() {
        initComponents();
        LoadDBThucDon();
        ToggleEdit(false);
    }

    public void LoadDBThucDon() {
        try {
            clear_Table();
            Connection conn = dbUtil.getConnection();
            String sql = "select * from ThucDon where TenThucDon like '%" + txtSearch.getText() + "%'" + "or IDThucDon like '%" + txtSearch.getText() + "%'";
            ResultSet rs = dbUtil.ThucThiSelect(sql);
            DefaultTableModel tbModel = (DefaultTableModel) table_Menu_Management.getModel();
            Object[] obj = new Object[5];
            while (rs.next()) {

                obj[0] = rs.getInt("IDThucDon");
                obj[1] = rs.getString("TenThucDon");
                obj[2] = rs.getString("Loai");
                obj[3] = rs.getString("GiaTien");
                obj[4] = rs.getString("HinhAnh");
                tbModel.addRow(obj);

            }
            dbUtil.CloseConnection(conn);

        } catch (SQLException ex) {
            Logger.getLogger(Management_Staff_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void clear_Table() {
        DefaultTableModel tbModel = (DefaultTableModel) table_Menu_Management.getModel();
        tbModel.setNumRows(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Top = new javax.swing.JPanel();
        txtSearch = new UserControl.TextFieldAnimation();
        btnAddMenu = new UserControl.GradientButtom();
        btnRepairMenu = new UserControl.GradientButtom();
        btnDeleteMenu = new UserControl.GradientButtom();
        Bottom = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Menu_Management = new UserControl.TableDark();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNameMenu = new UserControl.TextField();
        jLabel6 = new javax.swing.JLabel();
        txtUnitPrice = new UserControl.TextField();
        Image = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbbCategory = new UserControl.JComboboxCustom();
        btnSave = new UserControl.JButtonCustom();
        btnCancel = new UserControl.JButtonCustom();
        btnchosseImage = new UserControl.JButtonCustom();

        setBackground(new java.awt.Color(0, 0, 0));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        Top.setBackground(new java.awt.Color(0, 102, 102));
        Top.setOpaque(false);

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnAddMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_add_30px.png"))); // NOI18N
        btnAddMenu.setText("Thêm");
        btnAddMenu.setColor1(new java.awt.Color(51, 0, 153));
        btnAddMenu.setColor2(new java.awt.Color(102, 0, 102));
        btnAddMenu.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnAddMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMenuMouseClicked(evt);
            }
        });
        btnAddMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMenuActionPerformed(evt);
            }
        });

        btnRepairMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_screwdriver_emoji_30px.png"))); // NOI18N
        btnRepairMenu.setText("Sửa");
        btnRepairMenu.setColor1(new java.awt.Color(0, 102, 102));
        btnRepairMenu.setColor2(new java.awt.Color(51, 102, 0));
        btnRepairMenu.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnRepairMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRepairMenuMouseClicked(evt);
            }
        });
        btnRepairMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepairMenuActionPerformed(evt);
            }
        });

        btnDeleteMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_30px.png"))); // NOI18N
        btnDeleteMenu.setText("Xóa");
        btnDeleteMenu.setColor1(new java.awt.Color(255, 255, 0));
        btnDeleteMenu.setColor2(new java.awt.Color(255, 0, 0));
        btnDeleteMenu.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnDeleteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnAddMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btnRepairMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnDeleteMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeleteMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRepairMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        add(Top, java.awt.BorderLayout.PAGE_START);

        Bottom.setBackground(new java.awt.Color(0, 0, 0));
        Bottom.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));

        table_Menu_Management.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên món", "Loại", "Giá tiền", "Hình ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Menu_Management.setGridColor(new java.awt.Color(51, 51, 51));
        table_Menu_Management.setRowHeight(50);
        table_Menu_Management.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_Menu_ManagementMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_Menu_Management);
        if (table_Menu_Management.getColumnModel().getColumnCount() > 0) {
            table_Menu_Management.getColumnModel().getColumn(0).setResizable(false);
        }

        Bottom.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_dog_tag_50px.png"))); // NOI18N

        txtNameMenu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtNameMenu.setLabelText("Tên món");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_price_50px.png"))); // NOI18N

        txtUnitPrice.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtUnitPrice.setLabelText("Giá tiền");

        Image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_cafe_96px.png"))); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Categorize_50px.png"))); // NOI18N

        cbbCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Đồ ăn", "Nước uống" }));
        cbbCategory.setSelectedIndex(-1);
        cbbCategory.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbbCategory.setLabeText("Thể loại");

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

        btnchosseImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_choose_40px.png"))); // NOI18N
        btnchosseImage.setText("Chọn ảnh");
        btnchosseImage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnchosseImage.setRound(15);
        btnchosseImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnchosseImageMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNameMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnchosseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUnitPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(62, 62, 62)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNameMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUnitPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnchosseImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
            .addComponent(Image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Bottom.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        add(Bottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        LoadDBThucDon();
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnAddMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMenuMouseClicked
        ToggleEdit(true);
    }//GEN-LAST:event_btnAddMenuMouseClicked

    private void btnRepairMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRepairMenuMouseClicked
        ToggleEdit(true);
    }//GEN-LAST:event_btnRepairMenuMouseClicked

    private void btnchosseImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnchosseImageMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnchosseImageMouseEntered

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnCancelMouseEntered

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        ToggleEdit(false);
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        ClearEdit();
        ToggleEdit(false);
    }//GEN-LAST:event_btnCancelMouseClicked

    private void table_Menu_ManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_Menu_ManagementMouseClicked
        int x = table_Menu_Management.getSelectedRow();
        if (x >= 0) {
            td.SetMaMon(String.valueOf(table_Menu_Management.getValueAt(x, 0)));
            System.err.println(td.GetMaMon());
    }//GEN-LAST:event_table_Menu_ManagementMouseClicked
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        //-----------Insert----------//
        if (xacNhan == 0) {
            if (txtNameMenu.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập tên thực đơn");
            }
            if (cbbCategory.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập loại thực đơn");
            }
            if (txtUnitPrice.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập giá thực đơn");
            } else {
                ThucDon.InsertThucDon(txtNameMenu.getText(), String.valueOf(cbbCategory.getSelectedItem()), Integer.parseInt(txtUnitPrice.getText()));
            }
            LoadDBThucDon();
            ToggleEdit(false);
            ClearEdit();
            
          //------------Edit-----------//
        } else if (xacNhan == 1) {
            if (txtNameMenu.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập tên thực đơn");
            }
            if (cbbCategory.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập loại thực đơn");
            }
            if (txtUnitPrice.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập giá thực đơn");
            } else {
                ThucDon.EditThucDon(Integer.parseInt(td.GetMaMon()), txtNameMenu.getText(), String.valueOf(cbbCategory.getSelectedItem()), Integer.parseInt(txtUnitPrice.getText()));
            }
            LoadDBThucDon();
            ToggleEdit(false);
            ClearEdit();

        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMenuActionPerformed
        ToggleEdit(true);
        xacNhan = 0;
        txtNameMenu.requestFocus();
    }//GEN-LAST:event_btnAddMenuActionPerformed

    private void btnRepairMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepairMenuActionPerformed

        if (td.GetMaMon() == "") {
            JOptionPane.showMessageDialog(new JFrame(), "Vui lòng chọn món");
        } else {
            ToggleEdit(true);
            xacNhan = 1;
        }
    }//GEN-LAST:event_btnRepairMenuActionPerformed

    private void btnDeleteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMenuActionPerformed
        if (td.GetMaMon() == "") {
            JOptionPane.showMessageDialog(new JFrame(), "Vui lòng chọn món");

        } else {
            ThucDon.DeleteThucDon(Integer.parseInt(td.GetMaMon()));
            LoadDBThucDon();
        }
    }//GEN-LAST:event_btnDeleteMenuActionPerformed

    private void ToggleEdit(boolean state) {
        btnchosseImage.setVisible(state);
        btnCancel.setVisible(state);
        btnSave.setVisible(state);
        txtNameMenu.setEditable(state);
        txtUnitPrice.setEditable(state);
        cbbCategory.setEnabled(state);
    }

    private void ClearEdit() {
        txtNameMenu.setText("");
        txtUnitPrice.setText("");
        cbbCategory.setSelectedItem(-1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bottom;
    private javax.swing.JLabel Image;
    private javax.swing.JPanel Top;
    private UserControl.GradientButtom btnAddMenu;
    private UserControl.JButtonCustom btnCancel;
    private UserControl.GradientButtom btnDeleteMenu;
    private UserControl.GradientButtom btnRepairMenu;
    private UserControl.JButtonCustom btnSave;
    private UserControl.JButtonCustom btnchosseImage;
    private UserControl.JComboboxCustom cbbCategory;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private UserControl.TableDark table_Menu_Management;
    private UserControl.TextField txtNameMenu;
    private UserControl.TextFieldAnimation txtSearch;
    private UserControl.TextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables
}
