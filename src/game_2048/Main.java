package game_2048;

import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		Frame f = new Frame();
		f.pack();
		f.setSize(400, 400);
		f.setLocation(500, 100);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		int[][] matrix = new int[f.n][f.n];
		fromTextToMatrix(f, matrix);
		
		f.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
		    	if (keyCode == KeyEvent.VK_UP) {
		    		if(UP(f, matrix)) {
		    			deleteOldText(f);
			    		fromMatrixtoText(f, matrix);
			    		genera(f, matrix);
		    		}
		        }
		        else if (keyCode == KeyEvent.VK_DOWN) {
		        	if(DOWN(f, matrix)) {
		    			deleteOldText(f);
			    		fromMatrixtoText(f, matrix);
			    		genera(f, matrix);
		    		}
		        }
		        else if (keyCode == KeyEvent.VK_LEFT) {
		        	LEFT(f, matrix);
		    		deleteOldText(f);
		    		fromMatrixtoText(f, matrix);
		    		//genera(f);
		        }
		        else if (keyCode == KeyEvent.VK_RIGHT) {
		        	RIGHT(f, matrix);
		    		deleteOldText(f);
		    		fromMatrixtoText(f, matrix);
		    		//genera(f);
		        }
			}
		});
		/*
		for(int y=0; y<f.n; y++) {
			for(int x=0; x<f.n; x++) {
				System.out.print(matrix[x][y] + " ");
			}
			System.out.println("");
		}
		*/
	}
	
	public static void fromTextToMatrix(Frame f, int[][] matrix) {
		int c=0;
		for(int y=0; y<f.n; y++) {
			for(int x=0; x<f.n; x++) {
				if(f.text[c].getText() != "")
					matrix[x][y] = Integer.parseInt(f.text[c].getText());
				c++;
			}
		}
	}
	
	public static boolean UP(Frame f, int[][] matrix) {
		int c=0;
		for(int times=0; times<3; times++) {//eseguo per 3 volte per assicurare che anche se un numero sia tutto in basso, dopo 3 spostamenti possa essere su
			for(int y=0; y<(f.n)-1; y++) {
				for(int x=0; x<f.n; x++) {
					if(matrix[x][y] == 0 && matrix[x][y+1] != 0) {
						matrix[x][y] = matrix[x][y+1];
						matrix[x][y+1] = 0;
						c++;
					}
				}
			}
		}
		if(c<1)
			return false;
		else
			return true;
	}
	
	public static void fromMatrixtoText(Frame f, int[][] matrix) {
		int c=0;
		for(int y=0; y<f.n; y++) {
			for(int x=0; x<f.n; x++) {
				if(matrix[x][y] != 0) {
					f.text[c].setText(String.valueOf(matrix[x][y]));
					f.grid[c].setBackground(Color.white);// da cambiare colore in base al numero
				}
				c++;
			}
		}
	}
	
	public static void deleteOldText(Frame f) {
		for(int k=0; k<f.n*f.n; k++) {
			f.text[k].setText(null);
			f.grid[k].setBackground(Color.LIGHT_GRAY);
		}
	}
	
	public static boolean DOWN(Frame f, int[][] matrix) {
		int c=0;
		for(int times=0; times<3; times++) {//eseguo per 3 volte per assicurare che anche se un numero sia tutto in basso, dopo 3 spostamenti possa essere su
			for(int y=(f.n)-1; y>0; y--) {
				for(int x=0; x<f.n; x++) {
					if(matrix[x][y] == 0 && matrix[x][y-1] != 0) {
						matrix[x][y] = matrix[x][y-1];
						matrix[x][y-1] = 0;
						c++;
					}
				}
			}
		}
		if(c<1)
			return false;
		else
			return true;
	}
	
	public static boolean LEFT(Frame f, int[][] matrix) {
		return false;
	}
	
	public static boolean RIGHT(Frame f, int[][] matrix) {
		return false;
	}
	
	public static void genera(Frame f, int[][] matrix) {
		int[] poss = new int[f.n*f.n];
		int c=0;
		for(int k=0; k<f.n*f.n; k++) {
			if(f.text[k].getText() == null) {
				poss[c]=k;
				c++;
			}
		}
		if(c!=0) { //almeno 1 casella disponibile per spawnare
			Random random = new Random();
			int rand = random.nextInt(c);
			f.text[poss[rand]].setText("2");
			f.grid[poss[rand]].setBackground(Color.white);
			matrix[poss[rand] - (4*(poss[rand]/4))][poss[rand]/4] = 2;
			/*for(int k=0; k<c; k++) {
				System.out.print(matrix[k] + " ");
			}
			System.out.println();*/
		}
		else {
			
		}
	}
}
