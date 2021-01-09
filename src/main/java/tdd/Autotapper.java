package tdd;

import tdd.Card.CardWithCost;

public class Autotapper {

	public static Response tapper(Board board, CardWithCost card) {
		boolean isCastable;
		Board newBoard = board.valueOf();
		String manaCost = TransformManaCost.transform(card.getCost());
		for (int i = 0; i < manaCost.length(); i++) {
			String symbol = String.valueOf(manaCost.charAt(i));
			if(!board.canGenerate(card, symbol)) {
				isCastable = false;
				return createResponse(isCastable, newBoard);				
			}
			newBoard.tap(card, symbol);			
		}
		isCastable = true;
		return createResponse(isCastable, newBoard.valueOf());	
	}
	
	private static Response createResponse(boolean isCastable, Board board) {
		return new Response(isCastable, board);
	}
	
}
