import java.util.*;

/** This class stores the key mapping for the keyboard on the calculator.
  * @author Horatiu Lazu
  * @version 1.0 */
public class KeyMapping{
  /** getCommandAppending HashMap This map converts the coordinates into commands. */
  public HashMap<String, String> getCommandAppending = new HashMap<String, String>();
  
  /** This class constructor populates the getCommandAppending object. */
  public KeyMapping(){
    getCommandAppending.put("0|0", "X");
    getCommandAppending.put("0|1", ")^2");
    getCommandAppending.put("0|2", ")^3");
    getCommandAppending.put("0|3", ")^4");
    getCommandAppending.put("0|4", ")^5");
    getCommandAppending.put("1|1", "log(");
    getCommandAppending.put("1|2", "sqrt(");
    getCommandAppending.put("1|1", "log(");
    getCommandAppending.put("2|0", "sin(");
    getCommandAppending.put("2|1", "cos(");
    getCommandAppending.put("2|2", "tan(");
    getCommandAppending.put("2|3", "(");
    getCommandAppending.put("2|4", ")");
    getCommandAppending.put("3|0", "snh(");
    getCommandAppending.put("3|1", "csh(");
    getCommandAppending.put("3|2", "tnh(");
    getCommandAppending.put("3|3", "^(");
    getCommandAppending.put("4|1", "7");
    getCommandAppending.put("4|2", "4");
    getCommandAppending.put("4|3", "1");
    getCommandAppending.put("4|4", "0");
    getCommandAppending.put("5|4", "0");
    getCommandAppending.put("6|4", "0");
    getCommandAppending.put("5|1", "8");
    getCommandAppending.put("5|2", "5");
    getCommandAppending.put("5|3", "2");
    getCommandAppending.put("6|1", "9");
    getCommandAppending.put("6|2", "6");
    getCommandAppending.put("6|3", "3");
    getCommandAppending.put("7|0", "/");
    getCommandAppending.put("7|1", "*");
    getCommandAppending.put("7|3", "+");
    getCommandAppending.put("7|2", "-");
  }
}