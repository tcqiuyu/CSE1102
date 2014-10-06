/*
 * SnowmanBody.java
 * This class creates snowman's body.
 */
import java.awt.Color;

public class SnowmanBody implements Mover,  MoveDispatcher{
	//declare its container
	private MoveDispatcher _container;
	//declare its part
	private Mover _body;
	
	//constructors with parameters of its container and its location
	public SnowmanBody(MoveDispatcher aContainer, int x, int y){
		//peer object
		_container = aContainer;
		
		//instantiate snowman's body
		_body = new ContainedMousableEllipse(this, x+50, y+75, 100, 100, null, Color.BLACK, 2);
	}

	//constructors that will create a default snowman's body
	public SnowmanBody(MoveDispatcher aContainer){
		this(aContainer,150,200);
	}
	
	//move method that will be called by its container to move itself
	public void move(int x, int y){
		_body.move(x,y);
	}
	
	//request method that will be called by its parts to move all other related parts. 
	public void requestMove(int x, int y){
		_container.requestMove(x, y);
	}
}
