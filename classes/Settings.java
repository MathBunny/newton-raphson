package classes;
import java.io.*;

/** This class sees if the additional screen should be displayed based off of the configuration file.
  * @author Horatiu Lazu
  * @version 1.0
  */
public class Settings{
  
  /** This method looks and tries to read from the file to see if it should open the screen or not.
    * @return boolean This is if it should display.
    */
  public static boolean shouldDisplay(){
    try{
      BufferedReader in = new BufferedReader(new FileReader("settings.txt"));
      if (in.readLine().equals("display= false"))
        return false;
      return true;
    }
    catch(Exception e){}
    return true;
  }
}