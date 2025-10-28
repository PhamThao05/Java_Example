package DAL;

import DTO.ThongKe;
import DTO.ThongKeTheoNamDTO;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ThongKeDAL {

    public static List<ThongKe> loadTK() {
        String sqlQuery = "SELECT \n"
                + "    S.ten_sach,\n"
                + "	DG.ten_doc_gia,\n"
                + "    TT.ten_thu_thu,\n"
                + "    PM.ngay_muon,\n"
                + "    PM.ngay_hen_tra,\n"
                + "    S.so_luong AS tong_so_sach,\n"
                + "    COALESCE(SUM(CASE \n"
                + "                 WHEN PM.trang_thai = 0 THEN CTPM.so_luong \n"
                + "                 END), 0) AS so_luong_da_cho_muon,\n"
                + "    COALESCE(SUM(CASE \n"
                + "                 WHEN PM.trang_thai = 1 THEN CTPM.so_luong \n"
                + "                 END), 0) AS so_luong_da_tra,\n"
                + "    (S.so_luong - COALESCE(SUM(CASE \n"
                + "                 WHEN PM.trang_thai = 0 THEN CTPM.so_luong \n"
                + "                 END), 0)) AS so_luong_con_lai,\n"
                + "    \n"
                + "    CASE\n"
                + "       \n"
                + "        WHEN PM.trang_thai = 0 AND GETDATE() > PM.ngay_hen_tra THEN \n"
                + "            N'Quá hạn ' + CAST(DATEDIFF(DAY, PM.ngay_hen_tra, GETDATE()) AS NVARCHAR) + N' ngày'\n"
                + "        \n"
                + "        \n"
                + "        WHEN PM.trang_thai = 0 AND GETDATE() <= PM.ngay_hen_tra THEN \n"
                + "            N'Còn ' + CAST(DATEDIFF(DAY, GETDATE(), PM.ngay_hen_tra) AS NVARCHAR) + N' ngày'\n"
                + "        \n"
                + "        \n"
                + "        ELSE N'Đã trả'\n"
                + "    END AS tinh_trang,\n"
                + "	\n"
                + "    CASE\n"
                + "        WHEN PM.trang_thai = 0 AND GETDATE() > PM.ngay_hen_tra THEN \n"
                + "            DATEDIFF(DAY, PM.ngay_hen_tra, GETDATE()) * 5000\n"
                + "        ELSE 0\n"
                + "    END AS tien_phat\n"
                + "FROM \n"
                + "    SACH S\n"
                + "LEFT JOIN \n"
                + "    CHI_TIET_PHIEU_MUON CTPM ON S.ma_sach = CTPM.ma_sach\n"
                + "LEFT JOIN \n"
                + "    PHIEU_MUON PM ON CTPM.ma_phieu_muon = PM.ma_phieu_muon\n"
                + "LEFT JOIN \n"
                + "    DOC_GIA DG ON PM.ma_doc_gia = DG.ma_doc_gia\n"
                + "LEFT JOIN \n"
                + "    THU_THU TT ON PM.ma_thu_thu = TT.ma_thu_thu\n"
                + "GROUP BY \n"
                + "    S.ten_sach, S.so_luong, DG.ten_doc_gia, TT.ten_thu_thu, PM.ngay_muon, PM.ngay_hen_tra, PM.trang_thai";
        List<ThongKe> lst_tk = new ArrayList<>();
        try (Connection conn = ConnectToSQLServer.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet res = ps.executeQuery();
            
            while (res.next()) {
                ThongKe tk = new ThongKe(
                res.getString("ten_sach"),
                        res.getString("ten_doc_gia"),
                        res.getString("ten_thu_thu"),
                        res.getDate("ngay_muon"),
                        res.getDate("ngay_hen_tra"),
                        res.getInt("tong_so_sach"),
                        res.getInt("so_luong_da_cho_muon"),
                        res.getInt("so_luong_da_tra"),
                        res.getInt("so_luong_con_lai"),
                        res.getString("tinh_trang"),
                        res.getFloat("tien_phat")
                );
                lst_tk.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_tk;
    }
    
    public static Map<Integer, List<ThongKe>> loadThongKeTheoNam() {
    List<ThongKe> danhSachThongKe = loadTK(); // Dùng hàm bạn đã có
    Map<Integer, List<ThongKe>> thongKeTheoNam = new HashMap<>();

    for (ThongKe tk : danhSachThongKe) {
        Date ngayMuon = tk.getNgay_muon();
        if (ngayMuon == null) continue;

        Calendar cal = Calendar.getInstance();
        cal.setTime(ngayMuon);
        int nam = cal.get(Calendar.YEAR);

        thongKeTheoNam.putIfAbsent(nam, new ArrayList<>());
        thongKeTheoNam.get(nam).add(tk);
    }

    return thongKeTheoNam;
}

    public static List<ThongKeTheoNamDTO> thongKeTongHopTheoNam() {
    List<ThongKeTheoNamDTO> danhSach = new ArrayList<>();
    String sql = """
        SELECT 
            YEAR(PM.ngay_muon) AS Nam,
            SUM(CASE WHEN PM.trang_thai = 0 THEN CTPM.so_luong ELSE 0 END) AS SoLuongDaMuon,
            SUM(CASE WHEN PM.trang_thai = 1 THEN 0 ELSE (S.so_luong - CTPM.so_luong) END) AS SoLuongConLai,
            SUM(CASE 
                WHEN PM.trang_thai = 0 AND GETDATE() > PM.ngay_hen_tra 
                THEN DATEDIFF(DAY, PM.ngay_hen_tra, GETDATE()) * 5000 
                ELSE 0 
            END) AS TongTienPhat
        FROM 
            PHIEU_MUON PM
        JOIN CHI_TIET_PHIEU_MUON CTPM ON PM.ma_phieu_muon = CTPM.ma_phieu_muon
        JOIN SACH S ON CTPM.ma_sach = S.ma_sach
        GROUP BY YEAR(PM.ngay_muon)
        ORDER BY Nam
    """;

    try (Connection conn = ConnectToSQLServer.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            int nam = rs.getInt("Nam");
            int daMuon = rs.getInt("SoLuongDaMuon");
            int conLai = rs.getInt("SoLuongConLai");
            float tienPhat = rs.getFloat("TongTienPhat");

            ThongKeTheoNamDTO dto = new ThongKeTheoNamDTO(nam, daMuon, conLai, tienPhat);
            danhSach.add(dto);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return danhSach;
}
}
