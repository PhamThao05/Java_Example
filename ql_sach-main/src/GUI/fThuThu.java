package GUI;

import BUS.ThuThuBUS;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import DAL.ThuThuDAL;
import DTO.ThuThu;
import javax.swing.JOptionPane;

public class fThuThu extends javax.swing.JFrame {

    public fThuThu() {
        initComponents();
        load();
    }

    public void load() {
        loadTbl();
        txt_ma.setEditable(false);
        txt_ma.setEnabled(false);
    }

    public void loadTbl() {
        try {
            DefaultTableModel md = new DefaultTableModel();
            md.addColumn("Mã thủ thư ");
            md.addColumn("Tên thủ thư");
            md.addColumn("CMND");
            md.addColumn("SDT");
            md.addColumn("Email");
            md.addColumn("Password");

            List<ThuThu.CTThuThu> cttt = ThuThuBUS.LoadTBDATA();
            for (ThuThu.CTThuThu tt : cttt) {
                int ma = tt.getMa_thu_thu();
                String ten = tt.getTen_thu_thu();
                String cmnd = tt.getCmnd();
                String sdt = tt.getSdt();
                String email = tt.getEmail();
                String pass = tt.getPassword();

                md.addRow(new Object[]{ma, ten, cmnd, sdt, email, pass});
            }
            jTB_thuThu.setModel(md);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi load dữ liệu" + e.getMessage(), "lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void loadTbl_Search(String keyword) {
        try {
            DefaultTableModel md = new DefaultTableModel();
            md.addColumn("Mã thủ thư ");
            md.addColumn("Tên thủ thư");
            md.addColumn("CMND");
            md.addColumn("SDT");
            md.addColumn("Email");
            md.addColumn("Password");

            List<ThuThu.CTThuThu> cttt = ThuThuBUS.LoadtTbDATA_Search(keyword);
            for (ThuThu.CTThuThu tt : cttt) {
                int ma = tt.getMa_thu_thu();
                String ten = tt.getTen_thu_thu();
                String cmnd = tt.getCmnd();
                String sdt = tt.getSdt();
                String email = tt.getEmail();
                String pass = tt.getPassword();

                md.addRow(new Object[]{ma, ten, cmnd, sdt, email, pass});
            }
            jTB_thuThu.setModel(md);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi load dữ liệu" + e.getMessage(), "lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void clearForm() {
        txt_ma.setText("");
        txt_ten.setText("");
        txt_cmnd.setText("");
        txt_email.setText("");
        txt_sdt.setText("");
        txt_password.setText("");
    }

    public boolean valiDateForm() {
        String mes = "";


        // Kiểm tra tên
        if (txt_ten.getText().trim().isEmpty()) {
            mes += "Tên không được để trống.\n";
            txt_ten.requestFocus();
        }

        // Kiểm tra CMND
        if (txt_cmnd.getText().trim().isEmpty()) {
            mes += "CMND không được để trống.\n";
            txt_cmnd.requestFocus();
        } else if (!txt_cmnd.getText().trim().matches("\\d{9,12}")) { // CMND phải từ 9 đến 12 chữ số
            mes += "CMND phải từ 9 đến 12 chữ số.\n";
            txt_cmnd.requestFocus();
        }

        // Kiểm tra email
        if (txt_email.getText().trim().isEmpty()) {
            mes += "Email không được để trống.\n";
            txt_email.requestFocus();
        } else if (!txt_email.getText().trim().matches("^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$")) { // Kiểm tra định dạng email
            mes += "Email không hợp lệ.\n";
            txt_email.requestFocus();
        }

        // Kiểm tra số điện thoại
        if (txt_sdt.getText().trim().isEmpty()) {
            mes += "Số điện thoại không được để trống.\n";
            txt_sdt.requestFocus();
        } else if (!txt_sdt.getText().trim().matches("^0\\d{9,11}$")) { // Số điện thoại phải bắt đầu bằng 0 và có 10 đến 12 chữ số
            mes += "Số điện thoại phải bắt đầu bằng 0 và có từ 10 đến 12 chữ số.\n";
            txt_sdt.requestFocus();
        }

        // Kiểm tra mật khẩu
        if (txt_password.getText().trim().isEmpty()) {
            mes += "Mật khẩu không được để trống.\n";
            txt_password.requestFocus();
        }

        // Nếu có lỗi, hiển thị thông báo và trả về false
        if (!mes.isEmpty()) {
            JOptionPane.showMessageDialog(null, mes, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true; // Form hợp lệ
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_sua = new javax.swing.JButton();
        txt_sdt = new javax.swing.JTextField();
        txt_ma = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_xoa = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_timkiem = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTB_thuThu = new javax.swing.JTable();
        txt_email = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        txt_cmnd = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar_sach = new javax.swing.JMenuBar();
        menu_Sach = new javax.swing.JMenu();
        menu_thuThu = new javax.swing.JMenu();
        menu_muonTra = new javax.swing.JMenu();
        menu_qlTheLoai = new javax.swing.JMenu();
        menu_qlDocGia = new javax.swing.JMenu();
        menu_qlTacGia = new javax.swing.JMenu();
        menu_thongKe = new javax.swing.JMenu();
        menu_dxuat = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý thủ thư");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 242, 203));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(248, 155, 40));
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/edit.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 153, -1, -1));

        txt_sdt.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 16, 279, -1));

        txt_ma.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_ma, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 279, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(248, 155, 40));
        jLabel7.setText("SĐT:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 19, 80, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(248, 155, 40));
        jLabel6.setText("Mã Thủ Thư:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 100, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(248, 155, 40));
        jLabel8.setText("Email");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 59, 80, -1));

        btn_xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(248, 155, 40));
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/delete.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 153, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(248, 155, 40));
        jLabel10.setText("PassWord: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 99, 80, -1));

        txt_timkiem.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_timkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 217, -1));

        txt_password.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 96, 279, -1));

        jTB_thuThu.setForeground(new java.awt.Color(248, 155, 40));
        jTB_thuThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Ngôn ngữ", "Giá trị", "Số lượng", "Tác giả", "Thể loại", "Nhà xuất bản", "Năm xuất bản"
            }
        ));
        jTB_thuThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_thuThuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTB_thuThu);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 188, 816, 295));

        txt_email.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 56, 279, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 155, 40));
        jLabel1.setText("Tên Thủ Thư: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 100, -1));

        txt_ten.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txt_ten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenActionPerformed(evt);
            }
        });
        jPanel1.add(txt_ten, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 279, -1));

        btn_them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_them.setForeground(new java.awt.Color(248, 155, 40));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/plus.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        jPanel1.add(btn_them, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 153, -1, -1));

        txt_cmnd.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txt_cmnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cmndActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cmnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 279, -1));

        btn_timkiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_timkiem.setForeground(new java.awt.Color(248, 155, 40));
        btn_timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/search.png"))); // NOI18N
        btn_timkiem.setText("Tìm Kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });
        jPanel1.add(btn_timkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(248, 155, 40));
        jLabel5.setText("CMND:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 510));

        jMenuBar_sach.setBackground(new java.awt.Color(255, 242, 203));
        jMenuBar_sach.setForeground(new java.awt.Color(0, 0, 0));

        menu_Sach.setText("Quản lý sách");
        menu_Sach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_SachMouseClicked(evt);
            }
        });
        jMenuBar_sach.add(menu_Sach);

        menu_thuThu.setForeground(new java.awt.Color(248, 155, 40));
        menu_thuThu.setText("Quản lý thủ thư");
        menu_thuThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_thuThuMouseClicked(evt);
            }
        });
        menu_thuThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_thuThuActionPerformed(evt);
            }
        });
        jMenuBar_sach.add(menu_thuThu);

        menu_muonTra.setText("Quản lý mượn trả sách");
        menu_muonTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_muonTraMouseClicked(evt);
            }
        });
        jMenuBar_sach.add(menu_muonTra);

        menu_qlTheLoai.setText("Quản lý thể loại");
        menu_qlTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_qlTheLoaiMouseClicked(evt);
            }
        });
        jMenuBar_sach.add(menu_qlTheLoai);

        menu_qlDocGia.setText("Quản lý độc giả");
        menu_qlDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_qlDocGiaMouseClicked(evt);
            }
        });
        jMenuBar_sach.add(menu_qlDocGia);

        menu_qlTacGia.setText("Quản lý tác giả");
        menu_qlTacGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_qlTacGiaMouseClicked(evt);
            }
        });
        jMenuBar_sach.add(menu_qlTacGia);

        menu_thongKe.setText("Thống kê");
        menu_thongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_thongKeMouseClicked(evt);
            }
        });
        jMenuBar_sach.add(menu_thongKe);

        menu_dxuat.setText("Đăng xuất");
        menu_dxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_dxuatMouseClicked(evt);
            }
        });
        jMenuBar_sach.add(menu_dxuat);

        setJMenuBar(jMenuBar_sach);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        try {
            if (valiDateForm()) {
                ThuThu.CTThuThu tt = new ThuThu.CTThuThu(
                        Integer.parseInt(txt_ma.getText()),
                        txt_ten.getText(),
                        txt_cmnd.getText(),
                        txt_sdt.getText(),
                        txt_email.getText(),
                        txt_password.getText()
                );

                ThuThuBUS.suaTT(tt);
                JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                load();
                clearForm();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sửa Không Thành Công !!!", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        int ma = Integer.parseInt(txt_ma.getText());
        try {
            if (ThuThuDAL.checkEmpty(txt_ma.getText())) {
                ThuThuBUS.xoaTT(ma);
                JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                load();
                clearForm();
            }else{
                JOptionPane.showMessageDialog(null, "Xóa thất bại! Thủ thư đang tồn tại ở bảng phiếu mượn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Mã không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xóa thất bại! Vui lòng kiểm tra mã.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void jTB_thuThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_thuThuMouseClicked
        int current = jTB_thuThu.getSelectedRow();

        txt_ma.setText(String.valueOf(jTB_thuThu.getValueAt(current, 0)));
        txt_ten.setText(String.valueOf(jTB_thuThu.getValueAt(current, 1)));
        txt_cmnd.setText(String.valueOf(jTB_thuThu.getValueAt(current, 2)));
        txt_sdt.setText(String.valueOf(jTB_thuThu.getValueAt(current, 3)));
        txt_email.setText(String.valueOf(jTB_thuThu.getValueAt(current, 4)));
        txt_password.setText(String.valueOf(jTB_thuThu.getValueAt(current, 5)));
    }//GEN-LAST:event_jTB_thuThuMouseClicked

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_tenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        try {
            if (valiDateForm()) {
                ThuThu tt = new ThuThu(
                        txt_ten.getText(),
                        txt_cmnd.getText(),
                        txt_sdt.getText(),
                        txt_email.getText(),
                        txt_password.getText()
                );

                ThuThuBUS.themTT(tt);
                JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                load();
                clearForm();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm Lỗi !!!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void txt_cmndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cmndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cmndActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        String keyword = txt_timkiem.getText();
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa có dữ liệu tìm kiếm đầu vào", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            load();
        } else {
            loadTbl_Search(keyword);
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void menu_SachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_SachMouseClicked
        fSach sachFrame = new fSach();
        sachFrame.setDefaultCloseOperation(fSach.EXIT_ON_CLOSE);
        sachFrame.setLocationRelativeTo(null);
        sachFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_SachMouseClicked

    private void menu_thuThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_thuThuMouseClicked
        fThuThu thuThuFrame = new fThuThu();
        thuThuFrame.setDefaultCloseOperation(fThuThu.EXIT_ON_CLOSE);
        thuThuFrame.setLocationRelativeTo(null);
        thuThuFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_thuThuMouseClicked

    private void menu_thuThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_thuThuActionPerformed

    }//GEN-LAST:event_menu_thuThuActionPerformed

    private void menu_muonTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_muonTraMouseClicked
        fMuonTra muonTraFrame = new fMuonTra();
        muonTraFrame.setDefaultCloseOperation(fMuonTra.EXIT_ON_CLOSE);
        muonTraFrame.setLocationRelativeTo(null);
        muonTraFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_muonTraMouseClicked

    private void menu_qlTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_qlTheLoaiMouseClicked
        fTheLoai theLoaiFrame = new fTheLoai();
        theLoaiFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        theLoaiFrame.setLocationRelativeTo(null);
        theLoaiFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_qlTheLoaiMouseClicked

    private void menu_qlDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_qlDocGiaMouseClicked
        fDocGia docGiaFrame = new fDocGia();
        docGiaFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        docGiaFrame.setLocationRelativeTo(null);
        docGiaFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_qlDocGiaMouseClicked

    private void menu_qlTacGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_qlTacGiaMouseClicked
        fTacGia tacGiaFrame = new fTacGia();
        tacGiaFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        tacGiaFrame.setLocationRelativeTo(null);
        tacGiaFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_qlTacGiaMouseClicked

    private void menu_thongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_thongKeMouseClicked
        fThongKe thongKeFrame = new fThongKe();
        thongKeFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        thongKeFrame.setLocationRelativeTo(null);
        thongKeFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_thongKeMouseClicked

    private void menu_dxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_dxuatMouseClicked
        // Hiển thị hộp thoại
        int result = JOptionPane.showConfirmDialog(this,
            "Bạn có muốn đăng xuất không?", "Thông báo",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        // Nếu click "yes"
        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã đăng xuất tài khoản thành công");
            this.dispose();

            fDangNhap login = new fDangNhap();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        }
    }//GEN-LAST:event_menu_dxuatMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fThuThu thuThuFrame = new fThuThu();
                thuThuFrame.setDefaultCloseOperation(fThuThu.EXIT_ON_CLOSE);
                thuThuFrame.setLocationRelativeTo(null);
                thuThuFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar_sach;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTB_thuThu;
    private javax.swing.JMenu menu_Sach;
    private javax.swing.JMenu menu_dxuat;
    private javax.swing.JMenu menu_muonTra;
    private javax.swing.JMenu menu_qlDocGia;
    private javax.swing.JMenu menu_qlTacGia;
    private javax.swing.JMenu menu_qlTheLoai;
    private javax.swing.JMenu menu_thongKe;
    private javax.swing.JMenu menu_thuThu;
    private javax.swing.JTextField txt_cmnd;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_ten;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
