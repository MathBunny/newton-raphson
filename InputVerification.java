
/**
 * This class verifies the input
 * @author Horatiu Lazu
 * @version 1.0.0.0
 */
public class InputVerification {
	
	/**
	 * This method counts the number of occurances of a particular character.
	 * @param input This is the String input
	 * @param character This is the character that is being searched for
	 * @return int This is the count of the number of times that a character has been searched for
	 */
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
		return ((closeCount > openCount) ? (false) : (isFinal && closeCount != openCount) ? (false) : (true));
		/*if (closeCount > openCount)
			return false;
		if (isFinal && closeCount != openCount)
			return false;
		return true;*/
	}
	
	/**
	 * The purpose of this method is to detect if there are redundant operations that are not possible.
	 * For instance, ++ or -- or x+ which is not possible.
	 * @param input This is the input command variable
	 * @return boolean This boolean informs if the input is valid or not.
	 */
	
	public static boolean hasRepeatedInvalidOperators(String input){
		if (input.length() == 0)
			return true;
		char prev, current;
		char [] invalidChars = {'x', 'X','+','-','*','^', 'Ö'};
		char [] operators = {'+','-','x','^','Ö'};
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
		for(int i = 0; i < operators.length; i++){
			for(int x = 0; x < input.length(); x++){
				if (operators[i] == input.charAt(x)){
					if (x == input.length()-1)
						break;
					for(int y = 0; y < operators.length; y++){
						if (input.charAt(x+1) == operators[y])
							return false;
					}
				}
			}
		}
		return true;
	}
}
