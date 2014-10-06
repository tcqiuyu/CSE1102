import wheels.users.Frame;

/*Assignment2 for Yu Qiu, Math Dep.
 * The theme of this cartoon is 
 * "A bear go to the restaurant"
 */

/*I am sorry I didn't have constructor about setMessage. 
 * Because if I do that, I don't know how to erase the conversation bubble.
 * And there will be residual of the conversation bubble in the following scene.
 */

public class MainApp extends Frame {
	private Scenario1 _scen1;
	
	public MainApp(){
		_scen1 = new Scenario1();
	}
	
	public static void main(String [] args) {
		MainApp app = new MainApp();
	}
}
