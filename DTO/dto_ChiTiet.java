/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author USER
 */
public class dto_ChiTiet {
    private int ma;
    private String hoTen;
    private String gioiTinh;
    private String sdt;
    private int nghe;
    private int noi;
    private int doc;
    private int viet;
    private int tb;

    public dto_ChiTiet() {
    }

    public dto_ChiTiet(int ma, String hoTen) {
        this.ma = ma;
        this.hoTen = hoTen;
    }

    public int getMa() {
        return ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public int getNghe() {
        return nghe;
    }

    public int getNoi() {
        return noi;
    }

    public int getDoc() {
        return doc;
    }

    public int getViet() {
        return viet;
    }

    public int getTb() {
        return tb;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setNghe(int nghe) {
        this.nghe = nghe;
    }

    public void setNoi(int noi) {
        this.noi = noi;
    }

    public void setDoc(int doc) {
        this.doc = doc;
    }

    public void setViet(int viet) {
        this.viet = viet;
    }

    public void setTb(int tb) {
        this.tb = tb;
    }
    
    
    
}
