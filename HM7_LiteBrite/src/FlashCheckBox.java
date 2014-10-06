/*
 * FlashCheckBox.java
 * This class defines a check box that will allow the pegs flash when checked 
 */
import java.awt.event.ItemEvent;

public class FlashCheckBox extends javax.swing.JCheckBox{

	private LiteBritePanel _britePanel;//have to know about the brite panel so that it can invoke the makeflash method
	
	public FlashCheckBox(ButtonPanel buttonPanel, LiteBritePanel britePanel){
		super("FLASH");
		_britePanel = britePanel;
		buttonPanel.add(this);//add this check box to the button panel
		this.addItemListener(new CheckBoxListener(this));//register the listener for the check box 
	}
	
	//inner class defines the action that will be taken when the check box is selected and unselected.
	private class CheckBoxListener implements java.awt.event.ItemListener {
		private FlashCheckBox _checkbox;
		
		public CheckBoxListener(FlashCheckBox checkbox){
			_checkbox = checkbox;
		}
		@Override
		public void itemStateChanged(ItemEvent e) {
			//when the check box is checked, run the timer in brite panel
			if(_checkbox.isSelected()==true){
				_britePanel.TimerStart();
			}
			//when the check box is unchecked, stop the timer, restore the pegs' original color, and repaint the panel
			else{
				_britePanel.TimerStop();
				_britePanel.RestoreColor();
				_britePanel.repaint();
			}
		}
	}
}
