
public class Toy {
	private String name;
	public Toy(String n)
	{
		name = n ;
	}
	@Override 
	public String toString()
	{
		return "A "+this.name;
	}
	@Override
	public boolean equals(Object obj)
	{
		Toy b = (Toy) obj;
		if (this.name.equals(b.getName()))
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
