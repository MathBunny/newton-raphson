import javax.swing.*;
import java.awt.event.*;

/**
 * @author Horatiu Lazu
 * @version 1.0.0.0
 */

public class NewtonRaphsonApp extends JFrame{
	
	private JPanel buttonPanel;
	private JPanel screen;
	
	/**
	 * The purpose of this method is to start the program, as this is the main method.
	 * @param args String [] The purpose of this is to pass arguements to the main method.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NewtonRaphsonApp();
	}
	
	/**
	 * This method sets the JFrame, and calls the super-class to set the title of the JFrame.
	 */
	public NewtonRaphsonApp(){
		super("Newton Raphson Approximation Utility - Horatiu Lazu");
		super.setSize(500,500);
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//super.setVisible(true);
		
		buttonPanel = new JPanel();
		screen = new JPanel();
		addButtonsToPanel();
		
		
		add(buttonPanel);
		//add(screen);
		
		super.setVisible(true);
		
		
	}
	
	public void actionPeformed(ActionEvent ae){
		if (ae.getActionCommand().equals("Hello World"))
			System.out.println("Works");
		System.out.println("Hello World...");
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
		
		JButton calc = new JButton("=");
		//calc.setSize(40,40);
		//calc.setLocation(5,5);
		
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
}
