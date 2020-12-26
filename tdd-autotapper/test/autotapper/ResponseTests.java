package autotapper;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResponseTests {

	@Test
	public void testifWork() {
		Board board = new Board(); 
		board.add("G");
		Response resp = new Response(true,board);
		String logResult = "Can Cast: true Untapped: G";
		assertEquals(resp.toString(), logResult);
	}

}
