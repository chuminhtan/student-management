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
    private int diemDauVao;
    private int capDo;
    private String noiDung;
    private int trangThai;
    

    public dto_ChuongTrinh() {
    }
    
    
    public dto_ChuongTrinh(int maCt, String tenCt) {
        this.maCt = maCt;
        this.tenCt = tenCt;
    }
    //getter

    public int getMaCt() {
        return maCt;
    }

    public String getTenCt() {
        return tenCt;
    }

    public int getDiemDauVao() {
        return diemDauVao;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public int getCapDo() {
        return capDo;
    }
    //setter

    public void setMaCt(int maCt) {
        this.maCt = maCt;
    }

    public void setTenCt(String tenCt) {
        this.tenCt = tenCt;
    }

    public void setDiemDauVao(int diemDauVao) {
        this.diemDauVao = diemDauVao;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public void setCapDo(int capDo) {
        this.capDo = capDo;
    }
    
    
}
