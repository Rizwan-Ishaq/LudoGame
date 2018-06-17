package game;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;

import gui.LudoGUI;

public class LudoCommunication extends Thread{
	BufferedReader serverIn;
    PrintWriter serverOut;
	String playerIP;
	int winnerPlayer;
	LudoServerPlayer player;
	Boolean winnerFound = false;
	String diceRollString;
	LudoServerPlayer currPlayer;
	
	private Socket commSocket;
private int diceRoll;

	public LudoCommunication(Socket commSocket) {
		this.commSocket = commSocket;
	}
	
	public void run( ) {
		try {
			serverIn = new BufferedReader(new InputStreamReader(commSocket.getInputStream()));
			serverOut = new PrintWriter(commSocket.getOutputStream(), true);
			
			while(true) {
					    		
				
				if (LudoServer.serverPlayers.size() < 4) {
					playerConnection();
					break;
				} else {					
					retryConnection();
				}
				
			}
			
			LudoServer.playerPrintWriters.add(serverOut);	
				if (LudoServer.serverPlayers.size() == 4) {
					gameStart();
				}
		} catch (IOException e) {
			
		}
	}
	
	public void playerConnection() throws IOException {
		String playerIP = commSocket.getRemoteSocketAddress().toString();

		player = new LudoServerPlayer(playerIP);
		LudoServer.serverPlayers.add(player);
		
		serverOut.println("SUCCESSFULLY CONNECTED TO GAME");
		serverOut.println("YOU ARE PLAYER " + player.getPlayerID() + " with color " + player.getPlayerColor());
		
		System.out.println(LudoServer.serverPlayers.size());
		System.out.println("player " + player.getPlayerID() + " ip address:" );
		System.out.println("	" + player.getPlayerIP());
		System.out.println("player " + player.getPlayerID() + " is " + player.getPlayerColor());
		
		
		
	}
	
	private void retryConnection() throws IOException {
		serverOut.println("GAME ALREADY IN PROGRESS");
		serverOut.close();
		commSocket.close();
	}	
	
	private void broadcastOutput(String message) {
		for(PrintWriter broadcastOut : LudoServer.playerPrintWriters) {
			broadcastOut.println(message);
		}
	}
	
	private void gameStart() throws IOException {
		while(true) {
			int i = 0;
			while(winnerFound = false) {
				broadcastOutput("GAME HAS STARTED");
				broadcastOutput("player" + i + 1 + "'s turn");
				broadcastOutput(LudoServer.serverPlayers.get(0).getPlayerIP());
				diceRoll = serverIn.read();
				
				if(i == 0) {
					playerOne(diceRoll);
				}
			
				if(i == 1) {
					playerTwo(diceRoll);
				}
			
				if(i == 2) {
					playerThree(diceRoll);
				}
			
				if(i == 3) {
					playerFour(diceRoll);
				}
				
				if(i == 3) {
					i = 0;
				} else {
					i++;
				}
			}
		}
	}

	private void playerFour(int eyes) throws IOException {
		System.out.println(positionIn());
	}

	private void playerThree(int eyes) throws IOException {
		System.out.println(positionIn());
	}

	private void playerTwo(int eyes) throws IOException {
		System.out.println(positionIn());
	}

	private void playerOne(int eyes) throws IOException {
		System.out.println(positionIn());
	}

	private String positionIn() throws IOException {
		String pos = "(" + serverIn.read() + "," + serverIn.read() + ")";
		return pos;
	}

	private void diceHandler() {
		
	}
}