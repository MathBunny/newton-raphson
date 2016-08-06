import java.util.*;

public class NumericalTokenizer{
  private Operations operatorHelper = new Operations();
  
  public static void main (String [] args){
    System.out.println(new NumericalTokenizer().convertToSpacedNumericalFormat("72sin(x^2+32)*32-32+x^32+(1)"));
  }
  
  public String convertToSpacedNumericalFormat(String s){
    StringBuilder ans = new StringBuilder("");
    int ptrA = 0;
    
    for(int x = 0; x < s.length(); x++){
      if ((operatorHelper.isOperator(s.substring(ptrA, x+1)) || s.charAt(x) == 'x' || s.charAt(x) == '(' || s.charAt(x) == ')')){
        if (operatorHelper.isSingleOperator(s.substring(ptrA, x+1)))
          ans.append(" *");
        ans.append(" " + s.substring(ptrA, x+1));
        ptrA = x+1;
      }
      else{
        if (isNumber(s.charAt(x) + "")){
          int maxVal = x+1;
          boolean didBreak = false;
          for(int y = x+1; y < s.length(); y++){
            if (!isNumber(s.charAt(y) + "")){
              maxVal = y;
              didBreak = true;
              break;
            }
          }
          if (!didBreak){
            maxVal = s.length();
            ptrA = x;
          }
          if (ptrA != x)
            ans.append(" " + s.substring(ptrA, x));
          ans.append(" " + s.substring(x, maxVal));
          x = maxVal-1;
          ptrA = maxVal;
          if (!didBreak)
            break;
        }
      }
    }
    if (ptrA != s.length()-1){
      ans.append(s.substring(ptrA, s.length()) + " ");
    }
    return (ans.toString()).trim();
  }
  
  /** This method determines if the input is a number.
   * @param a String This is the input
   * @throws NumberFormatException This is to test to see if the input is a number. */
  private boolean isNumber(String a){
    try{Integer.parseInt(a);return true;} catch(NumberFormatException e){return false;}
  }    
}