package DAL;

import DTO.PhieuMuon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.sql.Date;

public class PhieuMuonDAL {

    public static List<PhieuMuon> loadTableData() {
        List<PhieuMuon> lst_tbl = new ArrayList();
        String sqlQuery = "SELECT * FROM PHIEU_MUON";
        try (Connection conn = ConnectToSQLServer.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                PhieuMuon pm = new PhieuMuon();
                pm.setMa_phieu_muon(rs.getInt("ma_phieu_muon"));
                pm.setMa_thu_thu(rs.getInt("ma_thu_thu"));
                pm.setMa_doc_gia(rs.getInt("ma_doc_gia"));
                pm.setNgay_muon(rs.getDate("ngay_muon"));
                pm.setNgay_hen_tra(rs.getDate("ngay_hen_tra"));
                pm.setNgay_tra(rs.getDate("ngay_tra"));
                lst_tbl.add(pm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_tbl;
    }

    public static List<PhieuMuon> loadTableDataSearch(String key) {
        List<PhieuMuon> lst_tbl = new ArrayList<>();
        String sqlQuery = "SELECT *\n"
            + "FROM PHIEU_MUON\n"
            + "LEFT JOIN DOC_GIA ON PHIEU_MUON.ma_doc_gia = DOC_GIA.ma_doc_gia\n"
            + "LEFT JOIN THU_THU ON PHIEU_MUON.ma_thu_thu = THU_THU.ma_thu_thu\n"
            + "WHERE DOC_GIA.ten_doc_gia LIKE ?\n"   // Tìm kiếm theo tên độc giả
            + " OR CAST(PHIEU_MUON.ma_phieu_muon AS NVARCHAR) LIKE ?\n"
            + " OR CAST(PHIEU_MUON.ma_thu_thu AS NVARCHAR) LIKE ?\n"
            + " OR THU_THU.ten_thu_thu LIKE ?\n"    // Tìm kiếm theo tên thủ thư
            + " OR CONVERT(VARCHAR, PHIEU_MUON.ngay_muon, 23) LIKE ?\n"
            + " OR CONVERT(VARCHAR, PHIEU_MUON.ngay_hen_tra, 23) LIKE ?\n"
            + " OR CONVERT(VARCHAR, PHIEU_MUON.ngay_tra, 23) LIKE ?\n"
            + " OR CAST(PHIEU_MUON.trang_thai AS NVARCHAR) LIKE ?;";
        
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            for (int i = 1; i <= 8; i++) {
                ps.setString(i, "%" + key + "%");
            }

            ResultSet res = ps.executeQuery();

            while (res.next()) {
                PhieuMuon pm = new PhieuMuon();
                pm.setMa_phieu_muon(res.getInt("ma_phieu_muon"));
                pm.setMa_thu_thu(res.getInt("ma_thu_thu"));
                pm.setMa_doc_gia(res.getInt("ma_doc_gia"));
                pm.setNgay_muon(res.getDate("ngay_muon"));
                pm.setNgay_hen_tra(res.getDate("ngay_hen_tra"));
                pm.setNgay_tra(res.getDate("ngay_tra"));
                pm.setTrang_thai(res.getInt("trang_thai"));
                lst_tbl.add(pm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lst_tbl;
    }

    public static String getThuThuById(int id) {
        String sqlQuery = "SELECT ten_thu_thu FROM THU_THU WHERE ma_thu_thu = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("ten_thu_thu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getDocGiaById(int id) {
        String sqlQuery = "SELECT ten_doc_gia FROM DOC_GIA WHERE ma_doc_gia = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("ten_doc_gia");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static List<String> load_cbb_docGiaData() {
        List<String> docGiaList = new ArrayList<>();
        String sqlQuery = "SELECT ten_doc_gia FROM DOC_GIA";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                docGiaList.add(rs.getString("ten_doc_gia"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return docGiaList;
    }

    public static List<String> load_cbb_thuThuData() {
        List<String> thuThuList = new ArrayList<>();
        String sqlQuery = "SELECT ten_thu_thu FROM THU_THU";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                thuThuList.add(rs.getString("ten_thu_thu"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return thuThuList;
    }
    
    public static List<String> load_cbb_tenSachData() {
        List<String> sachList = new ArrayList<>();
        String sqlQuery = "SELECT ten_sach FROM Sach";
        try (Connection conn = ConnectToSQLServer.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                sachList.add(rs.getString("ten_sach"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sachList;
    }

    public static void themPM(PhieuMuon pm) {
        String query = "INSERT INTO PHIEU_MUON (ma_thu_thu, ma_doc_gia, ngay_muon, ngay_hen_tra, ngay_tra, trang_thai)"
                + "VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);

            // Thiết lập tham số từ đối tượng "PHIEU_MUON"
            ps.setInt(1, pm.getMa_thu_thu());
            ps.setInt(2, pm.getMa_doc_gia());
            ps.setDate(3, (Date) (pm.getNgay_muon())); // Chuyển `Date` sang `java.sql.Date`
            ps.setDate(4, (Date) (pm.getNgay_hen_tra()));
            ps.setDate(5, (Date) pm.getNgay_tra());
            ps.setInt(6, pm.getTrang_thai());

            // Truy vấn
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public static void capNhatPM(PhieuMuon pm) {
        String query = "UPDATE PHIEU_MUON SET ma_thu_thu = ?, ma_doc_gia = ?, ngay_muon = ?, ngay_hen_tra = ?, ngay_tra = ?, trang_thai = ? WHERE ma_phieu_muon = ?";

        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);

            // Thiết lập tham số từ đối tượng "PHIEU_MUON"
            ps.setInt(1, pm.getMa_thu_thu());
            ps.setInt(2, pm.getMa_doc_gia());
            ps.setDate(3, (Date) (pm.getNgay_muon())); // Chuyển `Date` sang `java.sql.Date`
            ps.setDate(4, (Date) (pm.getNgay_hen_tra()));
            ps.setDate(5, (Date) pm.getNgay_tra());
            ps.setInt(6, pm.getTrang_thai());
            ps.setInt(7, pm.getMa_phieu_muon()); // mã phiếu mượn là điều kiện cập nhật

            // Truy vấn
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xoaPM(int maPhieuMuon) {
        String query = "DELETE FROM PHIEU_MUON WHERE ma_phieu_muon = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, maPhieuMuon); // Thiết lập tham số là mã phiếu mượn muốn xóa

            // Thực thi câu lệnh muốn xóa
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Xóa phiếu mượn thành công");
            } else {
                System.out.println("Không tìm thấy mã phiếu mượn: " + maPhieuMuon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean checkEmpty(String id){
        String sqlQuery = "SELECT COUNT(*) as dem FROM CHI_TIET_PHIEU_MUON WHERE ma_phieu_muon = ? ";
        try (Connection conn = ConnectToSQLServer.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            // Kiểm tra kết quả truy vấn
            if (rs.next()) {
                int dem = rs.getInt("dem");
                if (dem > 0) {
                    System.err.println("Phiếu Mượn còn tồn tại " + dem + " chi tiết phiếu mượn");
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
