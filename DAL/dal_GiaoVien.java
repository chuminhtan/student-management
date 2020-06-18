/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.dto_GiaoVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class dal_GiaoVien extends DBConnect{
    
    // HÀM LẤY DANH SÁCH GIÁO VIÊN
    public ArrayList<dto_GiaoVien> layDsGiaoVien(){
        
        ArrayList<dto_GiaoVien> dsGv = new ArrayList<dto_GiaoVien>();
        dto_GiaoVien gv = null;
        
        String sql = "SELECT ma_gv, ten_gv, quoc_tich "
                + "FROM giao_vien";
        
        try{
            PreparedStatement preStmt = conn.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();
            
            while(rs.next()){
                
                gv = new dto_GiaoVien();
                gv.setMaGv(rs.getInt(1));
                gv.setTenGv(rs.getString(2));
                gv.setQuocTich(rs.getString(3));
                
                dsGv.add(gv);
            }
            conn.close();
            return dsGv;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
