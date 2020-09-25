import java.util.Stack;

public class StackProbs {
	Stack<Integer> m;

	public StackProbs() {
	}

	public void doubleUp(Stack<Integer> nums) {
		m = new Stack<>();
		while (!nums.isEmpty()) {
			m.push(nums.pop());
		}
		while (!m.isEmpty()) {
			nums.push(m.peek());
			nums.push(m.pop());
		}
		m = nums;
	}

	public void posAndNeg(Stack<Integer> nums) {
		m = new Stack<>();
		Stack<Integer> temp = new Stack<>();
		int size = nums.size();
		while (!nums.isEmpty())
			if (nums.peek() < 0) {
				m.push(nums.pop());
			} else {
				temp.push(nums.pop());
			}
		while (!temp.isEmpty()) {
			m.push(temp.pop());
		}

	}

	public void swapPairs(Stack<Integer> nums) {
		m = new Stack<>();
		Stack<Integer> temp = new Stack<>();
		while (!nums.isEmpty()) {
			temp.push(nums.pop());
		}
		while (!temp.isEmpty()) {
			int t = temp.pop();
			if (!temp.isEmpty()) {
				int real = temp.pop();
				m.push(real);
			}
			m.push(t);
		}
	}

	public void shiftByN(Stack<Integer> nums, int n) {
		m = new Stack<>();
		Stack<Integer> temp = new Stack<>();
		int size = nums.size() - n;
		for (int i = 0; i < size; i++) {
			temp.push(nums.pop());
		}
		while (!temp.isEmpty()) {
			m.push(temp.pop());
		}
		while (!nums.isEmpty()) {
			temp.push(nums.pop());
		}
		while (!temp.isEmpty()) {
			m.push(temp.pop());
		}
	}

	public String reverseVowels(String str) {
		String tmp = "";
		Stack<Character> temp = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
					|| str.charAt(i) == 'u') {
				temp.push(str.charAt(i));
			}
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
					|| str.charAt(i) == 'u') {
				tmp += temp.pop();
			} else {
				tmp += str.charAt(i);
			}
		}
		return tmp;
	}

	public boolean bracketBalance(String s) {
		Stack<Character> temp = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[') {
				temp.push(s.charAt(i));
			} else if (s.charAt(i) == '(') {
				temp.push(s.charAt(i));
			} else if (s.charAt(i) == ')') {
				if (temp.isEmpty()) {
					return false;
				}
				if (temp.pop() != '(') {
					return false;
				}
			}
			else if (s.charAt(i) == ']') {
				if (temp.isEmpty()) {
					return false;
				}
				if (temp.pop() != '[') {
					return false;
				}
			}
		}
		return temp.isEmpty();

	}

	public void print() {
		System.out.println(m);
	}
}
