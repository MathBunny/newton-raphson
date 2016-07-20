import java.util.*;

/** This class evaluates postfix expressions.
  * @author Horatiu Lazu
  * @version 1.0 */

public class PostfixEvaluater{
  
  /** This method evaluates postfix expressions.
    * @param expression String This is the string with the expression.
    * @param value double This is the value. 
    * @return double This is the result of the expression at the given value.
    */
  public static double evaluate(String expression, double value){
    expression = InfixToPostfix.infixToPostfix(expression);
    Operations operator = new Operations();
    Stack<Double> op = new Stack<Double>();
    StringTokenizer input2 = new StringTokenizer(expression);
    
    while(input2.hasMoreTokens()){
      String input = input2.nextToken();
      if (input == null)
        break;
      
      if (input.equals("X"))
        input = value + "";
      
      if (operator.isSingleOperator(input)){
        double a = op.pop();
        op.push(operator.compute(a, input));
      }
      else if (operator.isOperator(input)){
        double b = op.pop();
        double a = op.pop();
        op.push(operator.compute(a, b, input));
      }
      else{
        op.push(Double.parseDouble(input)); 
      }
    }
    return op.pop();
    
  }
}