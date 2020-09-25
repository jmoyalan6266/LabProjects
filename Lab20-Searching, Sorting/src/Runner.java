
public class Runner {
	public static void main (String args[])
	{
		SearchSort m = new SearchSort(10);
		//System.out.println(m.toString());
		//System.out.println(m.binarySearchRecursive(1));
/*		m.bubbleSort(true);
		m.bubbleSort(false);
		System.out.println(m.toString());
		m.selectionSort(true);*/
		m.mergeSort(m.getArray(), 0, m.getArray().length - 1 );
		System.out.println(m);
		
	}
}
