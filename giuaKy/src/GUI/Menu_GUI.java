package GUI;

import DTO.Ban;
import DTO.HoaDon;
import DTO.NhanVien;
import DTO.ThucDon;
import DTO.addMenu;
import UserControl.MessagerCustom.MessageDialog;
import UserControl.Spinner;
import UserControl.WrapLayout;
import UserControl.menuObject;
import Util.dbUtil;
import static Util.dbUtil.conn;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.geometry.HPos;
import javax.swing.Action;
import sun.security.util.Length;

public class Menu_GUI extends javax.swing.JFrame {

    int table;
    NhanVien nv = new NhanVien();
    Home_GUI hm = new Home_GUI();
    List<ThucDon> td;
    private static List<addMenu> listmenu = new ArrayList<>();

    public Menu_GUI(int tb) {
        initComponents();
        table = tb;

        dbUtil conn = new dbUtil();
        dbUtil.getConnection();

        List<String> list = conn.GetLoaiThucDon();

        for (String string : list) {
            cbbType.addItem(string);
            cbbType.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loadMenu();
                }
            });
        }
        menuObject t = new menuObject();

        System.err.println("Mã nhân viên: " + nv.getMaNhanVien());
        System.err.println("Mã bàn: " + table);

        loadMenu();

    }

    //----------------Load Menu
    private void loadMenu() {
        pnlShowMenu.removeAll();
        dbUtil conn = new dbUtil();
        dbUtil.getConnection();
        List<ThucDon> l = conn.GetThucDon(txtFind.getText(), cbbType.getSelectedItem().toString());
        pnlShowMenu.setLayout(new WrapLayout(WrapLayout.LEFT, 5, 5));
        for (ThucDon item : l) {
            menuObject t = new menuObject();
            t.setMaMon(item.GetMaMon());
            t.setNameMenu(item.GetTenMon());
            t.setSrcImage("/Images/bacxiu.jpg");
            t.setGia(String.valueOf(item.GetDonGia()));
            pnlShowMenu.add(t);
            pnlShowMenu.repaint();
            pnlShowMenu.revalidate();
            JButton s = t.getBtnAdd();

            //--------------Nut Them Mon----------
            s.addActionListener((ActionEvent e) -> {
                if (t.getSoLuongMon() > 0) {
                     addMenu m = new addMenu(item.GetTenMon(), Integer.parseInt(t.getMaMon()), t.getSoLuongMon(), item.GetDonGia());
                    if (listmenu.isEmpty()) {
                        listmenu.add(m);
                        cloneLoadTable();
                    } else {    
                        FindIDMon(t.getSoLuongMon(),m);
                        cloneLoadTable();
                    }
                } else {
                    MessageDialog m = new MessageDialog(new JFrame());
                    m.showMessage("L?i", "Vui Long Chon So Luong!");
                }
            });
        }
    }

    private void cloneLoadTable() {
        clear_Table(); 
       double  totalmoney = 0;
        DefaultTableModel tbModel = (DefaultTableModel) tbBill.getModel();
        Object[] obj = new Object[4];
        for (addMenu item2 : listmenu) {
            obj[0] = tbBill.getRowCount() + 1;
            obj[1] = item2.getTenmon();
            obj[2] = item2.getSoluong();
            obj[3] = item2.getGia();
            tbModel.addRow(obj);
           
       totalmoney += (item2.getSoluong() * item2.getGia());
       txtTotalmoney.setText(String.valueOf(totalmoney)+" VNÐ");
    
        }
    }

    private void AddMontoDatabase() {
        for (addMenu t : listmenu) {
            if (!TonTaiBill(table)) {
                HoaDon.InsertHoaDon(table, nv.getMaNhanVien());
                HoaDon.InsertChiTietHoaDon(t.getMamon(), t.getSoluong(), t.getGia());
                UpdateTinhTrangBan(table);
                LoadHoaDonTable(table);
            } else {
                if (!TonTaiMon(String.valueOf(t.getMamon()), table)) {
                    HoaDon.InsertChiTietHoaDon(t.getMamon(), t.getSoluong(), t.getGia());
                    LoadHoaDonTable(table);
                } else {
                    UpdateSoLuong(t.getSoluong(), String.valueOf(t.getMamon()));
                    LoadHoaDonTable(table);
                }
            }

        }
    }

    private void FindIDMon(int SL,addMenu m) {
        List<addMenu> l = new ArrayList<>();
        boolean exist = false;
        for (addMenu item : listmenu) {
            if (m.getMamon() == item.getMamon()) {
                item.setSoluong(item.getSoluong() + SL);
                l.add(item);
                exist = true;
            } else {
                l.add(item);
            }
        }
        if(!exist){
            l.add(m);
        }
        listmenu = l;
    }

    private Menu_GUI() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
//---------------- LoadHoaDonVaoTable

    public void LoadHoaDonTable(int idBan) {
        clear_Table();
        Connection conn = dbUtil.getConnection();
        String sql = "select td.IDThucDon, td.TenThucDon,ct.SoLuong, td.GiaTien from ThucDon as td join ChiTietHoaDon as ct on td.IDThucDon = ct.IDThucDon and ct.MaHoaDon in (select hd.MaHoaDon from HoaDon as hd where SoBan =" + idBan + "and TrangThai = 0)";
        try {
            ResultSet rs = dbUtil.ThucThiSelect(sql);
            DefaultTableModel tbModel = (DefaultTableModel) tbBill.getModel();
            Object[] obj = new Object[4];
            while (rs.next()) {
                obj[0] = tbBill.getRowCount();
                obj[1] = rs.getString("TenThucDon");
                obj[2] = rs.getInt("SoLuong");
                obj[3] = rs.getInt("GiaTien");
                tbModel.addRow(obj);
            }
            dbUtil.CloseConnection(conn);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Loi load Thuc Don Ban");
        }

    }

    private void clear_Table() {
        DefaultTableModel tbModel = (DefaultTableModel) tbBill.getModel();
        tbModel.setNumRows(0);
    }

//---------------ton tai mon
    public boolean TonTaiMon(String TenMon, int Ban) {
        int KT;

        Connection conn = dbUtil.getConnection();
        String sql = "select count(IDThucDon) as count from ChiTietHoaDon as ct where ct.IDThucDon  = (select td.IDThucDon from ThucDon as td where td.TenThucDon =N'" + TenMon + "') and MaHoaDon in (select MaHoaDon from HoaDon as hd where hd.SoBan =" + Ban + " and hd.TrangThai = 0)";
        ResultSet rs;
        try {
            rs = dbUtil.ThucThiSelect(sql);
            rs.next();
            KT = rs.getInt("count");
            if (KT == 1) {
                return true;
            }
            dbUtil.CloseConnection(conn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Loi Ton Tai Mon");
        }
        return false;
    }

    //-----------------ton tai bill
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

    //-------------UpdateSoluong
    public int UpdateSoLuong(int sl, String idThucDon) {
        int update = 0;
        Connection cn = dbUtil.getConnection();
        String sql = "update ChiTietHoaDon set SoLuong = SoLuong+" + sl + "where IDThucDon=" + idThucDon + "and MaHoaDon= (select Max(MaHoaDon) from HoaDon)";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
            dbUtil.CloseConnection(conn);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Loi Insert HoaDon");
        }
        return update;
    }

    public int UpdateTinhTrangBan(int maBan) {
        int update = 0;
        Connection cn = dbUtil.getConnection();
        String sql = "update Ban set TinhTrang = 1 where SoBan=" + maBan;
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
            dbUtil.CloseConnection(conn);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Loi Insert HoaDon");
        }
        return update;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        barLeft = new javax.swing.JPanel();
        pnlLogo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlOption = new javax.swing.JPanel();
        cbbType = new UserControl.JComboboxCustom();
        cbbTypeCat = new UserControl.JComboboxCustom();
        btnMenuHot = new UserControl.JButtonCustom();
        barRight = new javax.swing.JPanel();
        rightTop = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtFind = new UserControl.TextField();
        btnFind = new UserControl.JButtonCustom();
        btnClose = new javax.swing.JLabel();
        btnXacNhan = new javax.swing.JButton();
        rightBottom = new javax.swing.JPanel();
        rightBottomRight = new javax.swing.JPanel();
        rBottomRightBottom = new javax.swing.JPanel();
        txtTotalmoney = new javax.swing.JLabel();
        rBottomRightTop = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBill = new javax.swing.JTable();
        rightBottomLeft = new javax.swing.JPanel();
        formShowMenu = new javax.swing.JScrollPane();
        pnlShowMenu = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setName("frm_menu"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        main.setLayout(new java.awt.BorderLayout());

        barLeft.setBackground(new java.awt.Color(0, 51, 51));
        barLeft.setLayout(new java.awt.BorderLayout());

        pnlLogo.setBackground(new java.awt.Color(0, 51, 51));
        pnlLogo.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logoquan.png"))); // NOI18N
        pnlLogo.add(jLabel1, java.awt.BorderLayout.CENTER);

        barLeft.add(pnlLogo, java.awt.BorderLayout.PAGE_START);

        pnlOption.setBackground(new java.awt.Color(0, 51, 51));

        cbbType.setFocusable(false);
        cbbType.setLabeText("Chọn loại");

        cbbTypeCat.setFocusable(false);
        cbbTypeCat.setLabeText("Chọn chi tiết");

        btnMenuHot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_hot_springs_60px.png"))); // NOI18N
        btnMenuHot.setText("Món hot");
        btnMenuHot.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        btnMenuHot.setRound(20);
        btnMenuHot.setStyle(UserControl.JButtonCustom.ButtonStyle.DESTRUCTIVE);

        javax.swing.GroupLayout pnlOptionLayout = new javax.swing.GroupLayout(pnlOption);
        pnlOption.setLayout(pnlOptionLayout);
        pnlOptionLayout.setHorizontalGroup(
            pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOptionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbTypeCat, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(cbbType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenuHot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlOptionLayout.setVerticalGroup(
            pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOptionLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(cbbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(cbbTypeCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnMenuHot, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        barLeft.add(pnlOption, java.awt.BorderLayout.CENTER);

        main.add(barLeft, java.awt.BorderLayout.LINE_START);

        barRight.setBackground(new java.awt.Color(255, 153, 153));
        barRight.setLayout(new java.awt.BorderLayout());

        rightTop.setBackground(new java.awt.Color(255, 255, 255));
        rightTop.setForeground(new java.awt.Color(255, 255, 255));

        jPanel7.setLayout(new java.awt.BorderLayout());

        txtFind.setLabelText("Tìm món");

        btnFind.setText("Tìm kiếm");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
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

        btnXacNhan.setText("Xác nhan");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightTopLayout = new javax.swing.GroupLayout(rightTop);
        rightTop.setLayout(rightTopLayout);
        rightTopLayout.setHorizontalGroup(
            rightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightTopLayout.createSequentialGroup()
                .addGroup(rightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightTopLayout.createSequentialGroup()
                        .addGap(624, 624, 624)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 475, Short.MAX_VALUE))
                    .addGroup(rightTopLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                        .addComponent(btnXacNhan)
                        .addGap(176, 176, 176)))
                .addComponent(btnClose)
                .addContainerGap())
        );
        rightTopLayout.setVerticalGroup(
            rightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightTopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(rightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightTopLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(rightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXacNhan))))
                .addGap(24, 24, 24))
        );

        barRight.add(rightTop, java.awt.BorderLayout.PAGE_START);

        rightBottom.setBackground(new java.awt.Color(204, 255, 102));
        rightBottom.setLayout(new java.awt.BorderLayout());

        rightBottomRight.setLayout(new java.awt.BorderLayout());

        rBottomRightBottom.setBackground(new java.awt.Color(0, 51, 51));
        rBottomRightBottom.setForeground(new java.awt.Color(255, 255, 255));
        rBottomRightBottom.setFont(new java.awt.Font("UTM Colossalis", 0, 24)); // NOI18N
        rBottomRightBottom.setLayout(new java.awt.BorderLayout());

        txtTotalmoney.setFont(new java.awt.Font("UD Digi Kyokasho NK-B", 1, 36)); // NOI18N
        txtTotalmoney.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalmoney.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalmoney.setText("0.00 VND");
        rBottomRightBottom.add(txtTotalmoney, java.awt.BorderLayout.CENTER);

        rightBottomRight.add(rBottomRightBottom, java.awt.BorderLayout.PAGE_END);

        rBottomRightTop.setBackground(new java.awt.Color(255, 255, 255));
        rBottomRightTop.setLayout(new javax.swing.BoxLayout(rBottomRightTop, javax.swing.BoxLayout.LINE_AXIS));

        tbBill.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
        tbBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên món", "Số lượng", "Đơn giá"
            }
        ));
        tbBill.setEnabled(false);
        tbBill.setGridColor(new java.awt.Color(0, 51, 51));
        tbBill.setIntercellSpacing(new java.awt.Dimension(0, 10));
        tbBill.setRowHeight(30);
        tbBill.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tbBill.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbBill.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbBill.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbBill.setShowGrid(true);
        tbBill.setShowVerticalLines(false);
        tbBill.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbBill);

        rBottomRightTop.add(jScrollPane1);

        rightBottomRight.add(rBottomRightTop, java.awt.BorderLayout.CENTER);

        rightBottom.add(rightBottomRight, java.awt.BorderLayout.LINE_END);

        rightBottomLeft.setLayout(new javax.swing.BoxLayout(rightBottomLeft, javax.swing.BoxLayout.LINE_AXIS));

        formShowMenu.setBackground(new java.awt.Color(255, 255, 255));
        formShowMenu.setBorder(null);
        formShowMenu.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        formShowMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        pnlShowMenu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlShowMenuLayout = new javax.swing.GroupLayout(pnlShowMenu);
        pnlShowMenu.setLayout(pnlShowMenuLayout);
        pnlShowMenuLayout.setHorizontalGroup(
            pnlShowMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1334, Short.MAX_VALUE)
        );
        pnlShowMenuLayout.setVerticalGroup(
            pnlShowMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );

        formShowMenu.setViewportView(pnlShowMenu);

        rightBottomLeft.add(formShowMenu);

        rightBottom.add(rightBottomLeft, java.awt.BorderLayout.CENTER);

        barRight.add(rightBottom, java.awt.BorderLayout.CENTER);

        main.add(barRight, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked

        int select = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất không?");
        if (select == 0) {
            this.dispose();

        }
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/icons8_close_window_30px_1.png"));
        btnClose.setIcon(ii);
    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        ImageIcon ii = new ImageIcon(getClass().getResource("/Images/icons8_close_window_30px.png"));
        btnClose.setIcon(ii);
    }//GEN-LAST:event_btnCloseMouseExited

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        this.dispose();
        AddMontoDatabase();
        Home_GUI home = new Home_GUI();
        home.setVisible(true);


    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed

        loadMenu();
    }//GEN-LAST:event_btnFindActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame j = new Menu_GUI();
                j.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barLeft;
    private javax.swing.JPanel barRight;
    private javax.swing.JLabel btnClose;
    private UserControl.JButtonCustom btnFind;
    private UserControl.JButtonCustom btnMenuHot;
    private javax.swing.JButton btnXacNhan;
    private UserControl.JComboboxCustom cbbType;
    private UserControl.JComboboxCustom cbbTypeCat;
    private javax.swing.JScrollPane formShowMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel main;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JPanel pnlOption;
    private javax.swing.JPanel pnlShowMenu;
    private javax.swing.JPanel rBottomRightBottom;
    private javax.swing.JPanel rBottomRightTop;
    private javax.swing.JPanel rightBottom;
    private javax.swing.JPanel rightBottomLeft;
    private javax.swing.JPanel rightBottomRight;
    private javax.swing.JPanel rightTop;
    private javax.swing.JTable tbBill;
    private UserControl.TextField txtFind;
    private javax.swing.JLabel txtTotalmoney;
    // End of variables declaration//GEN-END:variables
}
