package GUI;

import DTO.NhanVien;
import DTO.ThucDon;
import UserControl.loading;
import javax.swing.JFrame;
import UserControl.showFormAddUpdate;
import Util.dbUtil;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tranbathien
 */
public class Management_Menu_GUI extends javax.swing.JPanel {

    private JFrame frame;
    private boolean show;
    ThucDon td = new ThucDon();
    addUpdateMenu_GUI add =new addUpdateMenu_GUI();
    /**
     * Creates new form Management_Menu_GUI
     *
     * @param fram
     */
    public Management_Menu_GUI(JFrame fram) {
        initComponents();
        this.frame = fram;
        LoadDBThucDon();
        
    }

     public void LoadDBThucDon(){
        try {
            clear_Table();
            Connection conn = dbUtil.getConnection();
            String sql = "select * from ThucDon where TenThucDon like '%" + txtSearch.getText() + "%'"+"or IDThucDon like '%" + txtSearch.getText() + "%'";
            ResultSet rs = dbUtil.ThucThiSelect(sql);
            DefaultTableModel tbModel = (DefaultTableModel) table_Menu_Management.getModel();
            Object[] obj = new Object[5];
            while (rs.next()) {
                
                
                obj[0] = rs.getInt("IDThucDon");
                obj[1] = rs.getString("TenThucDon");
                obj[2] = rs.getString("Loai");
                obj[3] = rs.getString("GiaTien");
                obj[4] = rs.getString("HinhAnh");
                tbModel.addRow(obj);
                
            }
            dbUtil.CloseConnection(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(Management_Staff_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     private void clear_Table() {
        DefaultTableModel tbModel = (DefaultTableModel) table_Menu_Management.getModel();
        tbModel.setNumRows(0);
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Top = new javax.swing.JPanel();
        txtSearch = new UserControl.TextFieldAnimation();
        btnAddMenu = new UserControl.GradientButtom();
        btnRepairMenu = new UserControl.GradientButtom();
        btnDeleteMenu = new UserControl.GradientButtom();
        Bottom = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Menu_Management = new UserControl.TableDark();

        setBackground(new java.awt.Color(0, 0, 0));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        Top.setBackground(new java.awt.Color(0, 102, 102));
        Top.setOpaque(false);

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnAddMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_add_30px.png"))); // NOI18N
        btnAddMenu.setText("Thêm");
        btnAddMenu.setColor1(new java.awt.Color(51, 0, 153));
        btnAddMenu.setColor2(new java.awt.Color(102, 0, 102));
        btnAddMenu.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnAddMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMenuMouseClicked(evt);
            }
        });

        btnRepairMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_screwdriver_emoji_30px.png"))); // NOI18N
        btnRepairMenu.setText("Sửa");
        btnRepairMenu.setColor1(new java.awt.Color(0, 102, 102));
        btnRepairMenu.setColor2(new java.awt.Color(51, 102, 0));
        btnRepairMenu.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnRepairMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRepairMenuMouseClicked(evt);
            }
        });

        btnDeleteMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_30px.png"))); // NOI18N
        btnDeleteMenu.setText("Xóa");
        btnDeleteMenu.setColor1(new java.awt.Color(255, 255, 0));
        btnDeleteMenu.setColor2(new java.awt.Color(255, 0, 0));
        btnDeleteMenu.setFont(new java.awt.Font("UTM Alexander", 0, 12)); // NOI18N
        btnDeleteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnAddMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnRepairMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnDeleteMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeleteMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRepairMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        add(Top, java.awt.BorderLayout.PAGE_START);

        Bottom.setBackground(new java.awt.Color(0, 0, 0));
        Bottom.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));

        table_Menu_Management.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên món", "Loại", "Giá", "Ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Menu_Management.setGridColor(new java.awt.Color(51, 51, 51));
        table_Menu_Management.setRowHeight(50);
        table_Menu_Management.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_Menu_ManagementMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_Menu_Management);
        if (table_Menu_Management.getColumnModel().getColumnCount() > 0) {
            table_Menu_Management.getColumnModel().getColumn(0).setResizable(false);
        }

        Bottom.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(Bottom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnAddMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMenuMouseClicked
        if (!show) {
            addUpdateMenu_GUI panel = new addUpdateMenu_GUI();
            showFormAddUpdate a = new showFormAddUpdate(frame, panel);
            a.show();
            JButton btnSave = panel.getBtnSave();
            btnSave.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //viet ham thêm hoặc sửa ở đây
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
            JButton btnClose = panel.getBtnClose();
            btnClose.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    a.hide();
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


    }//GEN-LAST:event_btnAddMenuMouseClicked

    private void btnRepairMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRepairMenuMouseClicked
        loading l = new loading();
        l.show();
    }//GEN-LAST:event_btnRepairMenuMouseClicked

    private void table_Menu_ManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_Menu_ManagementMouseClicked
       int x = table_Menu_Management.getSelectedRow();
       if(x>=0){
           
           td.SetMaMon(String.valueOf(table_Menu_Management.getValueAt(x, 0)));
           System.err.println(td.GetMaMon());
       
       }
       
       
    }//GEN-LAST:event_table_Menu_ManagementMouseClicked

    private void btnDeleteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMenuActionPerformed
      ThucDon.DeleteThucDon(Integer.parseInt(td.GetMaMon()));
      LoadDBThucDon();
    }//GEN-LAST:event_btnDeleteMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bottom;
    private javax.swing.JPanel Top;
    private UserControl.GradientButtom btnAddMenu;
    private UserControl.GradientButtom btnDeleteMenu;
    private UserControl.GradientButtom btnRepairMenu;
    private javax.swing.JScrollPane jScrollPane2;
    private UserControl.TableDark table_Menu_Management;
    private UserControl.TextFieldAnimation txtSearch;
    // End of variables declaration//GEN-END:variables
}
