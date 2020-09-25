import java.util.ArrayList;

public class House {
	private ArrayList<Animal> animals;
	public House()
	{
		animals = new ArrayList<Animal>();
	}
	public void printAnimals()
	{
		cleanHouse();
		for (int x= 0 ; x < animals.size(); x++)
		{
		System.out.println(animals.get(x));
		}
	}
	public void add(Animal e)
	{
		animals.add(e);
	}
	private void cleanHouse()
	{
		for (Animal a:animals)
		{
			
			ArrayList<Toy> toys = a.getToys();
			for(int i = 0; i < toys.size() ; i++)
			{
				int firstIndex = toys.indexOf(toys.get(i));
				int lastindex =  toys.lastIndexOf(toys.get(i));
				if (firstIndex != lastindex)
				{
					toys.remove(lastindex);
				}
			}
		}
		
	}
}
