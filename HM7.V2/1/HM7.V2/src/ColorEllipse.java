
public class ColorEllipse extends java.awt.geom.Ellipse2D.Double{

	private java.awt.Color _color;
	
	public ColorEllipse(int x, int y){
		super(x, y, 18, 18);
		this.setColor(java.awt.Color.RED);
	}
	
	public void setColor(java.awt.Color aColor){
		_color = aColor;
	}
	
	public java.awt.Color getColor(){
		return _color;
	}
	
	public void fill(java.awt.Graphics2D aBrush){
		java.awt.Color savedColor = aBrush.getColor();
		aBrush.setColor(_color);
		aBrush.fill(this); // paint a solid ellipse
		aBrush.setColor(savedColor);
	}	
	
}
