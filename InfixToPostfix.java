/* Programming Competition - Template (Horatiu Lazu) */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;

class InfixToPostfix{
 static StringTokenizer st;
 //public static void main (String [] args){
 // new InfixToPostfix();
 //}
 
 /*private boolean hasHigherPrecendece(String a, String b){
  HashMap<String, Integer> order = new HashMap<String, Integer>();
  //order.put("(", 0);
  order.put("+", 1);
  order.put("-", 2);
  order.put("*", 3); 
  order.put("/", 4);
  order.put("^", 5);
  
  order.put("sin", 6);
  order.put("cos", 6);
  order.put("tan", 6);
  order.put("log", 6);
  
  if (!order.containsKey(b))
   return false;
  return (order.get(b) <= order.get(a));
 }*/

 public static String InfixToPostfix(String input){
  //String input = "sin ( ( 3 ) / 3 * 3.1415 )";
  st = new StringTokenizer(input);
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