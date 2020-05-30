/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.sql.Date;

/**
 *
 * @author HaiDuyhd789
 */
public class dto_LopHoc {
    private int MaLop;
    private int MaCT;
    private int MaNV;
    private String tenLop;
    private String ngayBD;
    private String ngayKT;
    private String soLuong;
    private String giaoVien;
    private String phong;
    private String trangThai;


    public dto_LopHoc() {
    }

    public dto_LopHoc(int MaLop, int MaCT, int MaNV, String tenLop, String ngayBD, String ngayKT, String soLuong, String giaoVien, String phong) {
        this.MaLop = MaLop;
        this.MaCT = MaCT;
        this.MaNV = MaNV;
        this.tenLop = tenLop;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.soLuong = soLuong;
        this.giaoVien = giaoVien;
        this.phong = phong;
        this.trangThai = trangThai;
    }

    public dto_LopHoc(int MaLop) {
        this.MaLop = MaLop;
    }

    public int getMaLop() {
        return MaLop;
    }

    public int getMaCT() {
        return MaCT;
    }

    public int getMaNV() {
        return MaNV;
    }

    public String getTenLop() {
        return tenLop;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public String getGiaoVien() {
        return giaoVien;
    }

    public String getPhong() {
        return phong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setMaLop(int MaLop) {
        this.MaLop = MaLop;
    }

    public void setMaCT(int MaCT) {
        this.MaCT = MaCT;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

 
    
}