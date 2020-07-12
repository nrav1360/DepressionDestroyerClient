package aarav.programs;

import java.awt.Graphics;
import javax.swing.*;

public class JTextBubble extends JTextPane{
	
	public JTextBubble(){
		super();
		setOpaque(false);
		
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}
	
	protected void paintComponent(Graphics g) {
        int width = getWidth() - getInsets().left - getInsets().right;
        int height = getHeight() - getInsets().top - getInsets().bottom;
        
       g.setColor(getBackground());
       g.fillRoundRect(getInsets().left, getInsets().top, width, height, 75, 75);
              
        super.paintComponent(g); 
		
		
    } 
     
}


