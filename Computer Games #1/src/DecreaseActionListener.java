import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DecreaseActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(CarrotFrame.CarrotNum > 0){ 
			CarrotFrame.CarrotNum --;
		}
	}

}
