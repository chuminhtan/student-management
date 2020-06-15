/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.dal_LopHoc;
import DTO.dto_LopHoc;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HaiDuyhd789
 */
public class bus_LopHoc {
    static ArrayList<dto_LopHoc> listLH;
    DAL.dal_LopHoc LHService = new dal_LopHoc();
    DefaultTableModel model;

    public void hienThiDanhSach(JTable tbl) {
        listLH = new ArrayList<dto_LopHoc>();
        listLH = LHService.layToanBoLopHoc();
        model = (DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        if (listLH != null) {
            for (dto_LopHoc lh : listLH) {
                Vector<Object> vec = new Vector<Object>();
                vec.add(lh.getMaLop());
                vec.add(lh.getMaCT());
                vec.add(lh.getMaNV());
                vec.add(lh.gettenLop());
                vec.add(lh.getngayBD());
                vec.add(lh.getngayKT());
                vec.add(lh.getsoLuong());
                vec.add(lh.getgiaoVien());
                vec.add(lh.getphong());
                vec.add(lh.gettrangThai());
                
                model.addRow(vec);
            }
        }
    }

    public ArrayList<dto_LopHoc> getList() {
        return listLH;
    }

    public boolean themLH(dto_LopHoc lh) {
        return LHService.themLopHoc(lh);
    }

    public boolean xoaLH(String ma) {
        return LHService.xoaLopHoc(ma);
    }

    public boolean capnhatLH(dto_LopHoc lh) {
        return LHService.capNhatLopHoc(lh);
    }
}
