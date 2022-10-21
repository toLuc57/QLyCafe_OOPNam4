/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import javax.swing.JOptionPane;


/**
 *
 * @author trant
 */
public class Management_Import_GUI extends javax.swing.JPanel {

    public Management_Import_GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Top = new javax.swing.JPanel();
        txtSearchImport = new UserControl.TextFieldAnimation();
        btnAddImport = new UserControl.GradientButtom();
        btnRepairImport = new UserControl.GradientButtom();
        btnDeleteImport = new UserControl.GradientButtom();
        Bottom = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Import_Management = new UserControl.TableDark();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        Top.setBackground(new java.awt.Color(0, 102, 102));
        Top.setOpaque(false);

        txtSearchImport.setAnimationColor(new java.awt.Color(204, 0, 153));
        txtSearchImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchImportMouseClicked(evt);
            }
        });
        txtSearchImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchImportActionPerformed(evt);
            }
        });

        btnAddImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_add_30px.png"))); // NOI18N
        btnAddImport.setText("Thêm");
        btnAddImport.setColor1(new java.awt.Color(51, 0, 153));
        btnAddImport.setColor2(new java.awt.Color(102, 0, 102));
        btnAddImport.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N

        btnRepairImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_screwdriver_emoji_30px.png"))); // NOI18N
        btnRepairImport.setText("Sửa");
        btnRepairImport.setColor1(new java.awt.Color(0, 102, 102));
        btnRepairImport.setColor2(new java.awt.Color(51, 102, 0));
        btnRepairImport.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N

        btnDeleteImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_30px.png"))); // NOI18N
        btnDeleteImport.setText("Xóa");
        btnDeleteImport.setColor1(new java.awt.Color(255, 255, 0));
        btnDeleteImport.setColor2(new java.awt.Color(255, 0, 0));
        btnDeleteImport.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchImport, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddImport, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnRepairImport, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnDeleteImport, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddImport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeleteImport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRepairImport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        add(Top, java.awt.BorderLayout.PAGE_START);

        Bottom.setBackground(new java.awt.Color(0, 0, 0));
        Bottom.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));

        table_Import_Management.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên sản phẩm", "Ngày nhập", "Số lượng", "Đơn giá nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Import_Management.setGridColor(new java.awt.Color(51, 51, 51));
        table_Import_Management.setRowHeight(50);
        jScrollPane2.setViewportView(table_Import_Management);

        Bottom.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(Bottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchImportActionPerformed
        
    }//GEN-LAST:event_txtSearchImportActionPerformed

    private void txtSearchImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchImportMouseClicked
            
    }//GEN-LAST:event_txtSearchImportMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bottom;
    private javax.swing.JPanel Top;
    private UserControl.GradientButtom btnAddImport;
    private UserControl.GradientButtom btnDeleteImport;
    private UserControl.GradientButtom btnRepairImport;
    private javax.swing.JScrollPane jScrollPane2;
    private UserControl.TableDark table_Import_Management;
    private UserControl.TextFieldAnimation txtSearchImport;
    // End of variables declaration//GEN-END:variables
}
