import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Maze {
	private int[][] maze;
	private boolean exitFound;
	int currentSteps = 0;
	int stepsFinal = 0;

	/** Make sure to look at the format of the mazes in the maze text files */
	public Maze(String fileName) throws IOException {
		Scanner in = new Scanner(new File(fileName)); // for getting next int
														// from the maze text
														// file
		int RowCol = in.nextInt();
		maze = new int[RowCol][RowCol];
		for (int r = 0; r < maze.length; r++) {
			for (int c = 0; c < maze[r].length; c++) {
				maze[r][c] = in.nextInt();
			}
		}
	}

	/**
	 * Helper method, makes the interface a little cleaner
	 * 
	 * The user doesn't have to know the solver should start at 0, 0
	 * 
	 * Also responsible for printing the final state of the maze
	 */
	public void solve() {
		this.hasExitPath(0, 0);
		System.out.println(this);
		if (exitFound) {
			System.out.println("Exit Found");
			System.out.println(stepsFinal);
		} else {
			System.out.println("Exit not Found");
		}
	}
	public void hasExitPath(int r, int c) {
		if (r < maze.length && r >= 0 && c < maze[r].length && c >= 0 && maze[r][c] == 1) {
			
			if (c == maze.length - 1) {
				exitFound = true;
				stepsFinal = currentSteps + 1;
			

			} else {
				currentSteps++;
				int original = maze[r][c];
				maze[r][c] = 2;
				hasExitPath(r + 1, c);
				hasExitPath(r - 1, c);
				hasExitPath(r, c + 1);
				hasExitPath(r, c - 1);
				maze[r][c] = original;
				currentSteps--;
			}
		}

	}

	@Override
	public String toString() {
		String output = "";
		for (int r = 0; r < maze.length; r++) {
			for (int c = 0; c < maze[r].length; c++) {

				output += maze[r][c] + " ";

				if (c == maze[r].length - 1) {
					output += "\n";
				}
			}
		}

		return output;
	}
}