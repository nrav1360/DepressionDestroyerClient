package aarav.programs;

import java.awt.*;

import javax.swing.*;

public class JGradientButton extends JButton{
    public JGradientButton(String string){
        super(string);
        setContentAreaFilled(false);
    }

    public void paintComponent(Graphics g){
        Graphics2D graphics = (Graphics2D)g.create();
        graphics.setPaint(new GradientPaint(new Point(0, 0), getBackground(), new Point(0, getHeight()/3),  Color.WHITE));
        graphics.fillRect(0, 0, getWidth(), getHeight()/3);
        graphics.setPaint(new GradientPaint( new Point(0, getHeight()/3),  Color.WHITE,  new Point(0, getHeight()), getBackground()));
        graphics.fillRect(0, getHeight()/3, getWidth(), getHeight());
        graphics.dispose();

        super.paintComponent(g);
    }
}
