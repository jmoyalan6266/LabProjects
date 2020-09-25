import java.util.EmptyStackException;

public class MyStack {
	Integer[] stack;
	int size;

	public MyStack() {
		this(4);

	}

	public MyStack(int initCap) {
		size = initCap;
		stack = new Integer[size];
	}

	public boolean isEmpty() {
		for (int i = 0; i < size; i++) {
			if (stack[i] != null) {
				return false;
			}
		}
		return true;
	}

	public Integer peek() {
		for (int i = size - 1; i >= 0; i--) {
			if (stack[i] != null) {
				return stack[i];
			}
		}
		throw new EmptyStackException();
	}

	public Integer pop() {
		for (int i = size - 1; i >= 0; i--) {
			if (stack[i] != null) {
				int t = stack[i];
				stack[i] = null;
				return t;
			}
		}
		throw new EmptyStackException();
	}

	public void push(Integer item) {
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

		Integer[] temp = new Integer[size];
		for (int i = 0; i < size; i++) {
			temp[i] = stack[i];
		}
		size = size * 2;
		stack = new Integer[size];
		for (int i = 0; i < size / 2; i++) {
			stack[i] = temp[i];
		}
	}

	@Override
	public String toString() {
		String temp = "";
		for (int i = size - 1; i >= 0; i--) {
			temp += stack[i] + "\n";
		}
		temp += "---------------";
		return temp;
	}

}
