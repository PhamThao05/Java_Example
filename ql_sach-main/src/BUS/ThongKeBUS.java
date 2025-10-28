package BUS;

import DAL.ThongKeDAL;
import DTO.ThongKe;
import DTO.ThongKeTheoNamDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ThongKeBUS {
    public static List<ThongKe> loadTK() {
        return ThongKeDAL.loadTK();
    }  
    
    public static List<ThongKeTheoNamDTO> thongKeTongHopTheoNam() {
    Map<Integer, List<ThongKe>> dataTheoNam = ThongKeDAL.loadThongKeTheoNam();
    List<ThongKeTheoNamDTO> ketQua = new ArrayList<>();

    for (Map.Entry<Integer, List<ThongKe>> entry : dataTheoNam.entrySet()) {
        int nam = entry.getKey();
        int tongMuon = 0;
        int tongConLai = 0;
        float tongPhat = 0;

        for (ThongKe tk : entry.getValue()) {
            tongMuon += tk.getSl_dachomuon();
            tongConLai += tk.getSl_con(); 
            tongPhat += tk.getTien_phat();
        }

        ketQua.add(new ThongKeTheoNamDTO(nam, tongMuon, tongConLai, tongPhat));
    }

    return ketQua;
}

}
