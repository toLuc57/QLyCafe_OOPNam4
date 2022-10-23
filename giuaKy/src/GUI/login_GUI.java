package GUI;

import DTO.NhanVien;
import java.io.IOException;
import UserControl.PasswordField;
import Util.dbUtil;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import sun.net.www.http.KeepAliveCache;

/**
 *
 * @author tranbathien
 */
public class login_GUI extends javax.swing.JFrame {

    public login_GUI() throws IOException {
        initComponents();
  
       

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbbPosition = new UserControl.JComboboxCustom();
        txtUsername = new UserControl.TextField();
        passwordField1 = new UserControl.PasswordField();
        btnLogin = new UserControl.JButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setName("frmLogin"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel4.setBackground(new java.awt.Color(1, 44, 61));

        jPanel5.setBackground(new java.awt.Color(242, 246, 249));

        jPanel1.setBackground(new java.awt.Color(242, 246, 249));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logoquan.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(242, 246, 249));

        jLabel2.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel2.setText("The Light Coffee");

        jLabel3.setFont(new java.awt.Font("Vijaya", 1, 48)); // NOI18N
        jLabel3.setText("login form");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(34, 34, 34))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_close_30px_1.png"))); // NOI18N
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_username_50px.png"))); // NOI18N
        jLabel5.setLabelFor(txtUsername);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_password_50px.png"))); // NOI18N

        cbbPosition.setBackground(new java.awt.Color(1, 44, 61));
        cbbPosition.setForeground(new java.awt.Color(255, 255, 255));
        cbbPosition.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Staff" }));
        cbbPosition.setSelectedIndex(1);
        cbbPosition.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        cbbPosition.setLabeText("");

        txtUsername.setBackground(new java.awt.Color(1, 44, 61));
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        txtUsername.setLabelText("Username");

        passwordField1.setBackground(new java.awt.Color(1, 44, 61));
        passwordField1.setForeground(new java.awt.Color(255, 255, 255));
        passwordField1.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        passwordField1.setLabelText("Password");

        btnLogin.setText("Login");
        btnLogin.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        btnLogin.setRound(20);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                                    .addComponent(passwordField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(cbbPosition, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnClose)
                .addGap(80, 80, 80)
                .addComponent(cbbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        int select = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đóng ứng dụng chứ?");
        if (select == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
           
            Connection conn = dbUtil.getConnection();
            String name = txtUsername.getText();
            String pass = new String(passwordField1.getPassword());
            String SQL = "select * from NhanVien where MaNhanVien = ? and Matkhau = ?";
            PreparedStatement ps = conn.prepareCall(SQL);
            StringBuilder sb = new StringBuilder();
            ps.setString(1, txtUsername.getText());
            ps.setString(2, passwordField1.getText());
            ResultSet rs = ps.executeQuery();

            if (txtUsername.getText().equals("")) {
                sb.append("Không được để trống tên! \n");
            }
            if (passwordField1.getText().equals("")) {
                sb.append("Không được để trống mật khẩu! \n");

            }
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString(), "Invalidation", JOptionPane.ERROR_MESSAGE);
            
             }
             if(isAdmin() == true && cbbPosition.getSelectedItem() == "Admin") {
                    Management_GUI ql = new Management_GUI();
                    ql.setVisible(true);
             }
             else if(isAdmin() == true && cbbPosition.getSelectedItem() == "Staff") {
                    Home_GUI home = new Home_GUI();
                    home.setVisible(true);
                    NhanVien nv = new NhanVien();
                    nv.setMaNhanVien(name);

                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công với tài khoản Admin: " + txtUsername.getText());
             }
            else if (rs.next() && (isAdmin() == false)) {
                if (cbbPosition.getSelectedItem() == "Staff") {
                    NhanVien nv = new NhanVien();
                    nv.setMaNhanVien(name);
                    Home_GUI home = new Home_GUI();
                    home.setVisible(true);
                    this.dispose();
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công với tài khoản: " + txtUsername.getText());

                }   

            } else {
                JOptionPane.showMessageDialog(this, "Mật khẩu không chính xác");
            }
            dbUtil.CloseConnection(conn);
        } catch (Exception e) {
            System.err.println("Loi Dang Nhap");
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    public boolean isAdmin() {
        boolean isAdmin = false;
        String sql;
        Connection conn = dbUtil.getConnection();

        sql = "Select isAdmin From NhanVien Where MaNhanVien = " + txtUsername.getText() + " AND Matkhau='" + passwordField1.getText() + "'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            rs.next();
            isAdmin = rs.getBoolean("isAdmin");
            System.out.println(isAdmin);

            if (isAdmin == true) {
                return true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }

        return false;

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private UserControl.JButtonCustom btnLogin;
    private UserControl.JComboboxCustom cbbPosition;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private UserControl.PasswordField passwordField1;
    private UserControl.TextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
