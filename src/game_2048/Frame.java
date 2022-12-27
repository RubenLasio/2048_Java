package game_2048;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class Frame extends JFrame 
	implements ActionListener{
	
	//Border x = BorderFactory.createLineBorder(Color.DARK_GRAY, 2);

	public int n=4;
	public JPanel[] grid;
	public JLabel[] text;

	public Frame() {
		super("convertitore monete");
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(n,n));
		c.setBackground(Color.gray);

		grid = new JPanel[n*n];
		text = new JLabel[n*n];
		
		Color panel = new Color(205,193,180);
		Color border = new Color(187,173,160);
		
		Font f1 = new Font("Arial",Font.BOLD,30);
		
		for(int k=0; k<n*n; k++) {
			grid[k] = new JPanel();
			grid[k].setLayout(new BorderLayout());
			text[k] = new JLabel("",SwingConstants.CENTER);
			text[k].setFont(f1);
			grid[k].setBackground(panel);
			grid[k].add(text[k],BorderLayout.CENTER);
			grid[k].setBorder(BorderFactory.createLineBorder(border, 3));
			c.add(grid[k]);
		}
		genera();
		genera();
		
		
		
	}
	
	public void genera() {
		Color c2 	= new Color(238,228,218);
		int[] poss = new int[n*n];
		int c=0;
		for(int k=0; k<n*n; k++) {
			if(text[k].getText().isEmpty()) {
				poss[c]=k;
				c++;
			}
		}
		if(c!=0) { //almeno 1 casella disponibile per spawnare
			Random random = new Random();
			int rand = random.nextInt(c);
			text[poss[rand]].setText("2");
			grid[poss[rand]].setBackground(c2);
			/*for(int k=0; k<c; k++) {
				System.out.print(poss[k] + " ");
			}
			System.out.println("   "+rand);*/
		}
		else {
			
		}
	}

	public void actionPerformed(ActionEvent ev) {
	}

}
