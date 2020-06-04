/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;

public class TaiKhoanDTO {

    private String MA_NV;
    private String HO_TEN;
    private String SDT;
    private Integer LOAI;
    private String TEN_DANG_NHAP;
    private String MAT_KHAU;

    public TaiKhoanDTO() {
    }

    public TaiKhoanDTO(String MA_NV, String HO_TEN, String SDT, Integer LOAI, String TEN_DANG_NHAP, String MAT_KHAU) {
        this.MA_NV = MA_NV;
        this.HO_TEN = HO_TEN;
        this.SDT = SDT;
        this.LOAI = LOAI;
        this.TEN_DANG_NHAP = TEN_DANG_NHAP;
        this.MAT_KHAU = MAT_KHAU;
    }

    public static Object[] getArrayColumnIdentifiers() {
        return new Object[]{
            "Mã tài khoản",
            "Họ tên",
            "Số điện thoại",
            "Loại",
            "Tên đăng nhập",
            "Mật khẩu"
        };
    }

    public static Vector getVectorColumnIdentifiers() {
        return new Vector(Arrays.asList(TaiKhoanDTO.getArrayColumnIdentifiers()));
    }

    public Object[] toArray() {
        return new Object[]{
            this.MA_NV,
            this.HO_TEN,
            this.SDT,
            this.LOAI,
            this.TEN_DANG_NHAP,
            this.MAT_KHAU
        };
    }

    public Vector toVector() {
        return new Vector(Arrays.asList(this.toArray()));
    }

    public TaiKhoanDTO fromArray(Object[] array) {
        this.MA_NV = (String) array[0];
        this.HO_TEN = (String) array[1];
        this.SDT = (String) array[2];
        this.LOAI = (Integer) array[3];
        this.TEN_DANG_NHAP = (String) array[4];
        this.MAT_KHAU = (String) array[5];
        return this;
    }

    public TaiKhoanDTO fromVector(Vector vector) {
        return this.fromArray(vector.toArray());
    }

    @Override
    public String toString() {
        return "Nhân viên có"
                + " mã tài khoản là '" + MA_NV + "'"
                + ",  họ tên là '" + HO_TEN + "'"
                + ",  số điện thoại là '" + SDT + "'"
                + ", thuộc loại '" + this.getLOAIToString() + "'"
                + ", tên đăng nhập là '" + TEN_DANG_NHAP + "'"
                + " và mật khẩu là '" + MAT_KHAU + "'";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.MA_NV);
        hash = 41 * hash + Objects.hashCode(this.HO_TEN);
        hash = 41 * hash + Objects.hashCode(this.SDT);
        hash = 41 * hash + Objects.hashCode(this.LOAI);
        hash = 41 * hash + Objects.hashCode(this.TEN_DANG_NHAP);
        hash = 41 * hash + Objects.hashCode(this.MAT_KHAU);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaiKhoanDTO other = (TaiKhoanDTO) obj;
        if (!Objects.equals(this.MA_NV, other.MA_NV)) {
            return false;
        }
        if (!Objects.equals(this.HO_TEN, other.HO_TEN)) {
            return false;
        }
        if (!Objects.equals(this.SDT, other.SDT)) {
            return false;
        }
        if (!Objects.equals(this.TEN_DANG_NHAP, other.TEN_DANG_NHAP)) {
            return false;
        }
        if (!Objects.equals(this.MAT_KHAU, other.MAT_KHAU)) {
            return false;
        }
        if (!Objects.equals(this.LOAI, other.LOAI)) {
            return false;
        }
        return true;
    }

    public boolean validateMA_NV() throws TaiKhoanValidateException {
        if (this.MA_NV == null) {
            throw new TaiKhoanValidateException("Mã nhân viên của tài khoản không tồn tại");
        }
        return true;
    }

    public boolean validateHO_TEN() throws TaiKhoanValidateException {
        if (this.HO_TEN == null) {
            throw new TaiKhoanValidateException("Họ tên của tài khoản không tồn tại");
        }
        if (!this.HO_TEN.matches("^([A-Z][a-z]*)( [A-Z][a-z]*)*$")) {
            throw new TaiKhoanValidateException("Họ tên của tài khoản không đạt yêu cầu");
        }
        return true;
    }

    public boolean validateSDT() throws TaiKhoanValidateException {
        if (this.SDT == null) {
            throw new TaiKhoanValidateException("Số điện thoại của tài khoản không tồn tại");
        }
        if (!this.SDT.matches("^[0-9]{10,}$")) {
            throw new TaiKhoanValidateException("Số điện thoại của tài khoản không đạt yêu cầu");
        }
        return true;
    }

    public boolean validateLOAI() throws TaiKhoanValidateException {
        if (this.LOAI == null) {
            throw new TaiKhoanValidateException("Loại của tài khoản không tồn tại");
        }
        if (!this.LOAI.toString().matches("[0-9]")) {
            throw new TaiKhoanValidateException("Loại của tài khoản không đạt yêu cầu");
        }
        return true;
    }

    public boolean validateTEN_DANG_NHAP() throws TaiKhoanValidateException {
        if (this.TEN_DANG_NHAP == null) {
            throw new TaiKhoanValidateException("Tên đăng nhập của tài khoản không tồn tại");
        }
        if (!this.TEN_DANG_NHAP.matches("^[A-Za-z0-9 ]+$")) {
            throw new TaiKhoanValidateException("Tên đăng nhập của tài khoản không đạt yêu cầu");
        }
        return true;
    }

    public boolean validateMAT_KHAU() throws TaiKhoanValidateException {
        if (this.MAT_KHAU == null) {
            throw new TaiKhoanValidateException("Mật khẩu của tài khoản không tồn tại");
        }
        if (this.MAT_KHAU.length() < 1) {
            throw new TaiKhoanValidateException("Mật khẩu của tài khoản quá ngắn");
        }
        return true;
    }

    public String getLOAIToString() {
        return this.LOAI == 1 ? "Ghi danh" : (this.LOAI == 2 ? "Học vụ" : "Quản lý");
    }

    public void setLOAIFromString(String stringLOAI) {
        this.LOAI = "Ghi danh".equals(stringLOAI) ? 1 : ("Học vụ".equals(stringLOAI) ? 2 : 0);
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

    public Integer getLOAI() {
        return LOAI;
    }

    public void setLOAI(Integer LOAI) {
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
