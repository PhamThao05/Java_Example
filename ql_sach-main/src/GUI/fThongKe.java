package GUI;

import BUS.ThongKeBUS;
import DAL.ThongKeDAL;
import DTO.ThongKe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.Year;

public class fThongKe extends javax.swing.JFrame {

    public fThongKe() {
        initComponents();
        load();
        hienThiBieuDo();
    }

    public void load() {
        try {
            DefaultTableModel md = new DefaultTableModel();
            md.addColumn("Tên sách");
            md.addColumn("Tên độc giả");
            md.addColumn("Tên thủ thư");
            md.addColumn("Ngày mượn");
            md.addColumn("Ngày hẹn trả");
            md.addColumn("Số lượng tổng");
            md.addColumn("Đã cho mượn");
            md.addColumn("Đã trả");
            md.addColumn("Còn lại");
            md.addColumn("Tình trạng");
            md.addColumn("Tiền phạt");

            List<ThongKe> lst_tk = ThongKeBUS.loadTK();

            for (ThongKe tk : lst_tk) {
                String ten_S = tk.getTen_S();
                String ten_DG = tk.getTen_DG();
                String ten_TT = tk.getTen_TT();
                Date ngay_muon = tk.getNgay_muon();
                Date ngay_hen_tra = tk.getNgay_hen_tra();
                int sl_tong = tk.getSl_tong();
                int sl_dachomuon = tk.getSl_dachomuon();
                int sl_datra = tk.getSl_datra();
                int sl_con = tk.getSl_con();
                String tinh_trang = tk.getTinh_trang();
                double tien_phat = tk.getTien_phat();

                md.addRow(new Object[]{ten_S, ten_DG, ten_TT, ngay_muon, ngay_hen_tra, sl_tong, sl_dachomuon, sl_datra, sl_con, tinh_trang, tien_phat});
            }

            jTbl_ThongKe.setModel(md);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi xử lý dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbl_ThongKe = new javax.swing.JTable();
        btn_inExcel = new javax.swing.JButton();
        chartPanel = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
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
        setTitle("Thống kê");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 242, 203));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 155, 40));
        jLabel1.setText("Thống Kê");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 6, 186, -1));

        jTbl_ThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTbl_ThongKe);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 60, 1228, 213));

        btn_inExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_inExcel.setForeground(new java.awt.Color(248, 155, 40));
        btn_inExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/paper.png"))); // NOI18N
        btn_inExcel.setText("In báo cáo");
        btn_inExcel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        btn_inExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inExcelActionPerformed(evt);
            }
        });
        jPanel1.add(btn_inExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        chartPanel.setPreferredSize(new java.awt.Dimension(900, 400));

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1220, Short.MAX_VALUE)
        );
        chartPanelLayout.setVerticalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        jPanel1.add(chartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 1220, 420));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(248, 155, 40));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Sắp xếp theo ---", "2023", "2024", "2025", " " }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 200, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 153, 0));
        jButton1.setText("thống kê theo từng năm ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 240, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 740));

        jMenuBar_sach.setBackground(new java.awt.Color(255, 242, 203));

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

        menu_thongKe.setForeground(new java.awt.Color(248, 155, 40));
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

    private void btn_inExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inExcelActionPerformed
        try {
            List<ThongKe> lThongKe = ThongKeDAL.loadTK();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
            
            XSSFWorkbook wordkbook = new XSSFWorkbook();
            XSSFSheet sheet = wordkbook.createSheet("baocaothongke");
            XSSFRow row = null;
            Cell cell = null;

            // Dòng tiêu đề
            row = sheet.createRow(2);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Báo cáo thống kê");

            // Dòng tiêu đề các cột
            row = sheet.createRow(3);
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Tên sách");
            
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Tên độc giả");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Tên thủ thư");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Ngày mượn");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Ngày hẹn trả");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Tổng");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Đã cho mượn");

            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Đã trả");

            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("Còn lại");

            cell = row.createCell(10, CellType.STRING);
            cell.setCellValue("Tình trạng");

            cell = row.createCell(11, CellType.STRING);
            cell.setCellValue("Tiền phạt");

            // Điền dữ liệu vào các hàng
            for (int i = 0; i < lThongKe.size(); i++) {
                ThongKe thongke = lThongKe.get(i);
                row = sheet.createRow(4 + i);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(thongke.getTen_S());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(thongke.getTen_DG());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(thongke.getTen_TT());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(dateFormat.format(thongke.getNgay_muon()));

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(dateFormat.format(thongke.getNgay_hen_tra()));

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(thongke.getSl_tong());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(thongke.getSl_dachomuon());

                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(thongke.getSl_datra());

                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue(thongke.getSl_con());

                cell = row.createCell(10, CellType.STRING);
                cell.setCellValue(thongke.getTinh_trang());

                cell = row.createCell(11, CellType.STRING);
                cell.setCellValue(thongke.getTien_phat());
            }
            // Sử dụng JFileChooser để chọn vị trí lưu file
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn vị trí lưu file");
            fileChooser.setSelectedFile(new File("baocaothongke.xlsx")); // Đặt tên file mặc định

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new ThongKeNamFrame().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

public void hienThiBieuDo() {
    try {
        Map<Month, Integer> thongKeThang = new TreeMap<>();

        // Khởi tạo trước 12 tháng của năm 2023 với giá trị 0
        for (int i = 1; i <= 12; i++) {
            thongKeThang.put(new Month(i, 2023), 0);
        }

        // Duyệt danh sách thống kê
        for (ThongKe tk : ThongKeBUS.loadTK()) {
            Date ngayMuon = tk.getNgay_muon();
            if (ngayMuon == null) continue;

            Calendar cal = Calendar.getInstance();
            cal.setTime(ngayMuon);

            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1; // Calendar.MONTH bắt đầu từ 0

            if (year == 2023) {
                Month thang = new Month(month, 2023);
                int soLuong = thongKeThang.get(thang); // đã có giá trị 0 ban đầu
                thongKeThang.put(thang, soLuong + tk.getSl_dachomuon());
            }
        }

        // In ra kiểm tra dữ liệu thống kê
        for (Map.Entry<Month, Integer> entry : thongKeThang.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Tạo chuỗi thời gian cho biểu đồ
        TimeSeries series = new TimeSeries("Số lượng sách cho mượn");
        for (Map.Entry<Month, Integer> entry : thongKeThang.entrySet()) {
            series.addOrUpdate(entry.getKey(), entry.getValue());
        }

        // Tạo dataset và biểu đồ
        TimeSeriesCollection dataset = new TimeSeriesCollection(series);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Thống kê số lượng sách cho mượn năm 2023",
                "Tháng",
                "Số lượng",
                dataset,
                false,
                false,
                false
        );

        // Cài đặt màu nền và hiển thị trong chartPanel
        chart.setBackgroundPaint(Color.WHITE);

        chartPanel.removeAll();
        chartPanel.setLayout(new BorderLayout());
        chartPanel.add(new ChartPanel(chart), BorderLayout.CENTER);
        chartPanel.validate();

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fThongKe thongKeFrame = new fThongKe();
                thongKeFrame.setDefaultCloseOperation(fThongKe.EXIT_ON_CLOSE);
                thongKeFrame.setLocationRelativeTo(null);
                thongKeFrame.setVisible(true);

            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_inExcel;
    private javax.swing.JPanel chartPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar_sach;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbl_ThongKe;
    private javax.swing.JMenu menu_Sach;
    private javax.swing.JMenu menu_dxuat;
    private javax.swing.JMenu menu_muonTra;
    private javax.swing.JMenu menu_qlDocGia;
    private javax.swing.JMenu menu_qlTacGia;
    private javax.swing.JMenu menu_qlTheLoai;
    private javax.swing.JMenu menu_thongKe;
    private javax.swing.JMenu menu_thuThu;
    // End of variables declaration//GEN-END:variables
}
