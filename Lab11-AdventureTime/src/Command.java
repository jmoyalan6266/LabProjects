public class Command {
	private static String[] commands = { "go", "quit", "help","take","back" };

	private String commandWord;
	private String secondWord;

	public Command(String first, String second) {
		commandWord = first;
		secondWord = second;
	}

	/** Returns true if str is a valid command (exists in the array) */
	public static boolean isCommand(String str) {
		for (int i = 0; i < commands.length; i++) {
			if (str.equals(commands[i])) {
				return true;
			}
		}

		return false; // REPLACE
	}

	/** Gets all the command words in the array, returns as a String */
	public static String getCommandsString() {
		// TODO

		return commands[0] + " " + commands[1] + " " + commands[2] +" " + commands[3]+" "+commands[4]; // REPLACE
	}

	/**
	 * An 'unknown' command will have a null commandWord A 'known' command will
	 * have a valid command as a commandWord
	 */
	public boolean isUnknown() {
		if (!Command.isCommand(this.commandWord)) {
			return true;
		}
		return false; // REPLACE
	}
	

	@Override
	public String toString() {
		return commandWord + " " + secondWord;
	}

	public String getCommandWord() {
		return commandWord;
	}

	public String getSecondWord() {
		return secondWord;
	}
}