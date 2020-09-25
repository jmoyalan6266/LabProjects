
public class Car extends Automobile implements Vehicle {
	private double mpg;

	public Car(String t, int y, double m, double mpg) {
		super(t, y, m);
		this.mpg = mpg;
	}

	@Override
	public String getInfo() {
		return super.getInfo() + ", " + mpg + " mpg, $" + this.getPrice();
	}

	@Override
	public double getPrice() {
		if (mpg >= 30) {
			return .9 * getMSRP();
		} else {
			return getMSRP();
		}
	}
}
