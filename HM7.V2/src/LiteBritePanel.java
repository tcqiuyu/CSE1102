
public class LiteBritePanel extends javax.swing.JPanel implements Flasher{

	private ColorEllipse [] _ellipseArray;
	private int _numberOfEllipse;
	private java.awt.Color _color;
	private java.util.ArrayList<java.awt.Color> _colorArray;
	private FlashTimer _flashTimer;
	private LiteBriteFrame _briteFrame;
	
	public LiteBritePanel (LiteBriteFrame briteFrame){
		super();
		_briteFrame = briteFrame;
		_flashTimer  = new FlashTimer(100,this);
		this.setBackground(java.awt.Color.BLACK);
		this.addMouseListener(new MyMouseListener(this));
		_ellipseArray = new ColorEllipse[5];
		_colorArray = new java.util.ArrayList<java.awt.Color>();
		_color = java.awt.Color.RED;
	}
	
	public void TimerStart(){
		_flashTimer.start();
	}
	
	public void TimerStop(){
		_flashTimer.stop();
	}
	
	public void setColor(java.awt.Color aColor){
		_color = aColor;
	}
	
	public void setPegNum(int n){
		_numberOfEllipse = n;
	}
	public int getPegNum(){
		return _numberOfEllipse;
	}
	public void paintComponent(java.awt.Graphics aBrush){
		super.paintComponent(aBrush);
		java.awt.Graphics2D betterBrush = (java.awt.Graphics2D) aBrush;
		if (_numberOfEllipse>0){
			for(int i = 0; i < _numberOfEllipse; i++){
				_ellipseArray[i].fill(betterBrush);
			}
		}
		else{
			super.paintComponent(aBrush);
		}
	}
	
	public void RestoreColor(){
		for(int i = 0; i < _numberOfEllipse; i++){
			_ellipseArray[i].setColor(_colorArray.get(i));
		}
	}
	
	public void MakeFlash(){
		this.RestoreColor();
		for(int i = 0; i < randomNumber(0,_numberOfEllipse-1); i++){
			_ellipseArray[randomNumber(0,_numberOfEllipse-1)].setColor(getBackground());
		}
	}
	
	private int randomNumber(int low, int high){
    	return low+(int)(Math.random()*(high-low+1));
    } 
	
	public ColorEllipse[] getEllipseArray(){
		this.RestoreColor();
		return _ellipseArray;
	}
	
	public void setEllipseArray(ColorEllipse[] ellipseArray){
		_ellipseArray = ellipseArray;
	}
	
	public void setColorArray(java.util.ArrayList<java.awt.Color> l){
		_colorArray = l;
	}
	
	public java.util.ArrayList<java.awt.Color> getColorArray(){
		this.RestoreColor();
		return _colorArray;
	}
	private class MyMouseListener extends java.awt.event.MouseAdapter{
		
		private LiteBritePanel _panel;

		public MyMouseListener(LiteBritePanel panel){
			_panel = panel;
			
		}
		
		@Override
		public void mousePressed(java.awt.event.MouseEvent e){
			int eraseEllipse = 2;
			int serialOfErase = 0;
			
			for(int i = 0; i < _numberOfEllipse; i++){
				if(_ellipseArray[i].contains(e.getPoint())){
					eraseEllipse = 0;//0 means we should erase the ellipse
					serialOfErase = i;
					break;//if we should draw a new ellipse, break the loop
				}
				else if(_ellipseArray[i].contains(this.getEllipseX(e)+9,this.getEllipseY(e)+9)){
					eraseEllipse = 1;//1 means we do nothing
					break;
				}
				else{
					eraseEllipse = 2;//2 means we create a new ellipse
				}
			}
			
			if(eraseEllipse==0){//erase the ellipse
				_numberOfEllipse--;
				_ellipseArray[serialOfErase] = _ellipseArray[_numberOfEllipse];
				_colorArray.add(serialOfErase, _colorArray.get(_numberOfEllipse));
				_ellipseArray[_numberOfEllipse] = null;
				_colorArray.remove(_numberOfEllipse);
			}
			else if(eraseEllipse == 1){//do nothing
			}
			else if(eraseEllipse == 2){//draw a new ellipse
				_ellipseArray[_numberOfEllipse] = new ColorEllipse(getEllipseX(e),getEllipseY(e));
				_ellipseArray[_numberOfEllipse].setColor(_color);
				_colorArray.add(_numberOfEllipse, _color);
				_numberOfEllipse++;
			}
			
			if( _numberOfEllipse ==_ellipseArray.length){
				_ellipseArray = this.EnlargeArray(_ellipseArray);
				
			}
			else if(_numberOfEllipse < Math.floor(_ellipseArray.length/4) && _ellipseArray.length>5){
				_ellipseArray = this.ShrinkArray(_ellipseArray);
			}

			_briteFrame.setStatusBarText(_numberOfEllipse + " pegs are being created.");
			
			//output the number of ellipse and the length of ellipse array to check the result
//			System.out.print(_numberOfEllipse+","+_ellipseArray.length+"\n");
			//repaint the panel every time we press the mouse
			_panel.repaint();

		}
		

		public ColorEllipse[] EnlargeArray(ColorEllipse[] array){
			ColorEllipse[] newArray = new ColorEllipse[array.length*2];
			for(int i = 0; i < array.length; i++){
				newArray[i] = array[i];
				array[i] = null;
			}
			return newArray;
		}
		
		public ColorEllipse[] ShrinkArray(ColorEllipse[] array){
			ColorEllipse[] newArray = new ColorEllipse[(int)Math.ceil(array.length/4)];
			for(int i = 0; i < newArray.length; i++){
				newArray[i] = array[i];
				array[i] = null;
			}
			return newArray;
		}
		
		public int getEllipseX(java.awt.event.MouseEvent e){//make offset of each line 
			if(isOdd((int)Math.ceil(e.getY()/20))){
				return (int)Math.rint((double)e.getX()/20)*20-10;
			}
			else{
				return (int)Math.ceil(e.getX()/20)*20;
			}
		}
		
		public int getEllipseY(java.awt.event.MouseEvent e){
			return (int)Math.ceil(e.getY()/20)*20;
		}
		
		public boolean isOdd(int a){
			if (a%2 != 0){
				return true;
			}
			else{
				return false;
			}		
		}
	}
}
