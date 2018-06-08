
public class LudoServerPlayer {
	
	private String playerIP;
	private int playerID;
	private static int id = 1;
	private String playerColor;
	private static String[] colors = {"Yellow","Green","Blue","Red"};
	private static int counter = 0;
	
	

	public LudoServerPlayer(String playerIP) {
		this.setPlayerIP(playerIP);
		
		this.playerID = id;
		id++;
		
		this.playerColor = colors[counter];
		counter++;
	}


	public int getPlayerID() {
		return playerID;
	}


	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}


	public String getPlayerIP() {
		return playerIP;
	}


	public void setPlayerIP(String playerIP) {
		this.playerIP = playerIP;
	}


	public String getPlayerColor() {
		return playerColor;
	}
}
