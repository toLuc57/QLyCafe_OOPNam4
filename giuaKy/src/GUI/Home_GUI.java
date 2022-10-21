package GUI;

import DTO.Ban;
import DTO.HoaDon;
import DTO.NhanVien;
import UserControl.tableObject;
import UserControl.WrapLayout;
import Util.dbUtil;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Home_GUI extends javax.swing.JFrame {

    int idtable = 0;
    int mahd = 0;
    NhanVien nv = new NhanVien();
    double totalmoney = 0;
    public Home_GUI() {
        initComponents();

        loadTable();
        lbMaNV.setText(nv.getMaNhanVien());

    }
    // ----------------Load Table---------------------

    public void loadTable() {
        pnlListTables.removeAll();

        dbUtil conn = new dbUtil();
        dbUtil.getConnection();
        List<Ban> l = conn.GetBan();

        pnlListTables.setLayout(new WrapLayout(WrapLayout.LEFT, 20, 10));
        for (Ban item : l) {
            tableObject btn = new tableObject();
            btn.setIDTable(item.getMaBan());
            btn.setSlot(item.getSoLuongGhe());
            if (TonTaiBill(idtable)) {
                btn.setStatusTable("1");
            } else {
                btn.setStatusTable(String.valueOf(item.getTinhTrang()));
            }

            //---------Click chon ban
            btn.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    idtable = btn.getIDTable();
                    System.err.println("Mã bàn: " + idtable);
                    GetMaHD(idtable);
                    clear_Table();
                    try {
                        LoadHoaDonBan();
                    } catch (SQLException ex) {
                        Logger.getLogger(Home_GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //-------- Cick CheckOut-----------
                    btnCheckout.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if(TonTaiBill(idtable)){
                             HoaDon.UpdateTrangThaiHoaDon(idtable,totalmoney);
                            Ban.UpdateTrangThaiBan(idtable);
                            loadTable();
                            clear_Table();
                            lblTotalMoney.setText("0.00 VNÐ");
                        }
                            else{
                                  JOptionPane.showMessageDialog(new JFrame(), "Bàn "+ idtable +" hiện đang trống hóa đơn!");
                                    }
                           
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }

            });
            pnlListTables.add(btn);
            pnlListTables.repaint();
            pnlListTables.revalidate();

        }
        //--------------Them Mon- Mo Menu-------

        btnAdd.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(idtable);
                if (idtable > 0) {
                    Menu_GUI menu = new Menu_GUI(idtable);
                    Home_GUI.this.dispose();
                    menu.setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(new JFrame(), "Vui lòng chọn bàn");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
               
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
             
            }
        });

    }

    private void clear_Table() {
        DefaultTableModel tbModel = (DefaultTableModel) tbBill.getModel();
        tbModel.setNumRows(0);
    }

    public void LoadHoaDonBan() throws SQLException {
        Connection conn = dbUtil.getConnection();
       
        lblTotalMoney.setText("0.00 VNÐ");
        String sql = "select  p.TenThucDon,ct.SoLuong , p.GiaTien from HoaDon as hd,ChiTietHoaDon as ct, ThucDon as p where hd.SoBan = " + idtable + "and ct.MaHoaDon = hd.MaHoaDon and ct.IDThucDon = p.IDThucDon and hd.TrangThai=0;";
        ResultSet rs = dbUtil.ThucThiSelect(sql);
        DefaultTableModel tbModel = (DefaultTableModel) tbBill.getModel();
        Object[] obj = new Object[4];
        try {
            while (rs.next()) {

                obj[0] = tbBill.getRowCount() + 1;
                obj[1] = rs.getString("TenThucDon");
                obj[2] = rs.getInt("SoLuong");
                obj[3] = rs.getInt("GiaTien");
                tbModel.addRow(obj);
                totalmoney += (rs.getInt("SoLuong") * rs.getInt("GiaTien"));
                lblTotalMoney.setText(String.valueOf(totalmoney) + " VNÐ");
            }
            dbUtil.CloseConnection(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Loi load Ban");
        }

    }

    public boolean TonTaiBill(int Ban) {
        String sql = "select * from HoaDon where SoBan= '" + Ban + "' and TrangThai=0";
        Connection conn = dbUtil.getConnection();
        ResultSet rs;
        try {
            rs = dbUtil.ThucThiSelect(sql);
            if (rs.next()) {
                return true;

            }
            dbUtil.CloseConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(Menu_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public int GetMaHD(int idtable) {
        Connection conn = dbUtil.getConnection();
        String sql = "Select * from HoaDon where SoBan = " + idtable;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                mahd = rs.getInt("MaHoaDon");
            }

            dbUtil.CloseConnection(conn);
        } catch (SQLException ex) {
            System.out.println("Loi GetMaHD");
        }
        return mahd;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnMain = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnAcount = new javax.swing.JLabel();
        btnManagement = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        lbMaNV = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnSwitch = new UserControl.JButtonCustom();
        btnAdd = new UserControl.JButtonCustom();
        lblTableID = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBill = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        lblTotalMoney = new javax.swing.JLabel();
        btnDiscount = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        lblSurcharge = new javax.swing.JTextField();
        btnSurchange = new UserControl.JButtonCustom();
        btnCheckout = new UserControl.JButtonCustom();
        pnlShowTable = new javax.swing.JPanel();
        srctable = new javax.swing.JScrollPane();
        pnlListTables = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setName("frm_Home"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        jpnMain.setBackground(new java.awt.Color(0, 51, 51));
        jpnMain.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.white, new java.awt.Color(204, 204, 204), java.awt.Color.white));
        jpnMain.setLayout(new javax.swing.BoxLayout(jpnMain, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnAcount.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAcount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAcount.setText("Tài khoản");
        btnAcount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAcountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAcountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAcountMouseExited(evt);
            }
        });

        btnManagement.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnManagement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnManagement.setText("Chủ quán");
        btnManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManagementMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManagementMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnManagementMouseExited(evt);
            }
        });

        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_close_window_30px.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });

        lbMaNV.setText("Mã nhân viên");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAcount, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177)
                .addComponent(lbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcount)
                    .addComponent(btnManagement)
                    .addComponent(lbMaNV))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setOpaque(false);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        btnSwitch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Switch_50px_3.png"))); // NOI18N
        btnSwitch.setText("Chuyển bàn");
        btnSwitch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSwitch.setRound(30);
        btnSwitch.setStyle(UserControl.JButtonCustom.ButtonStyle.DESTRUCTIVE);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Add_Property_50px.png"))); // NOI18N
        btnAdd.setText("Thêm món");
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setRound(30);
        btnAdd.setStyle(UserControl.JButtonCustom.ButtonStyle.DESTRUCTIVE);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblTableID.setFont(new java.awt.Font("UTM Alexander", 1, 18)); // NOI18N
        lblTableID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTableID.setText("Bàn số : 1 (Khu A)");
        lblTableID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTableIDMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTableID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSwitch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTableID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.BorderLayout());

        tbBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên Món", "Số lượng", "Giá"
            }
        ));
        tbBill.setRowHeight(30);
        jScrollPane1.setViewportView(tbBill);

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        lblTotalMoney.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotalMoney.setText("0.00 VND");
        lblTotalMoney.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel5.setBackground(new java.awt.Color(250, 244, 244));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel5.setText("Giảm giá:");

        lblSurcharge.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblSurcharge.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lblSurcharge.setText("0.00 VND");
        lblSurcharge.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        btnSurchange.setText("Phụ thu");
        btnSurchange.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnSurchange.setRound(10);
        btnSurchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSurchangeActionPerformed(evt);
            }
        });

        btnCheckout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_checkout_50px.png"))); // NOI18N
        btnCheckout.setText("Thanh toán");
        btnCheckout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCheckout.setRound(40);
        btnCheckout.setStyle(UserControl.JButtonCustom.ButtonStyle.DESTRUCTIVE);
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDiscount))
                    .addComponent(lblTotalMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSurcharge)
                    .addComponent(btnSurchange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSurchange, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSurcharge, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlShowTable.setBackground(new java.awt.Color(255, 255, 255));
        pnlShowTable.setLayout(new java.awt.BorderLayout());

        pnlListTables.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlListTablesLayout = new javax.swing.GroupLayout(pnlListTables);
        pnlListTables.setLayout(pnlListTablesLayout);
        pnlListTablesLayout.setHorizontalGroup(
            pnlListTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 943, Short.MAX_VALUE)
        );
        pnlListTablesLayout.setVerticalGroup(
            pnlListTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );

        srctable.setViewportView(pnlListTables);

        pnlShowTable.add(srctable, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlShowTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlShowTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jpnMain.add(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSurchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSurchangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSurchangeActionPerformed

    private void lblTableIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTableIDMouseClicked

    }//GEN-LAST:event_lblTableIDMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/icons8_close_window_30px.png"));
        btnClose.setIcon(ii);
    }//GEN-LAST:event_btnCloseMouseExited

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/icons8_close_window_30px_1.png"));
        btnClose.setIcon(ii);
    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked

        int select = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất không?");
        if (select == 0) {
            this.dispose();
            new login_GUI().setVisible(false);
        }
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnManagementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagementMouseExited
        btnManagement.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnManagementMouseExited

    private void btnManagementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagementMouseEntered
        btnManagement.setForeground(Color.BLUE);
    }//GEN-LAST:event_btnManagementMouseEntered

    private void btnManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagementMouseClicked
        btnManagement.setForeground(Color.RED);
    }//GEN-LAST:event_btnManagementMouseClicked

    private void btnAcountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAcountMouseExited
        btnAcount.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnAcountMouseExited

    private void btnAcountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAcountMouseEntered
        btnAcount.setForeground(Color.BLUE);
    }//GEN-LAST:event_btnAcountMouseEntered

    private void btnAcountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAcountMouseClicked
        btnAcount.setForeground(Color.RED);
    }//GEN-LAST:event_btnAcountMouseClicked

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed

    }//GEN-LAST:event_btnCheckoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame h = new Home_GUI();
                h.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAcount;
    private UserControl.JButtonCustom btnAdd;
    private UserControl.JButtonCustom btnCheckout;
    private javax.swing.JLabel btnClose;
    private javax.swing.JSpinner btnDiscount;
    private javax.swing.JLabel btnManagement;
    private UserControl.JButtonCustom btnSurchange;
    private UserControl.JButtonCustom btnSwitch;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnMain;
    private javax.swing.JLabel lbMaNV;
    private javax.swing.JTextField lblSurcharge;
    private javax.swing.JLabel lblTableID;
    private javax.swing.JLabel lblTotalMoney;
    private javax.swing.JPanel pnlListTables;
    private javax.swing.JPanel pnlShowTable;
    private javax.swing.JScrollPane srctable;
    private javax.swing.JTable tbBill;
    // End of variables declaration//GEN-END:variables
}
