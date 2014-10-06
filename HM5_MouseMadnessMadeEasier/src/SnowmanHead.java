/*
 * SnowmanHead.java
 * This class creates snowman's head.
 */
import java.awt.Color;

public class SnowmanHead implements Mover, MoveDispatcher{
	//declare its container
	private MoveDispatcher _container;
	//declare its part
	private Mover _head, _leftEye, _rightEye;

	//constructors with parameters of its container and its location
	public SnowmanHead(MoveDispatcher aContainer, int x, int y){
		//peer object
		_container = aContainer;
		
		//instantiate all its parts
		_head = new ContainedMousableEllipse(this, x+60, y+15, 80, 80, Color.WHITE, Color.BLACK, 2);
		_leftEye = new ContainedMousableEllipse(this, x+75, y+40, 15, 15, Color.DARK_GRAY, Color.DARK_GRAY, 1);
		_rightEye = new ContainedMousableEllipse(this, x+105, y+40, 15, 15, Color.DARK_GRAY, Color.DARK_GRAY, 1);	
	}
	
	//constructors that will create a default snowman's head
	public SnowmanHead(MoveDispatcher aContainer){
		this(aContainer, 150, 200);
	}
	
	//move method that will be called by its container to move itself
	public void move(int x, int y){
		_head.move(x, y);
		_leftEye.move(x, y);
		_rightEye.move(x, y);
	}
	
	//request method that will be called by its parts to move all other related parts. 
	public void requestMove(int x, int y){
		_container.requestMove(x, y);
	}
}
