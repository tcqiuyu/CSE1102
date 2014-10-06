/*
 * FishPanel.java
 * This class draws various kinds of fish (and snail) inside a fish tank.
 */
import java.awt.Color;


public class FishPanel extends javax.swing.JPanel implements Mover{
	private final int TANK_X = 75;
	private final int TANK_Y = 75;
    private final int TANK_WIDTH = 400;
    private final int TANK_HEIGHT = 300;
    private final int INTERVAL = 100;
	private SmartRectangle _tank;
	//Two fishes swim in different direction
	private Fish _redFish;
	private MotleyFish _greenFish;
	//A fish that swim in a circle
	private CircleFish _yellowFish;
	private JumpFish _jumpFish;
	//A snail walking through the edge
	private Snail _snail;
	//A dead fish
	private DeadFish _deadFish;
	private MoveTimer _timer;
	private long _startTime;

	private MainApp _main;
	
	public FishPanel(MainApp main){
		super();
		_main = main;
		//instantiate all components
		_tank = new SmartRectangle(Color.BLACK, Color.BLUE);
		_redFish = new Fish(Color.RED, _tank, 1);
		_greenFish = new MotleyFish(Color.GREEN, Color.PINK, _tank, 1);
		_yellowFish  = new CircleFish(Color.YELLOW, _tank, 1);
		_snail = new Snail();
		_deadFish = new DeadFish(Color.CYAN,_tank,2);
		_jumpFish = new JumpFish(Color.ORANGE,_tank, this);
		_timer = new MoveTimer(INTERVAL, this);
		
		//set panel's background
		this.setBackground(Color.WHITE);
		//set fish tank's location, size
		_tank.setLocation(TANK_X, TANK_Y);
		_tank.setSize(TANK_WIDTH, TANK_HEIGHT);
		//set fish and snail's initial location and speed 
		_redFish.setLocation(TANK_X, TANK_Y+TANK_HEIGHT/2);
		_redFish.setSpeed(3, 3);
		_greenFish.setLocation(100, 100);
		_greenFish.setSpeed(4, 0);
		_yellowFish.setLocation(325, 225);
		_snail.setSpeed(1, 1);
		_deadFish.setLocation(200, 200);
		//start the timer
		_timer.start();
		this.setStartTime();
	}
	
	public void move(){
		_redFish.move();
		_greenFish.move();
		_yellowFish.move();
		_snail.move();
		_deadFish.move();
		_jumpFish.move(_startTime);
		this.repaint();
		System.out.print(_main.getHeight());
	}
	
	//store the current time
	public void setStartTime(){
		_startTime = System.currentTimeMillis();
	}
	
	public void paintComponent(java.awt.Graphics aBrush){
		super.paintComponent(aBrush);
		java.awt.Graphics2D convertedBrush = (java.awt.Graphics2D) aBrush;
		_tank.fill(convertedBrush);
		_tank.draw(convertedBrush);
		_redFish.fill(convertedBrush);
		_redFish.draw(convertedBrush);
		_greenFish.fill(convertedBrush);
		_greenFish.draw(convertedBrush);
		_yellowFish.fill(convertedBrush);
		_yellowFish.draw(convertedBrush);
		_snail.fill(convertedBrush);
		_snail.draw(convertedBrush);
		_deadFish.fill(convertedBrush);
		_deadFish.draw(convertedBrush);
		_jumpFish.fill(convertedBrush);
		_jumpFish.draw(convertedBrush);
	}

}
