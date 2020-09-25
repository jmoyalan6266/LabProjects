
public class NumberList {
	private Integer[] list;
	private int size;

	public NumberList() {
		list = new Integer[2];
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public String toString() {
		String s = "[";
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {
				s += list[i];
			} else {
				s += list[i] + ", ";
			}
		}
		s += "]";
		return s;
	}
	
	private void doubleCapacity() {
		int length = list.length;
		Integer[] temp = new Integer[length];
		for (int i = 0; i < length; i++) {
			temp[i] = list[i];
		}
		length = length * 2;
		list = new Integer[length];
		for (int i = 0; i < length / 2; i++) {
			list[i] = temp[i];
		}
	}
	
	public void add(Integer i, int index)
	{
		if (!(index >= 0 || index <= size))
		{
			throw new IndexOutOfBoundsException();
		}
		if (size + 1 > list.length)
		{
			doubleCapacity();
		}
		int x = size;
		while(x > index)
		{
			list[x] = list[x - 1];
			x--;
		}
		list[index] = i;
		size++;
	}
	
	public void add(Integer i)
	{
		add(i , size);
	}
}
