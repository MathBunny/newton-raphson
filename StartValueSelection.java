import javax.swing.*;
import java.awt.*;


public class StartValueSelection extends JFrame{
	
	public StartValueSelection(boolean providedInitial){
		super("Commencing Values (Newton Raphson) - Horatiu Lazu");
		setResizable(false);
		
		if (providedInitial)
			useGivenValue();
		else
			identifyStartingValue();
	}
	
	private void useGivenValue(){
		setSize(300, 300);
		setVisible(true);
	}
	
	private void identifyStartingValue(){
		setSize(500, 400);
		setVisible(true);
	}
}
