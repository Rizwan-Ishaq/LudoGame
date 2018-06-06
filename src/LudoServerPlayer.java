
public class LudoServerPlayer {
	
	private String playerIP;
	private int playerID;
	private static int id = 0;
	

	public LudoServerPlayer(String playerIP) {
		this.playerIP = playerIP;
		this.playerID = id++;
	}


	public int getPlayerID() {
		return playerID;
	}


	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
}
