import java.util.ArrayList;

public class House {
	private ArrayList<Animal> p;

	public House() {
		p = new ArrayList<Animal>();
	}
	public void printAnimals()
	{
		cleanHouse();
		for (int i = 0 ; i < p.size(); i++)
		{
			System.out.println(p.toString());

		}
	}
	public void add(Animal e)
	{
		p.add(e);
	}
	
	
	private void cleanHouse()
	{
		for (Animal a : p)
		{
			ArrayList<Toy> toys = a.getToys();
			for (int i = 0; i < toys.size(); i++)
			{
				int firstIndex = toys.indexOf(toys.get(i));
				int lastIndex = toys.indexOf(toys.get(i));
				if(firstIndex!=lastIndex)
				{
					toys.remove(firstIndex);	
				}
			}
		}
	}
}
