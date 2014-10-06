/*
 * GridRect.java
 * This class draws the background grid for the main panel.
 */

public class GridRect extends java.awt.geom.Rectangle2D.Double {
    private java.awt.Color _color; // attributes
    private final int STROKE_WIDTH = 1;

    
    public GridRect(java.awt.Color aColor){ 
		_color = aColor;//The color of the 
    }

    //set the border color
    public void setBorderColor (java.awt.Color aColor) {
    	_color = aColor;
    }

    // set the location
    public void setLocation (double x, double y) {
    	this.setFrame (x, y, this.getWidth(), 
    			this.getHeight());
    }
    //set the size
    public void setSize (double aWidth, double aHeight) {
		this.setFrame(this.getX(), this.getY(), 
			      aWidth, aHeight);
    }

    //just need to draw the contour
    public void draw (java.awt.Graphics2D aBrush) {
		java.awt.Color savedColor = aBrush.getColor();
		aBrush.setColor(_color);
		java.awt.Stroke savedStroke = aBrush.getStroke();
		aBrush.setStroke(new java.awt.BasicStroke(STROKE_WIDTH));
		aBrush.draw(this);
		aBrush.setStroke(savedStroke);
		aBrush.setColor(savedColor);
    }
}
