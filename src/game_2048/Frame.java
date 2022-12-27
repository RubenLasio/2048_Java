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

		for(int k=0; k<n*n; k++) {
			grid[k] = new JPanel();
			grid[k].setLayout(new BorderLayout());
			text[k] = new JLabel("",SwingConstants.CENTER);
			grid[k].setBackground(Color.LIGHT_GRAY);
			grid[k].add(text[k],BorderLayout.CENTER);
			grid[k].setBorder(BorderFactory.createLineBorder(Color.gray, 3));
			c.add(grid[k]);
		}
		genera();
		genera();
		
		
		
	}
	
	public void genera() {
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
			grid[poss[rand]].setBackground(Color.white);
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
