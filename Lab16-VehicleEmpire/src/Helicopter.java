
public class Helicopter extends Aircraft implements Vehicle, Leasable {
	private boolean canShootMissles;
	public Helicopter( String t,int y, double c, int p, boolean cS) {
		super(t, y, c, p);
		canShootMissles= cS;
	}
	@Override 
	public double getPrice()
	{
		if (canShootMissles)
		{
			return 1.25 * getCost();
		}
		else
		{
			return getCost();
		}
	}

	@Override
	public String getInfo() {
		String s = super.getInfo() + ", $"+this.getPrice()+"\n";
		if (canShootMissles)
		{
			return s + "Shoots Missles";
		}
		else
		{
			return s + "Does not Shoot Missles";
		}
	}
	@Override
	public double getMonthlyPayment()
	{
		return getPrice()/60;
	}
}