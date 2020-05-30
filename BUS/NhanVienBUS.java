/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.NhanVienDAL;
import DTO.NhanVienDTO;
import java.util.ArrayList;

public class NhanVienBUS {

    private NhanVienBUS() {
    }
    private static NhanVienBUS instance;

    public static NhanVienBUS getInstance() {
        if (instance == null) {
            instance = new NhanVienBUS();
        }
        return instance;
    }
    
    public ArrayList<NhanVienDTO> getDanhSachNhanVien() {
        ArrayList<NhanVienDTO> nhanVienDTOs = NhanVienDAL.getInstance().getAll();        
        return nhanVienDTOs;
    }
    
    public boolean ThemNhanVien(NhanVienDTO nhanVienDTO) {
        return false;
    }
    
    public boolean XoaNhanVien(NhanVienDTO nhanVienDTO) {
        return false;
    }
    
    public boolean SuaNhanVien(NhanVienDTO nhanVienDTO) {
        return false;
    }
}
