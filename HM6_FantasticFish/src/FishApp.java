/** 
 * Chapter 7: FishApp
 * A second animated program. A composite object (the fish) is animated.
 * Follows the same recipes as BallApp for displaying and animating 2D 
 * graphical shapes and for event-handling. 
 */
public class FishApp extends javax.swing.JFrame {
    public FishApp (String title) {
	super(title);  
	this.setSize(600, 450);
	this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	this.add(new FishPanel());
	this.setVisible(true);
    }

    public static void main (String [ ] args) {
	FishApp app = new FishApp ("Chapter 7: FishApp");
    }
}
