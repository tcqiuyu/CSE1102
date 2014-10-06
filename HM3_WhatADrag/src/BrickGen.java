import wheels.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class BrickGen extends Rectangle{
	//declare variables
	private java.awt.Point _lastMousePosition;
	private Color _mainColor;
	private int _previousX;
	private int _previousY;
	private int _width;
	private int _height;
	
	//instructor: location, size and color input.
	public BrickGen(int x, int y, int width, int height, Color a){
		_mainColor = a;
		_previousX = x;
		_previousY = y;
		_width = width;
		_height = height;
		this.setColor(a);
		this.setLocation(x,y);
		this.setSize(width, height);
	}
	
	//when pressing the mouse on the brick, generate a new brick and record the mouse position 
	public void mousePressed(MouseEvent e){
		_lastMousePosition = e.getPoint();
		new BrickGen(_previousX, _previousY, _width, _height, _mainColor);
		//and also just show the contour of the brick
		this.setFrameColor(Color.BLACK);
		this.setFillColor(null);
	}
	
	//let you are able to drag the brick
	public void mouseDragged(MouseEvent e){
		java.awt.Point _currentPoint = e.getPoint();
		int diffX = _currentPoint.x - _lastMousePosition.x;
		int diffY = _currentPoint.y - _lastMousePosition.y;
		this.setLocation(this.getXLocation() + diffX, this.getYLocation() + diffY);
		_lastMousePosition = _currentPoint;
	}
	
	//when you release your mouse, the brick change back to its original color.
	public void mouseReleased(MouseEvent e){
		this.setColor(_mainColor);
		//what's more, if you drag it to the trash can, it will disappear.
		if (_lastMousePosition.x>610 && _lastMousePosition.x<660 && _lastMousePosition.y>405 && _lastMousePosition.y<465){
			super.hide();
		}
	}
}
