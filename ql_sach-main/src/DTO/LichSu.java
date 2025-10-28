/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Timestamp;

public class LichSu {
    private int id;
    private String maThuThu;
    private String hanhDong;
    private Timestamp thoiGian;
    private String ghiChu;

    // Constructor không tham số
    public LichSu() {
    }

    // Constructor đầy đủ tham số
     public LichSu(String maThuThu, String hanhDong, Timestamp thoiGian, String ghiChu) {
        this.maThuThu = maThuThu;
        this.hanhDong = hanhDong;
        this.thoiGian = thoiGian;
        this.ghiChu = ghiChu;
    }

    // Getter & Setter
    public String getMaThuThu() {
        return maThuThu;
    }

    public void setMaThuThu(String maThuThu) {
        this.maThuThu = maThuThu;
    }

    public String getHanhDong() {
        return hanhDong;
    }

    public void setHanhDong(String hanhDong) {
        this.hanhDong = hanhDong;
    }

    public Timestamp getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Timestamp thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "LichSu{" +
                "id=" + id +
                ", maThuThu=" + maThuThu +
                ", hanhDong='" + hanhDong + '\'' +
                ", thoiGian='" + thoiGian + '\'' +
                ", ghiChu='" + ghiChu + '\'' +
                '}';
    }
}
