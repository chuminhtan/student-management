/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.LopHocUI.ChiTietLopHoc;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class DtmChiTiet extends DefaultTableModel{
    private DtmChiTiet(){
        super(); // gọi khởi tạo của DefaultTableModel
        taoColumn();
    }
    //tao instance
    private static DtmChiTiet dtmChiTiet = null;
    
    //lấy giá trị dtmCtl
    public static DtmChiTiet getDtmChiTietLop(){
        if(dtmChiTiet == null){
            dtmChiTiet = new DtmChiTiet();
        }
        return dtmChiTiet;
    }
    private void taoColumn(){
        dtmChiTiet.addColumn("STT");
        dtmChiTiet.addColumn("Họ Tên");
        dtmChiTiet.addColumn("Giới Tính");
        dtmChiTiet.addColumn("Điện Thoại");
        dtmChiTiet.addColumn("Nghe");
        dtmChiTiet.addColumn("Nói");
        dtmChiTiet.addColumn("Đọc");
        dtmChiTiet.addColumn("Viết");
        dtmChiTiet.addColumn("TB");
    }
}
