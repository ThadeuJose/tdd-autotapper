package tdd;

import static org.junit.Assert.*;

import org.junit.Test;

import tdd.Card.Card;
import tdd.Card.CardGenerateAny;
import tdd.Card.CardGenerateOneColor;
import tdd.Card.CardWithCost;

public class BoardTests {

	Card genericCard = new CardGenerateOneColor("G","G");

	@Test
	public void testToString() {
		Board board = new Board(); 
		board.add(genericCard);
		String logResult = "Untapped: G";
		assertEquals(board.toString(), logResult);
	}
	
	@Test
	public void testEmptyToString() {
		Board board = new Board(); 
		String logResult = "";
		assertEquals(board.toString(), logResult);
	}

	@Test
	public void testValueOfAdd() {
		String message = "Test if Value of create a deep copy of board";
		Board board1 = new Board(); 
		board1.add(genericCard);
		Board board2 = board1.valueOf();
		board2.add(genericCard);
		String logResult1 = "Untapped: G";
		String logResult2 = "Untapped: G G";
		assertEquals(message, board1.toString() + board2.toString(), logResult1 + logResult2);
	}
	
	@Test
	public void testValueOfAllTap() {
		String message = "Test if Value of create a deep copy of board";
		Board board1 = new Board(); 
		board1.add(genericCard);
		board1.add(genericCard);
		Board board2 = board1.valueOf();
		CardWithCost c = new CardWithCost("CardId","G");
		board2.tap(c, c.getCost());
		board2.tap(c, c.getCost());
		String logResult1 = "Untapped: G G";
		String logResult2 = "Tapped: G G";
		assertEquals(message, board1.toString() + board2.toString(), logResult1 + logResult2);
	}
	
	@Test
	public void testTap() {
		String message = "Tap card who generate G";
		Board board = new Board(); 
		board.add(genericCard);
		board.add(new CardGenerateOneColor("R", "R"));
		CardWithCost c = new CardWithCost("CardId","G");
		board.tap(c, c.getCost());
		String logResult = "Tapped: G Untapped: R";
		assertEquals(message, board.toString(), logResult);
	}

	@Test
	public void testGenerateCard() {
		Board board = new Board(); 
		Card cardC = new CardGenerateOneColor("C", "C");		
		board.add(cardC);

		CardWithCost card = new CardWithCost("Artifact","C");
		String symbol = card.getCost();

		assertTrue(board.canGenerate(card, symbol));
	}

	@Test
	public void testNotGenerateCard() {
		Board board = new Board(); 		
		Card cardC = new CardGenerateOneColor("C","C");
		board.add(cardC);

		CardWithCost card = new CardWithCost("Artifact","W");
		String symbol = card.getCost();

		assertFalse(board.canGenerate(card, symbol));
	}

	@Test
	public void testTapCard() {
		Board board = new Board(); 
		Card cardC = new CardGenerateOneColor("CardId", "C");		
		board.add(cardC);

		CardWithCost card = new CardWithCost("Artifact","C");
		String symbol = card.getCost();

		board.tap(card, symbol);

		String result = "Tapped: CardId";
		assertEquals(result, board.toString());
	}

	@Test
	public void testTapCardGenerateAny() {
		Board board = new Board(); 
		Card cardC = new CardGenerateAny("CardId");		
		board.add(cardC);

		CardWithCost card = new CardWithCost("Artifact","W");
		String symbol = card.getCost();

		board.tap(card, symbol);

		String result = "Tapped: CardId";
		assertEquals(result, board.toString());
	}
	
}
