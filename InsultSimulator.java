package aarav.programs;

import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
	private static  String[] inputs = new String[3];
	private static String[] gInsults = new String[7];
	private static String[] yInsults = new String[7];
	private static String[] oInsults = new String[7];
	private static String[] rInsults = new String[7];
	private static String[] cInsults = new String[7];
	
	
	public InsultSimulator() throws IOException{
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 700);
		frame.setTitle("Insult Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
	//	BufferedImage ate = ImageIO.read(new File("aarav/programs/prettyforest.png"));
	//	JLabel cre = new JLabel(new ImageIcon(ate));
	//	cre.setBounds(0, 0, 500, 300);
	//	panel.add(cre); 
		
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
		textfield.setText("\nWelcome to the Insult/Complement Simulator. Choose a generic insult, or a specialized one using the buttons");
		textfield.setBounds(200, 20, 250, 100); 
		StyledDocument doc = textfield.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		panel.add(textfield);
		
		
		yo = new JLabel();
		yo.setBounds(95, 395, 100, 20);
		yo.setForeground(Color.white);
		yo.setFont(new Font("Papyrus", Font.BOLD, 14));
		yo.setText("Yo Mama");
		panel.add(yo);
		
		yo = new JLabel();
		yo.setBounds(95, 525, 100, 20);
		yo.setForeground(Color.white);
		yo.setFont(new Font("Papyrus", Font.BOLD, 14));
		yo.setText("Old Timey");
		panel.add(yo);
		
		yo = new JLabel();
		yo.setBounds(355, 395, 100, 20);
		yo.setForeground(Color.white);
		yo.setFont(new Font("Papyrus", Font.BOLD, 14));
		yo.setText("Rare");
		panel.add(yo);
		
		yo = new JLabel();
		yo.setBounds(352, 525, 100, 20);
		yo.setForeground(Color.white);
		yo.setFont(new Font("Papyrus", Font.BOLD, 14));
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
		
		BufferedImage ate = ImageIO.read(new File("aarav/programs/prettyforest.png"));
		JLabel cre = new JLabel(new ImageIcon(ate));
		cre.setBounds(0, 0, 500, 282);
		panel.add(cre); 
		
		BufferedImage ke = ImageIO.read(new File("aarav/programs/flowriver.png"));
		JLabel ma = new JLabel(new ImageIcon(ke));
		ma.setBounds(0, 282, 500, 418);
		panel.add(ma); 
		
		
		
		
		frame.setVisible(true); 
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// Nested if loops, if e==insult -> move on to inside
		// if yomama, choose random yomama insult
		// if rare, choose random rare insult...
		if(e.getSource().equals(insult)){
			if(yomamaON){
				textfield.setText(set + "Yomama so fat that she lost Weight Watchers to Trump");
			}
			else if(oldtimeyON){
				textfield.setText(set + "Yer a swashbuckling mongrel donkey");
			}
			else if(rareON){
				textfield.setText(set + "I've never seen a domesticated hippopotomus before");
			}
			else if(cringeON){
				textfield.setText(set + "Haha, you gay loser :)");
			}
			else{
				textfield.setText(set + "You're a loser");
			}
			
		}
		if(e.getSource().equals(compliment)){
			if(yomamaON){
				textfield.setText(set + "Yomama so nice she baked me a plate of cookies");
			}
			if(oldtimeyON){
				textfield.setText(set + "Yer gon'r succeed with yer endeavors");
			}
			if(rareON){
				textfield.setText(set + "I have never seen someone with such a voluminous brain");
			}
			if(cringeON){
				textfield.setText(set + "Are you from Tennessee. I think you're a 10 haha");
			}
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
		//	textfield.setText(set + "Yomama so homovariant that she acts like Sahus");
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
	//		textfield.setText(set + "Brah ya bleeding fairy");
			if(oldtimey.getForeground().equals(Color.GREEN)){ 
				oldtimey.setForeground(Color.red); 
				special = false; 
				oldtimeyON = false;
				
			}
			else { 
				oldtimey.setForeground(Color.GREEN); 
				special = true; 
				oldtimeyON = true;
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
	//		textfield.setText(set + "A green goblin is more energetic then you are");
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
	//		textfield.setText(set + "You're so lame, you would fall when walking");
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
	
	
	
	public static String splice(String string) {
		
		int begIndex = string.indexOf(':');
		int endIndex = string.indexOf(',');
		String toBeReturned = string.substring(begIndex+2, endIndex-1);
		return toBeReturned.substring(1);
		
	}
	
	public static int randomize(){
		return (int) (Math.random() * (6 - 0 + 1) + 1);
	}

	public static void main(String[] args) throws IOException {
		/*URL url = new URL("http://localhost:3000/insult/list");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(new InputStreamReader( con.getInputStream()));
		String st; 
		String combined = "";
		  int value = 0;
		 while ((st = in.readLine()) != null) {
		    System.out.println(st); 
		    combined = combined + st;
		 } 
		
		File file = new File("aarav/programs/Routes.txt"); 
		  
		 BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		String st; 
		String combined = "";
		  int value = 0;
		 while ((st = br.readLine()) != null) {
		    System.out.println(st); 
		    combined = combined + st;
			
		 }   
		 int bracketCounter = 0;
		 for(int i=0; i<combined.length(); i++){
			 if(combined.charAt(i)=='{' || combined.charAt(i)=='}')
			 bracketCounter++;
		 }
		 
		 for(int i=0; i<bracketCounter/2;i++){
			 int beg = combined.indexOf('{');
			 int end = combined.indexOf('}');
			 String car = combined.substring(beg, end+1);
			 inputs[value] = car;
			 combined = combined.substring(end+1);
			 value++;
		 }
		
		int yCounter = 0;
		int oCounter = 0;
		int rCounter = 0;
		int cCounter = 0;
		int gCounter = 0;
		System.out.println(inputs[0]);
		for(int i = 0; i<inputs.length; i++) {
			if(inputs[i].contains("yo mama")) {
				yInsults[yCounter] = inputs[i];
				yCounter++;
			}
			else if(inputs[i].contains("[\"old timey\"]")) {
				oInsults[oCounter] = inputs[i];
				oCounter++;
				System.out.println("hi");
			}
			else if(inputs[i].contains("rare")) {
				rInsults[rCounter] = inputs[i];
				rCounter++;
			}
			else if(inputs[i].contains("cringe")) {
				cInsults[cCounter] = inputs[i];
				cCounter++;
			}
			else {
				gInsults[gCounter] = inputs[i];
				gCounter++;
			}
		}
		System.out.println(oInsults[0]);
		System.out.println(oInsults[1]);
		System.out.println(oInsults[2]);
		System.out.print(splice(oInsults[0])); */
		new InsultSimulator();
	}
	

}
