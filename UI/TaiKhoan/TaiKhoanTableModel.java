/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.TaiKhoan;

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

    public void setTaiKhoanDTOs(Collection<TaiKhoanDTO> collection) {
        this.nhanVienDTOs.clear();
        this.nhanVienDTOs.addAll(collection);
    }
    
    public TaiKhoanDTO getTaiKhoanDTOAt(int rowSelected) {
        Vector vectorTaiKhoanData = this.getDataVector().get(rowSelected);
        vectorTaiKhoanData.remove(0);
        return new TaiKhoanDTO().fromVector(vectorTaiKhoanData);
    }

    public void UpdataInTable() {
        super.getDataVector().clear();
        for (int rowIndex = 0; rowIndex < this.nhanVienDTOs.size(); rowIndex += 1) {
            TaiKhoanDTO nhanVienDTO = this.nhanVienDTOs.get(rowIndex);
            
            Vector row = nhanVienDTO.toVector();
            row.add(0, rowIndex);
            
            super.addRow(row);
        }
        super.fireTableDataChanged();
    }

    public void UpdataInTable(Collection<TaiKhoanDTO> inputNhanVienDTOs) {
        super.getDataVector().clear();
        ArrayList<TaiKhoanDTO> arraylistInputs = new ArrayList<>(inputNhanVienDTOs);
        for (int rowIndex = 0; rowIndex < arraylistInputs.size(); rowIndex += 1) {
            TaiKhoanDTO nhanVienDTO = arraylistInputs.get(rowIndex);
            
            Vector row = nhanVienDTO.toVector();
            row.add(0, rowIndex);
            
            super.addRow(row);
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
