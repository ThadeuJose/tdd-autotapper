package tdd;

import static org.junit.Assert.*;

import org.junit.Test;

import tdd.Card.CardGenerateOneColor;

public class ResponseTests {

	@Test
	public void testifWork() {
		Board board = new Board(); 
		board.add(new CardGenerateOneColor("G", "G"));
		Response resp = new Response(true,board);
		String logResult = "Can Cast: true Untapped: G";
		assertEquals(resp.toString(), logResult);
	}

}
