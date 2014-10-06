/*
 * SmartLine.java
 * This class defines a line shape.
 */
import java.awt.Color;

public class SmartLine extends java.awt.geom.Line2D.Double{
	private Color _color;
	private int _thickness;
	
	public SmartLine(Color aColor){
		super();
		_color = aColor;
		_thickness = 2;
	}
	
	//set line color
	public void setColor(Color aColor){
		_color = aColor;
	}
	//set line thickness
	public void setThickness(int n){
		_thickness = n;
	}
	
	//make the line move 
	public void move(int x, int y){
		this.setLine(this.getX1()+x, this.getY1()+y, 
				this.getX2()+x, this.getY2()+y);
	}
	
	public void draw(java.awt.Graphics2D aBrush){
		Color originalColor = aBrush.getColor();
		aBrush.setColor(_color);
		java.awt.Stroke originalStroke = aBrush.getStroke();
		aBrush.setStroke(new java.awt.BasicStroke(_thickness));
		aBrush.draw(this);
		aBrush.setStroke(originalStroke);
		aBrush.setColor(originalColor);
	}
}
