import java.util.HashMap;

public class MorseCode {
	private final String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789 ";
	private final String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
			".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
			".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "|" };
	private HashMap<String, String> toText;
	private HashMap<String, String> toCode;

	public MorseCode() {
		toText = new HashMap<>();
		toCode = new HashMap<>();
		for (int i = 0; i < alphabet.length(); i++) {
			toCode.put(alphabet.substring(i, i + 1), morse[i]);
			toText.put(morse[i], alphabet.substring(i, i + 1));
		}
	}

	public String encode(String s) {
		String e = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equals(" ")) {
				e += "| ";
			} else {
				e += toCode.get(s.substring(i, i + 1)) + " ";
			}
		}
		return e;
	}

	public String decode(String s) {
	 String [] p = s.split(" ");
	 String w = "";
	 for (int i = 0; i < p.length; i++) {
		w += toText.get(p[i]);
		}
	 return w;
	}
}
