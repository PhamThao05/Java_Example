package DTO;

import java.util.Date;

public class Sach {

    private int ma_sach;
    private String ten_sach;
    private String ngon_ngu_sach;
    private float gia_tri;
    private int so_luong;
    private int tacgia;
    private int the_loai;
    private String nha_xuat_ban;
    private Date nam_xuat_ban;

    public Sach() {
    }

    public int getMa_sach() {
        return ma_sach;
    }

    public void setMa_sach(int ma_sach) {
        this.ma_sach = ma_sach;
    }

    public String getTen_sach() {
        return ten_sach;
    }

    public void setTen_sach(String ten_sach) {
        this.ten_sach = ten_sach;
    }

    public String getNgon_ngu_sach() {
        return ngon_ngu_sach;
    }

    public void setNgon_ngu_sach(String ngon_ngu_sach) {
        this.ngon_ngu_sach = ngon_ngu_sach;
    }

    public float getGia_tri() {
        return gia_tri;
    }

    public void setGia_tri(float gia_tri) {
        this.gia_tri = gia_tri;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public int getTacgia() {
        return tacgia;
    }

    public void setTacgia(int tacgia) {
        this.tacgia = tacgia;
    }

    public int getThe_loai() {
        return the_loai;
    }

    public void setThe_loai(int the_loai) {
        this.the_loai = the_loai;
    }

    public String getNha_xuat_ban() {
        return nha_xuat_ban;
    }

    public void setNha_xuat_ban(String nha_xuat_ban) {
        this.nha_xuat_ban = nha_xuat_ban;
    }

    public Date getNam_xuat_ban() {
        return nam_xuat_ban;
    }

    public void setNam_xuat_ban(Date nam_xuat_ban) {
        this.nam_xuat_ban = nam_xuat_ban;
    }

    public Sach(int ma_sach, String ten_sach, String ngon_ngu_sach, float gia_tri, int so_luong, int tacgia, int the_loai, String nha_xuat_ban, Date nam_xuat_ban) {
        this.ma_sach = ma_sach;
        this.ten_sach = ten_sach;
        this.ngon_ngu_sach = ngon_ngu_sach;
        this.gia_tri = gia_tri;
        this.so_luong = so_luong;
        this.tacgia = tacgia;
        this.the_loai = the_loai;
        this.nha_xuat_ban = nha_xuat_ban;
        this.nam_xuat_ban = nam_xuat_ban;
    }

    public Sach(String ten_sach, String ngon_ngu_sach, float gia_tri, int so_luong, int tacgia, int the_loai, String nha_xuat_ban, Date nam_xuat_ban) {
        this.ten_sach = ten_sach;
        this.ngon_ngu_sach = ngon_ngu_sach;
        this.gia_tri = gia_tri;
        this.so_luong = so_luong;
        this.tacgia = tacgia;
        this.the_loai = the_loai;
        this.nha_xuat_ban = nha_xuat_ban;
        this.nam_xuat_ban = nam_xuat_ban;
    }

}
