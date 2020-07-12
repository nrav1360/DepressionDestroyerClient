package aarav.programs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InsultSimulator implements ActionListener{
	
	private JFrame frame;
	private JPanel panel;
	private JButton insult, compliment, yomama, oldtimey, rare, cringe;
	private JLabel yo, duck;
	private BufferedImage donald;
	private static JTextBubble textfield;
	private boolean special;
	private boolean yomamaON, oldtimeyON, rareON, cringeON;
	private String set = "\n\n";
	
	public InsultSimulator() throws IOException{
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 700);
		frame.setTitle("Insult Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setBackground(Color.blue);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		insult = new JGradientButton("Insult");
		insult.setBounds(25, 300, 200, 50);
		insult.setBackground(Color.red);
		insult.setBorderPainted(false);
		panel.add(insult);
		insult.addActionListener(this);

		compliment = new JGradientButton("Compliment");
		compliment.setBounds(275, 300, 200, 50);
		compliment.setBackground(Color.green);
		compliment.setBorderPainted(false);
		panel.add(compliment);
		compliment.addActionListener(this);
		
		
		textfield = new JTextBubble();
		textfield.setBounds(200, 20, 250, 100); 
		StyledDocument doc = textfield.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		panel.add(textfield);
		
		
		yo = new JLabel();
		yo.setBounds(95, 395, 100, 20);
		yo.setFont(new Font("Papyrus", Font.PLAIN, 14));
		yo.setText("Yo Mama");
		panel.add(yo);
		
		yo = new JLabel();
		yo.setBounds(95, 525, 100, 20);
		yo.setFont(new Font("Papyrus", Font.PLAIN, 14));
		yo.setText("Old Timey");
		panel.add(yo);
		
		yo = new JLabel();
		yo.setBounds(355, 395, 100, 20);
		yo.setFont(new Font("Papyrus", Font.PLAIN, 14));
		yo.setText("Rare");
		panel.add(yo);
		
		yo = new JLabel();
		yo.setBounds(352, 525, 100, 20);
		yo.setFont(new Font("Papyrus", Font.PLAIN, 14));
		yo.setText("Cringe");
		panel.add(yo);

		yomama = new JButton("Yo");
		yomama.setForeground(Color.RED);
	    yomama.setBounds(100, 420, 45, 45);
	    yomama.setBorder(new JCircleButton(50));
	    panel.add(yomama);
		yomama.addActionListener(this);
		
		oldtimey = new JButton("Yo");
		oldtimey.setForeground(Color.RED);
	    oldtimey.setBounds(100, 550, 45, 45);
	    oldtimey.setBorder(new JCircleButton(30));
	    panel.add(oldtimey);
		oldtimey.addActionListener(this);
		
		rare = new JButton("Yo");
		rare.setForeground(Color.RED);
	    rare.setBounds(350, 420, 45, 45);
	    rare.setBorder(new JCircleButton(30));
	    panel.add(rare);
		rare.addActionListener(this);
		
		cringe = new JButton("Yo");
		cringe.setForeground(Color.RED);
	    cringe.setBounds(350, 550, 45, 45);
	    cringe.setBorder(new JCircleButton(30));
	    panel.add(cringe);
		cringe.addActionListener(this);
		
		donald = ImageIO.read(new File("aarav/programs/DonaldDuck.png"));
		duck = new JLabel(new ImageIcon(donald));
		duck.setBounds(50, 20, 150, 230);
		panel.add(duck); 
		
		BufferedImage speech = ImageIO.read(new File("aarav/programs/ComicBubbleThing.png"));
		JLabel bubble = new JLabel(new ImageIcon(speech));
		bubble.setBounds(150, -40, 150, 230);
		panel.add(bubble); 
		
		frame.setVisible(true); 
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// Nested if loops, if e==insult -> move on to inside
		// if yomama, choose random yomama insult
		// if rare, choose random rare insult...
		if(e.getSource().equals(insult)){
			textfield.setText(set + "Sahus is a homovariant");
		}
		if(e.getSource().equals(compliment)){
			textfield.setText(set + "Sahus is a fun kid");
		}
		if(e.getSource().equals(yomama)){
			if(special){
				//yomama.setForeground(Color.red);
				oldtimey.setForeground(Color.red);
				rare.setForeground(Color.red);
				cringe.setForeground(Color.red);
				oldtimeyON = false;
				rareON = false;
				cringeON = false;		
			}
			textfield.setText(set + "Yomama so homovariant that she acts like Sahus");
			if(yomama.getForeground().equals(Color.GREEN)){ 
				yomama.setForeground(Color.red); 
				special = false; 
				yomamaON = false;
			}
			else { 
				yomama.setForeground(Color.GREEN); 
				special = true; 
				yomamaON = true;
			}
			
		}
		if(e.getSource().equals(oldtimey)){
			if(special){
				yomama.setForeground(Color.red);
				rare.setForeground(Color.red);
				cringe.setForeground(Color.red);
				yomamaON = false;
				rareON = false;
				cringeON = false;		
			}
			textfield.setText(set + "Brah ya bleeding fairy");
			if(oldtimey.getForeground().equals(Color.GREEN)){ 
				oldtimey.setForeground(Color.red); 
				special = false; 
				oldtimeyON = false;
				System.out.println(yomamaON);
				System.out.println(oldtimeyON);
				
			}
			else { 
				oldtimey.setForeground(Color.GREEN); 
				special = true; 
				oldtimeyON = true;
				System.out.println(yomamaON);
				System.out.println(oldtimeyON);
			}
		}
		if(e.getSource().equals(rare)){
			if(special){
				yomama.setForeground(Color.red);
				oldtimey.setForeground(Color.red);
				cringe.setForeground(Color.red);
				yomamaON = false;
				oldtimeyON = false;
				cringeON = false;		
			}
			textfield.setText(set + "A green goblin is more energetic then you are");
			if(rare.getForeground().equals(Color.GREEN)){ 
				rare.setForeground(Color.red); 
				special = false; 
				rareON = false;
			}
			else{ 
				rare.setForeground(Color.GREEN); 
				special = true; 
				rareON = true;
			}
		}
		if(e.getSource().equals(cringe)){
			if(special){
				yomama.setForeground(Color.red);
				oldtimey.setForeground(Color.red);
				rare.setForeground(Color.red);
				yomamaON = false;
				oldtimeyON = false;
				rareON = false;	
			}
			textfield.setText(set + "You're so lame, you would fall when walking");
			if(cringe.getForeground().equals(Color.GREEN)){ 
				cringe.setForeground(Color.red); 
				special = false; 
				cringeON = false;
			}
			else { 
				cringe.setForeground(Color.GREEN); 
				special = true; 
				cringeON = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new InsultSimulator();
	}
	

}
