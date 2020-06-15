/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.dto_LopHoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HaiDuyhd789
 */
public class dal_LopHoc extends DBConnect {

    PreparedStatement preStatement;
    ResultSet result;

    public ArrayList<dto_LopHoc> layToanBoLopHoc() {
        ArrayList<dto_LopHoc> listLH = new ArrayList<>();
        try {
            String sql = "SELECT * FROM LOP ORDER BY MA_LOP ASC";
            preStatement = conn.prepareStatement(sql);
            result = preStatement.executeQuery();
            while (result.next()) {
                dto_LopHoc lh = new dto_LopHoc();
                lh.setMaLop(result.getString(1));
                lh.setMaCT(result.getString(2));
                lh.setMaNV(result.getString(3));
                lh.settenLop(result.getString(4));
                lh.setngayBD(result.getString(5));
                lh.setngayKT(result.getString(6));
                lh.setsoluong(result.getString(7));
                lh.setgiaoVien(result.getString(8));
                lh.setphong(result.getString(9));
                lh.settrangThai(result.getString(10));

                listLH.add(lh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

//        //test
//        for (int i = 0; i < 10; i++) {
//            listLH.add(new dto_LopHoc("Malop", "Mact", "Manv", "Tenlop", "01-01-2020", "01-01-2020", "10", "giaovien", "Phong", "Trangthai"));
//        }

        return listLH;
    }

    public boolean themLopHoc(dto_LopHoc lh) {
        try {
            String sql = "INSERT INTO LOP VALUES(lop_sequence.nextval,?,?,?,TO_DATE(?,'dd/MM/yyyy'),TO_DATE(?,'dd/MM/yyyy'),?,?,?,?)";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, lh.getMaCT());
            preStatement.setString(2, lh.getMaNV());
            preStatement.setString(3, lh.gettenLop());
            preStatement.setString(4, lh.getngayBD());
            preStatement.setString(5, lh.getngayKT());
            preStatement.setString(6, lh.getsoLuong());
            preStatement.setString(7, lh.getgiaoVien());
            preStatement.setString(8, lh.getphong());
            preStatement.setString(9, lh.gettrangThai());

            int n = preStatement.executeUpdate();
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoaLopHoc(String ma) {
        try {
            String sql = "DELETE FROM LOP WHERE MA_LOP = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, ma);
            int n = preStatement.executeUpdate();
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean capNhatLopHoc(dto_LopHoc lh) {
        try {
            String sql = "UPDATE LOP SET MA_CT = ?, MA_NV =?, TEN_LOP=?, NGAY_BD=TO_DATE(?,'dd/MM/yyyy'), NGAY_KT =TO_DATE(?,'dd/MM/yyyy'), SL=?, GV=?, PHONG=?, TRANG_THAI=? WHERE MA_LOP=? ";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, lh.getMaCT());
            preStatement.setString(2, lh.getMaNV());
            preStatement.setString(3, lh.gettenLop());
            preStatement.setString(4, lh.getngayBD());
            preStatement.setString(5, lh.getngayKT());
            preStatement.setString(6, lh.getsoLuong());
            preStatement.setString(7, lh.getgiaoVien());
            preStatement.setString(8, lh.getphong());
            preStatement.setString(9, lh.gettrangThai());
            preStatement.setString(10, lh.getMaLop());

            int n = preStatement.executeUpdate();
            if (n > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(dal_LopHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
