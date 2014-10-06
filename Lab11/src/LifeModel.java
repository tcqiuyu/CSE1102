public class LifeModel implements GameModel {

	private boolean[][] _presentArray;
	private boolean[][] _futureArray;
	private int _height;
	private int _width;
	
	public LifeModel(int height, int width) {
		// TODO write the constructor
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
	public boolean isCellAlive(int i, int j) {
		if (_presentArray[i+1][j+1] == true){
			return true;
		}
		return false;
	}

	@Override
	public void setCellAlive(int i, int j) {
		_presentArray[i+1][j+1] = true;
			
	}

	@Override
	public void setCellDead(int i, int j) {
		_presentArray[i+1][j+1] = false;
	}

	@Override
	public void updateGame() {
		_futureArray = new boolean[_height+2][_width+2];
		for (int i = 1; i <= this.getHeight(); i++){
			for (int j = 1; j <= this.getWidth(); j++){
				int neighbourAlive = 0;
				
				for (int m = i-1; m <= i+1; m++){
					for (int n = j-1; n <= j+1; n++){
						if (_presentArray[m][n]){
							neighbourAlive++;
							}
						}
					}
				if (_presentArray[i][j]){
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
				
				//rule 4
				else if(!_presentArray[i][j] && (neighbourAlive == 3)){
					_futureArray[i][j] = true;
				}
			}
		}//now all cells have been checked
		//update array
		_presentArray = _futureArray;
		
	}

	public void setCellAlive2(int i, int j){
		_futureArray[i+1][j+1] = true;
	}
	
	public void setCellDead2(int i, int j){
		_futureArray[i+1][j+1] = false;
	}
	
	public boolean isCellAlive2(int i, int j){
		if (_futureArray[i+1][j+1] == true){
			return true;
		}
		return false;
	}
	
}
