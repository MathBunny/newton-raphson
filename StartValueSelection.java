import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.text.*;


@SuppressWarnings("serial")
public class StartValueSelection extends JFrame implements MouseListener{
  JTable panel = new JTable();
  Image backgroundImg;
  double guess;
  double ans = Integer.MAX_VALUE;
  static int iterations = Integer.MAX_VALUE;
  
  public StartValueSelection(){
    super("Commencing Values (Newton Raphson) - Horatiu Lazu");
    addMouseListener(this);
    setResizable(false);
    
    useGivenValue();
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
    
    
    
    setSize(500, 300);
    setVisible(true);
  }
  
  public void drawHighlight(Graphics g){
    //implement highlighting
    
  }
  
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
  
  public void compute(){
    Operation.setOperation(NewtonRaphsonApp.getCommand());
    ans = Operation.compute(guess);
    
    if (ans == Integer.MAX_VALUE){
      JOptionPane.showMessageDialog(this, "Error: Time-out. Please try another guess, or change the expression.");
    }
    else{
      JOptionPane.showMessageDialog(this, "Solution found, there is a root at: x = " + (Operation.compute(guess)));
    }
  }
  
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
    
    //g.setFont(new Font("Helvetica", Font.PLAIN, 20));
    if (NewtonRaphsonApp.getCommand().length() > 10)
      g.drawString((NewtonRaphsonApp.getCommand()+ "").substring(0, 10), 80, 57);
    else
      g.drawString((NewtonRaphsonApp.getCommand()+ ""), 80, 57);
    
  }
  
  public void paint(Graphics g){
    super.paint(g);
    fetchImage();
    
    g.drawImage(backgroundImg, 0, 0, null);
    drawHighlight(g);
    drawText(g);
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
      adjustGuess();
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
