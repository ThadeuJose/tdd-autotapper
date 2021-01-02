package tdd;

public class TransformManaCost {
	
	public static String transform(String manacost) {
		if(isNumber(manacost)) {			
			return transformNumberToColorless(manacost);
		}
		if(!containNumbers(manacost)) {
			return manacost;
		}
		String result = "";
		StringBuilder sb = new StringBuilder(manacost);
		for (int i = manacost.length()-1; i > 0; i--) {
			char character = sb.charAt(i); 
			if(!Character.isDigit(character)) {
				result += character;
				sb.deleteCharAt(i);
			}				 
		}			
		result += transformNumberToColorless(sb.toString());
		return result;			
				
	}
	
	private static boolean containNumbers(String manacost) {
		for (char c : manacost.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}
	
	private static String transformNumberToColorless(String n) {		
		int number = Integer.parseInt(n);		
		String result = "";
		final String COLORLESS_SYMBOL = "C"; 
		for (int i = 0; i < number; i++) {
			result += COLORLESS_SYMBOL; 
		}
		return result;
	}
	
	private static boolean isNumber(String s) {
		return s.matches("[0-9]+");
	}
	
}

