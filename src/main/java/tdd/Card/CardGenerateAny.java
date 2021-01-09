package tdd.Card;

public class CardGenerateAny extends CardWithId implements CardWithPriority {

    String id;

    public CardGenerateAny(String id) {
        super(id);
    }
    
    @Override
    public boolean canGenerate(Card card, String symbol) {
        return true;
    }

    @Override
    public int getPriority() {        
        return Priority.AnyColor.priority;
    }

}
