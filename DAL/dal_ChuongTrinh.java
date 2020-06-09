/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.dto_ChuongTrinh;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class dal_ChuongTrinh extends DBConnect{
    
    // HÀM LẤY DỮ LIỆU TRONG BẢNG CHUONGTRINH CÓ THAM SỐ
    public ArrayList<dto_ChuongTrinh> layDsChuongTrinh(int trangThai){
        
        ArrayList<dto_ChuongTrinh> dsChuongTrinh = new ArrayList<dto_ChuongTrinh>();
        
        dto_ChuongTrinh ct = null;
        
        String sql="";
        if(trangThai == 0){
            sql = "SELECT ma_ct, ten_ct, diem_dau_vao, cap_do, noi_dung, trang_thai "
                    + "FROM chuong_trinh "
                    + "WHERE trang_thai = 1";
        }
        else{
            sql = "SELECT ma_ct, ten_ct, diem_dau_vao, cap_do, noi_dung, trang_thai "
                    + "FROM chuong_trinh "
                    + "ORDER BY trang_thai DESC";
        }
        try{
                    PreparedStatement preStmt = conn.prepareStatement(sql);
                    ResultSet rs = preStmt.executeQuery();
                    
                    while(rs.next()){
                        
                        ct = new dto_ChuongTrinh();
                        
                        ct.setMaCt(rs.getInt(1));
                        ct.setTenCt(rs.getString(2));
                        ct.setDiemDauVao(rs.getInt(3));
                        ct.setCapDo(rs.getInt(4));
                        ct.setNoiDung(rs.getString(5));
                        ct.setTrangThai(rs.getInt(6));
                        
                        dsChuongTrinh.add(ct);
                    }
                    
                    conn.close();
                    return dsChuongTrinh;
        }
        catch(Exception e){
            e.printStackTrace();
            return dsChuongTrinh;
        }
        
    }
    
    // HÀM TÌM KIẾM CHƯƠNG TRÌNH HỌC
    public ArrayList<dto_ChuongTrinh> timChuongTrinh(String txt) {
        
        txt = txt.toLowerCase();
        ArrayList<dto_ChuongTrinh> dsChuongTrinh = new ArrayList<dto_ChuongTrinh>();
        dto_ChuongTrinh ct = null;
        
        try {
            String sql = "SELECT ma_ct, ten_ct, diem_dau_vao, cap_do, noi_dung, trang_thai "
                    + "FROM chuong_trinh "
                    + "WHERE LOWER(ten_ct) like N'%" + txt + "%' "
                    + "OR LOWER(ma_ct) like N'" + txt + "%'";
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();

            while (rs.next()) {
                ct = new dto_ChuongTrinh();
                
                ct.setMaCt(rs.getInt(1));
                ct.setTenCt(rs.getString(2));
                ct.setDiemDauVao(rs.getInt(3));
                ct.setCapDo(rs.getInt(4));
                ct.setNoiDung(rs.getString(5));
                ct.setTrangThai(rs.getInt(6));
                        
                dsChuongTrinh.add(ct);
            }
            conn.close();
            return dsChuongTrinh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsChuongTrinh;
    }
    
    //MAIN
    public static void main(String[] args){
        ArrayList<dto_ChuongTrinh> dsChuongTrinh = new dal_ChuongTrinh().layDsChuongTrinh(0);
        
        for(dto_ChuongTrinh ct : dsChuongTrinh){
            System.out.println("Ma: " + ct.getMaCt());
            System.out.println("Ten: " + ct.getTenCt());
        }
    }
}
