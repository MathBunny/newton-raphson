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
  static final double ACCURACY = 1e-10;
  final static int MAX_ATTEMPTS = 1000;
  static private ArrayList<Variable> constantList = new ArrayList<Variable>();
  
  
  public static void addConstant(String symbol, double value){
    constantList.add(new Variable(symbol, value));
  }
  
  public static void addConstants(Expression e){
    for(int x = 0; x < constantList.size(); x++){
      e.setVariable(constantList.get(x).getSymbol(), constantList.get(x).getValue());
    }
  }
  
  public static double operate(double value){
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
  
  //guess
  //find equation of tangent line 
  
  public static double compute(double guess){
    final double ACCEPTABLE_CHANGE = ACCURACY;
    final double ACCEPTABLE_HORIZONTAL_SLOPE = ACCURACY;
    double x = guess;
    double newX;
    
    StartValueSelection.iterations = 0;
    for(int o = 0; o < MAX_ATTEMPTS; o++){
      double y = operate(x);
      double slope = derivative(x);
      if (ACCEPTABLE_HORIZONTAL_SLOPE > Math.abs(slope)){
        System.out.println("INFINITE SLOPE!");
        return Integer.MAX_VALUE;
      }
      newX = (x-(y/slope));
      if (Math.abs(newX-x) < ACCEPTABLE_CHANGE){
        System.out.println("FOUND!");
        return newX;
      }
      x = newX;
      StartValueSelection.iterations++;
    }
    System.out.println("Could not find any solution!");
    return Integer.MAX_VALUE; //could not find!

  }
  
  /** This method computes the derivative of a function using first principles.*/
  public static double derivative(double value){
    try{
      Expression e = new ExpressionBuilder(operation)
        .variables("X", "e", "pi", "¹") //uppercase...
        .build()
        .setVariable("X", value)
        .setVariable("e", Math.E)
        .setVariable("¹", Math.PI)
        .setVariable("pi", Math.PI);
      double firstVal = e.evaluate();
      double secondVal = ((e.setVariable("X", value + ACCURACY)).evaluate());
      double dx = ((secondVal - firstVal)/(ACCURACY));
      return dx;
    }
    catch(IllegalArgumentException e){
      System.out.println(e);
    }
    return -1; //error!
    
  }
  
  
  
  public static void setOperation(String operation){
    Operation.operation = operation; //sketchy/
    
  }
  
  
}