package GUI;

import BUS.LichSuBUS;
import BUS.SachBUS;
import javax.swing.JOptionPane;
import DAL.SachDAL;
import java.text.SimpleDateFormat;
import java.util.List;
import DTO.Sach;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

import javax.swing.JFileChooser;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class fSach extends javax.swing.JFrame {

    private String maSach;
    private String maThuThu;

    public fSach() {
        initComponents();
        Load();
    }

    private void Load() {
        // load cbb tác giả
        cbb_tacGia.removeAllItems();
        try {
            List<String> tacGiaList = SachBUS.load_cbb_TacGiaData();
            for (String tenTacGia : tacGiaList) {
                cbb_tacGia.addItem(tenTacGia);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xử lý dữ liệu từ bảng Tác Giả: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        // load cbb thể loại
        cbb_theLoai.removeAllItems();
        try {
            List<String> theLoaiList = SachBUS.load_cbb_TheLoaiData();
            for (String tenTheLoai : theLoaiList) {
                cbb_theLoai.addItem(tenTheLoai);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xử lý dữ liệu từ bảng Thể Loại: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mã Sách");
            model.addColumn("Tên Sách");
            model.addColumn("Ngôn Ngữ");
            model.addColumn("Giá Trị");
            model.addColumn("Số Lượng");
            model.addColumn("Tác Giả");
            model.addColumn("Thể Loại");
            model.addColumn("Nhà XB");
            model.addColumn("Năm Sản Xuất");

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

            List<Sach> tacGiaList = SachBUS.loadTableData();

            for (Sach s : tacGiaList) {
                int maSach = s.getMa_sach();
                String ten_sach = s.getTen_sach();
                String ngon_ngu_sach = s.getNgon_ngu_sach();
                float gia_tri = s.getGia_tri();
                int so_luong = s.getSo_luong();
                String tacgia = SachDAL.getTacGiaById(s.getTacgia());
                String the_loai = SachDAL.getTheLoaiById(s.getThe_loai());
                String nha_xuat_ban = s.getNha_xuat_ban();
                Date namSX = s.getNam_xuat_ban();
                String namSXFormatted = dateFormatter.format(namSX);
                model.addRow(new Object[]{maSach, ten_sach, ngon_ngu_sach, gia_tri, so_luong, tacgia, the_loai, nha_xuat_ban, namSXFormatted});
            }

            jTB_sach.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xử lý dữ liệu : " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void loadTBL_SEARCH(String search) {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mã Sách");
            model.addColumn("Tên Sách");
            model.addColumn("Ngôn Ngữ");
            model.addColumn("Giá Trị");
            model.addColumn("Số Lượng");
            model.addColumn("Tác Giả");
            model.addColumn("Thể Loại");
            model.addColumn("Nhà XB");
            model.addColumn("Năm Sản Xuất");

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

            List<Sach> tacGiaList = SachBUS.loadTableDataSearch(search);
            for (Sach s : tacGiaList) {
                int maSach = s.getMa_sach();
                String ten_sach = s.getTen_sach();
                String ngon_ngu_sach = s.getNgon_ngu_sach();
                float gia_tri = s.getGia_tri();
                int so_luong = s.getSo_luong();
                String tacgia = SachDAL.getTacGiaById(s.getTacgia());
                String the_loai = SachDAL.getTheLoaiById(s.getThe_loai());
                String nha_xuat_ban = s.getNha_xuat_ban();
                Date namSX = s.getNam_xuat_ban();
                String namSXFormatted = dateFormatter.format(namSX);
                model.addRow(new Object[]{maSach, ten_sach, ngon_ngu_sach, gia_tri, so_luong, tacgia, the_loai, nha_xuat_ban, namSXFormatted});
            }

            jTB_sach.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xử lý dữ liệu : " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void clearForm() {
        txt_ngonNgu.setText("");
        txt_soLuong.setText("");
        txt_giaTri.setText("");
        txt_nhaXB.setText("");
        txt_tenSach.setText("");
        txt_maSach.setText("");
        txt_namXB.setText("");
        cbb_tacGia.setSelectedIndex(0);
        cbb_theLoai.setSelectedIndex(0);
    }

    public boolean valiDateForm() {
        String mes = "";

        // Kiểm tra tên sách
        if (txt_tenSach.getText().trim().isEmpty()) {
            mes += "Tên sách không được để trống.\n";
            txt_tenSach.requestFocus();
        }


        // Kiểm tra số lượng
        if (txt_soLuong.getText().trim().isEmpty()) {
            mes += "Số lượng không được để trống.\n";
            txt_soLuong.requestFocus();
        } else {
            try {
                Integer.parseInt(txt_soLuong.getText().trim());
                
            } catch (NumberFormatException e){
                mes += "Số lượng phải là số nguyên \n";
                txt_soLuong.requestFocus();
            }
        }

        // Kiểm tra giá trị
        if (txt_giaTri.getText().trim().isEmpty()) {
            mes += "Giá trị không được để trống.\n";
            txt_giaTri.requestFocus();
        } else {
            try {
                Double.parseDouble(txt_giaTri.getText().trim()); 
            } catch(NumberFormatException e) {
                mes += "Giá trị phải là số.\n";
                txt_giaTri.requestFocus();
            } 
        }

        // Kiểm tra năm xuất bản
        if (txt_namXB.getText().trim().isEmpty()) {
            mes += "Năm xuất bản không được để trống.\n";
            txt_namXB.requestFocus();
        } else if (!txt_namXB.getText().trim().matches("\\d{4}(-\\d{2}-\\d{2}?)")) { 
            mes += "Năm xuất bản phải đúng định dạng yyyy hoặc yyyy-MM-dd.\n";
            txt_namXB.requestFocus();
        }

        // Kiểm tra nhà xuất bản
        if (txt_nhaXB.getText().trim().isEmpty()) {
            mes += "Nhà xuất bản không được để trống.\n";
            txt_nhaXB.requestFocus();
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
        btn_them = new javax.swing.JButton();
        txt_nhaXB = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_timkiem = new javax.swing.JButton();
        txt_ngonNgu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_sua = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_maSach = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_xoa = new javax.swing.JButton();
        txt_timkiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTB_sach = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_tenSach = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_giaTri = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_soLuong = new javax.swing.JTextField();
        txt_namXB = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbb_theLoai = new javax.swing.JComboBox<>();
        cbb_tacGia = new javax.swing.JComboBox<>();
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
        setTitle("Quản lý sách");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 242, 203));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_them.setBackground(new java.awt.Color(255, 255, 255));
        btn_them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_them.setForeground(new java.awt.Color(248, 155, 40));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/plus.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.setMargin(new java.awt.Insets(5, 10, 5, 10));
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        jPanel1.add(btn_them, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        txt_nhaXB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_nhaXB.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_nhaXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 290, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(248, 155, 40));
        jLabel7.setText("Ngôn ngữ:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 90, -1));

        btn_timkiem.setBackground(new java.awt.Color(255, 255, 255));
        btn_timkiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_timkiem.setForeground(new java.awt.Color(248, 155, 40));
        btn_timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/search.png"))); // NOI18N
        btn_timkiem.setText("Tìm Kiếm");
        btn_timkiem.setMargin(new java.awt.Insets(5, 10, 5, 10));
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });
        jPanel1.add(btn_timkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, -1, -1));

        txt_ngonNgu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_ngonNgu.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_ngonNgu, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 90, 260, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(248, 155, 40));
        jLabel4.setText("Nhà xuất bản: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 110, -1));

        btn_sua.setBackground(new java.awt.Color(255, 255, 255));
        btn_sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(248, 155, 40));
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/edit.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.setMargin(new java.awt.Insets(5, 10, 5, 10));
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(248, 155, 40));
        jLabel5.setText("Năm xuất bản: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 110, -1));

        txt_maSach.setEditable(false);
        txt_maSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_maSach.setEnabled(false);
        txt_maSach.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_maSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 10, 260, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(248, 155, 40));
        jLabel6.setText("Mã sách:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 70, -1));

        btn_xoa.setBackground(new java.awt.Color(255, 255, 255));
        btn_xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(248, 155, 40));
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/delete.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.setMargin(new java.awt.Insets(5, 10, 5, 10));
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));

        txt_timkiem.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_timkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 217, -1));

        jTB_sach.setForeground(new java.awt.Color(248, 155, 40));
        jTB_sach.setModel(new javax.swing.table.DefaultTableModel(
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
        jTB_sach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_sachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTB_sach);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 816, 278));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 155, 40));
        jLabel1.setText("Tên Sách: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 70, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(248, 155, 40));
        jLabel2.setText("Tác Giả: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 80, -1));

        txt_tenSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_tenSach.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txt_tenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenSachActionPerformed(evt);
            }
        });
        jPanel1.add(txt_tenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 50, 260, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(248, 155, 40));
        jLabel8.setText("Giá trị:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 60, -1));

        txt_giaTri.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_giaTri.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_giaTri, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 130, 260, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(248, 155, 40));
        jLabel9.setText("Số lượng: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, -1));

        txt_soLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_soLuong.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_soLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 180, 260, -1));

        txt_namXB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_namXB.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_namXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 290, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(248, 155, 40));
        jLabel3.setText("Thể Loại:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 80, -1));

        cbb_theLoai.setBackground(new java.awt.Color(255, 255, 255));
        cbb_theLoai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbb_theLoai.setForeground(new java.awt.Color(248, 155, 40));
        cbb_theLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbb_theLoai.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        cbb_theLoai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(cbb_theLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 290, -1));

        cbb_tacGia.setBackground(new java.awt.Color(255, 255, 255));
        cbb_tacGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbb_tacGia.setForeground(new java.awt.Color(248, 155, 40));
        cbb_tacGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbb_tacGia.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        cbb_tacGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbb_tacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_tacGiaActionPerformed(evt);
            }
        });
        jPanel1.add(cbb_tacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 290, -1));

        btn_inExcel.setBackground(new java.awt.Color(255, 255, 255));
        btn_inExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_inExcel.setForeground(new java.awt.Color(248, 155, 40));
        btn_inExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/paper.png"))); // NOI18N
        btn_inExcel.setText("In");
        btn_inExcel.setMargin(new java.awt.Insets(5, 10, 5, 10));
        btn_inExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inExcelActionPerformed(evt);
            }
        });
        jPanel1.add(btn_inExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 610));

        jMenuBar_sach.setBackground(new java.awt.Color(255, 242, 203));
        jMenuBar_sach.setForeground(new java.awt.Color(0, 0, 0));

        menu_Sach.setForeground(new java.awt.Color(248, 155, 40));
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
            if (valiDateForm()) {
                Sach sach = new Sach(
                        txt_tenSach.getText(),
                        txt_ngonNgu.getText(),
                        Float.parseFloat(txt_giaTri.getText()),
                        Integer.parseInt(txt_soLuong.getText()),
                        cbb_tacGia.getSelectedIndex() + 1,
                        cbb_theLoai.getSelectedIndex() + 1,
                        txt_nhaXB.getText(),
                        java.sql.Date.valueOf(txt_namXB.getText())
                );
                SachBUS.themSach(sach);
                LichSuBUS.ghiLichSu(maThuThu, "Thêm sách", "Thêm sách có mã: " + maSach);
                JOptionPane.showMessageDialog(null, "Thêm sách thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                Load();
                clearForm();
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm sách thất bại! Vui lòng kiểm tra dữ liệu đầu vào.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        String search = txt_timkiem.getText().trim();
        if (search.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa có dữ liệu tìm kiếm đầu vào", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            Load();
        } else {
            loadTBL_SEARCH(search);
        }

        if (jTB_sach.getRowCount() == 0) { // Kiểm tra nếu bảng không có dữ liệu
            JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả nào phù hợp", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        try {
            if (valiDateForm()) {
                Sach sach = new Sach(
                        txt_tenSach.getText(),
                        txt_ngonNgu.getText(),
                        Float.parseFloat(txt_giaTri.getText()),
                        Integer.parseInt(txt_soLuong.getText()),
                        cbb_tacGia.getSelectedIndex() + 1, // Chỉnh lại chỉ số cho phù hợp với ID của tác giả
                        cbb_theLoai.getSelectedIndex() + 1, // Chỉnh lại chỉ số cho phù hợp với ID của thể loại
                        txt_nhaXB.getText(),
                        java.sql.Date.valueOf(txt_namXB.getText()) // Chuyển đổi sang kiểu Date
                );

                // Gọi phương thức để cập nhật sách vào cơ sở dữ liệu
                SachBUS.capNhatSach(sach);

                // Thông báo cập nhật thành công
                JOptionPane.showMessageDialog(null, "Cập nhật sách thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                Load();
                clearForm();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cập nhật sách thất bại! Vui lòng kiểm tra dữ liệu đầu vào.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        try {
            if (SachDAL.checkEmpty(txt_maSach.getText())) {
                int maSach = Integer.parseInt(txt_maSach.getText()); // Lấy mã sách từ giao diện người dùng

            // Gọi phương thức để xóa sách khỏi cơ sở dữ liệu
            SachBUS.xoaSach(maSach);

            // Thông báo xóa thành công
            JOptionPane.showMessageDialog(null, "Xóa sách thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load();
            clearForm();
            }else{
            JOptionPane.showMessageDialog(null, "Xóa thất bại! Sách đang tồn tại chi tiết phiếu mượn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Mã sách không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xóa sách thất bại! Vui lòng kiểm tra mã sách.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void jTB_sachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_sachMouseClicked
        int curent = jTB_sach.getSelectedRow();

        // Lấy hàng hiện tại
        //int curent = jTB_sach.getSelectedRow();
// Điền dữ liệu vào các JTextField
        txt_maSach.setText(String.valueOf(jTB_sach.getValueAt(curent, 0)));
        txt_tenSach.setText(String.valueOf(jTB_sach.getValueAt(curent, 1)));
        txt_ngonNgu.setText(String.valueOf(jTB_sach.getValueAt(curent, 2)));
        txt_giaTri.setText(String.valueOf(jTB_sach.getValueAt(curent, 3)));
        txt_soLuong.setText(String.valueOf(jTB_sach.getValueAt(curent, 4)));

// Lấy mã tác giả từ bảng (cột 5)
        String maTacGia = String.valueOf(jTB_sach.getValueAt(curent, 5));

// Duyệt qua các mục trong cbb_tacGia để tìm item khớp với mã tác giả
        for (int i = 0; i < cbb_tacGia.getItemCount(); i++) {
            if (cbb_tacGia.getItemAt(i).toString().equals(maTacGia)) {
                cbb_tacGia.setSelectedIndex(i);
                break;
            }
        }

// Điền dữ liệu vào các JTextField khác
        txt_nhaXB.setText(String.valueOf(jTB_sach.getValueAt(curent, 7)));

// Lấy mã thể loại từ bảng (cột 7)
        String maTheLoai = String.valueOf(jTB_sach.getValueAt(curent, 6));

// Duyệt qua các mục trong cbb_theLoai để tìm item khớp với mã thể loại
        for (int i = 0; i < cbb_theLoai.getItemCount(); i++) {
            if (cbb_theLoai.getItemAt(i).toString().equals(maTheLoai)) {
                cbb_theLoai.setSelectedIndex(i);
                break;
            }
        }

// Điền năm xuất bản
        txt_namXB.setText(String.valueOf(jTB_sach.getValueAt(curent, 8)));

    }//GEN-LAST:event_jTB_sachMouseClicked

    private void txt_tenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenSachActionPerformed

    private void cbb_tacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_tacGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_tacGiaActionPerformed

    private void btn_inExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inExcelActionPerformed
        try {

            List<Sach> lSach = SachDAL.loadTableData();

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
            cell.setCellValue("Mã sách");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Tên sách");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Ngôn ngữ");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Giá trị");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Số lượng");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Tên tác giả");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Tên thể loại");

            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Nhà xuất bản");

            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("Năm xuất bản");

            // Điền dữ liệu vào các hàng
            for (int i = 0; i < lSach.size(); i++) {
                Sach sach = lSach.get(i);
                row = sheet.createRow(4 + i);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(sach.getMa_sach());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(sach.getTen_sach());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(sach.getNgon_ngu_sach());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(sach.getGia_tri());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(sach.getSo_luong());

                String tenTG = SachDAL.getTacGiaById(sach.getTacgia());
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(tenTG);
                
                String tenTL = SachDAL.getTheLoaiById(sach.getThe_loai());
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(tenTL);
                
                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(sach.getNha_xuat_ban());
                
                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue(dateFormat.format(sach.getNam_xuat_ban()));

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
                fSach sachFrame = new fSach();
                sachFrame.setDefaultCloseOperation(fSach.EXIT_ON_CLOSE);
                sachFrame.setLocationRelativeTo(null);
                sachFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_inExcel;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbb_tacGia;
    private javax.swing.JComboBox<String> cbb_theLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar_sach;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTB_sach;
    private javax.swing.JMenu menu_Sach;
    private javax.swing.JMenu menu_dxuat;
    private javax.swing.JMenu menu_muonTra;
    private javax.swing.JMenu menu_qlDocGia;
    private javax.swing.JMenu menu_qlTacGia;
    private javax.swing.JMenu menu_qlTheLoai;
    private javax.swing.JMenu menu_thongKe;
    private javax.swing.JMenu menu_thuThu;
    private javax.swing.JTextField txt_giaTri;
    private javax.swing.JTextField txt_maSach;
    private javax.swing.JTextField txt_namXB;
    private javax.swing.JTextField txt_ngonNgu;
    private javax.swing.JTextField txt_nhaXB;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_tenSach;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
