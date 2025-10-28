/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.LichSu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LichSuDAL {
    public static void themLichSu(LichSu ls) {
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            String sql = "INSERT INTO LichSu(maThuThu, hanhDong, thoiGian, ghiChu) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ls.getMaThuThu());
            ps.setString(2, ls.getHanhDong());
            ps.setTimestamp(3, ls.getThoiGian());
            ps.setString(4, ls.getGhiChu());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<LichSu> layLichSu() {
        List<LichSu> ds = new ArrayList<>();
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            String sql = "SELECT * FROM LichSu ORDER BY thoiGian DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LichSu ls = new LichSu();
                ls.setMaThuThu(rs.getString("maThuThu"));
                ls.setHanhDong(rs.getString("hanhDong"));
                ls.setThoiGian(rs.getTimestamp("thoiGian"));
                ls.setGhiChu(rs.getString("ghiChu"));
                ds.add(ls);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
}

