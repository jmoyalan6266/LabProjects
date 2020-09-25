import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze {
	Square[][] array;
	Square start, exit;

	public Maze() {

	}

	public boolean loadMaze(String fileName) {
		try {
			Scanner in = new Scanner(new File(fileName));
			int numRow = in.nextInt();
			int numCol = in.nextInt();
			array = new Square[numRow][numCol];
			for (int r = 0; r < numRow; r++) {
				for (int c = 0; c < numCol; c++) {

					Square s = new Square(r, c, in.nextInt());
					array[r][c] = s;
					if (array[r][c].getType() == Square.EXIT) {
						exit = array[r][c];
					}
					if (array[r][c].getType() == Square.START) {
						start = array[r][c];
					}
					
				}
			}
			reset();
		} catch (IOException e) {
			System.out.println("File not found, you dummy!");
			return false;
		}
		return true;
	}

	public List<Square> getNeighbors(Square s) {
		List<Square> temp = new ArrayList<>();
		if (s.getRow() - 1 >= 0) {
			temp.add(array[s.getRow() - 1][s.getCol()]);
		}
		if (s.getCol() + 1 <= array[s.getRow()].length - 1) {
			temp.add(array[s.getRow()][s.getCol() + 1]);
		}
		if (s.getRow() + 1 <= array.length - 1) {
			temp.add(array[s.getRow() + 1][s.getCol()]);
		}
		if (s.getCol() - 1 >= 0) {
			temp.add(array[s.getRow()][s.getCol() - 1]);
		}
		return temp;

	}

	public Square getStart() {
		return start;
	}

	public Square getExit() {
		return exit;
	}

	public void reset() {
		for (int r = 0; r < array.length; r++) {
			for (int c = 0; c < array[r].length; c++) {
				array[r][c].reset();
			}
		}
	}

	public String toString() {
		String temp = "";
		for (int r = 0; r < array.length; r++) {
			for (int c = 0; c < array[r].length; c++) {
				temp += array[r][c].toString() + " ";
				if (c == array[r].length - 1) {
					temp += "\n";
				}
			}
		}
		return temp;
	}
}
