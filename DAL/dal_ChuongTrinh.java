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
import java.sql.Types;

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
            sql = "SELECT ma_ct, ten_ct, ten_chung_chi, chuong_trinh.diem_dau_vao, chuong_trinh.diem_dau_ra, chuong_trinh.noi_dung, chuong_trinh.trang_thai "
                    + "FROM chuong_trinh, chung_chi "
                    + "WHERE chuong_trinh.ma_chung_chi = chung_chi.ma_chung_chi AND chuong_trinh.trang_thai = 1";
        }
        else{
            sql = "SELECT ma_ct, ten_ct, ten_chung_chi, chuong_trinh.diem_dau_vao, chuong_trinh.diem_dau_ra,  chuong_trinh.noi_dung, chuong_trinh.trang_thai "
                    + "FROM chuong_trinh, chung_chi "
                    + "WHERE chuong_trinh.ma_chung_chi = chung_chi.ma_chung_chi "
                    + "ORDER BY trang_thai DESC";
        }
        try{
                    PreparedStatement preStmt = conn.prepareStatement(sql);
                    ResultSet rs = preStmt.executeQuery();
                    
                    while(rs.next()){
                        
                        ct = new dto_ChuongTrinh();
                        
                        ct.setMaCt(rs.getInt(1));
                        ct.setTenCt(rs.getString(2));
                        ct.setTenCc(rs.getString(3));
                        ct.setDiemDauVao(rs.getFloat(4));
                        ct.setDiemDauRa(rs.getFloat(5));
                        ct.setNoiDung(rs.getString(6));
                        ct.setTrangThai(rs.getInt(7));
                        
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
            String sql = "SELECT ma_ct, ten_ct, chung_chi.ten_chung_chi, chuong_trinh.diem_dau_vao, chuong_trinh.diem_dau_ra, chuong_trinh.noi_dung, chuong_trinh.trang_thai "
                    + "FROM chuong_trinh JOIN chung_chi ON chuong_trinh.ma_chung_chi = chung_chi.ma_chung_chi "
                    + "WHERE LOWER(chuong_trinh.ten_ct) like N'%" + txt + "%' "
                    + "OR LOWER(chuong_trinh.ma_ct) like N'" + txt + "%'";
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();

            while (rs.next()) {
                ct = new dto_ChuongTrinh();

                        ct.setMaCt(rs.getInt(1));
                        ct.setTenCt(rs.getString(2));
                        ct.setTenCc(rs.getString(3));
                        ct.setDiemDauVao(rs.getFloat(4));
                        ct.setDiemDauRa(rs.getFloat(5));
                        ct.setNoiDung(rs.getString(6));
                        ct.setTrangThai(rs.getInt(7));

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
