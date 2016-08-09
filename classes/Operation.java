/** This class solves for the root of expressions.
  * @author Horatiu Lazu
  * @version 1.0.0.0 */
public class Operation{
  /** operation String This is the current operation. */
  private static String operation = "";
  /** ACCURACY double This is the accurary of the operation. */
  static final double ACCURACY = 1e-10;
  /** MAX_ATTEMPTS int This is the max attempts. */
  final static int MAX_ATTEMPTS = 10000;
  /** TEST_CASES double [] These are testcases used to try on functions for x values. */
  final static double[] TEST_CASES = new double[]{-100, -50, 0, 1, 50, 100};
  
  /** This method evaluates the expression at a particular value.
    * @param value double This is the value at which it is evaluated. */
  public static double operate(double value){
    return PostfixEvaluater.evaluate(operation, value);
  }
  
  /** This method applies Newton's approximation to solve for the root.
    * @param guess double This is the user's value for x. 
    * @return double This is the answer.
    */
  public static double compute(double guess){
    final double ACCEPTABLE_CHANGE = ACCURACY; //accuracy for the answer
    final double ACCEPTABLE_HORIZONTAL_SLOPE = ACCURACY; //acceptible horizontal slope to prevent timeouts
    double x = guess;
    double newX;
    
    StartValueSelection.iterations = 0; //reset iterations
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
    Operation.operation = operation.trim();
  }
  
  
}