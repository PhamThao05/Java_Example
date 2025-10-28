package DTO;
   

import java.util.Date;

public class DocGia {
    private int ma_doc_gia;
    private String ten_doc_gia;
    private Date ngay_sinh;
    private String dia_chi;
    private String cmnd;
    private String sdt;

    public DocGia() {
    }

    public int getMa_doc_gia() {
        return ma_doc_gia;
    }

    public void setMa_doc_gia(int ma_doc_gia) {
        this.ma_doc_gia = ma_doc_gia;
    }

    public String getTen_doc_gia() {
        return ten_doc_gia;
    }

    public void setTen_doc_gia(String ten_doc_gia) {
        this.ten_doc_gia = ten_doc_gia;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }


    public DocGia(int ma_doc_gia, String ten_doc_gia, Date ngay_sinh, String dia_chi, String cmnd, String sdt) {
        this.ma_doc_gia = ma_doc_gia;
        this.ten_doc_gia = ten_doc_gia;
        this.ngay_sinh = ngay_sinh;
        this.dia_chi = dia_chi;
        this.cmnd = cmnd;
        this.sdt = sdt;
    }
    
    public DocGia(String ten_doc_gia, Date ngay_sinh, String dia_chi, String cmnd, String sdt) {
        this.ten_doc_gia = ten_doc_gia;
        this.ngay_sinh = ngay_sinh;
        this.dia_chi = dia_chi;
        this.cmnd = cmnd;
        this.sdt = sdt;
    }
    
}
