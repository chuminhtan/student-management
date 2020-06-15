/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * Đối tượng sử dụng cho đăng nhập
 */
public class dto_DangNhap {
    private String ma;
    private String hoTen;
    private String tenDangNhap;
    private String matKhau;

    public dto_DangNhap() {
    }

    public dto_DangNhap(String tenDangNhap, String matKhau) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }


    public String getMa() {
        return ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    
}
