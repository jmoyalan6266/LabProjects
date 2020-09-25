import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field {
	private int depth, width;
	private Actor[][] field;

	/**
	 * Represent a field of the given dimensions.
	 * 
	 * @param depth
	 *            The depth of the field.
	 * @param width
	 *            The width of the field.
	 */
	public Field(int depth, int width) {
		this.depth = depth;
		this.width = width;
		field = new Actor[depth][width];
	}

	/** Empty the field */
	public void clear() {
		for (int r = 0; r < depth; r++) {
			for (int c = 0; c < width; c++) {
				field[r][c] = null;
			}
		}
	}

	/**
	 * Place an animal at the given location. If there is already an animal at
	 * the location it will be lost.
	 * 
	 * @param animal
	 *            The animal to be placed.
	 * @param row
	 *            Row coordinate of the location.
	 * @param col
	 *            Column coordinate of the location.
	 */
	public void place(Actor actor, int row, int col) {
		field[row][col] = actor;
	}

	/**
	 * Place an animal at the given location. If there is already an animal at
	 * the location it will be lost.
	 * 
	 * @param animal
	 *            The animal to be placed.
	 * @param location
	 *            Where to place the animal.
	 */
	public void place(Actor actor, Location location) {
		int row = location.getRow();
		int col = location.getCol();
		place(actor, row, col);
	}

	/**
	 * Move an Object from one location in the field to another
	 * 
	 * @param oldLocation
	 *            Object's old location
	 * @param newLocation
	 *            Object's new location
	 */
	public void move(Location oldLocation, Location newLocation) {
		Actor actor = getObjectAt(oldLocation);
		remove(oldLocation);
		place(actor, newLocation);
	}

	/**
	 * Remove an Object from a particular location
	 * 
	 * @param location
	 */
	public void remove(Location location) {
		int row = location.getRow();
		int col = location.getCol();
		field[row][col] = null;
	}

	/**
	 * Return the animal at the given location, if any.
	 * 
	 * @param location
	 *            Where in the field.
	 * @return The animal at the given location, or null if there is none.
	 */
	public Actor getObjectAt(Location location) {
		int row = location.getRow();
		int col = location.getCol();
		return getObjectAt(row, col);
	}

	/**
	 * Return the animal at the given location, if any.
	 * 
	 * @param row
	 *            The desired row.
	 * @param col
	 *            The desired column.
	 * @return The animal at the given location, or null if there is none.
	 */
	public Actor getObjectAt(int row, int col) {
		return field[row][col];
	}

	/**
	 * Generate a shuffled List of locations adjacent to the given one - will
	 * not include the location itself. All locations will lie within the grid.
	 * 
	 * @param location
	 *            The location from which to generate adjacencies.
	 * @return A randomized list of locations adjacent to that given.
	 */
	public List<Location> adjacentLocations(Location location) {
		List<Location> t = new ArrayList<>();
		int row = location.getRow();
		int col = location.getCol();
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
				if (r < 0 || r > depth - 1 || c < 0 || c > width - 1) {
					continue;
				}
				if (r == row && c == col) {
					continue;
				} else {
					Location p = new Location(r, c);
					t.add(p);
				}
			}
		}
		Collections.shuffle(t);
		return t;
	}

	/**
	 * Try to find a free location that is adjacent to the given location. If
	 * there is none, return null. The returned location will be within the
	 * valid bounds of the field.
	 * 
	 * @param location
	 *            The location from which to generate an adjacency.
	 * @return A valid free location within the grid area, or null if all
	 *         locations around are full.
	 */
	public Location freeAdjacentLocation(Location location) {
		List<Location> l = adjacentLocations(location);
		for (int i = 0 ; i < l.size(); i++)
		{
			if(getObjectAt(l.get(i)) == null)
			{
				return l.get(i);
			}
		}
		return null;
	}

	@Override
	public String toString() // quick picture of the state of the field, for
								// debugging
	{
		String result = "";

		for (int r = 0; r < this.depth; r++) {
			for (int c = 0; c < this.width; c++) {
				Actor actor = this.field[r][c];

				if (actor instanceof Rabbit)
					result += "R\t";
				else if (actor instanceof Fox)
					result += "F\t";
				else
					result += "x\t";
			}
			result += "\n";
		}

		return result;
	}

	public int getDepth() {
		return this.depth;
	}

	public int getWidth() {
		return this.width;
	}
}
