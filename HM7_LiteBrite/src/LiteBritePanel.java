/*
 * LiteBritePanel.java
 * This is the panel that presents all the pegs created
 */
public class LiteBritePanel extends javax.swing.JPanel implements Flasher{

	private ColorEllipse [] _pegArray;//array that stores all pegs
	private int _numberOfPegs;//the number of pegs that are currently created
	private java.awt.Color _color;
	private java.util.ArrayList<java.awt.Color> _colorArrayList;//an array list that stores all color corresponding to every peg
	private FlashTimer _flashTimer;//a timer that makes pegs flash
	private LiteBriteFrame _briteFrame;//peer object, this panel should know its container
	
	public LiteBritePanel (LiteBriteFrame briteFrame){
		super();
		_briteFrame = briteFrame;
		//instantiate the timer
		_flashTimer  = new FlashTimer(100,this);
		//set the background of the panel to black
		this.setBackground(java.awt.Color.BLACK);
		//register the mouse listener, so that it will generate pegs when clicking on the panel
		this.addMouseListener(new MyMouseListener(this));
		//instantiate the peg array, and the initial length of the peg array is 5
		_pegArray = new ColorEllipse[5];
		//instantiate the color array list
		_colorArrayList = new java.util.ArrayList<java.awt.Color>();
		//the initial color of the peg is red
		_color = java.awt.Color.RED;
	}
	
	//start the timer
	public void TimerStart(){
		_flashTimer.start();
	}
	
	//stop the timer
	public void TimerStop(){
		_flashTimer.stop();
	}
	
	//Set the color of next peg that will be created
	public void setColor(java.awt.Color aColor){
		_color = aColor;
	}
	
	//set the number of pegs manually
	public void setPegNum(int n){
		_numberOfPegs = n;
	}
	
	//get the current number of pegs
	public int getPegNum(){
		return _numberOfPegs;
	}
	
	//paint the panel
	public void paintComponent(java.awt.Graphics aBrush){
		super.paintComponent(aBrush);
		java.awt.Graphics2D betterBrush = (java.awt.Graphics2D) aBrush;
		
		//When the peg array is not empty, paint the peg(s) in it.
		if (_numberOfPegs>0){
			//this loop makes it possible to paint every peg in the peg array
			for(int i = 0; i < _numberOfPegs; i++){
				_pegArray[i].fill(betterBrush);
			}
		}
		//If the peg array is empty, just paint the panel
		else{
			super.paintComponent(aBrush);
		}
	}
	
	//restore the original color of each peg 
	public void RestoreColor(){
		for(int i = 0; i < _numberOfPegs; i++){
			_pegArray[i].setColor(_colorArrayList.get(i));
		}
	}
	
	//the method that makes the pegs to flash independently and randomly
	public void MakeFlash(){
		//first restore all the pegs to their original color
		this.RestoreColor();
		//this loop randomly choose the pegs and set their color as same as the background
		for(int i = 0; i < randomNumber(0,_numberOfPegs-1); i++){
			_pegArray[randomNumber(0,_numberOfPegs-1)].setColor(getBackground());
		}
	}
	
	//a private method that generates a random integer
	private int randomNumber(int low, int high){
    	return low+(int)(Math.random()*(high-low+1));
    } 
	
	//get the peg array.
	public ColorEllipse[] getPegArray(){
		//restore the original color before return the peg 
		this.RestoreColor();
		return _pegArray;
	}
	
	//manually set the peg array
	public void setPegArray(ColorEllipse[] pegArray){
		_pegArray = pegArray;
	}
	
	//manually set the color array list
	public void setColorArrayList(java.util.ArrayList<java.awt.Color> l){
		_colorArrayList = l;
	}
	
	//get the color array list
	public java.util.ArrayList<java.awt.Color> getColorArrayList(){
		//restore the original color before get the color array list
		this.RestoreColor();
		return _colorArrayList;
	}
	
	//inner class that defines the action that will be taken when click the mouse on the panel
	private class MyMouseListener extends java.awt.event.MouseAdapter{
		
		private LiteBritePanel _panel;

		public MyMouseListener(LiteBritePanel panel){
			_panel = panel;
		}
		
		@Override
		public void mousePressed(java.awt.event.MouseEvent e){
			//this local variable defines different action to be taken under different situations:
			//0 means to erase the peg
			//1 means to do nothing
			//2 means to create a new peg
			int eraseEllipse = 2;//the default is to create a new peg
			//this local variable defines which peg should be erased
			int whichToErase = 0;
			
			//this loop compares the location of the mouse when the user click it 
			//with every peg in the array and determines what action should be taken
			for(int i = 0; i < _numberOfPegs; i++){
				//if there is an peg contains the point we clicked on, then erase this ellipse
				if(_pegArray[i].contains(e.getPoint())){
					eraseEllipse = 0;//0 means we should erase the peg
					whichToErase = i;//the number of the pegs that should be erased is i
					break;//break the loop, because there is no need for further check
				}
				
				//if the mouse is click inside the grid where there is already a peg, then do nothing
				//this prevents to create multiple pegs
				else if(_pegArray[i].contains(this.getPegX(e)+9,this.getPegY(e)+9)){
					eraseEllipse = 1;//1 means we do nothing
					break;//break the loop
				}
				//elsewhile, generate a new peg
				else{
					eraseEllipse = 2;//2 means we create a new peg
				}
			}
			
			if(eraseEllipse==0){//erase the peg
				//decrease the value of number of pegs
				_numberOfPegs--;
				//substitute that peg with the peg at the end of array in the peg array
				_pegArray[whichToErase] = _pegArray[_numberOfPegs];
				//substitute the color of that peg with the color of the last peg in the color array list as well
				_colorArrayList.add(whichToErase, _colorArrayList.get(_numberOfPegs));
				//remove the last peg in the peg array
				_pegArray[_numberOfPegs] = null;
				//remove the last color in the color array list as well 
				_colorArrayList.remove(_numberOfPegs);
			}
			else if(eraseEllipse == 1){//do nothing
			}
			else if(eraseEllipse == 2){//draw a new peg
				//create a new peg at the first non-null slot in the peg array
				_pegArray[_numberOfPegs] = new ColorEllipse(getPegX(e),getPegY(e));
				//set this peg's color
				_pegArray[_numberOfPegs].setColor(_color);
				//add this peg's color to the color array list
				_colorArrayList.add(_numberOfPegs, _color);
				//increase the value of number of pegs
				_numberOfPegs++;
			}
			
			//if the number of pegs reach the length of the peg array, then double the array's size
			if( _numberOfPegs == _pegArray.length){
				_pegArray = this.EnlargeArray(_pegArray);
			}
			//if the number of pegs less than 25% of the length of the peg array, then half the array's size
			else if(_numberOfPegs < Math.floor(_pegArray.length/4) && _pegArray.length>5){
				_pegArray = this.ShrinkArray(_pegArray);
			}

			//change the text in the status bar to show the number of pegs are being used as well
			_briteFrame.setStatusBarText(_numberOfPegs + " pegs are being created.");
			
			//output the number of ellipse and the length of ellipse array to check the result
			System.out.print(_numberOfPegs+","+_pegArray.length+"\n");
			//repaint the panel every time we press the mouse
			_panel.repaint();

		}
		
		//enlarge the array
		public ColorEllipse[] EnlargeArray(ColorEllipse[] array){
			//create a new array whose size is twice larger than the given array
			ColorEllipse[] newArray = new ColorEllipse[array.length*2];
			//this loop copies all information from the given array to the new array
			for(int i = 0; i < array.length; i++){
				newArray[i] = array[i];
				array[i] = null;
			}
			return newArray;
		}
		
		//shrink the array
		public ColorEllipse[] ShrinkArray(ColorEllipse[] array){
			//create a new array whose size is half of the given array.
			ColorEllipse[] newArray = new ColorEllipse[(int)Math.ceil(array.length/2)];
			//this loop copies all information from the given array to the new array
			for(int i = 0; i < newArray.length; i++){
				newArray[i] = array[i];
				array[i] = null;
			}
			return newArray;
		}
		
		//get the peg's X location that we are going to draw at 
		public int getPegX(java.awt.event.MouseEvent e){//make offset of each line 
			//if mouse clicks on the "odd line", do offset
			if(isOdd((int)Math.ceil(e.getY()/20))){
				return (int)Math.rint((double)e.getX()/20)*20-10;
			}
			//if mouse clicks on the "even line"
			else{
				return (int)Math.ceil(e.getX()/20)*20;
			}
		}
		
		//get the peg's Y location that we are going to draw at
		public int getPegY(java.awt.event.MouseEvent e){
			return (int)Math.ceil(e.getY()/20)*20;
		}
		
		//a private method to determine whether a integer is odd or not
		private boolean isOdd(int a){
			if (a%2 != 0){
				return true;
			}
			else{
				return false;
			}		
		}
	}
}
