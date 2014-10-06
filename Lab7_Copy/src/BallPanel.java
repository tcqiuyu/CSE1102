import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Chapter 7: BallPanel.java
 * Creates the panel to be placed inside the BallApp window.
 * Used (with modifications) in all programs later in this book.
 * Version 2 of 3
 */
public class BallPanel extends javax.swing.JPanel implements Mover{
	private final int INIT_X = 75; // attributes
	private final int INIT_Y = 75;
	private final int DIAMETER = 10;
	private SmartEllipse _ball; // components
	private MoveTimer _timer;
	private long _startTime;
	
	public BallPanel (Color backgroundColor) {
		super();
		this.setBackground(backgroundColor);
		_ball = new SmartEllipse (java.awt.Color.red, this);  
		_ball.setLocation(INIT_X, INIT_Y);
		_ball.setSize(DIAMETER, DIAMETER);
		_timer = new MoveTimer(10,this);
		_timer.start();
		this.setStartTime();
	}
	
	public BallPanel(){
		this(java.awt.Color.white);
	}
	
	public void setStartTime(){
		_startTime = System.currentTimeMillis();
	}
	public void move(){
		_ball.fall(_startTime);
		this.repaint();
	}

	public void paintComponent (java.awt.Graphics aBrush) {
		super.paintComponent(aBrush);
		java.awt.Graphics2D betterBrush = 
				(java.awt.Graphics2D) aBrush;
		_ball.fill(betterBrush);
	}
}
