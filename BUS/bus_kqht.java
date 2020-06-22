package BUS;

import DAL.dal_KhachHang;
import DAL.dal_kqht;
import DTO.dto_kqht;
import java.util.ArrayList;

public class bus_kqht {
    
    // HÀM LẤY DANH SÁCH KQHT
    public ArrayList<dto_kqht> layDsKqht(int maLop){
        
        return new dal_kqht().layDsKqht(maLop);
    }
    
    // HÀM LẤY ĐỐI TƯỢNG KHÁCH HÀNG BẰNG MÃ KH
    public ArrayList<dto_kqht> layKhachHang(ArrayList<dto_kqht> dsKqht){
        
        int size = dsKqht.size();

        
        for(int i = 0; i < size; i++){
            dsKqht.get(i).setKh(new dal_KhachHang().layKhachHang(dsKqht.get(i).getMaKh()));
        }
        
        return dsKqht;
    }
}
