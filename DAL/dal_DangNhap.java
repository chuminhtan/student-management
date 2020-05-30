/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.dto_DangNhap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author USER
 */
public class dal_DangNhap extends DBConnect {

    public dto_DangNhap DangNhap(dto_DangNhap dangNhap) {

        dto_DangNhap dn = null;

        try {
            String sql = "SELECT MA_NV, HO_TEN, LOAI, TEN_DANG_NHAP, MAT_KHAU "
                    + "FROM NHAN_VIEN "
                    + "WHERE TEN_DANG_NHAP=? AND MAT_KHAU=?";

            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, dangNhap.getTenDangNhap());
            preStatement.setString(2, dangNhap.getMatKhau());

            ResultSet result = preStatement.executeQuery();

            if (result.next()) {
                dn = new dto_DangNhap();
                dn.setMa(result.getString(1));
                dn.setHoTen(result.getString(2));
                dn.setLoai(result.getInt(3));
                dn.setTenDangNhap(result.getString(3));
                dn.setMatKhau(result.getString(4));
            }
            return dn;
        } catch (Exception ex) {
            ex.printStackTrace();
            return dn;
        }
    }
}
