package DTO;

public class TacGia {
    private int ma_tac_gia;
    private String ten_tac_gia;

    public TacGia() {
    }
    
    
    public int getMa_tac_gia() {
        return ma_tac_gia;
    }

    public void setMa_tac_gia(int ma_tac_gia) {
        this.ma_tac_gia = ma_tac_gia;
    }

    public String getTen_tac_gia() {
        return ten_tac_gia;
    }

    public void setTen_tac_gia(String ten_tac_gia) {
        this.ten_tac_gia = ten_tac_gia;
    }

    public TacGia(int ma_tac_gia, String ten_tac_gia) {
        this.ma_tac_gia = ma_tac_gia;
        this.ten_tac_gia = ten_tac_gia;
    }
    
     public TacGia(String ten_tac_gia) {
        this.ten_tac_gia = ten_tac_gia;
    }
}
