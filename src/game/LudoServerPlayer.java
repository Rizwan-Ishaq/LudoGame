package game;

public class LudoServerPlayer {
	
	private String playerIP;
	private int playerID;
	private static int id = 1;
	private String playerColor;
	private int currPos;
	private int winPos;
	private static String[] colors = {"Yellow","Green","Blue","Red"};
	private static int[] endPos = {20,40,60,80};
	private static int[] startPos = {1,21,41,61};
	private static int counter = 0;

	public LudoServerPlayer(String playerIP) {
		this.setPlayerIP(playerIP);
		
		this.playerID = id;
		id++;
		
		this.playerColor = colors[counter];		
		this.currPos = startPos[counter];
		this.winPos = endPos[counter];
		
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
	
	public int getCurrPos() {
		return currPos;
	}
	
	public void setCurrPos(int diceVal) {
		this.currPos = currPos + diceVal;
	}


	public int getWinPos() {
		return winPos;
	}
}
