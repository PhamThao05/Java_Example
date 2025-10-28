package BUS;

import DAL.PhieuMuonDAL;
import DTO.PhieuMuon;
import java.util.List;

public class PhieuMuonBUS {
    public static List<PhieuMuon> loadTableData() {
        return PhieuMuonDAL.loadTableData();
    }
    
    public static List<PhieuMuon> loadTableDataSearch(String key) {
        return PhieuMuonDAL.loadTableDataSearch(key);
    }
    
    public static String getThuThuById(int id) {
        return PhieuMuonDAL.getThuThuById(id);
    }
    
    public static String getDocGiaById(int id) {
        return PhieuMuonDAL.getDocGiaById(id);
    }
    
    public static List<String> load_cbb_docGiaData() {
        return PhieuMuonDAL.load_cbb_docGiaData();
    }
    
    public static List<String> load_cbb_thuThuData() {
        return PhieuMuonDAL.load_cbb_thuThuData();
    }
    
    public static List<String> load_cbb_tenSachData() {
        return PhieuMuonDAL.load_cbb_tenSachData();
    }
    
    public static void themPM(PhieuMuon pm) {
        PhieuMuonDAL.themPM(pm);
    }
    
    public static void capNhatPM(PhieuMuon pm) {
        PhieuMuonDAL.capNhatPM(pm);
    }
    
    public static void xoaPM(int maPhieuMuon) {
        PhieuMuonDAL.xoaPM(maPhieuMuon);
    }
    
    public static boolean checkEmpty(String id){
        if (PhieuMuonBUS.checkEmpty(id)) {
            return true;
        }
        return false;
    }
}
