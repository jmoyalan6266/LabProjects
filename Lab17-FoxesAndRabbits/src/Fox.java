
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fox extends Animal {
	/* Characteristics shared by all foxes (static fields). */

	private static final int BREEDING_AGE = 10;
	private static final int MAX_AGE = 20;
	private static final double BREEDING_PROBABILITY = 0.06;
	private static final int MAX_LITTER_SIZE = 4;
	private static final int RABBIT_FOOD_VALUE = 8;

	/* Individual characteristics (instance fields). */

	private int foodLevel;

	/**z
	 * Create a fox. A fox is created as a new born (age zero and not hungry).
	 */
	public Fox(Field field, Location location) {
		super(field, location);
		foodLevel = Fox.RABBIT_FOOD_VALUE;
	}

	/**
	 * This is what the fox does most of the time: it hunts for rabbits. In the
	 * process, it might breed, die of hunger, or die of old age.
	 */
	public void act() {
		incrementAge();
		incrementHunger();
		if (!alive) {
			return;
		}
		int babies = breed();
		for (int i = 0; i < babies; i++) {
			Location loc = field.freeAdjacentLocation(location);
			if (loc != null) {
				Fox f = new Fox(field, loc);
				field.place(f, loc);
			}
		}
		Location loc = findFood();
		Location locat = field.freeAdjacentLocation(location);
		if (loc != null) {
			field.move(location, loc);
			setLocation(loc);
		} else if (locat != null) {
			field.move(location, locat);
			setLocation(locat);
		} else {
			remove();
		}
	}

	/**
	 * Increase the age. This could result in the fox's death.
	 */
	public void incrementAge() {
		age++;
		if (age >= Fox.MAX_AGE) {
			remove();
		}
	}

	/**
	 * Make this fox more hungry. This could result in the fox's death.
	 */
	private void incrementHunger() {
		foodLevel--;
		if (foodLevel < 0) {
			remove();
		}
	}

	/** Method called with a Fox is no longer alive */


	/**
	 * Tell the fox to look for rabbits adjacent to its current location.
	 * 
	 * @return Where food was found, or null if it wasn't.
	 */
	private Location findFood() {
		List<Location> adjacentLocations = field.adjacentLocations(this.location);

		for (Location where : adjacentLocations) // look for Rabbits in adjacent
													// locations
		{
			Object animal = field.getObjectAt(where);

			if (animal instanceof Rabbit) { // if this object is a rabbit...
				Rabbit rabbit = (Rabbit) animal;

				rabbit.remove();

				this.foodLevel = Fox.RABBIT_FOOD_VALUE; // Foxes goes back to
														// full

				return where;
			}
		}
		return null;
	}

	/**
	 * Generate a number representing the number of births, if it can breed.
	 * 
	 * @return The number of births (may be zero).
	 */
	public int breed() {
		int babies = 0;
		Random rand = new Random();
		for (int i = 0; i < Fox.MAX_LITTER_SIZE; i++) {
			double prob = rand.nextDouble();
			if (canBreed() && prob < Fox.BREEDING_PROBABILITY) {
				babies++;
			}
		}
		return babies;
	}

	/**
	 * A fox can breed if it has reached breeding age.
	 */
	public boolean canBreed() {
		if (age >= BREEDING_AGE) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString()
	{
		return "Fox, " + age + " y/o, at " + location;
	}

}
