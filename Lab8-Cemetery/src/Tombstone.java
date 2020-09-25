
public class Tombstone {
	private  String name ;
	private String burialDate;
	private int age;
	private String address;
	public Tombstone(String n , String b, int a, String k)
	{
		name = n;
		burialDate = b;
		age = a;
		address = k ;
	}
	public String getName()
	{
		return name;
	}
	public String getBurialDate()
	{
		return burialDate;
	}
	public int getAge()
	{
		return age;
	}
	public String address()
	{
		return address;
	}
	
}
