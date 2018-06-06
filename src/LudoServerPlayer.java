
public class LudoServerPlayer {
	
	private String playerIP;
	private int playerID;
	private static int id = 1;
	

	public LudoServerPlayer(String playerIP) {
		this.setPlayerIP(playerIP);
		this.playerID = id++;
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
}
