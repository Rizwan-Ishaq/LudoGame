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
					String playerIP = commSocket.getRemoteSocketAddress().toString();
					LudoServerPlayer player = new LudoServerPlayer(playerIP);
					LudoServer.serverPlayers.add(player);
					output.println("SUCCESSFULLY CONNECTED TO GAME");
					output.println("YOU ARE PLAYER " + player.getPlayerID());
				} else if (LudoServer.serverPlayers.size() == 4) {
					output.println("GAME ALREADY IN PROGRESS");
				}
				
				LudoServer.playerPrintWriters.add(output);
				
				if (LudoServer.serverPlayers.size() == 4) {
					output.println("GAME FULL - STARTING GAME NOW");
				}
			}
		} catch (IOException e) {
			
		}
	}
		
		
		
//		LudoServerPlayer testPlayer = new LudoServerPlayer("192.168.10.2");
//		LudoServerPlayer testPlayer2 = new LudoServerPlayer("192.168.10.3");
//		
//		System.out.println(testPlayer.getPlayerID());
//		System.out.println(testPlayer2.getPlayerID());
//		
	}
