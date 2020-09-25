import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MapDataDrawer {
	/** the 2D array containing the elevations */
	private int[][] grid;

	/** constructor, parses input from the file into grid */
	public MapDataDrawer(String fileName, int rows, int cols) throws IOException {
		grid = new int[rows][cols];
		File file = new File(fileName);
		Scanner input = new Scanner(file);
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				grid[r][c] = input.nextInt();
			}
		}
	}

	/** @return the min value in the entire grid */
	public int findMin() {
		int min = findMax();
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c] < min)
					min = grid[r][c];
			}
		}

		return min; // REPLACE
	}

	/** @return the max value in the entire grid */
	public int findMax() {
		int max = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c] > max)
					max = grid[r][c];
			}
		}

		return max; // REPLACE
	}

	/**
	 * Draws the grid using the given Graphics object. Colors should be
	 * grayscale values 0-255, scaled based on min/max values in grid
	 */
	public void drawMap(Graphics g) {
		double b = findMax();
		double a = findMin();
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				int color = (int) (((grid[r][c] - a) * 255) / (b - a));
				g.setColor(new Color(color, color, color));
				g.fillRect(c, r, 1, 1);
			}
		}
	}

	/**
	 * Find a path from West-to-East starting at given row. Choose a forward
	 * step out of 3 possible forward locations, using greedy method described
	 * in assignment.
	 * 
	 * @return the total change in elevation traveled from West-to-East
	 */
	public int drawLowestElevPath(Graphics g, int row) {
		g.fillRect(0, 0, 1, 1);
		int r = row;
		int c1 = findMax();
		int totChange = 0;

		for (int c = 0; c < grid[row].length - 1; c++) {
			if (r != 0) {
				c1 = Math.abs(grid[r][c] - grid[r - 1][c + 1]);
			}
			else {c1 = 10000000;}
			int c2 = Math.abs(grid[r][c] - grid[r][c + 1]);
			int c3 = Math.abs(grid[r][c] - grid[r + 1][c + 1]);
			if (c1 < c2 && c1 < c3) {

				totChange += Math.abs(grid[r][c] - grid[r - 1][c + 1]);
				r = r - 1;
				g.fillRect(c + 1, r, 1, 1);
			} else if (c2 < c1 && c2 < c3) {
				totChange += Math.abs(grid[r][c] - grid[r][c + 1]);
				g.fillRect(c + 1, r, 1, 1);
			} else if (c3 < c2 && c3 < c1) {
				totChange += Math.abs(grid[r][c] - grid[r + 1][c + 1]);
				r = r + 1;
				g.fillRect(c + 1, r, 1, 1);
			}
			/* else {
				totChange += Math.abs(grid[r][c] - grid[r][c + 1]);
				g.fillRect(c + 1, r, 1, 1);
			}*/
			

		}

		return totChange;
	}

	/**
	 * @return the index of the starting row for the lowest-elevation-change
	 *         path in the entire grid.
	 */
	public int indexOfLowestElevPath(Graphics g) {
		int min = 20000000;
		int rowLowChange = 0;
		for (int r = 0; r < grid.length-1; r++) {
			int lowChange = drawLowestElevPath(g, r);
			if (lowChange < min) {
				min = lowChange;
				rowLowChange = r;
			}

		}
				 
		return rowLowChange;
	}

	public void print() {
		String w = "";
		for (int r = 0; r < grid.length; r++) {
			w += (Arrays.toString(grid[r]));
		}
		System.out.println(w);
	}

}
