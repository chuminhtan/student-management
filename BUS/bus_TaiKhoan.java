/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.TaiKhoanValidateException;
import DAL.dal_TaiKhoan;
import DTO.TaiKhoanDTO;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class bus_TaiKhoan {

    private bus_TaiKhoan() {
    }
    private static bus_TaiKhoan instance;

    public static bus_TaiKhoan getInstance() {
        if (instance == null) {
            instance = new bus_TaiKhoan();
        }
        return instance;
    }

    public ArrayList<TaiKhoanDTO> getDanhSachNhanVien() {
        ArrayList<TaiKhoanDTO> nhanVienDTOs = dal_TaiKhoan.getInstance().getAll();
        
        return nhanVienDTOs;
    }

    public boolean themNhanVien(TaiKhoanDTO nhanVienDTO) throws TaiKhoanValidateException {
        if (nhanVienDTO == null) {
            throw new TaiKhoanValidateException("Tài khoản không tồn tại.");
        }
        nhanVienDTO.validateLOAI();
        nhanVienDTO.validateMAT_KHAU();
        nhanVienDTO.validateSDT();
        nhanVienDTO.validateTEN_DANG_NHAP();
        return dal_TaiKhoan.getInstance().them(nhanVienDTO);
    }

    public boolean xoaNhanVien(TaiKhoanDTO nhanVienDTO) throws TaiKhoanValidateException {
        if (nhanVienDTO == null) {
            throw new TaiKhoanValidateException("Tài khoản không tồn tại.");
        }
        nhanVienDTO.validateMA_NV();
        return dal_TaiKhoan.getInstance().xoa(nhanVienDTO);
    }

    public boolean suaNhanVien(TaiKhoanDTO nhanVienDTO, TaiKhoanDTO newNhanVienDTO) throws TaiKhoanValidateException {
        if (nhanVienDTO == null) {
            throw new TaiKhoanValidateException("Tài khoản không tồn tại.");
        }
        nhanVienDTO.validateLOAI();
        nhanVienDTO.validateMAT_KHAU();
        nhanVienDTO.validateSDT();
        nhanVienDTO.validateTEN_DANG_NHAP();
        return dal_TaiKhoan.getInstance().sua(nhanVienDTO, newNhanVienDTO);
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
            Logger.getLogger(bus_TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
