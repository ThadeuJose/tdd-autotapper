package autotapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;



public class autotapperTest {

	Board board; 
	String message;
	
	@Before
	public void initialize() {
		board = new Board();
	}
	
	private void checkBoard(String logResult) {
		assertEquals(message, board.toString(), logResult);
	}
	
	@Test
	public void testOneManaCard() {
		message = "Cast a card who cost G with a card who can generate G in the board";
		board.add("G");
		String cardManaCost = "G";
		
		String logResult = "Tapped: G";
		
		assertTrue(message, Autotapper.tapper(board, cardManaCost));
		checkBoard(logResult);
	}
	
	@Test
	public void testRGBoard() {
		message = "Cast a card who cost G with a card who can generate RG in the board";
		board.add("RG");
		String cardManaCost = "G";
				
		String logResult = "Tapped: RG";
		
		assertTrue(message, Autotapper.tapper(board, cardManaCost));
		checkBoard(logResult);
	}	
	
	@Test
	public void testTapRG() {
		message = "Cast a card who cost G with a card who can generate G and a card who can generate R in the board";
		board.add("G");
		board.add("R");
		String cardManaCost = "G";
		
		String logResult = "Tapped: G Untapped: R";
		
		assertTrue(message, Autotapper.tapper(board, cardManaCost));
		checkBoard(logResult);
	}

	@Test
	public void testTap1G() {
		message = "Cast a card who cost 1G with a card who can generate G and a card who can generate R in the board";
		board.add("G");
		board.add("R");
		String cardManaCost = "1G";
		
		String logResult = "Tapped: G R";
		
		assertTrue(message, Autotapper.tapper(board, cardManaCost));
		checkBoard(logResult);
	}
	
}
