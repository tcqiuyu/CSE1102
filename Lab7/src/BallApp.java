/**
 * Chapter 7: BallApp.java
 * Displays a window with a red circle on a white background. 
 * Similar to FirstApp.java (in Chapter 1), but written without Wheels.
 * Used (with modifications) in all programs later in this book.
 */
public class BallApp extends javax.swing.JFrame {
	public BallApp (String title) {
		super(title);
		this.setSize(600, 450);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.add(new BallPanel(java.awt.Color.BLUE));
		this.setVisible(true);
	}

	public static void main (String[] args) {
		BallApp app = new BallApp ("OMG it's bluescreen!");
	}
}
