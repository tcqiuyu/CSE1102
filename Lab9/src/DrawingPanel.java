/*
 * DrawingPanel.java
 * This is a class that creates a panel where you can add ellipse by clicking the mouse
 */
public class DrawingPanel extends javax.swing.JPanel{

	private SmartEllipse[] _ellipseArray;//declare a array that store all the ellipses.
	private int _numberOfEllipse;//a variable that stores the number of ellipses.
	private final int DIAMETER = 60;

	public DrawingPanel(){
		super();
		this.setBackground(java.awt.Color.WHITE);
		//add mouse listener to the panel.
		this.addMouseListener(new MyMouseListener(this));
		//the starting length of the array is 5.
		_ellipseArray = new SmartEllipse[5];
	}
	
	
	public void paintComponent(java.awt.Graphics aBrush){
		java.awt.Graphics2D aBetterBrush = (java.awt.Graphics2D) aBrush;
		if(_numberOfEllipse>0){
			for(int i = 0; i < _numberOfEllipse; i++){
				_ellipseArray[i].fill(aBetterBrush);
			}
		}
		//if there is no ellipse in the array, do not call the fill method.
		else{
			super.paintComponents(aBrush);
		}
	}
	
	//a inner class extends from MouseInputAdapter
	private class MyMouseListener extends java.awt.event.MouseAdapter{
		private javax.swing.JPanel _panel;//peer object, so that it can call the repaint method every time we press the mouse
	
		public MyMouseListener(DrawingPanel panel){
			_panel = panel;
	}
		public void mousePressed(java.awt.event.MouseEvent e){
			boolean eraseEllipse = false;
			int serialOfErase = 0;
			
			//decide whether to erase a existed ellipse or not
			for(int i=0; i<_numberOfEllipse; i++){
				if(_ellipseArray[i].contains(e.getPoint())){
					eraseEllipse = true;
					serialOfErase = i;
				}
			}
			
			//erase a existed ellipse
			if (eraseEllipse){
				_numberOfEllipse--;
				_ellipseArray[serialOfErase] = _ellipseArray[_numberOfEllipse];
				_ellipseArray[_numberOfEllipse] = null;
			}
			//or draw a new ellipse
			else{
				_ellipseArray[_numberOfEllipse] = new SmartEllipse(e.getX()-30,e.getY()-30);
				_numberOfEllipse++;
			}
			
			//enlarge the length of array when it is full
			if (_numberOfEllipse==_ellipseArray.length){
				_ellipseArray = this.EnlargeArray(_ellipseArray);
			}
			//shrink the length of array when only 25% of it is full
			else if(_numberOfEllipse  < Math.floor(_ellipseArray.length/4) && _ellipseArray.length > 5){
				_ellipseArray = this.ShrinkArray(_ellipseArray);
			}
			
			//output the number of ellipse and the length of ellipse array to check the result
			System.out.print(_numberOfEllipse+","+_ellipseArray.length+"\n");
			//repaint the panel every time we press the mouse
			_panel.repaint();
		
		}
		
		//a method to enlarge an array by double its size
		public SmartEllipse[] EnlargeArray(SmartEllipse[] array){
			SmartEllipse[] newArray = new SmartEllipse[array.length*2];
			for(int i = 0; i < array.length; i++){
				newArray[i] = array[i];
				array[i] = null;
			}
			return newArray;
		}
		
		//a method to shrink an array by half its size
		public SmartEllipse[] ShrinkArray(SmartEllipse[] array){
			SmartEllipse[] newArray = new SmartEllipse[(int)Math.ceil(array.length/2)];
			for(int i = 0; i < newArray.length; i++){
				newArray[i] = array[i];
				array[i] = null;
			}
			return newArray;
		}
	}	
}
