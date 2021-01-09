package tdd.Card;

public interface Card {
    
    String getId();

    boolean canGenerate(Card card, String symbol);
    
}
