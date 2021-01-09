package tdd.Card;

public abstract class CardWithId implements Card {

    String id;

    public CardWithId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
