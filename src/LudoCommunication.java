import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class LudoCommunication extends Thread{
	BufferedReader input;
    PrintWriter output;
	InputStream in;
	OutputStream out;
	String playerIP;
	int winnerPlayer;
	LudoServerPlayer player;
	Boolean winnerFound = false;
	String diceRollString;
	ArrayList<String> messages = new ArrayList<String>();
	//String clientInput
	
	private Socket commSocket;

	public LudoCommunication(Socket commSocket) {
		this.commSocket = commSocket;
	}
	
	public void run( ) {
		try {
			input = new BufferedReader(new InputStreamReader(commSocket.getInputStream()));
			output = new PrintWriter(commSocket.getOutputStream(), true);
			
			while(true) {
					    		
				
				if (LudoServer.serverPlayers.size() < 4) {
					playerConnection();
					break;
				} else {					
					retryConnection();
				}
				
			}
			
			LudoServer.playerPrintWriters.add(output);
			while (true ) {			
				if (LudoServer.serverPlayers.size() == 4) {
					gameStart();
				}
			}
		} catch (IOException e) {
			
		}
	}
	
	public void playerConnection() {
		String playerIP = commSocket.getRemoteSocketAddress().toString();

		player = new LudoServerPlayer(playerIP);
		LudoServer.serverPlayers.add(player);
		
		output.println("SUCCESSFULLY CONNECTED TO GAME");
		output.println("YOU ARE PLAYER " + player.getPlayerID() + " with color " + player.getPlayerColor());
		
		//BUG TESTING
		System.out.println(LudoServer.serverPlayers.size());
		System.out.println("player " + player.getPlayerID() + " ip address:" );
		System.out.println("	" + player.getPlayerIP());
		System.out.println("player " + player.getPlayerID() + " is " + player.getPlayerColor());
		
		
		
	}
	
	private void retryConnection() throws IOException {
		output.println("GAME ALREADY IN PROGRESS");
		output.close();
		commSocket.close();
	}	
	
	private void broadcastOutput(String message) {
		for(PrintWriter output : LudoServer.playerPrintWriters) {
			output.println(message);
		}
	}
	
	private void gameStart() throws IOException {
		broadcastOutput("GAME LOBBY FULL - STARTING GAME NOW");
		while(!winnerFound == true) {
			
			
	    	
			System.out.println("WHILE LOOP");
			for (int i = 1; i<=4; i++) {
				System.out.println("FOR LOOP");
				broadcastOutput("DICE ROLL PLAYER " + i);
				System.out.println("input read line: " + input.readLine());
				if (diceRollString.startsWith("DICE ROLL VALUE")) {
					System.out.println(diceRollString);
					int diceVal = Integer.valueOf(diceRollString.substring(16));
					
					player.setCurrPos(diceVal);
					
					System.out.println(diceVal);
					
					output.println("NEW POS PLAYER " + player.getPlayerID() + " " + player.getCurrPos());
					
					System.out.println("NEW POS PLAYER");
					
					if (player.getCurrPos() == player.getWinPos()) {
						winnerPlayer = player.getPlayerID();
						winnerFound = true;
						break;
					}	
		    		
		    	} else {
		    		System.out.println("diceRollString error");
		    	}
		    	
				
			}
		}
		
		broadcastOutput("GAME ENDED - PLAYER " + winnerPlayer + " WON THE GAME");
	}
}
