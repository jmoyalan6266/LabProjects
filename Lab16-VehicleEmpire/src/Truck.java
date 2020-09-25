

public class Truck extends Automobile implements Vehicle {
	private int towing;

	public Truck(String t, int y, double m, int to) {
		super(t, y, m);
		towing = to;
	}

	@Override
	public String getInfo() {
		return super.getInfo() + ", " + towing + " lbs. towing, $" + this.getPrice();
	}

	@Override
	public double getPrice() {
		if (towing >= 5000) {
			return .85 * getMSRP();
		} else {
			return getMSRP();
		}
	}
}
