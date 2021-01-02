package tdd;

public class Autotapper {
	
	public static Response tapper(Board board, String cardManaCost) {
		boolean isCastable;
		Board newBoard = board.valueOf();
		String manaCost = TransformManaCost.transform(cardManaCost);
		for (int i = 0; i < manaCost.length(); i++) {
			String symbol = String.valueOf(manaCost.charAt(i));
			if(!board.canGenerate(symbol)) {
				isCastable = false;
				return createResponse(isCastable, newBoard);				
			}
			newBoard.tap(symbol);			
		}
		isCastable = true;
		return createResponse(isCastable, newBoard.valueOf());		
	}
	
	private static Response createResponse(boolean isCastable, Board board) {
		return new Response(isCastable, board);
	}
	
}
