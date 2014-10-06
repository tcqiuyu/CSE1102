import java.awt.Color;
import wheels.users.*;

public class MobileRedBall extends Ellipse{
	private java.awt.Point _lastMousePosition;
	private Color _mainColor;
	
	public MobileRedBall(int x, int y, Color a){
		_lastMousePosition = new java.awt.Point(); 
		this.setLocation(x, y);
		this.setColor(a);
		_mainColor = a;
	}
	
	public void mousePressed(java.awt.event.MouseEvent e) { 
		System.out.println("Mouse Pressed!");
		_lastMousePosition = e.getPoint(); 
		this.setColor(Color.GREEN);
		}
	
	public void mouseDragged(java.awt.event.MouseEvent e) {	
		java.awt.Point currentPoint = e.getPoint();
		int diffX = currentPoint.x - _lastMousePosition.x; 
		int diffY = currentPoint.y - _lastMousePosition.y; 
		this.setLocation(this.getLocation().x + diffX,this.getLocation().y + diffY); 
		_lastMousePosition = currentPoint;
		System.out.println("Current Location is ("+currentPoint.x+","+currentPoint.y+")");
		}
	
	public void mouseReleased(java.awt.event.MouseEvent e) {
		this.setColor(_mainColor);
		System.out.println("Release!");
		}
}
