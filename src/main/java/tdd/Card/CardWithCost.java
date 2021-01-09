package tdd.Card;

public class CardWithCost extends CardWithId {
    
    String cost;

    public CardWithCost(String id, String cost) {
        super(id);
        this.cost = cost;
    }
    
    @Override
    public boolean canGenerate(Card card, String symbol) {
        return false;
    }

    public String getCost(){
        return this.cost;
    }

}