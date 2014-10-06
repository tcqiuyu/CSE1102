import java.awt.GridLayout;


public class ButtonPanel extends javax.swing.JPanel{
	
	private javax.swing.ButtonGroup group = new javax.swing.ButtonGroup();
	public ButtonPanel(LiteBritePanel britePanel){
		super(new GridLayout(2,0));
		ColorRadioButton redButton = new ColorRadioButton(java.awt.Color.RED, "RED", true, britePanel, this, group);
		ColorRadioButton blueButton = new ColorRadioButton(java.awt.Color.BLUE, "BLUE", false, britePanel, this, group);
		ColorRadioButton greenButton = new ColorRadioButton(java.awt.Color.GREEN, "GREEN", false,britePanel, this, group);
		ColorRadioButton pinkButton = new ColorRadioButton(java.awt.Color.PINK, "PINK", false,britePanel, this, group);
		ColorRadioButton magentaButton = new ColorRadioButton(java.awt.Color.MAGENTA, "MAGENTA", false,britePanel, this, group);
		ColorRadioButton yellowButton = new ColorRadioButton(java.awt.Color.YELLOW, "YELLOW", false,britePanel, this, group);
		ColorRadioButton grayButton = new ColorRadioButton(java.awt.Color.GRAY, "GRAY", false,britePanel, this, group);
		ColorRadioButton whiteButton = new ColorRadioButton(java.awt.Color.white, "WHITE", false,britePanel, this, group);
		CustomColorButton customColorButton = new CustomColorButton(false,britePanel, this, group);

		FlashCheckBox flashToggleButton = new FlashCheckBox(this,britePanel);
	}
	
}
