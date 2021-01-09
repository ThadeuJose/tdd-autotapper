package tdd.Card;

import java.util.Arrays;

public class CardGenerateMultiColor extends CardWithId implements CardWithPriority {

    String symbols[];

    public CardGenerateMultiColor(String id, String... symbols) {
        super(id);
        this.symbols = symbols;

    }

    @Override
    public boolean canGenerate(Card card, String symbol) {    
        if(symbol.equals("C")){
            return true;
        }            
        return Arrays.stream(symbols).anyMatch(symbol::equals);
    }

    @Override
    public int getPriority() {
        return Priority.MultiColor.priority;
    }

}
