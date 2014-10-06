import wheels.users.*;

import java.awt.Color;
//Table class, use it to create multiple tables.
public class Table {
	//Declare variables
	private Ellipse _tableTop;
	private RoundedRectangle _tableLeg1;
	private RoundedRectangle _tableLeg2;
	private RoundedRectangle _tableLeg3;
	private Color _colorTableTop;
	private Color _colorTableLeg;

	//constructor with no parameter (default table)
	public Table(){
		_colorTableTop = Color.GRAY;
		_colorTableLeg = Color.GRAY;
		_tableLeg1 = new RoundedRectangle();
		_tableLeg2 = new RoundedRectangle();
		_tableLeg3 = new RoundedRectangle();
		_tableTop = new Ellipse();
		this.setLocation(200, 200, 10);
		this.setColor(_colorTableTop, _colorTableLeg);
		this.setSize(10);
	}
	
	//constructor with various parameters: location, size
	public Table(int x, int y, int z){
		this();
		this.setLocation(x, y, z);
		this.setColor(Color.GRAY,Color.GRAY);
		this.setSize(z);
	}
	
	//set color, as well as setting the frame color and frame thickness
	public void setColor(Color a, Color b){
		this._tableTop.setColor(a);
		this._tableTop.setFrameColor(Color.BLACK);
		this._tableTop.setFrameThickness(2);
		this._tableLeg1.setColor(b);
		this._tableLeg1.setFrameColor(Color.BLACK);
		this._tableLeg1.setFrameThickness(2);
		this._tableLeg2.setColor(b);
		this._tableLeg2.setFrameColor(Color.BLACK);
		this._tableLeg2.setFrameThickness(2);
		this._tableLeg3.setColor(b);
		this._tableLeg3.setFrameColor(Color.BLACK);
		this._tableLeg3.setFrameThickness(2);
	}
	
	//set location  
	public void setLocation(int x, int y, int z){
		this._tableTop.setLocation(x, y);
		this._tableLeg1.setLocation(x+3*z, y+2*z);
		this._tableLeg2.setLocation(x+9*z, y+2*z);
		this._tableLeg3.setLocation(x+15*z, y+2*z);
	}
	
	//set the whole size of the table
	public void setSize(int z){
		this._tableTop.setSize(19*z, 5*z);
		this._tableLeg1.setSize(z, 11*z);
		this._tableLeg2.setSize(z, 8*z);
		this._tableLeg3.setSize(z, 11*z);
	}
	
}
