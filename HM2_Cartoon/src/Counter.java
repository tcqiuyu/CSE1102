import wheels.users.*;

import java.awt.Color;

public class Counter{
	//declare variables
	private Line _desk1;
	private Line _desk2;
	private Rectangle _fill;
	
	public Counter(){
		_desk1 = new Line();
		_desk2 = new Line();
		_fill = new Rectangle();
		
		this._desk1.setColor(Color.BLACK);
		this._desk2.setColor(Color.BLACK);
		this._fill.setColor(Color.WHITE);
		
		this._desk1.setThickness(3);
		this._desk2.setThickness(3);

		this._desk1.setPoints(0, 430, 400, 430);
		this._desk2.setPoints(400, 430, 600, 600);
		this._fill.setSize(400, 100);
		this._fill.setLocation(0, 432);
	}
	
}
