
public class Runner {
	public static void main(String args[]) {
		System.out.println(isPalindrome("akaiaka"));
		timesTwo(68);
		System.out.println(GCD(2, 4));
		System.out.println(reverseString("String"));
		reverseString1("String");
		System.out.println();
		System.out.println(isPowerOfN(25, 3));
		curlyString("what's {all this} then");
		printPattern(16);
		System.out.println();
		printSquares(5);
		printSquares(8);
		System.out.println();
		System.out.println(wordWrap("hello, how are you doing today?", 13));

	}

	public static boolean isPalindrome(String s) {
		if (s.length() <= 1) {
			return true;
		}
		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			return isPalindrome(s.substring(1, s.length() - 1));
		} else {
			return false;
		}
	}

	public static void timesTwo(int n) {
		if (n % 2 != 0) {
			System.out.println(n);
		}
		if (n % 2 == 0) {
			System.out.print("2 * ");
			timesTwo(n / 2);
		}
	}

	public static int GCD(int a, int b) {
		if (a == 0 || b == 0)
			return a + b; // base case
		else {
			return GCD(b, a % b);
		}
	}

	public static String reverseString(String str) {
		char c = str.charAt(str.length() - 1);
		if (str.length() == 1) {
			return Character.toString(c);
		} else {
			return c + reverseString(str.substring(0, str.length() - 1));
		}
	}

	public static void reverseString1(String str) {
		char c = str.charAt(str.length() - 1);
		if (str.length() == 1) {
			System.out.println(Character.toString(c));
		} else {
			System.out.print(c + reverseString(str.substring(0, str.length() - 1)));
		}
	}

	public static boolean isPowerOfN(int num, int base) {
		if (num % base != 0) {
			return false;
		}
		if (num == 1) {
			return true;
		}
		if (num == base) {
			return true;
		} else {
			return isPowerOfN(num / base, base);
		}
	}

	public static void curlyString(String str) {
		if (str.substring(0, 1).equals("{") && str.substring(str.length() - 1, str.length()).equals("}")) {
			System.out.println(str);
		} else if (str.substring(0, 1).equals("{")) {
			curlyString(str.substring(0, str.length() - 1));
		} else if (str.substring(str.length() - 1, str.length()).equals("}")) {
			curlyString(str.substring(1, str.length()));
		} else {
			curlyString(str.substring(1, str.length() - 1));
		}
	}

	public static void printPattern(int start) {
		if (start < 0) {
			System.out.print(start + " ");
		} else {
			System.out.print(start + " ");
			printPattern(start - 5);
			System.out.print(start + " ");
		}
	}

	public static void printSquares(int s) {
		if (s == 1) {
			System.out.print(s * s + ", ");
		} else if (s % 2 != 0) {
			System.out.print(s * s + ", ");
			printSquares(s - 1);
		} else {
			printSquares(s - 1);
			System.out.print((s) * (s) + ", ");
		}
	}

	public static String wordWrap(String line, int width) {

		if (line.length() < width) {
			return line;
		} else {
			int index = line.substring(0, width + 1).lastIndexOf(" ");
			return line.substring(0, index) + "\n" + wordWrap(line.substring(index + 1), width);

		}
	}

}
