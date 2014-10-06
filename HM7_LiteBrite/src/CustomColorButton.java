/*
 * CustomColorButton.java
 * This class add a button that will open a window 
 * let the users choose a custom color by themselves
 */
import javax.swing.ButtonGroup;


public class CustomColorButton extends javax.swing.JRadioButton{

	private java.awt.Color _color = java.awt.Color.white;
	private LiteBritePanel _britePanel;
	
	public CustomColorButton(boolean aSelected, 
			LiteBritePanel britePanel, ButtonPanel buttonPanel, 
			ButtonGroup aGroup) {
		super("Custom", aSelected);
		_britePanel = britePanel;
		buttonPanel.add(this);//add this button to a given panel
		aGroup.add(this);// add this button to a specific button group
		this.addActionListener(new CustomColorListener(this));//register the listener to this button
	}

	//inner class, which defines the action taken when select the button
	private class CustomColorListener implements java.awt.event.ActionListener{
		//should know about the button so that it can change the background color of the button
		private CustomColorButton _customColorButton;

		public CustomColorListener(CustomColorButton customColorButton){
			_customColorButton = customColorButton;//instance variable
		}
		
		//action that will be taken when selected
		public void actionPerformed(java.awt.event.ActionEvent e){
			//store the original color
			java.awt.Color tempColor = _color;
			
			//instantiate a color chooser.
			_color = javax.swing.JColorChooser.showDialog(null, "Color Chooser", _color);
			//if no color to be chosen, restore the original color 
			if(_color == null){
				_color = tempColor;
			}
			
			//set the color of the peg that will be created
			_britePanel.setColor(_color);
			//set the background of the button
			_customColorButton.setBackground(_color);
			_customColorButton.setOpaque(true);

		}
	}
	
}
