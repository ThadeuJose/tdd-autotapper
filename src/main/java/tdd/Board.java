package tdd;

import java.util.ArrayList;

public class Board {
	
	private ArrayList<String> untappedBoard;
	private ArrayList<String> tappedBoard;
	
	public Board() {
		untappedBoard = new ArrayList<>();
		tappedBoard = new ArrayList<>();
	}	
	
	public boolean canGenerate(String cardManaCost) {
		String COLORLESS_SYMBOL = "C";
		if (cardManaCost.equals(COLORLESS_SYMBOL)) {
			if (untappedBoard.size() >= 1) {
				return true;
			} else {
				return false;
			}
		} else {
			for (String element : untappedBoard) {
				if(element.contains(cardManaCost)) {
					return true;
				}
			}
			return false;	
		}		
	}
	
	public void add(String manaGenerateCard) {
		untappedBoard.add(manaGenerateCard);
	}
	
	public void tap(String manaGenerateCard) {
		String COLORLESS_SYMBOL = "C";
		if (manaGenerateCard.equals(COLORLESS_SYMBOL)) {
			String element = untappedBoard.get(0);
			untappedBoard.remove(element);
			tappedBoard.add(element);
		} else {
			for (String element : untappedBoard) {
				if(element.contains(manaGenerateCard)) {
					untappedBoard.remove(element);
					tappedBoard.add(element);
					break;
				}
			}
		}
		
	}
	
	public String makeSection(String title, ArrayList<String> board) {
		String result = title + ":";
		for (String element : board) {
			result = result + " " + element;
		}
		return result;
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

	
	private void setUntappedBoardElement(String element) {
		untappedBoard.add(element);
	}
	private void setTappedBoardElement(String element) {
		tappedBoard.add(element);
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
	
}
