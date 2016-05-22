import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;


/** This class acts as the runner and allows the user to enter equation information.
  * @author Horatiu Lazu
  * @version 1.0.0.0
  */

@SuppressWarnings("serial")
public class NewtonRaphsonApp extends JFrame implements ActionListener, MouseListener{
  /** buttonPanel JPanel Stores the calculator */
  private JPanel buttonPanel;
  /** UPPER_BUFFER int This is the gap from the screen and calculator buttons */
  private static final int UPPER_BUFFER = 100;
  /** backgroundImg Image This is the background image file */
  private Image backgroundImg;
  /** display Image This is the background image file for the calculator screen */
  private Image display;
  /** highlight Image This is the highlight for the calculator buttons */
  private Image highlight;
  /** displayInitialize Image This is the display initialization screen */
  private Image displayInitialize;
  /** displayOff Image This is the image shown when the program is off */
  private Image displayOff;
  /** maxChar Image This is the maximum character exceeded image */
  private Image maxChar;
  /** drawHighlight boolean This stores if the highlight should be drawn */
  private boolean drawHighlight = false; //temporary
  /** highlightX int This stores the x coordinate of the past hightlight */
  private int highlightX = 0;
  /** highlightY int This stores the y coordinate of the past highlight */
  private int highlightY = 0;
  /** drawzero boolean This stores if the zero button should be highlighted */
  private boolean drawZero = false;
  /** turnedOn boolean This stores if the calculator is turned on */
  private boolean turnedOn = false;
  /** turnedOff boolean This stores if the calculator's current paused state is off */
  private boolean turnedOff = true;
  /** off boolean This stores if the calculator was ever on */
  private boolean off = true;
  /** command String This stores the current selected command */
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
    add(buttonPanel);
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
      JOptionPane.showMessageDialog(this, "Error: Could not find required image files!");
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
  
  /** This method draws the hightlights
    * @param g Graphics This object is a reference variable for the form's graphcis */
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
  
  /** This method updates the screen's text.
    * @param g Graphics This is the graphics reference variable */
  
  private void updateScreen(Graphics g){
    g.setFont(new Font("Helvetica", Font.PLAIN, 30));
    g.setColor(Color.white);
    g.drawString(command, 113, 85);
  }
  
  /** This method paints the screen of the calculator.
    * @param g Graphics This is the graphcis reference variable */
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
  
  
  /** This method is for when the mouse is clicked.
    @param arg0 This is a MouseEvent reference variable */
    @Override
    public void mouseClicked(MouseEvent arg0) {}
    
    /** This method is for when the mouse is entered.
      * @param arg0 This is a MouseEvent reference variable */
    @Override
    public void mouseEntered(MouseEvent arg0) {}
    
    /** This method is for when the mouse is exited.
      * @param arg0 MouseEvent This is a MouseEvent reference variable */
    @Override
    public void mouseExited(MouseEvent arg0) {}
    
    /** This method informs the user that a certain feature is not available. */
    
    private void outputNotSupported(){
      JOptionPane.showMessageDialog(this,"Notice: This operation is not supported in this version! You may use an exponent to the power of 1/4 instead.","Notice: Unsupported Operation",JOptionPane.ERROR_MESSAGE);
    }
    
    /** This updates the current command demanding on where the mouse was clicked.
      * @param x int This is the x-coordinate
      * @param y int This is the y-coordinate */
    
    private void updateCommand(int x, int y){
      
      if (x == 0 && y == 0){
        command += "X";
      }
      // TODO Add restrictions on when you press certain buttons.
      // TODO Convert to 2D String map for operations 
      else if (x == 0 && y == 1) //add restriction...
        command += ")^2";
      
      else if (x == 0 && y == 2)
        command += ")^3";
      
      else if (x == 0 && y == 3)
        command += ")^4";
      
      else if (x == 0 && y == 4)
        command += ")^5";
      
      else if (x == 0 && (y > 0)){ // TODO use last operation method
        if (!InputVerification.isValidExponent(command)){
          JOptionPane.showMessageDialog(this,"Notice: You cannot apply an exponential function without an expression enclosed in brackets.","Notice: Invalid Operation",JOptionPane.ERROR_MESSAGE);
          command = command.substring(0, command.length()-3);
          return;
        }
        if (!InputVerification.hasRepeatedInvalidOperators(command)){
          JOptionPane.showMessageDialog(this,"Fatal Error: Invalid Input! You cannot have repeated / invalid operators.","Fatal Error: Invalid Input",JOptionPane.ERROR_MESSAGE);
          command = command.substring(0, command.length() -3);
          return;
        }
      }
      else if (x == 1 && y == 0){
        outputNotSupported();
        return;
        //command += "ln(";
      }
      
      else if (x == 1 && y == 1){
        command += "log10(";
      }
      
      else if (x == 1 && y == 2){
        command += "Ã";
      }
      
      else if (x == 1 && y == 3){
        //command += "3Ã"; //not ideal...
        outputNotSupported();
        return;
      }
      
      else if (x == 1 && y == 4){
        //command += "4Ã";
        outputNotSupported();
        return;
      }
      
      else if (x == 2 && y == 0){
        command += "sin(";
      }
      
      else if (x == 2 && y == 1){
        command += "cos(";
      }
      
      else if (x == 2 && y == 2){
        command += "tan(";
      }
      
      else if (x == 2 && y == 3){
        command += "(";
      }
      
      else if (x == 2 && y == 4){
        command += ")";
      }
      
      else if (x == 3 && y == 0){
        command += "sinh(";
      }
      
      else if (x == 3 && y == 1){
        command += "cosh(";
      }
      
      else if (x == 3 && y == 2){
        command += "tanh(";
      }
      
      else if (x == 3 && y == 3){
        command += "^(";
      }
      
      else if (x == 3 && y == 4){
        JOptionPane.showMessageDialog(this,
                                      "Notice: Decimals are not supported in this version!",
                                      "Notice: Unsupported Operation",
                                      JOptionPane.ERROR_MESSAGE);
        return;
      }
      
      else if (x == 4 && y == 1){
        command += "7";
      }
      
      else if (x == 4 && y == 2){
        command += "4";
      }
      
      else if (x == 4 && y == 3){
        command += "1";
      }
      
      else if (y == 4 && (x == 4 || x == 5 || x == 6)){
        command += "0";
      }
      
      else if (x == 5 && y == 1){
        command += "8";
      }
      
      else if  (x == 5 && y == 2){
        command += "5";
      }
      
      else if (x == 5 && y == 3){
        command += "2";
      }
      
      else if (x == 6 && y == 1){
        command += "9";
      }
      
      else if (x == 6 && y == 2){
        command += "6";
      }
      
      else if (x == 6 && y == 3){
        command += "3";
      }
      
      else if (x == 7 && y == 0){
        //command += "Ö";
        command += "/";
      }
      
      else if (x == 7 && y == 1){
        //command += "x";
        command += "*";
      }
      
      else if (x == 7 && y == 3){
        //command += "+";
        command += "+";
      }
      
      else if (x == 7 && y == 2){
        command += "-";
      }
      
      verifyCommandValidity(false);
      
    }
    
    /** This helper method removes the last operation */
    private void removeLastOperation(){
      command = command.substring(0, command.length()-1);
    }
    
    /** This method calculates the validity of a command.
      * @param isFinal boolean This determines if it is the final computation (in which case different things need to be verified, for example appropriate closing brackets)
      * @return boolean This determines if it is valid.
      */
    
    private boolean verifyCommandValidity(boolean isFinal){
      if (!InputVerification.hasBalancedBrackets(command, isFinal)){
        JOptionPane.showMessageDialog(this,"Fatal Error: You have invalid bracket proportions!","Fatal Error: Invalid Input",JOptionPane.ERROR_MESSAGE);
        removeLastOperation();
        return false;
      }
      if (!InputVerification.hasRepeatedInvalidOperators(command)){
        JOptionPane.showMessageDialog(this,"Fatal Error: Invalid Input! You cannot have repeated / invalid operators.","Fatal Error: Invalid Input",JOptionPane.ERROR_MESSAGE);
        removeLastOperation();
        return false;
      }
      return true;
    }
    
    private void calculate(){
      if (!verifyCommandValidity(true))
        return;
      if (command.equals("")){
        JOptionPane.showMessageDialog(this,"Fatal Error: You cannot calculate without inputting an equation!","Fatal Error: Invalid Input",JOptionPane.ERROR_MESSAGE);
        return;
      }
      new StartValueSelection();
    }
    
    /** This method gets the x position and y position of a click
      * @param arg0 MouseEvent This is a MouseEvent reference variable */
    
    @Override
    public void mousePressed(MouseEvent arg0) {
      // TODO: Make this code more KISS?
      int x = arg0.getX() / 58;
      int y = (arg0.getY() -100) / 50;
      //x = x / 58;
      //y = (y - 100)/50;
      
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
      }
      if (command.length() > 18){
        return;
      }
      updateCommand(x, y);
      repaint();
    }
    
    /** This method is invoked when the mouse is released, and takes out the highlight.
      * @param arg0 MouseEvent This is a MouseEvent reference variable */
    
    @Override
    public void mouseReleased(MouseEvent arg0) {
      // TODO: Take away the blue animation
      drawHighlight = false;
      repaint();
    }
    
}
