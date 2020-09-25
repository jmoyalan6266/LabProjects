
public class Truck extends Vehicle {
	
	private int towing;
	
	public Truck(String t, int y, double p, int to) {
		super(t,y,p);
		towing = to;
	}
	
	public boolean canTwoBoat()
	{
		if (towing >= 2000)
		{
			return true;
		}
		return false;
	}
	public String getInfo()
	{
		return getYear()+" "+getType()+", "+towing+" lbs. towing"+", $"+getPrice();
	}
	
}
