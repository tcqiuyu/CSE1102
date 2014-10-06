import java.awt.Color;

import wheels.users.*;

public class RedBall extends Ellipse {

	public RedBall(){
		setColor(Color.RED);
	}
	
	public RedBall(Color a){
		setColor(a);
	}
	
	public void mousePressed(java.awt.event.MouseEvent e){
		this.setColor(Color.GREEN);
	}
	
	public void mouseReleased(java.awt.event.MouseEvent e){
		this.setColor(Color.RED);
	}
	
	private static wheels.users.Frame _frame;
	
	public static void main(String[] args) {
		_frame = new wheels.users.Frame();
		RedBall ball = new RedBall();
	}
}
