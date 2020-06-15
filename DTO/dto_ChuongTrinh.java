/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author HaiDuyhd789
 */
public class dto_ChuongTrinh {
    private String MaCT;
    private String tenCT;
    private String level;
    private String diemDauVao;
    private String noiDung;
    private String trangThai;


    public dto_ChuongTrinh() {
    }

    public dto_ChuongTrinh(String MaCT, String tenCT, String level, String diemDauVao, String noiDung, String trangThai) {
        this.MaCT = MaCT;
        this.tenCT = tenCT;
        this.level = level;
        this.diemDauVao = diemDauVao;
        this.noiDung = noiDung;
        this.trangThai = trangThai;
    }
    
    public dto_ChuongTrinh(String tenCT, String level, String diemDauVao, String noiDung, String trangThai) {
        this.tenCT = tenCT;
        this.level = level;
        this.diemDauVao = diemDauVao;
        this.noiDung = noiDung;
        this.trangThai = trangThai;
    }
    
    
    public String getMaCT() {
        return MaCT;
    }
    
    
    public String gettenCT() {
        return tenCT;
    }
    
    public String getlevel() {
        return level;
    }
    
    public String getdiemDauVao() {
        return diemDauVao;
    }
    
    public String getnoiDung() {
        return noiDung;
    }
    
    public String gettrangThai() {
        return trangThai;
    }
    
    public void setMaCT(String MaCT) {
        this.MaCT = MaCT;
    }
    
    public void settenCT(String tenCT) {
        this.tenCT = tenCT;
    }
    
    public void setlevel(String level) {
        this.level = level;
    }
    
    public void setdiemDauVao(String diemDauVao) {
        this.diemDauVao = diemDauVao;
    }
    
    public void setnoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
    
    public void settrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
}
