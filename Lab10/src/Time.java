
/**
 * Objects of the Time class hold a time value for a
 * European-style 24 hour clock.
 * The value consists of hours, minutes and seconds.
 * The range of the value is 00:00:00 (midnight) to 23:59:59 (one
 * second before midnight).
 *
 * @version 1.1
 */
public class Time
{
	// The values of the three parts of the time
	private int _hours;
	private int _minutes;
	private int _seconds;
	/**
	 * Constructor for objects of class Time.
	 * Creates a new Time object set to 00:00:00.
	 * Do not change this constructor.
	 * 
	 */
	public Time()
	{
		this._hours = 0;
		this._minutes = 0;
		this._seconds = 0;
	}
	/**
	 * Constructor for objects of class Time.
	 * Creates a new Time object set to h:m:s.
	 * Assumes, without checking, that the parameter values are
	 * within bounds.
	 * For this task, you don't need to worry about invalid parameter values.
	 * Do not change this constructor.
	 */
	public Time(int h, int m, int s)
	{
		this._hours = h;
		this._minutes = m;
		this._seconds = s;
	}
	/**
	 * Add one second to the current time.
	 * When the seconds value reaches 60, it rolls over to zero.
	 * When the seconds roll over to zero, the minutes advance.
	 * So 00:00:59 rolls over to 00:01:00.
	 * When the minutes reach 60, they roll over and the hours advance.
	 * So 00:59:59 rolls over to 01:00:00.
	 * When the hours reach 24, they roll over to zero.
	 * So 23:59:59 rolls over to 00:00:00.
	 */
	public void tick()
	{
		// Task 1: complete the tick() method
		this._seconds++;
		if (this._seconds == 60){
			this._seconds = 0;
			this._minutes++;
			if(this._minutes == 60){
				this._minutes = 0;
				this._hours++;
				if(this._hours==24){
					this._hours = 0;
				}
			}
		}
	}
	/**
	 * Compare this time to otherTime.
	 * Assumes that both times are in the same day.
	 * Returns -1 if this Time is before otherTime.
	 * Returns 0 if this Time is the same as otherTime.
	 * Returns 1 if this Time is after otherTime.
	 * 
	 * 
	 * Note: since compareTo is a Time method, I can refer to the 
	 * private instance variables of otherTime as 
	 * otherTime._hours, otherTime._minutes, and otherTime._seconds
	 */
	public int compareTo(Time otherTime)
	{
		// Task 2: complete the compareTo method
		if(this._hours > otherTime._hours){
			return 1;
		}
		else if(this._hours < otherTime._hours){
			return -1;
		}
		else {
			if (this._minutes > otherTime._minutes){
				return 1;
			}
			else if(this._minutes < otherTime._minutes){
				return -1;
			}
			else{
				if (this._seconds > otherTime._seconds){
					return 1;
				}
				else if(this._seconds < otherTime._seconds){
					return -1;
				}
			}
		}
		return 0;
	}
	/**
	 * Add an offset to this Time.
	 * Rolls over the hours, minutes and seconds fields when needed.
	 */
	public void add(Time offset)
	{
		// Task 3: complete the add method
		if( this._seconds + offset._seconds >= 60 ){
			this._minutes++;
		}
		if( this._minutes + offset._minutes >= 60) {
			this._hours++;
		}
		
		this._seconds = (this._seconds + offset._seconds)%60;
		this._minutes = (this._minutes + offset._minutes)%60;
		this._hours = (this._hours + offset._hours)%24;
	}
	/**
	 * Subtract an offset from this Time.
	 * Rolls over (under?) the hours, minutes and seconds fields when needed.
	 */
	public void subtract(Time offset)
	{
		// Task 4: complete the subtract method
		if ( this._seconds - offset._seconds < 0){
			this._minutes--;
		}
		if ( this._minutes - offset._minutes < 0){
			this._hours--;
		}
		
		this._seconds = (this._seconds - offset._seconds + 60)%60;
		this._minutes = (this._minutes - offset._minutes + 60)%60;
		this._hours = (this._hours - offset._hours + 24)%24;
	}
	/**
	 * Return a string representation of this Time.
	 * String is of the form hh:mm:ss with always two digits for h, m and s.
	 * Do not change this.
	 */
	public String toString()
	{
		return pad(_hours) + ":" + pad(_minutes) + ":" + pad(_seconds);
	}
	/**
	 * Returns a string representing the argument value, adding a leading
	 * "0" if needed to make it at least two digits long.
	 * Do not change this.
	 */
	private String pad(int value)
	{
		String sign = "";
		if (value < 0) {
			sign = "-";
			value = -value;
		}
		if (value < 10) {
			return sign + "0" + value;
		} else {
			return sign + value;
		}
	}
}
