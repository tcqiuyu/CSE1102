import wheels.users.*;

import java.awt.Color;
import java.awt.color.*;
//This is the background in Scenario 1 and 3. Which sketch a general view in a room. 
 
public class Background {
	//declare variables
	private Line _contour1;
	private Line _contour2;
	private Line _contour3;
	
	public Background(){
		_contour1 = new Line();
		_contour2 = new Line();
		_contour3 = new Line();
		this._contour1.setColor(Color.GRAY);
		this._contour2.setColor(Color.GRAY);
		this._contour3.setColor(Color.GRAY);
		

		this._contour1.setPoints(550, 0, 550, 300);
		this._contour2.setPoints(0, 300, 550, 300);
		this._contour3.setPoints(550, 300, 800, 500);
	}
	
}
