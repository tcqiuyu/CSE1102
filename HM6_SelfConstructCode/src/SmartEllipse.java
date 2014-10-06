/*
 * SmartEllipse.java
 * This class defines an ellipse shape
 */
public class SmartEllipse extends SmartRectangularShape{

	public SmartEllipse(java.awt.Color aBorderColor, java.awt.Color aFillColor){
		super(new java.awt.geom.Ellipse2D.Double());
		super.setBorderColor(aBorderColor);
		super.setFillColor(aFillColor);
	}
}
