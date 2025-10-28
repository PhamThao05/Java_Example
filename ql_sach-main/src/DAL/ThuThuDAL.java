package DAL;

import DTO.LichSu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import DTO.ThuThu;

public class ThuThuDAL {

    public static List<ThuThu.CTThuThu> LoadTBDATA() {
        String sqlQuery = "SELECT * FROM THU_THU";
        List<ThuThu.CTThuThu> lst_tbl = new ArrayList<>();
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                ThuThu.CTThuThu tt = new ThuThu.CTThuThu();
                tt.setMa_thu_thu(res.getInt("ma_thu_thu"));
                tt.setTen_thu_thu(res.getString("ten_thu_thu"));
                tt.setCmnd(res.getString("cmnd"));
                tt.setSdt(res.getString("sdt"));
                tt.setEmail(res.getString("email"));
                tt.setPassword(res.getString("password"));

                lst_tbl.add(tt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst_tbl;
    }

    public static List<ThuThu.CTThuThu> LoadtTbDATA_Search(String keyword) {
        String sqlQuery = "SELECT *\n"
                + "FROM THU_THU\n"
                + "WHERE ten_thu_thu LIKE ? \n"
                + "   OR cmnd LIKE ? \n"
                + "   OR sdt LIKE ? \n"
                + "   OR email LIKE ? \n"
                + "   OR password LIKE ?";
        List<ThuThu.CTThuThu> lst_tbl = new ArrayList<>();
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            String searchPattern = "%" + keyword + "%";
            for (int i = 1; i <= 5; i++) {
                ps.setString(i, searchPattern);
            }

            ResultSet res = ps.executeQuery();

            while (res.next()) {
                ThuThu.CTThuThu tt = new ThuThu.CTThuThu();
                tt.setMa_thu_thu(res.getInt("ma_thu_thu"));
                tt.setTen_thu_thu(res.getString("ten_thu_thu"));
                tt.setCmnd(res.getString("cmnd"));
                tt.setSdt(res.getString("sdt"));
                tt.setEmail(res.getString("email"));
                tt.setPassword(res.getString("password"));

                lst_tbl.add(tt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_tbl;
    }

    public static void them(ThuThu tt) {
        String sqlQuery = "INSERT INTO THU_THU (ten_thu_thu, cmnd, sdt, email, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareCall(sqlQuery);
            ps.setString(1, tt.getTen_thu_thu());
            ps.setString(2, tt.getCmnd());
            ps.setString(3, tt.getSdt());
            ps.setString(4, tt.getEmail());
            ps.setString(5, tt.getPassword());

            ps.executeUpdate();
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sua(ThuThu.CTThuThu cttt) {
        String sqlQuery = "UPDATE THU_THU\n"
                + "SET ten_thu_thu = ?,\n"
                + "    cmnd = ?,\n"
                + "    sdt = ?,\n"
                + "    email = ?,\n"
                + "    password = ?\n"
                + "WHERE ma_thu_thu = ?;";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareCall(sqlQuery);
            ps.setString(1, cttt.getTen_thu_thu());
            ps.setString(2, cttt.getCmnd());
            ps.setString(3, cttt.getSdt());
            ps.setString(4, cttt.getEmail());
            ps.setString(5, cttt.getPassword());
            ps.setInt(6, cttt.getMa_thu_thu());

            ps.executeUpdate();
            System.out.println("Sửa thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xoa(int ma) {
        String sqlQuery = "DELETE FROM THU_THU WHERE ma_thu_thu = ?";
        
        try (Connection conn = ConnectToSQLServer.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, ma);
            ps.executeUpdate();
            
            System.out.println("Xóa thành công");
        } catch (Exception e) {
        }
    }
    
    public static boolean checkEmpty(String id) {
        String sqlQuery = "SELECT COUNT(*) AS dem FROM PHIEU_MUON WHERE ma_thu_thu = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            // Kiểm tra kết quả truy vấn
            if (rs.next()) {
                int dem = rs.getInt("dem");
                if (dem > 0) {
                    System.err.println("Thủ thư còn tồn tại " + dem + " Phiếu mượn");
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
public static ThuThu.CTThuThu kiemTraDangNhap(String email, String password) {
    String sql = "SELECT * FROM THU_THU WHERE email = ? AND password = ?";
    try (Connection conn = ConnectToSQLServer.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            ThuThu.CTThuThu tt = new ThuThu.CTThuThu();
            tt.setMa_thu_thu(rs.getInt("ma_thu_thu"));
            tt.setTen_thu_thu(rs.getString("ten_thu_thu"));
            tt.setCmnd(rs.getString("cmnd"));
            tt.setSdt(rs.getString("sdt"));
            tt.setEmail(rs.getString("email"));
            tt.setPassword(rs.getString("password"));
            tt.setPhanQuyen(rs.getString("phanquyen")); // ✅ THÊM DÒNG NÀY

            return tt;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
    public static void ghiLichSu(int maThuThu, String hanhDong, String ghiChu) {
    String sql = "INSERT INTO LICH_SU_TAI_KHOAN (ma_thu_thu, hanh_dong, ghi_chu) VALUES (?, ?, ?)";
    try (Connection conn = ConnectToSQLServer.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, maThuThu);
        ps.setString(2, hanhDong);
        ps.setString(3, ghiChu);
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static List<LichSu> layLichSu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
