import java.awt.Color;

public class TallHat implements MoveDispatcher
{
    private Mover _brim, _band1, _band2, _band3, _band4;
    
    public TallHat (Color mainColor, Color alternateColor)
    {        
    	_brim = new HatPart (this, mainColor, 100, 15, 200, 160);
        _band1 = new HatPart (this, alternateColor, 60, 25, 220, 135);
        _band2 = new HatPart (this, mainColor, 60, 25, 220, 110);
        _band3 = new HatPart (this, alternateColor, 60, 25, 220, 85);
        _band4 = new HatPart (this, mainColor, 60, 25, 220, 60);
    }
    
    //ask the different parts to move together
    public void requestMove(int x, int y){
    	_brim.move(x, y);
    	_band1.move(x,y);
    	_band2.move(x, y);
    	_band3.move(x, y);
    	_band4.move(x, y);
    }
}
