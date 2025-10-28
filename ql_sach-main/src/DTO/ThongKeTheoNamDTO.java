/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author VũNguyễn
 */
public class ThongKeTheoNamDTO {
    private int nam;
    private int tongDaChoMuon;
    private int tongConLai;
    private float tongTienPhat;

    public ThongKeTheoNamDTO(int nam, int tongDaChoMuon, int tongConLai, float tongTienPhat) {
        this.nam = nam;
        this.tongDaChoMuon = tongDaChoMuon;
        this.tongConLai = tongConLai;
        this.tongTienPhat = tongTienPhat;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getTongDaChoMuon() {
        return tongDaChoMuon;
    }

    public void setTongDaChoMuon(int tongDaChoMuon) {
        this.tongDaChoMuon = tongDaChoMuon;
    }

    public int getTongConLai() {
        return tongConLai;
    }

    public void setTongConLai(int tongConLai) {
        this.tongConLai = tongConLai;
    }

    public float getTongTienPhat() {
        return tongTienPhat;
    }

    public void setTongTienPhat(float tongTienPhat) {
        this.tongTienPhat = tongTienPhat;
    }
}

