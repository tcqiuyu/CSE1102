import wheels.users.*;
import java.awt.Color;

public class Trashcan {
	private Ellipse _top;
	private Ellipse _bot;
	private Line _body1;
	private Line _body2;
	
	//default constructor which generate a trash can
	public Trashcan(){
		_top = new Ellipse();
		_bot = new Ellipse();
		_body1 = new Line();
		_body2 = new Line();
		
		_top.setFrameColor(Color.BLACK);
		_top.setFrameThickness(2);
		_top.setFillColor(null);
		_top.setSize(36, 12);
		_top.setLocation(293, 264);
		_bot.setFillColor(null);
		_bot.setFrameColor(Color.BLACK);
		_bot.setFrameThickness(2);
		_bot.setSize(24, 8);
		_bot.setLocation(300, 300);
		_body1.setColor(Color.BLACK);
		_body1.setPoints(293, 270, 300, 304);
		_body1.setThickness(2);
		_body2.setColor(Color.BLACK);
		_body2.setPoints(329, 270, 324, 304);
		_body2.setThickness(2);
	}
	
	//constructor that can make it possible to move the trash can.
	public Trashcan(int x, int y){
		this();
		_top.setLocation(293+x, 264+y);
		_bot.setLocation(300+x, 300+y);
		_body1.setPoints(293+x, 270+y, 300+x, 304+y);
		_body2.setPoints(329+x, 270+y, 324+x, 304+y);
	}
	
}
