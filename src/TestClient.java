import java.io.*;
import java.net.*;

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
	    	System.out.println(message);
	    }
		
	}
	
	public static void main(String[] args) throws IOException{
		TestClient.conn();
	}
}
