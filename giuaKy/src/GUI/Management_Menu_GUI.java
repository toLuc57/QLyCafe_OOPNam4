package GUI;

import DTO.ThucDon;
import UserControl.TableDark;
import Util.dbUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Management_Menu_GUI extends javax.swing.JPanel {

    public Management_Menu_GUI() {
        initComponents();
        Connection conn = null;
        
        Vector vctHeader = new Vector();
        vctHeader.add("IDThucDon");
        vctHeader.add("TenThucDon");
        vctHeader.add("Loai");
        vctHeader.add("GiaTien");
        vctHeader.add("HinhAnh");
        Vector vctData = new Vector();
        
        String sql = "SELECT IDThucDon,TenThucDon,Loai,GiaTien,HinhAnh" 
                + " FROM ThucDon";
        try {
            conn = dbUtil.getConnection();
            PreparedStatement pstm =  conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                
                String IDThucDon = rs.getString("IDThucDon");
                String TenThucDon = rs.getString("TenThucDon");
                String Loai = rs.getString("Loai");
                int GiaTien = rs.getInt("GiaTien");
                String HinhAnh = rs.getString("HinhAnh");    
                
                Vector record = new Vector();
                record.add(IDThucDon);
                record.add(TenThucDon);
                record.add(Loai);
                record.add(GiaTien);
                record.add(HinhAnh);
                
                vctData.add(record);
            }
            tableMenu.setModel(new DefaultTableModel(vctData, vctHeader));
            
        } catch (SQLException e){
            e.printStackTrace();
        }        
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
        tableMenu = new UserControl.TableDark();

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

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRepairMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRepairMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        add(Top, java.awt.BorderLayout.PAGE_START);

        Bottom.setBackground(new java.awt.Color(0, 0, 0));
        Bottom.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));

        tableMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "fáadas", "món 1", "dsa", "1232131"},
                {"2", "dá", "đá", "ád", "ádas"},
                {"3", "dá", "ád", "ád", "ádasdas"},
                {"4", "sad", "áda", "áda", "đấ"},
                {"5", "ádas", "adasd", "đá", null}
            },
            new String [] {
                "ID", "Hình ảnh", "Tên món", "Loại", "Giá tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMenu.setGridColor(new java.awt.Color(51, 51, 51));
        tableMenu.setRowHeight(50);
        jScrollPane2.setViewportView(tableMenu);
        if (tableMenu.getColumnModel().getColumnCount() > 0) {
            tableMenu.getColumnModel().getColumn(0).setResizable(false);
        }

        Bottom.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(Bottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    
    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnAddMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMenuActionPerformed
//        Connection conn;
//        String sql = "insert into ThucDon (IDThucDon,TenThucDon,Loai,GiaTien,HinhAnh)"
//                + "values (?,?,?,?,?)";
//        PreparedStatement pstm;
//        try {
//            conn = dbUtil.getConnection();
//            pstm = conn.prepareStatement(sql);
//            pstm.executeUpdate();
//            JOptionPane.showMessageDialog(this, "Them thanh cong!");
//        } catch (SQLException ex) {
//            Logger.getLogger(Management_Menu_GUI.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showInternalMessageDialog(this, "Them that bai!","Loi", JOptionPane.ERROR_MESSAGE);
//        }
               
    }//GEN-LAST:event_btnAddMenuActionPerformed

    private void btnRepairMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepairMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRepairMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bottom;
    private javax.swing.JPanel Top;
    private UserControl.GradientButtom btnAddMenu;
    private UserControl.GradientButtom btnDeleteMenu;
    private UserControl.GradientButtom btnRepairMenu;
    private javax.swing.JScrollPane jScrollPane2;
    private UserControl.TableDark tableMenu;
    private UserControl.TextFieldAnimation txtSearch;
    // End of variables declaration//GEN-END:variables
}
