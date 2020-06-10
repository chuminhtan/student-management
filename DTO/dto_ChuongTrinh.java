/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author USER
 */
public class dto_ChuongTrinh {
    private int maCt;
    private String tenCt;
    private String tenCc;
    private float diemDauVao;
    private float diemDauRa;
    private String noiDung;
    private int trangThai; // 0-đóng , 1-mở

    public dto_ChuongTrinh() {
    }
    
    //getter

    public int getMaCt() {
        return maCt;
    }

    public String getTenCc() {
        return tenCc;
    }

    public String getTenCt() {
        return tenCt;
    }

    public float getDiemDauVao() {
        return diemDauVao;
    }

    public float getDiemDauRa() {
        return diemDauRa;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public int getTrangThai() {
        return trangThai;
    }
    
    
    //setter

    public void setMaCt(int maCt) {
        this.maCt = maCt;
    }

    public void setTenCc(String tenCc) {
        this.tenCc = tenCc;
    }

    public void setTenCt(String tenCt) {
        this.tenCt = tenCt;
    }

    public void setDiemDauVao(float diemDauVao) {
        this.diemDauVao = diemDauVao;
    }

    public void setDiemDauRa(float diemDauRa) {
        this.diemDauRa = diemDauRa;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
