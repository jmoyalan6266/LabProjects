import java.io.IOException;
import java.util.Stack;

public class Debugger {
	public static void main(String[] args) throws IOException{
		Maze m = new Maze();
		m.loadMaze("maze-2");
		System.out.println(m.toString());
		System.out.println(m.getNeighbors(new Square(0,0, 0)));
		System.out.println(m.getExit().getCol());
		System.out.println();
		MyStack mine = new MyStack(1);
		Stack<Square> javas = new Stack();
		Square s = new Square(0,1,2);
		mine.push(s);
		javas.push(s);
		System.out.println(mine);
		System.out.println(javas);
	}
}
