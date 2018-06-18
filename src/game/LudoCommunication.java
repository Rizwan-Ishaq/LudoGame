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
	
	public Socket commSocket;
	public String diceRoll;

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
		serverOut.println(player.getPlayerIP());
		
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
		broadcastOutput("GAME HAS STARTED");
		int i = 0;
		while(!winnerFound == true) {
			int playernumber = 1;
			LudoServer.playerPrintWriters.get(i).println(("player" + playernumber + "'s turn"));
			broadcastOutput(LudoServer.serverPlayers.get(i).getPlayerIP());
			System.out.println(serverIn.readLine());
			System.out.println(serverIn.readLine());
			System.out.println(serverIn.readLine());
			System.out.println(serverIn.readLine());
			System.out.println(serverIn.readLine());
			diceRoll = serverIn.readLine();
			
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
				playernumber = 1;
			} else {
				i++;
				playernumber++;
			}
		}
	}

	private void playerFour(String eyes) throws IOException {
		System.out.println(positionIn());
	}

	private void playerThree(String eyes) throws IOException {
		System.out.println(positionIn());
	}

	private void playerTwo(String eyes) throws IOException {
		System.out.println(positionIn());
	}

	private void playerOne(String eyes) throws IOException {
		System.out.println(positionIn());
	}

	private String positionIn() throws IOException {
		String pos = "(" + serverIn.read() + "," + serverIn.read() + ")";
		return pos;
	}

	private void diceHandler() {
		
	}
}