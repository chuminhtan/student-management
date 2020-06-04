/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.dto_DangNhap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

            PreparedStatement preStatement = this.conn.prepareStatement(sql);
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
        } catch (SQLException ex) {
            Logger.getLogger(dal_DangNhap.class.getName()).log(Level.SEVERE, null, ex);
            return dn;
        }
    }

    public ArrayList<dto_DangNhap> getList() {
        ArrayList<dto_DangNhap> result = new ArrayList<>();

        String sql = "SELECT * FROM NHANVIEN;";

        try {
            PreparedStatement preStatement = this.conn.prepareStatement(sql);
            ResultSet resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                result.add(new dto_DangNhap(
                        resultSet.getString("MA_NV"),
                        resultSet.getString("HO_TEN"),
                        resultSet.getInt("LOAI"),
                        resultSet.getString("TEN_DANG_NHAP"),
                        resultSet.getString("MAT_KHAU"),
                        resultSet.getString("SDT")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(dal_DangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
}
