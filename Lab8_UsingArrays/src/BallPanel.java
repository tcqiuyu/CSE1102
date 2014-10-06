import java.awt.Color;


public class BallPanel extends javax.swing.JPanel{
	private final int DIAMETER=60;
	private RandomBall [] _randomBall;
	
	public BallPanel(int ballnumber){
		super();
		this.setBackground(Color.WHITE);
		_randomBall = new RandomBall[ballnumber];
		for(int i = 0; i < _randomBall.length; i++){
			_randomBall[i] = new RandomBall();
			_randomBall[i].setSize(DIAMETER, DIAMETER);
		}
		
	}
	
    public void paintComponent(java.awt.Graphics aBrush){
		super.paintComponent(aBrush);
		java.awt.Graphics2D betterBrush = 
		    (java.awt.Graphics2D) aBrush;
		for(int i = 0; i < _randomBall.length; i++){
			_randomBall[i].fill(betterBrush);
			_randomBall[i].draw(betterBrush);
		}
	}
}
