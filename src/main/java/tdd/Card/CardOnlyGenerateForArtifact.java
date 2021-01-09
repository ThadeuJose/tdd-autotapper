package tdd.Card;

public class CardOnlyGenerateForArtifact extends CardWithId implements CardWithPriority {
    String id;
    
    public CardOnlyGenerateForArtifact(String id){
        super(id);
    }

    @Override
    public boolean canGenerate(Card card, String symbol) {
        if(card.getId().equals("Artifact") && symbol.equals("C")){
            return true;
        }
        return false;
    }

    @Override
    public int getPriority() {
        return Priority.GenerateForArtifact.priority;
    }
}
