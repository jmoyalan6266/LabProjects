import java.util.HashMap;
import java.util.Set;

public class Room {
	private String description;
	private HashMap<String, Room> exits = new HashMap<String, Room>();
	Item item;

	public Room(String desc) {
		description = desc;
		item = null;
	}
	public void addItem(Item c)
	{
		item = c;
	}

	/**
	 * Initializes the exits for this room object
	 * 
	 * The Room parameter should be passed in as null if there is no exit in
	 * that direction
	 */
	public void setExit(String direction, Room neighbor)
	{
		exits.put(direction, neighbor);
	}

	/** Return a String showing all the possible exits a Room has */
	public String getExitString() {
        String result = "Exits >>> ";
		Set<String> keys = exits.keySet();//Set must be imported, in java.util package
        for (String exit : keys) {//a for-each loop
            result+= " " + exit;
        }
        return result;
	}

	public String getDescription() {
		return description;
	}

	public Room getExit(String direction)
	{
		return exits.get(direction);
	}
	public Item getItem()
	{
		return item;
	}
	public Item removeItem()
	{
		Item c = item;
		item = null;
		return c;
	}
}
