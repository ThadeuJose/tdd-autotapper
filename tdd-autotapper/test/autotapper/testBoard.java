package autotapper;

import static org.junit.Assert.*;

import org.junit.Test;

public class testBoard {

	@Test
	public void testBoardConstructor() {
		String message = "Show Board";
		Board board = new Board(); 
		board.add("G");
		String logResult = "Untapped: G";
		assertEquals(message, board.toString(), logResult);
	}
	
	@Test
	public void testTap() {
		String message = "Tap card who generate G";
		Board board = new Board(); 
		board.add("G");
		board.add("R");
		board.tap("G");
		String logResult = "Tapped: G Untapped: R";
		assertEquals(message, board.toString(), logResult);
	}
	
}
