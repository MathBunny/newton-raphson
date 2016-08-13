package classes;
import java.io.*;

/** This class lets the user find the roots of an equation.
  * @author Horatiu Lazu
  * @version 1.0 
  */
public class NewtonRaphsonConsole{
  /** Main method for the program.
    * @param args String [] These are the arguments. */
  public static void main (String [] args){
    NewtonRaphsonConsole nrConsole = new NewtonRaphsonConsole();
    while(true){
      nrConsole.mainMenu();
    }
  }
  
  /** This method is used to compute a root for an expression.
    * @param shouldShowSteps boolean This indicates if the program should display Newton Raphson's method in steps outputted to the user. */
  public void compute(boolean shouldShowSteps){
    System.out.println("Please input expression.");
    try{
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      Operation.setOperation(InfixToPostfix.infixToPostfix(new NumericalTokenizer().convertToSpacedNumericalFormat(in.readLine().replaceAll("x", "X"))));
    }
    catch(IOException e){}
    System.out.println("Please enter guess: ");
    double guess = getInput();
    double ans = Operation.compute(guess);
    if (ans == Integer.MAX_VALUE){
      System.out.println("Error: Could not compute a root.");
    }
    else{
      System.out.println("Answer: " + ans);
    }
    pause();
  }
  
  /** This method gets the input from the user in a while loop.
    * @return int This is the input. */
  public int getInput(){
    while(true){
      try{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int option = Integer.parseInt(in.readLine());
        return option;
      }
      catch(IOException e){
        System.out.println("Error: Please retry, an input error occured.");
      }
      catch(NumberFormatException e){
        System.out.println("Error: Please enter a number.");
      }
    }
  }
  
  /** This method displays a pause screen. */
  public void pause(){
    System.out.println("Press any key to continue.");
    try{
      new BufferedReader(new InputStreamReader(System.in)).readLine();
      for(int x = 0; x < 100; x++)
        System.out.println("");
    }
    catch(IOException e){}
  }
  
  /** This is the main menu screen. */
  public void mainMenu(){
    System.out.println("Main menu: " );
    System.out.println("1. Compute (with steps)");
    System.out.println("2. Compute (without steps)");
    System.out.println("3. Exit");
    int option = getInput();
    if (option == 3){
      System.exit(0);
    }
    else if (option == 2){
      compute(false);
    }
    else if (option == 1){
      compute(true);
    }
  }
}