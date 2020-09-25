import java.awt.*;
import java.util.*;

public class SandLab {
	// add constants for particle types here
	public static final int EMPTY = 0;
	public static final int METAL = 1;
	public static final int SAND = 2;
	public static final int WATER = 3;

	// do not add any more fields!
	private int[][] grid;
	private SandDisplay display; // SandDisplay is the GUI class

	public SandLab(int numRows, int numCols) {
		String[] names = new String[4];

		names[EMPTY] = "Empty";
		names[METAL] = "Metal";
		names[SAND] = "Sand";
		names[WATER] = "Water";

		display = new SandDisplay("Falling Sand", numRows, numCols, names);
		grid = new int[numRows][numCols];
	}

	/** called when the user clicks on a location using the given tool */
	private void locationClicked(int row, int col, int tool) {
		grid[row][col] = tool;
	}

	/** copies each element of grid into the display */
	public void updateDisplay() {
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c] == METAL) {
					display.setColor(r, c, Color.GRAY);
				} else if (grid[r][c] == SAND) {
					display.setColor(r, c, Color.YELLOW);
				} else if (grid[r][c] == WATER) {
					display.setColor(r, c, Color.BLUE);
				} else {
					display.setColor(r, c, Color.BLACK);
				}
			}
		}
	}

	/** called repeatedly, causes one random particle to maybe do something */
	public void step() {
		int r = (int) (Math.random() * grid.length) + 0;
		int c = (int) (Math.random() * grid[0].length) + 0;
		System.out.println(r + " " + c);
		if ((grid[r][c] == SAND || grid[r][c] == WATER) && grid[r + 1][c] == EMPTY && r + 1 < grid.length - 1) {
			int temp = grid[r][c];
			grid[r][c] = grid[r + 1][c];
			grid[r + 1][c] = temp;
		}
		int rand = (int) (Math.random() * 2) + 0;
		if (grid[r][c] == WATER && grid[r + 1][c] == EMPTY && r + 1 < grid.length - 1 && c <= grid[0].length - 2
				&& c >= 1) {
			if (rand == 1) {
				int temp = grid[r][c];
				grid[r][c] = grid[r][c - 1];
				grid[r][c - 1] = temp;
			} else {
				int temp = grid[r][c];
				grid[r][c] = grid[r][c + 1];
				grid[r][c + 1] = temp;
			}
		}
		if (grid[r][c] == WATER && (grid[r + 1][c] == WATER || grid[r + 1][c] == SAND) && c <= grid[0].length - 2 && c >= 1) {
			rand = (int) (Math.random() * 2) + 0;
			if (rand == 1 & grid[r][c + 1] == EMPTY) {
				int temp = grid[r][c];
				grid[r][c] = grid[r][c + 1];
				grid[r][c + 1] = temp;
			} else if (grid[r][c - 1] == EMPTY) {
				int temp = grid[r][c];
				grid[r][c] = grid[r][c - 1];
				grid[r][c - 1] = temp;
			}
		}
		if (grid[r][c] == SAND && grid[r + 1][c] == WATER) {
			while (grid[r + 1][c] == WATER) {
				int temp = grid[r][c];
				grid[r][c] = grid[r + 1][c];
				grid[r + 1][c] = temp;
			}
		}
	}

	// do not modify!
	public void run() {
		while (true) {
			for (int i = 0; i < display.getSpeed(); i++)
				step();

			updateDisplay();

			display.repaint();

			display.pause(1); // wait for redrawing and for mouse

			int[] mouseLoc = display.getMouseLocation();

			if (mouseLoc != null) // test if mouse clicked
				locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
		}
	}
}
