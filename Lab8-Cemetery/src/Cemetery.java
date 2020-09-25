import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cemetery {
	private ArrayList<Tombstone> g = new ArrayList<>();

	public Cemetery(String fileName)   throws IOException {
		File nFile = new File(fileName)	;
		Scanner in = new Scanner(nFile);
		String s = "";
		String b = "";
		while (in.hasNext()) {
			while (!in.hasNextInt()) {
				s += in.next()+" ";
			}
			b = in.next() + in.next() + in.next();

			int c = parseAge(in.next());
			String a = in.nextLine();
			g.add(new Tombstone(s, b, c, a));
		}
		in.close();
	}
	public ArrayList<Tombstone> getArray()
	{
		return g;
	}
	public int numTombs()
	{
		return g.size();
	}
	public Tombstone getTomb(int index)
	{
		return g.get(index);
	}

	public static int parseAge(String ageString) {
		if (ageString.contains("d")) { // age supplied in days
			ageString = ageString.replaceAll("d", "");
			return Integer.parseInt(ageString);
		}

		int result = 0;

		boolean done = true;

		try {
			result = Integer.parseInt(ageString);
		} // is the String a whole number of years?

		catch (NumberFormatException n) {
			done = false;
		}

		if (done) // successfully parsed as an int, return value
			return 365 * result; // ignoring leap years

		double ageDouble = 0;

		done = true;

		try {
			ageDouble = Double.parseDouble(ageString);
		} // is the String a floating point number of years?

		catch (NumberFormatException n) {
			done = false;
		}

		if (done) { // successfully parse as a double, String doesn't contain
					// any text
			return (int) (ageDouble * 365); // ignoring leap years, using 30 for
											// days in a month
		}

		if (ageString.contains("w")) { // age is supplied in weeks, return
										// appropriately
			ageString = ageString.replaceAll("w", "");
			return Integer.parseInt(ageString) * 7;
		}

		return 0;
	}
}
