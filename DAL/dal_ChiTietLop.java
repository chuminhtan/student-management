/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.dto_ChiTiet_TT;
import DTO.dto_ChiTiet_KH;
import DTO.dto_KhachHang;
import DTO.dto_LopHoc;
import UI.LopHocUI.ChiTietLopHoc.UI_ChiTietLop;
//import java.util.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class dal_ChiTietLop extends DBConnect{
    
    // Hàm lấy danh sách khách hàng trong 1 lớp
    public ArrayList<dto_ChiTiet_KH> getDataChiTiet(dto_LopHoc dto_lop){
        
        ArrayList<dto_ChiTiet_KH> list = new ArrayList<dto_ChiTiet_KH>();
        dto_ChiTiet_KH dto_chiTiet = null;
        try{
            String sql = "select khach_hang.ma_kh, khach_hang.ho_ten, khach_hang.gioi_tinh, khach_hang.sdt, kqht.nghe, kqht.noi, kqht.doc, kqht.viet, kqht.dtb " +
                         "from khach_hang, kqht " +
                         "where khach_hang.ma_kh = kqht.ma_kh and kqht.ma_lop = ?";
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, dto_lop.getMaLop());
            ResultSet rs = preStmt.executeQuery();
            
            while(rs.next()){
                dto_chiTiet = new dto_ChiTiet_KH();
                
                dto_chiTiet.setMa(rs.getInt(1));
                dto_chiTiet.setHoTen(rs.getString(2));
                dto_chiTiet.setGioiTinh(rs.getString(3));
                dto_chiTiet.setSdt(rs.getString(4));
                dto_chiTiet.setNghe(rs.getInt(5));
                dto_chiTiet.setNoi(rs.getInt(6));
                dto_chiTiet.setDoc(rs.getInt(7));
                dto_chiTiet.setViet(rs.getInt(8));
                dto_chiTiet.setTb(rs.getInt(9));

                list.add(dto_chiTiet);
            }        
            return list;
            
        }catch(Exception e){
            e.printStackTrace();
            return list;
        }
    }  
    
    // Hàm lấy thông tin chi tiết của 1 lớp
    public dto_ChiTiet_TT getDataLop(dto_LopHoc dto_lop){
        
        dto_ChiTiet_TT thongTinLop = null;
        try{
            String sql = "select lop.ma_lop, lop.ma_ct, lop.ma_nv, lop.ten_lop, to_date(lop.ngay_bd, 'dd/mm/yyyy'), to_date(lop.ngay_kt, 'dd/mm/yyyy'), lop.sl, lop.gv, lop.phong, lop.trang_thai, chuong_trinh.ten_ct "
                    + "from lop, chuong_trinh where lop.ma_ct = chuong_trinh.ma_ct and ma_lop=?";
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
           
            preStmt.setInt(1, dto_lop.getMaLop());
            
            ResultSet rs = preStmt.executeQuery();
            rs.next();
            
            thongTinLop = new dto_ChiTiet_TT();
            
            thongTinLop.setMaLop(rs.getInt(1));
            thongTinLop.setMaCT(rs.getInt(2));
            thongTinLop.setMaNV(rs.getInt(3));
            thongTinLop.setTenLop(rs.getString(4));
            thongTinLop.setNgayBD(rs.getDate(5));
            thongTinLop.setNgayKT(rs.getDate(6));
            thongTinLop.setSoLuong(rs.getString(7));
            thongTinLop.setGiaoVien(rs.getString(8));
            thongTinLop.setPhong(rs.getString(9));
            thongTinLop.setTrangThai(rs.getInt(10));
            thongTinLop.setTenCt(rs.getString(11));
            
            return thongTinLop;
            
        }catch(Exception e){
            e.printStackTrace();
            return thongTinLop;
        }
        
    }
    
    // Hàm tìm khách hàng dựa vào kí tự nhập
    public ArrayList<dto_KhachHang> timKH(String tt){
        tt = tt.toLowerCase();
        
        ArrayList<dto_KhachHang> listKh = new ArrayList<dto_KhachHang>();
        dto_KhachHang kh = null;
        
        try{
            String sql = "select * from khach_hang where "
                    + "lower(ho_ten) like N'%" + tt + "%' "
                    + "or lower(ma_kh) like N'" + tt + "%' "
                    + "or sdt like N'" + tt + "%' "
                    + "order by trang_thai";
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();
            
            while(rs.next()){
                kh = new dto_KhachHang();
                
                kh.setMaKH(rs.getInt(1));
                kh.setHoTen(rs.getString(2));
                kh.setNgaySinh(rs.getDate(3));
                kh.setGioiTinh(rs.getString(4));
                kh.setDiaChi(rs.getString(5));
                kh.setSdt(rs.getString(6));
                kh.setDiemDauVao(rs.getInt(7));
                kh.setTrangThai(rs.getInt(8));
                
                listKh.add(kh);
            }
            
            return listKh;
            
        }catch(Exception e){
            
            e.printStackTrace();
            return listKh;
        }
    }
    
    // Hàm thêm 1 khách hàng vào 1 lớp - lưu thông tin vào bảng KQHT
    public int themKhVaoLop(dto_KhachHang kh, dto_LopHoc lop){
        
        int rs = 0;
        try{
            String sql = "insert into kqht " +
                         "values (? , ?, 0, 0, 0, 0, 0)";
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, kh.getMaKH());
            preStmt.setInt(2, lop.getMaLop());
            
            rs = preStmt.executeUpdate();
            return rs;
            
        }catch(Exception e){
            
            e.printStackTrace();
            return rs;
        }
    }
    public static void main(String[] args){
        /*
        ArrayList<dto_ChiTiet> list = new ArrayList<dto_ChiTiet>();
        
        dto_LopHoc lop =  new dto_LopHoc(1);
        list = new dal_ChiTietLop().getDataChiTiet(lop);
        
        for(dto_ChiTiet_KH ct : list){
            System.out.println(ct.getMa());
            System.out.println(ct.getHoTen());
            System.out.println(ct.getGioiTinh());
            System.out.println(ct.getSdt());
            System.out.println(ct.getNghe());
            System.out.println(ct.getNoi());
            System.out.println(ct.getDoc());
            System.out.println(ct.getViet());
            System.out.println(ct.getTb());
         */
        /*
        dto_ChiTiet_TT lop = new dal_ChiTietLop().getDataLop(new dto_LopHoc(1));
        
        System.out.println(lop.getMaLop());
        System.out.println(lop.getTenLop());
        System.out.println(lop.getNgayBD());
        System.out.println(lop.getNgayKT());
        System.out.println(lop.getTenCt());
        */
        
        /*
        ArrayList<dto_KhachHang> list = new ArrayList<dto_KhachHang>();
        
        list = new dal_ChiTietLop().timKH("N");
        
        for(dto_KhachHang kh : list){
            System.out.println(kh.getMaKH());
            System.out.println(kh.getHoTen());
            System.out.println(kh.getTrangThai());
        }
            */
        
        int rs = new dal_ChiTietLop().themKhVaoLop(new dto_KhachHang(6), new dto_LopHoc(1));
        System.out.println(rs);
        }

}

