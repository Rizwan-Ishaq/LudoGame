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
    private static String playerTurn;
    private static String player1Pos;
    private static String player2Pos;
    private static String player3Pos;
    private static String player4Pos;
    
    
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
	    		
//	    		if(messages.get(0).equals("GAME ALREADY IN PROGRESS")) {
//	    			// SEND EN BESKED TIL SPILLERN SÅ HAN VED AT SPILLET ER I GANG
//	    			 	in.close();
//	    			 	out.close();
//	    			 	socket.close();
//	    		}
	    		
	    		if(messages.get(0).equals("SUCCESSFULLY CONNECTED TO GAME") & messages.size() >= 2) {
	    			playerNumber = messages.get(1).substring(15,16);
	    			playerColor = messages.get(1).substring(28);
	    			
	    			if(messages.size() >= 3) {
	    				if(messages.get(2).equals("GAME LOBBY FULL - STARTING GAME NOW")){
	    					if(messages.size() >= 4) {
	    						System.out.println("messages size 4");
			    				for (int i = 3; i <= messages.size(); i++) {
			    					//System.out.println(i + " " + messages.size() + " " + messages.get(i));
			    					if (messages.get(i).startsWith("DICE ROLL")) {
			    						playerTurn = messages.get(i).substring(17);
			    						System.out.println("Player turn " + playerTurn);
			    						if (playerTurn.equals(playerNumber)) {
			    							System.out.println("Dice Roll");
			    							
				    						out.println("DICE ROLL VALUE " + diceRoll() +"\n");
				    						System.out.println("after message");
				    					} else {
				    						//SEND BESKED TIL SPILLEREN OM AT DET IKKE ER HANS TUR ENDNU
				    						System.out.println("It is player " + playerTurn + "s turn" );
				    					}
			    					} else if (messages.get(i).startsWith("NEW POS")) {
			    						String playerPosChanged = messages.get(i).substring(15, 16);
			    						System.out.println("Player Pos changed " + playerPosChanged);
			    						String newPosVal = messages.get(i).substring(18);
			    						System.out.println("New position value " + newPosVal);
			    						
			    						if (playerPosChanged.equals("1")) {
			    							player1Pos = newPosVal;
			    						} else if (playerPosChanged.equals("2")) {
			    							player2Pos = newPosVal;
			    						} else if (playerPosChanged.equals("3")) {
			    							player3Pos = newPosVal;
			    						} else if (playerPosChanged.equals("4")) {
			    							player4Pos = newPosVal;
			    						}
			       					}
			    				}
	    					}
	    				}
	    			}
	    		}
	    	}
	    }
	}
	   
//	    			
	    	
	
	    	// SPLIT MESSAGE
	    	// IF SÆTNING SOM TJEKKER SPLITTET MESSAGE
	    	// INDE I IF SÆTNING ER DER METODEKALD TIL DE FORSKELLIGE HANDLINGER
	    	// DER SKAL SKE VED SPECIFIKKE PROTOKOLKALD
	    	// EN METODE FOR HVER HANDLING
	
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
