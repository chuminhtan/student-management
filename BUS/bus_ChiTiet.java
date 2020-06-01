/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.dal_ChiTietLop;
import DTO.dto_ChiTiet_KH;
import DTO.dto_ChiTiet_TT;
import DTO.dto_LopHoc;
import UI.LopHocUI.ChiTietLopHoc.UI_ChiTietLop;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class bus_ChiTiet {
    public void getListChiTietLop(dto_LopHoc dto_lop){
        ArrayList<dto_ChiTiet_KH> list = new ArrayList<dto_ChiTiet_KH>();
        dal_ChiTietLop dal_ct = new dal_ChiTietLop();
        list = dal_ct.getDataChiTiet(dto_lop);
        UI_ChiTietLop.reloadTable(list);
   
    }
    
    public dto_ChiTiet_TT getLopHoc(dto_LopHoc dto_lop){
        return new dal_ChiTietLop().getDataLop(dto_lop);
    }
    
    public void loadTable(){
        
    }
}
