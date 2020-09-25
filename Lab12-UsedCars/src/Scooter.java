
public class Scooter extends Vehicle {
	private double size;
	public Scooter(String t, int y, double p, double s) {
		super(t,y,p);
		size = s;
	}

	public boolean greatGasMileage() {
		if (size >= 36) {
			return true;
		}
		return false;
	}
	public String getInfo()
	{
		return getYear()+" "+getType()+", " + size +" lbs."+", $"+getPrice();
	}

}
