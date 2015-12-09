

public class Variable{
  
  private String symbol;
  private double value;
  
  public Variable(String symbol, double value){
    this.symbol = symbol;
    this.value = value;
  }
  
  public String getSymbol(){
    return symbol;
  }
  
  public double getValue(){
    return value;
  }
  
}