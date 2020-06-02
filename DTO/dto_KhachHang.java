/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author USER
 */
public class dto_KhachHang {
    private int MaKH;
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String sdt;
    private int trangThai;
    private int diemDauVao;

    //CONSTRUCTOR
    public dto_KhachHang() {
    }

    public dto_KhachHang(int MaKH) {
        this.MaKH = MaKH;
    }
    
    public dto_KhachHang(int MaKH, String hoTen, Date ngaySinh, String gioiTinh, String diaChi, String sdt, int trangThai, int diemDauVao) {
        this.MaKH = MaKH;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.diemDauVao = diemDauVao;
    }
    
    //GETTER
    public int getMaKH() {
        return MaKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public Date getNgaySinh() {
        SimpleDateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");
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

    public int getTrangThai() {
        return trangThai;
    }

    public int getDiemDauVao() {
        return diemDauVao;
    }
    
    //SETTER
    public void setMaKH(int MaKH) {
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

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public void setDiemDauVao(int diemDauVao) {
        this.diemDauVao = diemDauVao;
    }
    
    
}
