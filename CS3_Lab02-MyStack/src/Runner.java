import java.util.Stack;

public class Runner {
	public static void main (String args[])
	{
		StackProbs myB = new StackProbs();
		Stack<Integer> t = new Stack<>();
		t.push(7);
		t.push(23);
		t.push(-7);
		t.push(0);
		t.push(22);
		t.push(-8);
		t.push(4);
		t.push(5);
		System.out.println(t);
		myB.shiftByN(t, 3);
		myB.print();
		System.out.println(myB.reverseVowels("hello how are you"));
		System.out.println(myB.bracketBalance("([()[]()])()"));

	}
}
