
/**
 * EvilHangman.java  06/04/2015
 *
 * @author - Jane Doe
 * @author - Period n
 * @author - Id nnnnnnn
 *
 * @author - I received help from ...
 *
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class EvilHangman {
	private boolean debug;
	private Scanner in;
	private List<String> wordList;
	private int wordLength;
	private int remainingGuesses;
	private String solution;
	private String guessedLetters;

	/**
	 * Construct an EvilHangman object.
	 * 
	 * @param fineName
	 *            the name of the file that contains the word list.
	 * @param debug
	 *            indicates if the size of the remaining word list should be
	 *            included in the toString result.
	 * @throws FileNotFoundException
	 *             when the fileName file does not exist.
	 */
	public EvilHangman(String fileName, boolean debug) throws FileNotFoundException {
		this.debug = debug;
		in = new Scanner(System.in);
		inputWords(fileName);
		System.out.print("Number of Guesses? ");
		remainingGuesses = in.nextInt();
		solution = "";
		for (int i = 0; i < wordLength; i++) {
			solution += "-";
		}
		guessedLetters = "";
	}

	/**
	 * Plays one the game. The user guesses letters until either they guess the
	 * word, or they run out of guesses. Game status is printed each turn and
	 * winning / losing information is printed at the conclusion of the game.
	 */
	public void playGame() {

		while (remainingGuesses > 0 && solution.indexOf("-") != -1) {
			System.out.println(this);
			String letter = inputLetter();
			guessedLetters += letter;
			List<Partition> t = this.getPartitionList(letter);
			this.removeSmallerPartitions(t);
			wordList = getWordsFromOptimalPartition(t);
			if (debug) {
				System.out.println(wordList);
			}
			String temp = solution;
			this.substitute(wordList.get(0), letter);
			if (temp.equals(solution)) {
				remainingGuesses--;
			}
		}
		if (remainingGuesses > 0) {
			System.out.println("You win, congatulations!");
			System.out.println("The word was \"" + solution + "\"");
		} else {
			System.out.println("You lose, sorry!");

			System.out.println("The word was \"" + wordList.get(0) + "\"");
		}

	}

	/**
	 * Creates and returns a status string that indicates the state of the game.
	 * 
	 * @return the game status string.
	 */
	public String toString() {
		String a = "";
		if (!debug) {
			a += "Remaining Guesses: " + remainingGuesses + "\n";
			a += "Guessed Letters: " + guessedLetters + "\n";
			a += "Solution: " + solution + "\n";
		} else {
			a += "Remaining Guesses: " + remainingGuesses + "\n";
			a += "Guessed Letters: " + guessedLetters + "\n";
			a += "Solution: " + solution + "\n";
			a += "Remaining words: " + wordList.size() + "\n";
		}
		return a;
	}

	////////// PRIVATE HELPER METHODS //////////

	/**
	 * Helper method for the constructor: Inputs the word length from the user,
	 * reads in the words from the fileName file, and initializes the wordList
	 * instance variable with the words of the correct length. This method loops
	 * until a valid word length is entered.
	 * 
	 * @param fineName
	 *            the name of the file that contains the word list.
	 * @throws FileNotFoundException
	 *             when the fileName file does not exist.
	 */
	private void inputWords(String fileName) throws FileNotFoundException {
		wordList = new ArrayList<String>();
		while (wordList.isEmpty()) {
			System.out.print("Word Length? ");
			wordLength = in.nextInt();
			Scanner file = new Scanner(new File(fileName));
			while (file.hasNext()) {
				String maybe = file.next();
				if (maybe.length() == wordLength) {
					wordList.add(maybe);
				}
			}
			if (wordList.isEmpty()) {
				System.out.println("There are no words with " + wordLength + " letters.");
			}
		}
	}

	/**
	 * Helper method for playGame: Inputs a one-letter string from the user.
	 * Loops until the string is a one-character character in the range a-z or
	 * A-Z.
	 * 
	 * @return the single-letter string converted to upper-case.
	 */
	private String inputLetter() {
		String response = "";
		while (response.length() == 0) {
			System.out.print("Next Letter? ");
			response = in.next().toUpperCase();
			if (response.length() != 1 || Character.isLetter(response.charAt(0)) == false) {
				System.out.println("Invalid Input!");
				response += "";
			}
		}
		return response;
	}

	/**
	 * Helper method for getPartitionList: Uses word and letter to create a
	 * pattern. The pattern string has the same number of letter as word. If a
	 * character in word is the same as letter, the pattern is letter; Otherwise
	 * it's "-".
	 * 
	 * @param word
	 *            the word used to create the pattern
	 * @param letter
	 *            the letter used to create the pattern
	 * @return the pattern
	 */
	private String getPattern(String word, String letter) {
		String a = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.substring(i, i + 1).equals(letter)) {
				a += letter;
			} else {
				a += "-";
			}
		}
		return a;// REPLACE
	}

	/**
	 * Helper method for playGame: Partitions each string in wordList based on
	 * their patterns.
	 * 
	 * @param letter
	 *            the letter used to find the pattern for each word in wordList.
	 * @return the list of partitions.
	 */
	private List<Partition> getPartitionList(String letter) {
		List<Partition> partitionList = new ArrayList<>();
		for (int i = 0; i < wordList.size(); i++) {
			String a = wordList.get(i);
			String pattern = getPattern(a, letter);
			boolean added = false;
			for (int x = 0; x < partitionList.size() && !added; x++) {
				if (partitionList.get(x).addIfMatches(pattern, a)) {
					added = true;
				}
			}
			if (!added) {
				Partition part = new Partition(pattern, a);
				partitionList.add(part);
			}
		}
		return partitionList;
	}

	/**
	 * Helper method for playGame: Removes all but the largest (most words)
	 * partitions from partitions.
	 * 
	 * @param partitions
	 *            the list of partitions. Precondition: partitions.size() > 0
	 *            Postcondition: partitions 1) contains all of the partitions
	 *            with the most words. 2) does not contain any of the partitions
	 *            with fewer than the most words.
	 */
	private void removeSmallerPartitions(List<Partition> partitions) {
		int max = 0;
		for (int i = 0; i < partitions.size(); i++) {
			if (partitions.get(i).getWords().size() > max) {
				max = partitions.get(i).getWords().size();
			}
		}
		for (int i = partitions.size() - 1; i >= 0; i--) {
			if (partitions.get(i).getWords().size() != max) {
				partitions.remove(i);
			}
		}

	}

	/**
	 * Helper method for playGame: Returns the words from one of the optimal
	 * partitions, that is a partition with the most dashes in its pattern.
	 * 
	 * @param partitions
	 *            the list of partitions.
	 * @return the optimal partition.
	 */
	private List<String> getWordsFromOptimalPartition(List<Partition> partitions) {
		int maxDashCount = 0;
		int indexOfMax = 0;
		for (int i = 0; i < partitions.size(); i++) {
			if (partitions.get(i).getPatternDashCount() > maxDashCount) {
				maxDashCount = partitions.get(i).getPatternDashCount();
				indexOfMax = i;
			}
		}
		return partitions.get(indexOfMax).getWords();
	}

	/**
	 * Helper method for playGame: Creates a new string for solution. If the ith
	 * letter of found equals letter, then the ith letter of solution is changed
	 * to letter; Otherwise it is unchanged.
	 * 
	 * @param found
	 *            the string to check for occurances of letter.
	 * @param letter
	 *            the letter to check for in found.
	 */
	private void substitute(String found, String letter) {
		String newSolution = "";
		for (int i = 0; i < found.length(); i++) {
			if (found.substring(i, i + 1).equals(letter)) {
				newSolution += letter;
			} else {
				newSolution += solution.substring(i, i + 1);
			}
		}
		this.solution = newSolution;
	}
}
