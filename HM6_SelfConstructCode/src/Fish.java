/*
 * Fish.java
 * This class indicates a general kind of fish
 */

import java.awt.Color;


public class Fish implements Mover{
    private final int BODY_WIDTH = 17; // attributes
    private final int TAIL_WIDTH = 6;
    private final int FISH_WIDTH = 22; 
    private final int FISH_HEIGHT = 10; 
    protected double _changeX, _changeY;
    private double _rotation;
    private double _initSize;
    //protected _body and _tail so that it can be access and changed by its subclass, which is specifically MotleyFish
    protected SmartEllipse _body;
    protected SmartArc _tail;
    private SmartRectangle _tank;
    
    public Fish(Color aColor, 
    		SmartRectangle aRectangle, double sizeFactor){
    	super();
    	this.setSpeed(3, 0);
    	_rotation = 0;
    	_body = new SmartEllipse(aColor,aColor);
    	_tail = new SmartArc(90, 180, 
    			java.awt.geom.Arc2D.PIE, aColor, aColor);
    	_tank = aRectangle;
    	_initSize = sizeFactor;
    	this.setSize(_initSize);
    }
    
    public void setSize(double sizeFactor){
    	_body.setSize(BODY_WIDTH*sizeFactor, FISH_HEIGHT*sizeFactor);
    	_tail.setSize(TAIL_WIDTH*sizeFactor, FISH_HEIGHT*sizeFactor);
    }
    
    //accessor and mutator for speed 
    public double getXSpeed(){
    	return this._changeX;
    }
    public double getYSpeed(){
    	return this._changeY;
    }
    public void setXSpeed(double xSpeed){
    	_changeX = xSpeed;
    }
    public void setYSpeed(double ySpeed){
    	_changeY = ySpeed;
    }
    public void setSpeed(double xSpeed, double ySpeed){
    	this.setXSpeed(xSpeed);
    	this.setYSpeed(ySpeed);
    }
    
    //get the the boundary for fish
    public double getMinBoundX(){
    	return _tank.getX();
    }
    public double getMaxBoundX(){
    	return (_tank.getMaxX()-FISH_WIDTH);
    }
    public double getMinBoundY(){
    	return _tank.getY();
    }
    public double getMaxBoundY(){
    	return (_tank.getMaxY()-FISH_HEIGHT);
    }
    
    //accessor and mutator of location
    public double getX(){
    	return _tail.getX();
    }
    public double getY(){
    	return _tail.getY();
    }
    public double getCenterX(){
    	return this.getX()+FISH_WIDTH/2;
    }
    public double getCenterY(){
    	return this.getY()+FISH_HEIGHT/2;
    }
    public void setLocation(double x, double y){
    	_body.setLocation(x+5, y);
    	_tail.setLocation(x, y);
    }
    
    public void setRotation(double rotation){
    	_rotation = rotation;
    }
    
	public void move(){
		double nextX = this.getX() + _changeX;
		double nextY = this.getY() + _changeY;
		
		//change the direction when hitting the bound of the tank
		if (nextX <= this.getMinBoundX()){
			_changeX *= -1;
			nextX = this.getMinBoundX();
		}
		else if (nextX >= this.getMaxBoundX()){
			_changeX *= -1;
			nextX = this.getMaxBoundX();
		}
		if (nextY <= this.getMinBoundY()+20){
			_changeY *= -1;
			nextY = this.getMinBoundY()+20;
		}
		else if (nextY >= this.getMaxBoundY()-20){
			_changeY *= -1;
			nextY = this.getMaxBoundY()-20;
		}
		
		//change the direction of the fish so that it always faces the direction it swim to.
		if (_changeX <= 0){
			this.setRotation(Math.PI+Math.atan(_changeY/_changeX));
		}
		else
			this.setRotation(Math.atan(_changeY/_changeX));
				
		this.setLocation(nextX, nextY);
		
		//change the size when getting close to the middle of the tank
		double _sizeFactor = 2 - 
				(2-_initSize)*
					(Math.abs((this.getCenterX()-_tank.getCenterX())))
						/(_tank.getCenterX()-_tank.getX());
		this.setSize(_sizeFactor);
	}
	
	public void fill(java.awt.Graphics2D aBrush){
		aBrush.rotate(_rotation, 
				this.getCenterX(), this.getCenterY());
		_body.fill(aBrush);
		_tail.fill(aBrush);
		aBrush.rotate(-_rotation, 
				this.getCenterX(), this.getCenterY());
	}
	
	public void draw(java.awt.Graphics2D aBrush){
		aBrush.rotate(_rotation, 
				this.getCenterX(), this.getCenterY());
		_body.draw(aBrush);
		_tail.draw(aBrush);
		aBrush.rotate(-_rotation, 
				this.getCenterX(), this.getCenterY());
	}
}
