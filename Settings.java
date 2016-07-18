import java.io.*;

public class Settings{
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