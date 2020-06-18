/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.dto_Phong;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class dal_Phong extends DBConnect{
    
    // HÀM LẤY DS PHÒNG
    public ArrayList<dto_Phong> layDsPhong(){
        
        ArrayList<dto_Phong> dsPhong = new ArrayList<dto_Phong>();
        dto_Phong phong = null;
        
        String sql = "SELECT ma_phong, ten_phong "
                + "FROM phong";
        
        try{
            PreparedStatement preStmt = conn.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();
            
            while(rs.next()){
                
                phong = new dto_Phong();
                phong.setMaPhong(rs.getInt(1));
                phong.setTenPhong(rs.getString(2));
                
                dsPhong.add(phong);
            }
            
            conn.close();
            return dsPhong;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
