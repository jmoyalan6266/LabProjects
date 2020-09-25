import java.util.ArrayList;

public abstract class MazeSolver {
	Maze maze;
	public boolean isSolvable;
	public boolean isSolved;

	public MazeSolver(Maze maze) {
		this.maze = maze;
		this.makeEmpty();
		add(maze.getStart());
	}

	public abstract void makeEmpty();

	public abstract boolean isEmpty();

	public abstract void add(Square s);

	public abstract Square next();

	public boolean isSolved() {
		return isSolved;
	}

	public boolean isSolvable() {
		return isSolvable;
	}

	public abstract Square peek();

	public void step() {
		System.out.println(this.peek());

		if (this.isEmpty() && !this.isSolved()) {
			isSolved = true;
			isSolvable = false;
			return;
		}
		
		Square next = this.next();
		
		if (next.equals(this.maze.getExit())) {
			isSolved = true;
			isSolvable = true;
			return;
		}

		for (Square s : maze.getNeighbors(next)) {
			if (s.getType() != Square.WALL && s.getStatus() != Square.EXPLORED) {
				s.setStatus(Square.WORKING);
				this.add(s);
			}
		}
		next.setStatus(Square.EXPLORED);
	}


	public String getPath() {
		if (isSolved()) {
			if (isSolvable) {
				return "Solved";
			} else {
				return "Unsolvable";
			}
		} else {
			return "Not Yet Solved";
		}
	}

	public void solve() {
		while (!isSolved()) {
			step();
		}
	}

}
