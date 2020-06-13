/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author USER
 */
public class dto_LopHoc {
    private int maLop;
    private int maCt;
    private int maNv;
    private String tenLop;
    private Date ngayBd;
    private Date ngayKt;
    private String giaoVien;
    private String phong;
    private int trangThai;
    private String tenCt;
    
    public dto_LopHoc() {
    }
    
    //getter

    public String getTenCt() {
        return tenCt;
    }
    
    
    public int getMaLop() {
        return maLop;
    }

    public int getMaCt() {
        return maCt;
    }

    public int getMaNv() {
        return maNv;
    }

    public String getTenLop() {
        return tenLop;
    }

    public Date getNgayBd() {
        return ngayBd;
    }

    public Date getNgayKt() {
        return ngayKt;
    }

    public String getGiaoVien() {
        return giaoVien;
    }

    public String getPhong() {
        return phong;
    }

    public int getTrangThai() {
        return trangThai;
    }
    
    //setter

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public void setMaCt(int maCt) {
        this.maCt = maCt;
    }

    public void setMaNv(int maNv) {
        this.maNv = maNv;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public void setNgayBd(Date ngayBd) {
        this.ngayBd = ngayBd;
    }

    public void setNgayKt(Date ngayKt) {
        this.ngayKt = ngayKt;
    }

    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public void setTenCt(String tenCt) {
        this.tenCt = tenCt;
    }
    
    
}
