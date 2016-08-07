import java.io.*;

public class NewtonRaphsonConsole{
  public NewtonRaphsonConsole(){}
  
  public static void main (String [] args){
    NewtonRaphsonConsole nrConsole = new NewtonRaphsonConsole();
    while(true){
      nrConsole.mainMenu();
    }
  }
  
  public void compute(boolean shouldShowSteps){
    
    
  }
  
  public int getInput(){
    while(true){ //quit
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
      //
      System.out.println("Please input expression.");
      //System.out.println(new NumericalTokenizer().convertToSpacedNumericalFormat("log(X)")); //works! wtf lol
      try{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Operation.setOperation(InfixToPostfix.infixToPostfix(new NumericalTokenizer().convertToSpacedNumericalFormat(in.readLine())));
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
    }
    else if (option == 1){
      //
    }
  }
}