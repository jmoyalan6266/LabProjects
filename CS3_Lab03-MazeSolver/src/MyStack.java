import java.util.EmptyStackException;

public class MyStack implements StackADT {
	Square[] stack;
	int size;

	public MyStack() {
		this(4);

	}

	public int size() {
		return size;
	}

	public void clear() {
		for (int i = 0; i < stack.length; i++) {
			stack[i] = null;
		}
	}

	public MyStack(int initCap) {
		size = initCap;
		stack = new Square[size];
	}

	public boolean isEmpty() {
		for (int i = 0; i < size; i++) {
			if (stack[i] != null) {
				return false;
			}
		}
		return true;
	}

	public Square peek() {
		for (int i = size - 1; i >= 0; i--) {
			if (stack[i] != null) {
				return stack[i];
			}
		}
		throw new EmptyStackException();
	}

	public Square pop() {
		for (int i = size - 1; i >= 0; i--) {
			if (stack[i] != null) {
				Square t = stack[i];
				stack[i] = null;
				return t;
			}
		}
		throw new EmptyStackException();
	}

	public void push(Square item) {
		if (stack[size - 1] != null) {
			doubleCapacity();
		}
		for (int i = 0; i < size; i++) {
			if (stack[i] == null) {
				stack[i] = item;
				break;
			}
		}
	}

	private void doubleCapacity() {

		Square[] temp = new Square[size];
		for (int i = 0; i < size; i++) {
			temp[i] = stack[i];
		}
		size = size * 2;
		stack = new Square[size];
		for (int i = 0; i < size / 2; i++) {
			stack[i] = temp[i];
		}
	}

	@Override
	public String toString() {
		String temp = "[";
		for (int i = size - 1; i >= 0; i--) {
			if (i == 0) {
				temp += stack[i];
			} else {
				temp += stack[i] + ", ";
			}
		}
		temp += "]";
		return temp;
	}

}
