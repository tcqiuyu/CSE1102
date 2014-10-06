/*
 * MainPanel.java
 * This class defines a panel where we launch the "life game". 
 */
import java.awt.event.MouseListener;

public class MainPanel extends javax.swing.JPanel{
	private final int INTERVAL = 1000;//the step length of the timer
	private Timer _timer;
	private LifeModel _model;
	private GridRect[][] _grid;
	private final double GRIDSIZE = 20;//the size of grid background
	private final java.awt.Color BACKGROUND_COLOR = java.awt.Color.BLACK;//the color of the background
	private ColorEllipse[][] _ellipseArray;
	private final double ELLIPSE_SIZE = 18;//the size of the ellipse
	private final java.awt.Color ELLIPSE_COLOR = java.awt.Color.RED;//the color of the ellipse
	
	public MainPanel(LifeModel model){	
		super();
		_timer = new Timer(INTERVAL,this);//instantiate the timer, which makes the animation
		_model = model;
		this.setBackground(BACKGROUND_COLOR);
		//add the mouselistener so that the panel will respond to the mouse click
		this.addMouseListener(new MyMouseListener(this));
		//instantiate the gird array
		_grid = new GridRect[_model.getWidth()][_model.getHeight()];
		//instantiate the ellipse array
		_ellipseArray = new ColorEllipse[_model.getWidth()][_model.getHeight()];
		//draw the background grid
		for(int i = 0; i < _model.getWidth(); i++){
			for(int j = 0; j < _model.getHeight(); j++){
				_grid[i][j] = new GridRect(java.awt.Color.WHITE);
				_grid[i][j].setFrame(GRIDSIZE*i, GRIDSIZE*j, GRIDSIZE, GRIDSIZE);
			}
		}
	}
	
	//start animation
	public void GameStart(){
		_timer.start();
	}
	
	//pause the animation
	public void GameStop(){
		_timer.stop();
	}
	
	//update game by using the update game in LifeModel.java
	public void UpdateGame(){
		_model.updateGame();
		this.ModelToPanel();
	}
	
	//convert the boolean array we get from LifeModel to the ellipse array in the panel 
	public void ModelToPanel(){
		//for loop through row and column
		for(int i = 0; i < _model.getWidth(); i++){
			for(int j = 0; j < _model.getHeight(); j++){
				//as before, use try and catch to avoid array index out of bounds exception
				try{
					//if the value of the model array is true, then draw a corresponding ellipse
					if(_model.isCellAlive(i, j)==true){
						_ellipseArray[i][j] = new ColorEllipse();
						_ellipseArray[i][j].setFrame(0.5*GRIDSIZE+GRIDSIZE*i-0.5*ELLIPSE_SIZE,
								0.5*GRIDSIZE+GRIDSIZE*j-0.5*ELLIPSE_SIZE, ELLIPSE_SIZE, ELLIPSE_SIZE);
						_ellipseArray[i][j].setColor(ELLIPSE_COLOR);
					}
					//else, if it is false, then make the ellipse array to be null
					else{
						_ellipseArray[i][j] = null;
					}
				}
				catch(java.lang.ArrayIndexOutOfBoundsException e){}
			}
		}
	}
	
	//paint component method, to draw everything in this panel.
	public void paintComponent(java.awt.Graphics aBrush){
		super.paintComponent(aBrush);
		
		for(int i = 0; i < _model.getWidth(); i++){
			for(int j = 0; j < _model.getHeight(); j++){
				_grid[i][j].draw((java.awt.Graphics2D)aBrush);
				//use try and catch to avoid null pointer exception
				try{_ellipseArray[i][j].fill((java.awt.Graphics2D)aBrush);}
				catch(java.lang.NullPointerException e){}
			}
		}
	}
	
	//inside class MyMouseListener that will make the panel to respond the mouse action
	private class MyMouseListener extends java.awt.event.MouseAdapter{
		private MainPanel _panel;//should know about the container
		public MyMouseListener(MainPanel p){
			_panel = p;
		}
		
		//when user presses the mouse, either a new ellipse will be drawn in the panel, 
		//or an existing ellipse will be removed
		public void mousePressed(java.awt.event.MouseEvent e){
			if(_model.isCellAlive((int)Math.floor(e.getX()/GRIDSIZE), (int)Math.floor(e.getY()/GRIDSIZE))){
				_model.setCellDead((int)Math.floor(e.getX()/GRIDSIZE), (int)Math.floor(e.getY()/GRIDSIZE));
			}
			else{
				_model.setCellAlive((int)Math.floor(e.getX()/GRIDSIZE), (int)Math.floor(e.getY()/GRIDSIZE));
			}
			_panel.ModelToPanel();
			_panel.repaint();
		}
	}
	
}
