package game;

import java.net.*;
import java.io.*;
import java.util.*;

public class LudoServer{
	static ServerSocket connection;
	static final int PORT = 1337;
    static ArrayList<LudoServerPlayer> serverPlayers = new ArrayList<LudoServerPlayer>();
    static ArrayList<PrintWriter> playerPrintWriters = new ArrayList<PrintWriter>();
	
	public static void main(String[] args) throws IOException {
		connection = new ServerSocket(PORT);
		System.out.println("STARTING SERVER SOCKET...");
		System.out.println("SERVER SOCKET RUNNING...");
		System.out.println("SERVER LISTENING ON PORT " + PORT);
		
//		LudoServerPlayer testPlayer = new LudoServerPlayer("192.168.10.2");
//		LudoServerPlayer testPlayer2 = new LudoServerPlayer("192.168.10.3");
//		LudoServerPlayer testPlayer3 = new LudoServerPlayer("192.168.10.4");
//		LudoServerPlayer testPlayer4 = new LudoServerPlayer("192.168.10.5");
//		
//		
//		System.out.println(testPlayer.getPlayerID());
//		System.out.println(testPlayer2.getPlayerID());
		
		
		while (true) {
            new LudoCommunication(connection.accept()).start();
        }
	}
}
