import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;

import wheels.users.*;

public class HatPart extends Rectangle implements Mover{
	
	private MoveDispatcher _hat;
    private Point _lastMousePosition;

	public HatPart(MoveDispatcher aHat, Color aColor, int width, int height, int xLocation, int yLocation){
		//pass the Hat's information to its part 
		_hat = aHat;
		this.setColor(aColor);
		this.setSize(width, height);
		this.setLocation(xLocation, yLocation);
	}
	
	public void mousePressed(MouseEvent e){
		//get the starting point
    	_lastMousePosition = e.getPoint();
	}
	
	public void mouseDragged(MouseEvent e){
		//get the current point
    	Point currentPoint = e.getPoint();
    	//calculate the drift 
    	int diffX = currentPoint.x - _lastMousePosition.x;
    	int diffY = currentPoint.y - _lastMousePosition.y;
    	//ask the whole hat to move together
    	_hat.requestMove(diffX, diffY);
    	//get new starting point
    	_lastMousePosition = e.getPoint();

	}
	
	public void move(int x, int y){
		this.setLocation(this.getXLocation()+x, this.getYLocation()+y);
	}
}

