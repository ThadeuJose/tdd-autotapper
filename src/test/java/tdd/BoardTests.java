package tdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTests {

	@Test
	public void testToString() {
		String message = "Show Board";
		Board board = new Board(); 
		board.add("G");
		String logResult = "Untapped: G";
		assertEquals(message, board.toString(), logResult);
	}
	
	@Test
	public void testValueOfAdd() {
		String message = "Test if Value of create a deep copy of board";
		Board board1 = new Board(); 
		board1.add("G");
		Board board2 = board1.valueOf();
		board2.add("G");
		String logResult1 = "Untapped: G";
		String logResult2 = "Untapped: G G";
		assertEquals(message, board1.toString() + board2.toString(), logResult1 + logResult2);
	}
	
	@Test
	public void testValueOfAllTap() {
		String message = "Test if Value of create a deep copy of board";
		Board board1 = new Board(); 
		board1.add("G");
		board1.add("G");
		Board board2 = board1.valueOf();
		board2.tap("G");
		board2.tap("G");	
		String logResult1 = "Untapped: G G";
		String logResult2 = "Tapped: G G";
		assertEquals(message, board1.toString() + board2.toString(), logResult1 + logResult2);
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
