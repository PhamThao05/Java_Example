package DTO;

import java.util.Date;

public class ThongKe {
    private String ten_S;
    private String ten_DG;
    private String ten_TT;
    private Date ngay_muon;
    private Date ngay_hen_tra;
    private int sl_tong;
    private int sl_dachomuon;
    private int sl_datra;
    private int sl_con;
    private String tinh_trang;
    private double tien_phat;

    public ThongKe() {
    }

    public String getTen_S() {
        return ten_S;
    }

    public void setTen_S(String ten_S) {
        this.ten_S = ten_S;
    }

    public String getTen_DG() {
        return ten_DG;
    }

    public void setTen_DG(String ten_DG) {
        this.ten_DG = ten_DG;
    }

    public String getTen_TT() {
        return ten_TT;
    }

    public void setTen_TT(String ten_TT) {
        this.ten_TT = ten_TT;
    }

    public Date getNgay_muon() {
        return ngay_muon;
    }

    public void setNgay_muon(Date ngay_muon) {
        this.ngay_muon = ngay_muon;
    }

    public Date getNgay_hen_tra() {
        return ngay_hen_tra;
    }

    public void setNgay_hen_tra(Date ngay_hen_tra) {
        this.ngay_hen_tra = ngay_hen_tra;
    }

    public int getSl_tong() {
        return sl_tong;
    }

    public void setSl_tong(int sl_tong) {
        this.sl_tong = sl_tong;
    }

    public int getSl_dachomuon() {
        return sl_dachomuon;
    }

    public void setSl_dachomuon(int sl_dachomuon) {
        this.sl_dachomuon = sl_dachomuon;
    }

    public int getSl_datra() {
        return sl_datra;
    }

    public void setSl_datra(int sl_datra) {
        this.sl_datra = sl_datra;
    }

    public int getSl_con() {
        return sl_con;
    }

    public void setSl_con(int sl_con) {
        this.sl_con = sl_con;
    }

    public String getTinh_trang() {
        return tinh_trang;
    }

    public void setTinh_trang(String tinh_trang) {
        this.tinh_trang = tinh_trang;
    }

    public double getTien_phat() {
        return tien_phat;
    }

    public void setTien_phat(double tien_phat) {
        this.tien_phat = tien_phat;
    }

    public ThongKe(String ten_S, String ten_DG, String ten_TT, Date ngay_muon, Date ngay_hen_tra, int sl_tong, int sl_dachomuon, int sl_datra, int sl_con, String tinh_trang, double tien_phat) {
        this.ten_S = ten_S;
        this.ten_DG = ten_DG;
        this.ten_TT = ten_TT;
        this.ngay_muon = ngay_muon;
        this.ngay_hen_tra = ngay_hen_tra;
        this.sl_tong = sl_tong;
        this.sl_dachomuon = sl_dachomuon;
        this.sl_datra = sl_datra;
        this.sl_con = sl_con;
        this.tinh_trang = tinh_trang;
        this.tien_phat = tien_phat;
    }
}
