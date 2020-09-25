
public class Book {
	private String title; 
	private String author; 
	private double price;
	public Book(String t , String s, double g)
	{
		title = t;
		author = s ;
		price = g ;
	}
	public String getTitle()
	{
		return title;
	}
	public String getAuthor()
	{
		return author;
	}
	public double getPrice()
	{
		return price;
	}
	public String toString()
	{
		String s = title + ", by "+author+". Cost: $"+price ;
		return s; 
	}
	
	
	}
	


