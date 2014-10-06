/*
 * LifeModel.java
 * This class defines the model of the life game.
 * We input an 2-dimension boolean array, which represents the live status of the cell
 * and the GameUpdate method will apply the game rules to this array
 * then we got a new array 
 */

public class LifeModel implements GameModel {

	private boolean[][] _presentArray;//input array
	private boolean[][] _futureArray;//array after applying the rules
	//the number of the cells
	private int _height;
	private int _width;
	
	
	public LifeModel(int height, int width) {
		//the constructor initiate two arrays, one for input and one for output
		_presentArray = new boolean[height+2][width+2];
		_futureArray = new boolean[height+2][width+2];

		_height = height;
		_width = width;
	}
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return _height;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return _width;
	}

	@Override 
	//return the live status of a given cell 
	public boolean isCellAlive(int i, int j) {
		//use try and catch to prevent the array index out of bounds exception
		try{
			
			if (_presentArray[i+1][j+1] == true){
				return true;
			}
			return false;
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e){return false;}
	}

	@Override
	//set the given cell to alive
	public void setCellAlive(int i, int j) {
		//use try and catch to prevent the array index out of bounds exception
		try{
			_presentArray[i+1][j+1] = true;
		}	
			catch(java.lang.ArrayIndexOutOfBoundsException e){}
	}

	@Override
	//set the given cell to dead
	public void setCellDead(int i, int j) {
		//use try and catch to prevent the array index out of bounds exception
		try{
			_presentArray[i+1][j+1] = false;
		}	
		catch(java.lang.ArrayIndexOutOfBoundsException e){}	
	}

	@Override
	//This method applies all 4 rules to the current array
	public void updateGame() {
		_futureArray = new boolean[_height+2][_width+2];
		
		//loop for column and row
		for (int i = 1; i <= this.getHeight(); i++){
			for (int j = 1; j <= this.getWidth(); j++){
				//for counting the number of neighbors, set a local int variable
				int neighbourAlive = 0;
				
				//counting the number of alive cells in all 9 cells around the given cell
				for (int m = i-1; m <= i+1; m++){
					for (int n = j-1; n <= j+1; n++){
						if (_presentArray[m][n]){
							neighbourAlive++;
							}
						}
					}
				
				//if the given cell is alive, then apply for rule 1~3.
				if (_presentArray[i][j]){
					//subtract the number of neighbors by 1, 
					//because the given cell is alive while it should not be counted as a neighbor  
					neighbourAlive--;
					//rule 1
					if(neighbourAlive < 2){
						_futureArray[i][j] = false;
					}
					//rule 2
					else if (neighbourAlive == 2 || (neighbourAlive == 3)){
						_futureArray[i][j] = true;
					}
					//rule 3
					else//if (neighbourAlive > 3)
						{
						_futureArray[i][j] = false;
					}
				}
				
				//if the given cell is dead, then apply rule 4
				else if(!_presentArray[i][j] && (neighbourAlive == 3)){
					_futureArray[i][j] = true;
				}
			}
		}//now all cells have been checked
		//update array
		_presentArray = _futureArray;
	}
	
}
