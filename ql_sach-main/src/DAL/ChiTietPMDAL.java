package DAL;

import DTO.CTPM;
import java.util.*;
import DTO.CTPM;
import DTO.CTPM.ChiTietPM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChiTietPMDAL {

    public static String getTenSachById(int id) {
        String sqlQuery = "SELECT ten_sach FROM SACH WHERE ma_sach = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                return res.getString("ten_sach");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static List<CTPM.ChiTietPM> LoadTbl(int ma) {
        String sqlQuery = "SELECT * FROM CHI_TIET_PHIEU_MUON WHERE ma_phieu_muon = ?";
        List<CTPM.ChiTietPM> lst_tbl = new ArrayList<>();
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, ma);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                CTPM.ChiTietPM ctpm = new CTPM.ChiTietPM();
                ctpm.setMa_chi_tiet(res.getInt("ma_chi_tiet"));
                ctpm.setMa_sach(res.getInt("ma_sach"));
                lst_tbl.add(ctpm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_tbl;
    }

    public static void themCTPM(CTPM ctpm) {
        String sqlQuery = "INSERT INTO CHI_TIET_PHIEU_MUON (ma_phieu_muon, ma_sach) VALUES(?, ?)";
//        String sqlSort = "SELECT * ma_chi_tiet"
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            
            ps.setInt(1, ctpm.getMa_phieu_muon());
            ps.setInt(2, ctpm.getMa_sach());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xoaCTPM(int maCTPM) {
        String sqlQuery = "DELETE FROM CHI_TIET_PHIEU_MUON WHERE ma_chi_tiet = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            // Thiết lập tham số
            ps.setInt(1, maCTPM);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Xóa phiếu mượn thành công");
            } else {
                System.out.println("Không tìm thấy mã phiếu mượn: " + maCTPM);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
