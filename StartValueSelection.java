import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class StartValueSelection extends JFrame implements ActionListener{
	
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

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
