/*
 * ContainedMousableBubble.java
 * This class describes a conversation bubble,
 * which is able to be dragged in the frame.
 */
import java.awt.Point;
import java.awt.event.MouseEvent;

import wheels.users.*;

public class ContainedMousableBubble extends ConversationBubble implements Mover{
	private MoveDispatcher _container;
	private Point _lastMousePosition;
	
	//constructor with inputs about content, location and its container.  
	public ContainedMousableBubble(MoveDispatcher aContainer, String text,int x, int y){
		super(text);
		
		//peer object
		_container = aContainer;
		
		//set location and size
		this.setLocation(x, y);
		this.setSize(150, 100);
	}
	
	//overwrite the mousePressed method so that it will record the last position of the ellipse.
	public void MousePressed(MouseEvent e){
		_lastMousePosition = e.getPoint();
	}
	
	//overwrite the mouseDragged method so that it is able to be dragged by the mouse.
	public void MouseDragged(MouseEvent e){
		//get the current mouse location
		Point currentPoint = e.getPoint();
		
		//calculate how much should object move
		int diffX = currentPoint.x - _lastMousePosition.x;
		int diffY = currentPoint.y - _lastMousePosition.y;
		
		//call its container to move the all related parts
		_container.requestMove(diffX, diffY);

		//reset the starting point
		_lastMousePosition = e.getPoint();
	}

	//method that will be called by its container to move the ellipse by drift x(horizontal) and y(vertical).
	public void move(int x, int y){
		this.setLocation(this.getXLocation()+x, this.getYLocation()+y);
	}

}
