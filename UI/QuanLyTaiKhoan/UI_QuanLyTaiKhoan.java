/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.QuanLyTaiKhoan;

import BUS.TaiKhoanBUS;
import DTO.TaiKhoanValidateException;
import DTO.TaiKhoanDTO;
import java.awt.Color;
import java.awt.Dialog;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public final class UI_QuanLyTaiKhoan extends javax.swing.JPanel {

    private final TaiKhoanTableModel taiKhoanTableModel = new TaiKhoanTableModel();

    public UI_QuanLyTaiKhoan() {
        this.initComponents();
        this.initializeLookAndFeels();
        this.initializeEvents();

        this.refreshDataInTable();
    }

    public void initializeLookAndFeels() {
        this.buttonSua.setBorder(new CustomBorder(1));
        CustomComponentModify.getInstance().modifyButtonColor(this.buttonSua, new Color(239, 158, 154), CustomComponentModify.LIGHT, CustomComponentModify.DARK, CustomComponentModify.LIGHT, new Color(239, 158, 154), CustomComponentModify.DARK);

        this.buttonThem.setBorder(new CustomBorder(1));
        CustomComponentModify.getInstance().modifyButtonColor(this.buttonThem, new Color(91, 155, 213), CustomComponentModify.LIGHT, CustomComponentModify.DARK, CustomComponentModify.LIGHT, new Color(91, 155, 213), CustomComponentModify.DARK);

        this.buttonXoa.setBorder(new CustomBorder(1));
        CustomComponentModify.getInstance().modifyButtonColor(this.buttonXoa, new Color(239, 158, 154), CustomComponentModify.LIGHT, CustomComponentModify.DARK, CustomComponentModify.LIGHT, new Color(239, 158, 154), CustomComponentModify.DARK);

        this.buttonStopSearch.setBorder(new CustomCompoundBorder(1, 10));
        CustomComponentModify.getInstance().modifyButtonColor(this.buttonStopSearch, new Color(239, 158, 154), CustomComponentModify.LIGHT, CustomComponentModify.DARK, CustomComponentModify.LIGHT, new Color(239, 158, 154), CustomComponentModify.DARK);

        this.textfieldTuKhoa.setBorder(new CustomCompoundBorder(new CustomBorder(1, 0), 10));

        this.tableNhanVien.getTableHeader().setForeground(CustomComponentModify.DARK);
        this.tableNhanVien.setSelectionBackground(new Color(0, 0, 0, 100));
        this.tableNhanVien.setModel(this.taiKhoanTableModel);
        this.taiKhoanTableModel.UpdataInTable();

        DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();
        centerCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        centerCellRenderer.setVerticalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer leftCellRenderer = new DefaultTableCellRenderer();
        leftCellRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        leftCellRenderer.setVerticalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer loaiTaiKhoanCellRenderer = new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                if (value != null) {
                    String loai = value.toString();
                    this.setText("1".equals(loai) ? "Ghi danh" : ("2".equals(loai) ? "Học vụ" : "Quản lý"));
                } else {
                    super.setValue(value);
                }
            }
        };
        loaiTaiKhoanCellRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        loaiTaiKhoanCellRenderer.setVerticalAlignment(SwingConstants.CENTER);

        Vector tableTaiKhoanColumnNames = TaiKhoanDTO.getVectorColumnIdentifiers();
        tableTaiKhoanColumnNames.add(0, "STT");
        this.taiKhoanTableModel.setColumnIdentifiers(tableTaiKhoanColumnNames);

        this.tableNhanVien.getColumnModel().getColumn(0).setMaxWidth(30);
        this.tableNhanVien.getColumnModel().getColumn(0).setCellRenderer(centerCellRenderer);

        this.tableNhanVien.getColumnModel().getColumn(1).setMaxWidth(80);
        this.tableNhanVien.getColumnModel().getColumn(1).setMinWidth(50);
        this.tableNhanVien.getColumnModel().getColumn(1).setCellRenderer(centerCellRenderer);

        this.tableNhanVien.getColumnModel().getColumn(2).setMaxWidth(300);
        this.tableNhanVien.getColumnModel().getColumn(2).setMinWidth(200);
        this.tableNhanVien.getColumnModel().getColumn(2).setCellRenderer(leftCellRenderer);

        this.tableNhanVien.getColumnModel().getColumn(3).setMaxWidth(120);
        this.tableNhanVien.getColumnModel().getColumn(3).setMinWidth(100);
        this.tableNhanVien.getColumnModel().getColumn(3).setCellRenderer(leftCellRenderer);

        this.tableNhanVien.getColumnModel().getColumn(4).setMaxWidth(75);
        this.tableNhanVien.getColumnModel().getColumn(4).setCellRenderer(loaiTaiKhoanCellRenderer);

        this.tableNhanVien.getColumnModel().getColumn(5).setMaxWidth(300);
        this.tableNhanVien.getColumnModel().getColumn(5).setMinWidth(200);
        this.tableNhanVien.getColumnModel().getColumn(5).setCellRenderer(leftCellRenderer);

        this.tableNhanVien.getColumnModel().getColumn(6).setCellRenderer(leftCellRenderer);

        //Tính thêm padding,striped cho cell mà lười nên thôi
    }

    public void initializeEvents() {
        this.buttonStopSearch.setVisible(false);

        this.textfieldTuKhoa.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent arg0) {
                ChangeFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                ChangeFilter();
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                ChangeFilter();
            }

            public void ChangeFilter() {
                String keyword = textfieldTuKhoa.getText();
                if (keyword.isEmpty()) {
                    buttonStopSearch.setVisible(false);
                    taiKhoanTableModel.UpdataInTable();
                } else {
                    buttonStopSearch.setVisible(true);
                    taiKhoanTableModel.FilterNhanVienDTO(keyword);
                }
            }
        });
    }

    public TaiKhoanTableModel getNhanVienTableModel() {
        return taiKhoanTableModel;
    }

    public void refreshDataInTable() {
        this.taiKhoanTableModel.setTaiKhoanDTOs(TaiKhoanBUS.getInstance().getDanhSachNhanVien());
        this.taiKhoanTableModel.UpdataInTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        labelTimKiem = new javax.swing.JLabel();
        textfieldTuKhoa = new javax.swing.JTextField();
        buttonStopSearch = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        buttonThem = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        buttonXoa = new javax.swing.JButton();
        buttonSua = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableNhanVien = new javax.swing.JTable();

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setRequestFocusEnabled(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(297, 70));

        labelTimKiem.setText("TÌM KIẾM");
        labelTimKiem.setToolTipText("");

        buttonStopSearch.setText("✕");
        buttonStopSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStopSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(labelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textfieldTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonStopSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfieldTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonStopSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/themmmm.png"))); // NOI18N
        buttonThem.setText("THÊM TÀI KHOẢN MỚI");
        buttonThem.setToolTipText("");
        buttonThem.setPreferredSize(new java.awt.Dimension(200, 40));
        buttonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(425, Short.MAX_VALUE)
                .addComponent(buttonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(70, 58));

        buttonXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xoa.png"))); // NOI18N
        buttonXoa.setText("XÓA");
        buttonXoa.setToolTipText("");
        buttonXoa.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXoaActionPerformed(evt);
            }
        });

        buttonSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cap nhat 1.png"))); // NOI18N
        buttonSua.setText("SỬA");
        buttonSua.setToolTipText("");
        buttonSua.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonSua, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(buttonSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tableNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        tableNhanVien.setForeground(new java.awt.Color(0, 0, 0));
        tableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhân viên", "Họ tên", "Số điện thoại", "Loại", "Tên đăng nhập", "<ật khẩu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableNhanVien);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1073, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonStopSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStopSearchActionPerformed
        this.textfieldTuKhoa.setText("");
        this.taiKhoanTableModel.UpdataInTable();
        this.buttonStopSearch.setVisible(false);
    }//GEN-LAST:event_buttonStopSearchActionPerformed

    private void buttonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThemActionPerformed
        FormThemTaiKhoan formThemTaiKhoan = new FormThemTaiKhoan(SwingUtilities.getWindowAncestor(this), Dialog.ModalityType.DOCUMENT_MODAL);

        formThemTaiKhoan.setAfterThemTaiKhoan(new AfterThemTaiKhoan() {
            @Override
            public void DoAfterThemTaiKhoan() {
                refreshDataInTable();
            }
        });

        formThemTaiKhoan.setLocationRelativeTo(this);
        formThemTaiKhoan.setVisible(true);
    }//GEN-LAST:event_buttonThemActionPerformed

    private void buttonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXoaActionPerformed
        int[] rowSelecteds = this.tableNhanVien.getSelectedRows();

        if (rowSelecteds.length < 1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Hãy chọn ít nhất một tài khoản trước khi nhấn nút",
                    "Thông báo",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        DefaultTableModel defaultTableModel = (DefaultTableModel) this.tableNhanVien.getModel();

        String deletedNhanVienDTOInfos = "";
        ArrayList<TaiKhoanDTO> deletedNhanVienDTOs = new ArrayList<>();
        for (int rowSelected : rowSelecteds) {
            TaiKhoanDTO deletedNhanVienDTO = this.taiKhoanTableModel.getTaiKhoanDTOAt(rowSelected);
            deletedNhanVienDTOs.add(deletedNhanVienDTO);
            deletedNhanVienDTOInfos += deletedNhanVienDTO.toString();
            deletedNhanVienDTOInfos += "\n";
        }

        int deleteChooseResult = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc chắn muốn xoá " + rowSelecteds.length + " tài khoản không? "
                + "\n"
                + "Thông tin" + (rowSelecteds.length > 1 ? " các" : "") + " tài khoản đó là: "
                + "\n"
                + deletedNhanVienDTOInfos,
                "Xóa tài khoản",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE
        );

        if (deleteChooseResult == JOptionPane.YES_OPTION) {
            //Xoá ngay và luôn 
            String messageResults = "";
            for (TaiKhoanDTO deletedNhanVienDTO : deletedNhanVienDTOs) {
                boolean deleteResult;
                messageResults += "Xóa tài khoản " + deletedNhanVienDTO.getMA_NV() + " - " + deletedNhanVienDTO.getHO_TEN() + " ";
                try {
                    deleteResult = TaiKhoanBUS.getInstance().xoaNhanVien(deletedNhanVienDTO);
                    messageResults += (deleteResult ? "thành công" : "thất bại");
                } catch (TaiKhoanValidateException ex) {
                    messageResults += "Thất bại do " + ex.getMessage();
                }

                messageResults += "\n";
            }
            JOptionPane.showMessageDialog(this, messageResults, "Kết quả xóa tài khoản", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buttonXoaActionPerformed

    private void buttonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSuaActionPerformed
        int rowSelected = this.tableNhanVien.getSelectedRow();

        if (rowSelected < 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Hãy chọn một tài khoản trước khi nhấn nút",
                    "Thông báo",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        FormSuaTaiKhoan formSuaTaiKhoan = new FormSuaTaiKhoan(SwingUtilities.getWindowAncestor(this), Dialog.ModalityType.DOCUMENT_MODAL);

        TaiKhoanDTO nhanVienDTO = this.taiKhoanTableModel.getTaiKhoanDTOAt(rowSelected);
        formSuaTaiKhoan.setDefaultNhanVienDTO(nhanVienDTO);
        formSuaTaiKhoan.setDefaultInformations(nhanVienDTO);

        formSuaTaiKhoan.setAfterSuaTaiKhoan(new AfterSuaTaiKhoan() {
            @Override
            public void DoAfterSuaTaiKhoan() {
                refreshDataInTable();
            }
        });

        formSuaTaiKhoan.setVisible(true);
    }//GEN-LAST:event_buttonSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonStopSearch;
    private javax.swing.JButton buttonSua;
    private javax.swing.JButton buttonThem;
    private javax.swing.JButton buttonXoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelTimKiem;
    private javax.swing.JTable tableNhanVien;
    private javax.swing.JTextField textfieldTuKhoa;
    // End of variables declaration//GEN-END:variables
}
