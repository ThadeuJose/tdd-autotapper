package tdd;

import java.util.Comparator;

import tdd.Card.CardWithPriority;

class ManaGeneratorComparator implements Comparator<CardWithPriority> {
 
    @Override
    public int compare(CardWithPriority c1, CardWithPriority c2) {        
        return  c1.getPriority() > c2.getPriority() ? 1: -1;
    }
}