
public class Runner {
	public static void main(String args[]) {
		System.out.println(numEars(3));
		countdown(5);
		System.out.println(cheerlead("Go Team!", 5));
		System.out.println(exponent(3, 5));
		System.out.println(fibonacci(8));
		printPattern(16);
		printPattern(10);
		System.out.println(numOfChar("aaHELLOa"));
		printAtoBbyC(10, 30, 5);
		System.out.println(countOdds(123456));
	}

	public static int numEars(int bunnies) {
		if (bunnies == 1) {
			return 2;
		} else {
			return 2 + numEars(bunnies - 1);
		}
	}

	public static void countdown(int num) {
		if (num == 1) {
			System.out.println(num + ", blastoff!");
		} else {
			System.out.print(num + ", ");
			countdown(num - 1);
		}
	}

	public static String cheerlead(String str, int i) {
		if (i == 1) {
			return str;
		} else {
			return str + cheerlead(str, i - 1);
		}
	}

	public static int exponent(int base, int power) {
		if (power == 0) {
			return 1;
		} else {
			return base * exponent(base, power - 1);
		}
	}

	public static int fibonacci(int num) {
		if (num == 0) {
			return 0;
		} else if (num == 1) {
			return 1;
		} else {
			return fibonacci(num - 1) + fibonacci(num - 2);
		}

	}

	public static void printPattern(int start) {
		if (start < 0) {
			System.out.println(start);
		} else {
			System.out.print(start + ", ");
			printPattern(start - 5);
		}
	}

	public static int numOfChar(String str) {
		if (str.length() == 0) {
			return 0;
		} else if (str.charAt(0) == 'a') {
			return 1 + numOfChar(str.substring(1));
		} else {
			return numOfChar(str.substring(1));
		}
	}

	public static void printAtoBbyC(int a, int b, int c) {
		if (a >= b) {
			System.out.println(a);
		} else {
			System.out.print(a + ", ");
			printAtoBbyC(a + c, b, c);
		}
	}

	public static int countOdds(int a) {
		if (a == 0) {
			return a;
		} else {
			if (a % 2 == 0) {
				return 0 + countOdds(a / 10);
			} else {
				return 1 + countOdds(a / 10);
			}
		}
	}
}
