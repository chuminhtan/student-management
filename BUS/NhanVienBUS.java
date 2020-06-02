/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.NhanVienDAL;
import DTO.NhanVienDTO;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public boolean themNhanVien(NhanVienDTO nhanVienDTO) {
        return false;
    }

    public boolean xoaNhanVien(NhanVienDTO nhanVienDTO) {
        return false;
    }

    public boolean suaNhanVien(NhanVienDTO nhanVienDTO) {
        return false;
    }

    public String hashPassword(String input, String hashMenthod) {
        if (hashMenthod == null) {
            hashMenthod = "MD5";
        }
        
        try {
            //Hash ra mảng các byte dữ liệu
            byte[] messageDigest = MessageDigest.getInstance(hashMenthod).digest(input.getBytes());
            
            //Convert mảng byte thành string
            BigInteger signumResult = new BigInteger(1, messageDigest);
            String hashtext = signumResult.toString(16);
            
            //Thêm số 0 vào đầu cho đủ 32bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            
            return hashtext;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(NhanVienBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
