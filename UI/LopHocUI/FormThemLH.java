/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.LopHocUI;

import DTO.dto_LopHoc;
import BUS.bus_LopHoc;
import DTO.dto_DangNhap;
import UI.KhachHangUI.UI_KhachHang;
import UI.UI_Main;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author ThinkPro
 */
public class FormThemLH extends javax.swing.JFrame {
    
    private LopHocCallback lopHocCallback;

    /**
     * Creates new form FormThem
     */
    UI_LopHoc lopHocUI = new UI_LopHoc();
    bus_LopHoc bus = new bus_LopHoc();
    public FormThemLH() {
        initComponents();
    }

    public LopHocCallback getLopHocCallback() {
        return lopHocCallback;
    }

    public void setLopHocCallback(LopHocCallback lopHocCallback) {
        this.lopHocCallback = lopHocCallback;
    }
    
    public void setThongTinDangNhap(dto_DangNhap dn){
        txtThemPH1.setText(dn.getMa());
    }
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnThemLop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnThemTenLop = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtThemGV = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtThemPH = new javax.swing.JTextField();
        btnXacNhanThemLop = new javax.swing.JButton();
        cbThemChuongTrinh = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dateBDLop = new com.toedter.calendar.JDateChooser();
        dateKTLop = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txtThemPH1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tạo Lớp Học Mới");
        setResizable(false);

        pnThemLop.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("NGÀY BẮT ĐẦU");

        btnThemTenLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTenLopActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Mã CHƯƠNG TRÌNH");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("TÊN LỚP");

        txtThemGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThemGVActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("TÊN GIÁO VIÊN");

        btnXacNhanThemLop.setBackground(new java.awt.Color(91, 155, 213));
        btnXacNhanThemLop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXacNhanThemLop.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhanThemLop.setText("XÁC NHẬN");
        btnXacNhanThemLop.setContentAreaFilled(false);
        btnXacNhanThemLop.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnXacNhanThemLop.setFocusable(false);
        btnXacNhanThemLop.setOpaque(true);
        btnXacNhanThemLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanThemLopActionPerformed(evt);
            }
        });

        cbThemChuongTrinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("PHÒNG HỌC");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("NGÀY KẾT THÚC");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("TẠO MỚI");

        txtThemPH1.setEditable(false);
        txtThemPH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThemPH1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnThemLopLayout = new javax.swing.GroupLayout(pnThemLop);
        pnThemLop.setLayout(pnThemLopLayout);
        pnThemLopLayout.setHorizontalGroup(
            pnThemLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThemLopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(224, 224, 224))
            .addGroup(pnThemLopLayout.createSequentialGroup()
                .addGroup(pnThemLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThemLopLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(pnThemLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnThemLopLayout.createSequentialGroup()
                                .addGroup(pnThemLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(pnThemLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThemTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbThemChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnThemLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(dateKTLop, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(dateBDLop, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtThemGV, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtThemPH, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnThemLopLayout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(txtThemPH1))))
                    .addGroup(pnThemLopLayout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(btnXacNhanThemLop)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnThemLopLayout.setVerticalGroup(
            pnThemLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThemLopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(pnThemLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThemLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThemLopLayout.createSequentialGroup()
                        .addComponent(cbThemChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dateBDLop, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnThemLopLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnThemLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThemLopLayout.createSequentialGroup()
                        .addComponent(dateKTLop, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtThemGV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtThemPH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnThemLopLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(txtThemPH1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnXacNhanThemLop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnThemLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnThemLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemTenLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTenLopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemTenLopActionPerformed

    private void btnXacNhanThemLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanThemLopActionPerformed
        String tenLop = btnThemTenLop.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String maCT = (String) cbThemChuongTrinh.getSelectedItem();
        String ngayBD = sdf.format(dateBDLop.getDate());
        String ngayKT = sdf.format(dateKTLop.getDate());
        String giaoVien = txtThemGV.getText();
        String phong = txtThemPH.getText();
        
        BUS.bus_LopHoc busLH = new bus_LopHoc();
        boolean kt = busLH.themLH(new dto_LopHoc(maCT, MaNV, tenLop, ngayBD, ngayKT, "30", giaoVien, phong, "1"));
        if (kt == true) {
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            bus.hienThiDanhSach(lopHocUI.getTableLH());
//            System.out.println("hien thi");
            lopHocUI.showTable();
            
            //
            this.lopHocCallback.Callback();
            
            //Close
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "WRONG");
        }
    }//GEN-LAST:event_btnXacNhanThemLopActionPerformed

    private void txtThemGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThemGVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThemGVActionPerformed

    private void txtThemPH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThemPH1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThemPH1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormThemLH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThemLH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThemLH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThemLH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormThemLH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField btnThemTenLop;
    private javax.swing.JButton btnXacNhanThemLop;
    private javax.swing.JComboBox<String> cbThemChuongTrinh;
    private com.toedter.calendar.JDateChooser dateBDLop;
    private com.toedter.calendar.JDateChooser dateKTLop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnThemLop;
    private javax.swing.JTextField txtThemGV;
    private javax.swing.JTextField txtThemPH;
    private javax.swing.JTextField txtThemPH1;
    // End of variables declaration//GEN-END:variables
}