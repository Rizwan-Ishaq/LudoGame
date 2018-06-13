package game;
import java.util.Random;

public class DiceRoll {
	
	public DiceRoll() {
		
	}
	
	public static int diceRoll() {
		Random diceVal = new Random();
		return diceVal.nextInt(6)+1;
	}
}
