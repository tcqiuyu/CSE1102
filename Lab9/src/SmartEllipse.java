/*
 * SmartEllipse.java
 * This is a class that defines an ellipse 
 */
public class SmartEllipse extends java.awt.geom.Ellipse2D.Double{

	private java.awt.Color _color;
	private final int DIAMETER = 60;
	
	public SmartEllipse(double x, double y){
		super();
		this.setFrame(x, y, DIAMETER, DIAMETER);
		this.SetColor(java.awt.Color.RED);
	}
	
	public void SetColor(java.awt.Color aColor){
		_color = aColor;
	}
	
	public void fill(java.awt.Graphics2D aBrush){
		java.awt.Color savedColor = aBrush.getColor();
		aBrush.setColor(_color);
		aBrush.fill(this);
		aBrush.setColor(savedColor);
	}
}
