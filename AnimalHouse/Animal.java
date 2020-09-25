import java.util.ArrayList;

public class Animal {
	private String name;
	private int birthYear;
	private ArrayList<Toy> toys;
	private Animal friend;
	private static int year;
	public Animal(String n , int b)
	{
		name = n ;
		birthYear = b;
		year =2017;
		toys = new ArrayList<Toy>();
		friend = null;
	}
	public int getAge()
	{
		return year - birthYear;
	}
	public String getName()
	{
		return name;
	}
	public void addToy(Toy e)
	{
		toys.add(e);
	}
	public void setFriend(Animal p)
	{
		friend = p;
	}
	@Override
	public String toString()
	{
		String s = "";
		s += "Hello, I am "+name+", I am "+this.getAge()+" years old.\n";
		if(friend != null)
		{
			s += "I have a friend named "+friend.getName()+"\n";
		}
		else
		{
			s += " I have no friends \n";
		}
		s += "I have the following toys: "+this.toys+"\n";
		return s;
	}
	public ArrayList<Toy> getToys()
	{
		return toys;
	}
			
}
