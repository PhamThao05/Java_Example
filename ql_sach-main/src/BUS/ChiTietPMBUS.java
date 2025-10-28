package BUS;

import DAL.ChiTietPMDAL;
import DTO.CTPM;
import java.util.List;

public class ChiTietPMBUS {
    public static String getTenSachById(int id) {
        return ChiTietPMDAL.getTenSachById(id);
    }
    
    public static List<CTPM.ChiTietPM> LoadTbl(int ma) {
        return ChiTietPMDAL.LoadTbl(ma);
    }
    
    public static void themCTPM(CTPM ctpm) {
        ChiTietPMDAL.themCTPM(ctpm);
    }
    
    public static void xoaCTPM(int maCTPM) {
        ChiTietPMDAL.xoaCTPM(maCTPM);
    }
}
