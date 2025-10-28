package BUS;

import DAL.TheLoaiDAL;
import DTO.TheLoai;
import java.util.List;

public class TheLoaiBUS {
    public static List<TheLoai> loadTableData() {
        return TheLoaiDAL.loadTableData();
    }
    
    public static void themTheLoai(TheLoai theloai) {
        TheLoaiDAL.themTheLoai(theloai);
    }
    
    public static void suaTheLoai(TheLoai theloai) {
        TheLoaiDAL.suaTheLoai(theloai);
    }
    
    public static void xoaTheLoai(int maTheLoai) {
        TheLoaiDAL.xoaTheLoai(maTheLoai);
    }
    
    public static List<TheLoai> loadTableDataSearch(String key) {
        return TheLoaiDAL.loadTableDataSearch(key);
    }
    
     public static boolean checkEmpty(String id) {
        if (TheLoaiDAL.checkEmpty(id)) {
            return false;
        }
        return true;
    }
}
