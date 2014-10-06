/*
 * SmartRectangularShape.java
 * This is an abstract class that defines all rectangular shape
 */
import java.awt.Color;

public abstract class SmartRectangularShape{
	private Color _borderColor, _fillColor;
	private double _rotation;
	private int _strokeWidth;
	private java.awt.geom.RectangularShape _shape;
	
	public SmartRectangularShape(java.awt.geom.RectangularShape s){
		_borderColor = Color.WHITE;
		_fillColor = Color.WHITE;
		_rotation = 0;
		_strokeWidth = 2;
		_shape = s;
	}
	
	//Method make the shape colorable
	public void setColor(Color borderColor, Color fillColor){
		_borderColor = borderColor;
		_fillColor = fillColor;
	}
	public void setBorderColor(Color borderColor){
		_borderColor = borderColor;
	}
	public void setFillColor(Color fillColor){
		_fillColor = fillColor;
	}
	
	//Method to get the different point of the shape
	public double getCenterX(){
		return _shape.getCenterX();
	}
	public double getCenterY(){
		return _shape.getCenterY();
	}
	public double getMaxX(){
		return _shape.getMaxX();
	}
	public double getMaxY(){
		return _shape.getMaxY();
	}
	public double getX(){
		return _shape.getX();
	}
	public double getY(){
		return _shape.getY();
	}
	
	//Method to set location, size, rotation and thickness
	public void setLocation(double x, double y){
		_shape.setFrame(x, y, _shape.getWidth(), _shape.getHeight());
	}
	public void setSize(double width, double height){
		_shape.setFrame(_shape.getX(), _shape.getY(), width, height);
	}
	public void setRotation(double rotation){
		_rotation = rotation;
	}
	public void setThickness(int thickness){
		_strokeWidth = thickness;
	}
	
	public void draw(java.awt.Graphics2D aBrush){
		Color originalColor = aBrush.getColor();
		aBrush.setColor(_borderColor);
		java.awt.Stroke originalStroke = aBrush.getStroke();
		aBrush.setStroke(new java.awt.BasicStroke(_strokeWidth));
		aBrush.rotate(_rotation, getCenterX(), getCenterY());
		aBrush.draw(_shape);
		aBrush.rotate(-_rotation, getCenterX(), getCenterY());
		//restore the original brush
		aBrush.setColor(originalColor);
		aBrush.setStroke(originalStroke);
	}
	
	public void fill(java.awt.Graphics2D aBrush){
		Color originalColor = aBrush.getColor();
		aBrush.setColor(_fillColor);
		aBrush.rotate(_rotation, getCenterX(), getCenterY());
		aBrush.fill(_shape);
		aBrush.rotate(-_rotation, getCenterX(), getCenterY());		
		//restore the original brush color
		aBrush.setColor(originalColor);
	}
}
