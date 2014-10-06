/*
 * ContainedMousableRectangle.java
 * This class describes an ellipse shape part consists the snowman,
 * which is able to be dragged in the frame.
 */
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;

import wheels.users.*;

public class ContainedMousableRectangle extends Rectangle implements Mover{

	private MoveDispatcher _mycontainer;
	private Point _lastMousePosition;

	//constructor with inputs about size, location, color and its container.  
	public ContainedMousableRectangle(MoveDispatcher container, int x, int y, 
										int width, int height, Color aColor){
		//peer object
		_mycontainer = container;
		
		//setting different kinds of attributes 
		this.setColor(aColor);
		this.setLocation(x, y);
		this.setSize(width, height);
		}
	
	//overwrite the mousePressed method so that it will record the last position of the rectangle.
	public void mousePressed(MouseEvent e){
		_lastMousePosition = e.getPoint();
	}
	
	//overwrite the mouseDragged method so that it is able to be dragged by the mouse.
	public void mouseDragged(MouseEvent e){
		//get the current mouse location
		Point currentPoint = e.getPoint();
		
		//calculate how much should object move
		int diffX = currentPoint.x - _lastMousePosition.x;
		int diffY = currentPoint.y - _lastMousePosition.y;
		
		//call its container to move the all related parts
		_mycontainer.requestMove(diffX, diffY);
		
		//reset the starting point
		_lastMousePosition = e.getPoint();
	}
	
	//method that will be called by its container to move the ellipse by drift x(horizontal) and y(vertical).
	public void move(int x, int y){
		this.setLocation(this.getXLocation()+x, this.getYLocation()+y);
		}
}
