/*
 * Hat.java
 * This class draws a Hat which consists of several rectangles,
 * which belongs to ContainedMousableRecangle class. 
 */

import java.awt.Color;

public class Hat implements Mover, MoveDispatcher{
	//declare variables
	private Mover _brim, _band1, _band2, _band3, _band4;
	
	//constructor with parameters of location and size
	public Hat(int x, int y, int width, int height){
		//instantiate different parts of a hat
		_brim = new ContainedMousableRectangle(this, x, y, width, height, Color.BLACK);
		_band1 = new ContainedMousableRectangle(this, x+20, y-25, width-40, height+10, Color.DARK_GRAY);
		_band2 = new ContainedMousableRectangle(this, x+20, y-50, width-40, height+10, Color.BLACK);
		_band3 =  new ContainedMousableRectangle(this, x+20, y-75, width-40, height+10, Color.DARK_GRAY);
		_band4 =  new ContainedMousableRectangle(this, x+20, y-100, width-40, height+10, Color.BLACK);
	}
	
	//constructor which create a default hat
	public Hat(){
		this(200,200,100,15);
	}
	
	//move method that will be called by its container to move all parts under this class 
	public void move(int x, int y){
		_brim.move(x, y);
		_band1.move(x, y);
		_band2.move(x, y);
		_band3.move(x, y);
		_band4.move(x, y);
	}
	
	
	 // requestMove method that will be called by its parts to move all parts
	 // In this case, moving hat will not influence other parts of the snowman, 
	 // so this method will call method to just move itself.  
	public void requestMove(int x, int y){
		this.move(x, y);
	}
}
