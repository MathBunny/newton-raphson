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
 private String operation = "";
 
 public double operate(int value){
  Expression e = new ExpressionBuilder(operation)
                .variables("x", "e", "pi", "¹")
                .build()
                .setVariable("x", value)
                .setVariable("e", Math.E)
                .setVariable("¹", Math.PI)
                .setVariable("pi", Math.PI);
        double result = e.evaluate();
        return result;
 }
 
 public void derive(){
   
 }
}