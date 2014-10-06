
public class BallFrame extends javax.swing.JFrame{
	public BallFrame (String title) {
		super(title);  
		this.setSize(500, 500);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.add(new BallPanel(50));
		this.setVisible(true);
		}

	    public static void main (String [ ] args) {
	    	new BallFrame ("Lots of Balls");
	    }
}
