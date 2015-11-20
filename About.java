import javax.swing.*;
import javax.imageio.ImageIO;

import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;
/**
 * The purpose of this class is to show an about box.
 * @author Horatiu Lazu
 * @version 1.0.0.0
 */

public class About extends JFrame implements ActionListener{
	private Image background;
	
	public About(){
		super("About Newton Raphson Approximation");
		setSize(250, 350);
		setResizable(false);
		
				
		addButton();
		
		fetchImage();
		repaint();
		validate();
		
		setVisible(true);
	}
	
	private void addButton(){
		JPanel panel = new JPanel();
		JButton quit = new JButton("Quit");
		panel.setLayout(null);
		quit.addActionListener(this);
		
		
		quit.setSize(100,30);
		quit.setLocation(80,270);
		
		panel.add(quit);
		add(panel);
	}
	
	private void fetchImage(){
		try{
			background = ImageIO.read(new File("About.jpg"));
		}
		catch(IOException e){
			JOptionPane.showMessageDialog(this, "Error: Could not find the image file!");
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(background,0,20,null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		setVisible(false);
	}
}
