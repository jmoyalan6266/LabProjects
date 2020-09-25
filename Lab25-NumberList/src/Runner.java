
public class Runner {
	public static void main(String[] args) {
		NumberList n = new NumberList();
		System.out.println(n.isEmpty());
		System.out.println(n.toString());
		n.add(5, 0);
		System.out.println(n.toString());
		n.add(6, 0);
		System.out.println(n.toString());
		n.add(5, 0);
		System.out.println(n.toString());
		n.add(20, 0);
		System.out.println(n.toString());
		n.add(15);
		System.out.println(n.toString());
		System.out.println(n.size());

		
	} 
}
