/*
 * Yu Qiu, Math Dep.
 * Homework 4: MouseMadness
 */

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import wheels.users.*;


public class CartoonCharacter extends Frame{
	private Ellipse _body, _head, _leftEye, _rightEye;
	private TallHat _hat;
	private int _x, _y;//variables to store the initial location value
	private Point _lastMousePosition;
	private ConversationBubble _bubble;
	
	public CartoonCharacter(){
		_body = new SnowmanPart(this);
		_head = new SnowmanPart(this);
		_leftEye = new SnowmanPart(this);
		_rightEye = new SnowmanPart(this);
		_hat = new TallHat();
		_bubble = new ConversationBubble("Happy Snow Day!");
		this.setOutline(Color.BLACK, 2);
		this.setColor();
		this.setSize();
		_x = 150;
		_y = 200;//designate the original location
		this.setLocation(_x, _y);
		_hat.setLocation(_x+50, _y);
	}
	
	//set the outline of the character
	public void setOutline(Color aColor, int thickness){
		_body.setFrameColor(aColor);
		_body.setFrameThickness(thickness);
		_head.setFrameColor(aColor);
		_head.setFrameThickness(thickness);
	}
	
	//set the color of the character
	public void setColor(){
		_body.setFillColor(Color.WHITE);
		_head.setFillColor(Color.WHITE);
		_leftEye.setColor(Color.DARK_GRAY);
		_rightEye.setColor(Color.DARK_GRAY);
	}
	
	//set the size of the character
	public void setSize(){
		_body.setSize(100, 100);
		_head.setSize(80, 80);
		_leftEye.setSize(15, 15);
		_rightEye.setSize(15, 15);
		_bubble.setSize(150, 100);
	}
	
	//set the general location of the character
	public void setLocation(int x, int y){
		_x = x;
		_y = y;
		_body.setLocation(x+50, y+75);
		_head.setLocation(x+60, y+15);
		_leftEye.setLocation(x+75, y+40);
		_rightEye.setLocation(x+105, y+40);
		_bubble.setLocation(x-120, y-100);
	}
	
	public void mousePressed(MouseEvent e){
		//get the original location of the hat when pressing the mouse
		_lastMousePosition = e.getPoint();
	}
	
	public void mouseDragged(MouseEvent e){
		//get the current cursor's location of the hat
		Point currentPoint = e.getPoint();
		//calculate the drift
		int diffX = currentPoint.x - _lastMousePosition.x;
		int diffY = currentPoint.y - _lastMousePosition.y;
		//set the new location of the character
		this.setLocation(_x+diffX, _y+diffY);
		//call the method in hat class to set its location
		_hat.setLocation(_hat.getLocation().x+diffX, _hat.getLocation().y+diffY);
		_lastMousePosition = currentPoint;//set the new starting location
	}
	
	public static void main(String[] args){
		new CartoonCharacter();
	}
}
