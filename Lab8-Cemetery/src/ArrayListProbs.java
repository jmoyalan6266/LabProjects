import java.util.*;

public class ArrayListProbs {
	public ArrayListProbs() {

	}

	public void makeListAndPrint(int num, int limit) {
		ArrayList<Integer> p = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Integer t = new Integer((int) (Math.random() * (limit) + 1));
			p.add(t);
		}
		System.out.println(p);
	}
	
	public ArrayList<Integer> minToFront(ArrayList<Integer> list)
	{
		int min =1100000;
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) < min)
			{
				min = list.get(i);
			}
		}
		list.add(0 , min);
		return list;
	}
	public ArrayList<Integer> addOne(ArrayList<Integer> list)
	{
		for (int i = 0; i < list.size(); i++)
		{
			list.set(i, list.get(i) + 1);
		}
		return list;
	}
	public ArrayList<String> removeDupes(ArrayList<String> list)
	{
		for (int i = 0; i < list.size()-1; i++)
		{
			if (list.get(i).equals(list.get(i + 1)))
			{
				list.remove(i);
			}
		}
		return list;
	}
	public ArrayList<Integer> swapPairs(ArrayList<Integer> list)
	{
		int temp = 0;
		for (int i = 0; i < list.size() - 1; i+=2)
		{
			temp = list.get(i);
			list.set(i , list.get(i + 1));
			list.set(i + 1 , temp);
		}
		
		return list;
	}
	public ArrayList<String> removeLenN(ArrayList<String> list, int n)
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).length() == n)
			{
				list.remove(i);
			}
		}
		return list;
	}
	public int dumbestPerson(ArrayList<Person> list)
	{	
		int	index =  0;
		for (int i = 0; i < list.size() ; i++)
		{
			if ( list.get(i).getIQ() < list.get(index).getIQ() )
			{
				index = i;
			}
		}
		return index;
	}
	public Book highestPricedBook(ArrayList<Book> list)
	{
		int index= 0;
		for (int i = 0 ; i < list.size() ; i++)
		{
			if  (list.get(i).getPrice() > list.get(index).getPrice())
			{
				index = i;
			}
		}
		return list.get(index);
	}
	public ArrayList<Book> banBook (ArrayList<Book> list, Book book)
	{
		for (int i = 0 ; i < list.size() ; i++)
		{
			if  (list.get(i).getTitle().equals(book.getTitle()) )
			{
				list.remove(list.get(i));
			}
		}
		return list; 
	}
	 public double bookstoreValue(Bookstore store)
	 {
		 double price = 0;
		 for (int i = 0 ; i < store.numBooks() ; i ++)
		 {
			 price += store.getBook(i).getPrice();
		 }
		 return price; 
	 }
	

	

}
