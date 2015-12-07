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
 
 public static void setOperation(String operation){
   Operation.operation = operation; //sketchy/
   
 }
 
 public static void derive(){
   
 }
}