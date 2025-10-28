package DTO;

public class CTPM {
    private int ma_phieu_muon;
    private int ma_sach;

    public CTPM() {
    }

    public int getMa_phieu_muon() {
        return ma_phieu_muon;
    }

    public void setMa_phieu_muon(int ma_phieu_muon) {
        this.ma_phieu_muon = ma_phieu_muon;
    }

    public int getMa_sach() {
        return ma_sach;
    }

    public void setMa_sach(int ma_sach) {
        this.ma_sach = ma_sach;
    }

    public CTPM(int ma_phieu_muon, int ma_sach) {
        this.ma_phieu_muon = ma_phieu_muon;
        this.ma_sach = ma_sach;
    }
    
    public static class ChiTietPM extends CTPM{
        private int ma_chi_tiet;

        public ChiTietPM() {
        }

        public int getMa_chi_tiet() {
            return ma_chi_tiet;
        }

        public void setMa_chi_tiet(int ma_chi_tiet) {
            this.ma_chi_tiet = ma_chi_tiet;
        }

        public ChiTietPM(int ma_chi_tiet) {
            this.ma_chi_tiet = ma_chi_tiet;
        }

        public ChiTietPM(int ma_chi_tiet, int ma_phieu_muon, int ma_sach) {
            super(ma_phieu_muon, ma_sach);
            this.ma_chi_tiet = ma_chi_tiet;
        }
        
        
    }
    
}



