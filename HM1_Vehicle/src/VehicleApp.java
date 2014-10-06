// Homework1:Vehicle
// Yu Qiu
// yuq12002
// Math Department
import java.awt.Color;

public class VehicleApp extends wheels.users.Frame {
	//declare instance variables 
	private wheels.users.Rectangle _body1;
	private wheels.users.Rectangle _body2;
	private wheels.users.Rectangle _window;
	private wheels.users.Line _barrel;
	private wheels.users.Ellipse _tire;
	private wheels.users.Ellipse _hubcap;
	private wheels.users.ConversationBubble _bubble;
	
	public VehicleApp(){
		//drawing tank's body
		_body1 = new wheels.users.Rectangle(180,180);
		_body1.setFillColor(Color.LIGHT_GRAY);
		_body1.setFrameColor(Color.BLACK);
		_body1.setSize(350, 120);
		_body1.setFrameThickness(2);
		_barrel = new wheels.users.Line(400, 180, 600, 80);
		_barrel.setColor(Color.BLACK);
		_barrel.setThickness(15);
		_body2 = new wheels.users.Rectangle(280,140);
		_body2.setColor(Color.WHITE);
		_body2.setFrameColor(Color.BLACK);
		_body2.setSize(150,80);
		_body2.setFrameThickness(2);
		_window = new wheels.users.Rectangle(365,150);
		_window.setFillColor(null);
		_window.setFrameColor(Color.BLACK);
		_window.setSize(50, 20);
		_window.setFrameThickness(2);
		
		//drawing tank's wheels
		for (int i=0; i<10; i++){
			_tire = new wheels.users.Ellipse(155+i*40,300);
			_hubcap = new wheels.users.Ellipse(155+10+i*40,10+300);
			_tire.setFillColor(Color.GRAY);
			_tire.setSize(40,40);
			_tire.setFrameColor(Color.BLACK);
			_tire.setFrameThickness(2);
			_hubcap.setFillColor(Color.LIGHT_GRAY);
			_hubcap.setSize(20, 20);
			_hubcap.setFrameColor(Color.BLACK);
			_hubcap.setFrameThickness(2);
			}
		
		//a conversation bubble
		_bubble = new wheels.users.ConversationBubble("Really? I am a tank?!  orz");
		_bubble.setLocation(70,50);
		}
	
	//execute the app. YAY!
	public static void main(String[] args){
		VehicleApp vehicle = new VehicleApp();
	}
}
