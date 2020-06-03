/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVienDAL {

    private NhanVienDAL() {
    }
    private static NhanVienDAL instance;

    public static NhanVienDAL getInstance() {
        if (instance == null) {
            instance = new NhanVienDAL();
        }
        return instance;
    }

    public ArrayList<NhanVienDTO> getAll() {
        ArrayList<NhanVienDTO> nhanVienDTOs = new ArrayList<>();

        try {
            Connection connection = DatabaseConnection.getInstance().CreateNewConnection();
            String query = "";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVienDTO nhanVienDTO = new NhanVienDTO(
                        resultSet.getString("MA_NV"),
                        resultSet.getString("HO_TEN"),
                        resultSet.getString("SDT"),
                        resultSet.getInt("LOAI"),
                        resultSet.getString("TEN_DANG_NHAP"),
                        resultSet.getString("MAT_KHAU")
                );

                nhanVienDTOs.add(nhanVienDTO);
            }

            DatabaseConnection.getInstance().RemoveConnection(connection);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }

        //test
        for (int i = 0; i < 100; i++) {
            NhanVienDTO nhanVienDTO = new NhanVienDTO(
                    "NV" + i, "Nhân viên " + i, "2347856348756", i % 3, "" + i, NhanVienBUS.getInstance().hashPassword("" + i, null)
            );
            nhanVienDTOs.add(nhanVienDTO);
        }

        return nhanVienDTOs;
    }

    public boolean them(NhanVienDTO nhanVienDTO) {
        return false;
    }

    public boolean xoa(NhanVienDTO nhanVienDTO) {
        return false;
    }

    public boolean sua(NhanVienDTO nhanVienDTO, NhanVienDTO newNhanVienDTO) {
        return false;
    }
}
