
public class Cat extends Animal{
	private int numYears;

	public Cat(String n, int b, int y) {
		super(n, b);
		numYears = y;
	}
	public Cat(String n, int b) {
		this(n, b, 9);
	}
	public String toString() {
			return super.toString() + "I have "+numYears+" lives.\n";
		}
	}

