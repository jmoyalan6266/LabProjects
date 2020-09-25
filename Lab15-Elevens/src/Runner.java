
public class Runner {
	public static void main(String[] args) {
		ElevensBoard board = new ElevensBoard();
		System.out.println(board.toString());
		board.newGame();
		System.out.println(board.toString());
		System.out.println(board.cardIndexes());
		System.out.println(board.anotherPlayIsPossible());
	}
}
