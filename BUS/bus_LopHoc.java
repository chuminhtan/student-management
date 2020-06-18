/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.dal_ChuongTrinh;
import DAL.dal_GiaoVien;
import DAL.dal_Lich;
import DAL.dal_LopHoc;
import DAL.dal_Phong;
import DTO.dto_ChuongTrinh;
import DTO.dto_GiaoVien;
import DTO.dto_Lich;
import DTO.dto_LopHoc;
import DTO.dto_Phong;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class bus_LopHoc {
    
    // HÀM LẤY DANH SÁCH LỚP HIỂN THỊ LÊN BẢNG
    public ArrayList<dto_LopHoc> layDsLop(boolean chonTatCa){
        
        return new dal_LopHoc().layDsLop(chonTatCa);
    }
    
    // HÀM LẤY DS TÌM KIẾM
    public ArrayList<dto_LopHoc> layDsLopTim(String text){
        
        return new dal_LopHoc().layDsLopTim(text);
    }
    
    // HÀM LẤY DS CHƯƠNG TRÌNH
    public ArrayList<dto_ChuongTrinh> layDsChuongTrinh(){
        
        return new dal_ChuongTrinh().layDsChuongTrinh(false);
    }
    
    // HÀM LẤY DS GIÁO VIÊN
    public ArrayList<dto_GiaoVien> layDsGiaoVien(){
        
        return new dal_GiaoVien().layDsGiaoVien();
    }
    
    // HÀM LẤY DS PHÒNG
    public ArrayList<dto_Phong> layDsPhong(){
        
        return new dal_Phong().layDsPhong();
    }
    
    // HÀM THÊM LỚP MỚI
    public int themLopHoc(dto_LopHoc lop){
        
        return new dal_LopHoc().themLopHoc(lop);
    }
    
    // HÀM CẬP NHẬT LỚP
    public int capNhatLop(dto_LopHoc lop){
        
        return new dal_LopHoc().capNhatLop(lop);
    }
    
    // HÀM XÓA LỚP
    public int xoaLop(dto_LopHoc lop){
        
        return new dal_LopHoc().xoaLop(lop);
    }
    
    // HÀM LẤY DANH SÁCH LỊCH NGÀY TRONG HỆ THỐNG
    public ArrayList<dto_Lich> layDsLichNgay(){
        
        return new dal_Lich().layDsLichNgay();
    }
    
    // HÀM THÊM DANH SÁCH LỊCH HỌC
    public int themDsLich(ArrayList<dto_Lich> dsLich){
        
        return new dal_Lich().themLichHoc(dsLich);
    }
    
    //  HÀM XÓA LỊCH HỌC
    public int xoaDsLich(int maLop){
        
        return new dal_Lich().xoaDsLich(maLop);
    }
    
    // LẤY DANH SÁCH LỊCH THEO LỚP
    public ArrayList<dto_Lich> layDsLichTheoLop(int maLop){
        
        return new dal_Lich().layDsLichTheoLop(maLop);
    }
}
