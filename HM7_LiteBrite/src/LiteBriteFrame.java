/*
 * Yu Qiu
 * Math Dep
 * Homework7 LiteBrite
 * 
 * LiteBriteFrame.java
 * This is the main class of the project.
 * It creates the main frame.
 */

public class LiteBriteFrame extends javax.swing.JFrame{
	
	private ControlPanel _controlPanel; 
	
	public LiteBriteFrame(String title){
		super(title);
		this.setSize(600,480);//set the default size
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		//instantiate the brite panel and control panel
		LiteBritePanel liteBritePanel = new LiteBritePanel(this);
		_controlPanel = new ControlPanel(liteBritePanel);
		//locate the brite panel to the center and control panel to the south
		this.add(liteBritePanel, java.awt.BorderLayout.CENTER);
		this.add(_controlPanel, java.awt.BorderLayout.SOUTH);
		//add a menubar to the frame
		this.setJMenuBar(new MenuBar(liteBritePanel));
		this.setVisible(true);
		
	}
	
	//a method to invoke the method to set the text of status bar. 
	public void setStatusBarText(String s){
		_controlPanel.setStatusLabel(s);
	}
	
	public static void main(String[] args){
		new LiteBriteFrame("Lite Brite");
	}
}
