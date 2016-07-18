import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;

/** This class converts infix to postfix.
  * @author Horatiu Lazu
  * @version 1.0 */

public class InfixToPostfix{
  /** This method converts infix to postfix. It uses Dijkstra's Shunting-Yard algorithm.
    * @param input String This is the input. 
    */
  public static String InfixToPostfix(String input){
    StringTokenizer st = new StringTokenizer(input);
    HashSet<String> operator = new HashSet<String>();
    operator.add("*");
    operator.add("+");
    operator.add("-");
    operator.add("/");
    operator.add("^");
    
    StringBuilder res = new StringBuilder("");
    Stack<String> stack = new Stack<String>();
    Operations ops = new Operations();
    while(st.hasMoreTokens()){
      String token = st.nextToken();
      if (ops.isOperator(token)){
        while(!stack.isEmpty() && !stack.peek().equals("(") && ops.hasHigherPrecendece(stack.peek(), token)){
          res.append(stack.pop() + " "); 
        } 
        stack.push(token);
      }
      else if (token.equals("(")){
        stack.push("("); 
      }
      else if (token.equals(")")){
        while(!stack.isEmpty() && !stack.peek().equals("(")){
          res.append(stack.pop() + " "); 
        } 
        stack.pop();
      }
      else{
        res.append(token + " "); 
      }
    } 
    while (!stack.isEmpty())
      res.append((stack.pop()) + " ");
    return res.toString().trim(); //trim it nicely :)
  }
}