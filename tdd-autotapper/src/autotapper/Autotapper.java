package autotapper;

public class Autotapper {
	
	public static boolean tapper(Board board, String cardManaCost) {
		if(board.canGenerate(cardManaCost)) {
			board.tap(cardManaCost);
			return true;
		}
		return false;		
	}

}
