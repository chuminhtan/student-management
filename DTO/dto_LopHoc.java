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
public class dto_LopHoc {
    private String MaLop;
    private String MaCT;
    private String MaNV;
    private String tenLop;
    private String ngayBD;
    private String ngayKT;
    private String soLuong;
    private String giaoVien;
    private String phong;
    private String trangThai;


    public dto_LopHoc() {
    }

    public dto_LopHoc(String MaLop, String MaCT, String MaNV, String tenLop, String ngayBD, String ngayKT, String soLuong, String giaoVien, String phong,String trangThai) {
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
    
    public dto_LopHoc(String MaCT, String MaNV, String tenLop, String ngayBD, String ngayKT, String soLuong, String giaoVien, String phong,String trangThai) {
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
    
    public String getMaLop() {
        return MaLop;
    }
    
    public String getMaCT() {
        return MaCT;
    }
    
    public String getMaNV() {
        return MaNV;
    }
    
    public String gettenLop() {
        return tenLop;
    }
    
    public String getngayBD() {
        return ngayBD;
    }
    
    public String getngayKT() {
        return ngayKT;
    }
    
    public String getsoLuong() {
        return soLuong;
    }
    
    public String getgiaoVien() {
        return giaoVien;
    }
    
    public String getphong() {
        return phong;
    }
    
    public String gettrangThai() {
        return trangThai;
    }
    
    public void setMaLop(String MaLop) {
        this.MaLop = MaLop;
    }
    
    public void setMaCT(String MaCT) {
        this.MaCT = MaCT;
    }
    
    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    
    public void settenLop(String tenLop) {
        this.tenLop = tenLop;
    }
    
    public void setngayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }
    
    public void setngayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }
    
    public void setsoluong(String soLuong) {
        this.soLuong = soLuong;
    }
    
    public void setgiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }
    
    public void setphong(String phong) {
        this.phong = phong;
    }
    
    public void settrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
}