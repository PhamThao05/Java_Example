package DTO;

import java.util.Date;

public class PhieuMuon {
    private int ma_phieu_muon;
    private int ma_thu_thu;
    private int ma_doc_gia;
    private java.sql.Date ngay_muon;
    private java.sql.Date ngay_hen_tra;
    private java.sql.Date ngay_tra;
    private int trang_thai;

    public PhieuMuon() {
    }

    public int getMa_phieu_muon() {
        return ma_phieu_muon;
    }

    public void setMa_phieu_muon(int ma_phieu_muon) {
        this.ma_phieu_muon = ma_phieu_muon;
    }

    public int getMa_thu_thu() {
        return ma_thu_thu;
    }

    public void setMa_thu_thu(int ma_thu_thu) {
        this.ma_thu_thu = ma_thu_thu;
    }

    public int getMa_doc_gia() {
        return ma_doc_gia;
    }

    public void setMa_doc_gia(int ma_doc_gia) {
        this.ma_doc_gia = ma_doc_gia;
    }

    public Date getNgay_muon() {
        return ngay_muon;
    }

    public void setNgay_muon(java.sql.Date ngay_muon) {
        this.ngay_muon = ngay_muon;
    }

    public Date getNgay_hen_tra() {
        return ngay_hen_tra;
    }

    public void setNgay_hen_tra(java.sql.Date ngay_hen_tra) {
        this.ngay_hen_tra = ngay_hen_tra;
    }

    public Date getNgay_tra() {
        return ngay_tra;
    }

    public void setNgay_tra(java.sql.Date ngay_tra) {
        this.ngay_tra = ngay_tra;
    }

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }

    public PhieuMuon(int ma_phieu_muon, int ma_thu_thu, int ma_doc_gia, java.sql.Date ngay_muon, java.sql.Date ngay_hen_tra, java.sql.Date ngay_tra, int trang_thai) {
        this.ma_phieu_muon = ma_phieu_muon;
        this.ma_thu_thu = ma_thu_thu;
        this.ma_doc_gia = ma_doc_gia;
        this.ngay_muon = ngay_muon;
        this.ngay_hen_tra = ngay_hen_tra;
        this.ngay_tra = ngay_tra;
        this.trang_thai = trang_thai;
    }
    
     public PhieuMuon(int ma_thu_thu, int ma_doc_gia, java.sql.Date ngay_muon, java.sql.Date ngay_hen_tra, java.sql.Date ngay_tra, int trang_thai) {
        this.ma_thu_thu = ma_thu_thu;
        this.ma_doc_gia = ma_doc_gia;
        this.ngay_muon = ngay_muon;
        this.ngay_hen_tra = ngay_hen_tra;
        this.ngay_tra = ngay_tra;
        this.trang_thai = trang_thai;
    }
}
