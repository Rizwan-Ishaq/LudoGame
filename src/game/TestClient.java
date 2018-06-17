package game;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.LudoGUI;

public class TestClient {
	
	private static String host = "127.0.0.1";
	private static final int PORT = 1337;
	static BufferedReader clientIn;
    static PrintWriter clientOut;
    private static ArrayList<String> messages = new ArrayList<String>();
    private static String playerNumber;
    private static String playerColor;
    private static String playerTurn;
    private static String player1Pos;
    private static String player2Pos;
    private static String player3Pos;
    private static String player4Pos;
	private static String currPlayer;
	public static String player;
	public static int selected;
	public static int selectedIndex;

	public static void conn() throws IOException {
		Socket socket = new Socket(host, PORT);
		
		clientIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    clientOut = new PrintWriter(socket.getOutputStream(), true);
	    
	    while(true) {
		   	if(clientIn.readLine().startsWith(("GAME HAS STARTED"))) {
			   	player = clientIn.readLine();
			   	LudoGUI.getInfo().setText(player);
		   		LudoGUI.getRollDice().setEnabled(true);
		   		currPlayer = clientIn.readLine();
		   	}
	    }
	}
	
	public static void sendPos() throws IOException {
   		if(MyIP().equals(currPlayer)) {
   			clientOut.print(LudoGUI.getRoll());
   			clientOut.print(selectedIndex);
   			clientOut.print(selected);
   		}
	}
	
	public static void enabled(String player) {
		if(player.startsWith("player1")) {
	   		for(int i = 0; i < 4; i++) {
		   		LudoGUI.getPieces().get(i).setEnabled(true);
	   		}
		}
		
		if(player.startsWith("player2")) {
	   		for(int i = 4; i < 8; i++) {
		   		LudoGUI.getPieces().get(i).setEnabled(true);
	   		}
		}
		
		if(player.startsWith("player3")) {
	   		for(int i = 8; i < 12; i++) {
		   		LudoGUI.getPieces().get(i).setEnabled(true);
	   		}
		}
		
		if(player.startsWith("player4")) {
	   		for(int i = 12; i < 16; i++) {
		   		LudoGUI.getPieces().get(i).setEnabled(true);
	   		}
		}
	}

	private static String MyIP() throws IOException {
	    URL whatismyip = new URL("http://checkip.amazonaws.com");
	    BufferedReader in = new BufferedReader(new InputStreamReader(
	                    whatismyip.openStream()));

	    String ip = in.readLine();
	    return ip;
	}
	
	public static int getSelectedIndex() {
		return selectedIndex;
	}

	public static void setSelectedIndex(int selectedIndex) {
		TestClient.selectedIndex = selectedIndex;
	}

	public static int getSelected() {
		return selected;
	}

	public static void setSelected(int selected) {
		TestClient.selected = selected;
	}

	public static void main(String[] args) throws IOException{
		LudoGUI simplegui = new LudoGUI();
        
        simplegui.setTitle("Ludo"); 
        simplegui.setSize(1350,990);    
        simplegui.setResizable(false);   
		simplegui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        simplegui.setVisible(true);
        
		TestClient.conn();
	}
	
	public static int diceRoll() {
		Random diceVal = new Random();
		return diceVal.nextInt(6)+1;
		
	}
}


