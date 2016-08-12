package classes;
/** This class abstracts a variable.
  * @author Horatiu Lazu 
  * @version 1.0
  */
public class Variable{
  /** symbol String This is the string representation of the variable (ie, x) */
  private String symbol;
  /** value double This is the value of the variable */
  private double value;
  
  /** This is the class constructor for a variable.
    * @param symbol String This is the symbol for the variable.
    * @param value double This is the numerical value for the variable. */
  public Variable(String symbol, double value){
    this.symbol = symbol;
    this.value = value;
  }
  
  /** This method returns the symbol. 
    * @return String This is the symbol. */
  public String getSymbol(){
    return symbol;
  }
  
  /** This method returns the value.
    * @return double This is the value. */
  public double getValue(){
    return value;
  }
}