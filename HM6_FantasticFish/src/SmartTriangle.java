import java.awt.Color;


public class SmartTriangle extends java.awt.Polygon{

	private Color _borderColor, _fillColor;
	private static int NPOINTS = 3;
	private final int STROKE_WIDTH =2;
	
	public SmartTriangle(int x1, int y1, int x2, 
			int y2, int x3, int y3){
		super(new int[]{x1,x2,x3}, new int[]{y1,y2,y3},NPOINTS);
	}
	
	public void move(int x, int y){
		this.translate(x, y);
	}
	
	public void setBorderColor(Color aColor){
		_borderColor = aColor;
	}
	
	public void setFillColor(Color aColor){
		_fillColor = aColor;
	}
	
	public void fill(java.awt.Graphics2D aBrush){
		Color originalColor = aBrush.getColor();
		aBrush.setColor(_fillColor);
		aBrush.fillPolygon(this);
		aBrush.setColor(originalColor);
	}
	
	public void draw(java.awt.Graphics2D aBrush){
		//store the original color and set new color
		Color originalColor = aBrush.getColor();
		aBrush.setColor(_borderColor);
		
		//store the original stroke and set new stroke
		java.awt.Stroke originalStroke = aBrush.getStroke();
		aBrush.setStroke(new java.awt.BasicStroke(STROKE_WIDTH));
		
		//draw the border
		aBrush.drawPolygon(this);
		
		//restore to original color and stroke
		aBrush.setColor(originalColor);
		aBrush.setStroke(originalStroke);
	}
}
