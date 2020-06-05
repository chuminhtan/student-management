/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.TaiKhoanValidateException;
import DAL.TaiKhoanDAL;
import DTO.TaiKhoanDTO;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaiKhoanBUS {

    private TaiKhoanBUS() {
    }
    private static TaiKhoanBUS instance;

    public static TaiKhoanBUS getInstance() {
        if (instance == null) {
            instance = new TaiKhoanBUS();
        }
        return instance;
    }

    public ArrayList<TaiKhoanDTO> getDanhSachNhanVien() {
        ArrayList<TaiKhoanDTO> nhanVienDTOs = TaiKhoanDAL.getInstance().getAll();

        //Just for test
        nhanVienDTOs.add(new TaiKhoanDTO("1", "Chu Min Ton", "0823451262", new java.util.Random().nextInt(3), "TonCuTeez", this.hashPassword("", null)));
        nhanVienDTOs.add(new TaiKhoanDTO("2", "Hai Duy", "0789789789789", new java.util.Random().nextInt(3), "Duy789", this.hashPassword("", null)));
        nhanVienDTOs.add(new TaiKhoanDTO("3", "Nguyen Minh Hy", "0890563456", new java.util.Random().nextInt(3), "HyHy", this.hashPassword("", null)));
        nhanVienDTOs.add(new TaiKhoanDTO("4", "Không Phải Chu Min Ton", "0123456789", new java.util.Random().nextInt(3), "NotTan", this.hashPassword("", null)));

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
        return TaiKhoanDAL.getInstance().them(nhanVienDTO);
    }

    public boolean xoaNhanVien(TaiKhoanDTO nhanVienDTO) throws TaiKhoanValidateException {
        if (nhanVienDTO == null) {
            throw new TaiKhoanValidateException("Tài khoản không tồn tại.");
        }
        nhanVienDTO.validateMA_NV();
        return TaiKhoanDAL.getInstance().xoa(nhanVienDTO);
    }

    public boolean suaNhanVien(TaiKhoanDTO nhanVienDTO, TaiKhoanDTO newNhanVienDTO) throws TaiKhoanValidateException {
        if (nhanVienDTO == null) {
            throw new TaiKhoanValidateException("Tài khoản không tồn tại.");
        }
        nhanVienDTO.validateLOAI();
        nhanVienDTO.validateMAT_KHAU();
        nhanVienDTO.validateSDT();
        nhanVienDTO.validateTEN_DANG_NHAP();
        return TaiKhoanDAL.getInstance().sua(nhanVienDTO, newNhanVienDTO);
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
            Logger.getLogger(TaiKhoanBUS.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
