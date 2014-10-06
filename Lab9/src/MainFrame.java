/*
 * Lab7
 * Yu Qiu
 * MainFrame.java
 * This is the main frame of the program
 * It creates a window containing a panel where you can add ellipses.
 */
public class MainFrame extends javax.swing.JFrame{
	
	public MainFrame(String title){
		super(title);
		this.setSize(600,450);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.add(new DrawingPanel());
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		new MainFrame("Lab7");
	}
}
