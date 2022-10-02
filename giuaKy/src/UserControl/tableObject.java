/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserControl;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author tranbathien
 */
public class tableObject extends javax.swing.JPanel {

    private static final String CO_KHACH = "Có khách";
    private static final String TRONG = "Trống";
    private static final String DAT = "Đặt trước";
    private static final String SRC_CO_KHACH = "/Images/icons8_table_top_view_100px_1.png";
    private static final String SRC_TRONG = "/Images/icons8_table_top_view_100px.png";
    private static final String SRC_DAT = "/Images/icons8_table_top_view_100px_2.png";
    private String IDTable;
    private int slot;
    private int freeSlot;
    public tableObject() {
        initComponents();
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setFocusable(true);
    }

    public String getIDTable() {
        return IDTable;
    }
    private void setImage(String src){
        ImageIcon img = new ImageIcon(getClass().getResource(src));
        Image i = img.getImage();
        Image newimg = i.getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        this.lblImageTable.setIcon(new ImageIcon(newimg));
    }
    public void setStatusTable(String status){
        if(status.equals(TRONG)){
            setImage(SRC_TRONG);
            txtStatusTable.setText(TRONG);
            txtStatusTable.setForeground(Color.GREEN);
        }else{
            if(status.equals(CO_KHACH)){
                setImage(SRC_CO_KHACH);
                txtStatusTable.setText(CO_KHACH);
                txtStatusTable.setForeground(Color.YELLOW);
            }else{
                setImage(SRC_DAT);
                txtStatusTable.setText(DAT);
                txtStatusTable.setForeground(Color.RED);
            }
        }
    }
    public void setIDTable(String IDTable) {
        this.IDTable = IDTable;
        txtIdTable.setText(IDTable);
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
        txtSlot.setText("Ghế: "+ String.valueOf(slot));
    }

    public int getFreeSlot() {
        return freeSlot;
    }

    public void setFreeSlot(int customer) {
        this.freeSlot = this.slot - customer;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSlotFree = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtStatusTable = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtSlot = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtIdTable = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblImageTable = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(0, 51, 51));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("UTM Alexander", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Trống");
        jPanel6.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        txtSlotFree.setFont(new java.awt.Font("UTM Akashi", 0, 18)); // NOI18N
        txtSlotFree.setForeground(new java.awt.Color(255, 255, 255));
        txtSlotFree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSlotFree.setText("3");
        jPanel6.add(txtSlotFree, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel6, java.awt.BorderLayout.LINE_END);

        jPanel7.setBackground(new java.awt.Color(0, 51, 51));
        jPanel7.setLayout(new java.awt.BorderLayout());

        txtStatusTable.setFont(new java.awt.Font("UTM Alberta Heavy", 0, 14)); // NOI18N
        txtStatusTable.setForeground(new java.awt.Color(255, 255, 0));
        txtStatusTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusTable.setText("CÓ KHÁCH");
        jPanel7.add(txtStatusTable, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel7, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        txtSlot.setFont(new java.awt.Font("UTM Americana EB", 0, 12)); // NOI18N
        txtSlot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSlot.setText("Ghế : 4");
        jPanel3.add(txtSlot, java.awt.BorderLayout.LINE_END);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("UTM Americana EB", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bàn số:");
        jPanel3.add(jLabel2, java.awt.BorderLayout.LINE_START);

        jPanel5.setLayout(new java.awt.BorderLayout());

        txtIdTable.setBackground(new java.awt.Color(255, 255, 255));
        txtIdTable.setFont(new java.awt.Font("UTM Akashi", 0, 18)); // NOI18N
        txtIdTable.setForeground(new java.awt.Color(255, 255, 255));
        txtIdTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIdTable.setText("05");
        txtIdTable.setEnabled(false);
        txtIdTable.setOpaque(true);
        jPanel5.add(txtIdTable, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        lblImageTable.setBackground(new java.awt.Color(255, 255, 255));
        lblImageTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_table_top_view_100px.png"))); // NOI18N
        jPanel4.add(lblImageTable, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
      
    }//GEN-LAST:event_formFocusGained

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblImageTable;
    private javax.swing.JLabel txtIdTable;
    private javax.swing.JLabel txtSlot;
    private javax.swing.JLabel txtSlotFree;
    private javax.swing.JLabel txtStatusTable;
    // End of variables declaration//GEN-END:variables
}
