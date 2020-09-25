import java.util.ArrayList;

public class Animal {
	private String name;
	private int birthYear;
	private static int currentYear;
	private Animal friend;
	private ArrayList <Toy> test;
	
	public Animal(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
		currentYear = 2017;
		friend = null;
		test = new ArrayList<Toy>();
	}

	public void setFriend(Animal p) {
		friend = p;
	}

	public int getAge() {
		return currentYear - birthYear;
	}
	public String getName() {
		return name;
	}

	public String toString() {
		String s = "Hello, I am " + name + ". I am " + getAge() + " years old.\n";
		if (friend != null) {
			s += " I have a friend named "+friend.getName()+".\n";
		}
		else
		{
			s += " I have no friends. \n";
		}
		s += " I have the following toys: ";
		s += test.toString()+"\n";
		return s;

	}
	 public void addToy(Toy e)
	 {
	 test.add(e);
	 }
	 public ArrayList <Toy> getToys()
	 {
		 return test;
	 }

}
