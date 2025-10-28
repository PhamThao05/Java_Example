package BUS;

import DAL.DocGiaDAL;
import DTO.DocGia;
import java.util.List;

public class DocGiaBUS {

    public static List<DocGia> loadTableData() {
        return DocGiaDAL.loadTableData();
    }

    public static List<DocGia> loadTableDataSearch(String keyword) {
        return DocGiaDAL.loadTableDataSearch(keyword);
    }

    public static void themDG(DocGia dg) {
        DocGiaDAL.them(dg);
    }

    public static void capNhatDG(DocGia dg) {
        DocGiaDAL.capNhat(dg);
    }

    public static void xoaDG(int maDG) {
        DocGiaDAL.xoa(maDG);
    }

    public static boolean checkEmpty(String id) {
        if (id == null || id.trim().isEmpty()) {
            return false;
        }
        return true;
    }
}
