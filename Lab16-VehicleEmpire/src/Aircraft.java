
public abstract class Aircraft implements Vehicle{
	private double cost;
	private String type;
	private int year;
	private int passengers;
	public Aircraft( String t, int y, double c, int p)
	{
		cost = c;
		type = t;
		year = y;
		passengers = p;
	}
	@Override
	public String getInfo()
	{
		return year + " "+type+", "+passengers+" passengers";
	}
	public String getType()
	{
		return type;
	}
	public int getYear()
	{
		return year;
	}
	public double getCost()
	{
		return cost;
	}
	public int getPassengers()
	{
		return passengers;
	}
}
