import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCloud {
	private ArrayList<Word> words;
	private ArrayList<Word> topHits;
	private int totalWords;
	private int uniqueWords;

	public WordCloud(String fileName) throws IOException {
		words = new ArrayList<Word>();
		topHits = new ArrayList<Word>();
		totalWords = 0;
		uniqueWords = 0;
		load(fileName);

	}

	private int getIndex(String str) {

		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getWord().equals(str)) {
				return i;
			}
		}
		return -1;
	}

	private void load(String fileName) throws IOException {
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		while (in.hasNext()) {
			totalWords++;
			String a = in.next().toLowerCase();
			for (int t = 0; t < 2; t++) {
				if (!a.equals("")) {
					if (!Character.isLetterOrDigit(a.charAt(0))) {
						a = a.substring(1);
					}
				}
			}
			for (int t = 0; t < 2; t++) {
				if (!a.equals("")) {
					if (Character.isLetterOrDigit(a.charAt(a.length() - 1)) == false) {
						a = a.substring(0, a.length() - 1);
					}
				}
			}
			if (!a.equals("")) {
				Word w = new Word(a);
				if (getIndex(w.getWord()) == -1) {
					words.add(w);
				} else {
					words.get(getIndex(w.getWord())).increment();
				}
			}
		}
		uniqueWords = words.size();
		getTopHits();
	}

	public ArrayList<Word> getTopHits() {
		int max = 0;
		int indexOfMax = 0;
		for (int i = 0; i < 30; i++) {
			for (int t = 0; t < words.size(); t++) {
				if (words.get(t).getCount() > max) {
					indexOfMax = t;
					max = words.get(t).getCount();
				}
			}
			topHits.add(words.remove(indexOfMax));
			max = 0;
		}
		return topHits;
	}

	public void printInfo() {
		
		System.out.println("Number of Unique Words >>> " + uniqueWords);
		System.out.println("Total number of Words >>> " + totalWords);
		System.out.println("\tWord\t\tFrequency");
		for (int i = 0; i < topHits.size(); i++) {
			System.out.println((i + 1) + ")\t" + topHits.get(i).getWord() + "\t\t" + topHits.get(i).getCount());
		}
	}

}
