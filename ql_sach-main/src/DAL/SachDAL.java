package DAL;

import static DAL.ConnectToSQLServer.getConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;
import DTO.Sach;

public class SachDAL {

    public static List<String> load_cbb_TacGiaData() {
        List<String> tacGiaList = new ArrayList<>();
        String sqlQuery = "SELECT ten_tac_gia FROM TAC_GIA";
        try (Connection conn = ConnectToSQLServer.getConnection(); PreparedStatement ps = conn.prepareStatement(sqlQuery); ResultSet res = ps.executeQuery()) {

            while (res.next()) {
                tacGiaList.add(res.getString("ten_tac_gia"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu từ bảng Tác Giả: " + e.getMessage(), "Lỗi SQL", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return tacGiaList;
    }

    public static List<String> load_cbb_TheLoaiData() {
        List<String> theLoaiList = new ArrayList<>();
        String sqlQuery = "SELECT ten_the_loai FROM THE_LOAI";
        try (Connection conn = ConnectToSQLServer.getConnection(); PreparedStatement ps = conn.prepareStatement(sqlQuery); ResultSet res = ps.executeQuery()) {

            while (res.next()) {
                theLoaiList.add(res.getString("ten_the_loai"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu từ bảng Thể Loại: " + e.getMessage(), "Lỗi SQL", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return theLoaiList;
    }

    public static List<Sach> loadTableData() {
        List<Sach> lst_tbl = new ArrayList<>();
        String sqlQuery = "SELECT * FROM SACH";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Sach sach = new Sach();
                sach.setMa_sach(res.getInt("ma_sach"));
                sach.setTen_sach(res.getString("ten_sach"));
                sach.setNgon_ngu_sach(res.getString("ngon_ngu"));
                sach.setGia_tri(res.getFloat("gia_tri"));
                sach.setSo_luong(res.getInt("so_luong"));
                sach.setTacgia(res.getInt("ma_tac_gia"));
                sach.setThe_loai(res.getInt("ma_the_loai"));
                sach.setNha_xuat_ban(res.getString("nxb"));
                sach.setNam_xuat_ban(res.getDate("nam_xuat_ban"));
                lst_tbl.add(sach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_tbl;
    }

    public static List<Sach> loadTableDataSearch(String keyword) {
        List<Sach> lst_tbl = new ArrayList<>();

        String sqlQuery = "SELECT *\n"
                + "FROM SACH\n"
                + "WHERE CAST(ma_sach AS NVARCHAR) LIKE ?\n"
                + "  OR ten_sach LIKE ?\n"
                + "   OR ngon_ngu LIKE ?\n"
                + "   OR CAST(gia_tri AS NVARCHAR) LIKE ?\n"
                + "   OR CAST(so_luong AS NVARCHAR) LIKE ?\n"
                + "   OR CAST(ma_tac_gia AS NVARCHAR) LIKE ?\n"
                + "   OR CAST(ma_the_loai AS NVARCHAR) LIKE ?\n"
                + "   OR nxb LIKE ?\n"
                + "   OR CAST(nam_xuat_ban AS NVARCHAR) LIKE ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            for (int i = 1; i <= 9; i++) {
                ps.setString(i, "%" + keyword + "%");
            }
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Sach sach = new Sach();
                sach.setMa_sach(res.getInt("ma_sach"));
                sach.setTen_sach(res.getString("ten_sach"));
                sach.setNgon_ngu_sach(res.getString("ngon_ngu"));
                sach.setGia_tri(res.getFloat("gia_tri"));
                sach.setSo_luong(res.getInt("so_luong"));
                sach.setTacgia(res.getInt("ma_tac_gia"));
                sach.setThe_loai(res.getInt("ma_the_loai"));
                sach.setNha_xuat_ban(res.getString("nxb"));
                sach.setNam_xuat_ban(res.getDate("nam_xuat_ban"));
                lst_tbl.add(sach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_tbl;
    }

    public static void themSach(Sach sach) {
        String sqlQuery = "INSERT INTO SACH (ten_sach, ngon_ngu, gia_tri, so_luong, ma_tac_gia, ma_the_loai, nxb, nam_xuat_ban) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            // Thiết lập các tham số từ đối tượng `Sach`
            ps.setString(1, sach.getTen_sach());
            ps.setString(2, sach.getNgon_ngu_sach());
            ps.setFloat(3, sach.getGia_tri());
            ps.setInt(4, sach.getSo_luong());
            ps.setInt(5, sach.getTacgia());
            ps.setInt(6, sach.getThe_loai());
            ps.setString(7, sach.getNha_xuat_ban());
            ps.setDate(8, java.sql.Date.valueOf(sach.getNam_xuat_ban().toString())); // chuyển `Date` sang `java.sql.Date`

            // Thực thi truy vấn
            ps.executeUpdate();
            System.out.println("Thêm sách thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void capNhatSach(Sach sach) {
        String sqlQuery = "UPDATE SACH SET ten_sach = ?, ngon_ngu = ?, gia_tri = ?, so_luong = ?, ma_tac_gia = ?, ma_the_loai = ?, nxb = ?, nam_xuat_ban = ? WHERE ma_sach = ?";

        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            // Thiết lập các tham số từ đối tượng `Sach`
            ps.setString(1, sach.getTen_sach());
            ps.setString(2, sach.getNgon_ngu_sach());
            ps.setFloat(3, sach.getGia_tri());
            ps.setInt(4, sach.getSo_luong());
            ps.setInt(5, sach.getTacgia());
            ps.setInt(6, sach.getThe_loai());
            ps.setString(7, sach.getNha_xuat_ban());
            ps.setDate(8, java.sql.Date.valueOf(sach.getNam_xuat_ban().toString())); // chuyển `Date` sang `java.sql.Date`
            ps.setInt(9, sach.getMa_sach()); // ma_sach là điều kiện cập nhật

            // Thực thi truy vấn
            ps.executeUpdate();
            System.out.println("Cập nhật sách thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xoaSach(int maSach) {
        String sqlQuery = "DELETE FROM SACH WHERE ma_sach = ?";

        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, maSach); // Thiết lập tham số là mã sách muốn xóa

            // Thực thi câu lệnh xóa
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Xóa sách thành công!");
            } else {
                System.out.println("Không tìm thấy sách với mã: " + maSach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getTacGiaById(int id) {
        String sqlQuery = "SELECT ten_tac_gia FROM TAC_GIA WHERE ma_tac_gia = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                return res.getString("ten_tac_gia");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getTheLoaiById(int id) {
        String sqlQuery = "SELECT ten_the_loai FROM THE_LOAI WHERE ma_the_loai = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                return res.getString("ten_the_loai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public static boolean checkEmpty(String id) {
        String sqlQuery = "SELECT COUNT(*) AS dem FROM CHI_TIET_PHIEU_MUON WHERE ma_sach = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            // Kiểm tra kết quả truy vấn
            if (rs.next()) {
                int dem = rs.getInt("dem");
                if (dem > 0) {
                    System.err.println("sách còn tồn tại " + dem + " chi tiết phiếu mượn");
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
   
}
