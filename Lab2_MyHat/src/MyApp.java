import java.awt.Color;

import wheels.users.*;

public class MyApp extends Frame {
	private TallHat _aHat;
	private TallHat _bHat;

	public MyApp() {
		_aHat = new TallHat(Color.GREEN,Color.YELLOW,200,160,"I am wizard's hat!");
		_bHat = new TallHat(Color.BLACK,Color.GRAY,500,160,"Really?");
	}

	public static void main(String [] args) {
	    MyApp app = new MyApp();
	}
}
