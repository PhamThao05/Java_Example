package GUI;

import BUS.DocGiaBUS;
import BUS.LichSuBUS;
import DAL.DocGiaDAL;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import DTO.DocGia;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import java.awt.*;


import javax.swing.JFileChooser;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

public class fDocGia extends javax.swing.JFrame {

    private String maDocGia;
    private String maThuThu;

    public fDocGia() {
        initComponents();
        load();
    }

    public void load() {
        loadTBL();
    }

    SimpleDateFormat fmDate = new SimpleDateFormat("dd-MM-yyyy");

    public void clearForm() {
        txt_maDG.setText("");
        txt_tenDG.setText("");
        txt_ngaySinh.setText("");
        txt_diaChi.setText("");
        txt_CCCD.setText("");
        txt_SDT.setText("");
    }

    public boolean valueDate() {
        String mes = " ";
        if (txt_maDG.getText().trim().isEmpty()) {
            mes = mes + " Mã độc giả";
            txt_maDG.requestFocus();
        }
        if (txt_tenDG.getText().trim().isEmpty()) {
            mes = mes + " Tên độc giả";
            txt_tenDG.requestFocus();
        }
        if (txt_ngaySinh.getText().trim().isEmpty()) {
            mes = mes + " Ngày sinh";
            txt_ngaySinh.requestFocus();
        } else if (txt_diaChi.getText().trim().isEmpty()) {
            mes = mes + " Địa chỉ";
            txt_diaChi.requestFocus();
        }

        // Kiểm tra CCCD
        String cccd = txt_CCCD.getText().trim();
        if (cccd.isEmpty()) {
            mes = mes + " CCCD";
            txt_CCCD.requestFocus();
        } else if (cccd.length() < 9 || cccd.length() > 12) {
            mes = mes + " CCCD phải có từ 9 đến 12 chữ số";
            txt_CCCD.requestFocus();
        }

        // Kiểm tra số điện thoại
        String sdt = txt_SDT.getText().trim();
        if (sdt.isEmpty()) {
            mes = mes + " Số điện thoại";
            txt_SDT.requestFocus();
        } else if (sdt.length() < 10 || sdt.length() > 12) {
            mes = mes + " Số điện thoại phải có từ 10 đến 12 chữ số";
            txt_SDT.requestFocus();
        } else if (!sdt.startsWith("0")) {
            mes = mes + " Số điện thoại phải bắt đầu bằng 0";
            txt_SDT.requestFocus();
        }

        if (mes.trim().isEmpty()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Không được để trống" + mes, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public void loadTBL() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mã độc giả");
            model.addColumn("Tên độc giả");
            model.addColumn("Ngày sinh");
            model.addColumn("Địa Chỉ");
            model.addColumn("CMND");
            model.addColumn("SDT");

            SimpleDateFormat fmDate = new SimpleDateFormat("dd-MM-yyyy");

            List<DocGia> dg = DocGiaBUS.loadTableData();
            for (DocGia docGia : dg) {
                int ma = docGia.getMa_doc_gia();
                String ten = docGia.getTen_doc_gia();
                String ngaysinhfm = fmDate.format(docGia.getNgay_sinh());
                String diachi = docGia.getDia_chi();
                String cmnd = docGia.getCmnd();
                String sdt = docGia.getSdt();

                model.addRow(new Object[]{ma, ten, ngaysinhfm, diachi, cmnd, sdt});
            }
            jTB_docGia.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi xử lý dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void loadTBL_Search(String keyword) {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mã độc giả");
            model.addColumn("Tên độc giả");
            model.addColumn("Ngày sinh");
            model.addColumn("Địa Chỉ");
            model.addColumn("CMND");
            model.addColumn("SDT");

            SimpleDateFormat fmDate = new SimpleDateFormat("dd-MM-yyyy");

            List<DocGia> dg = DocGiaBUS.loadTableDataSearch(keyword);
            for (DocGia docGia : dg) {
                int ma = docGia.getMa_doc_gia();
                String ten = docGia.getTen_doc_gia();
                String ngaysinhfm = fmDate.format(docGia.getNgay_sinh());
                String diachi = docGia.getDia_chi();
                String cmnd = docGia.getCmnd();
                String sdt = docGia.getSdt();
                model.addRow(new Object[]{ma, ten, ngaysinhfm, diachi, cmnd, sdt});
            }
            jTB_docGia.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi xử lý dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_maDG = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_ngaySinh = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        txt_CCCD = new javax.swing.JTextField();
        txt_timkiem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTB_docGia = new javax.swing.JTable();
        txt_diaChi = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_tenDG = new javax.swing.JTextField();
        btn_sua = new javax.swing.JButton();
        btn_inExcel = new javax.swing.JButton();
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
        setTitle("Quản lý độc giả");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 242, 201));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_maDG.setEditable(false);
        txt_maDG.setEnabled(false);
        txt_maDG.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_maDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 292, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(248, 155, 40));
        jLabel9.setText("Ngày sinh: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 26));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(248, 155, 40));
        jLabel6.setText("Mã độc giả:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 90, -1));

        txt_ngaySinh.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txt_ngaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ngaySinhActionPerformed(evt);
            }
        });
        jPanel1.add(txt_ngaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 292, -1));

        btn_them.setBackground(new java.awt.Color(255, 255, 255));
        btn_them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_them.setForeground(new java.awt.Color(248, 155, 40));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/plus.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        btn_them.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_them.setMargin(new java.awt.Insets(1, 10, 1, 10));
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        jPanel1.add(btn_them, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        btn_xoa.setBackground(new java.awt.Color(255, 255, 255));
        btn_xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(248, 155, 40));
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/delete.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        btn_xoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_xoa.setMargin(new java.awt.Insets(1, 10, 1, 10));
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 152, -1, -1));

        txt_CCCD.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_CCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 60, 310, -1));

        txt_timkiem.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_timkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 217, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(248, 155, 40));
        jLabel3.setText("Số điện thoại:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 110, -1));

        txt_SDT.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_SDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 100, 310, -1));

        jTB_docGia.setForeground(new java.awt.Color(248, 155, 40));
        jTB_docGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã độc giả", "Tên độc giả", "Ngày sinh", "Địa chỉ", "CCCD", "Số điện thoại", "Chức vụ"
            }
        ));
        jTB_docGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTB_docGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_docGiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTB_docGia);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 223, 816, 330));

        txt_diaChi.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_diaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 20, 310, -1));

        btn_timkiem.setBackground(new java.awt.Color(255, 255, 255));
        btn_timkiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_timkiem.setForeground(new java.awt.Color(248, 155, 40));
        btn_timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/search.png"))); // NOI18N
        btn_timkiem.setText("Tìm Kiếm");
        btn_timkiem.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        btn_timkiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_timkiem.setMargin(new java.awt.Insets(1, 10, 1, 10));
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });
        jPanel1.add(btn_timkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 155, 40));
        jLabel1.setText("Tên độc giả: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(248, 155, 40));
        jLabel2.setText("Địa chỉ: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 70, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(248, 155, 40));
        jLabel4.setText("CCCD:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 50, -1));

        txt_tenDG.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txt_tenDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenDGActionPerformed(evt);
            }
        });
        jPanel1.add(txt_tenDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 292, -1));

        btn_sua.setBackground(new java.awt.Color(255, 255, 255));
        btn_sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(248, 155, 40));
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/edit.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        btn_sua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sua.setMargin(new java.awt.Insets(1, 10, 1, 10));
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        btn_inExcel.setBackground(new java.awt.Color(255, 255, 255));
        btn_inExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_inExcel.setForeground(new java.awt.Color(248, 155, 40));
        btn_inExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/paper.png"))); // NOI18N
        btn_inExcel.setText("In");
        btn_inExcel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        btn_inExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_inExcel.setMargin(new java.awt.Insets(1, 10, 1, 10));
        btn_inExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inExcelActionPerformed(evt);
            }
        });
        jPanel1.add(btn_inExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 152, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, -1));

        jMenuBar_sach.setBackground(new java.awt.Color(255, 242, 201));
        jMenuBar_sach.setForeground(new java.awt.Color(248, 155, 40));
        jMenuBar_sach.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        menu_qlDocGia.setForeground(new java.awt.Color(248, 155, 40));
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

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        try {
            if (valueDate()) {
                DocGia dg = new DocGia(
                        txt_tenDG.getText(),
                        new java.sql.Date(fmDate.parse(txt_ngaySinh.getText()).getTime()),
                        txt_diaChi.getText(),
                        txt_CCCD.getText(),
                        txt_SDT.getText()
                );

                DocGiaBUS.themDG(dg);
                JOptionPane.showMessageDialog(null, "Thêm độc giả thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                load();
                clearForm();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        try {
            if (DocGiaDAL.checkEmpty(txt_maDG.getText())) {
                int maDG = Integer.parseInt(txt_maDG.getText());
                DocGiaBUS.xoaDG(maDG);

                JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                load();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại! Độc giả đang tồn tại phiếu mượn sách.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Mã không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xóa thất bại! Vui lòng kiểm tra mã.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void jTB_docGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_docGiaMouseClicked
        int curent = jTB_docGia.getSelectedRow();
        txt_maDG.setText(String.valueOf(jTB_docGia.getValueAt(curent, 0)));
        txt_tenDG.setText(String.valueOf(jTB_docGia.getValueAt(curent, 1)));
        txt_ngaySinh.setText(String.valueOf(jTB_docGia.getValueAt(curent, 2)));
        txt_diaChi.setText(String.valueOf(jTB_docGia.getValueAt(curent, 3)));
        txt_CCCD.setText(String.valueOf(jTB_docGia.getValueAt(curent, 4)));
        txt_SDT.setText(String.valueOf(jTB_docGia.getValueAt(curent, 5)));
    }//GEN-LAST:event_jTB_docGiaMouseClicked

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        String search = txt_timkiem.getText();
        if (search.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa có dữ liệu tìm kiếm đầu vào", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            loadTBL_Search(search);
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void txt_tenDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenDGActionPerformed

    }//GEN-LAST:event_txt_tenDGActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        try {
            if (valueDate()) {
                DocGia dg = new DocGia(
                        Integer.parseInt(txt_maDG.getText()),
                        txt_tenDG.getText(),
                        new java.sql.Date(fmDate.parse(txt_ngaySinh.getText()).getTime()),
                        txt_diaChi.getText(),
                        txt_CCCD.getText(),
                        txt_SDT.getText()
                );
                DocGiaBUS.capNhatDG(dg);

                // Thông báo cập nhật thành công
                JOptionPane.showMessageDialog(null, "Cập nhật độc giả thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                load();
                clearForm();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cập nhật độc giả thất bại! Vui lòng kiểm tra dữ liệu đầu vào.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void txt_ngaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ngaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ngaySinhActionPerformed

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

    private void menu_qlTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_qlTheLoaiMouseClicked
        fTheLoai theLoaiFrame = new fTheLoai();
        theLoaiFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        theLoaiFrame.setLocationRelativeTo(null);
        theLoaiFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_qlTheLoaiMouseClicked

    private void btn_inExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inExcelActionPerformed
        try {

            List<DocGia> lDG = DocGiaDAL.loadTableData();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            XSSFWorkbook wordkbook = new XSSFWorkbook();
            XSSFSheet sheet = wordkbook.createSheet("danhsach");
            XSSFRow row = null;
            Cell cell = null;

            // Dòng tiêu đề
            row = sheet.createRow(2);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Danh sách độc giả");

            // Dòng tiêu đề các cột
            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã độc giả");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Tên độc giả");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Ngày sinh");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Địa chỉ");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Số CCCD");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Số điện thoại");

            // Điền dữ liệu vào các hàng
            for (int i = 0; i < lDG.size(); i++) {
                DocGia dg = lDG.get(i);
                row = sheet.createRow(4 + i);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(dg.getMa_doc_gia());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(dg.getTen_doc_gia());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(dateFormat.format(dg.getNgay_sinh()));

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(dg.getDia_chi());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(dg.getCmnd());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(dg.getSdt());

            }
            // Sử dụng JFileChooser để chọn vị trí lưu file
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn vị trí lưu file");
            fileChooser.setSelectedFile(new File("danhsach.xlsx")); // Đặt tên file mặc định

            int userSelection = fileChooser.showSaveDialog(this); // Hiển thị hộp thoại lưu file

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();

                // Ghi dữ liệu vào file
                try (FileOutputStream fis = new FileOutputStream(fileToSave)) {
                    wordkbook.write(fis);
                    fis.close();
                    JOptionPane.showMessageDialog(this, "In ra file Excel thành công tại: " + fileToSave.getAbsolutePath());
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "File không thể mở hoặc ghi.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lỗi khi ghi file.");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi mở file");
        }
    }//GEN-LAST:event_btn_inExcelActionPerformed

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
                fDocGia docGiaFrame = new fDocGia();
                docGiaFrame.setDefaultCloseOperation(fSach.EXIT_ON_CLOSE);
                docGiaFrame.setLocationRelativeTo(null);
                docGiaFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_inExcel;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar_sach;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTB_docGia;
    private javax.swing.JMenu menu_Sach;
    private javax.swing.JMenu menu_dxuat;
    private javax.swing.JMenu menu_muonTra;
    private javax.swing.JMenu menu_qlDocGia;
    private javax.swing.JMenu menu_qlTacGia;
    private javax.swing.JMenu menu_qlTheLoai;
    private javax.swing.JMenu menu_thongKe;
    private javax.swing.JMenu menu_thuThu;
    private javax.swing.JTextField txt_CCCD;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_diaChi;
    private javax.swing.JTextField txt_maDG;
    private javax.swing.JTextField txt_ngaySinh;
    private javax.swing.JTextField txt_tenDG;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
