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
import java.awt.Font;
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
        
        buttonSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
        buttonThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
        buttonXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
       
        this.buttonSua.setBorder(new CustomBorder(1));
        CustomComponentModify.getInstance().modifyButtonColor(this.buttonSua, CustomComponentModify.TRANSPARENT, new Color(0,0,0),new Color(255,255,255), CustomComponentModify.TRANSPARENT, new Color(0,0,0), CustomComponentModify.DARK);
        
        this.buttonThem.setBorder(new CustomBorder(1));
        CustomComponentModify.getInstance().modifyButtonColor(this.buttonThem, CustomComponentModify.TRANSPARENT, new Color(0,0,0), new Color(0,102,153), CustomComponentModify.TRANSPARENT, new Color(0,0,0), CustomComponentModify.DARK);

        this.buttonXoa.setBorder(new CustomBorder(1));
        CustomComponentModify.getInstance().modifyButtonColor(this.buttonXoa, CustomComponentModify.TRANSPARENT, new Color(0,0,0), new Color(239, 158, 154), CustomComponentModify.TRANSPARENT, new Color(0,0,0), CustomComponentModify.DARK);
       

        this.tableNhanVien.getTableHeader().setForeground(CustomComponentModify.DARK);
        this.tableNhanVien.setSelectionBackground(new Color(0, 0, 0, 100));
        this.tableNhanVien.setModel(this.taiKhoanTableModel);
        this.taiKhoanTableModel.UpdataInTable();
        tableNhanVien.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        tableNhanVien.getTableHeader().setOpaque(false);
        tableNhanVien.getTableHeader().setForeground(new Color(0, 0, 0));

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

        this.tableNhanVien.getColumnModel().getColumn(0).setMaxWidth(50);
        this.tableNhanVien.getColumnModel().getColumn(0).setCellRenderer(centerCellRenderer);

        this.tableNhanVien.getColumnModel().getColumn(1).setMaxWidth(100);
        this.tableNhanVien.getColumnModel().getColumn(1).setMinWidth(100);
        this.tableNhanVien.getColumnModel().getColumn(1).setCellRenderer(centerCellRenderer);

        this.tableNhanVien.getColumnModel().getColumn(2).setMaxWidth(200);
        this.tableNhanVien.getColumnModel().getColumn(2).setMinWidth(200);
        this.tableNhanVien.getColumnModel().getColumn(2).setCellRenderer(leftCellRenderer);

        this.tableNhanVien.getColumnModel().getColumn(3).setMaxWidth(150);
        this.tableNhanVien.getColumnModel().getColumn(3).setMinWidth(150);
        this.tableNhanVien.getColumnModel().getColumn(3).setCellRenderer(leftCellRenderer);

        this.tableNhanVien.getColumnModel().getColumn(4).setMinWidth(150);
        this.tableNhanVien.getColumnModel().getColumn(4).setMaxWidth(150);
        this.tableNhanVien.getColumnModel().getColumn(4).setCellRenderer(loaiTaiKhoanCellRenderer);

        this.tableNhanVien.getColumnModel().getColumn(5).setMaxWidth(180);
        this.tableNhanVien.getColumnModel().getColumn(5).setMinWidth(180);
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

        buttonXoa = new javax.swing.JButton();
        labelTimKiem = new javax.swing.JLabel();
        textfieldTuKhoa = new javax.swing.JTextField();
        buttonThem = new javax.swing.JButton();
        buttonSua = new javax.swing.JButton();
        jspKH = new javax.swing.JScrollPane();
        tableNhanVien = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 659));

        buttonXoa.setBackground(new java.awt.Color(255, 255, 255));
        buttonXoa.setForeground(new java.awt.Color(239, 158, 154));
        buttonXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xoa.png"))); // NOI18N
        buttonXoa.setText("XÓA");
        buttonXoa.setToolTipText("");
        buttonXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonXoa.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXoaActionPerformed(evt);
            }
        });

        labelTimKiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTimKiem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTimKiem.setText("TÌM TÀI KHOẢN");
        labelTimKiem.setToolTipText("");

        textfieldTuKhoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textfieldTuKhoa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textfieldTuKhoa.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(109, 109, 109)));

        buttonThem.setBackground(new java.awt.Color(255, 255, 255));
        buttonThem.setForeground(new java.awt.Color(91, 155, 213));
        buttonThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/themmmm.png"))); // NOI18N
        buttonThem.setText("THÊM TÀI KHOẢN MỚI");
        buttonThem.setToolTipText("");
        buttonThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonThem.setPreferredSize(new java.awt.Dimension(200, 40));
        buttonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThemActionPerformed(evt);
            }
        });

        buttonSua.setBackground(new java.awt.Color(255, 255, 255));
        buttonSua.setForeground(new java.awt.Color(239, 158, 154));
        buttonSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cap nhat 1.png"))); // NOI18N
        buttonSua.setText("CẬP NHẬT");
        buttonSua.setToolTipText("");
        buttonSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonSua.setPreferredSize(new java.awt.Dimension(100, 40));
        buttonSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSuaActionPerformed(evt);
            }
        });

        jspKH.setBackground(new java.awt.Color(255, 255, 255));
        jspKH.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jspKH.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jspKH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jspKH.setPreferredSize(new java.awt.Dimension(469, 200));
        jspKH.setViewportView(null);

        tableNhanVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "1", "a", null, null, null, null, null, null},
                {null, "2", "a", null, null, null, null, null, null},
                {null, "3", "a", null, null, null, null, null, null},
                {null, "4", "a", null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã KH", "Họ Tên", "Ngày Sinh", "Giới Tính", "Điện Thoại", "Địa Chỉ", "Trạng Thái", "Điểm Đầu Vào"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableNhanVien.setFocusable(false);
        tableNhanVien.setPreferredSize(new java.awt.Dimension(600, 450));
        tableNhanVien.setRowHeight(30);
        tableNhanVien.setRowMargin(5);
        tableNhanVien.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableNhanVien.setShowGrid(true);
        jspKH.setViewportView(tableNhanVien);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 379, Short.MAX_VALUE)
                        .addComponent(buttonThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonSua, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jspKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(50, 50, 50)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textfieldTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 567, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(jspKH, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(97, Short.MAX_VALUE)))
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
    private javax.swing.JScrollPane jspKH;
    private javax.swing.JLabel labelTimKiem;
    private javax.swing.JTable tableNhanVien;
    private javax.swing.JTextField textfieldTuKhoa;
    // End of variables declaration//GEN-END:variables
}
