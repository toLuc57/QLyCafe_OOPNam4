/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Util.dbUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trant
 */
public class Management_Product_GUI extends javax.swing.JPanel {

    /**
     * Creates new form Management_Product_GUI
     */
    public Management_Product_GUI() {
        initComponents();
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

        btnRepairProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_screwdriver_emoji_30px.png"))); // NOI18N
        btnRepairProduct.setText("Sửa");
        btnRepairProduct.setColor1(new java.awt.Color(0, 102, 102));
        btnRepairProduct.setColor2(new java.awt.Color(51, 102, 0));
        btnRepairProduct.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N

        btnDeleteProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_30px.png"))); // NOI18N
        btnDeleteProduct.setText("Xóa");
        btnDeleteProduct.setColor1(new java.awt.Color(255, 255, 0));
        btnDeleteProduct.setColor2(new java.awt.Color(255, 0, 0));
        btnDeleteProduct.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnRepairProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
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
        jScrollPane2.setViewportView(table_Product_Management);

        Bottom.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(Bottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchProductActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bottom;
    private javax.swing.JPanel Top;
    private UserControl.GradientButtom btnAddProduct;
    private UserControl.GradientButtom btnDeleteProduct;
    private UserControl.GradientButtom btnRepairProduct;
    private javax.swing.JScrollPane jScrollPane2;
    private UserControl.TableDark table_Product_Management;
    private UserControl.TextFieldAnimation txtSearchProduct;
    // End of variables declaration//GEN-END:variables
}
