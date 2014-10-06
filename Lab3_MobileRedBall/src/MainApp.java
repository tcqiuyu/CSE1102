import java.awt.Color;

import wheels.users.*;

public class MainApp extends Frame{
	private MobileRedBall _redball1;
	private MobileRedBall _redball2;
	private MobileRedBall _redball3;
	
	public MainApp(){
		_redball1 = new MobileRedBall(100,100,Color.CYAN);
		_redball2 = new MobileRedBall(100,200,Color.RED);
		_redball3 = new MobileRedBall(100,300,Color.YELLOW);
	}
	
	public static void main(String[] args){
		MainApp app = new MainApp();
	}
}
