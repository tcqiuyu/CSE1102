/*
 * MotleyFish.java
 * This class defines a fish which has different color of body and tail.
 */
import java.awt.Color;

public class MotleyFish extends Fish {

	public MotleyFish(Color bodyColor, Color tailColor, 
			SmartRectangle aRectangle, double sizeFactor){
		super(null,aRectangle,sizeFactor);
		this._body.setColor(bodyColor, bodyColor);
		this._tail.setColor(tailColor, tailColor);
	}
}
