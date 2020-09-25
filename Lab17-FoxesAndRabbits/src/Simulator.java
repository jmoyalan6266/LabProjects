
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

/**
 * A simple predator-prey simulator, based on a field containing rabbits and
 * foxes.
 */
public class Simulator {
	/* Constants representing configuration information for the simulation. */

	private static final int DEFAULT_WIDTH = 50; // size of field by default
	private static final int DEFAULT_DEPTH = 50;
	private static final double FOX_CREATION_PROBABILITY = 0.02;
	private static final double RABBIT_CREATION_PROBABILITY = 0.08;

	/* Instance variables */

	private Field field;
	private int step;

	private SimulatorView view; // graphical view of the Simulator, don't mess
								// with this

	/**
	 * Construct a simulation field with default size.
	 */
	public Simulator() {
		this(Simulator.DEFAULT_DEPTH, Simulator.DEFAULT_WIDTH);
	}

	/**
	 * Create a simulation field with the given size.
	 * 
	 * @param depth
	 *            Depth of the field. Must be greater than zero.
	 * @param width
	 *            Width of the field. Must be greater than zero.
	 */
	public Simulator(int depth, int width) {
		field = new Field(depth, width);
		step = 0;
		// Create a view of the state of each location in the field, don't mess
		// with this
		view = new SimulatorView(depth, width);
		view.setColor(Rabbit.class, Color.orange);
		view.setColor(Fox.class, Color.blue);

		// Setup a valid starting point, don't mess with this
		reset();
	}

	/**
	 * Run the simulation from its current state for a reasonably long period,
	 * e.g. 500 steps.
	 */
	public void runLongSimulation() {
		simulate(500);
	}

	/**
	 * Run the simulation from its current state for the given number of steps.
	 * Stop before the given number of steps if it ceases to be viable.
	 * 
	 * @param numSteps
	 *            The number of steps to run for.
	 */
	public void simulate(int numSteps) {
		for (int step = 1; step <= numSteps && view.isViable(field); step++) {
			simulateOneStep();
		}
	}

	/**
	 * Run the simulation from its current state for a single step. Iterate over
	 * the whole field updating the state of each fox and rabbit.
	 */
	public void simulateOneStep() {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
		} // Slow it down a bit, don't remove
		step++;
		for (int r = 0; r < field.getDepth(); r++) {
			for (int c = 0; c < field.getWidth(); c++) {
				Actor actor = field.getObjectAt(r, c);
				if (actor != null) {
					actor.act();
				}
			}

			view.showStatus(step, field); // Display the new field on screen,
											// don't
											// remove
		}
	}

	/**
	 * Reset the simulation to a starting position.
	 */
	public void reset() {
		step = 0;

		field.clear();

		this.populate();

		// Show the starting state in the view
		view.showStatus(step, field);
	}

	/**
	 * Populate a field with foxes and rabbits.
	 */
	private void populate() {
		Random rand = new Random();
		field.clear();
		for (int r = 0; r < field.getDepth(); r++) {
			for (int c = 0; c < field.getWidth(); c++) {
				double prob = rand.nextDouble();
				Location loc = new Location(r, c);
				if (prob <= FOX_CREATION_PROBABILITY) {
					Fox f = new Fox(field, loc);
					field.place(f, loc);
				} else if (prob <= RABBIT_CREATION_PROBABILITY) {
					Rabbit rab = new Rabbit(field, loc);
					field.place(rab, loc);
				} else {
					continue;
				}
			}
		}
	}
}
