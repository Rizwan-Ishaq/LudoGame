package game;
import java.io.*;
import java.net.*;
import java.util.Random;

public class TestClient {
	
	private static String host = "127.0.0.1";
	private static final int PORT = 1337;
	static BufferedReader in;
    static PrintWriter out;
	
	public static void conn() throws IOException {
		Socket socket = new Socket(host, PORT);
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    out = new PrintWriter(socket.getOutputStream(), true);
	    
	    while(true) {
	    	String message = in.readLine();
	    	if (!(message == null)) {
	    		System.out.println(message);
	    	}
	    	
	    	// SPLIT MESSAGE
	    	// IF SÆTNING SOM TJEKKER SPLITTET MESSAGE
	    	// INDE I IF SÆTNING ER DER METODEKALD TIL DE FORSKELLIGE HANDLINGER
	    	// DER SKAL SKE VED SPECIFIKKE PROTOKOLKALD
	    	// EN METODE FOR HVER HANDLING
	    }
		
	}
	
	public static void main(String[] args) throws IOException{
		TestClient.conn();
//		System.out.println(diceRoll());
//		System.out.println(diceRoll());
//		System.out.println(diceRoll());
//		System.out.println(diceRoll());
	}
}
