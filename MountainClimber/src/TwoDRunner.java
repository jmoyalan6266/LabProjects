import java.util.*;
public class TwoDRunner {
	public static void main(String args[])

	{
		TwoDArrays t=new TwoDArrays(new int[][] {{1, 2}, {10, 11}}) ;
		System.out.println(t.Sum());
		TwoDArrays a=new TwoDArrays(new int[][] {{2, 3, 1}, {5, 4, 6}});
		System.out.println(a.isSquare());
		a=new TwoDArrays(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
		System.out.println(a.inSequence());
		a=new TwoDArrays(new int[][] {{3, 1, 5, 7}, {4, 12, -3, 8}});
		System.out.println(Arrays.toString(a.closestToZero()));
		a=new TwoDArrays(new int[][] {{1,2,3}, {3,2,1}});
		a.addMatrix(new int[][] {{2,3,1}, {3,1,2}});
		a.print();
		a=new TwoDArrays(new int[][] {{4, 1, 3}, {8, 2, 6}});
		System.out.println(Arrays.toString(a.twoMin()));
		a=new TwoDArrays(new int[][] {{1, 2, 3}, {4, 5, 6}, {6}});
		System.out.println(a.columnSum(2));
		a=new TwoDArrays(new int[][] {{1, 2, 3}, {1}, {2, 2, 1}});
		System.out.println(a.isColumnMagic());
		a=new TwoDArrays(new int[][] {{1, 2, 3}, {3, 2, 1}, {7, 2, 2}});
		System.out.println(a.sameDiagonalSums());		
		a = new TwoDArrays(new int[][] {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}});
		System.out.println(a.sameDiagonalSums());

		
	}

}
