package DAL;

import DTO.dto_kqht;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class dal_kqht extends DBConnect {

    // LẤY DANH SÁCH KQHT
    public ArrayList<dto_kqht> layDsKqht(int maLop) {

        ArrayList<dto_kqht> dsKqht = new ArrayList<dto_kqht>();
        dto_kqht kqht = null;

        String sql = "SELECT ma_kh, ma_lop, nghe, noi, doc, viet, tong "
                + "FROM kqht "
                + "WHERE ma_lop = ?";

        try {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, maLop);

            ResultSet rs = preStmt.executeQuery();

            while (rs.next()) {

                kqht = new dto_kqht();
                kqht.setMaKh(rs.getInt(1));
                kqht.setMaLop(rs.getInt(2));
                kqht.setNghe(rs.getFloat(3));
                kqht.setNoi(rs.getFloat(4));
                kqht.setDoc(rs.getFloat(5));
                kqht.setViet(rs.getFloat(6));
                kqht.setTong(rs.getFloat(7));

                dsKqht.add(kqht);
            }

            conn.close();
            return dsKqht;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
