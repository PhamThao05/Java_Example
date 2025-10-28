package GUI;

import BUS.TacGiaBUS;
import javax.swing.table.DefaultTableModel;
import DAL.TacGiaDAL;
import DTO.TacGia;
import java.util.List;
import javax.swing.JOptionPane;

public class fTacGia extends javax.swing.JFrame {

    public fTacGia() {
        initComponents();
        load();
    }

    public void load() {
        loadTBL();
    }

    public void loadTBL() {
        try {
            DefaultTableModel md = new DefaultTableModel();
            md.addColumn("Mã Tác Giả");
            md.addColumn("Tên Tác Giả");

            List<TacGia> tacGia = TacGiaBUS.loadTbaleData();

            for (TacGia tg : tacGia) {
                int ma = tg.getMa_tac_gia();
                String ten = tg.getTen_tac_gia();

                md.addRow(new Object[]{ma, ten});
            }
            jTB_tacGia.setModel(md);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi xử lý dữ liệu" + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void loadTBL_Search(String keyword) {
        try {
            DefaultTableModel md = new DefaultTableModel();
            md.addColumn("Mã Tác Giả");
            md.addColumn("Tên Tác Giả");

            List<TacGia> tacgia = TacGiaBUS.loadTbaleDataSearch(keyword);

            for (TacGia tg : tacgia) {
                int ma = tg.getMa_tac_gia();
                String ten = tg.getTen_tac_gia();

                md.addRow(new Object[]{ma, ten});
            }
            jTB_tacGia.setModel(md);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi Load dữ liệu" + e.getMessage(), "lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void clearForm() {
        txt_maTG.setText("");
        txt_tenTG.setText("");
    }
    
    public boolean validateForm() {
    String mes = "";

    // Kiểm tra mã tác giả
    if (txt_maTG.getText().trim().isEmpty()) {
        mes += " Mã tác giả";
        txt_maTG.requestFocus();
    }

    // Kiểm tra tên tác giả
    if (txt_tenTG.getText().trim().isEmpty()) {
        mes += " Tên tác giả";
        txt_tenTG.requestFocus();
    }

    // Nếu có lỗi, hiển thị thông báo và trả về false
    if (!mes.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Không để trống: "+mes, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        return false;
    }

    return true; // Form hợp lệ
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_maTG = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_tenTG = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTB_tacGia = new javax.swing.JTable();
        btn_xoa = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        txt_timkiem = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
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
        setTitle("Quản lý tác giả");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 242, 203));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_maTG.setEditable(false);
        txt_maTG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_maTG.setEnabled(false);
        txt_maTG.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_maTG, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 481, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(248, 155, 40));
        jLabel6.setText("Mã tác giả:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 47, 100, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 155, 40));
        jLabel1.setText("Tên tác giả:  ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 86, 100, -1));

        txt_tenTG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_tenTG.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txt_tenTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenTGActionPerformed(evt);
            }
        });
        jPanel1.add(txt_tenTG, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 481, -1));

        jTB_tacGia.setForeground(new java.awt.Color(248, 155, 40));
        jTB_tacGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã tên giả", "Tên tác giả"
            }
        ));
        jTB_tacGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_tacGiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTB_tacGia);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 184, 640, 234));

        btn_xoa.setBackground(new java.awt.Color(255, 255, 255));
        btn_xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(248, 155, 40));
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/delete.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        btn_them.setBackground(new java.awt.Color(255, 255, 255));
        btn_them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_them.setForeground(new java.awt.Color(248, 155, 40));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/plus.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        jPanel1.add(btn_them, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        txt_timkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_timkiem.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_timkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 210, -1));

        btn_timkiem.setBackground(new java.awt.Color(255, 255, 255));
        btn_timkiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_timkiem.setForeground(new java.awt.Color(248, 155, 40));
        btn_timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/search.png"))); // NOI18N
        btn_timkiem.setText("Tìm Kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });
        jPanel1.add(btn_timkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, -1));

        btn_sua.setBackground(new java.awt.Color(255, 255, 255));
        btn_sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(248, 155, 40));
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/edit.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 450));

        jMenuBar_sach.setBackground(new java.awt.Color(255, 242, 203));
        jMenuBar_sach.setForeground(new java.awt.Color(0, 0, 0));

        menu_Sach.setText("Quản lý sách");
        menu_Sach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_SachMouseClicked(evt);
            }
        });
        jMenuBar_sach.add(menu_Sach);

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

        menu_qlTacGia.setForeground(new java.awt.Color(248, 155, 40));
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

    private void txt_tenTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenTGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenTGActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        try {
            if (TacGiaDAL.checkEmpty(txt_maTG.getText())) {
                int ma = Integer.parseInt(txt_maTG.getText());
            TacGiaDAL.xoa(ma);
            load();
            clearForm();
            JOptionPane.showMessageDialog(null, "Xóa Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Xóa thất bại! Tác giả đang tồn tại bảng sách.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Mã không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xóa thất bại! Vui lòng kiểm tra mã.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        try {
            if (validateForm()) {
                 TacGia tg = new TacGia(
                txt_tenTG.getText()
            );
            
            TacGiaBUS.themTG(tg);
            load();
            clearForm();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm không thành công"+e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        try {
            String search = txt_timkiem.getText();
            if (search.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Chưa có dữ liệu đầu vào", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }else{
                loadTBL_Search(search);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        try {
            if (validateForm()) {
                TacGia tg = new TacGia(
                Integer.parseInt(txt_maTG.getText()),
                txt_tenTG.getText()
            );
            
            TacGiaBUS.suaTG(tg);
            JOptionPane.showMessageDialog(null, "Sửa Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            load();
            clearForm();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sửa không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void jTB_tacGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_tacGiaMouseClicked
        int current = jTB_tacGia.getSelectedRow();
        txt_maTG.setText(String.valueOf(jTB_tacGia.getValueAt(current, 0)));
        txt_tenTG.setText(String.valueOf(jTB_tacGia.getValueAt(current, 1)));
    }//GEN-LAST:event_jTB_tacGiaMouseClicked

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
                fTacGia tacGiaFrame = new fTacGia();
                tacGiaFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                tacGiaFrame.setLocationRelativeTo(null);
                tacGiaFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar_sach;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTB_tacGia;
    private javax.swing.JMenu menu_Sach;
    private javax.swing.JMenu menu_dxuat;
    private javax.swing.JMenu menu_muonTra;
    private javax.swing.JMenu menu_qlDocGia;
    private javax.swing.JMenu menu_qlTacGia;
    private javax.swing.JMenu menu_qlTheLoai;
    private javax.swing.JMenu menu_thongKe;
    private javax.swing.JMenu menu_thuThu;
    private javax.swing.JTextField txt_maTG;
    private javax.swing.JTextField txt_tenTG;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
