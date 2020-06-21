/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.dto_ChuongTrinh;
import DTO.dto_Lich;
import DTO.dto_LopHoc;
import DTO.dto_TaiKhoan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author USER
 */
public class dal_LopHoc extends DBConnect{
    
    
    // HÀM LẤY DÁNH SÁCH LỚP
    public ArrayList<dto_LopHoc> layDsLop(boolean chonTatCa){
        
        ArrayList<dto_LopHoc> dsLop = new ArrayList<dto_LopHoc>();
        
        dto_LopHoc lop = null;
        
        String sql = "";
        
        
        if(chonTatCa == false){
            sql = "SELECT ma_lop, ma_ct, ma_nv, ten_lop, ngay_bd, so_buoi, trang_thai "
                    + "FROM lop "
                    + "WHERE trang_thai = 1";
        }
        else if(chonTatCa == true){
             sql = "SELECT ma_lop, ma_ct, ma_nv, ten_lop, ngay_bd, so_buoi, trang_thai "
                    + "FROM lop "
                     + "ORDER BY trang_thai DESC";           
        }
        
        try{
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();
            
            while(rs.next()){
                
                lop = new dto_LopHoc();     
                lop.setMaLop(rs.getInt(1));
                lop.setMaCt(rs.getInt(2));
                lop.setMaNv(rs.getInt(3));
                lop.setTenLop(rs.getString(4));
                lop.setNgayBd(rs.getDate(5));
                lop.setSoBuoi(rs.getInt(6));
                lop.setTrangThai(rs.getInt(7));
                
                if(lop.getMaLop() > 0)
                    lop.setDsLich(new dal_Lich().layDsLichTheoLop(lop.getMaLop()));
                
                lop.setCt(layChuongTrinh(lop.getMaCt()));
                lop.setTk(layTaiKhoan(lop.getMaNv()));
                lop.setSiSo(laySiSo(lop.getMaLop()));
                dsLop.add(lop);
            }
            conn.close();
            return dsLop;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return dsLop;
        }
    } 
    
    
    // HÀM LẤY SỈ SỐ LỚP
    public int laySiSo(int maLop){
        
        int siSo = 0;
        
        String sql = "SELECT COUNT(ma_kh) "
                + "FROM kqht "
                + "GROUP BY ma_lop "
                + "HAVING ma_lop =?";
        
        try{
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, maLop);
            ResultSet rs = preStmt.executeQuery();
            
            if(!rs.next()){
                
            }
            else{
                siSo = rs.getInt(1);
            }
            
            //conn.close();
            return siSo;
    
        }
        catch(Exception ex){
            ex.printStackTrace();
            return siSo;
        }
    }
    
    // HÀM LẤY CHƯƠNG TRÌNH BẰNG MÃ LỚP
    public dto_ChuongTrinh layChuongTrinh(int ma_ct){
        
        dto_ChuongTrinh ct = null;
        
        String sql = "SELECT ma_chung_chi, ten_ct, diem_dau_vao, diem_dau_ra, noi_dung, trang_thai, tinh_diem_nghe, tinh_diem_noi, tinh_diem_doc, tinh_diem_viet, cach_tinh_diem "
                + "FROM chuong_trinh "
                + "WHERE ma_ct =?";
        try{
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, ma_ct);
            ResultSet rs = preStmt.executeQuery();
            
            if(rs.next()){
                ct = new dto_ChuongTrinh();
                ct.setMaCt(ma_ct);
                ct.setMaCc(rs.getInt(1));
                ct.setTenCt(rs.getString(2));
                ct.setDiemDauVao(rs.getFloat(3));
                ct.setDiemDauRa(rs.getFloat(4));
                ct.setNoiDung(rs.getString(5));
                ct.setTrangThai(rs.getInt(6));
                ct.setTinhNghe(rs.getInt(7));
                ct.setTinhNoi(rs.getInt(8));
                ct.setTinhDoc(rs.getInt(9));
                ct.setTinhViet(rs.getInt(10));
                ct.setCachTinhDiem(rs.getInt(11));
            }
           //conn.close();
           return ct;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    // HÀM LẤY TÀI KHOẢN BẰNG MÃ LỚP
    public dto_TaiKhoan layTaiKhoan(int ma_tk){
        
        dto_TaiKhoan tk = null;
        
        String sql = "SELECT ho_ten, sdt, loai, ten_dang_nhap, mat_khau, src_img "
                + "FROM nhan_vien "
                + "WHERE ma_nv = ?";
        
        try{
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, ma_tk);
            ResultSet rs = preStmt.executeQuery();
            
            if(rs.next()){
                tk = new dto_TaiKhoan();
                tk.setMa(ma_tk);
                tk.setHoTen(rs.getString(1));
                tk.setSdt(rs.getString(2));
                tk.setLoai(rs.getInt(3));
                tk.setTenDangNhap(rs.getString(4));
                tk.setMatKhau(rs.getString(5));
                tk.setSrcImg(rs.getString(6));
            }
            //conn.close();
            return tk;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        
    }
    
    // HÀM TÌM LỚP THEO KÝ TỰ NHẬP VÀO
    public ArrayList<dto_LopHoc> layDsLopTim(String text){
        
        text = text.toLowerCase();
        
        ArrayList<dto_LopHoc> dsLop = new ArrayList<dto_LopHoc>();
        dto_LopHoc lop = null;
        
        String sql = "SELECT ma_lop, ma_ct, ma_nv, ten_lop, ngay_bd, so_buoi, trang_thai "
                + "FROM lop "
                + "WHERE ma_lop LIKE '" + text + "%' "
                + "OR ma_ct LIKE '" + text + "%' "
                + "OR ma_nv LIKE '" + text + "%' "
                + "OR LOWER(ten_lop) LIKE N'%" + text +"%'";
        
        try{
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();
            
            while(rs.next()){
                lop = new dto_LopHoc();
                lop.setMaLop(rs.getInt(1));
                lop.setMaCt(rs.getInt(2));
                lop.setMaNv(rs.getInt(3));
                lop.setTenLop(rs.getString(4));
                lop.setNgayBd(rs.getDate(5));
                lop.setSoBuoi(rs.getInt(6));
                lop.setTrangThai(rs.getInt(7));
                
                lop.setDsLich(new dal_Lich().layDsLichTheoLop(lop.getMaLop()));
                lop.setCt(layChuongTrinh(lop.getMaCt()));
                lop.setTk(layTaiKhoan(lop.getMaNv()));
                lop.setSiSo(laySiSo(lop.getMaLop()));
                dsLop.add(lop);
            }
            conn.close();
            return dsLop;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }   
    }
    
    
    // HÀM THÊM LỚP HỌC
    public int themLopHoc(dto_LopHoc lop){
        
        String sql = "INSERT INTO lop (ma_lop, ma_ct, ma_nv, ten_lop, ngay_bd, so_buoi, trang_thai) "
                + "VALUES (lop_sequence.NEXTVAL,?,?,?, to_date(?, 'dd-mm-yyyy hh24:mi:ss'),?,?)";
        
        try{
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, lop.getMaCt());
            preStmt.setInt(2, lop.getMaNv());
            preStmt.setString(3, lop.getTenLop());
            preStmt.setString(4, lop.layNgayBd());
            preStmt.setInt(5, lop.getSoBuoi());
            preStmt.setInt(6, lop.getTrangThai());
            
            int rs = preStmt.executeUpdate();
            conn.close();
            return rs;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return 0;
        }
    }
    
    // HÀM CẬP NHẬT LỚP HỌC
    public int capNhatLop(dto_LopHoc lop){
        
        String sql = "UPDATE lop "
                + "SET ten_lop =?,"
                + "ma_ct=?,"
                + "ngay_bd =to_date(?, 'dd-mm-yyyy'),"
                + "so_buoi =?,"
                + "trang_thai =? "
                + "WHERE ma_lop =?";
        
        try{
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, lop.getTenLop());
            preStmt.setInt(2, lop.getMaCt());
            preStmt.setString(3, lop.layNgayBd());
            preStmt.setInt(4, lop.getSoBuoi());
            preStmt.setInt(5, lop.getTrangThai());
            preStmt.setInt(6, lop.getMaLop());
            
            int rs = preStmt.executeUpdate();
            
            conn.close();
            return rs;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return 0;
        }
    }
    
    // XÓA LỚP
    public int xoaLop(dto_LopHoc lop){
        
        String sql = "DELETE FROM lop WHERE ma_lop=" + lop.getMaLop();
        
        try{
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            int rs = preStmt.executeUpdate();
            conn.close();
            return rs;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return 0;
        }
    }
    
    // HÀM LẤY THÔNG TIN LỚP BẰNG MÃ LỚP
    public dto_LopHoc layLopHoc(int maLop){
        
        dto_LopHoc lop = null;
        
        String sql = "SELECT ma_lop, ma_ct, ma_nv, ten_lop, ngay_bd, so_buoi, trang_thai "
                + "FROM lop "
                + "WHERE ma_lop=" + maLop;
        
        try{
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();
            
            if(rs.next()){
                
                lop = new dto_LopHoc();
                lop.setMaLop(rs.getInt(1));
                lop.setMaCt(rs.getInt(2));
                lop.setMaNv(rs.getInt(3));
                lop.setTenLop(rs.getString(4));
                lop.setNgayBd(rs.getDate(5));
                lop.setSoBuoi(rs.getInt(6));
                lop.setTrangThai(rs.getInt(7));
                
                lop.setDsLich(new dal_Lich().layDsLichTheoLop(maLop));
            }
            
            return lop;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    //main
    public static void main(String[] args){

        dto_LopHoc lop = new dto_LopHoc();
        lop.setMaLop(2321);
        lop.setMaCt(160);
        lop.setMaNv(5503);
        lop.setTenLop("Hí hí hí");
        lop.setSoBuoi(50);
        lop.setTrangThai(1);
        
        
        Date d = new Date();
        lop.setNgayBd(d);
        
        int rs = new dal_LopHoc().capNhatLop(lop);
        
        System.out.println(rs);
        
    }
}
