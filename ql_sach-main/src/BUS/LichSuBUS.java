/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.LichSu;
import DAL.LichSuDAL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class LichSuBUS {
    public static void ghiLichSu(String maThuThu, String hanhDong, String ghiChu) {
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        LichSu ls = new LichSu(maThuThu, hanhDong, now, ghiChu);
        LichSuDAL.themLichSu(ls);
    }

    public static List<LichSu> layDanhSachLichSu() {
        return LichSuDAL.layLichSu();
    }
}



