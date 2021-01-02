package tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;



public class AutoTapperTests {

	Board board; 
	String message;
	Response response;
	String logResultBoard;
	String logResultResp;
	
	@Before
	public void initialize() {
		board = new Board();
	}
	
	private String LogResponse() {
		return board.toString() + response.toString();
	}
	
	private String LogExpected() {
		return logResultBoard + logResultResp;
	}
	
	
	
	@Test
	public void testOneManaCard() {
		message = "Cast a card who cost G with a card who can generate G in the board";
		board.add("G");
		String cardManaCost = "G";
		
		response = Autotapper.tapper(board, cardManaCost);
		
		logResultBoard = "Untapped: G";
		logResultResp = "Can Cast: true Tapped: G";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}

	@Test
	public void testRGBoard() {
		message = "Cast a card who cost G with a card who can generate RG in the board";
		board.add("RG");
		String cardManaCost = "G";
				
		response = Autotapper.tapper(board, cardManaCost);
		
		logResultBoard = "Untapped: RG";
		logResultResp = "Can Cast: true Tapped: RG";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}	
	
	@Test
	public void testTapRG() {
		message = "Cast a card who cost G with a card who can generate G and a card who can generate R in the board";
		board.add("G");
		board.add("R");
		String cardManaCost = "G";
		
		response = Autotapper.tapper(board, cardManaCost);
		
		logResultBoard = "Untapped: G R";
		logResultResp = "Can Cast: true Tapped: G Untapped: R";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}

	@Test
	public void testTap1() {
		message = "Cast a card who cost 1 with a card who can generate G in the board";
		board.add("G");
		String cardManaCost = "1";
		
		response = Autotapper.tapper(board, cardManaCost);
		
		logResultBoard = "Untapped: G";
		logResultResp = "Can Cast: true Tapped: G";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}
	
	@Test
	public void testTap1G() {
		message = "Cast a card who cost 1G with a card who can generate G and a card who can generate R in the board";
		board.add("G");
		board.add("R");
		String cardManaCost = "1G";
		
		response = Autotapper.tapper(board, cardManaCost);
		
		logResultBoard = "Untapped: G R";
		logResultResp = "Can Cast: true Tapped: G R";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}
	
	@Test
	public void testTapGG() {
		message = "Cast a card who cost GG with a card who can generate G and a card who can generate G in the board";
		board.add("G");
		board.add("G");
		String cardManaCost = "GG";
		
		response = Autotapper.tapper(board, cardManaCost);
		
		logResultBoard = "Untapped: G G";
		logResultResp = "Can Cast: true Tapped: G G";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}
	
	@Test
	public void testTap0() {
		message = "Cast a card who cost 0 with a card who can generate G in the board";
		board.add("G");
		String cardManaCost = "0";
		
		response = Autotapper.tapper(board, cardManaCost);
		
		logResultBoard = "Untapped: G";
		logResultResp = "Can Cast: true Untapped: G";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}

	@Test
	public void testTapPriority() {
		message = "Cast a card who cost G with a card who can generate R or G and a card who can generate R or G in the board";
		board.add("RG");
		board.add("G");				
		String cardManaCost = "G";
		
		response = Autotapper.tapper(board, cardManaCost);
		
		logResultBoard = "Untapped: RG G";
		logResultResp = "Can Cast: true Tapped: G Untapped: RG";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}

	
}
