
public class Square {
	public static final int SPACE = 0;
	public static final int WALL = 1;
	public static final int START = 2;
	public static final int EXIT = 3;

	public static char WORKING = 'o';
	public static char EXPLORED = '.';
	public static char ON_EXIT_PATH = 'x';
	public static char UNKNOWN = '_';

	int type;
	private int row;
	private int col;
	private char status;

	public Square(int row, int col, int type) {
		this.row = row;
		this.col = col;
		this.type = type;
		//this.status = UNKNOWN;
	}

	@Override
	public String toString() {
		String temp = "";
		if (type == SPACE) {
			temp += status;
		} else if (type == WALL) {
			temp += "#";
		} else if (type == START) {
			temp += "S";
		} else {
			temp += "E";
		}
		return temp;
	}

	@Override
	public boolean equals(Object obj) {
		Square temp = (Square) obj;
		if (type == temp.getType()) {
			return true;
		} else {
			return false;
		}
	}
	public void reset()
	{
		status = UNKNOWN;
	}
	
	public void setStatus(char i)
	{
		status = i;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int getType() {
		return type;
	}

	public char getStatus() {
		return status;
	}
}
