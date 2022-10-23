/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Util.dbUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trant
 */
public class Management_Bill_GUI extends javax.swing.JPanel {

   
     
    /**
     * Creates new form Management_Bill_GUI
     */
    public Management_Bill_GUI(){
        initComponents();
   

        List<String> listNV = GetNhanVien();
        for (String nhanvien : listNV) {
            cbbFilterStaff.addItem(nhanvien);
        }

        List<String> listBan = GetSoBan();
        for (String ban : listBan) {
            cbbFilterIdTable.addItem(ban);
        }
        if (cbbFilterIdTable.getSelectedItem() == null) {
            cbbFilterIdTable.getSelectedItem().equals("");
        }

        LoadDBHoaDon();
    }

    public void LoadDBHoaDon() {
        try {
            clear_Table();
            Connection conn = dbUtil.getConnection();
            String sql;
            if (txtDate.getText() == null) {
              txtDate.setText("");
            }
             if("".equals(txtDate.getText())){
                sql = "select *,FORMAT(ThoiGianRa,'dd-MM-yyyy') as tgr from HoaDon where MaNhanVien like '%"+ cbbFilterStaff.getSelectedItem() + "' and SoBan like '%"+ cbbFilterIdTable.getSelectedItem()+"%'";
               
               }else{
                sql = "select *,FORMAT(ThoiGianRa,'dd-MM-yyyy') as tgr from HoaDon where MaNhanVien like '%"+ cbbFilterStaff.getSelectedItem() +"%' and  FORMAT(ThoiGianRa,'dd-MM-yyyy') = '"+txtDate.getText()+"' and SoBan like '%"+ cbbFilterIdTable.getSelectedItem()+"%'";
               }
            ResultSet rs = dbUtil.ThucThiSelect(sql);
            DefaultTableModel tbModel = (DefaultTableModel) table_Bill_Management.getModel();
            Object[] obj = new Object[7];
            while (rs.next()) {
                obj[0] = rs.getInt("MaHoaDon");
                obj[1] = rs.getString("MaNhanVien");
                obj[2] = rs.getString("SoBan");
                obj[3] = rs.getString("ThoiGianVao");
                obj[4] = rs.getString("ThoiGianRa");
                obj[5] = "";
                obj[6] = rs.getString("TongTien");
                tbModel.addRow(obj);

            }
            dbUtil.CloseConnection(conn);

        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(new JFrame(), "Lỗi Load hóa đơn");
        }

    }

    private void clear_Table() {
        DefaultTableModel tbModel = (DefaultTableModel) table_Bill_Management.getModel();
        tbModel.setNumRows(0);
    }

    public List<String> GetNhanVien() {
        String NhanVien = "";
        List<String> ls = new ArrayList<>();
        Connection conn = dbUtil.getConnection();
        String sql = "Select distinct MaNhanVien from NhanVien";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ls.add("");
            while (rs.next()) {
                ls.add(rs.getString("MaNhanVien"));
               
            }

        } catch (SQLException ex) {
            System.out.println("Loi Get NhanVien");
        }
        return ls;

    }

    public List<String> GetSoBan() {
        String Ban = "";
        List<String> ls = new ArrayList<>();
        Connection conn = dbUtil.getConnection();
        String sql = "Select distinct SoBan from Ban";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ls.add("");
            while (rs.next()) {
                ls.add(rs.getString("SoBan"));
               
            }

        } catch (SQLException ex) {
            System.out.println("Loi Get SoBan");
        }
        return ls;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new DateTimePicker.DateChooser();
        Top = new javax.swing.JPanel();
        btnExportList = new UserControl.GradientButtom();
        cbbFilterStaff = new UserControl.JComboboxCustom();
        cbbFilterIdTable = new UserControl.JComboboxCustom();
        btnFilter = new UserControl.GradientButtom();
        txtDate = new UserControl.TextField();
        Bottom = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Bill_Management = new UserControl.TableDark();

        date.setDateFormat("dd-MM-yyyy\n");
        date.setTextRefernce(txtDate);

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        Top.setBackground(new java.awt.Color(0, 102, 102));
        Top.setOpaque(false);

        btnExportList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_print_30px.png"))); // NOI18N
        btnExportList.setText("Xuất");
        btnExportList.setColor1(new java.awt.Color(0, 102, 102));
        btnExportList.setColor2(new java.awt.Color(51, 102, 0));
        btnExportList.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N

        cbbFilterStaff.setBackground(new java.awt.Color(254, 201, 149));
        cbbFilterStaff.setLabeText("Nhân viên lập");
        cbbFilterStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbFilterStaffActionPerformed(evt);
            }
        });

        cbbFilterIdTable.setBackground(new java.awt.Color(254, 201, 149));
        cbbFilterIdTable.setLabeText("Số bàn");
        cbbFilterIdTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbFilterIdTableActionPerformed(evt);
            }
        });

        btnFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_filter_30px.png"))); // NOI18N
        btnFilter.setText("Lọc");
        btnFilter.setColor1(new java.awt.Color(102, 102, 255));
        btnFilter.setColor2(new java.awt.Color(153, 0, 255));
        btnFilter.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        txtDate.setBackground(new java.awt.Color(254, 201, 149));
        txtDate.setLabelText("Thời gian xuất hóa đơn");
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbFilterStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbbFilterIdTable, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExportList, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbFilterIdTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExportList, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cbbFilterStaff, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        add(Top, java.awt.BorderLayout.PAGE_START);

        Bottom.setBackground(new java.awt.Color(0, 0, 0));
        Bottom.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));

        table_Bill_Management.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nhân viên lập", "Bàn", "Thời gian vào", "Thời gian ra", "Tổng phụ thu", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Bill_Management.setGridColor(new java.awt.Color(51, 51, 51));
        table_Bill_Management.setRowHeight(50);
        jScrollPane2.setViewportView(table_Bill_Management);

        Bottom.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(Bottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cbbFilterStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbFilterStaffActionPerformed
       
    }//GEN-LAST:event_cbbFilterStaffActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
 
    }//GEN-LAST:event_txtDateActionPerformed

    private void cbbFilterIdTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbFilterIdTableActionPerformed
    
    }//GEN-LAST:event_cbbFilterIdTableActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
                System.err.println(cbbFilterStaff.getSelectedItem());
        System.err.println(cbbFilterIdTable.getSelectedItem());
        System.err.println(txtDate.getText());
         LoadDBHoaDon();
    }//GEN-LAST:event_btnFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bottom;
    private javax.swing.JPanel Top;
    private UserControl.GradientButtom btnExportList;
    private UserControl.GradientButtom btnFilter;
    private UserControl.JComboboxCustom cbbFilterIdTable;
    private UserControl.JComboboxCustom cbbFilterStaff;
    private DateTimePicker.DateChooser date;
    private javax.swing.JScrollPane jScrollPane2;
    private UserControl.TableDark table_Bill_Management;
    private UserControl.TextField txtDate;
    // End of variables declaration//GEN-END:variables
}
