import java.util.*;

public class Operation{
  private static String operation = "";
  static final double ACCURACY = 1e-10;
  final static int MAX_ATTEMPTS = 1000;
  static private ArrayList<Variable> constantList = new ArrayList<Variable>();
  
  
  public static void addConstant(String symbol, double value){
    constantList.add(new Variable(symbol, value));
  }
  
  public static double operate(double value){
    return PostfixEvaluater.evaluate(operation, value);
  }
  
  
  public static double compute(double guess){
    final double ACCEPTABLE_CHANGE = ACCURACY;
    final double ACCEPTABLE_HORIZONTAL_SLOPE = ACCURACY;
    double x = guess;
    double newX;
    
    StartValueSelection.iterations = 0;
    for(int o = 0; o < MAX_ATTEMPTS; o++){
      double y = operate(x);
      double slope = derivative(x);
      newX = (x-(y/slope));
      if (Math.abs(newX-x) < ACCEPTABLE_CHANGE){
        System.out.println("Solution Found at: x= " + newX);
        return newX;
      }
      if (ACCEPTABLE_HORIZONTAL_SLOPE > Math.abs(slope)){
        System.out.println("Error: Infinite slope found.");
        return Integer.MAX_VALUE;
      }
      x = newX;
      StartValueSelection.iterations++;
    }
    System.out.println("Could not find any solution!");
    return Integer.MAX_VALUE; //could not find!
    
  }
  
  /** This method computes the derivative of a function using first principles.
    * @param value Double This is the value of the x coordinate 
    */
  public static double derivative(double value){
    double firstVal = PostfixEvaluater.evaluate(operation, value);
    double secondVal = (PostfixEvaluater.evaluate(operation, value + ACCURACY));
    double dx = ((secondVal - firstVal)/(ACCURACY));
    return dx;
  }
  
  /** This method sets the operation.
    * @param operation String This is the operation being set. */
  public static void setOperation(String operation){
    Operation.operation = operation.trim(); //sketchy/
    
  }
  
  
}