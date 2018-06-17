package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.w3c.dom.css.Counter;

import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position;

import game.TestClient;

public class LudoGUI extends JFrame implements ActionListener{
	public JPanel board1, board2, board3, board4;
	public JPanel menu;
	public JButton red, green, blue, yellow, black;
	public static JButton rollDice;
	public JButton dice;
	public static JTextArea info;
	public JTextArea bufferArea;
	public static int roll;
	public static ArrayList<JButton> pieces = new ArrayList<JButton>();
	public ArrayList<JButton> tiles = new ArrayList<JButton>();
	public ArrayList<JButton> border = new ArrayList<JButton>();
	public ArrayList<JTextArea> buffer = new ArrayList<JTextArea>();
//	public static ArrayList<Integer> player1 = new ArrayList<Integer>();
//	public static ArrayList<Integer> player2 = new ArrayList<Integer>();
//	public static ArrayList<Integer> player3 = new ArrayList<Integer>();
//	public static ArrayList<Integer> player4 = new ArrayList<Integer>();
	public static ArrayList<Integer> position = new ArrayList<Integer>();
	
	
	public LudoGUI() {        
		getContentPane().setLayout(new GridLayout(1,5));

		board();
        menu();
        buffer();
		border();
		players();
		
		row1();
		row2();
		row3();
		row4();
		row5();
		row6();
		row7();
		row8();
		row9();
		row10();
		row11();
	}

	public void buffer() {
		for(int i = 0; i < 11; i++) {
			bufferArea = new JTextArea();
			buffer.add(bufferArea);
		}
	}

	public void menu() {
		menu = new JPanel();
		menu.setLayout(new GridLayout(6,1));
		getContentPane().add(menu);
		
        menu.add(rollDice = new JButton("Roll Dice"));
        rollDice.addActionListener(this);
        rollDice.setEnabled(false);
        
        menu.add(dice = new JButton());
        rolled();
		
        menu.add(info = new JTextArea());
        info.setText("player1's turn, roll the dice");
	}

	public void border() {
		for(int i = 0; i < 12; i++) {
			red = new JButton();
			border.add(red);
			red.setBackground(Color.RED);
			red.setEnabled(false);
		}
		
		for(int i = 0; i < 12; i++) {
			green = new JButton();
			border.add(green);
			green.setBackground(Color.GREEN);
			green.setEnabled(false);
		}
		
		for(int i = 0; i < 12; i++) {
			blue = new JButton();
			border.add(blue);
			blue.setBackground(Color.BLUE);
			blue.setEnabled(false);
		}
		
		for(int i = 0; i < 12; i++) {
			yellow = new JButton();
			border.add(yellow);
			yellow.setBackground(Color.YELLOW);
			yellow.setEnabled(false);
		}
		
		black = new JButton();
		black.setBackground(Color.BLACK);
		black.setEnabled(false);
	}
	
	public void players() {
		for(int i = 0; i < 4; i++) {
        	JButton red = new JButton("red");
        	pieces.add(red);
        	icon("red", red);
        	red.addActionListener(this);
        	red.setEnabled(false);
        	position.add(-1);
        }
        
        for(int i = 0; i < 4; i++) {
        	JButton green = new JButton("green");
        	pieces.add(green);
        	icon("green", green);
        	green.addActionListener(this);
        	green.setEnabled(false);
        	position.add(-1);
        }
        
        for(int i = 0; i < 4; i++) {
        	JButton blue = new JButton("blue");
        	pieces.add(blue);
        	icon("blue", blue);
        	blue.addActionListener(this);
        	blue.setEnabled(false);
        	position.add(-1);
        }
        
        for(int i = 0; i <= 4; i++) {
        	JButton yellow = new JButton("yellow");
        	pieces.add(yellow);
        	icon("yellow", yellow);
        	yellow.addActionListener(this);
        	yellow.setEnabled(false);
        	position.add(-1);
        }
	}

	public void board() {
		board1 = new JPanel();
		board1.setLayout(new GridLayout(11,3));
		getContentPane().add(board1);
		
		board2 = new JPanel();
		board2.setLayout(new GridLayout(11,3));
		getContentPane().add(board2);
		
		board3 = new JPanel();
		board3.setLayout(new GridLayout(11,3));
		getContentPane().add(board3);
		
		board4 = new JPanel();
		board4.setLayout(new GridLayout(11,3));
		getContentPane().add(board4);
		
		for(int i = 0; i <= 57; i++) {
        	JButton tile = new JButton("" + i);
        	tiles.add(tile);
        	texture("" + i, tile);
        }
	}

	public void row1() {
		board1.add(border.get(0));
		board1.add(border.get(1));
		board1.add(border.get(2));
		board2.add(border.get(3));
		board2.add(tiles.get(8));
		board2.add(tiles.get(9));
		board3.add(tiles.get(10));
		board3.add(border.get(12));
		board3.add(border.get(13));
		board4.add(border.get(14));
		board4.add(border.get(15));
		board4.add(buffer.get(0));
	}

	public void row2() {
		board1.add(border.get(4));
		board1.add(pieces.get(0));
		board1.add(pieces.get(1));
		board2.add(border.get(5));
		board2.add(tiles.get(7));
		board2.add(tiles.get(44));
		board3.add(tiles.get(11));
		board3.add(border.get(16));
		board3.add(pieces.get(4));
		board4.add(pieces.get(5));
		board4.add(border.get(17));
		board4.add(buffer.get(1));
	}

	public void row3() {
		board1.add(border.get(6));
		board1.add(pieces.get(2));
		board1.add(pieces.get(3));
		board2.add(border.get(7));
		board2.add(tiles.get(6));
		board2.add(tiles.get(45));
		board3.add(tiles.get(12));
		board3.add(border.get(18));
		board3.add(pieces.get(6));
		board4.add(pieces.get(7));
		board4.add(border.get(19));
		board4.add(buffer.get(2));
	}
	
	public void row4() {
		board1.add(border.get(8));
		board1.add(border.get(9));
		board1.add(border.get(10));
		board2.add(border.get(11));
		board2.add(tiles.get(5));
		board2.add(tiles.get(46));
		board3.add(tiles.get(13));
		board3.add(border.get(20));
		board3.add(border.get(21));
		board4.add(border.get(22));
		board4.add(border.get(23));
		board4.add(buffer.get(3));
	}
	
	public void row5() {
		board1.add(tiles.get(0));
		board1.add(tiles.get(1));
		board1.add(tiles.get(2));
		board2.add(tiles.get(3));
		board2.add(tiles.get(4));
		board2.add(tiles.get(47));
		board3.add(tiles.get(14));
		board3.add(tiles.get(15));
		board3.add(tiles.get(16));
		board4.add(tiles.get(17));
		board4.add(tiles.get(18));
		board4.add(buffer.get(4));
	}
	
	public void row6() {
		board1.add(tiles.get(39));
		board1.add(tiles.get(40));
		board1.add(tiles.get(41));
		board2.add(tiles.get(42));
		board2.add(tiles.get(43));
		board2.add(black);
		board3.add(tiles.get(51));
		board3.add(tiles.get(50));
		board3.add(tiles.get(49));
		board4.add(tiles.get(48));
		board4.add(tiles.get(19));
		board4.add(buffer.get(5));
	}
	
	public void row7() {
		board1.add(tiles.get(38));
		board1.add(tiles.get(37));
		board1.add(tiles.get(36));
		board2.add(tiles.get(35));
		board2.add(tiles.get(34));
		board2.add(tiles.get(55));
		board3.add(tiles.get(24));
		board3.add(tiles.get(23));
		board3.add(tiles.get(22));
		board4.add(tiles.get(21));
		board4.add(tiles.get(20));
		board4.add(buffer.get(6));
	}
	
	public void row8() {
		board1.add(border.get(24));
		board1.add(border.get(25));
		board1.add(border.get(26));
		board2.add(border.get(27));
		board2.add(tiles.get(33));
		board2.add(tiles.get(54));
		board3.add(tiles.get(25));
		board3.add(border.get(36));
		board3.add(border.get(37));
		board4.add(border.get(38));
		board4.add(border.get(39));
		board4.add(buffer.get(7));
	}
	
	public void row9() {
		board1.add(border.get(28));
		board1.add(pieces.get(8));
		board1.add(pieces.get(9));
		board2.add(border.get(29));
		board2.add(tiles.get(32));
		board2.add(tiles.get(53));
		board3.add(tiles.get(26));
		board3.add(border.get(40));
		board3.add(pieces.get(10));
		board4.add(pieces.get(11));
		board4.add(border.get(41));
		board4.add(buffer.get(8));
	}
	
	public void row10() {
		board1.add(border.get(30));
		board1.add(pieces.get(12));
		board1.add(pieces.get(13));
		board2.add(border.get(31));
		board2.add(tiles.get(31));
		board2.add(tiles.get(52));
		board3.add(tiles.get(27));
		board3.add(border.get(42));
		board3.add(pieces.get(14));
		board4.add(pieces.get(15));
		board4.add(border.get(43));
		board4.add(buffer.get(9));
	}
	
	public void row11() {
		board1.add(border.get(32));
		board1.add(border.get(33));
		board1.add(border.get(34));
		board2.add(border.get(35));
		board2.add(tiles.get(30));
		board2.add(tiles.get(29));
		board3.add(tiles.get(28));
		board3.add(border.get(44));
		board3.add(border.get(45));
		board4.add(border.get(46));
		board4.add(border.get(47));
		board4.add(buffer.get(10));
	}

	public void rolled() {
		Image img = new ImageIcon("dice/" + roll + ".jpg").getImage();
        dice.setIcon(new ImageIcon(img));
	}
	
	public void icon(String icon, JButton button) {
		Image img = new ImageIcon("pieces/" + icon + ".jpg").getImage();
        button.setIcon(new ImageIcon(img));
    }
	
	public void texture(String texture, JButton tile) {
		Image img = new ImageIcon("tiles/" + texture + ".jpg").getImage();
        tile.setIcon(new ImageIcon(img)); 
	}
	
	public static int getRoll() {
		return roll;
	}

	public static JButton getRollDice() {
		return rollDice;
	}

	public JPanel getBoard1() {
		return board1;
	}

	public void setBoard1(JPanel board1) {
		this.board1 = board1;
	}

	public JPanel getBoard2() {
		return board2;
	}

	public void setBoard2(JPanel board2) {
		this.board2 = board2;
	}

	public JPanel getBoard3() {
		return board3;
	}

	public void setBoard3(JPanel board3) {
		this.board3 = board3;
	}

	public JPanel getBoard4() {
		return board4;
	}

	public void setBoard4(JPanel board4) {
		this.board4 = board4;
	}

	public JPanel getMenu() {
		return menu;
	}

	public void setMenu(JPanel menu) {
		this.menu = menu;
	}

	public JButton getRed() {
		return red;
	}

	public void setRed(JButton red) {
		this.red = red;
	}

	public JButton getGreen() {
		return green;
	}

	public void setGreen(JButton green) {
		this.green = green;
	}

	public JButton getBlue() {
		return blue;
	}

	public void setBlue(JButton blue) {
		this.blue = blue;
	}

	public JButton getYellow() {
		return yellow;
	}

	public void setYellow(JButton yellow) {
		this.yellow = yellow;
	}

	public JButton getBlack() {
		return black;
	}

	public void setBlack(JButton black) {
		this.black = black;
	}

	public JButton getDice() {
		return dice;
	}

	public void setDice(JButton dice) {
		this.dice = dice;
	}

	public static JTextArea getInfo() {
		return info;
	}

	public void setInfo(JTextArea info) {
		this.info = info;
	}

	public JTextArea getBufferArea() {
		return bufferArea;
	}

	public void setBufferArea(JTextArea bufferArea) {
		this.bufferArea = bufferArea;
	}

	public static ArrayList<JButton> getPieces() {
		return pieces;
	}

	public void setPieces(ArrayList<JButton> pieces) {
		this.pieces = pieces;
	}

	public ArrayList<JButton> getTiles() {
		return tiles;
	}

	public void setTiles(ArrayList<JButton> tiles) {
		this.tiles = tiles;
	}

	public ArrayList<JButton> getBorder() {
		return border;
	}

	public void setBorder(ArrayList<JButton> border) {
		this.border = border;
	}

	public ArrayList<JTextArea> getBuffer() {
		return buffer;
	}

	public void setBuffer(ArrayList<JTextArea> buffer) {
		this.buffer = buffer;
	}

	public static void setRollDice(JButton rollDice) {
		LudoGUI.rollDice = rollDice;
	}

	public static void setRoll(int roll) {
		LudoGUI.roll = roll;
	}

	public static void main(String[] args) {
		LudoGUI simplegui = new LudoGUI();
        
        simplegui.setTitle("Ludo"); 
        simplegui.setSize(1350,990);    
        simplegui.setResizable(false);   
		simplegui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        simplegui.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == rollDice) {
    		roll = game.TestClient.diceRoll();
    		rollDice.setEnabled(false);
	   		TestClient.enabled(TestClient.player);	
    	}
    		
//    		String text = info.getText();
//    		if(text.startsWith("player1")) {
//    			if(roll <= 6) {
//    				info.setText("You may move all your pieces");
//    				for(int i = 0; i <= 3; i++) {
//    					JButton button = pieces.get(i);
//    					button.setEnabled(true);
//    				}
//    			} else if(buttonval(pieces.get(0)) == -1 && buttonval(pieces.get(1)) == -1
//    					&& buttonval(pieces.get(2)) == -1 && buttonval(pieces.get(3)) == -1) {
//    				if(counter < 3) {
//    	   				info.setText("You must get a 6 to leave the starting area, please roll again");
//        				counter++;
//        				rollDice.setEnabled(true);
//    				} else {
//    					info.setText("player2's turn");
//    					for(int i = 4; i <= 7; i++) {
//    						JButton button = pieces.get(i);
//    						button.setEnabled(false);
//    					}
//    		    		rollDice.setEnabled(true);
//    				}
//    			} else {
//    				info.setText("You can only move the pieces, which are outside your starting area");
//    				for(int i = 0; i <= 3; i++) {
//    					JButton button = pieces.get(i);
//    					if(buttonval(button) => 0) {
//    						button.setEnabled(true);
//    					}
//    				}
//    			}
//    		}
//    		
//    		if(text.startsWith("player2")) {
//    			if(roll == 6) {
//    				info.setText("You may move all your pieces");
//    				for(int i = 4; i <= 7; i++) {
//    					JButton button = pieces.get(i);
//    					button.setEnabled(true);
//    				}
//    			} else if(buttonval(pieces.get(4)) == -1 && buttonval(pieces.get(5)) == -1
//    					&& buttonval(pieces.get(6)) == -1 && buttonval(pieces.get(7)) == -1) {
//    				if(counter < 3) {
//    	   				info.setText("You must get a 6 to leave the starting area, please roll again");
//        				counter++;
//        				rollDice.setEnabled(true);
//    				} else {
//    					info.setText("player3's turn");
//    					for(int i = 8; i <= 11; i++) {
//    						JButton button = pieces.get(i);
//    						button.setEnabled(false);
//    					}
//    		    		rollDice.setEnabled(true);
//    				}
//    			} else {
//    				info.setText("You can only move the pieces, which are outside your starting area");
//    				for(int i = 4; i <= 7; i++) {
//    					JButton button = pieces.get(i);
//    					if(buttonval => 0) {
//    						button.setEnabled(true);
//    					}
//    				}
//    			}
//    		}
//    		
//    		if(text.startsWith("player3")) {
//    			if(roll == 6) {
//    				info.setText("You may move all your pieces");
//    				for(int i = 8; i <= 11; i++) {
//    					JButton button = pieces.get(i);
//    					button.setEnabled(true);
//    				}
//    			} else if(buttonval(pieces.get(8)) == -1 && buttonval(pieces.get(9)) == -1
//    					&& buttonval(pieces.get(10)) == -1 && buttonval(pieces.get(11)) == -1) {
//    				if(counter < 3) {
//    	   				info.setText("You must get a 6 to leave the starting area, please roll again");
//        				counter++;
//        				rollDice.setEnabled(true);
//    				} else {
//    					info.setText("player4's turn");
//    					for(int i = 12; i <= 15; i++) {
//    						JButton button = pieces.get(i);
//    						button.setEnabled(false);
//    					}
//    		    		rollDice.setEnabled(true);
//    				}
//    			} else {
//    				info.setText("You can only move the pieces, which are outside your starting area");
//    				for(int i = 8; i <= 11; i++) {
//    					JButton button = pieces.get(i);
//    					if(buttonval => 0) {
//    						button.setEnabled(true);
//    					}
//    				}
//    			}
//    		}
//    		
//    		if(text.startsWith("player4")) {
//    			if(roll == 6) {
//    				info.setText("You may move all your pieces");
//    				for(int i = 12; i <= 15; i++) {
//    					JButton button = pieces.get(i);
//    					button.setEnabled(true);
//    				}
//    			} else if(buttonval(pieces.get(12)) == -1 && buttonval(pieces.get(13)) == -1
//    					&& buttonval(pieces.get(14)) == -1 && buttonval(pieces.get(15)) == -1) {
//    				if(counter < 3) {
//    	   				info.setText("You must get a 6 to leave the starting area, please roll again");
//        				counter++;
//        				rollDice.setEnabled(true);
//    				} else {
//    					info.setText("player1's turn");
//    					for(int i = 0; i <= 3; i++) {
//    						JButton button = pieces.get(i);
//    						button.setEnabled(false);
//    					}
//    		    		rollDice.setEnabled(true);
//    				}
//    			} else {
//    				info.setText("You can only move the pieces, which are outside your starting area");
//    				for(int i = 12; i <= 15; i++) {
//    					JButton button = pieces.get(i);
//    					if(buttonval => 0) {
//    						button.setEnabled(true);
//    					}
//    				}
//    			}
//    		}
//    	}
    	
    	if (e.getSource() == pieces.get(0)) {
    		TestClient.setSelected(position.get(0));
    		TestClient.setSelectedIndex(0);
   			for(JButton piece : pieces) {
   				piece.setEnabled(false);
   			}
   			
   			try {
				TestClient.sendPos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		//functionality
//    		info.setText("player2's turn");
//			for(int i = 0; i <= 3; i++) {
//				JButton button = pieces.get(i);
//				button.setEnabled(false);
//			}
//    		rollDice.setEnabled(true);
    	}
    	
    	if (e.getSource() == pieces.get(1)) {
    		//functionality
    		TestClient.setSelected(position.get(1));
    		TestClient.setSelectedIndex(1);
    		for(JButton piece : pieces) {
   				piece.setEnabled(false);
   			}
    		
   			try {
				TestClient.sendPos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    	if (e.getSource() == pieces.get(2)) {
    		//functionality
    		TestClient.setSelected(position.get(2));
    		TestClient.setSelectedIndex(2);
    		for(JButton piece : pieces) {
   				piece.setEnabled(false);
   			}
    		
   			try {
				TestClient.sendPos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    	if (e.getSource() == pieces.get(3)) {
    		//functionality
    		TestClient.setSelected(position.get(3));
    		TestClient.setSelectedIndex(3);
    		for(JButton piece : pieces) {
   				piece.setEnabled(false);
   			}
    		
   			try {
				TestClient.sendPos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    	if (e.getSource() == pieces.get(4)) {
    		//functionality
    		TestClient.setSelected(position.get(4));
    		TestClient.setSelectedIndex(4);
    		for(JButton piece : pieces) {
   				piece.setEnabled(false);
   			}
    		
   			try {
				TestClient.sendPos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    	if (e.getSource() == pieces.get(5)) {
    		//functionality
    		TestClient.setSelected(position.get(5));
    		TestClient.setSelectedIndex(5);
    		for(JButton piece : pieces) {
   				piece.setEnabled(false);
   			}
    		
   			try {
				TestClient.sendPos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    	if (e.getSource() == pieces.get(6)) {
    		//functionality
    		TestClient.setSelected(position.get(6));
    		TestClient.setSelectedIndex(6);
    		for(JButton piece : pieces) {
   				piece.setEnabled(false);
   			}
    		
   			try {
				TestClient.sendPos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    	if (e.getSource() == pieces.get(7)) {
    		//functionality
    		TestClient.setSelected(position.get(7));
    		TestClient.setSelectedIndex(7);
    		for(JButton piece : pieces) {
   				piece.setEnabled(false);
   			}
    		
   			try {
				TestClient.sendPos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    	if (e.getSource() == pieces.get(8)) {
    		//functionality
    		TestClient.setSelected(position.get(8));
    		TestClient.setSelectedIndex(8);
    		for(JButton piece : pieces) {
   				piece.setEnabled(false);
   			}
    		
   			try {
				TestClient.sendPos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    	if (e.getSource() == pieces.get(9)) {
    		//functionality
    		TestClient.setSelected(position.get(9));
    		TestClient.setSelectedIndex(9);
    		for(JButton piece : pieces) {
   				piece.setEnabled(false);
   			}
    		
   			try {
				TestClient.sendPos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    	if (e.getSource() == pieces.get(10)) {
    		//functionality
    		TestClient.setSelected(position.get(10));
    		TestClient.setSelectedIndex(10);
    		for(JButton piece : pieces) {
   				piece.setEnabled(false);
   			}
    		
   			try {
				TestClient.sendPos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    	if (e.getSource() == pieces.get(11)) {
    		//functionality
    		TestClient.setSelected(position.get(11));
    		TestClient.setSelectedIndex(11);
    		for(JButton piece : pieces) {
   				piece.setEnabled(false);
   			}
    		
   			try {
				TestClient.sendPos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    	if (e.getSource() == pieces.get(12)) {
    		//functionality
    		TestClient.setSelected(position.get(12));
    		TestClient.setSelectedIndex(12);
    		for(JButton piece : pieces) {
   				piece.setEnabled(false);
   			}
    		
   			try {
				TestClient.sendPos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    	if (e.getSource() == pieces.get(13)) {
    		//functionality
    		TestClient.setSelected(position.get(13));
    		TestClient.setSelectedIndex(13);
    		for(JButton piece : pieces) {
   				piece.setEnabled(false);
   			}
    		
   			try {
				TestClient.sendPos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    	if (e.getSource() == pieces.get(14)) {
    		//functionality
    		TestClient.setSelected(position.get(14));
    		TestClient.setSelectedIndex(14);
    		for(JButton piece : pieces) {
   				piece.setEnabled(false);
   			}
    		
   			try {
				TestClient.sendPos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    	if (e.getSource() == pieces.get(15)) {
    		//functionality
    		TestClient.setSelected(position.get(15));
    		TestClient.setSelectedIndex(15);
    		for(JButton piece : pieces) {
   				piece.setEnabled(false);
   			}
    		
   			try {
				TestClient.sendPos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
	} 
}
