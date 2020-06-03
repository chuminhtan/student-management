/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.QuanLyNhanVien;

import DTO.NhanVienDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class NhanVienTableModel extends DefaultTableModel {

    private final Vector<NhanVienDTO> nhanVienDTOs = new Vector<>();

    public NhanVienTableModel() {
        super();
    }

    public Vector<NhanVienDTO> getNhanVienDTOs() {
        return nhanVienDTOs;
    }

    public void setNhanVienDTOs(Collection<NhanVienDTO> collection) {
        this.nhanVienDTOs.clear();
        this.nhanVienDTOs.addAll(collection);
    }

    public void AddNhanVienDTO(NhanVienDTO nhanVienDTO) {
        this.nhanVienDTOs.add(nhanVienDTO);
        this.UpdataInTable();
    }

    public void RemoveNhanVienDTO(NhanVienDTO nhanVienDTO) {
        this.nhanVienDTOs.remove(nhanVienDTO);
        this.UpdataInTable();
    }

    public void UpdataInTable() {
        super.getDataVector().clear();
        for (NhanVienDTO nhanVienDTO : this.nhanVienDTOs) {
            super.addRow(nhanVienDTO.toVector());
        }
        super.fireTableDataChanged();
    }

    public void UpdataInTable(Collection<NhanVienDTO> inputNhanVienDTOs) {
        super.getDataVector().clear();
        for (NhanVienDTO inputNhanVienDTO : inputNhanVienDTOs) {
            super.addRow(inputNhanVienDTO.toVector());
        }
        super.fireTableDataChanged();
    }

    public void FilterNhanVienDTO(String keyword) {
        ArrayList<NhanVienDTO> filteredNhanVienDTOs = new ArrayList<>();

        for (NhanVienDTO nhanVienDTO : this.nhanVienDTOs) {
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
