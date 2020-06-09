/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.dal_ChuongTrinh;
import DTO.dto_ChuongTrinh;
import UI.ChuongTrinhUI.UI_ChuongTrinh;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class bus_ChuongTrinh {
    
    // HÀM LÂY GIÁ TRỊ HIỂN THỊ LÊN BẢNG.
    public void layDsChuongTrinh(int trangThai){
        
        ArrayList<dto_ChuongTrinh> dsChuongTrinh = new dal_ChuongTrinh().layDsChuongTrinh(trangThai);
        
        UI_ChuongTrinh.reloadTable(dsChuongTrinh);
    }
    
    // HÀM LẤY DANH SÁCH TÌM KIẾM HIỂN THỊ LÊN BẢNG
    public void layDsTimKiem(String text){
        ArrayList<dto_ChuongTrinh> dsChuongTrinh = new dal_ChuongTrinh().timChuongTrinh(text);
        UI_ChuongTrinh.reloadTable(dsChuongTrinh);    
    }
}
