
public class Dog extends Animal {
	private boolean goodBoy;

	public Dog(String name, int birthYear, boolean b) {
		super(name, birthYear);
		goodBoy = b;
	}

	public String toString() {
		if (goodBoy) {
			return super.toString() + "I am a good boy.\n";
		} else {
			return super.toString() + "I am not a good boy.\n";
		}
	}
}
