
public class DebugRunner {
	public static void main(String args[])
	{
		
		Room rotunda = new Room("A large, echoing rotunda");
		Player p = new Player(rotunda);
		rotunda.addItem(new Item("Money"));
		System.out.println(p.getCurrentRoom().getItem().getDesc());
		
	}

}
