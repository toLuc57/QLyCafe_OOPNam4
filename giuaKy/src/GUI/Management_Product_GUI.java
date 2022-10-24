/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DTO.SanPhamTho;
import DTO.ThucDon;
import Util.dbUtil;
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
 * @author trant
 */
public class Management_Product_GUI extends javax.swing.JPanel {
    private String Stringprice="";
    private long Longprice=0;
    int xacNhan=0;
    SanPhamTho sp = new SanPhamTho();
    public Management_Product_GUI() {
        initComponents();
        ToggleEdit(false);
        LoadDBSanPham();
    }
     public void LoadDBSanPham() {
        try {
            clear_Table();
            Connection conn = dbUtil.getConnection();
            String sql = "select * from SanPhamTho where TenSanPham like '%" + txtSearchProduct.getText() + "%'" + "or MaSanPham like '%" + txtSearchProduct.getText() + "%'";
            ResultSet rs = dbUtil.ThucThiSelect(sql);
            DefaultTableModel tbModel = (DefaultTableModel) table_Product_Management.getModel();
            Object[] obj = new Object[5];
            while (rs.next()) {

                obj[0] = rs.getInt("MaSanPham");
                obj[1] = rs.getString("TenSanPham");
                obj[2] = rs.getInt("SoLuong");
                obj[3] = rs.getString("DonViTinh");
                obj[4] = rs.getInt("GiaTien");
                tbModel.addRow(obj);

            }
            dbUtil.CloseConnection(conn);

        } catch (SQLException ex) {
            Logger.getLogger(Management_Staff_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  private void clear_Table() {
        DefaultTableModel tbModel = (DefaultTableModel) table_Product_Management.getModel();
        tbModel.setNumRows(0);
    }
    private void ToggleEdit(boolean state) {
        btnCancel.setVisible(state);
        btnSave.setVisible(state);
        txtNumberProduct.setEditable(state);
        txtUnitPrice.setEditable(state);
        cbbUnitProduct.setEnabled(state);
    }
    private void ClearEdit() {
        txtNumberProduct.setText("");
        txtUnitPrice.setText("");
        cbbUnitProduct.setSelectedItem(-1);
        txtNumberProduct.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Top = new javax.swing.JPanel();
        txtSearchProduct = new UserControl.TextFieldAnimation();
        btnAddProduct = new UserControl.GradientButtom();
        btnRepairProduct = new UserControl.GradientButtom();
        btnDeleteProduct = new UserControl.GradientButtom();
        Bottom = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Product_Management = new UserControl.TableDark();
        jPanel1 = new javax.swing.JPanel();
        txtNumberProduct = new UserControl.TextField();
        txtUnitPrice = new UserControl.TextField();
        cbbUnitProduct = new UserControl.JComboboxCustom();
        btnSave = new UserControl.JButtonCustom();
        btnCancel = new UserControl.JButtonCustom();
        jLabel1 = new javax.swing.JLabel();
        txtNameProduct = new UserControl.TextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        Top.setBackground(new java.awt.Color(0, 102, 102));
        Top.setOpaque(false);

        txtSearchProduct.setAnimationColor(new java.awt.Color(0, 153, 51));
        txtSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchProductActionPerformed(evt);
            }
        });

        btnAddProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_add_30px.png"))); // NOI18N
        btnAddProduct.setText("Thêm");
        btnAddProduct.setColor1(new java.awt.Color(51, 0, 153));
        btnAddProduct.setColor2(new java.awt.Color(102, 0, 102));
        btnAddProduct.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        btnRepairProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_screwdriver_emoji_30px.png"))); // NOI18N
        btnRepairProduct.setText("Sửa");
        btnRepairProduct.setColor1(new java.awt.Color(0, 102, 102));
        btnRepairProduct.setColor2(new java.awt.Color(51, 102, 0));
        btnRepairProduct.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnRepairProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepairProductActionPerformed(evt);
            }
        });

        btnDeleteProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_30px.png"))); // NOI18N
        btnDeleteProduct.setText("Xóa");
        btnDeleteProduct.setColor1(new java.awt.Color(255, 255, 0));
        btnDeleteProduct.setColor2(new java.awt.Color(255, 0, 0));
        btnDeleteProduct.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnRepairProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRepairProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        add(Top, java.awt.BorderLayout.PAGE_START);

        Bottom.setBackground(new java.awt.Color(0, 0, 0));
        Bottom.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));

        table_Product_Management.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên sản phẩm", "Số lượng", "Đơn vị tính", "Giá tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Product_Management.setGridColor(new java.awt.Color(51, 51, 51));
        table_Product_Management.setRowHeight(50);
        table_Product_Management.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_Product_ManagementMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_Product_Management);

        Bottom.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtNumberProduct.setLabelText("Số lượng");

        txtUnitPrice.setLabelText("Đơn giá nhập");
        txtUnitPrice.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtUnitPriceInputMethodTextChanged(evt);
            }
        });
        txtUnitPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUnitPriceKeyTyped(evt);
            }
        });

        cbbUnitProduct.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lon", "Túi", "Ký", "100 gam", "Hộp", "Chai", "Cái" }));
        cbbUnitProduct.setSelectedIndex(-1);
        cbbUnitProduct.setLabeText("Đơn vị tính");

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_orange_128px.png"))); // NOI18N

        txtNameProduct.setLabelText("Tên sản phẩm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbUnitProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNameProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumberProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNumberProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbUnitProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Bottom.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        add(Bottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    
    private void txtSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchProductActionPerformed
        LoadDBSanPham();
    }//GEN-LAST:event_txtSearchProductActionPerformed

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

    private void txtUnitPriceInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtUnitPriceInputMethodTextChanged
        System.out.println("test nhan");
    }//GEN-LAST:event_txtUnitPriceInputMethodTextChanged

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        ToggleEdit(true);
         xacNhan = 0;
        txtNameProduct.requestFocus();
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnRepairProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepairProductActionPerformed
          if (sp.getMaSanPhan() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Vui lòng chọn Sản Phẩm");
        } else {
            ToggleEdit(true);
            xacNhan = 1;
            txtNameProduct.setText(String.valueOf(sp.getTenSanPham()));
            txtNumberProduct.setText(String.valueOf(sp.getSoLuong()));
            txtUnitPrice.setText(String.valueOf(sp.getGiaTien()));
            cbbUnitProduct.setSelectedItem(sp.getDonViTinh());
        }
    }//GEN-LAST:event_btnRepairProductActionPerformed

    private void txtUnitPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnitPriceKeyTyped
        //Day là sự kiện khi nhập giá tiền
        char c = evt.getKeyChar();
           if(c<=57&&c>=48 || c==8) {
                System.out.println("Vua moi bam phim dung la phim = "+c);
          }
    }//GEN-LAST:event_txtUnitPriceKeyTyped

    private void table_Product_ManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_Product_ManagementMouseClicked
           int x = table_Product_Management.getSelectedRow();
        if (x >= 0) {
            sp.setMaSanPhan(Integer.parseInt(String.valueOf(table_Product_Management.getValueAt(x, 0))));
            sp.setTenSanPham(String.valueOf(table_Product_Management.getValueAt(x, 1)));
            sp.setSoLuong(Integer.parseInt(String.valueOf(table_Product_Management.getValueAt(x, 2))));
            sp.setDonViTinh((String.valueOf(table_Product_Management.getValueAt(x, 3))));
            sp.setGiaTien(Integer.parseInt(String.valueOf(table_Product_Management.getValueAt(x, 4))));
                
    }        
    }//GEN-LAST:event_table_Product_ManagementMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        //-----------Insert----------//
        if (xacNhan == 0) {
            if (txtNameProduct.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập tên sản phảm");
            }
            if (txtNumberProduct.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập số lượng sản phẩm");
            }
            if (cbbUnitProduct.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập Đơn vị tính sản phẩm");
            }
            if (txtUnitPrice.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập giá Thực phẩm");
            } else {
                SanPhamTho.InsertSanPham(txtNameProduct.getText(), Integer.parseInt(txtNumberProduct.getText()),String.valueOf(cbbUnitProduct.getSelectedItem()),Integer.parseInt(txtUnitPrice.getText()));
            }
            LoadDBSanPham();
            ToggleEdit(false);
            ClearEdit();
            
          //------------Edit-----------//
        } else if (xacNhan == 1) {
            if (txtNameProduct.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập tên sản phảm");
            }
            if (txtNumberProduct.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập số lượng sản phẩm");
            }
            if (cbbUnitProduct.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập Đơn vị tính sản phẩm");
            }
            if (txtUnitPrice.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập giá Thực phẩm");
            } else {
                SanPhamTho.EditSanPham(txtNameProduct.getText(), Integer.parseInt(txtNumberProduct.getText()),String.valueOf(cbbUnitProduct.getSelectedItem()),Integer.parseInt(txtUnitPrice.getText()),sp.getMaSanPhan());
            }
            LoadDBSanPham();
            ToggleEdit(false);
            ClearEdit();

        }      
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
  if (sp.getMaSanPhan() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Vui lòng chọn Sản Phẩm");
        } else {
        SanPhamTho.DeleteSanPham(sp.getMaSanPhan());
        LoadDBSanPham();
            JOptionPane.showMessageDialog(new JFrame(), "Xóa sản phẩm thành công");
        }        
    }//GEN-LAST:event_btnDeleteProductActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bottom;
    private javax.swing.JPanel Top;
    private UserControl.GradientButtom btnAddProduct;
    private UserControl.JButtonCustom btnCancel;
    private UserControl.GradientButtom btnDeleteProduct;
    private UserControl.GradientButtom btnRepairProduct;
    private UserControl.JButtonCustom btnSave;
    private UserControl.JComboboxCustom cbbUnitProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private UserControl.TableDark table_Product_Management;
    private UserControl.TextField txtNameProduct;
    private UserControl.TextField txtNumberProduct;
    private UserControl.TextFieldAnimation txtSearchProduct;
    private UserControl.TextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables
}
