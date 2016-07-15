/* Programming Competition - Template (Horatiu Lazu) */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;


public class PostfixEvaluater{
 BufferedReader in;
 
 //public static void main (String [] args){
 // new PostfixEvaluater();
 //}
 
 
 public static double evaluate(String expression, double value){
  expression = InfixToPostfix.InfixToPostfix(expression);
  Operations operator = new Operations();
  Stack<Double> op = new Stack<Double>();
  StringTokenizer input2 = new StringTokenizer(expression);
  
  while(input2.hasMoreTokens()){
   String input = input2.nextToken();
   if (input.equals("X")){
    input = value + "";
   }
   if (input == null)
    break;
   
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
 

 public PostfixEvaluater(){
  try{
   in = new BufferedReader(new InputStreamReader(System.in));
   Operations operator = new Operations();
   
   
   Stack<Double> op = new Stack<Double>();
   StringTokenizer input2 = new StringTokenizer(in.readLine());
   while(input2.hasMoreTokens()){
    String input = input2.nextToken();
    if (input.equals("x")){
      
    }
    if (input == null)
     break;
    
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
   System.out.println(op.pop());
   
  }
  catch(IOException e){
   System.out.println("IO: General");
  }
 }
}