/*
 * ControlPanel.java
 * This class defines a panel under the main panel
 * It contains a button which will control the animation(start animation&stop animation)
 */
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class ControlPanel extends javax.swing.JPanel implements GameController{

	private MainPanel _mainPanel;//The control panel should know about the main panel
	private javax.swing.JButton _button;
	private int _status;//0=start animation; 1=stop animation;
	
	public ControlPanel(MainPanel mainPanel){
		super();
		_mainPanel = mainPanel;
		//add the button to the panel
		_button = new javax.swing.JButton("Start animation");
		//register an action listener to this button
		_button.addActionListener(new StartAnimationListener());
		this.add(_button);
		//the default status for the button should be "start animation"
		_status = 0;
	}
	
	@Override
	public JPanel getIoPanel(){
		return this;
	}
	
	@Override
	//start the animation
	public void startAnimation(){
		_mainPanel.GameStart();
	}

	@Override
	//stop the animation
	public void stopAnimation() {
		_mainPanel.GameStop();
	}
	
	//the action listener to be registered to the button
	private class StartAnimationListener implements java.awt.event.ActionListener{

		@Override
		//action taken when click the button
		public void actionPerformed(ActionEvent e) {
			//if the current status is to start the animation, 
			//then when click it, start animation and make the text to be "stop animation" 
			if(_status == 0){
				_mainPanel.GameStart();
				_button.setText("Stop animation");
				_status = 1;
			}
			//else, stop animation and make the text to be "start animation"
			else{
				_mainPanel.GameStop();
				_button.setText("Start animation");
				_status = 0;
			}
		}
		
	}
}
