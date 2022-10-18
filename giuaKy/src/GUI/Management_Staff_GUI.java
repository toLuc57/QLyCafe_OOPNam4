package GUI;

import Util.dbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class Management_Staff_GUI extends javax.swing.JPanel {
    private int idStaff;
    public Management_Staff_GUI() {
        initComponents();
        Connection conn = null;
        
        Vector vctHeader = new Vector();
        vctHeader.add("[MaNhanVien]");
        vctHeader.add("[HoTen]");
        vctHeader.add("[NgaySinh]");
        vctHeader.add("[DiaChi]");
        vctHeader.add("[SDT]");
        vctHeader.add("[Matkhau]");
        vctHeader.add("[ChucVu]");
        Vector vctData = new Vector();
        
        String sql = "SELECT [MaNhanVien],[HoTen],[NgaySinh],[DiaChi],[SDT],[Matkhau],[isAdmin]"
                + " FROM [NhanVien] where isAdmin = 0";
        try {
            conn = dbUtil.getConnection();
            PreparedStatement pstm =  conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                
                String MaNhanVien = rs.getString("MaNhanVien");
                String HoTen = rs.getString("HoTen");
                String NgaySinh = rs.getString("NgaySinh");
                String DiaChi = rs.getString("DiaChi");
                String SDT = rs.getString("SDT");
                String Matkhau = rs.getString("Matkhau");
                String ChucVu = "";   
                if(rs.getBoolean("isAdmin")) {
                    ChucVu = "Admin";
                }
                else {
                    ChucVu = "Nhan Vien";
                }
                Vector record = new Vector();
                record.add(MaNhanVien);
                record.add(HoTen);
                record.add(NgaySinh);
                record.add(DiaChi);
                record.add(SDT);
                record.add(Matkhau);
                record.add(ChucVu);
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

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btnUpdateStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnDeleteStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
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

        tableMenu.setModel(new javax.swing.table.DefaultTableModel(
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
        tableMenu.setGridColor(new java.awt.Color(51, 51, 51));
        tableMenu.setRowHeight(50);
        jScrollPane2.setViewportView(tableMenu);
        if (tableMenu.getColumnModel().getColumnCount() > 0) {
            tableMenu.getColumnModel().getColumn(0).setResizable(false);
        }

        Bottom.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(Bottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchStaffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchStaffActionPerformed


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
