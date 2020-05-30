/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.dto_ChiTiet;
import DTO.dto_LopHoc;
import UI.LopHocUI.ChiTietLopHoc.UI_ChiTietLop;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class dal_ChiTiet extends DBConnect{
    
    public ArrayList<dto_ChiTiet> getDataChiTiet(dto_LopHoc dto_lop){
        
        ArrayList<dto_ChiTiet> list = new ArrayList<dto_ChiTiet>();
        dto_ChiTiet dto_chiTiet = null;
        try{
            String sql = "select khach_hang.ma_kh, khach_hang.ho_ten, khach_hang.gioi_tinh, khach_hang.sdt, kqht.nghe, kqht.noi, kqht.doc, kqht.viet, kqht.dtb " +
                         "from khach_hang, kqht " +
                         "where khach_hang.ma_kh = kqht.ma_kh and kqht.ma_lop = ?";
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, dto_lop.getMaLop());
            ResultSet rs = preStmt.executeQuery();
            
            while(rs.next()){
                dto_chiTiet = new dto_ChiTiet();
                
                dto_chiTiet.setMa(rs.getInt(1));
                dto_chiTiet.setHoTen(rs.getString(2));
                dto_chiTiet.setGioiTinh(rs.getString(3));
                dto_chiTiet.setSdt(rs.getString(4));
                dto_chiTiet.setNghe(rs.getInt(5));
                dto_chiTiet.setNoi(rs.getInt(6));
                dto_chiTiet.setDoc(rs.getInt(7));
                dto_chiTiet.setViet(rs.getInt(8));
                dto_chiTiet.setTb(rs.getInt(9));

                list.add(dto_chiTiet);
            }        
            return list;
            
        }catch(Exception e){
            e.printStackTrace();
            return list;
        }
    }  
    
    public static void main(String[] args){
        ArrayList<dto_ChiTiet> list = new ArrayList<dto_ChiTiet>();
        
        dto_LopHoc lop =  new dto_LopHoc(1);
        list = new dal_ChiTiet().getDataChiTiet(lop);
        
        for(dto_ChiTiet ct : list){
            System.out.println(ct.getMa());
            System.out.println(ct.getHoTen());
            System.out.println(ct.getGioiTinh());
            System.out.println(ct.getSdt());
            System.out.println(ct.getNghe());
            System.out.println(ct.getNoi());
            System.out.println(ct.getDoc());
            System.out.println(ct.getViet());
            System.out.println(ct.getTb());
         
        }
    }
}
