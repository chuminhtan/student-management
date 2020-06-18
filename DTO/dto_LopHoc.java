/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import com.toedter.calendar.DateUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author USER
 */
public class dto_LopHoc {
    private int maLop;
    private int maCt;
    private int maNv;
    private String tenLop;
    private Date ngayBd;
    private int soBuoi;
    private int trangThai;
    private int siSo;
    
    private dto_ChuongTrinh ct;
    private dto_TaiKhoan tk;
    private ArrayList<dto_Lich> dsLich; 
    
    public dto_LopHoc() {
        ct = new dto_ChuongTrinh();
        tk = new dto_TaiKhoan();
        dsLich = new ArrayList<dto_Lich>();
    }

    public int getSiSo() {
        return siSo;
    }
    
    
    public dto_ChuongTrinh getCt() {
        return ct;
    }

    public dto_TaiKhoan getTk() {
        return tk;
    }
   
    public int getMaLop() {
        return maLop;
    }

    public int getMaCt() {
        return maCt;
    }

    public int getMaNv() {
        return maNv;
    }

    public String getTenLop() {
        return tenLop;
    }

    public Date getNgayBd() {
        return ngayBd;
    }

    public int getSoBuoi() {
        return soBuoi;
    }

    public int getTrangThai() {
        return trangThai;
    }


    public ArrayList<dto_Lich> getDsLich() {
        return dsLich;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public void setMaCt(int maCt) {
        this.maCt = maCt;
    }

    public void setMaNv(int maNv) {
        this.maNv = maNv;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public void setNgayBd(Date ngay) {
        /*
        try{
            this.ngayBd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(ngay);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
         */
        this.ngayBd = ngay;
    }

    public void setSoBuoi(int soBuoi) {
        this.soBuoi = soBuoi;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }


    public void setDsLich(ArrayList<dto_Lich> dsLich) {
        this.dsLich = dsLich;
    }

    public void setCt(dto_ChuongTrinh ct) {
        this.ct = ct;
    }

    public void setTk(dto_TaiKhoan tk) {
        this.tk = tk;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public String layNgayGioBd(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return sdf.format(this.ngayBd);
    }
    
    public String layNgayBd(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(this.ngayBd);
    }
    
    public static void main(String[] args){

        try{
            String dt = "2020-06-17";  // Start date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            Date d = new Date();
            c.setTime(d);
            
            int day = 0;
            for(int i = 0; i < 10; i++){
                c.add(Calendar.DATE, 1);
                
                if(c.get(c.DAY_OF_WEEK) == 5){
                    System.out.println(c.getTime());
      
                }
            }
              // number of days to add
            //dt = sdf.format(c.getTime());  // dt is now the new date
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }


       
    }
}
