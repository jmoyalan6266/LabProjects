
public class Dog extends Animal {
	private boolean goodBoy;

	public Dog(String n, int b, boolean gb) {
		super(n, b);
		goodBoy = gb;
	}

	@Override
	public String toString() {
		if (goodBoy) {
			return super.toString() + "I am a good boy.\n";
		} else {
			return super.toString() + "I am not a good boy.\n";
		}
	}
}
