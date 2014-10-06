/*
 * SmartArc.java
 * This class defines arc shape.
 */
public class SmartArc extends SmartRectangularShape{
	
	public SmartArc(double aStart, double anExtent, int aType, 
			java.awt.Color aBorderColor, java.awt.Color aFillColor){
		super(new java.awt.geom.Arc2D.Double(0, 0, 0, 0,
												aStart, anExtent,aType));
		super.setBorderColor(aBorderColor);
		super.setFillColor(aFillColor);
	}
}
