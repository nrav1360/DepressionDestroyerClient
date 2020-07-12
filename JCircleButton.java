package aarav.programs;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class JCircleButton implements Border {

    private int rad;


    public JCircleButton(int rad) {
        this.rad = rad;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.rad+1, this.rad+1, this.rad+2, this.rad);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.fillOval(x, y, width, height);
    }

}