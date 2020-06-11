/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.dal_ChungChi;
import DTO.dto_ChungChi;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class bus_ChungChi {
    
    // HÀM LẤY DANH SÁCH CHỨNG CHỈ
    public ArrayList<dto_ChungChi> layDsChungChi(){
        ArrayList<dto_ChungChi> dsChungChi = new ArrayList<dto_ChungChi>();
        
        dsChungChi = new dal_ChungChi().layDsChungChi();
        
        return dsChungChi;
    }
}
