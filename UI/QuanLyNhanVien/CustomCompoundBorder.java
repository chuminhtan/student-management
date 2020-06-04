/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.QuanLyNhanVien;

import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class CustomCompoundBorder extends CompoundBorder implements CustomInterfaceBorder{
    
    public CustomCompoundBorder() {
        super();
        this.insideBorder = new EmptyBorder(0, 0, 0, 0);
    }
    
    public CustomCompoundBorder(CustomBorder outsideBorder, int top, int right, int bottom, int left) {
        super();
        this.outsideBorder = outsideBorder;
        this.insideBorder = new EmptyBorder(top, left, bottom, right);
    }
    
    public CustomCompoundBorder(CustomBorder outsideBorder) {
        this(outsideBorder, 0, 0, 0, 0);
    }
    
    public CustomCompoundBorder(int outsideBorderWidth, int insideBorderWidth) {
        this(new CustomBorder(outsideBorderWidth), insideBorderWidth, insideBorderWidth, insideBorderWidth, insideBorderWidth);
    }
    
    public CustomCompoundBorder(int outsideBorderWidth, int topbottom, int leftright) {
        this(new CustomBorder(outsideBorderWidth), topbottom, leftright, topbottom, leftright);
    }
    
    @Override
    public void setColor(Color color) {
        ((CustomBorder)this.outsideBorder).setColor(color);
    }
    
    public CustomCompoundBorder setInsideBorderWidth(int top, int left, int bottom, int right) {
        this.insideBorder = new EmptyBorder(top, left, bottom, right);
        return this;
    }
}
