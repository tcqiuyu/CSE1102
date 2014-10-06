/*
 * An interface that indicates the ability to be dragged.
 */

import java.awt.event.*;

public interface Draggable {
	public void setLocation(int x, int y);
	public void mousePressed(MouseEvent e);
	public void mouseDragged(MouseEvent e);
}
