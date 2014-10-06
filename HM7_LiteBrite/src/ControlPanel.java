/*
 * ControlPanel.java
 * This is a panel lies in the south of the frame.
 * It consist of a button panel and a status bar. 
 */
public class ControlPanel extends javax.swing.JPanel{

	private javax.swing.JLabel _statusLabel;

	
	public ControlPanel(LiteBritePanel liteBritePanel){
		super(new java.awt.BorderLayout());//use border layout.
		
		//instantiate a button panel and add it to the control panel
		ButtonPanel buttonPanel = new ButtonPanel(liteBritePanel);
		this.add(buttonPanel,java.awt.BorderLayout.CENTER);		

		//instantiate a status bar
		javax.swing.JPanel statusBar = new javax.swing.JPanel();
		//lowered the border so that "looks like" status bar 
		statusBar.setBorder(new javax.swing.border.BevelBorder
				(javax.swing.border.BevelBorder.LOWERED));
		//add it to the panel
		this.add(statusBar, java.awt.BorderLayout.SOUTH);
		//set the height of the status bar
		statusBar.setPreferredSize(new java.awt.Dimension(this.getWidth(),20));
		//set the layout of the status bar
		statusBar.setLayout(new javax.swing.BoxLayout
				(statusBar, javax.swing.BoxLayout.X_AXIS));
		//add labels so it will show the number of pegs that are currently created
		_statusLabel = new javax.swing.JLabel(liteBritePanel.getPegNum()+" pegs now created.");
		//make the label to align with left
		_statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		statusBar.add(_statusLabel);
		
	}
	
	//create a public method of set the label of status bar 
	//so that it can be invoked outside the class to change the content of the label
	public void setStatusLabel(String s){
		_statusLabel.setText(s);
	}
	
}
