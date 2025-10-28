package BUS;

import DAL.TacGiaDAL;
import DTO.TacGia;
import java.util.List;

public class TacGiaBUS {
    public static List<TacGia> loadTbaleData() {
        return TacGiaDAL.loadTbaleData();
    }
    
    public static List<TacGia> loadTbaleDataSearch(String keyword) {
        return TacGiaDAL.loadTbaleDataSearch(keyword);
    }
    
    public static void themTG(TacGia tg){
        TacGiaDAL.them(tg);
    }
    
    public static void suaTG(TacGia tg){
        TacGiaDAL.sua(tg);
    }
    
    public static void xoaTG(int ma){
        TacGiaDAL.xoa(ma);
    }
    
    public static boolean checkEmpty(String id) {
        if (TacGiaDAL.checkEmpty(id)) {
            return false;
        }
        return true;
    }
}
