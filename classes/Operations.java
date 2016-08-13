package classes;
import java.util.*;

/** This class stores operations on variables.
  * @author Horatiu Lazu
  * @version 1.0
  */

public class Operations{
  /** operator HashSet These are binary operators. */
  private HashSet<String> operator = new HashSet<String>();
  /** singleOperator HashSet This are unary operators. */
  private HashSet<String> singleOperator = new HashSet<String>();
  
  /** This is the class constructor. It populates the HashSets. */
  public Operations(){
    singleOperator.add("sin");
    singleOperator.add("cos");
    singleOperator.add("tan");
    singleOperator.add("snh");
    singleOperator.add("csh");
    singleOperator.add("log");
    
    operator.add("*");
    operator.add("+");
    operator.add("-");
    operator.add("/");
    operator.add("%");
    operator.add("^");
  }
  
  /** This method determines if the string is an operator.
    * @param s String This is the input string.
    * @return boolean If it is an operator or not. */
  public boolean isOperator(String s){
    return operator.contains(s) || singleOperator.contains(s); 
  }
  
  /** This method returns if an operator is specifically unary.
    * @param s String This is the input string.
    * @return boolean If it is a single operator or not. */
  public boolean isSingleOperator(String s){
    return singleOperator.contains(s); 
  }
  
  /** This method computes a specific operation.
    * @param a double This is the first number.
    * @param b double This is the second number.
    * @param operator String This is the operator string. 
    * @return double This is the computed answer.
    */
  public double compute(double a, double b, String operator){
    if (operator.equals("*"))
      return a * b;
    if (operator.equals("+"))
      return a + b;
    if (operator.equals("-"))
      return a - b;
    if (operator.equals("/"))
      return a / b;
    if (operator.equals("^"))
      return Math.pow(a, b);
    if (operator.equals("%"))
      return a % b;
    return -1;
  }
  
  /** This method computes a specific operation on a unary operator.
    * @param a double This is the number.
    * @param operator String This is the operator.
    * @return double This is the computed answer.
    */
  public double compute(double a, String operator){
    if (operator.equals("sin"))
      return Math.sin(a);
    if (operator.equals("cos"))
      return Math.cos(a);
    if (operator.equals("tan"))
      return Math.tan(a);
    if (operator.equals("csh"))
      return Math.cosh(a);
    if (operator.equals("snh"))
      return Math.sinh(a);
    if (operator.equals("log"))
      return Math.log(a);
    return -1;
  }
  
  /** This method determines the order of operations.
    * @param a String This is the first candidate.
    * @param b String This is the second candidate. 
    * @return boolean If it has higher precedence.
    */
  public boolean hasHigherPrecendece(String a, String b){
    HashMap<String, Integer> order = new HashMap<String, Integer>();
    order.put("+", 1);
    order.put("-", 2);
    order.put("*", 3); 
    order.put("/", 4);
    order.put("^", 5);
    
    order.put("sin", 6);
    order.put("cos", 6);
    order.put("tan", 6);
    order.put("log", 6);
    
    order.put("snh", 7);
    order.put("cnh", 7);
    
    if (!order.containsKey(b))
      return false;
    return (order.get(b) <= order.get(a));
  }
  
}