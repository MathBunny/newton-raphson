import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class StartValueSelection extends JFrame implements ActionListener{
  JTable panel = new JTable();
    
    
  public StartValueSelection(boolean providedInitial){
    super("Commencing Values (Newton Raphson) - Horatiu Lazu");
    setResizable(false);
    
    if (providedInitial)
      useGivenValue();
    else
      identifyStartingValue();
  }
  
  /** This method sets up the JFrame for finding the root based off of a starting value. */
  private void useGivenValue(){
    
    
    //JButton computeDerivative = new JButton("kjfdsljdklsjf");
    //computeDerivative.setSize(200,30);
    //computeDerivative.setLocation(300,5);
    
    
    JButton evaluateExpression = new JButton("Evaluate Expresssion");
    evaluateExpression.setSize(200,30);
    evaluateExpression.setLocation(300,100);
    
    JButton nextStep = new JButton("Next Step");
    evaluateExpression.setSize(200,30);
    evaluateExpression.setLocation(200,200);
    
    JButton computeRoot = new JButton("Compute Root");
    computeRoot.setSize(200,30);
    computeRoot.setLocation(200,300);
    
    
    //panel.add(computeDerivative);
    panel.add(evaluateExpression);
    panel.add(computeRoot);
    
    
    
    add(panel);
    
    
    
    
    setSize(500, 500);
    setVisible(true);
  }
  
  private void identifyStartingValue(){
    setSize(700, 500);
    setVisible(true);
  }
  
  
  @Override
  public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub
    
  }
}
