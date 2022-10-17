/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserControl;

import GUI.Menu_GUI;
import Util.dbUtil;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tranbathien
 */
public class menuObject extends javax.swing.JPanel {
    private String srcImage;
    private int gia;
    private String nameMenu;
    int soLuongMon;
    private String maMon;

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }
    public menuObject() {
        initComponents();
    }   
    public String getSrcImage() {
        return srcImage;
    }

    public int getSoLuongMon() {
        return (int) nbSL.getValue();
    }

    public void setSrcImage(String srcImage) {
        ImageIcon img = new ImageIcon(getClass().getResource(srcImage));
        Image i = img.getImage();
        Image newimg = i.getScaledInstance(210, 120, Image.SCALE_SMOOTH);
        this.imgMenu.setIcon(new ImageIcon(newimg));
    }

    public int getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.lblUniPrice.setText(gia);
    }

    public String getNameMenu() {
        return nameMenu;
    }

    public void setNameMenu(String nameMenu) {
        this.txtNameMenu.setText(nameMenu);
    }
    
    public JButton getBtnAdd(){
        return btnAddtoBill;
    }
    public Spinner getNbSL(){
        return nbSL;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        imgMenu = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        nbSL = new UserControl.Spinner();
        btnAddtoBill = new UserControl.JButtonCustom();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblUniPrice = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtNameMenu = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new java.awt.BorderLayout());

        imgMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_table_top_view_100px.png"))); // NOI18N
        jPanel1.add(imgMenu, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 204, 255));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        nbSL.setLabelText("Chọn số lượng");
        nbSL.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nbSLStateChanged(evt);
            }
        });

        btnAddtoBill.setText("Thêm vào hóa đơn");
        btnAddtoBill.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddtoBill.setStyle(UserControl.JButtonCustom.ButtonStyle.DESTRUCTIVE);
        btnAddtoBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddtoBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nbSL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddtoBill, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nbSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddtoBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Đơn giá:");
        jPanel6.add(jLabel2, java.awt.BorderLayout.LINE_START);

        lblUniPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUniPrice.setText("0.00");
        jPanel6.add(lblUniPrice, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        txtNameMenu.setBackground(new java.awt.Color(255, 255, 255));
        txtNameMenu.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        txtNameMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNameMenu.setText("Sữa tươi trân châu đường đen");
        jPanel3.add(txtNameMenu, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddtoBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddtoBillActionPerformed
        JOptionPane.showMessageDialog(this, "btnAddtoBillActionPerformed");
    }//GEN-LAST:event_btnAddtoBillActionPerformed

    private void nbSLStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nbSLStateChanged
        int number = (int) nbSL.getValue();
        if(number < 0)
            nbSL.setValue(0);
    }//GEN-LAST:event_nbSLStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UserControl.JButtonCustom btnAddtoBill;
    private javax.swing.JLabel imgMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JLabel lblUniPrice;
    private UserControl.Spinner nbSL;
    private javax.swing.JLabel txtNameMenu;
    // End of variables declaration//GEN-END:variables
}
