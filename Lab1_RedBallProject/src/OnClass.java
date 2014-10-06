public class OnClass extends wheels.users.Frame {
	private wheels.users.Ellipse _ellipse;
	public OnClass (){ //constructor definition
		_ellipse = new wheels.users.Ellipse();
		new wheels.users.ConversationBubble("I am the Red Ball of Death!");
	}

	public int getBallHeight(){
		return _ellipse.getHeight();
	}
	public int getBallWidth(){
		return _ellipse.getWidth();
	}
	public void setWidthAndHeight(int p){
		_ellipse.setSize(p, p);
	}
	
}