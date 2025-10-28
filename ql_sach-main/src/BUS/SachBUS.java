package BUS;

import DAL.SachDAL;
import DTO.Sach;
import java.util.List;

public class SachBUS {

    public static List<String> load_cbb_TacGiaData() {
        return SachDAL.load_cbb_TacGiaData();
    }

    public static List<String> load_cbb_TheLoaiData() {
        return SachDAL.load_cbb_TheLoaiData();
    }

    public static List<Sach> loadTableData() {
        return SachDAL.loadTableData();
    }

    public static List<Sach> loadTableDataSearch(String keyword) {
        return SachDAL.loadTableDataSearch(keyword);
    }

    public static void themSach(Sach sach) {
        SachDAL.themSach(sach);
    }

    public static void capNhatSach(Sach sach) {
        SachDAL.capNhatSach(sach);
    }

    public static void xoaSach(int maSach) {
        SachDAL.xoaSach(maSach);
    }

    public static String getTacGiaById(int id) {
        return SachDAL.getTacGiaById(id);
    }

    public static String getTheLoaiById(int id) {
        return SachDAL.getTheLoaiById(id);
    }

    public static boolean checkEmpty(String id) {
        if (id == null || id.trim().isEmpty()) {
            return false;
        }
        return true;
    }
}
