package DAL;

import java.util.*;
import DTO.TheLoai;
import java.sql.*;

public class TheLoaiDAL {

    public static List<TheLoai> loadTableData() {
        List<TheLoai> lst_tbl = new ArrayList<>();

        String sqlQuery = "SELECT * FROM THE_LOAI";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TheLoai theloai = new TheLoai();
                theloai.setMa_the_loai(rs.getInt("ma_the_loai"));
                theloai.setTen_the_loai(rs.getString("ten_the_loai"));
                lst_tbl.add(theloai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_tbl;
    }

    public static void themTheLoai(TheLoai theloai) {
        String sqlQuery = "INSERT INTO THE_LOAI (ten_the_loai) VALUES (?)";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            //Thiết lập tham số
            ps.setString(1, theloai.getTen_the_loai());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void suaTheLoai(TheLoai theloai) {
        String sqlQuery = "UPDATE THE_LOAI set ten_the_loai = ? WHERE ma_the_loai = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            //Thiết lập tham số
            ps.setString(1, theloai.getTen_the_loai());
            ps.setInt(2, theloai.getMa_the_loai());

            ps.executeUpdate();
            System.out.println("Cập nhật thể loại thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xoaTheLoai(int maTheLoai) {
        String sqlQuery = "DELETE FROM THE_LOAI WHERE ma_the_loai = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            //Thiết lập tham số
            ps.setInt(1, maTheLoai);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Xóa thành công");
            } else {
                System.out.println("Không tìm thấy mã thể loại");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<TheLoai> loadTableDataSearch(String key) {
        List<TheLoai> lst_tbl = new ArrayList<>();
        String sqlQuery = "SELECT * FROM THE_LOAI "
                + "WHERE CAST(ma_the_loai AS NVARCHAR) LIKE ?\n"
                + " OR ten_the_loai LIKE ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            for (int i = 1; i <= 2; i++) {
                ps.setString(i, "%" + key + "%");
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TheLoai theloai = new TheLoai();
                theloai.setMa_the_loai(rs.getInt("ma_the_loai"));
                theloai.setTen_the_loai(rs.getString("ten_the_loai"));
                lst_tbl.add(theloai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_tbl;
    }
    
    public static boolean checkEmpty(String id) {
        String sqlQuery = "SELECT COUNT(*) AS dem FROM THE_LOAI WHERE ma_the_loai = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            // Kiểm tra kết quả truy vấn
            if (rs.next()) {
                int dem = rs.getInt("dem");
                if (dem > 0) {
                    System.err.println("Thể loại còn tồn tại " + dem + " sách");
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
