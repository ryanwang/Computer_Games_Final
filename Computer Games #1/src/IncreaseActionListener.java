import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class IncreaseActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(CarrotFrame.CarrotNum < 9) {
			CarrotFrame.CarrotNum++;
		}		
	}
}
