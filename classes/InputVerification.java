package classes;

/**
 * This class verifies the input
 * @author Horatiu Lazu
 * @version 1.0
 */
public class InputVerification {
  
  /**
   * This method counts the number of occurances of a particular character.
   * @param input This is the String input.
   * @param character This is the character that is being searched for.
   * @return int This is the count of the number of times that a character has been searched for.
   */
  public static int countCharacter (String input, char character){
    int returnVal = 0;
    for(int i = 0; i < input.length(); i++)
      if (input.charAt(i) == character)
      returnVal++;
    return returnVal;
  }
  
  /** This method indicates if the input has a valid exponent. 
    * @param input String This is the input.
    * @return boolean This is true/false depending on the validity of the input. */
  public static boolean isValidExponent(String input){
    if (countCharacter(input, '(') >= countCharacter(input, ')'))
      return true;
    return false;
  }
  
  /** This method determines if the brackets are balanced or not. This is an alternative to using a stack.
    * @param input String This is the input that it used to determine.
    * @param isFinal boolean This is used to determine if it should be completely balanced or just logically valid so far. Ex: 5 (x + 3 is valid if you are not done typing.
    * @return boolean This indicates if the brackets are balanced.*/
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
    char [] invalidChars = {'x', 'X','+','-','*','^', '�', '/'};
    char [] operators = {'+','-','x','^','�', '/', '*'};
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
