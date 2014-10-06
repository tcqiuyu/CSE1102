/*
 * MainFrame.java
 * This is the main class of the program.
 */
public class MainFrame extends javax.swing.JFrame{

	public MainFrame(String title){
		super(title);
		this.setSize(600,480);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		//add the main panel and control panel to the frame
		MainPanel mainPanel = new MainPanel(new LifeModel(20,20));
		ControlPanel controlPanel = new ControlPanel(mainPanel);
		this.add(mainPanel,java.awt.BorderLayout.CENTER);//main panel locates in the center
		this.add(controlPanel, java.awt.BorderLayout.SOUTH);//control panel locates in the south
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		new MainFrame("Life Game");
	}
}
