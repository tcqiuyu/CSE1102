//The Red Rectangle of Death!

public class NextApp extends wheels.users.Frame {
	private wheels.users.RoundedRectangle _roundedRectangle;
	private wheels.users.Line _line;
	private wheels.users.Ellipse _ellipse;
	public NextApp (){ //constructor definition
		_roundedRectangle = new wheels.users.RoundedRectangle();
		_line = new wheels.users.Line();
		_line.setPoints(100, 100, 100, 200);
		_line.setThickness(2);
		_ellipse = new wheels.users.Ellipse();
		new wheels.users.ConversationBubble("I am the Red Rectangle of Death!");
	}
	
	//magic to let NextApp execute
	public static void main(String[] args){
		NextApp app = new NextApp();
	}
}
