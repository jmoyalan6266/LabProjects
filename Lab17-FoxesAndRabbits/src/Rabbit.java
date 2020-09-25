
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rabbit extends Animal{
	/* Characteristics shared by all rabbits (static fields). */

	private static final int BREEDING_AGE = 5;
	private static final int MAX_AGE = 15;
	private static final double BREEDING_PROBABILITY = 0.25;
	private static final int MAX_LITTER_SIZE = 6;

	/**
	 * Create a new rabbit. A rabbit is created with age zero (a new born).
	 */
	public Rabbit(Field field, Location location) {
		super(field, location);
	}


	/**
	 * This is what the rabbit does most of the time - it runs around. Sometimes
	 * it will breed or die of old age.
	 */
	public void act() {
		incrementAge();
		if (!isActive()) {
			return;
		}
		int babies = breed();
		
		for (int i = 0; i < babies; i++) {
			Location loc = field.freeAdjacentLocation(location);
			if (loc != null) {
				Rabbit r = new Rabbit(field, loc);
				field.place(r, loc);
			}
		}
		Location loc = field.freeAdjacentLocation(location);
		if (loc != null) {
			field.move(location, loc);
			setLocation(loc);
		} else {
			remove();
		}
	}

	/** Method called when a Rabbit becomes deceased */

	/**
	 * Increase the Rabbit's age. This could result in the rabbit's death.
	 */
	public void incrementAge() {
		age++;
		if (age >= MAX_AGE) {
			remove();
		}
	}

	/**
	 * Generate a number representing the number of births, if it can breed.
	 * 
	 * @return The number of births (may be zero).
	 */

	public int breed() {
		int babies = 0;
		Random rand = new Random();
		for (int i = 0; i < Rabbit.MAX_LITTER_SIZE; i++) {
			double prob = rand.nextDouble();
			if (canBreed() && prob < Rabbit.BREEDING_PROBABILITY) {
				babies++;
			}
		}
		return babies; // replace
	}

	/**
	 * A rabbit can breed if it has reached breeding age.
	 * 
	 * @return true if the rabbit can breed, false otherwise.
	 */

	public boolean canBreed() {
		if (age >= Rabbit.BREEDING_AGE) {
			return true;
		} else {
			return false;
		}
	}


	@Override
	public String toString() {
		return "Rabbit, " + age + " y/o, at " + location;
	}
}
