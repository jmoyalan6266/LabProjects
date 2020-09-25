import java.util.Random;

public abstract class Animal implements Actor {
	public int age;
	public boolean alive;
	public Field field;
	public Location location; // stores a reference to this Rabbit's current
								// location

	public int getAge() {
		return age;
	}

	public boolean isActive() {
		return alive;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Create a new rabbit. A rabbit is created with age zero (a new born).
	 */
	public Animal(Field field, Location location) {
		this.field = field;
		this.location = location;
		alive = true;
		age = 0;
	}

	/**
	 * This is what the rabbit does most of the time - it runs around. Sometimes
	 * it will breed or die of old age.
	 */

	/** Method called when a Rabbit becomes deceased */
	public void remove() {
		alive = false;
		field.remove(location);
	}

	/**
	 * Increase the Rabbit's age. This could result in the rabbit's death.
	 */
	public abstract void incrementAge();

	/**
	 * Generate a number representing the number of births, if it can breed.
	 * 
	 * @return The number of births (may be zero).
	 */
	public abstract int breed();

	/**
	 * A rabbit can breed if it has reached breeding age.
	 * 
	 * @return true if the rabbit can breed, false otherwise.
	 */
	public abstract boolean canBreed();

	@Override
	public abstract String toString();
}
