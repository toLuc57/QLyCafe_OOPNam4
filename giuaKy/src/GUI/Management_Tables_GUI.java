/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DTO.Ban;
import DTO.ThucDon;
import Util.dbUtil;
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
 * @author lenha
 */
public class Management_Tables_GUI extends javax.swing.JPanel {
    
    Ban ban = new Ban();
    public Management_Tables_GUI() {
        initComponents();
        LoadDBBan();
    }
 public void LoadDBBan() {
        try {
            clear_Table();
            Connection conn = dbUtil.getConnection();
            String sql = "select * from Ban where SoBan like '%"+txtSearchTable.getText()+"%'";
            ResultSet rs = dbUtil.ThucThiSelect(sql);
            DefaultTableModel tbModel = (DefaultTableModel) tb_Tables_Management.getModel();
            Object[] obj = new Object[4];
            while (rs.next()) {
                obj[0] = rs.getString("SoBan");
                obj[1] = rs.getString("LoaiBan");
                obj[2] = rs.getString("SoGhe");
                obj[3] = rs.getString("TinhTrang");
                tbModel.addRow(obj);

            }
            dbUtil.CloseConnection(conn);

        } catch (SQLException ex) {
            Logger.getLogger(Management_Staff_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void clear_Table() {
        DefaultTableModel tbModel = (DefaultTableModel) tb_Tables_Management.getModel();
        tbModel.setNumRows(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Top1 = new javax.swing.JPanel();
        txtSearchTable = new UserControl.TextFieldAnimation();
        btnAddTable = new UserControl.GradientButtom();
        btnRepairTable = new UserControl.GradientButtom();
        btnDeleteTable = new UserControl.GradientButtom();
        Bottom = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_Tables_Management = new UserControl.TableDark();
        jPanel1 = new javax.swing.JPanel();

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        Top1.setBackground(new java.awt.Color(0, 102, 102));
        Top1.setOpaque(false);

        txtSearchTable.setAnimationColor(new java.awt.Color(51, 51, 51));
        txtSearchTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchTableActionPerformed(evt);
            }
        });

        btnAddTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_add_30px.png"))); // NOI18N
        btnAddTable.setText("Thêm");
        btnAddTable.setColor1(new java.awt.Color(51, 0, 153));
        btnAddTable.setColor2(new java.awt.Color(102, 0, 102));
        btnAddTable.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnAddTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTableActionPerformed(evt);
            }
        });

        btnRepairTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_screwdriver_emoji_30px.png"))); // NOI18N
        btnRepairTable.setText("Sửa");
        btnRepairTable.setColor1(new java.awt.Color(0, 102, 102));
        btnRepairTable.setColor2(new java.awt.Color(51, 102, 0));
        btnRepairTable.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N

        btnDeleteTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_30px.png"))); // NOI18N
        btnDeleteTable.setText("Xóa");
        btnDeleteTable.setColor1(new java.awt.Color(255, 255, 0));
        btnDeleteTable.setColor2(new java.awt.Color(255, 0, 0));
        btnDeleteTable.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnDeleteTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Top1Layout = new javax.swing.GroupLayout(Top1);
        Top1.setLayout(Top1Layout);
        Top1Layout.setHorizontalGroup(
            Top1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Top1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchTable, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddTable, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRepairTable, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteTable, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        Top1Layout.setVerticalGroup(
            Top1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Top1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Top1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Top1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddTable, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeleteTable, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRepairTable, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        add(Top1, java.awt.BorderLayout.PAGE_START);

        Bottom.setBackground(new java.awt.Color(0, 0, 0));
        Bottom.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));

        tb_Tables_Management.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Loại bàn", "Số ghế", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Tables_Management.setGridColor(new java.awt.Color(51, 51, 51));
        tb_Tables_Management.setRowHeight(50);
        tb_Tables_Management.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_Tables_ManagementMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_Tables_Management);

        Bottom.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1047, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        Bottom.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        add(Bottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchTableActionPerformed
  
    }//GEN-LAST:event_txtSearchTableActionPerformed

    private void btnAddTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTableActionPerformed
       Ban.InsertBan();
       LoadDBBan();
    }//GEN-LAST:event_btnAddTableActionPerformed

    private void tb_Tables_ManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_Tables_ManagementMouseClicked
         int x = tb_Tables_Management.getSelectedRow();
        if (x >= 0) {
            ban.setMaBan(Integer.parseInt(String.valueOf(tb_Tables_Management.getValueAt(x, 0))));
            System.err.println(ban.getMaBan());
    }                       
    }//GEN-LAST:event_tb_Tables_ManagementMouseClicked

    private void btnDeleteTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTableActionPerformed
       if (ban.getMaBan() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Vui lòng chọn món");

        } else {
            ban.DeleteBan(ban.getMaBan());
            LoadDBBan();
        }
    }//GEN-LAST:event_btnDeleteTableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bottom;
    private javax.swing.JPanel Top1;
    private UserControl.GradientButtom btnAddTable;
    private UserControl.GradientButtom btnDeleteTable;
    private UserControl.GradientButtom btnRepairTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private UserControl.TableDark tb_Tables_Management;
    private UserControl.TextFieldAnimation txtSearchTable;
    // End of variables declaration//GEN-END:variables
}
