package DAL;

import DTO.TacGia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TacGiaDAL {
    public static List<TacGia> loadTbaleData() {
        List<TacGia> lst_tbl = new ArrayList<>();
        String sqlQuery = "SELECT * FROM TAC_GIA";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                TacGia tg = new TacGia();
                tg.setMa_tac_gia(res.getInt("ma_tac_gia"));
                tg.setTen_tac_gia(res.getString("ten_tac_gia"));
                lst_tbl.add(tg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_tbl;
    }
    
    public static List<TacGia> loadTbaleDataSearch(String keyword) {
        List<TacGia> lst_tbl = new ArrayList<>();

        String sqlQuery = "SELECT * FROM TAC_GIA WHERE CAST(ma_tac_gia AS NVARCHAR) LIKE ? OR ten_tac_gia LIKE ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            for (int i = 1; i <= 2; i++) {
                ps.setString(i, "%" + keyword + "%");
            }
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                TacGia tg = new TacGia();
                tg.setMa_tac_gia(res.getInt("ma_tac_gia"));
                tg.setTen_tac_gia(res.getString("ten_tac_gia"));
                lst_tbl.add(tg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_tbl;
    }
    
    public static void them(TacGia tg){
        String sqlQuery = "INSERT INTO TAC_GIA(ten_tac_gia) VALUES (?)";
        try (Connection conn = ConnectToSQLServer.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, tg.getTen_tac_gia());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void sua(TacGia tg){
        String sqlQuery = "UPDATE TAC_GIA SET ten_tac_gia = ? WHERE ma_tac_gia = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(2, tg.getMa_tac_gia());
            ps.setString(1, tg.getTen_tac_gia());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
    
    
    public static void xoa(int ma){
        String sqlQuery = "DELETE FROM TAC_GIA WHERE ma_tac_gia = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, ma);
            ps.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean checkEmpty(String id) {
        String sqlQuery = "SELECT COUNT(*) AS dem FROM SACH WHERE ma_tac_gia = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            // Kiểm tra kết quả truy vấn
            if (rs.next()) {
                int dem = rs.getInt("dem");
                if (dem > 0) {
                    System.err.println("Tác giả còn tồn tại " + dem + " sách");
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
