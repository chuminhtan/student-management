/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Vector;

public class NhanVienDTO {

    private String MA_NV;
    private String HO_TEN;
    private String SDT;
    private int LOAI;
    private String TEN_DANG_NHAP;
    private String MAT_KHAU;

    public NhanVienDTO() {
    }

    public NhanVienDTO(String MA_NV, String HO_TEN, String SDT, int LOAI, String TEN_DANG_NHAP, String MAT_KHAU) {
        this.MA_NV = MA_NV;
        this.HO_TEN = HO_TEN;
        this.SDT = SDT;
        this.LOAI = LOAI;
        this.TEN_DANG_NHAP = TEN_DANG_NHAP;
        this.MAT_KHAU = MAT_KHAU;
    }

    public static Vector getVectorColumnIdentifiers() {
        Vector result = new Vector();

        result.add("Mã nhân viên");
        result.add("Họ tên");
        result.add("Số điện thoại");
        result.add("Loại");
        result.add("Tên đăng nhập");
        result.add("Mật khẩu");

        return result;
    }

    public Vector toVector() {
        Vector result = new Vector();

        result.add(this.MA_NV);
        result.add(this.HO_TEN);
        result.add(this.SDT);

        String loai = "Quản lý";
        if (this.LOAI == 2) {
            loai = "Ghi danh";
        } else if (this.LOAI == 3) {
            loai = "Học vụ";
        }
        result.add(loai);

        result.add(this.TEN_DANG_NHAP);
        result.add(this.MAT_KHAU);

        return result;
    }

    public String getMA_NV() {
        return MA_NV;
    }

    public void setMA_NV(String MA_NV) {
        this.MA_NV = MA_NV;
    }

    public String getHO_TEN() {
        return HO_TEN;
    }

    public void setHO_TEN(String HO_TEN) {
        this.HO_TEN = HO_TEN;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getLOAI() {
        return LOAI;
    }

    public void setLOAI(int LOAI) {
        this.LOAI = LOAI;
    }

    public String getTEN_DANG_NHAP() {
        return TEN_DANG_NHAP;
    }

    public void setTEN_DANG_NHAP(String TEN_DANG_NHAP) {
        this.TEN_DANG_NHAP = TEN_DANG_NHAP;
    }

    public String getMAT_KHAU() {
        return MAT_KHAU;
    }

    public void setMAT_KHAU(String MAT_KHAU) {
        this.MAT_KHAU = MAT_KHAU;
    }

}
