/*
 * ColorRadioButton.java
 * This class defines a set of radio button that control the color of pegs
 */
public class ColorRadioButton extends javax.swing.JRadioButton{

	private java.awt.Color _color;
	private LiteBritePanel _britePanel;//should know about the panel so that it can change the color of pegs 
	
	public ColorRadioButton(java.awt.Color aColor, String aColorName,
			boolean aSelected, LiteBritePanel britePanel, ButtonPanel buttonPanel, javax.swing.ButtonGroup aGroup){
		super(aColorName, aSelected);
		_color = aColor;
		_britePanel = britePanel;
		buttonPanel.add(this);//add this button to the panel
		aGroup.add(this);//add the button to a specific button group			
		this.setBackground(aColor);
		this.setOpaque(true);//make the button not opaque so that it is able to show the background
		this.addActionListener(new ColorListener());//register the listener
	}
	
	//inner class implements actionlistener
	private class ColorListener implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent e){
			//when the button is selected, set the instance variable _color of peg we are going to create
			_britePanel.setColor(_color);
		}
	}
	
}
