package tdd;

import tdd.Card.CardGenerateMultiColor;
import tdd.Card.CardGenerateOneColor;
import tdd.Card.CardWithCost;

public class main_tdd {
    public static void main(String[] args) {
        Board board = new Board();
        
		CardGenerateMultiColor c1 = new CardGenerateMultiColor("RG","R","G");		
		board.add(c1);
		CardGenerateOneColor c2 = new CardGenerateOneColor("G", "G");
		board.add(c2);			
				
		Response response = Autotapper.tapper(board, new CardWithCost("G", "G"));

        System.out.println(response);
    }
}
