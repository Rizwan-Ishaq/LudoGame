package gui;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LudoClient {
	public JPanel board1, board2, board3, board4;
	public JPanel menu;
	public JButton red, green, blue, yellow, black;
	public static JButton rollDice;
	public JButton dice;
	public static JTextArea info;
	public JTextArea bufferArea;
	public static int roll;
	public ArrayList<JButton> pieces = new ArrayList<JButton>();
	public ArrayList<JButton> tiles = new ArrayList<JButton>();
	public ArrayList<JButton> border = new ArrayList<JButton>();
	public ArrayList<JTextArea> buffer = new ArrayList<JTextArea>();
	
	public void buffer() {
		for(int i = 0; i < 11; i++) {
			bufferArea = new JTextArea();
			buffer.add(bufferArea);
		}
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
	public static JButton getRollDice() {
		return rollDice;
	}
	public static void setRollDice(JButton rollDice) {
		LudoClient.rollDice = rollDice;
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
	public static void setInfo(JTextArea info) {
		LudoClient.info = info;
	}
	public JTextArea getBufferArea() {
		return bufferArea;
	}
	public void setBufferArea(JTextArea bufferArea) {
		this.bufferArea = bufferArea;
	}
	public static int getRoll() {
		return roll;
	}
	public static void setRoll(int roll) {
		LudoClient.roll = roll;
	}
	public ArrayList<JButton> getPieces() {
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
}
