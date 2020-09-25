import java.io.IOException;

public class MazeRunner
{
	public static void main(String args[]) throws IOException 
	{
		Maze maze0 = new Maze("maze0.txt");
		maze0.solve();
		Maze maze1 = new Maze("maze1.txt");
		maze1.solve();
		Maze maze2 = new Maze("maze2.txt");
		maze2.solve();
		Maze maze3 = new Maze("maze3.txt");
		maze3.solve();
	}
}