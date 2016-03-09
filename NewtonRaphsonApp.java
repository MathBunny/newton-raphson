import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

/**
 * @author Horatiu Lazu
 * @version 1.0.0.0
 */

@SuppressWarnings("serial")
public class NewtonRaphsonApp extends JFrame implements ActionListener, MouseListener{
  private JPanel buttonPanel;
  private static final int UPPER_BUFFER = 100;
  private Image backgroundImg;
  private Image display;
  private Image highlight;
  private Image displayInitialize;
  private Image displayOff;
  private Image maxChar;
  
  private boolean drawHighlight = false; //temporary
  private int highlightX = 0;
  private int highlightY = 0;
  private boolean drawZero = false;
  private boolean turnedOn = false;
  private boolean turnedOff = true;
  private boolean off = true;
  
  private static String command = "";
  
  /**
   * The purpose of this method is to start the program, as this is the main method.
   * @param args String [] The purpose of this is to pass arguements to the main method.
   */
  public static void main(String[] args) {
    new NewtonRaphsonApp();
  }
  
  /**
   * This method returns the command.
   * @return String The command.
   */
  
  public static String getCommand(){
    return command;
  }
  
  /**
   * This method sets the JFrame, and calls the super-class to set the title of the JFrame.
   */
  public NewtonRaphsonApp(){
    super("Newton Raphson Approximation Utility - Horatiu Lazu");
    setSize(465,351);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setResizable(false);
    
    buttonPanel = new JPanel();
    //screen = new JPanel();
    //addButtonsToPanel();
    
    add(buttonPanel);
    //add(screen);
    addMenuBar();
    
    addMouseListener(this);
    setVisible(true);
  }
  
  /**
   * This method gets the background from the folder.
   * @throws IOException This throws an IOException if an error occurs.
   */
  private void fetchImages(){
    try{
      backgroundImg = ImageIO.read(new File("images/CalculatorBackground.jpg"));
      display = ImageIO.read(new File("images/monitor.jpg"));
      highlight = ImageIO.read(new File("images/highlight.png"));
      displayInitialize = ImageIO.read(new File("images/initializing.jpg"));
      displayOff = ImageIO.read(new File("images/off.jpg"));
      maxChar = ImageIO.read(new File("images/monitor_max.jpg"));
    }
    catch(IOException e){
      JOptionPane.showMessageDialog(this, "Error: Could not find the image file!");
    }
  }
  
  
  /**
   * This method adds the menu-bar.
   */
  private void addMenuBar(){
    JMenuBar menu = new JMenuBar();
    
    JMenu file = new JMenu("File");
    JMenu help = new JMenu ("Help");
    
    JMenuItem quit = new JMenuItem("Quit");
    quit.addActionListener(this);
    
    JMenuItem about = new JMenuItem("About");
    about.addActionListener(this);
    
    file.add(quit);
    help.add(about);
    
    menu.add(file);
    menu.add(help);
    
    setJMenuBar(menu);
  }
  
  /**
   * This method draws the interface with the grid-like display.
   * @param g This is the reference variable for the graphics class.
   */
  private void drawInterface(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    for(int i = 0; i < 6; i++){
      g2d.drawLine(0,UPPER_BUFFER + i * 50, 464, UPPER_BUFFER + i * 50);
    }
    for(int i = 0; i < 9; i++){
      g2d.drawLine(i * 58, UPPER_BUFFER, i * 58, 350);
    }
  }
  
  private void drawHighLight(Graphics g){
    if (!drawHighlight)
      return;
    if (drawZero){
      // TODO Draw zero in.
    }
    else{
      g.drawImage(highlight, 58 * highlightX,  100 + 50 * highlightY,  null);
    }
  }
  
  
  private void updateScreen(Graphics g){
    g.setFont(new Font("Helvetica", Font.PLAIN, 30));
    g.setColor(Color.white);
    g.drawString(command, 113, 85);
  }
  
  
  public void paint(Graphics g){
    super.paint(g);
    fetchImages();
    
    g.drawImage(backgroundImg, 0, 100, null);
    if (!turnedOff && !turnedOn && !off){
      if (command.length() <= 18)
        g.drawImage(display,  0,  44,  490,  57,  null);
      else
        g.drawImage(maxChar, 0, 44, 490, 57, null);
    }
    else if (turnedOn){
      off=false;
      command = "";
      g.drawImage(displayInitialize, 0, 44, 490, 57, null);
      try{
        Thread.sleep(50);
      }
      catch(Exception e){}
      g.drawImage(display,  0,  44,  490,  57,  null);
    }
    else{
      off = true;
      g.drawImage(displayOff, 0, 44, 490, 57, null);
      command = "";
    }
    
    drawHighLight(g);
    drawInterface(g);
    updateScreen(g);
  }
  
  /**
   * This method handles all events in the program.
   * @param arg0 This variable stores the action command.
   */
  @Override
  public void actionPerformed(ActionEvent arg0) {
    String cmd = arg0.getActionCommand();
    if (cmd.equals("Quit"))
      System.exit(0);
    else
      new About();
  }
  
  
  @Override
  public void mouseClicked(MouseEvent arg0) {}
  
  @Override
  public void mouseEntered(MouseEvent arg0) {}
  
  @Override
  public void mouseExited(MouseEvent arg0) {}
  
  private void updateCommand(int x, int y){
    
    if (x == 0 && y == 0){
      command += "X";
    }
    // TODO Add restrictions on when you press certain buttons.
    // TODO Convert to 2D String map for operations 
    if (x == 0 && y == 1) //add restriction...
      command += ")^2";
    
    if (x == 0 && y == 2)
      command += ")^3";
    
    if (x == 0 && y == 3)
      command += ")^4";
    
    if (x == 0 && y == 4)
      command += ")^5";
    
    if (x == 0 && (y > 0)){ // TODO use last operation method
      if (!InputVerification.isValidExponent(command)){
        JOptionPane.showMessageDialog(this,
                                      "Notice: You cannot apply an exponential function without an expression enclosed in brackets.",
                                      "Notice: Invalid Operation",
                                      JOptionPane.ERROR_MESSAGE);
        command = command.substring(0, command.length()-3);
        return;
      }
      if (!InputVerification.hasRepeatedInvalidOperators(command)){
        JOptionPane.showMessageDialog(this,
                                      "Fatal Error: Invalid Input! You cannot have repeated / invalid operators.",
                                      "Fatal Error: Invalid Input",
                                      JOptionPane.ERROR_MESSAGE);
        command = command.substring(0, command.length() -3);
        return;
      }
    }
    if (x == 1 && y == 0){
      JOptionPane.showMessageDialog(this,
                                    "Notice: This operation is not supported in this version!",
                                    "Notice: Unsupported Operation",
                                    JOptionPane.ERROR_MESSAGE);
      //command += "ln(";
    }
    
    if (x == 1 && y == 1){
      command += "log10(";
    }
    
    if (x == 1 && y == 2){
      command += "Ã";
    }
    
    if (x == 1 && y == 3){
      //command += "3Ã"; //not ideal...
      JOptionPane.showMessageDialog(this,
                                    "Notice: This operation is not supported in this version! You may use an exponent to the power of 1/3 instead.",
                                    "Notice: Unsupported Operation",
                                    JOptionPane.ERROR_MESSAGE);
      return;
    }
    
    if (x == 1 && y == 4){
      //command += "4Ã";
      JOptionPane.showMessageDialog(this,
                                    "Notice: This operation is not supported in this version! You may use an exponent to the power of 1/4 instead.",
                                    "Notice: Unsupported Operation",
                                    JOptionPane.ERROR_MESSAGE);
      return;
    }
    
    if (x == 2 && y == 0){
      command += "sin(";
    }
    
    if (x == 2 && y == 1){
      command += "cos(";
    }
    
    if (x == 2 && y == 2){
      command += "tan(";
    }
    
    if (x == 2 && y == 3){
      command += "(";
    }
    
    if (x == 2 && y == 4){
      command += ")";
    }
    
    if (x == 3 && y == 0){
      command += "sinh(";
    }
    
    if (x == 3 && y == 1){
      command += "cosh(";
    }
    
    if (x == 3 && y == 2){
      command += "tanh(";
    }
    
    if (x == 3 && y == 3){
      command += "^(";
    }
    
    if (x == 3 && y == 4){
      JOptionPane.showMessageDialog(this,
                                    "Notice: Decimals are not supported in this version!",
                                    "Notice: Unsupported Operation",
                                    JOptionPane.ERROR_MESSAGE);
      return;
    }
    
    if (x == 4 && y == 1){
      command += "7";
    }
    
    if (x == 4 && y == 2){
      command += "4";
    }
    
    if (x == 4 && y == 3){
      command += "1";
    }
    
    if (y == 4 && (x == 4 || x == 5 || x == 6)){
      command += "0";
    }
    
    if (x == 5 && y == 1){
      command += "8";
    }
    
    if  (x == 5 && y == 2){
      command += "5";
    }
    
    if (x == 5 && y == 3){
      command += "2";
    }
    
    if (x == 6 && y == 1){
      command += "9";
    }
    
    if (x == 6 && y == 2){
      command += "6";
    }
    
    if (x == 6 && y == 3){
      command += "3";
    }
    
    if (x == 7 && y == 0){
      //command += "Ö";
      command += "/";
    }
    
    if (x == 7 && y == 1){
      //command += "x";
      command += "*";
    }
    
    if (x == 7 && y == 3){
      //command += "+";
      command += "+";
    }
    
    if (x == 7 && y == 2){
      command += "-";
    }
    
    verifyCommandValidity(false);
    
  }
  
  
  private void removeLastOperation(){
    command = command.substring(0, command.length()-1);
  }
  
  private boolean verifyCommandValidity(boolean isFinal){
    if (!InputVerification.hasBalancedBrackets(command, isFinal)){
      JOptionPane.showMessageDialog(this,
                                    "Fatal Error: You have invalid bracket proportions!",
                                    "Fatal Error: Invalid Input",
                                    JOptionPane.ERROR_MESSAGE);
      removeLastOperation();
      return false;
    }
    if (!InputVerification.hasRepeatedInvalidOperators(command)){
      JOptionPane.showMessageDialog(this,
                                    "Fatal Error: Invalid Input! You cannot have repeated / invalid operators.",
                                    "Fatal Error: Invalid Input",
                                    JOptionPane.ERROR_MESSAGE);
      removeLastOperation();
      return false;
    }
    return true;
  }
  
  private void calculate(){
    if (!verifyCommandValidity(true))
      return;
    if (command.equals("")){
      JOptionPane.showMessageDialog(this,
                                    "Fatal Error: You cannot calculate without inputting an equation!",
                                    "Fatal Error: Invalid Input",
                                    JOptionPane.ERROR_MESSAGE);
      return;
    }

    new StartValueSelection();
    
  }
  
  
  @Override
  public void mousePressed(MouseEvent arg0) {
    // TODO: Make this code more KISS?
    int x = arg0.getX() /58;
    int y = (arg0.getY() -100) / 50;
    //x = x / 58;
    //y = (y - 100)/50;
    
    //System.out.println("Mouse Pressed: (" + x + "," + y + ")");
    if (x < 0 || x > 7 || y < 0 || y > 4)
      return;
    if (x == 4 && y == 0){
      turnedOn = true;   
    }
    else{
      turnedOn = false;
    }
    if (x == 5 && y == 0){
      turnedOff = true;
    }
    else{
      turnedOff = false;
    }
    
    drawHighlight = true;
    if (x >=4 && x <= 6 && y == 4)
      drawZero = true;
    else
      drawZero = false;
    highlightX = x;
    highlightY = y;
    if (off)
      return;
    
    if (x == 7 && y == 4){ //calculate button
      calculate();
      return; //return?
    }
    
    if (x == 6 && y == 0){
      command = "";
      //repaint();
    }
    if (command.length() > 18){
      return;
    }
    updateCommand(x, y);
    repaint();
    
  }
  
  @Override
  public void mouseReleased(MouseEvent arg0) {
    // TODO: Take away the blue animation
    drawHighlight = false;
    repaint();
  }
  
}
