
public class Car extends Vehicle{
	private double mpg;
	public Car(String t, int y, double p, double m) {
		super(t,y,p);
		mpg = m;
	}

	public boolean greatGasMileage() {
		if (mpg >= 36) {
			return true;
		}
		return false;
	}
	public String getInfo()
	{
		return getYear()+" "+getType()+", " + mpg +" mpg"+", $"+getPrice();
	}
}
