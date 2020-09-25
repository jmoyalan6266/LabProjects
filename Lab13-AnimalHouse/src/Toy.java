
public class Toy {
	private String name;
	public Toy(String name)
	{
		this.name = name; 
	}
	public String toString()
	{
		return "A "+name;
	}
	@Override
	public boolean equals(Object e)
	{
		if (this.toString().equals(e.toString()))
		{
			return true;
		}
		return false;
	}
	public String getName()
	{
		return name;
	}
}
