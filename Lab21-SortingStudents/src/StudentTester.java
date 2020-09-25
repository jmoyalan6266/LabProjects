import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StudentTester {
	public static List<Student> list1 = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		Student a = new Student("Joe", 100009);
		Student b = new Student("Sally", 100004);
		Student c = new Student("Sam", 100007);
		Student d = new Student("Bob", 100006);

		List<Student> list = new ArrayList<>();

		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);

		Collections.sort(list); // this wouldn't compile if Student didn't
								// implement Comparable!

		System.out.println(list);
		Scanner in = new Scanner(new File("names (1).csv"));
		while (in.hasNext()) {
			int rand = (int) (Math.random() * 999999) + 100000;
			Student s = new Student(in.next(), rand);
			list1.add(s);
		}
		bubbleSort();
		System.out.println(list1);
	}

	public static void bubbleSort()
	{
		for(int i = 0 ; i < list1.size()-1 ;i++ )
		{
			for(int x = 0 ; x < list1.size() - 1 ; x++)
			{
				if (list1.get(x + 1).compareTo(list1.get(x)) < 0)
				{
					swap( x + 1 , x);
				}
			}
		}
	}
	private static void swap(int i, int j) {
		Student temp = list1.get(i);
		list1.set(i , list1.get(j));
		list1.set(j , temp);
	}
}
