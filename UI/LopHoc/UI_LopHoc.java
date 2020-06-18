/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.LopHoc;
import BUS.bus_LopHoc;
import DTO.dto_Lich;
import DTO.dto_LopHoc;
import UI.DangNhap.UI_DangNhap;
import UI.FormXacMinhNguoiDung;
import UI.LopHoc.ChiTietLopHoc.UI_ChiTietLop;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ThinkPro
 */
public class UI_LopHoc extends javax.swing.JPanel {

    /**
     * Creates new form LopHocUI
     */
    public UI_LopHoc() {
        initComponents();
        setupTableLop();
        setupTableLich();
        hienThiDsLop();
        thayPanel(pnLocThu);
        cbLoc.setSelectedIndex(0);
    }
   
    // BIẾN TỰ ĐỊNH NGHĨA
    static DefaultTableModel static_dtmLopHoc;
    static DefaultTableModel static_dtmLich;
    
    pnLocThu pnLocThu = new pnLocThu();
    static ArrayList<dto_LopHoc> static_dsLopHoc;
    static ArrayList<dto_Lich> static_dsLich;
    boolean isCheckLopDong;
    
    
    public static ArrayList<dto_LopHoc> getDsLopHoc(){
        return static_dsLopHoc;
    }
    
    
    // HÀM THAY PANEL
    public void thayPanel(JPanel pn){
        pnLoc.removeAll();
        pnLoc.repaint();
        pnLoc.add(pn);
        pnLoc.repaint();
        pnLoc.revalidate();

    }
    
    // HÀM XÓA LỚP
    public void xoaLop(){
        
        dto_LopHoc lop = layLopDuocChon();
        
        if(lop != null){
            
            FormXacMinhNguoiDung form = new FormXacMinhNguoiDung();
            boolean ketQua = form.kiemTraMatKhau();
            
            if(form.getLuaChon() == 0){
                
                if(ketQua == true){
                
                int rs = new bus_LopHoc().xoaLop(lop);
                
                if(rs == 0)
                    JOptionPane.showMessageDialog(null, "Không Thành Công");
                else{
                    JOptionPane.showMessageDialog(null, "Xóa Thành Công");
                    hienThiDsLop();
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Mật Khẩu Không Chính Xác");
            }

        }
    }
    // HÀM TÌM KIẾM
    public void hienThiDsTimLop(String text){
        ArrayList<dto_LopHoc> dsLopTim = new bus_LopHoc().layDsLopTim(text);
        reloadTableLop(dsLopTim);
    }
    // HÀM HIỂN THỊ THÔNG TIN LÊN DS LỚP HỌC
    public static void hienThiDsLop(){
        
        ArrayList<dto_LopHoc> dsLop = new ArrayList<dto_LopHoc>();
        boolean chonTatCa = ckLopDong.isSelected();
        dsLop = new bus_LopHoc().layDsLop(chonTatCa);
        reloadTableLop(dsLop);  
    }
    
    // HÀM HIỂN THỊ DANH SÁCH LỊCH HỌC CỦA 1 LỚP
    public void hienThiThongTinLop(dto_LopHoc lop){
        txtPhuTrach.setText(lop.getTk().getMa() + " - " + lop.getTk().getHoTen());
        reloadTableLich(lop);
    }
    
    // HÀM LẤY ĐỐI TƯỢNG LỚP ĐƯỢC CHỌN
    public dto_LopHoc layLopDuocChon(){      
        int dong = tbLopHoc.getSelectedRow();
        dto_LopHoc lop = null;
        
        if(dong > -1){
            lop = new dto_LopHoc(); 
            lop = static_dsLopHoc.get(dong);
        }
        return lop;
    }
    // HÀM TẢI LẠI DANH SÁCH LICH
    public static void reloadTableLich(dto_LopHoc lop) {

        static_dsLich = new ArrayList<dto_Lich>();
        static_dsLich = lop.getDsLich();

        int stt = 0;
        static_dtmLich.setRowCount(0);

        for (dto_Lich lich : static_dsLich) {

            stt++;
            Vector<Object> vc = new Vector<Object>();
            vc.add(stt);
            vc.add(lich.getNgayHoc());
            
            if(lich.getThu() == 1)
                vc.add("CN");
            else
                vc.add(lich.getThu());
            
            vc.add(lich.getGioBd() + " - " +lich.getGioKt());
            vc.add(lich.getGv().getTenGv());
            vc.add(lich.getPhong().getTenPhong());
            static_dtmLich.addRow(vc);
        }
    }
    // HÀM TẢI LẠI DANH SÁCH LỚP
    public static void reloadTableLop(ArrayList<dto_LopHoc> dsLop) {

        static_dsLopHoc = new ArrayList<dto_LopHoc>();
        static_dsLopHoc = dsLop;

        int stt = 0;
        static_dtmLopHoc.setRowCount(0);

        for (dto_LopHoc lop : dsLop) {

            stt++;
            Vector<Object> vc = new Vector<Object>();

            vc.add(stt);
            vc.add(lop.getMaLop());
            vc.add(lop.getTenLop());
            vc.add(lop.getCt().getTenCt());
            vc.add(lop.layNgayBd());
            vc.add(lop.getSoBuoi());
            vc.add(lop.getSiSo());

            if (lop.getTrangThai() == 0) {
                vc.add("Đóng");
            } else {
                vc.add("Mở");
            }

            static_dtmLopHoc.addRow(vc);
        }
    }
    
    // HÀM TẠO BẢNG LỊCH
    public void setupTableLich() {
        static_dtmLich = new DefaultTableModel(){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        static_dtmLich.addColumn("STT");
        static_dtmLich.addColumn("Ngày");
        static_dtmLich.addColumn("Thứ");
        static_dtmLich.addColumn("Thời Gian");
        static_dtmLich.addColumn("Giáo Viên");
        static_dtmLich.addColumn("Phòng");

        tbLich.setModel(static_dtmLich);

        tbLich.getColumnModel().getColumn(0).setMinWidth(50);
        tbLich.getColumnModel().getColumn(0).setMaxWidth(50);
        tbLich.getColumnModel().getColumn(1).setMinWidth(80);
        tbLich.getColumnModel().getColumn(1).setMaxWidth(80);
        tbLich.getColumnModel().getColumn(2).setMinWidth(50);
        tbLich.getColumnModel().getColumn(2).setMaxWidth(50);
        tbLich.getColumnModel().getColumn(3).setMinWidth(100);
        tbLich.getColumnModel().getColumn(3).setMaxWidth(100);
        tbLich.getColumnModel().getColumn(5).setMinWidth(50);
        tbLich.getColumnModel().getColumn(5).setMaxWidth(50);
        
        tbLich.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        tbLich.getTableHeader().setOpaque(false);
        tbLich.getTableHeader().setForeground(new Color(0, 0, 0));
        tbLich.setSelectionBackground(new Color(0, 64, 128));

    }
    
    // HÀM TẠO BẢNG LỚP HỌC
    public void setupTableLop() {
        static_dtmLopHoc = new DefaultTableModel(){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        static_dtmLopHoc.addColumn("STT");
        static_dtmLopHoc.addColumn("Mã Lớp");
        static_dtmLopHoc.addColumn("Tên Lớp");
        static_dtmLopHoc.addColumn("Chương Trình");
        static_dtmLopHoc.addColumn("Bắt Đầu");
        static_dtmLopHoc.addColumn("Số Buổi");
        static_dtmLopHoc.addColumn("Sỉ Số");
        static_dtmLopHoc.addColumn("Trạng Thái");

        tbLopHoc.setModel(static_dtmLopHoc);

        tbLopHoc.getColumnModel().getColumn(0).setMinWidth(50);
        tbLopHoc.getColumnModel().getColumn(0).setMaxWidth(50);
        tbLopHoc.getColumnModel().getColumn(1).setMinWidth(80);
        tbLopHoc.getColumnModel().getColumn(1).setMaxWidth(80);
        tbLopHoc.getColumnModel().getColumn(2).setMinWidth(120);
        tbLopHoc.getColumnModel().getColumn(2).setMaxWidth(120);
        tbLopHoc.getColumnModel().getColumn(3).setMinWidth(120);
        tbLopHoc.getColumnModel().getColumn(3).setMaxWidth(120);
        tbLopHoc.getColumnModel().getColumn(4).setMaxWidth(80);
        tbLopHoc.getColumnModel().getColumn(4).setMinWidth(80);
        tbLopHoc.getColumnModel().getColumn(5).setMaxWidth(80);
        tbLopHoc.getColumnModel().getColumn(5).setMinWidth(80);
        tbLopHoc.getColumnModel().getColumn(6).setMinWidth(80);
        tbLopHoc.getColumnModel().getColumn(6).setMaxWidth(80);

        tbLopHoc.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        tbLopHoc.getTableHeader().setOpaque(false);
        tbLopHoc.getTableHeader().setForeground(new Color(0, 0, 0));
        tbLopHoc.setSelectionBackground(new Color(0, 64, 128));
    }
    
    // HÀM ẨN CHỨC NĂNG DÀNH CHO GIAO DIỆN GHI DANH
    public void hideBtnLop(){
        btnLichHoc.setVisible(false);
        btnThemLop.setVisible(false);
        btnCapNhatLop.setVisible(false);
        btnXoaLop.setVisible(false);
    } 
    
    // SỰ KIỆN KHI LỰA CHỌN CHỨC NĂNG LỌC

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCapNhatLop = new javax.swing.JButton();
        btnXoaLop = new javax.swing.JButton();
        lblTimLop = new javax.swing.JLabel();
        txtTimLop = new javax.swing.JTextField();
        jspLH = new javax.swing.JScrollPane();
        tbLopHoc = new javax.swing.JTable();
        btnThemLop = new javax.swing.JButton();
        ckLopDong = new javax.swing.JCheckBox();
        pnThongTinLop = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLich = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPhuTrach = new javax.swing.JTextField();
        btnLichHoc = new javax.swing.JButton();
        btnChiTietLop1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbLoc = new javax.swing.JComboBox<>();
        pnLoc = new javax.swing.JPanel();
        pnDemo = new javax.swing.JPanel();

        setBackground(new java.awt.Color(230, 245, 255));
        setMinimumSize(new java.awt.Dimension(1350, 634));
        setPreferredSize(new java.awt.Dimension(1350, 634));

        btnCapNhatLop.setBackground(new java.awt.Color(230, 245, 255));
        btnCapNhatLop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCapNhatLop.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhatLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/capnhat.png"))); // NOI18N
        btnCapNhatLop.setContentAreaFilled(false);
        btnCapNhatLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapNhatLop.setFocusable(false);
        btnCapNhatLop.setMaximumSize(new java.awt.Dimension(129, 49));
        btnCapNhatLop.setMinimumSize(new java.awt.Dimension(129, 49));
        btnCapNhatLop.setOpaque(true);
        btnCapNhatLop.setPreferredSize(new java.awt.Dimension(129, 49));
        btnCapNhatLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatLopActionPerformed(evt);
            }
        });

        btnXoaLop.setBackground(new java.awt.Color(230, 245, 255));
        btnXoaLop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoaLop.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xoa.png"))); // NOI18N
        btnXoaLop.setContentAreaFilled(false);
        btnXoaLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaLop.setFocusable(false);
        btnXoaLop.setMaximumSize(new java.awt.Dimension(129, 49));
        btnXoaLop.setMinimumSize(new java.awt.Dimension(129, 49));
        btnXoaLop.setOpaque(true);
        btnXoaLop.setPreferredSize(new java.awt.Dimension(129, 49));
        btnXoaLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaLopActionPerformed(evt);
            }
        });

        lblTimLop.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTimLop.setText("Tìm Kiếm");

        txtTimLop.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTimLop.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtTimLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimLopActionPerformed(evt);
            }
        });
        txtTimLop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimLopKeyReleased(evt);
            }
        });

        jspLH.setBackground(new java.awt.Color(255, 255, 255));
        jspLH.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jspLH.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jspLH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jspLH.setPreferredSize(new java.awt.Dimension(469, 400));

        tbLopHoc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbLopHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Lớp", "Tên Lớp", "Chương Trình", "Bắt Đầu", "Sỉ Số", "Số Buổi", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbLopHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbLopHoc.setDoubleBuffered(true);
        tbLopHoc.setFocusable(false);
        tbLopHoc.setRowHeight(40);
        tbLopHoc.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tbLopHoc.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbLopHoc.getTableHeader().setReorderingAllowed(false);
        tbLopHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbLopHocMousePressed(evt);
            }
        });
        jspLH.setViewportView(tbLopHoc);
        if (tbLopHoc.getColumnModel().getColumnCount() > 0) {
            tbLopHoc.getColumnModel().getColumn(0).setMinWidth(50);
            tbLopHoc.getColumnModel().getColumn(0).setMaxWidth(50);
            tbLopHoc.getColumnModel().getColumn(1).setMinWidth(100);
            tbLopHoc.getColumnModel().getColumn(1).setMaxWidth(100);
            tbLopHoc.getColumnModel().getColumn(2).setMinWidth(150);
            tbLopHoc.getColumnModel().getColumn(2).setMaxWidth(150);
            tbLopHoc.getColumnModel().getColumn(3).setMinWidth(150);
            tbLopHoc.getColumnModel().getColumn(3).setMaxWidth(150);
            tbLopHoc.getColumnModel().getColumn(4).setMinWidth(80);
            tbLopHoc.getColumnModel().getColumn(4).setMaxWidth(80);
            tbLopHoc.getColumnModel().getColumn(5).setMinWidth(50);
            tbLopHoc.getColumnModel().getColumn(5).setMaxWidth(50);
        }

        btnThemLop.setBackground(new java.awt.Color(230, 245, 255));
        btnThemLop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/taomoi.png"))); // NOI18N
        btnThemLop.setContentAreaFilled(false);
        btnThemLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemLop.setFocusable(false);
        btnThemLop.setOpaque(true);
        btnThemLop.setPreferredSize(new java.awt.Dimension(183, 40));
        btnThemLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLopActionPerformed(evt);
            }
        });

        ckLopDong.setBackground(new java.awt.Color(230, 245, 255));
        ckLopDong.setText("Lớp đã đóng");
        ckLopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckLopDongActionPerformed(evt);
            }
        });

        pnThongTinLop.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTinLop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 2));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbLich.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, "2", "10h00 - 12h00", "Alexander Rud", "A509"}
            },
            new String [] {
                "STT", "Ngày", "Thứ", "Thời Gian", "Giáo Viên", "Phòng"
            }
        ));
        tbLich.setRowHeight(40);
        jScrollPane1.setViewportView(tbLich);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Lịch Học");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Phụ Trách :");

        txtPhuTrach.setBorder(null);

        btnLichHoc.setBackground(new java.awt.Color(0, 102, 153));
        btnLichHoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLichHoc.setForeground(new java.awt.Color(255, 255, 255));
        btnLichHoc.setText("Cài Đặt Lịch Học");
        btnLichHoc.setToolTipText("Chi Tiết Lớp");
        btnLichHoc.setBorder(null);
        btnLichHoc.setContentAreaFilled(false);
        btnLichHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLichHoc.setFocusable(false);
        btnLichHoc.setOpaque(true);
        btnLichHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichHocActionPerformed(evt);
            }
        });

        btnChiTietLop1.setBackground(new java.awt.Color(0, 102, 153));
        btnChiTietLop1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnChiTietLop1.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietLop1.setText("Vào Lớp");
        btnChiTietLop1.setToolTipText("Chi Tiết Lớp");
        btnChiTietLop1.setBorder(null);
        btnChiTietLop1.setContentAreaFilled(false);
        btnChiTietLop1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChiTietLop1.setFocusable(false);
        btnChiTietLop1.setOpaque(true);
        btnChiTietLop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietLop1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnThongTinLopLayout = new javax.swing.GroupLayout(pnThongTinLop);
        pnThongTinLop.setLayout(pnThongTinLopLayout);
        pnThongTinLopLayout.setHorizontalGroup(
            pnThongTinLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnThongTinLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnThongTinLopLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLichHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnThongTinLopLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtPhuTrach, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinLopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChiTietLop1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
        );
        pnThongTinLopLayout.setVerticalGroup(
            pnThongTinLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinLopLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(pnThongTinLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhuTrach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThongTinLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnLichHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChiTietLop1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Lọc Theo");

        cbLoc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thứ", "Ngày" }));
        cbLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocActionPerformed(evt);
            }
        });

        pnLoc.setBackground(new java.awt.Color(230, 245, 255));
        pnLoc.setMinimumSize(new java.awt.Dimension(347, 30));
        pnLoc.setPreferredSize(new java.awt.Dimension(347, 30));
        pnLoc.setLayout(new java.awt.CardLayout());

        pnDemo.setBackground(new java.awt.Color(230, 245, 255));
        pnDemo.setMinimumSize(new java.awt.Dimension(347, 30));
        pnDemo.setPreferredSize(new java.awt.Dimension(347, 30));

        javax.swing.GroupLayout pnDemoLayout = new javax.swing.GroupLayout(pnDemo);
        pnDemo.setLayout(pnDemoLayout);
        pnDemoLayout.setHorizontalGroup(
            pnDemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnDemoLayout.setVerticalGroup(
            pnDemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pnLoc.add(pnDemo, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTimLop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimLop, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ckLopDong)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnLoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jspLH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnThongTinLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnThemLop, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhatLop, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(405, 405, 405))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimLop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTimLop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ckLopDong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemLop, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapNhatLop, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jspLH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnThongTinLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCapNhatLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatLopActionPerformed
    
        dto_LopHoc lopChon = new dto_LopHoc();
        lopChon = layLopDuocChon();
        
        if(lopChon != null){
            if(lopChon.getMaNv() == UI_DangNhap.layMaNguoiDung() || UI_DangNhap.layLoaiNguoiDung() == 1) 
                new FormCapNhatLop(lopChon).show();
            else
                JOptionPane.showMessageDialog(null, "Người Phụ Trách Mới Được Thực Hiện Thao Tác Này");
        }
        else
            JOptionPane.showMessageDialog(null, "Chưa Chọn Lớp");
    }//GEN-LAST:event_btnCapNhatLopActionPerformed

    private void btnThemLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLopActionPerformed
        new FormThemLop().show();
    }//GEN-LAST:event_btnThemLopActionPerformed

    private void btnLichHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichHocActionPerformed
    
        dto_LopHoc lopChon = new dto_LopHoc();
        lopChon = layLopDuocChon();     
        if(lopChon != null){
            if(lopChon.getMaNv() == UI_DangNhap.layMaNguoiDung() || UI_DangNhap.layLoaiNguoiDung() == 1){
                int luaChon = JOptionPane.showConfirmDialog(null, "Lưu ý lịch học đã tồn tại!\n\nSau khi cập nhật lịch học cũ sẽ được thay thế bằng lịch mới\n\nBạn có muốn tiếp tục?", "Cập Nhật Lịch Học", JOptionPane.YES_NO_OPTION);
                if(luaChon == 0)
                    new FormLichHoc(lopChon).show();
            }       
            else
                JOptionPane.showMessageDialog(null, "Người Phụ Trách Mới Được Thực Hiện Thao Tác Này");
        }
        else
            JOptionPane.showMessageDialog(null, "Chưa Chọn Lớp");
    }//GEN-LAST:event_btnLichHocActionPerformed

    private void btnXoaLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLopActionPerformed
            dto_LopHoc lop = layLopDuocChon();
            
            if(lop != null){
                
                if(lop.getMaNv() == UI_DangNhap.layMaNguoiDung() || UI_DangNhap.layLoaiNguoiDung() ==1)
                    xoaLop();
                else
                    JOptionPane.showMessageDialog(null, "Người Phụ Trách Mới Được Thực Hiện Thao Tác Này");
            }
            else
                JOptionPane.showMessageDialog(null, "Chưa Chọn Lớp");
    }//GEN-LAST:event_btnXoaLopActionPerformed

    private void txtTimLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimLopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimLopActionPerformed

    private void tbLopHocMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLopHocMousePressed
        hienThiThongTinLop(layLopDuocChon()); 
    }//GEN-LAST:event_tbLopHocMousePressed

    private void txtTimLopKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimLopKeyReleased
        String text= txtTimLop.getText();
        
        if(!text.isEmpty()){
            hienThiDsTimLop(text);
        }
        else
            hienThiDsLop();
    }//GEN-LAST:event_txtTimLopKeyReleased

    private void ckLopDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckLopDongActionPerformed
        hienThiDsLop();
    }//GEN-LAST:event_ckLopDongActionPerformed

    private void btnChiTietLop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietLop1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChiTietLop1ActionPerformed

    private void cbLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocActionPerformed
        int row = cbLoc.getSelectedIndex();
        
        if(row == 0)
            thayPanel(new pnLocThu());
        
        else if(row == 1)
            thayPanel(new pnLocNgay());
    }//GEN-LAST:event_cbLocActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatLop;
    private javax.swing.JButton btnChiTietLop1;
    private javax.swing.JButton btnLichHoc;
    private javax.swing.JButton btnThemLop;
    private javax.swing.JButton btnXoaLop;
    private javax.swing.JComboBox<String> cbLoc;
    private static javax.swing.JCheckBox ckLopDong;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jspLH;
    private javax.swing.JLabel lblTimLop;
    private javax.swing.JPanel pnDemo;
    private javax.swing.JPanel pnLoc;
    private javax.swing.JPanel pnThongTinLop;
    private javax.swing.JTable tbLich;
    private javax.swing.JTable tbLopHoc;
    private javax.swing.JTextField txtPhuTrach;
    private javax.swing.JTextField txtTimLop;
    // End of variables declaration//GEN-END:variables
}
