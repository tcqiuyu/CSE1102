//The Red Ball of Death!

public class FirstApp extends wheels.users.Frame {
	private wheels.users.Ellipse _ellipse;
	private wheels.users.ConversationBubble _bubble;
	
	public FirstApp (){ //constructor definition
		_ellipse = new wheels.users.Ellipse();
		_bubble = new wheels.users.ConversationBubble("I am the Red Ball of Death!");
	}
	
	//provide access to ball color
	public java.awt.Color getBallColor(){
		return _ellipse.getColor();
	}
	//magic to let FirstApp execute
	public static void main(String[] args){
		FirstApp app = new FirstApp();
	}
}
