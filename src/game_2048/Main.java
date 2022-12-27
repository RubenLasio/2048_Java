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
		        		Sum_UP(f, matrix);
		    			deleteOldText(f);
			    		fromMatrixtoText(f, matrix);
			    		genera(f, matrix);
		    		}
		        	else if(Sum_UP(f, matrix)) {
		        		deleteOldText(f);
			    		fromMatrixtoText(f, matrix);
			    		genera(f, matrix);
		        	}
		        }
		        else if (keyCode == KeyEvent.VK_DOWN) {
		        	if(DOWN(f, matrix)) {
		        		Sum_DOWN(f, matrix);
		    			deleteOldText(f);
			    		fromMatrixtoText(f, matrix);
			    		genera(f, matrix);
		    		}
		        	else if(Sum_DOWN(f, matrix)) {
		        		deleteOldText(f);
			    		fromMatrixtoText(f, matrix);
			    		genera(f, matrix);
		        	}
		        }
		        else if (keyCode == KeyEvent.VK_LEFT) {
		        	if(LEFT(f, matrix)) {
		        		Sum_LEFT(f, matrix);
		    			deleteOldText(f);
			    		fromMatrixtoText(f, matrix);
			    		genera(f, matrix);
		    		}
		        	else if(Sum_LEFT(f, matrix)) {
		        		deleteOldText(f);
			    		fromMatrixtoText(f, matrix);
			    		genera(f, matrix);
		        	}
		        }
		        else if (keyCode == KeyEvent.VK_RIGHT) {
		        	if(RIGHT(f, matrix)) {
		        		Sum_RIGHT(f, matrix);
		    			deleteOldText(f);
			    		fromMatrixtoText(f, matrix);
			    		genera(f, matrix);
		    		}
		        	else if(Sum_RIGHT(f, matrix)) {
		        		deleteOldText(f);
			    		fromMatrixtoText(f, matrix);
			    		genera(f, matrix);
		        	}
		        }
			}
		});
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
	
	public static void fromMatrixtoText(Frame f, int[][] matrix) {
		
		Color c2 	= new Color(238,228,218);
		Color c4 	= new Color(238,225,201);
		Color c8 	= new Color(243,178,122);
		Color c16 	= new Color(246,150,100);
		Color c32 	= new Color(247,124,95);
		Color c64 	= new Color(247,95,59);
		Color c128 	= new Color(237,208,115);
		Color c256 	= new Color(255,255,255);
		Color c512 	= new Color(255,255,255);
		Color c1024 = new Color(255,255,255);
		Color c2048 = new Color(255,255,255);
		Color cDefault = new Color(58,58,48);
		
		int c=0;
		for(int y=0; y<f.n; y++) {
			for(int x=0; x<f.n; x++) {
				if(matrix[x][y] != 0) {
					f.text[c].setText(String.valueOf(matrix[x][y]));
					int number = Integer.parseInt(f.text[c].getText());
					switch(number) {
					case 2: f.grid[c].setBackground(c2);
						break;
					case 4: f.grid[c].setBackground(c4);
						break;
					case 8: f.grid[c].setBackground(c8);
						break;
					case 16: f.grid[c].setBackground(c16);
						break;
					case 32: f.grid[c].setBackground(c32);
						break;
					case 64: f.grid[c].setBackground(c64);
						break;
					case 128: f.grid[c].setBackground(c128);
						break;
					case 256: f.grid[c].setBackground(c256);
						break;
					case 512: f.grid[c].setBackground(c512);
						break;
					case 1024: f.grid[c].setBackground(c1024);
						break;
					case 2048: f.grid[c].setBackground(c2048);
						break;
					default: f.grid[c].setBackground(cDefault);
					}
				}
				c++;
			}
		}
	}
	
	public static void deleteOldText(Frame f) {
		Color panel = new Color(205,193,180);
		for(int k=0; k<f.n*f.n; k++) {
			f.text[k].setText(null);
			f.grid[k].setBackground(panel);
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
	
	public static boolean Sum_UP(Frame f, int[][] matrix) {
		int c=0;
			for(int y=0; y<(f.n)-1; y++) {
				for(int x=0; x<f.n; x++) {
					if(matrix[x][y] == matrix[x][y+1] && matrix[x][y] != 0) {
						matrix[x][y] += matrix[x][y+1];
						matrix[x][y+1] = 0;
						UP(f, matrix);
						c++;
					}
				}
			}
			if(c<1)
				return false;
			else
				return true;
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
	
	public static boolean Sum_DOWN(Frame f, int[][] matrix) {
		int c=0;
		for(int y=(f.n)-1; y>0; y--) {
			for(int x=0; x<f.n; x++) {
				if(matrix[x][y] == matrix[x][y-1] && matrix[x][y] != 0) {
					matrix[x][y] += matrix[x][y-1];
					matrix[x][y-1] = 0;
					DOWN(f, matrix);
					c++;
				}
			}
		}
		if(c<1)
			return false;
		else 
			return true;
	}
	
	public static boolean LEFT(Frame f, int[][] matrix) {
		int c=0;
		for(int times=0; times<3; times++) {//eseguo per 3 volte per assicurare che anche se un numero sia tutto in basso, dopo 3 spostamenti possa essere su
			for(int y=0; y<f.n; y++) {
				for(int x=0; x<(f.n)-1; x++) {
					if(matrix[x][y] == 0 && matrix[x+1][y] != 0) {
						matrix[x][y] = matrix[x+1][y];
						matrix[x+1][y] = 0;
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
	
	public static boolean Sum_LEFT(Frame f, int[][] matrix) {
		int c=0;
		for(int y=0; y<f.n; y++) {
			for(int x=0; x<(f.n)-1; x++) {
				if(matrix[x][y] == matrix[x+1][y] && matrix[x][y] != 0) {
					matrix[x][y] += matrix[x+1][y];
					matrix[x+1][y] = 0;
					LEFT(f, matrix);
					c++;
				}
			}
		}
		if(c<1)
			return false;
		else 
			return true;
	}
	
	public static boolean RIGHT(Frame f, int[][] matrix) {
		int c=0;
		for(int times=0; times<3; times++) {//eseguo per 3 volte per assicurare che anche se un numero sia tutto in basso, dopo 3 spostamenti possa essere su
			for(int y=0; y<f.n; y++) {
				for(int x=(f.n)-1; x>0; x--) {
					if(matrix[x][y] == 0 && matrix[x-1][y] != 0) {
						matrix[x][y] = matrix[x-1][y];
						matrix[x-1][y] = 0;
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
	
	public static boolean Sum_RIGHT(Frame f, int[][] matrix) {
		int c=0;
		for(int y=0; y<f.n; y++) {
			for(int x=(f.n)-1; x>0; x--) {
				if(matrix[x][y] == matrix[x-1][y] && matrix[x][y] != 0) {
					matrix[x][y] += matrix[x-1][y];
					matrix[x-1][y] = 0;
					RIGHT(f, matrix);
					c++;
				}
			}
		}
		if(c<1)
			return false;
		else 
			return true;
	}
	
	public static void genera(Frame f, int[][] matrix) {
		
		Color c2 	= new Color(238,228,218);
		
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
			f.grid[poss[rand]].setBackground(c2);
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
