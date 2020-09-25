
public abstract class Automobile implements Vehicle{
	private double MSRP;
	private String type;
	private int year;
	public Automobile(String t, int y, double m )
	{
		MSRP = m;
		type = t;
		year = y;
	}
	@Override
	public String getInfo()
	{
		return year + " "+type;
	}
	
	public double getMSRP()
	{
		return MSRP;
	}
	public String getType()
	{
		return type;
	}
	public int getYear()
	{
		return year;
	}
}
