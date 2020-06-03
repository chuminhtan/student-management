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
            connection.setAutoCommit(false);

            String query = "SELECT * FROM NHANVIEN;";
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

            connection.commit();
            DatabaseConnection.getInstance().RemoveConnection(connection);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nhanVienDTOs;
    }

    public boolean them(NhanVienDTO nhanVienDTO) {
        try {
            Connection connection = DatabaseConnection.getInstance().CreateNewConnection();
            connection.setAutoCommit(false);

            String query = "INSERT INTO NHANVIEN (MA_NV,HO_TEN,SDT,LOAI,TEN_DANG_NHAP,MAT_KHAU) VALUES (?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nhanVienDTO.getMA_NV());
            preparedStatement.setString(2, nhanVienDTO.getHO_TEN());
            preparedStatement.setString(3, nhanVienDTO.getSDT());
            preparedStatement.setInt(4, nhanVienDTO.getLOAI());
            preparedStatement.setString(5, nhanVienDTO.getTEN_DANG_NHAP());
            preparedStatement.setString(6, nhanVienDTO.getMAT_KHAU());
            
            int queryResult = preparedStatement.executeUpdate();

            connection.commit();
            DatabaseConnection.getInstance().RemoveConnection(connection);

            return queryResult > 0;
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean xoa(NhanVienDTO nhanVienDTO) {
        try {
            Connection connection = DatabaseConnection.getInstance().CreateNewConnection();
            connection.setAutoCommit(false);

            String query = "DELETE FROM NHANVIEN WHERE NHANVIEN.MA_NV = ?;";
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().CreateNewConnection().prepareStatement(query);
            preparedStatement.setString(1, nhanVienDTO.getMA_NV());
            
            int queryResult = preparedStatement.executeUpdate();

            connection.commit();
            DatabaseConnection.getInstance().RemoveConnection(connection);

            return queryResult > 0;
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean sua(NhanVienDTO nhanVienDTO, NhanVienDTO newNhanVienDTO) {
        try {
            Connection connection = DatabaseConnection.getInstance().CreateNewConnection();
            connection.setAutoCommit(false);

            String query = "UPDATE NHANVIEN SET NHANVIEN.MA_NV= ?, NHANVIEN.HO_TEN= ?, NHANVIEN.SDT= ?, NHANVIEN.LOAI= ?, NHANVIEN.TEN_DANG_NHAP= ?, NHANVIEN.MAT_KHAU= ? WHERE NHANVIEN.MA_NV = ?;";
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().CreateNewConnection().prepareStatement(query);
            preparedStatement.setString(1, newNhanVienDTO.getMA_NV());
            preparedStatement.setString(2, newNhanVienDTO.getHO_TEN());
            preparedStatement.setString(3, newNhanVienDTO.getSDT());
            preparedStatement.setInt(4, newNhanVienDTO.getLOAI());
            preparedStatement.setString(5, newNhanVienDTO.getTEN_DANG_NHAP());
            preparedStatement.setString(6, newNhanVienDTO.getMAT_KHAU());
            preparedStatement.setString(7, nhanVienDTO.getMA_NV());

            int queryResult = preparedStatement.executeUpdate();
            
            connection.commit();
            DatabaseConnection.getInstance().RemoveConnection(connection);

            return queryResult > 0;
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
