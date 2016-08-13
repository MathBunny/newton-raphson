package classes;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.text.*;

/** This class shows the root of an expression, and allows the user to modify their estimates. 
  * @author Horatiu Lazu
  * @version 1.0 */
@SuppressWarnings("serial")
public class StartValueSelection extends JFrame implements MouseListener{
  /** panel JPanel This is the panel that is used for the graphics */
  JTable panel = new JTable();
  /** backgroundIMg Image This is the background image. */
  Image backgroundImg;
  /** guess Double This is the estimated provided for Newton's algorithm. */
  double guess;
  /** ans Double This is the answer pre-set */
  double ans = Double.MAX_VALUE;
  /** iterations int This is the number of iterations that were used */
  static int iterations = Integer.MAX_VALUE;
  
  /** This is the class constructor */
  public StartValueSelection(){
    super("Commencing Values (Newton Raphson) - Horatiu Lazu");
    addMouseListener(this);
    setResizable(false);
    useGivenValue();
  }
  
  /** This method sets up the JFrame for finding the root based off of a starting value. 
    * @throws NumberFormatException This is in case of entering letters or symbols in the textbox
    * @throws NullPointerException This is in case nothing is entered
    */
  private void useGivenValue(){
    while(true){
      String s = JOptionPane.showInputDialog("Please enter your guess. Numbers only!");
      try{
        if (s == null){
          setVisible(false);
          return;
        }
        guess = Double.parseDouble(s);
        Operation.setOperation(NewtonRaphsonApp.getCommand());
        if (Operation.derivative(guess) <= Operation.ACCURACY){
          JOptionPane.showMessageDialog(null, "Error: The slope of the tangent is zero! Enter a valid guess point, or enter an expression with a possible root.", "Error: Slope is zero.", JOptionPane.PLAIN_MESSAGE);
        }else
          break;
      }
      catch(NullPointerException e){
        setVisible(false);
        return;
      }
    }
    setSize(500, 300);
    setVisible(true);
  }
  
  /** This draws the highlight.
    * @param g Graphics Reference to the graphics of the frame. */
  public void drawHighlight(Graphics g){}
  
  /** This method adjusts the guess by the user 
    * @throws NumberFormatException This is in case of entering letters or symbols in the textbox
    * @throws NullPointerException This is in case nothing is entered 
    */
  public void adjustGuess(){
    while(true){
      String s = JOptionPane.showInputDialog("Please enter your guess. Numbers only!");
      try{
        if (s == null){
          setVisible(false);
          return;
        }
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
      catch(NullPointerException e){
        setVisible(false);
        return;
      }
    }
    
  }
  
  /** This method computes the answer. */
  public void compute(){
    Operation.setOperation(NewtonRaphsonApp.getCommand());
    ans = Operation.compute(guess);
    
    if (ans == Integer.MAX_VALUE)
      JOptionPane.showMessageDialog(this, "Error: Time-out. Please try another guess, or change the expression.");
    else
      JOptionPane.showMessageDialog(this, "Solution found, there is a root at: x = " + (Operation.compute(guess)));
    
  }
  
  /** This method fetches the image from the folder. */
  public void fetchImage(){
    try{
      backgroundImg = ImageIO.read(new File("images/StartStopValue.png"));
    }
    catch(IOException e){
      JOptionPane.showMessageDialog(this, "Error: Could not find the image file!");
    }
  }
  
  
  /** The following draws the text in the StartValueSelection. */
  public void drawText(Graphics g){
    g.setFont(new Font("Helvetica", Font.PLAIN, 30));
    g.setColor(Color.white);
    DecimalFormat dF = new DecimalFormat("0.00000000");
    g.drawString((ans == Integer.MAX_VALUE) ? ("Unknown") : (dF.format(ans)), 255, 103);
    g.drawString(guess+ "", 255, 148);
    
    Operation.setOperation(NewtonRaphsonApp.getCommand());
    dF = new DecimalFormat("0.000000");
    g.drawString(dF.format(Operation.derivative(guess)), 338, 57);
    
    g.drawString((iterations == Integer.MAX_VALUE) ? ("Unknown") : (iterations + ""), 255, 192);
    
    if (NewtonRaphsonApp.getCommand().length() > 10)
      g.drawString((NewtonRaphsonApp.getCommand()+ "").substring(0, 10), 80, 57);
    else
      g.drawString((NewtonRaphsonApp.getCommand()+ ""), 80, 57);
    
  }
  
  /** This method redraws the image.
    * @param g Graphics This is a graphics reference variable. */
  public void paint(Graphics g){
    super.paint(g);
    fetchImage();
    
    g.drawImage(backgroundImg, 0, 0, null);
    drawHighlight(g);
    drawText(g);
  }
  
  /** This method is for when the start value will be automatically detected. This feature will become later. */
  private void identifyStartingValue(){
    System.out.println("This function is not available yet!");
  }
  
  /** This method is for when the mouse is pressed.
    * @param e MouseEvent This is a referrence variable */
  public void mousePressed(MouseEvent e) {}
  
  /** This is for when the mouse is released.
    * @param arg0 MouseEvent This is a reference variable. */
  public void mouseReleased(MouseEvent arg0) {
    repaint();
  }
  
  /** This method reacts when the mouse was clicked.
    * @param e MouseEvent This is a reference variable */
  public void mouseClicked(MouseEvent e) {
    System.out.println(e.getX() + " " + e.getY());
    int x = e.getX();
    int y = e.getY();
    
    if (x >= 11 && x <= 186 && y >= 220 && y <= 284)
      adjustGuess();
    else if (x >= 220 && x <= 395 && y >= 220 && y <=284)
      compute();
    else if (x >= 426 && x <= 489 && y >= 219 && y <= 297)
      setVisible(false);
    
  }
  
  /** This method is called when the mouse is entered.
    * @param arg0 MouseEvent This is a reference variable */
  public void mouseEntered(MouseEvent arg0) {}
  
  /** This method is called when the mouse is exited.
    * @param arg0 MouseEvent This is a reference to the MouseEvent class */
  public void mouseExited(MouseEvent arg0) {}
}
