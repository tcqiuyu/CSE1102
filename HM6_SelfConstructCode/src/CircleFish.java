/*
 * CircleFish.java
 * This class defines fish swims in a circle
 */

import java.awt.Color;


public class CircleFish extends Fish{
	private double _radius;
	private double _pathCenterX;
	private double _pathCenterY;
	private final double DEGREE_INTERVAL = 2*Math.PI/200; 
	
	public CircleFish(Color aColor, SmartRectangle aRectangle, double sizeFactor){
		super(aColor, aRectangle, sizeFactor);
		_pathCenterX = 275;
		_pathCenterY = 225;
		_radius = 50;
	}
	
	//set circle path's center
	public void setCenter(double x, double y){
		_pathCenterX = x;
		_pathCenterY = y;
	}
	
	//set path radius
	public void setRadius(double r){
		_radius = r;
	}
	
	//get current angle
	public double getDegree(){
		if (this.getX()>=_pathCenterX){
			return Math.atan((this.getY()-_pathCenterY)/(this.getX()-275));
		}
		else{
			return Math.PI+
					Math.atan((this.getY()-_pathCenterY)/(this.getX()-275));
		}
	}
	
	public void move(){
		//polar coordinate system
		double _changeX = _radius*Math.cos(this.getDegree()+DEGREE_INTERVAL);
		double _changeY = _radius*Math.sin(this.getDegree()+DEGREE_INTERVAL);
		double nextX = _pathCenterX + _changeX;
		double nextY = _pathCenterY + _changeY;
		
		//change the facing direction of the fish
		if (_changeX < 0) 
		    this.setRotation(3*Math.PI/2+Math.atan(_changeY/_changeX));
		else if(_changeX == 0 && _changeY > 0){
			this.setRotation(Math.PI/2);
		}
		else if(_changeX == 0 && _changeY < 0){
			this.setRotation(-Math.PI/2);
		}
		else {
		    this.setRotation(Math.PI/2+Math.atan(_changeY/_changeX));
		} 
		this.setLocation(nextX, nextY);
	}
}
