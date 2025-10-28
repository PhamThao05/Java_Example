package GUI;

import BUS.LichSuBUS;
import DTO.ThuThu;
import DAL.ThuThuDAL;
import javax.swing.JOptionPane;

public class fDangNhap extends javax.swing.JFrame {

    private String maThuThu;

    public fDangNhap() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_tendnhap = new javax.swing.JTextField();
        btn_dnhap = new javax.swing.JButton();
        cb_showPass = new javax.swing.JCheckBox();
        txt_mkhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setBackground(new java.awt.Color(51, 255, 255));
        setFocusTraversalPolicyProvider(true);
        setMinimumSize(new java.awt.Dimension(687, 434));
        setPreferredSize(new java.awt.Dimension(400, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 242, 201));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 55)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 155, 40));
        jLabel1.setText("Đăng nhập");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 360, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/profile.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/lock.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));

        txt_tendnhap.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jPanel1.add(txt_tendnhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 340, -1));

        btn_dnhap.setBackground(new java.awt.Color(255, 255, 255));
        btn_dnhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_dnhap.setForeground(new java.awt.Color(248, 155, 40));
        btn_dnhap.setText("Đăng nhập");
        btn_dnhap.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK),
            javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20)
        )
    );
    btn_dnhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btn_dnhap.setMargin(new java.awt.Insets(10, 20, 10, 20));
    btn_dnhap.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btn_dnhapMouseClicked(evt);
        }
    });
    btn_dnhap.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_dnhapActionPerformed(evt);
        }
    });
    jPanel1.add(btn_dnhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, -1));

    cb_showPass.setForeground(new java.awt.Color(248, 155, 40));
    cb_showPass.setText("Hiện mật khẩu");
    cb_showPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    cb_showPass.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cb_showPassActionPerformed(evt);
        }
    });
    jPanel1.add(cb_showPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, -1, -1));

    txt_mkhau.setMargin(new java.awt.Insets(5, 10, 5, 10));
    jPanel1.add(txt_mkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 340, -1));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 460));

    getAccessibleContext().setAccessibleDescription("");

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_showPassActionPerformed
        if (cb_showPass.isSelected()) {
            txt_mkhau.setEchoChar((char) 0);
        } else {
            txt_mkhau.setEchoChar('*');
        }
    }//GEN-LAST:event_cb_showPassActionPerformed

    private void btn_dnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dnhapActionPerformed
// Lấy giá trị từ các trường nhập liệu
         String email = txt_tendnhap.getText().trim();
    String password = new String(txt_mkhau.getPassword()).trim();

    ThuThu.CTThuThu thuThu = ThuThuDAL.kiemTraDangNhap(email, password);

    if (thuThu != null) {
        maThuThu = String.valueOf(thuThu.getMa_thu_thu()); // Lưu lại mã người dùng

        JOptionPane.showMessageDialog(this, "Đăng nhập thành công. Xin chào " + thuThu.getTen_thu_thu());

        LichSuBUS.ghiLichSu(maThuThu, "Đăng nhập", "Thủ thư đăng nhập vào hệ thống");

        this.dispose(); // Đóng màn hình đăng nhập

        String role = thuThu.getPhanQuyen().toUpperCase(); // Giả sử tên thuộc tính là 'role'
        if (role.equals("ADMIN")) {
            new fQuanLyAdmin().setVisible(true); // Mở giao diện dành cho admin
        } else if (role.equals("THU_THU")) {
            new fMuonTra().setVisible(true); // Giao diện thường
        } else {
            JOptionPane.showMessageDialog(null, "Không xác định được vai trò người dùng!");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Email hoặc mật khẩu không đúng!");
    }
    }//GEN-LAST:event_btn_dnhapActionPerformed

    private void btn_dnhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dnhapMouseClicked

    }//GEN-LAST:event_btn_dnhapMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fDangNhap dNhapFrame = new fDangNhap();
                dNhapFrame.setDefaultCloseOperation(fDangNhap.EXIT_ON_CLOSE);
                dNhapFrame.setLocationRelativeTo(null);
                dNhapFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dnhap;
    private javax.swing.JCheckBox cb_showPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_mkhau;
    private javax.swing.JTextField txt_tendnhap;
    // End of variables declaration//GEN-END:variables

}
