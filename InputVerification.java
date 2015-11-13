
/**
 * This class verifies the input
 * @author horatiulazu
 * @version 1.0.0.0
 */
public class InputVerification {
	
	public static boolean hasBalancedBrackets(String input){
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
		if (closeCount != openCount)
			return false;
		return true;
	}
	
	public static boolean repeatedOperators(String input){
		char prev;
		char current;
		char [] invalidChars = {'x', 'X','+','-','*'};
		for(int i = 1; i < input.length(); i++){
			prev = input.charAt(i-1);
			current = input.charAt(i);
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
