/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HaiDuyhd789
 */
public class dto_LopHoc {
    private int MaLop;
    private int MaCT;
    private int MaNV;
    private String tenLop;
    private Date ngayBD;
    private Date ngayKT;
    private String soLuong;
    private String giaoVien;
    private String phong;
    private int trangThai;


    public dto_LopHoc() {
    }
    
    public dto_LopHoc(int MaLop) {
        this.MaLop = MaLop;
    }
    public dto_LopHoc(int MaLop, int MaCT, int MaNV, String tenLop, Date ngayBD, Date ngayKT, String soLuong, String giaoVien, String phong) {
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
    
    public String getNgayBD(){
        SimpleDateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");
        return dfm.format(ngayBD);
    }

    public String getNgayKT() {
        SimpleDateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");
        return dfm.format(ngayKT);
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

    public int getTrangThai() {
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

    public void setNgayBD(Date ngayBD) {
       this.ngayBD = ngayBD;    
    }

    public void setNgayKT(Date ngayKT) {
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

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}