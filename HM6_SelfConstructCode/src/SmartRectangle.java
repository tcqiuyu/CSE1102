/*
 * SmartRectangular.java
 * This class defines a rectangular shape
 */
public class SmartRectangle extends SmartRectangularShape{

	public SmartRectangle(java.awt.Color aBorderColor, java.awt.Color aFillColor){
		super(new java.awt.geom.Rectangle2D.Double());
		super.setBorderColor(aBorderColor);
		super.setFillColor(aFillColor);
	}
}
