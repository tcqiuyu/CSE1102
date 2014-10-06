import java.awt.Color;

import wheels.users.*;

public class MainApp extends Frame{
	
	public MainApp(){
		new TallHat(Color.BLACK, Color.GRAY);
		new TallHat(Color.RED, Color.BLUE);
	}
	public static void main(String[] args){
		new MainApp();
	}
}
