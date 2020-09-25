import java.util.ArrayList;

public class Player {
	private Room currentRoom;
	private ArrayList<Item> inventory = new ArrayList<Item>();
	public Player(Room current)
	{
		currentRoom = current;
	}
	
	public void setCurrentRoom(Room c)
	{
		currentRoom = c;
	}
	public void addToInventory(Item c)
	{
		inventory.add(c);
	}
	public Room getCurrentRoom()
	{
		return currentRoom;
	}
	public String getInventory()
	{
		return inventory.toString();
	}
	public boolean hasItem(Item c)
	{
		return inventory.contains(c);
	}
	

}
