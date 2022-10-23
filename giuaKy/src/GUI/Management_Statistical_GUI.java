/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import chart.LineChart;
import chart.ModelChart;
import java.awt.Color;


/**
 *
 * @author trant
 */
public class Management_Statistical_GUI extends javax.swing.JPanel {

    /**
     * Creates new form Management_Statistical_GUI
     */
    public Management_Statistical_GUI() {
        initComponents();
        panelChartLine.setVisible(false);
        chart.addLegend("Thu vào", Color.green, Color.black);
        chart.addLegend("Chi ra", Color.red, Color.black);
        chart.addLegend("Lợi nhuận", Color.yellow, Color.black);
        chart.addData(new ModelChart("Thứ 2", new double[]{3500,500,3000}));
        chart.addData(new ModelChart("Thứ 3", new double[]{4500,2500,2000}));
        chart.addData(new ModelChart("Thứ 4", new double[]{6000,1500,4500}));
        chart.addData(new ModelChart("Thứ 5", new double[]{3500,500,3000}));
        chart.addData(new ModelChart("Thứ 6", new double[]{4500,2500,2000}));
        chart.addData(new ModelChart("Thứ 7", new double[]{6000,1500,4500}));
        chart.addData(new ModelChart("Chủ nhật", new double[]{3500,500,3000}));
        chart.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtDateFrom = new UserControl.TextField();
        txtDateto = new UserControl.TextField();
        jLabel4 = new javax.swing.JLabel();
        nbrChooseMonth = new UserControl.Spinner();
        nbrChooseYear = new UserControl.Spinner();
        btnthongketuan = new UserControl.JButtonCustom();
        btnthongkeThang = new UserControl.JButtonCustom();
        jPanel2 = new javax.swing.JPanel();
        panelChartLine = new javax.swing.JPanel();
        chartLine = new chart.LineChart();
        jPanel4 = new javax.swing.JPanel();
        chart = new chart.Chart();

        setBackground(new java.awt.Color(0, 50, 50));
        setMaximumSize(new java.awt.Dimension(1200, 570));
        setMinimumSize(new java.awt.Dimension(1200, 570));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);

        jPanel3.setBackground(new java.awt.Color(30, 90, 90));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logoquan.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("UTM Alexander", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thống kê dòng tiền");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(30, 90, 90));

        jLabel3.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("+ Thống kê theo ngày / tuần");

        txtDateFrom.setBackground(new java.awt.Color(30, 90, 90));
        txtDateFrom.setForeground(new java.awt.Color(255, 255, 255));
        txtDateFrom.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        txtDateFrom.setLabelText("Từ ngày");

        txtDateto.setBackground(new java.awt.Color(30, 90, 90));
        txtDateto.setForeground(new java.awt.Color(255, 255, 255));
        txtDateto.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        txtDateto.setLabelText("Đến ngày");

        jLabel4.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("+ Thống kê theo tháng cố định");

        nbrChooseMonth.setBackground(new java.awt.Color(30, 90, 90));
        nbrChooseMonth.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        nbrChooseMonth.setLabelText("Chọn tháng");

        nbrChooseYear.setBackground(new java.awt.Color(30, 90, 90));
        nbrChooseYear.setModel(new javax.swing.SpinnerNumberModel(2020, 2020, 2023, 1));
        nbrChooseYear.setLabelText("Chọn năm");

        btnthongketuan.setText("Thống kê");
        btnthongketuan.setFont(new java.awt.Font("UTM Alexander", 0, 18)); // NOI18N
        btnthongketuan.setRound(20);
        btnthongketuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthongketuanActionPerformed(evt);
            }
        });

        btnthongkeThang.setText("Thống kê");
        btnthongkeThang.setFont(new java.awt.Font("UTM Alexander", 0, 18)); // NOI18N
        btnthongkeThang.setRound(20);
        btnthongkeThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthongkeThangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDateFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDateto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(nbrChooseMonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nbrChooseYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnthongketuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnthongkeThang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDateto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnthongketuan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nbrChooseMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nbrChooseYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnthongkeThang, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        panelChartLine.setMaximumSize(new java.awt.Dimension(991, 240));
        panelChartLine.setMinimumSize(new java.awt.Dimension(991, 240));
        panelChartLine.setOpaque(false);
        panelChartLine.setPreferredSize(new java.awt.Dimension(991, 240));
        panelChartLine.setLayout(new java.awt.BorderLayout());
        panelChartLine.add(chartLine, java.awt.BorderLayout.CENTER);

        jPanel2.add(panelChartLine, java.awt.BorderLayout.PAGE_START);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel4.add(chart, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnthongkeThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthongkeThangActionPerformed
        chart.start();
        panelChartLine.setVisible(true);
        chartLine.addLegend("Thu vào", Color.green, Color.black);
        chartLine.addLegend("Chi ra", Color.red, Color.black);
        chartLine.addLegend("Lợi nhuận", Color.yellow, Color.black);
        chartLine.addData(new ModelChart("1", new double[]{3500,500,3000}));
        chartLine.addData(new ModelChart("2", new double[]{4500,2500,2000}));
        chartLine.addData(new ModelChart("3", new double[]{6000,1500,4500}));
        chartLine.addData(new ModelChart("4", new double[]{3500,500,3000}));
        chartLine.addData(new ModelChart("5", new double[]{4500,2500,2000}));
        chartLine.addData(new ModelChart("6", new double[]{6000,1500,4500}));
        chartLine.addData(new ModelChart("7", new double[]{3500,500,3000}));
        chartLine.addData(new ModelChart("8", new double[]{3500,500,3000}));
        chartLine.addData(new ModelChart("9", new double[]{4500,2500,2000}));
        chartLine.addData(new ModelChart("10", new double[]{6000,1500,4500}));
        chartLine.addData(new ModelChart("11", new double[]{3500,500,3000}));
        chartLine.addData(new ModelChart("12", new double[]{4500,2500,2000}));
        chartLine.addData(new ModelChart("13", new double[]{6000,1500,4500}));
        chartLine.addData(new ModelChart("14", new double[]{3500,500,3000}));
        chartLine.addData(new ModelChart("15", new double[]{3500,500,3000}));
        chartLine.addData(new ModelChart("16", new double[]{4500,2500,2000}));
        chartLine.addData(new ModelChart("17", new double[]{6000,1500,4500}));
        chartLine.addData(new ModelChart("18", new double[]{3500,500,3000}));
        chartLine.addData(new ModelChart("19", new double[]{4500,2500,2000}));
        chartLine.addData(new ModelChart("20", new double[]{6000,1500,4500}));
        chartLine.addData(new ModelChart("21", new double[]{3500,500,3000}));
        chartLine.addData(new ModelChart("22", new double[]{3500,500,3000}));
        chartLine.addData(new ModelChart("23", new double[]{4500,2500,2000}));
        chartLine.addData(new ModelChart("24", new double[]{6000,1500,4500}));
        chartLine.addData(new ModelChart("25", new double[]{3500,500,3000}));
        chartLine.addData(new ModelChart("26", new double[]{4500,2500,2000}));
        chartLine.addData(new ModelChart("27", new double[]{6000,1500,4500}));
        chartLine.addData(new ModelChart("28", new double[]{3500,500,3000}));
        chartLine.addData(new ModelChart("29", new double[]{4500,2500,2000}));
        chartLine.addData(new ModelChart("30", new double[]{6000,1500,4500}));
        chartLine.addData(new ModelChart("31", new double[]{3500,500,3000}));
        chartLine.start();
    }//GEN-LAST:event_btnthongkeThangActionPerformed

    private void btnthongketuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthongketuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnthongketuanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UserControl.JButtonCustom btnthongkeThang;
    private UserControl.JButtonCustom btnthongketuan;
    private chart.Chart chart;
    private chart.LineChart chartLine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private UserControl.Spinner nbrChooseMonth;
    private UserControl.Spinner nbrChooseYear;
    private javax.swing.JPanel panelChartLine;
    private UserControl.TextField txtDateFrom;
    private UserControl.TextField txtDateto;
    // End of variables declaration//GEN-END:variables
}
