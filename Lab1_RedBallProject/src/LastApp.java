import java.awt.Color;

import wheels.users.Line;

//The Last App!

public class LastApp extends wheels.users.Frame {
	private wheels.users.Ellipse _ellipse;
	private wheels.users.Rectangle _rectangle;
	private wheels.users.RoundedRectangle _roundedrectangle;
	
	public LastApp (){ //constructor definition
		_ellipse = new wheels.users.Ellipse(200,200);
		_ellipse = new wheels.users.Ellipse(100,200);

		_rectangle = new wheels.users.Rectangle(300, 200);
		_roundedrectangle = new wheels.users.RoundedRectangle(400, 200);

		new wheels.users.ConversationBubble("I am the colorful ...Whatever... of Death!");
		//set color
		_ellipse.setColor(Color.blue);
		_rectangle.setColor(Color.green);
		_roundedrectangle.setColor(Color.yellow);
		
	}
	
	//magic to let LastApp execute
	public static void main(String[] args){
		LastApp app = new LastApp();
	}
}
