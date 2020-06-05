/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.TaiKhoan;

import UI.CustomComponentModify;
import BUS.bus_TaiKhoan;
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

public final class UI_TaiKhoan extends javax.swing.JPanel {

    private final TaiKhoanTableModel taiKhoanTableModel = new TaiKhoanTableModel();

    public UI_TaiKhoan() {
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

        //this.buttonStopSearch.setBorder(new CustomCompoundBorder(1, 10));
        //CustomComponentModify.getInstance().modifyButtonColor(this.buttonStopSearch, new Color(239, 158, 154), CustomComponentModify.LIGHT, CustomComponentModify.DARK, CustomComponentModify.LIGHT, new Color(239, 158, 154), CustomComponentModify.DARK);

        //this.textfieldTuKhoa.setBorder(new CustomCompoundBorder(new CustomBorder(1, 0), 10));

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
        //this.buttonStopSearch.setVisible(false);

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
                   // buttonStopSearch.setVisible(false);
                    taiKhoanTableModel.UpdataInTable();
                } else {
                   // buttonStopSearch.setVisible(true);
                    taiKhoanTableModel.FilterNhanVienDTO(keyword);
                }
            }
        });
    }

    public TaiKhoanTableModel getNhanVienTableModel() {
        return taiKhoanTableModel;
    }

    public void refreshDataInTable() {
        this.taiKhoanTableModel.setTaiKhoanDTOs(bus_TaiKhoan.getInstance().getDanhSachNhanVien());
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tableNhanVien = new javax.swing.JTable();
        buttonXoa = new javax.swing.JButton();
        labelTimKiem = new javax.swing.JLabel();
        textfieldTuKhoa = new javax.swing.JTextField();
        buttonThem = new javax.swing.JButton();
        buttonSua = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 585));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tableNhanVien.setAutoCreateRowSorter(true);
        tableNhanVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        tableNhanVien.setPreferredSize(new java.awt.Dimension(600, 450));
        tableNhanVien.setRowHeight(30);
        jScrollPane2.setViewportView(tableNhanVien);

        buttonXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xoa.png"))); // NOI18N
        buttonXoa.setText("XÓA");
        buttonXoa.setToolTipText("");
        buttonXoa.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXoaActionPerformed(evt);
            }
        });

        labelTimKiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTimKiem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTimKiem.setText("TÌM LỚP HỌC");
        labelTimKiem.setToolTipText("");

        textfieldTuKhoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textfieldTuKhoa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textfieldTuKhoa.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(109, 109, 109)));

        buttonThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/themmmm.png"))); // NOI18N
        buttonThem.setText("THÊM TÀI KHOẢN MỚI");
        buttonThem.setToolTipText("");
        buttonThem.setPreferredSize(new java.awt.Dimension(200, 40));
        buttonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThemActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(labelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(textfieldTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonSua, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(buttonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textfieldTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

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
                    deleteResult = bus_TaiKhoan.getInstance().xoaNhanVien(deletedNhanVienDTO);
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
    private javax.swing.JButton buttonSua;
    private javax.swing.JButton buttonThem;
    private javax.swing.JButton buttonXoa;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelTimKiem;
    private javax.swing.JTable tableNhanVien;
    private javax.swing.JTextField textfieldTuKhoa;
    // End of variables declaration//GEN-END:variables
}
