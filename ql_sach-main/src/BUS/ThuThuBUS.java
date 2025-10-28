package BUS;

import DAL.ThuThuDAL;
import DTO.ThuThu;
import java.util.List;

public class ThuThuBUS {
    public static List<ThuThu.CTThuThu> LoadTBDATA() {
        return ThuThuDAL.LoadTBDATA();
    }
    
    public static List<ThuThu.CTThuThu> LoadtTbDATA_Search(String keyword) {
        return ThuThuDAL.LoadtTbDATA_Search(keyword);
    }
    
    public static void themTT(ThuThu tt) {
        ThuThuDAL.them(tt);
    }
    
    public static void suaTT(ThuThu.CTThuThu cttt) {
        ThuThuDAL.sua(cttt);
    }
    
    public static void xoaTT(int ma) {
        ThuThuDAL.xoa(ma);
    }
    
    public static boolean checkEmpty(String id) {
        if (ThuThuDAL.checkEmpty(id)) {
            return false;
        }
        return true;
    }
}
