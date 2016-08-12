package classes;
import java.util.*;

/** This class converts infix to postfix.
  * @author Horatiu Lazu
  * @version 1.0 */

public class InfixToPostfix{
  /** This method converts infix to postfix. It uses Dijkstra's Shunting-Yard algorithm.
    * @param input String This is the input. 
    */
  public static String infixToPostfix(String input){
    StringTokenizer st = new StringTokenizer(input); //tokenize the input
    StringBuilder res = new StringBuilder(""); //build the result with the StringBuilder for O(1) appending
    Stack<String> stack = new Stack<String>(); //stack used for the Shunting-Yard
    
    Operations ops = new Operations(); //reference for operation variables
    while(st.hasMoreTokens()){
      String token = st.nextToken(); //get the next token
      if (ops.isOperator(token)){
        while(!stack.isEmpty() && !stack.peek().equals("(") && ops.hasHigherPrecendece(stack.peek(), token)){ //higher precedence
          res.append(stack.pop() + " "); 
        } 
        stack.push(token);
      }
      else if (token.equals("(")){ //let open braces to be normal
        stack.push("("); 
      }
      else if (token.equals(")")){ //keep appending until you get an open bracket
        while(!stack.isEmpty() && !stack.peek().equals("(")){
          res.append(stack.pop() + " "); 
        } 
        stack.pop();
      }
      else{
        res.append(token + " ");  //append the token normally
      }
    } 
    while (!stack.isEmpty())
      res.append((stack.pop()) + " ");
    return res.toString().trim(); //trim it nicely :)
  }
}