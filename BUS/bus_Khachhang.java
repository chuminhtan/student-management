/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.dal_KhachHang;
import DTO.dto_KhachHang;
import DTO.dto_LichSu;
import DTO.dto_Lich;
import DTO.dto_LopHoc;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author USER
 */
public class bus_Khachhang {
    
    
    // LẤY DS KHÁCH HÀNG
    public ArrayList<dto_KhachHang> layDsKhachHang(){
        
        ArrayList<dto_KhachHang> dsKhachHang = new ArrayList<>();
        dsKhachHang = new dal_KhachHang().layDsKhachHang();
        int i = 0;
        // lấy ra từng khách hàng
        for(dto_KhachHang kh : dsKhachHang){
               
            //lấy ra danh sách lịch sử của khách hàng đó
            ArrayList<dto_LichSu> dsLichSu = new ArrayList<>();
            dsLichSu = kh.getDsLichSu();
            // lấy ra từng lịch sử trong danh sách
            
            for(dto_LichSu ls : dsLichSu){
                
                // mỗi lịch sử có 1 lớp học - mỗi lớp đi kèm với 1 danh sách lịch học.
                ArrayList<dto_Lich> dsLich = new ArrayList<dto_Lich>();
                dsLich = ls.getLop().getDsLich();
                
                if(dsLich.size() >0){
                    ls.setNgayBatDau(timNgayDau(dsLich));
                    ls.setNgayKetThuc(timNgayCuoi(dsLich));
                }
               
            }
             i++;
        }
        
        return dsKhachHang;
    }
    
    // HÀM TÌM NGÀY ĐẦU TIÊN TRONG DANH SÁCH LỊCH HỌC
    public Date timNgayDau(ArrayList<dto_Lich> dsLich){
        
        Date ngayDau = new Date();
        ngayDau.setYear(dsLich.get(0).getTgBd().getYear());
        ngayDau.setMonth(dsLich.get(0).getTgBd().getMonth());
        ngayDau.setDate(dsLich.get(0).getTgBd().getDate());
        
        int size = dsLich.size();
        
        for(int i = 0; i < size; i++){
            
            for(int j = i + 1 ; j < size; j++){
                
                if(dsLich.get(j).getTgBd().before(ngayDau)){
                    ngayDau.setYear(dsLich.get(j).getTgBd().getYear());  
                    ngayDau.setMonth(dsLich.get(j).getTgBd().getMonth());
                    ngayDau.setDate(dsLich.get(j).getTgBd().getDate());
                    
                }
            }
        }
        
        return ngayDau;
    }
    
    // HÀM TÌM NGÀY CUỐI CÙNG TRONG DANH SÁCH LỊCH HỌC
    public Date timNgayCuoi(ArrayList<dto_Lich> dsLich){
        
        Date ngayCuoi= new Date();
        ngayCuoi.setYear(dsLich.get(0).getTgBd().getYear());
        ngayCuoi.setMonth(dsLich.get(0).getTgBd().getMonth());
        ngayCuoi.setDate(dsLich.get(0).getTgBd().getDate());

        
        int size = dsLich.size();
        
        for(int i = 0; i < size; i++){
            
            for(int j = i +1 ; j < size; j++){
                
                if(dsLich.get(j).getTgBd().after(ngayCuoi)){
                    ngayCuoi.setYear(dsLich.get(j).getTgBd().getYear());
                    ngayCuoi.setMonth(dsLich.get(j).getTgBd().getMonth());
                    ngayCuoi.setDate(dsLich.get(j).getTgBd().getDate());
                }
            }
        }
        
        return ngayCuoi;
    }
    
    // HÀM THÊM KHÁCH HÀNG
    public int themKhachHang(dto_KhachHang kh){
        
        return new dal_KhachHang().themKhachHang(kh);
    }
    
    // HÀM CẬP NHẬT KHÁCH HÀNG
    public int capNhatKhachHang(dto_KhachHang kh){
        
        return new dal_KhachHang().capNhatKhachHang(kh);
    }
    
    // HÀM XÓA KHÁCH HÀNG
    public int xoaKhachHang(dto_KhachHang kh){
        
        return new dal_KhachHang().xoaKhachHang(kh);
    }
}
