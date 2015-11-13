
/**
 * This class verifies the input
 * @author horatiulazu
 * @version 1.0.0.0
 */
public class InputVerification {
	
	public static int countCharacter (String input, char character){
		int returnVal = 0;
		for(int i = 0; i < input.length(); i++)
			if (input.charAt(i) == character)
				returnVal++;
		return returnVal;
	}
	
	public static boolean isValidExponent(String input){
		if (countCharacter(input, '(') >= countCharacter(input, ')'))
			return true;
		return false;
	}
	
	public static boolean hasBalancedBrackets(String input, boolean isFinal){
		int openCount = 0;
		int closeCount = 0;
		for(int i = 0; i < input.length(); i++){
			if (input.charAt(i) == '(')
				openCount++;
			else{
				if (input.charAt(i) == ')')
					closeCount++;
			}
		}
		if (closeCount > openCount)
			return false;
		if (isFinal && closeCount != openCount)
			return false;
		return true;
	}
	
	public static boolean hasRepeatedInvalidOperators(String input){
		if (input.length() == 0)
			return true;
		char prev;
		char current;
		char [] invalidChars = {'x', 'X','+','-','*','^', 'Ö'};
		for(int i = 1; i < input.length(); i++){
			prev = input.charAt(i-1);
			current = input.charAt(i);
			if (prev == '(' && current == ')')
				return false;
			if (prev == current){
				for(int x = 0; x < invalidChars.length; x++){
					if (prev == invalidChars[x])
						return false;
				}
			}
		}
		return true;
	}
}
