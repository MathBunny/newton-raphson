import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;



/**
 * @author Horatiu Lazu
 * @version 1.0.0.0
 */

public class NewtonRaphsonApp extends JFrame implements ActionListener, MouseListener{
	private JPanel buttonPanel;
	private JPanel screen;
	private static final int UPPER_BUFFER = 100;
	private Image backgroundImg;
	private Image display;
	private Image highlight;
	private Image displayInitialize;
	private Image displayOff;
	
	private boolean drawHighlight = false; //temporary
	private int highlightX = 0;
	private int highlightY = 0;
	private boolean drawZero = false;
	private boolean turnedOn = false;
	private boolean turnedOff = true;
	
	/**
	 * The purpose of this method is to start the program, as this is the main method.
	 * @param args String [] The purpose of this is to pass arguements to the main method.
	 */
	public static void main(String[] args) {
		new NewtonRaphsonApp();
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
		screen = new JPanel();
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
			 backgroundImg = ImageIO.read(new File("CalculatorBackground.jpg"));
			 display = ImageIO.read(new File("monitor.jpg"));
			 highlight = ImageIO.read(new File("highlight.png"));
			 displayInitialize = ImageIO.read(new File("initializing.jpg"));
			 displayOff = ImageIO.read(new File("off.jpg"));
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
	 * @param g
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
	
	
	public void paint(Graphics g){
		super.paint(g);
		fetchImages();
		
		g.drawImage(backgroundImg, 0, 100, null);
		if (!turnedOff && !turnedOn)
			g.drawImage(display,  0,  44,  490,  57,  null);
		else if (turnedOn){
			g.drawImage(displayInitialize, 0, 44, 490, 57, null);
			try{
				Thread.sleep(1000);
			}
			catch(Exception e){}
			g.drawImage(display,  0,  44,  490,  57,  null);
		}
		else{
			g.drawImage(displayOff, 0, 44, 490, 57, null);
		}
		
		drawHighLight(g);
		drawInterface(g);
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
	
	/**
	 * This method adds all of the buttons to the JPanel, so that they can be used by the user.
	 */
	private void addButtonsToPanel(){
		//buttonPanel.setLayout(null);
		//JLabel hi = new JLabel("Hello World)");
		
		JButton [] numPad = new JButton[10];
		for(int i = 0; i < 10; i++)
			numPad[i] = new JButton(Integer.toString(i));
		numPad[0].setSize(30,30);
		
		
		JButton calc = new JButton("=");
		//calc.setSize(30,30);
		//calc.setLocation(0,5);
		
		JButton del = new JButton("del");
		
		JButton exponent = new JButton("^");
		
		JButton sqrt = new JButton("Ã");
		
		JButton multiplication = new JButton("*");
		
		JButton addition = new JButton("+");
		
		JButton subtraction = new JButton("-");
		
		JButton division = new JButton("/");
		
		JButton openBracket = new JButton("(");
		
		JButton closeBracket = new JButton(")");
		
		JButton sin = new JButton("sin(");
		
		JButton cos = new JButton("cos(");
		
		JButton tan = new JButton("tan(");
		
		JButton x = new JButton("x");
		
		/* Add all of the buttons to the JPanel */
		for(int i = 0; i < 10; i++)
			buttonPanel.add(numPad[i]);
		
		buttonPanel.add(calc);
		buttonPanel.add(del);
		buttonPanel.add(exponent);
		buttonPanel.add(sqrt);
		buttonPanel.add(multiplication);
		buttonPanel.add(addition);
		buttonPanel.add(subtraction);
		buttonPanel.add(division);
		buttonPanel.add(openBracket);
		buttonPanel.add(closeBracket);
		buttonPanel.add(sin);
		buttonPanel.add(cos);
		buttonPanel.add(tan);
		buttonPanel.add(x);
		
		buttonPanel.repaint();
		buttonPanel.revalidate();
		repaint();
		validate();
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO: Make this code more KISS?
		int x = arg0.getX() /58;
		int y = (arg0.getY() -100) / 50;
		//x = x / 58;
		//y = (y - 100)/50;
				
		System.out.println("Mouse Pressed: (" + x + "," + y + ")");
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
		repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO: Take away the blue animation
		drawHighlight = false;
		repaint();
	}

}
