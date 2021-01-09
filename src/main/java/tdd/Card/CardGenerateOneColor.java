package tdd.Card;

public class CardGenerateOneColor extends CardWithId implements CardWithPriority {
    
    String symbol;
    
    public CardGenerateOneColor(String id, String symbol) {
        super(id);
        this.symbol = symbol;
    }

    @Override
    public boolean canGenerate(Card card, String symbol) {
        if(symbol.equals("C")){
            return true;
        }
        return this.symbol.equals(symbol);
    }

    @Override
    public int getPriority() {        
        if (this.symbol.equals("C")) {
            return Priority.Colorless.priority;
        }
        return Priority.Color.priority;
    }

}
