/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DTO.NhanVien;
import UserControl.TextFieldAnimation;
import Util.dbUtil;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
public class Management_Staff_GUI extends javax.swing.JPanel {

    NhanVien nv = new NhanVien();
    public Management_Staff_GUI() {
        initComponents();
        LoadDBNhanVien();
      
         
        
        
      
    }
     public void LoadDBNhanVien(){
        try {
            clear_Table();
            Connection conn = dbUtil.getConnection();
            String sql = "select * from NhanVien where HoTen like '%" + txtSearchStaff.getText() + "%'"+"or MaNhanVien like '%" + txtSearchStaff.getText() + "%'";
            ResultSet rs = dbUtil.ThucThiSelect(sql);
            DefaultTableModel tbModel = (DefaultTableModel) tableMenu.getModel();
            Object[] obj = new Object[8];
            try {
                while (rs.next()) {
                    
                    obj[0] = tableMenu.getRowCount() + 1;
                    obj[1] = rs.getInt("MaNhanVien");
                    obj[2] = rs.getString("HoTen");
                    obj[3] = rs.getString("NgaySinh");
                    obj[4] = rs.getString("DiaChi");
                    obj[5] = rs.getString("SDT");
                    obj[6] = rs.getString("Matkhau");
                    obj[7] = rs.getString("isAdmin");
                    tbModel.addRow(obj);
                    
                }
                dbUtil.CloseConnection(conn);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Loi load NhanVien");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Management_Staff_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Top = new javax.swing.JPanel();
        txtSearchStaff = new UserControl.TextFieldAnimation();
        btnUpdateStaff = new UserControl.GradientButtom();
        btnAddStaff = new UserControl.GradientButtom();
        btnDeleteStaff = new UserControl.GradientButtom();
        Bottom = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMenu = new UserControl.TableDark();

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

        btnAddStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_add_30px.png"))); // NOI18N
        btnAddStaff.setText("Thêm");
        btnAddStaff.setColor1(new java.awt.Color(51, 0, 153));
        btnAddStaff.setColor2(new java.awt.Color(102, 0, 102));
        btnAddStaff.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N

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
                .addComponent(txtSearchStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnUpdateStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnDeleteStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopLayout.createSequentialGroup()
                        .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdateStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtSearchStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(Top, java.awt.BorderLayout.PAGE_START);

        Bottom.setBackground(new java.awt.Color(0, 0, 0));
        Bottom.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));

        tableMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã nhân viên", "Họ tên", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Mật khẩu", "Chức vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMenu.setGridColor(new java.awt.Color(51, 51, 51));
        tableMenu.setRowHeight(50);
        tableMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMenuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableMenu);
        if (tableMenu.getColumnModel().getColumnCount() > 0) {
            tableMenu.getColumnModel().getColumn(0).setResizable(false);
        }

        Bottom.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(Bottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchStaffActionPerformed
        System.err.println("tim tim tim");
        LoadDBNhanVien();
        txtSearchStaff.doLayout();
    }//GEN-LAST:event_txtSearchStaffActionPerformed

        private void clear_Table() {
        DefaultTableModel tbModel = (DefaultTableModel) tableMenu.getModel();
        tbModel.setNumRows(0);
    }
    private void tableMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMenuMouseClicked
       int x = tableMenu.getSelectedRow();
       if(x>=0){
           
           nv.setMaNhanVien(String.valueOf(tableMenu.getValueAt(x, 1)));
           System.err.println(nv.getMaNhanVien());
       
       }
       
       
       
    }//GEN-LAST:event_tableMenuMouseClicked

    private void btnDeleteStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStaffActionPerformed
      NhanVien.DeleteNhanVien(Integer.parseInt(nv.getMaNhanVien()));
      LoadDBNhanVien();
      
    }//GEN-LAST:event_btnDeleteStaffActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bottom;
    private javax.swing.JPanel Top;
    private UserControl.GradientButtom btnAddStaff;
    private UserControl.GradientButtom btnDeleteStaff;
    private UserControl.GradientButtom btnUpdateStaff;
    private javax.swing.JScrollPane jScrollPane2;
    private UserControl.TableDark tableMenu;
    private UserControl.TextFieldAnimation txtSearchStaff;
    // End of variables declaration//GEN-END:variables
}
