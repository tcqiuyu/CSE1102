/*
 * ButtonPanel.java
 * This is the panel that contains all the buttons in the frame
 */
import java.awt.GridLayout;

public class ButtonPanel extends javax.swing.JPanel{
	
	private javax.swing.ButtonGroup _group = new javax.swing.ButtonGroup();
	public ButtonPanel(LiteBritePanel bp){
		super(new GridLayout(2,0));//make the panel 2 line grid layout
		
		//instantiate all buttons
		ColorRadioButton redButton = new ColorRadioButton(java.awt.Color.RED, "RED", true, bp, this, _group);
		ColorRadioButton blueButton = new ColorRadioButton(java.awt.Color.BLUE, "BLUE", false, bp, this, _group);
		ColorRadioButton greenButton = new ColorRadioButton(java.awt.Color.GREEN, "GREEN", false,bp, this, _group);
		ColorRadioButton pinkButton = new ColorRadioButton(java.awt.Color.PINK, "PINK", false,bp, this, _group);
		ColorRadioButton magentaButton = new ColorRadioButton(java.awt.Color.MAGENTA, "MAGENTA", false,bp, this, _group);
		ColorRadioButton yellowButton = new ColorRadioButton(java.awt.Color.YELLOW, "YELLOW", false,bp, this, _group);
		ColorRadioButton grayButton = new ColorRadioButton(java.awt.Color.GRAY, "GRAY", false,bp, this, _group);
		ColorRadioButton whiteButton = new ColorRadioButton(java.awt.Color.white, "WHITE", false,bp, this, _group);
		CustomColorButton customColorButton = new CustomColorButton(false,bp, this, _group);
		FlashCheckBox flashToggleButton = new FlashCheckBox(this,bp);
	}
	
}
