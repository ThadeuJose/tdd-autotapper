package tdd;

import java.util.ArrayList;

public class Board {
	
	private ArrayList<String> untappedBoard;
	private ArrayList<String> tappedBoard;
	
	public Board() {
		untappedBoard = new ArrayList<>();
		tappedBoard = new ArrayList<>();
	}	

	public void add(String manaGenerateCard) {
		untappedBoard.add(manaGenerateCard);
	}

	public boolean canGenerate(String cardManaCost) {
		if (isColorlessSymbol(cardManaCost)) {
			return hasMinimalManaAvaible();
		} 

		for (String element : untappedBoard) {
			if(element.contains(cardManaCost)) {
				return true;
			}
		}
		return false;
	}

	private boolean hasMinimalManaAvaible() {
		return untappedBoard.size() >= 1;
	}

	public void tap(String manaGenerateCard) {		
		if (isColorlessSymbol(manaGenerateCard)) {
			String firstElement = untappedBoard.get(0);
			untappedBoard.remove(firstElement);
			tappedBoard.add(firstElement);
		} 
	
		for (String element : untappedBoard) {
			if(element.contains(manaGenerateCard)) {
				untappedBoard.remove(element);
				tappedBoard.add(element);
				break;
			}
		}
	}
	
	private boolean isColorlessSymbol(String symbol) {
		String COLORLESS_SYMBOL = "C";
		return symbol.equals(COLORLESS_SYMBOL);
	}
	
	@Override
	public String toString() {
		if(tappedBoard.isEmpty()) {
			return makeSection("Untapped", untappedBoard);
		}
		
		if(untappedBoard.isEmpty()) {
			return makeSection("Tapped", tappedBoard);
		}
		
		return makeSection("Tapped", tappedBoard) +" "+ makeSection("Untapped", untappedBoard);
	}

	public String makeSection(String title, ArrayList<String> board) {
		String result = title + ":";
		for (String element : board) {
			result = result + " " + element;
		}
		return result;
	}
	
	
	public Board valueOf() {
		Board b = new Board();
		for (String string : tappedBoard) {
			b.setTappedBoardElement(string);
		}
		for (String string : untappedBoard) {
			b.setUntappedBoardElement(string);
		}
		return b;
	}

	private void setUntappedBoardElement(String element) {
		untappedBoard.add(element);
	}
	private void setTappedBoardElement(String element) {
		tappedBoard.add(element);
	}

}
