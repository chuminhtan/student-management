/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.dto_ChungChi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class dal_ChungChi extends DBConnect {
    // HÀM LẤY CHỨNG CHỈ

    public ArrayList<dto_ChungChi> layDsChungChi() {

        ArrayList<dto_ChungChi> dsChungChi = new ArrayList<dto_ChungChi>();
        dto_ChungChi cc = null;
        try {
            String sql = "SELECT ma_chung_chi, ten_chung_chi, diem_toi_da, noi_dung, src_img "
                    + "FROM chung_chi";

            PreparedStatement preStmt = conn.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();

            for (int i = 0; rs.next() == true; i++) {
                cc = new dto_ChungChi();
                cc.setMaCc(rs.getInt(1));
                cc.setTenCc(rs.getString(2));
                cc.setDiemToiDa(rs.getFloat(3));
                cc.setNoiDung(rs.getString(4));
                cc.setSrcImg(rs.getString(5));

                dsChungChi.add(cc);

            }

            conn.close();
            return dsChungChi;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return dsChungChi;
        }
    }
}
