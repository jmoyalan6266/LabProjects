
public class Airplane extends Aircraft implements Vehicle {
	private boolean hasFirstClass;
	public Airplane( String t, int y, double c, int p, boolean fC) {
		super(t, y, c, p);
		hasFirstClass= fC;
	}
	@Override 
	public double getPrice()
	{
		if (hasFirstClass)
		{
			return 1.1 * getCost();
		}
		else
		{
			return getCost();
		}
	}

	@Override
	public String getInfo() {
		String s = super.getInfo() + ", $"+this.getPrice()+"\n";
		if (hasFirstClass)
		{
			return s + "Has First Class ";
		}
		else
		{
			return s + "No First Class ";
		}
	}
}
