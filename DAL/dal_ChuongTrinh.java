/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.dto_ChungChi;
import DTO.dto_ChuongTrinh;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Types;
import java.util.Vector;

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
    
    
    // HÀM LẤY CHỨNG CHỈ
    public ArrayList<dto_ChungChi>layDsChungChi(){
        
        ArrayList<dto_ChungChi> dsChungChi = new ArrayList<dto_ChungChi>();
        dto_ChungChi cc = null;
        try{
            String sql = "SELECT ma_chung_chi, ten_chung_chi, diem_toi_da, noi_dung "
                    + "FROM chung_chi";
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();
            
            for(int i = 0; rs.next() == true; i++){
                cc = new dto_ChungChi();
                cc.setMaCc(rs.getInt(1));
                cc.setTenCc(rs.getString(2));
                cc.setDiemToiDa(rs.getFloat(3));
                cc.setNoiDung(rs.getString(4));
                
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
   
    // HÀM THÊM CHUONG TRÌNH
    public int themChuongTrinh(dto_ChuongTrinh ct){
        
        try{
            String sql = "INSERT INTO chuong_trinh VALUES (chuong_trinh_sequence.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, ct.getMaCc());
            preStmt.setString(2, ct.getTenCt());
            preStmt.setFloat(3, ct.getDiemDauVao());
            preStmt.setFloat(4, ct.getDiemDauRa());
            preStmt.setString(5, ct.getNoiDung());
            preStmt.setInt(6, ct.getTrangThai());
            preStmt.setInt(7, ct.getTinhNghe());
            preStmt.setInt(8, ct.getTinhNoi());
            preStmt.setInt(9, ct.getTinhDoc());
            preStmt.setInt(10, ct.getTinhViet());
            preStmt.setInt(11, ct.getCachTinhDiem());
            
            int rs = preStmt.executeUpdate();
            
            conn.close();
            return rs;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return 0;
        }
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
