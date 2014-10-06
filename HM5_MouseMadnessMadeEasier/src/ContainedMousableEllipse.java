/*
 * ContainedMousableEllipse.java
 * This class describes an ellipse shape part consists the snowman,
 * which is able to be dragged in the frame.
 */
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Point;
import wheels.users.*;

public class ContainedMousableEllipse extends Ellipse implements Mover{
	private MoveDispatcher _container; //declare its container
	private Point _lastMousePosition;
	
	//constructor with inputs about size, location, color, contour, and its container.  
	public ContainedMousableEllipse(MoveDispatcher aContainer, int x, int y, int width, int height, 
									Color fillColor, Color frameColor, int thick){
		//peer object
		_container = aContainer;
		
		//setting different kinds of attributes 
		this.setLocation(x, y);
		this.setSize(width, height);
		this.setFillColor(fillColor);
		this.setFrameColor(frameColor);
		this.setFrameThickness(thick);	
	}
	
	//overwrite the mousePressed method so that it will record the last position of the ellipse.
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
		_container.requestMove(diffX, diffY);
		
		//reset the starting point
		_lastMousePosition = e.getPoint();
	}
	
	//method that will be called by its container to move the ellipse by drift x(horizontal) and y(vertical).
	public void move(int x, int y){
		this.setLocation(this.getXLocation()+x, this.getYLocation()+y);
	}

}
