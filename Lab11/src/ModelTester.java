
public class ModelTester {
	private LifeModel _testTarget;
	private static int DEFAULT_HEIGHT = 20;
	private static int DEFAULT_WIDTH = 20;
	private int _rows;
	private int _cols;

	public ModelTester(int rows, int cols){
		_rows = rows;
		_cols = cols;
		_testTarget = new LifeModel(rows, cols);
	}
	
	public boolean allTestsPassed() {
		// TODO write the test code
		//first test=set 9 cells,then update, then read the middle cell
		
		if (!TestCenterR1(10,10)){
			return false;
		}
		else 
			if (!TestCenterR2(10,10)){
			return false;
		}
		else if (!TestCenterR3(10,10)){
			return false;
		}
		else if (!TestCenterR4(10,10)){			
			return false;
		}
		//test for corner
		else if (!TestCornerR1(_rows-1,_cols-1)){			
			return false;
		}
		else if (!TestCornerR2(_rows-1,_cols-1)){
			return false;
		}
		else if (!TestCornerR4(_rows-1,_cols-1)){
			return false;
		}
		//test for edge
		else if (!TestEdgeR1(0, 10)){
			return false;
		}
		else if (!TestEdgeR2(0, 10)){
			return false;
		}
		else if (!TestEdgeR3(0,10)){
			return false;
		}
		else if (!TestEdgeR4(0,10)){
			return false;
		}
		return true;
			
	}
	
	public boolean TestCenterR1(int x, int y){
		_testTarget.setCellAlive(x-1, y-1);
		_testTarget.setCellDead(x, y-1);
		_testTarget.setCellDead(x+1, y-1);
		_testTarget.setCellDead(x-1, y);
		_testTarget.setCellAlive(x, y);
		_testTarget.setCellDead(x+1, y);
		_testTarget.setCellDead(x-1, y+1);
		_testTarget.setCellDead(x, y+1);
		_testTarget.setCellDead(x+1, y+1);
		
		_testTarget.updateGame();
		if (!_testTarget.isCellAlive2(x, y)){
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 1 passed." + "\n");
			return true;
		}
		else{
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 1 failed." + "\n");
			return false;
		}
	}
	
	public boolean TestCenterR2(int x, int y){
		_testTarget.setCellAlive(x-1, y-1);
		_testTarget.setCellAlive(x, y-1);
		_testTarget.setCellDead(x+1, y-1);
		_testTarget.setCellDead(x-1, y);
		_testTarget.setCellAlive(x, y);
		_testTarget.setCellDead(x+1, y);
		_testTarget.setCellDead(x-1, y+1);
		_testTarget.setCellDead(x, y+1);
		_testTarget.setCellDead(x+1, y+1);
		
		_testTarget.updateGame();
		if (_testTarget.isCellAlive2(x, y)){
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 2 passed." + "\n");
			return true;
		}
		else {
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 2 failed." + "\n");
			return false;
		}	
	}
	
	public boolean TestCenterR3(int x, int y){		
		_testTarget.setCellAlive(x-1, y-1);
		_testTarget.setCellAlive(x, y-1);
		_testTarget.setCellAlive(x+1, y-1);
		_testTarget.setCellAlive(x-1, y);
		_testTarget.setCellAlive(x, y);
		_testTarget.setCellDead(x+1, y);
		_testTarget.setCellDead(x-1, y+1);
		_testTarget.setCellDead(x, y+1);
		_testTarget.setCellDead(x+1, y+1);
		
		_testTarget.updateGame();
		if (!_testTarget.isCellAlive2(x, y)){
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 3 passed." + "\n");
			return true;
		}
		else {
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 3 failed." + "\n");
			return false;
		}	
	}
	
	public boolean TestCenterR4(int x, int y){
		_testTarget.setCellAlive(x-1, y-1);
		_testTarget.setCellAlive(x, y-1);
		_testTarget.setCellAlive(x+1, y-1);
		_testTarget.setCellDead(x-1, y);
		_testTarget.setCellDead(x, y);
		_testTarget.setCellDead(x+1, y);
		_testTarget.setCellDead(x-1, y+1);
		_testTarget.setCellDead(x, y+1);
		_testTarget.setCellDead(x+1, y+1);
		
		_testTarget.updateGame();
		if (_testTarget.isCellAlive2(x, y)){
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 4 passed." + "\n");
			return true;
		}
		else {
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 4 failed." + "\n");
			return false;
		}
	}
	
	public boolean TestCornerR1(int x, int y){
		_testTarget.setCellAlive(x, y);
		_testTarget.setCellDead(x-1, y);
		_testTarget.setCellDead(x-1, y-1);
		_testTarget.setCellDead(x, y-1);	
		
		_testTarget.updateGame();
		if (!_testTarget.isCellAlive2(x, y)){
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 1 passed." + "\n");
			return true;
		}
		else {
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 1 failed." + "\n");
			return false;
		}
	}
	
	public boolean TestCornerR2(int x, int y){
		_testTarget.setCellAlive(x, y);
		_testTarget.setCellAlive(x-1, y);
		_testTarget.setCellAlive(x-1, y-1);
		_testTarget.setCellDead(x, y-1);	
		
		_testTarget.updateGame();
		if (_testTarget.isCellAlive2(x, y)){
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 2 passed." + "\n");
			return true;
		}
		else {
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 2 failed." + "\n");
			return false;
		}
	}
	
	public boolean TestCornerR4(int x, int y){
		_testTarget.setCellDead(x, y);
		_testTarget.setCellAlive(x-1, y-1);
		_testTarget.setCellAlive(x-1, y);
		_testTarget.setCellAlive(x, y-1);
		
		_testTarget.updateGame();
		if (_testTarget.isCellAlive2(x, y)){
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 4 passed." + "\n");
			return true;
		}
		else {
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 4 failed." + "\n");
			return false;
		}
	}
	
	public boolean TestEdgeR1(int x, int y){
		_testTarget.setCellAlive(x, y-1);
		_testTarget.setCellDead(x+1, y-1);
		_testTarget.setCellAlive(x, y);
		_testTarget.setCellDead(x+1, y);
		_testTarget.setCellDead(x, y+1);
		_testTarget.setCellDead(x+1, y+1);
		
		_testTarget.updateGame();
		if (!_testTarget.isCellAlive2(x, y)){
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 1 passed." + "\n");
			return true;
		}
		else {
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 1 failed." + "\n");
			return false;
		}
	}
	
	public boolean TestEdgeR2(int x, int y){
		_testTarget.setCellAlive(x, y-1);
		_testTarget.setCellAlive(x+1, y-1);
		_testTarget.setCellAlive(x, y);
		_testTarget.setCellAlive(x+1, y);
		_testTarget.setCellDead(x, y+1);
		_testTarget.setCellDead(x+1, y+1);		
		
		_testTarget.updateGame();
		if (_testTarget.isCellAlive2(x, y)){
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 2 passed." + "\n");
			return true;
		}
		else {
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 2 failed." + "\n");
			return false;
		}
	}
	
	public boolean TestEdgeR3(int x, int y){
		_testTarget.setCellAlive(x, y-1);
		_testTarget.setCellAlive(x+1, y-1);
		_testTarget.setCellAlive(x, y);
		_testTarget.setCellAlive(x+1, y);
		_testTarget.setCellAlive(x, y+1);
		_testTarget.setCellDead(x+1, y+1);		

		_testTarget.updateGame();
		if (!_testTarget.isCellAlive2(x, y)){
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 3 passed." + "\n");
			return true;
		}
		else {
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 3 failed." + "\n");
			return false;
		}
	}
	
	public boolean TestEdgeR4(int x, int y){
		_testTarget.setCellAlive(x, y-1);
		_testTarget.setCellAlive(x+1, y-1);
		_testTarget.setCellDead(x, y);
		_testTarget.setCellAlive(x+1, y);
		_testTarget.setCellDead(x, y+1);
		_testTarget.setCellDead(x+1, y+1);		
		
		_testTarget.updateGame();
		if (_testTarget.isCellAlive2(x, y)){
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 4 passed." + "\n");
			return true;
		}
		else {
			System.out.print("Test for Cell(" + x + "," + y + "): Rule 4 failed." + "\n");
			return false;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ModelTester tester = new ModelTester(DEFAULT_HEIGHT,DEFAULT_WIDTH);
		if (tester.allTestsPassed())
			System.out.println("All tests passed");
		else
			System.out.println("Not all tests passed");
	}
}

