import java.awt.Color;

/**
 * Chapter 7: BallPanel.java
 * Creates the panel to be placed inside the BallApp window.
 * Used (with modifications) in all programs later in this book.
 * Version 2 of 3
 */
public class BallPanel extends javax.swing.JPanel {
	private final int INIT_X = 75; // attributes
	private final int INIT_Y = 75;
	private final int DIAMETER = 60;
	private SmartEllipse _ball, _ball2; // components
	private SmartRectangle _rectangle;
	
	public BallPanel (Color backgroundColor) {
		super();
		this.setBackground(backgroundColor);
		
		if(backgroundColor == Color.RED){
			_ball = new SmartEllipse(Color.BLUE);
			}
		else	{
		_ball = new SmartEllipse (java.awt.Color.red);  
		}
		
		_ball.setLocation(INIT_X, INIT_Y);
		_ball.setSize(DIAMETER, DIAMETER);
	
		_ball2 = new SmartEllipse(Color.CYAN);
		_ball2.setLocation(175, 75);
		_ball2.setSize(DIAMETER, DIAMETER);
		
		_rectangle = new SmartRectangle(Color.GREEN);
		_rectangle.setLocation(275, 75);
		_rectangle.setSize(DIAMETER, DIAMETER);
	}
	
	public BallPanel(){
		this(java.awt.Color.white);
	}

	public void paintComponent (java.awt.Graphics aBrush) {
		super.paintComponent(aBrush);
		java.awt.Graphics2D betterBrush = 
				(java.awt.Graphics2D) aBrush;
		_ball.fill(betterBrush);
		_ball2.fill(betterBrush);
		_rectangle.fill(betterBrush);
	}
}
