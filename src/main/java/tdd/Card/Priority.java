package tdd.Card;

public enum Priority {
 
    Colorless(0),
    GenerateForArtifact(1),
    Color(2),
    MultiColor(3),
    AnyColor(4);

    public final int priority;

    private Priority(int priority) {
        this.priority = priority;
    }
}
