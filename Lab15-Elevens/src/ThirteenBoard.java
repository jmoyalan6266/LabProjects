import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ThirteenBoard extends Board{

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 10;
	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public ThirteenBoard() {
		super(BOARD_SIZE, POINT_VALUES);
	}


	/**
	 * Determines if the selected cards form a valid group for removal. In
	 * Elevens, the legal groups are (1) a pair of non-face cards whose values
	 * add to 11, and (2) a group of three cards consisting of a jack, a queen,
	 * and a king in some order.
	 * 
	 * @param selectedCards
	 *            the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal; false
	 *         otherwise.
	 */
	public boolean isLegal(List<Integer> selectedCards) {
		if ((containsPairSum13(selectedCards) && selectedCards.size() == 2)
				|| (containsK(selectedCards) && selectedCards.size() == 1)) {
			return true;
		}

		return false; // REPLACE
	}

	/**
	 * Determine if there are any legal plays left on the board. In Elevens,
	 * there is a legal play if the board contains (1) a pair of non-face cards
	 * whose values add to 11, or (2) a group of three cards consisting of a
	 * jack, a queen, and a king in some order.
	 * 
	 * @return true if there is a legal play left on the board; false otherwise.
	 */
	public boolean anotherPlayIsPossible() {
		if (containsK(cardIndexes()) || containsPairSum13(cardIndexes())) {
			return true;
		}

		return false; // REPLACE
	}


	/**
	 * Check for an 11-pair in the selected cards.
	 * 
	 * @param selectedCards
	 *            selects a subset of this board. It is list of indexes into
	 *            this board that are searched to find an 11-pair.
	 * @return true if the board entries in selectedCards contain an 11-pair;
	 *         false otherwise.
	 */
	private boolean containsPairSum13(List<Integer> selectedCards) {
		int sum13 = 0;
		for (int i = 0; i < selectedCards.size(); i++) {
			for (int x = i + 1; x < selectedCards.size(); x++) {
				if (cardAt(selectedCards.get(x)).pointValue() + cardAt(selectedCards.get(i)).pointValue() == 13) {
					return true;
				}
			}
		}

		return false; // REPLACE
	}

	/**
	 * Check for a JQK in the selected cards.
	 * 
	 * @param selectedCards
	 *            selects a subset of this board. It is list of indexes into
	 *            this board that are searched to find a JQK group.
	 * @return true if the board entries in selectedCards include a jack, a
	 *         queen, and a king; false otherwise.
	 */
	private boolean containsK(List<Integer> selectedCards) {
		boolean k = false;
		for (int i = 0; i < selectedCards.size(); i++) {

			if (cardAt(selectedCards.get(i)).rank().equals("king")) {
				k = true;
			}
			if (k) {
				return true;
			}
		}

		return false; // REPLACE
	}
}
