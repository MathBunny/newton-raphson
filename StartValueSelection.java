import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.*;
import java.io.*;


@SuppressWarnings("serial")
public class StartValueSelection extends JFrame implements MouseListener{
  JTable panel = new JTable();
  Image backgroundImg;
  double guess;
  
  public StartValueSelection(boolean providedInitial){
    super("Commencing Values (Newton Raphson) - Horatiu Lazu");
    addMouseListener(this);
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
    
    
    //add(panel);
    
    while(true){
      String s = JOptionPane.showInputDialog("Please enter your guess. Numbers only!");
      try{
        guess = Double.parseDouble(s);
        Operation.setOperation(NewtonRaphsonApp.getCommand());
        if (Operation.derivative(guess) <= Operation.ACCURACY){
          JOptionPane.showMessageDialog(null, "Error: The slope of the tangent is zero! Enter a valid guess point, or enter an expression with a possible root.", "Error: Slope is zero.", JOptionPane.PLAIN_MESSAGE);
        }else
          break;
      }
      catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Error: Please enter a double!", "Error: Input Invalid", JOptionPane.PLAIN_MESSAGE);
      }
    }
    
    
    
    setSize(500, 300);
    setVisible(true);
  }
  
  public void drawHighlight(Graphics g){
    //implement highlighting
    
  }
  
  public void nextIteration(){
    JOptionPane.showMessageDialog(this, "This feature is coming soon!");
    
  }
  
  public void compute(){
    Operation.setOperation(NewtonRaphsonApp.getCommand());
    JOptionPane.showMessageDialog(this, (Operation.compute(guess) + " = ANSWER!"));
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
    
    g.drawImage(backgroundImg, 0, 0, null);
    drawHighlight(g);
  }
  
  private void identifyStartingValue(){
    System.out.println("This function is not available yet!");
    //setSize(500, 300);
    // setVisible(true);
  }
  
  public void mousePressed(MouseEvent e) {
    //System.out.println(e.getX() + " " + e.getY());
    
  }
  
  public void mouseReleased(MouseEvent arg0) {
    // TODO: Take away the blue animation
    //drawHighlight = false;
    repaint();
  }
  
  public void mouseClicked(MouseEvent e) {
    System.out.println(e.getX() + " " + e.getY());
    int x = e.getX();
    int y = e.getY();
    if (x >= 11 && x <= 186 && y >= 220 && y <= 284){
      System.out.println("left button");
      nextIteration();
    }
    else if (x >= 220 && x <= 395 && y >= 220 && y <=284){
      System.out.println("middle button");
      compute();
    }
    else if (x >= 426 && x <= 489 && y >= 219 && y <= 297){
      System.out.println("BACK!");
      setVisible(false);
    }
  }

  public void mouseEntered(MouseEvent arg0) {}
 
  public void mouseExited(MouseEvent arg0) {}
}
