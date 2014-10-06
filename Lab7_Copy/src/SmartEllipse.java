/**
 * Chapter 7: SmartEllipse.java
 * Extends Java's Ellipse2D.Double class, adding the capabilities to
 * set color, rotation, location, and size, to move to a specified
 * location, and to display itself on a panel.
 */
public class SmartEllipse extends java.awt.geom.Ellipse2D.Double{
	private java.awt.Color _borderColor, _fillColor; // attributes
	private int _rotation;
	private final int STROKE_WIDTH = 2;
	private BallPanel _panel; 
	private double _bounceVelo;
	private double _startTime;
	private int _direction;
	private double _veloY;
	private double _v0;
	private double _g;
	private double _s0; 
	
	public SmartEllipse(java.awt.Color aColor, BallPanel panel){ 
		_panel = panel;
		_borderColor = aColor;
		_fillColor = aColor; // solid color to start
		_rotation = 0; // no rotation for now
		_direction = 1;
		_v0=0;
		_g = 180.5;
		_s0=75;
	}

	// methods not provided by Java
	public void setBorderColor (java.awt.Color aColor) {
		_borderColor = aColor;
	}
	public void setFillColor (java.awt.Color aColor) {
		_fillColor = aColor;
	}
	public void setRotation (int aRotation) {
		_rotation = aRotation;
	}

	// more readable versions of methods provided by Java
	public void setLocation (double x, double y) {
		this.setFrame (x, y, this.getWidth(), this.getHeight());
	}
	public void setSize (int aWidth, int aHeight) {
		this.setFrame(this.getX(), this.getY(), aWidth, aHeight);
	}
	public void move (double aChangeInX, double aChangeInY) {
		this.setFrame(this.getX()+aChangeInX,
				this.getY()+aChangeInY,
				this.getWidth(),
				this.getHeight());
	}
	
	public void fall(long startTime){
		double currentTime = System.currentTimeMillis();
		double time = (currentTime - startTime)/1000;
		_veloY =_v0 +_g*time;
		double locY = _s0 +_v0*time+ 0.5*_g*time*time;
		
		if(locY > 375){
			_v0 = -_g*time;
			locY = 375;
			_s0 = 375;
			_panel.setStartTime();
		}
		
		else if(_veloY >= -2 && _veloY <= 0){
			_v0 = 0;
			_s0 = this.getY();
			
			_panel.setStartTime();
		}
		
		this.setLocation(this.getX()+0.5, locY); 
		System.out.print(time +"  "+ _veloY + "  " + "  "+locY +"\n");

	}
	
	public void fill (java.awt.Graphics2D aBetterBrush){
		java.awt.Color savedColor = aBetterBrush.getColor();
		aBetterBrush.setColor(_fillColor);
		aBetterBrush.fill(this); // paint a solid ellipse
		aBetterBrush.setColor(savedColor);
	}
	public void draw (java.awt.Graphics2D aBrush) {
		java.awt.Color savedColor = aBrush.getColor();
		aBrush.setColor(_borderColor);
		java.awt.Stroke savedStroke = aBrush.getStroke();
		aBrush.setStroke(new java.awt.BasicStroke(STROKE_WIDTH));
		aBrush.draw(this);
		aBrush.setStroke(savedStroke);
		aBrush.setColor(savedColor);
	}
}
