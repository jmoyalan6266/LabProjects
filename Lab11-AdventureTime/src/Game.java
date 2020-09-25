import java.util.Scanner;

public class Game {
	private Player player;
	private Scanner console;
	private Room previousRoom;
	private Item key;
	private Room winningRoom;

	public Game() {
		console = new Scanner(System.in);
		createRooms();
	}

	/** Creates Room objects and sets exits to create the game world */
	private void createRooms() {
		// create Rooms
		Room rotunda = new Room("A large, echoing rotunda");
		Room principalsOffice = new Room("The principal's office");
		Room entryWay = new Room("School entryway");
		Room outside = new Room("Outside the school");
		Room carParking = new Room("Car parking for School");
		Room Hall = new Room("Long Winding Hallway");
		Room footballField = new Room("Massive Football field");
		Room comsciClass = new Room("The class where legends are made: AP CS");
		Room secretRoom = new Room("The room who's name will never be known");
		Room cafeteria = new Room("The Cafeteria");
		Room ultimateRoom = new Room("Room filled with desires beyond imagination");
		winningRoom = ultimateRoom;

		// set exits for Rooms
		outside.setExit("north", entryWay);
		outside.setExit("west", carParking);
		outside.addItem(new Item("Flashlight"));
		carParking.setExit("west", outside);
		carParking.addItem(new Item("Monkey"));
		entryWay.setExit("north", rotunda);
		entryWay.setExit("south", outside);
		entryWay.setExit("east", principalsOffice);
		entryWay.setExit("west", Hall);
		principalsOffice.setExit("west", entryWay);
		principalsOffice.setExit("east", ultimateRoom);
		principalsOffice.addItem(new Item("Computer"));
		ultimateRoom.setExit("west", principalsOffice);
		rotunda.setExit("south", entryWay);
		rotunda.setExit("west", cafeteria);
		cafeteria.setExit("east", rotunda);
		cafeteria.setExit("south", Hall);
		Hall.setExit("east", entryWay);
		Hall.setExit("south", footballField);
		Hall.setExit("west", comsciClass);
		Hall.setExit("north", cafeteria);
		footballField.setExit("north", Hall);
		footballField.addItem(new Item("Football"));
		comsciClass.setExit("east", Hall);
		comsciClass.setExit("west", secretRoom);
		secretRoom.setExit("east", comsciClass);
		Item i = new Item("Magical Flute");
		key = i;
		secretRoom.addItem(i);

		// initialize game's starting room
		player = new Player(outside);
	}

	private void printWelcome() {
		System.out.println("Welcome to my text-based adventure!");
		System.out.println("Find the Magical Flute and reach Ultimate Room to Win");
		System.out.println("Type 'help' if you need help\n");
		System.out.println("You are here >>> " + player.getCurrentRoom().getDescription());
		if (player.getCurrentRoom().getItem() != null) {
			System.out.println("There is a "+ player.getCurrentRoom().getItem().getDesc()+ " in the room");}
	}

	private void printHelp() {
		System.out.println("You are alone, you are lost.");
		System.out.println("You wander around an emtpy school.");
		System.out.println("Your commands are >>> " + Command.getCommandsString());
	}

	/** Takes a Command object and attempts to process it as a game command */
	private boolean processCommand(Command command) {
		boolean finished = false;
		if (command.isUnknown()) {
			System.out.println("I don't know what you mean ... ");
			return false;
		}
		String commandWord = command.getCommandWord();
		if (commandWord.equals("help")) {
			printHelp();
		} else if (commandWord.equals("go")) {
			goRoom(command);
		} else if (commandWord.equals("quit")) {
			finished = quit(command);
		} else if (commandWord.equals("take")) {
			player.addToInventory(player.getCurrentRoom().removeItem());
			System.out.println("You currently have "+player.getInventory());
		}
		else if (commandWord.equals("back"))
		{
			back();
		}
		return finished;
	}

	/** Attempts to move the player to another Room based on their Command */
	private void goRoom(Command command) {
		if (command.getSecondWord() == null) {
			System.out.println("Go where");
			return;
		}
		String direction = command.getSecondWord();
		Room nextRoom = new Room(null);
		previousRoom = player.getCurrentRoom();
		nextRoom = player.getCurrentRoom().getExit(direction);

		if (nextRoom != null) {
			player.setCurrentRoom(nextRoom);
			System.out.println("You are here >>> " + player.getCurrentRoom().getDescription());
			if (player.getCurrentRoom().getItem() != null) {
				System.out.println("There is a "+ player.getCurrentRoom().getItem().getDesc()+ " in the room");}
			
		
		} else {
			System.out.println("There is no door");
		}

	}
	private void back()
	{
		Room nextRoom = new Room(null);
		nextRoom = previousRoom;
		if (nextRoom != null) {
			player.setCurrentRoom(nextRoom);
			System.out.println("You are here >>> " + player.getCurrentRoom().getDescription());
			if (player.getCurrentRoom().getItem() != null) {
				System.out.println("There is a "+ player.getCurrentRoom().getItem().getDesc()+ " in the room");}
			
		
		} else {
			System.out.println("There is no door");
		}
	}

	/** Returns true if the user is wanting to quit */
	private boolean quit(Command command) {
		if (command.getSecondWord() != null) {
			System.out.println("Quit what?");
			return false;
		} else {
			System.out.println("Thanks for playing, goodbye");
			return true;
		}

	}

	/** This method starts the game, continuing until the user wants to quit */
	public void play() {
		printWelcome();
		boolean finished = false;
		while (!finished) {
			System.out.println(player.getCurrentRoom().getExitString());
			System.out.print(">");
			String line = console.nextLine();
			Scanner tokenizer = new Scanner(line);
			String command = null;
			String second = null;
			if (tokenizer.hasNext()) {
				command = tokenizer.next();
				if (tokenizer.hasNext()) {
					second = tokenizer.next();
				}
			}
			Command t = new Command(command, second);
			finished = processCommand(t);
			if (player.hasItem(key) && player.getCurrentRoom() == winningRoom)
			{
				System.out.println();
				System.out.println("You have won the game. The Fountain of Youth is now yours.");
				System.out.println("Be proud. You will live forever");
				System.out.println("You bested me fiend");
				finished = true;
			}
		}
	}
}
