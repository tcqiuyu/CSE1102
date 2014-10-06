/*
 * MoveDispatcher.java
 * This is an interface which describes the ability to send move request to all parts
 * that we want to move together under this class. 
 */
public interface MoveDispatcher {
	void requestMove(int x, int y);
}
