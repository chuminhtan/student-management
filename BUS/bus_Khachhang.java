package BUS;

import DAL.dal_ChungChi;
import DAL.dal_KhachHang;
import DAL.dal_LichSu;
import DAL.dal_LopHoc;
import DTO.dto_ChungChi;
import DTO.dto_KhachHang;
import DTO.dto_LichSu;
import DTO.dto_Lich;
import java.util.ArrayList;
import java.util.Date;

public class bus_Khachhang {
    
    // LẤY DS KHÁCH HÀNG
    public ArrayList<dto_KhachHang> layDsKhachHang(){
         
         return new dal_KhachHang().layDsKhachHang();
    }
    
    // HÀM LẤY LỊCH SỬ KHÁCH HÀNG
    public ArrayList<dto_LichSu> dsLichSu(int maKh){
        
        ArrayList<dto_LichSu> dsLichSu =  new ArrayList<dto_LichSu>();
        dsLichSu = new dal_LichSu().dsLichSu(maKh);
        
        for(dto_LichSu ls : dsLichSu){
            
            ls.setLop(new dal_LopHoc().layLopHoc(ls.getMaLop()));
        }
        
        return dsLichSu;
    }
    
    // HÀM LẤY DTO CHỨNG CHỈ CHO KHÁCH HÀNG
    public dto_ChungChi layChungChi(int maCc){
        
        return new dal_ChungChi().layChungChi(maCc);
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
    
    // HÀM TÌM KHÁCH HÀNG
    public ArrayList<dto_KhachHang> layDsTimKiem(String text){
        
        return new dal_KhachHang().layDsTimKiem(text);
    }
}
