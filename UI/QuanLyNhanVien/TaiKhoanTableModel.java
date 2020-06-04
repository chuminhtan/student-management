/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.QuanLyNhanVien;

import DTO.TaiKhoanDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TaiKhoanTableModel extends DefaultTableModel {

    private final Vector<TaiKhoanDTO> nhanVienDTOs = new Vector<>();

    public TaiKhoanTableModel() {
        super();
    }

    public Vector<TaiKhoanDTO> getNhanVienDTOs() {
        return nhanVienDTOs;
    }

    public void setNhanVienDTOs(Collection<TaiKhoanDTO> collection) {
        this.nhanVienDTOs.clear();
        this.nhanVienDTOs.addAll(collection);
    }

    public void AddNhanVienDTO(TaiKhoanDTO nhanVienDTO) {
        this.nhanVienDTOs.add(nhanVienDTO);
        this.UpdataInTable();
    }

    public void RemoveNhanVienDTO(TaiKhoanDTO nhanVienDTO) {
        this.nhanVienDTOs.remove(nhanVienDTO);
        this.UpdataInTable();
    }

    public void UpdataInTable() {
        super.getDataVector().clear();
        for (TaiKhoanDTO nhanVienDTO : this.nhanVienDTOs) {
            super.addRow(nhanVienDTO.toVector());
        }
        super.fireTableDataChanged();
    }

    public void UpdataInTable(Collection<TaiKhoanDTO> inputNhanVienDTOs) {
        super.getDataVector().clear();
        for (TaiKhoanDTO inputNhanVienDTO : inputNhanVienDTOs) {
            super.addRow(inputNhanVienDTO.toVector());
        }
        super.fireTableDataChanged();
    }

    public void FilterNhanVienDTO(String keyword) {
        ArrayList<TaiKhoanDTO> filteredNhanVienDTOs = new ArrayList<>();

        for (TaiKhoanDTO nhanVienDTO : this.nhanVienDTOs) {
            if (nhanVienDTO.getHO_TEN().contains(keyword)
                    || nhanVienDTO.getLOAIToString().contains(keyword)
                    || nhanVienDTO.getMAT_KHAU().contains(keyword)
                    || nhanVienDTO.getMA_NV().contains(keyword)
                    || nhanVienDTO.getSDT().contains(keyword)
                    || nhanVienDTO.getTEN_DANG_NHAP().contains(keyword)) {
                filteredNhanVienDTOs.add(nhanVienDTO);
            }
        }

        this.UpdataInTable(filteredNhanVienDTOs);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
