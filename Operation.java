/* Programming Competition - Template (Horatiu Lazu) */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;
import exp4j.*;

class Operation{
  private static String operation = "";
  static final double ACCURACY = 0.0000000001;
  static private ArrayList<Variable> constantList = new ArrayList<Variable>();
  
  
  public static void addConstant(String symbol, double value){
    constantList.add(new Variable(symbol, value));
  }
  
  public static void addConstants(Expression e){
    for(int x = 0; x < constantList.size(); x++){
      e.setVariable(constantList.get(x).getSymbol(), constantList.get(x).getValue());
    }
  }
  
  public static double operate(int value){
    Expression e = new ExpressionBuilder(operation)
      .variables("X", "e", "pi", "¹") //uppercase...
      .build()
      .setVariable("X", value)
      .setVariable("e", Math.E)
      .setVariable("¹", Math.PI)
      .setVariable("pi", Math.PI);
    double result = e.evaluate();
    System.out.println("Res: " + result);
    return result;
  }
  
  /** This method computes the derivative of a function using first principles.*/
  public static double derivative(int value){
    Expression e = new ExpressionBuilder(operation)
      .variables("X", "e", "pi", "¹") //uppercase...
      .build()
      .setVariable("X", value)
      .setVariable("e", Math.E)
      .setVariable("¹", Math.PI)
      .setVariable("pi", Math.PI);
    
    double firstVal = e.evaluate();
    double secondVal = ((e.setVariable("X", value)).evaluate());
    double dx = ((secondVal - firstVal)/(ACCURACY));
    return dx;
  }
  
  
  
  public static void setOperation(String operation){
    Operation.operation = operation; //sketchy/
    
  }
 
  
}