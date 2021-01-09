package tdd;

import java.util.ArrayList;
import java.util.Collections;

import tdd.Card.Card;
import tdd.Card.CardWithPriority;

public class Board {

	private ArrayList<Card> untappedBoardCards;
	private ArrayList<Card> tappedBoardCards;
	
	public Board() {		
		untappedBoardCards = new ArrayList<>();
		tappedBoardCards = new ArrayList<>();
	}	

	public void add(Card manaGenerator) {		
		untappedBoardCards.add(manaGenerator);
		ArrayList<CardWithPriority> newArray = new ArrayList<>();
		for (Card card : untappedBoardCards) {
			newArray.add((CardWithPriority) card);
		}
		Collections.sort(newArray, new ManaGeneratorComparator());
		untappedBoardCards.clear();
		for (CardWithPriority card : newArray) {
			untappedBoardCards.add((Card)card);
		}
	}

	public boolean canGenerate(Card card, String symbol) {
		for (Card boardCard : untappedBoardCards) {
			if(boardCard.canGenerate(card, symbol)) {
				return true;
			}
		}
		return false;
	}

	public void tap(Card spell, String symbol) {
		for (Card card : untappedBoardCards) {
			if(card.canGenerate(spell, symbol)) {
				untappedBoardCards.remove(card);
				tappedBoardCards.add(card);
				break;
			}
		}
	}
	
	@Override
	public String toString() {	
		if(tappedBoardCards.isEmpty() && untappedBoardCards.isEmpty()){
			return "";
		}
		
		if(tappedBoardCards.isEmpty()) {
			return makeSection("Untapped", untappedBoardCards);
		}
		
		if(untappedBoardCards.isEmpty()) {
			return makeSection("Tapped", tappedBoardCards);
		}
		
		return makeSection("Tapped", tappedBoardCards) +" "+ makeSection("Untapped", untappedBoardCards);
	}

	public String makeSection(String title, ArrayList<Card> board) {
		String result = title + ":";
		for (Card element : board) {
			result = result + " " + element.getId();
		}
		return result;
	}
	
	public Board valueOf() {
		Board b = new Board();
		for (Card string : tappedBoardCards) {
			b.setTappedBoardElement(string);
		}
		for (Card string : untappedBoardCards) {
			b.setUntappedBoardElement(string);
		}
		return b;
	}

	private void setUntappedBoardElement(Card element) {
		untappedBoardCards.add(element);
	}
	private void setTappedBoardElement(Card element) {
		tappedBoardCards.add(element);
	}

}
