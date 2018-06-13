import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Random;

public class TestClient {
	
	private static String host = "127.0.0.1";
	private static final int PORT = 1337;
	static BufferedReader in;
    static PrintWriter out;
    private static ArrayList<String> messages = new ArrayList<String>();
    private static String playerNumber;
    private static String playerColor;
    
    
	public static void conn() throws IOException {
		Socket socket = new Socket(host, PORT);
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    out = new PrintWriter(socket.getOutputStream(), true);
	    
	    while(true) {
	    	String message = in.readLine();
	    	if (!(message == null)) {
	    		System.out.println(message);
	    		if(!(messages.contains(message))){
	    			messages.add(message);
	    		}
	    		if(messages.get(0).equals("SUCCESSFULLY CONNECTED TO GAME")) {
	    			playerNumber = messages.get(1).substring(14,16);
	    			playerColor = messages.get(1).substring(28);
	    		}
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
	
	public static int diceRoll() {
		Random diceVal = new Random();
		return diceVal.nextInt(6)+1;
		
	}
}
