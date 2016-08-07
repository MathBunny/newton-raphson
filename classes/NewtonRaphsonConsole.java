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
  
  public void mainMenu(){
    System.out.println("Main menu: " );
    System.out.println("1. Compute (with steps)");
    System.out.println("2. Compute (without steps)");
    System.out.println("3. Exit");
    int option = 2;
    while(true){ //quit
      try{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        option = Integer.parseInt(in.readLine());
        break;
      }
      catch(IOException e){
        System.out.println("Error: Please retry, an input error occured.");
      }
      catch(NumberFormatException e){
        System.out.println("Error: Please enter a number.");
      }
    }
    if (option == 3){
      System.exit(0);
    }
    else if (option == 2){
      //
      System.out.println(new NumericalTokenizer().convertToSpacedNumericalFormat("sin(X)")); //works! wtf lol
      Operation.setOperation(InfixToPostfix.infixToPostfix(new NumericalTokenizer().convertToSpacedNumericalFormat("sin(X)")));
      System.out.println(Operation.compute(2.0));
    }
    else if (option == 1){
      //
    }
  }
}