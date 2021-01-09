package tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tdd.Card.Card;
import tdd.Card.CardGenerateOneColor;
import tdd.Card.CardGenerateMultiColor;
import tdd.Card.CardOnlyGenerateForArtifact;
import tdd.Card.CardWithCost;

public class AutoTapperTests {

	Board board; 
	CardWithCost genericCard = new CardWithCost("G", "G");
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
		CardGenerateOneColor c = new CardGenerateOneColor("G", "G");
		board.add(c);		
		
		response = Autotapper.tapper(board, genericCard);
		
		logResultBoard = "Untapped: G";
		logResultResp = "Can Cast: true Tapped: G";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}

	@Test
	public void testRGBoard() {
		message = "Cast a card who cost G with a card who can generate RG in the board";
		CardGenerateMultiColor c = new CardGenerateMultiColor("RG","R","G");		
		board.add(c);
						
		response = Autotapper.tapper(board, genericCard);
		
		logResultBoard = "Untapped: RG";
		logResultResp = "Can Cast: true Tapped: RG";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}	
	
	@Test
	public void testTapRG() {
		message = "Cast a card who cost G with a card who can generate G and a card who can generate R in the board";
		CardGenerateOneColor c1 = new CardGenerateOneColor("G", "G");
		board.add(c1);		
		CardGenerateOneColor c2 = new CardGenerateOneColor("R", "R");
		board.add(c2);
				
		response = Autotapper.tapper(board, genericCard);
		
		logResultBoard = "Untapped: R G";
		logResultResp = "Can Cast: true Tapped: G Untapped: R";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}

	@Test
	public void testTap1() {
		message = "Cast a card who cost 1 with a card who can generate G in the board";
		CardGenerateOneColor c1 = new CardGenerateOneColor("G", "G");
		board.add(c1);

		CardWithCost card = new CardWithCost("Artifact", "1");
		
		response = Autotapper.tapper(board, card);
		
		logResultBoard = "Untapped: G";
		logResultResp = "Can Cast: true Tapped: G";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}
	
	@Test
	public void testTap1G() {
		message = "Cast a card who cost 1G with a card who can generate G and a card who can generate R in the board";
		CardGenerateOneColor c1 = new CardGenerateOneColor("G", "G");
		board.add(c1);		
		CardGenerateOneColor c2 = new CardGenerateOneColor("R", "R");
		board.add(c2);
		CardWithCost card = new CardWithCost("Green Spell", "1G");
		
		response = Autotapper.tapper(board, card);
		
		logResultBoard = "Untapped: R G";
		logResultResp = "Can Cast: true Tapped: G R";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}
	
	@Test
	public void testTapGG() {
		message = "Cast a card who cost GG with a card who can generate G and a card who can generate G in the board";
		CardGenerateOneColor c1 = new CardGenerateOneColor("G", "G");
		board.add(c1);				
		board.add(c1);
		CardWithCost card = new CardWithCost("Green Spell", "GG");
		
		response = Autotapper.tapper(board, card);
		
		logResultBoard = "Untapped: G G";
		logResultResp = "Can Cast: true Tapped: G G";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}
	
	@Test
	public void testTap0() {
		message = "Cast a card who cost 0 with a card who can generate G in the board";
		CardGenerateOneColor c1 = new CardGenerateOneColor("G", "G");
		board.add(c1);				
		CardWithCost card = new CardWithCost("Egg", "0");
		
		response = Autotapper.tapper(board, card);
		
		logResultBoard = "Untapped: G";
		logResultResp = "Can Cast: true Untapped: G";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}

	@Test
	public void testTapPriority() {
		message = "Cast a card who cost G with a card who can generate R or G and a card who can generate R or G in the board";
		CardGenerateMultiColor c1 = new CardGenerateMultiColor("RG","R","G");		
		board.add(c1);
		CardGenerateOneColor c2 = new CardGenerateOneColor("G", "G");
		board.add(c2);			
		
		response = Autotapper.tapper(board, genericCard);
		
		logResultBoard = "Untapped: G RG";
		logResultResp = "Can Cast: true Tapped: G Untapped: RG";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}

	@Test
	public void testTapIf() {
		message = "Cast a card who cost C and is a artifact with a card who can generate C only for artifact in the board and a card who can generate G";
		Card cardA = new CardOnlyGenerateForArtifact("A");				
		board.add(cardA);

		CardGenerateOneColor cardG = new CardGenerateOneColor("G", "G");		
		board.add(cardG);				

		CardWithCost card = new CardWithCost("Artifact","C");
		
		response = Autotapper.tapper(board, card);
		
		logResultBoard = "Untapped: A G";
		logResultResp = "Can Cast: true Tapped: A Untapped: G";		
						
		assertEquals(message, LogResponse(), LogExpected());
	}

	
}
