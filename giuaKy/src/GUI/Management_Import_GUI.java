package GUI;

import DTO.NhanVien;
import DTO.PhieuNhap;
import DTO.SanPhamTho;
import UserControl.MessageDialog;
import Util.dbUtil;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Management_Import_GUI extends javax.swing.JPanel {

    NhanVien nv = new NhanVien();
    private static List<SanPhamTho> listmenu = new ArrayList<>();
    private String nameStaff;
    private String nameProduct;
    double totalmoney;
    PhieuNhap pn = new PhieuNhap();

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;

    }

    public Management_Import_GUI() {
        initComponents();
        ToggleEdit(false);

        List<String> listTenSanPham = GetTenSanPham();
        for (String sanpham : listTenSanPham) {
            cbbChosseProduct.addItem(sanpham);
            cbbNameProductFilter.addItem(sanpham);
            
        }
         List<String> listMaNhanVien = maNhanVien();
        for (String nhanvien : listMaNhanVien) {
            cbbNameNvFilter.addItem(nhanvien);

        }
        
        
        
    
        if(cbbNameNvFilter.getSelectedItem()==null){
          nameStaff = "";
        }else{
            nameStaff = cbbNameNvFilter.getSelectedItem().toString();
        }
        if(cbbNameProductFilter.getSelectedItem()==null){
            nameProduct = "";
        }else{
            nameProduct = cbbNameProductFilter.getSelectedItem().toString();
        }
        System.err.println("Tên san pham"+nameProduct);
        System.err.println("Ma nhan Vien: "+nameStaff);
        
        LoadDBPhieuNhap();
             
    }
    public void LoadDBPhieuNhap() {
        try {
            clear_TableReal();
            Connection conn = dbUtil.getConnection();
            String sql;
            if("".equals(txtDateFrom.getText()) && "".equals(txtDateto.getText()))
            {
               sql= "select * from PhieuNhap,ChiTietNhap,SanPhamTho where ChiTietNhap.SoPhieuNhap = PhieuNhap.SoPhieuNhap and SanPhamTho.MaSanPham = ChiTietNhap.MaSanPham and SanPhamTho.MaSanPham like N'%"+ txtSearchImport.getText()+"%' and SanPhamTho.TenSanPham like N'%"+nameProduct+"%' and PhieuNhap.MaNhanVien like '%"+nameStaff+"%'";
            }
            else{
              sql = "select * from PhieuNhap,ChiTietNhap,SanPhamTho where ChiTietNhap.SoPhieuNhap = PhieuNhap.SoPhieuNhap and SanPhamTho.MaSanPham = ChiTietNhap.MaSanPham and SanPhamTho.MaSanPham like N'%"+ txtSearchImport.getText()+"%' and SanPhamTho.TenSanPham like N'%"+nameProduct+"%' and PhieuNhap.MaNhanVien like '%"+nameStaff+"%' and NgayNhap BETWEEN '"+txtDateFrom.getText()+"'  and '"+txtDateto.getText()+"'";
            }
           
            ResultSet rs = dbUtil.ThucThiSelect(sql);
            DefaultTableModel tbModel = (DefaultTableModel) table_Import_Management.getModel();
            Object[] obj = new Object[5];
            while (rs.next()) {
                obj[0] = rs.getInt("SoPhieuNhap");
                obj[1] = rs.getString("TenSanPham");
                obj[2] = rs.getString("NgayNhap");
                obj[3] = rs.getInt("SoLuong");
                obj[4] = rs.getInt("TongTien");
                tbModel.addRow(obj);
            }
            dbUtil.CloseConnection(conn);

        } catch (SQLException ex) {
            Logger.getLogger(Management_Staff_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 

    private void cloneLoadTable() {
        clear_Table();
        totalmoney = 0;
        lblShowToltalMoney.setText("");
        DefaultTableModel tbModel = (DefaultTableModel) tbImport.getModel();
        Object[] obj = new Object[5];
        for (SanPhamTho item2 : listmenu) {
            obj[0] = item2.getMaSanPhan();
            obj[1] = item2.getTenSanPham();
            obj[2] = item2.getDonViTinh();
            obj[3] = item2.getSoLuong();
            obj[4] = item2.getGiaTien();
            tbModel.addRow(obj);
            totalmoney += (item2.getSoLuong() * item2.getGiaTien());
            setTotalmoney(totalmoney);
            lblShowToltalMoney.setText(String.valueOf(getTotalmoney()) + " VNĐ");
        }
    }

    private void clear_Table() {
        DefaultTableModel tbModel = (DefaultTableModel) tbImport.getModel();
        tbModel.setNumRows(0);
    }
     private void clear_TableReal() {
        DefaultTableModel tbModel1 = (DefaultTableModel) table_Import_Management.getModel();
        tbModel1.setNumRows(0);
    }

    private void ToggleEdit(boolean state) {
        panelShowAddUpdate.setVisible(state);
    }

    private void ClearEdit() {
        cbbChosseProduct.setSelectedIndex(-1);
        nbrSLImport.setValue(0);
        clearTable();
        lblShowToltalMoney.setText("0 VNĐ");
    }

    private void clearTable() {
        DefaultTableModel tbmodel = (DefaultTableModel) tbImport.getModel();
        tbmodel.setNumRows(0);
    }

    public List<String> GetTenSanPham() {
        String SanPham = "";
        List<String> ls = new ArrayList<>();
        Connection conn = dbUtil.getConnection();
        String sql = "Select distinct TenSanPham from SanPhamTho";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ls.add("");
            while (rs.next()) {
                ls.add(rs.getString("TenSanPham"));

            }

        } catch (SQLException ex) {
            System.out.println("lỗi Get TenSanPham");
        }
        return ls;

    }
        public List<String> maNhanVien() {
        int manv = 0;
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
            System.out.println("lỗi Get maNhanVien");
        }
        return ls;

    }

    public String getDonViTinh(String tenSp) {
        Connection conn = dbUtil.getConnection();
        String donvitinh = "";
        String sql = "Select * from SanPhamTho where TenSanPham =N'" + tenSp + "'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                donvitinh = rs.getString("DonViTinh");
            }

            dbUtil.CloseConnection(conn);
        } catch (SQLException ex) {
            System.out.println("Loi GetDonViTinh");
        }
        return donvitinh;
    }

    public int getGia(String tenSp) {
        Connection conn = dbUtil.getConnection();
        int gia = 0;
        String sql = "Select * from SanPhamTho where TenSanPham = N'" + tenSp + "'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                gia = rs.getInt("GiaTien");
            }

            dbUtil.CloseConnection(conn);
        } catch (SQLException ex) {
            System.out.println("Loi GiaTien ");
        }
        return gia;
    }

    public int getMaSP(String tenSp) {
        Connection conn = dbUtil.getConnection();
        int masp = 0;
        String sql = "Select * from SanPhamTho where TenSanPham = N'" + tenSp + "'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                masp = rs.getInt("MaSanPham");
            }

            dbUtil.CloseConnection(conn);
        } catch (SQLException ex) {
            System.out.println("Loi getMaSp ");
        }
        return masp;
    }

    private void FindTenSP(int SL, SanPhamTho m) {
        List<SanPhamTho> l = new ArrayList<>();
        boolean exist = false;
        for (SanPhamTho item : listmenu) {
            if (m.getTenSanPham() == item.getTenSanPham()) {
                item.setSoLuong(item.getSoLuong() + SL);
                l.add(item);
                exist = true;
            } else {
                l.add(item);
            }
        }
        if (!exist) {
            l.add(m);
        }
        listmenu = l;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateFrom = new DateTimePicker.DateChooser();
        dateTo = new DateTimePicker.DateChooser();
        Top = new javax.swing.JPanel();
        txtSearchImport = new UserControl.TextFieldAnimation();
        btnAddImport = new UserControl.GradientButtom();
        btnRepairImport = new UserControl.GradientButtom();
        btnDeleteImport = new UserControl.GradientButtom();
        cbbNameProductFilter = new UserControl.JComboboxCustom();
        cbbNameNvFilter = new UserControl.JComboboxCustom();
        txtDateFrom = new javax.swing.JTextField();
        txtDateto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnFilterImport = new UserControl.GradientButtom();
        Bottom = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Import_Management = new UserControl.TableDark();
        panelShowAddUpdate = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cbbChosseProduct = new UserControl.JComboboxCustom();
        nbrSLImport = new UserControl.Spinner();
        jLabel3 = new javax.swing.JLabel();
        jButtonCustom1 = new UserControl.JButtonCustom();
        jPanel2 = new javax.swing.JPanel();
        lblShowToltalMoney = new javax.swing.JLabel();
        btnAccept = new UserControl.JButtonCustom();
        btnCloseFormAddUpdate = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbImport = new UserControl.TableDark();

        dateFrom.setDateFormat("yyyy-MM-dd");
        dateFrom.setTextRefernce(txtDateFrom);

        dateTo.setDateFormat("yyyy-MM-dd");
        dateTo.setTextRefernce(txtDateto);

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        Top.setBackground(new java.awt.Color(0, 102, 102));
        Top.setOpaque(false);

        txtSearchImport.setAnimationColor(new java.awt.Color(204, 0, 153));
        txtSearchImport.setHintText("Tìm theo mã phiếu...");
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
        btnAddImport.setText("Nhập");
        btnAddImport.setColor1(new java.awt.Color(51, 0, 153));
        btnAddImport.setColor2(new java.awt.Color(102, 0, 102));
        btnAddImport.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnAddImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImportActionPerformed(evt);
            }
        });

        btnRepairImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_screwdriver_emoji_30px.png"))); // NOI18N
        btnRepairImport.setText("Sửa phiếu");
        btnRepairImport.setColor1(new java.awt.Color(0, 102, 102));
        btnRepairImport.setColor2(new java.awt.Color(51, 102, 0));
        btnRepairImport.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnRepairImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepairImportActionPerformed(evt);
            }
        });

        btnDeleteImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_30px.png"))); // NOI18N
        btnDeleteImport.setText("Xóa");
        btnDeleteImport.setColor1(new java.awt.Color(255, 255, 0));
        btnDeleteImport.setColor2(new java.awt.Color(255, 0, 0));
        btnDeleteImport.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnDeleteImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteImportActionPerformed(evt);
            }
        });

        cbbNameProductFilter.setBackground(new java.awt.Color(254, 201, 149));
        cbbNameProductFilter.setLabeText("Tên sản phẩm");

        cbbNameNvFilter.setBackground(new java.awt.Color(254, 201, 149));
        cbbNameNvFilter.setLabeText("Nhân viên nhập");
        cbbNameNvFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNameNvFilterActionPerformed(evt);
            }
        });

        txtDateFrom.setText("");

        txtDateto.setText("");

        jLabel1.setLabelFor(txtDateFrom);
        jLabel1.setText("Từ ngày:");

        jLabel2.setLabelFor(txtDateto);
        jLabel2.setText("Đến ngày:");

        btnFilterImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_filter_30px.png"))); // NOI18N
        btnFilterImport.setText("Lọc");
        btnFilterImport.setColor1(new java.awt.Color(102, 102, 255));
        btnFilterImport.setColor2(new java.awt.Color(153, 0, 255));
        btnFilterImport.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnFilterImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterImportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchImport, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbNameProductFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbNameNvFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDateto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFilterImport, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddImport, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRepairImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteImport, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopLayout.createSequentialGroup()
                        .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddImport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteImport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRepairImport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNameProductFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbNameNvFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFilterImport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(TopLayout.createSequentialGroup()
                        .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDateto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        add(Top, java.awt.BorderLayout.PAGE_START);

        Bottom.setBackground(new java.awt.Color(0, 0, 0));
        Bottom.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));

        table_Import_Management.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên sản phẩm", "Ngày nhập", "Số lượng", "Tổng tiền"
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
        table_Import_Management.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_Import_ManagementMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_Import_Management);

        Bottom.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        panelShowAddUpdate.setBackground(new java.awt.Color(255, 255, 255));
        panelShowAddUpdate.setMaximumSize(new java.awt.Dimension(1415, 197));
        panelShowAddUpdate.setMinimumSize(new java.awt.Dimension(1415, 197));
        panelShowAddUpdate.setPreferredSize(new java.awt.Dimension(1415, 197));
        panelShowAddUpdate.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 197));

        cbbChosseProduct.setLabeText("Chọn sản phẩm nhập");
        cbbChosseProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChosseProductActionPerformed(evt);
            }
        });

        nbrSLImport.setLabelText("Đơn vị nhập");

        jLabel3.setFont(new java.awt.Font("UTM Amherst", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Chọn số lượng");

        jButtonCustom1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_add_48px.png"))); // NOI18N
        jButtonCustom1.setText("Chọn nhập");
        jButtonCustom1.setFont(new java.awt.Font("UTM Alexander", 0, 24)); // NOI18N
        jButtonCustom1.setRound(30);
        jButtonCustom1.setStyle(UserControl.JButtonCustom.ButtonStyle.DESTRUCTIVE);
        jButtonCustom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCustom1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbChosseProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(nbrSLImport, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbChosseProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbrSLImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelShowAddUpdate.add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 197));

        lblShowToltalMoney.setFont(new java.awt.Font("UTM Flamenco", 0, 18)); // NOI18N
        lblShowToltalMoney.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblShowToltalMoney.setText("5,000,000 VNĐ");

        btnAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Checkmark_64px.png"))); // NOI18N
        btnAccept.setText("Xác nhận");
        btnAccept.setFont(new java.awt.Font("UTM Alexander", 0, 24)); // NOI18N
        btnAccept.setRound(30);
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnCloseFormAddUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCloseFormAddUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_descending_sorting_48px.png"))); // NOI18N
        btnCloseFormAddUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseFormAddUpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseFormAddUpdateMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblShowToltalMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCloseFormAddUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAccept, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblShowToltalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCloseFormAddUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelShowAddUpdate.add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(2147483647, 197));
        jPanel3.setLayout(new java.awt.BorderLayout());

        tbImport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Đơn vị tính", "Số lượng", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbImport);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelShowAddUpdate.add(jPanel3, java.awt.BorderLayout.CENTER);

        Bottom.add(panelShowAddUpdate, java.awt.BorderLayout.PAGE_END);

        add(Bottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchImportActionPerformed
        LoadDBPhieuNhap();
    }//GEN-LAST:event_txtSearchImportActionPerformed

    private void txtSearchImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchImportMouseClicked

    }//GEN-LAST:event_txtSearchImportMouseClicked

    private void btnAddImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImportActionPerformed
        ToggleEdit(true);
        cbbChosseProduct.requestFocus();
    }//GEN-LAST:event_btnAddImportActionPerformed

    private void btnCloseFormAddUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseFormAddUpdateMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnCloseFormAddUpdateMouseEntered

    private void btnCloseFormAddUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseFormAddUpdateMouseClicked
        MessageDialog m = new MessageDialog(new JFrame());
        m.showMessage("Khoan đã!", "Bạn có chắc chắn muốn đóng form nhập hàng chứ? Mọi thông tin nhập sẽ bị hủy bỏ?");
        if (m.getMessageType() == MessageDialog.MessageType.OK) {
            ToggleEdit(false);
            ClearEdit();
        }

    }//GEN-LAST:event_btnCloseFormAddUpdateMouseClicked

    private void btnRepairImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepairImportActionPerformed
        ToggleEdit(true);
        

    }//GEN-LAST:event_btnRepairImportActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // viet code o day nhe quang
        PhieuNhap.CreatePhieuNhap(Integer.parseInt(nv.getMaNhanVien()),getTotalmoney());
        PhieuNhap.CreateChiTietPhieuNhap(getMaSP(String.valueOf(cbbChosseProduct.getSelectedItem())), Integer.parseInt(String.valueOf(nbrSLImport.getValue())));
        ToggleEdit(false);
        ClearEdit();
        LoadDBPhieuNhap();
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void jButtonCustom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCustom1ActionPerformed
        if (Integer.parseInt(String.valueOf(nbrSLImport.getValue())) > 0) {
            SanPhamTho sp = new SanPhamTho(getMaSP(String.valueOf(cbbChosseProduct.getSelectedItem())), String.valueOf(cbbChosseProduct.getSelectedItem()), Integer.parseInt(String.valueOf(nbrSLImport.getValue())), nbrSLImport.getLabelText(), getGia(String.valueOf(cbbChosseProduct.getSelectedItem())));
            if (listmenu.isEmpty()) {
                listmenu.add(sp);
                cloneLoadTable();
            } else {
//                       FindIDMon(t.getSoLuongMon(), m);
                FindTenSP((int) nbrSLImport.getValue(), sp);
                cloneLoadTable();
            }
        } else {
            UserControl.MessagerCustom.MessageDialog m = new UserControl.MessagerCustom.MessageDialog(new JFrame());
            m.showMessage("Lỗi", "Vui lòng chọn số lượng!");
        }
         
    }//GEN-LAST:event_jButtonCustom1ActionPerformed

    private void cbbChosseProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChosseProductActionPerformed
        nbrSLImport.setLabelText(getDonViTinh(String.valueOf(cbbChosseProduct.getSelectedItem())));
    }//GEN-LAST:event_cbbChosseProductActionPerformed

    private void cbbNameNvFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNameNvFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNameNvFilterActionPerformed

    private void btnFilterImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterImportActionPerformed
         LoadDBPhieuNhap();
    }//GEN-LAST:event_btnFilterImportActionPerformed

    private void table_Import_ManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_Import_ManagementMouseClicked
   int x = table_Import_Management.getSelectedRow();
        if (x >= 0) {
            pn.setSoPhieuNhap(Integer.parseInt(String.valueOf(table_Import_Management.getValueAt(x, 0))));
             pn.setTenSP(String.valueOf(table_Import_Management.getValueAt(x, 1)));
              pn.setNgayNhap(String.valueOf(table_Import_Management.getValueAt(x, 2)));
               pn.setSoLuong(Integer.parseInt(String.valueOf(table_Import_Management.getValueAt(x, 3))));
                pn.setTongTien(Integer.parseInt(String.valueOf(table_Import_Management.getValueAt(x, 4))));
            System.err.println(pn.getSoPhieuNhap());
    }                   
    }//GEN-LAST:event_table_Import_ManagementMouseClicked

    private void btnDeleteImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteImportActionPerformed
      if(pn.getSoPhieuNhap()==0){
          JOptionPane.showMessageDialog(new JFrame(), "Vui lòng chọn phiếu nhập");
      }
      else{
          PhieuNhap.DeletePhieuNhap(pn.getSoPhieuNhap());
      }
    }//GEN-LAST:event_btnDeleteImportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bottom;
    private javax.swing.JPanel Top;
    private UserControl.JButtonCustom btnAccept;
    private UserControl.GradientButtom btnAddImport;
    private javax.swing.JLabel btnCloseFormAddUpdate;
    private UserControl.GradientButtom btnDeleteImport;
    private UserControl.GradientButtom btnFilterImport;
    private UserControl.GradientButtom btnRepairImport;
    private UserControl.JComboboxCustom cbbChosseProduct;
    private UserControl.JComboboxCustom cbbNameNvFilter;
    private UserControl.JComboboxCustom cbbNameProductFilter;
    private DateTimePicker.DateChooser dateFrom;
    private DateTimePicker.DateChooser dateTo;
    private UserControl.JButtonCustom jButtonCustom1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblShowToltalMoney;
    private UserControl.Spinner nbrSLImport;
    private javax.swing.JPanel panelShowAddUpdate;
    private UserControl.TableDark table_Import_Management;
    private UserControl.TableDark tbImport;
    private javax.swing.JTextField txtDateFrom;
    private javax.swing.JTextField txtDateto;
    private UserControl.TextFieldAnimation txtSearchImport;
    // End of variables declaration//GEN-END:variables
}
