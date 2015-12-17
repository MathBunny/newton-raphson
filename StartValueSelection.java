import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.*;
import java.io.*;


@SuppressWarnings("serial")
public class StartValueSelection extends JFrame implements ActionListener{
  JTable panel = new JTable();
  Image backgroundImg;
    
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
  
  public void drawHighlight(Graphics g){
    
    
  }
  
  public void fetchImage(){
    try{
      backgroundImg = ImageIO.read(new File("StartStopValue.png"));
    }
    catch(IOException e){
      JOptionPane.showMessageDialog(this, "Error: Could not find the image file!");
    }
  }
  
  public void paint(Graphics g){
    super.paint(g);
    fetchImage();
    
    g.drawImage(backgroundImg, 0, 100, null);
    drawHighlight(g);
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
