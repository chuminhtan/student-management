/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.dal_DangNhap;
import DTO.dto_DangNhap;
import UI.UI_Main;

/**
 *
 * Xử lý tương tác giữa UI với DAL 
 */
public class bus_DangNhap {
    
    public boolean xyLyDangNhap(dto_DangNhap dn){
        dto_DangNhap dto_dn = new dto_DangNhap();
        dto_dn = new dal_DangNhap().DangNhap(dn);
        
        if(dto_dn == null)
            return false;
        else{
            UI_Main ui_m = new UI_Main();
            ui_m.setThongTinDangNhap(dto_dn);
            
            if(dto_dn.getLoai() == 2){
                ui_m.showGhiDanh();
            }
            else if(dto_dn.getLoai() == 3){
                ui_m.showHocVu();
            }
            
            ui_m.setVisible(true);           
            return true;
        }
    }
}
