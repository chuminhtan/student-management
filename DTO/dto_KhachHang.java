/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class dto_KhachHang {
    private String MaKH;
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String sdt;
    private String trangThai;
    private String diemDauVao;

    public dto_KhachHang() {
    }

    public dto_KhachHang(String MaKH, String hoTen, Date ngaySinh, String gioiTinh, String diaChi, String sdt, String trangThai, String diemDauVao) {
        this.MaKH = MaKH;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.diemDauVao = diemDauVao;
    }
    
    
    public String getMaKH() {
        return MaKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public String getDiemDauVao() {
        return diemDauVao;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setDiemDauVao(String diemDauVao) {
        this.diemDauVao = diemDauVao;
    }
    
    
}
