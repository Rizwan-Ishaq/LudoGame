package game;
import java.io.*;
import java.net.Socket;

public class LudoCommunication extends Thread{
	BufferedReader input;
    PrintWriter output;
	InputStream in;
	OutputStream out;
	String playerIP;
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
					break;
				}
			}
			
			LudoServer.playerPrintWriters.add(output);
			
			if (LudoServer.serverPlayers.size() == 4) {
				gameLobbyStart();
			}
		} catch (IOException e) {
			
		}
	}
	
	public void playerConnection() {
		String playerIP = commSocket.getRemoteSocketAddress().toString();

		LudoServerPlayer player = new LudoServerPlayer(playerIP);
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
	
	private void gameLobbyStart() {
		for(PrintWriter output : LudoServer.playerPrintWriters) {
			output.println("GAME LOBBY FULL - STARTING GAME NOW");
		}
	}
}
