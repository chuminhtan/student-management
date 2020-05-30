/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.dal_ChiTiet;
import DTO.dto_ChiTiet;
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
        ArrayList<dto_ChiTiet> list = new ArrayList<dto_ChiTiet>();
        dal_ChiTiet dal_ct = new dal_ChiTiet();
        list = dal_ct.getDataChiTiet(dto_lop);
        UI_ChiTietLop.reloadTable(list);
   
    }
    
    public void loadTable(){
        
    }
}
