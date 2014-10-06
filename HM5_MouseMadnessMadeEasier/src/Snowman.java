/*
 * Snowman.java
 * This class will draw a snowman with body, head, and a hat.
 */
public class Snowman implements MoveDispatcher{
	
	private Mover _body, _head, _hat, _bubble;
	
	//constructor that will create a snowman.
	public Snowman(){
		_body = new SnowmanBody(this);
		_head = new SnowmanHead(this);
		_hat = new Hat();
		_bubble = new ContainedMousableBubble(this, "Happy SnowDay!",30,100);
	}
	
	//requestMove method will be called by snowman's part, in order to move other parts together.
	public void requestMove(int x, int y){
		//call methods of different parts individually so that to move them as a whole
		_body.move(x, y);
		_head.move(x, y);
		_hat.move(x, y);
		_bubble.move(x, y);
	}
	
}
