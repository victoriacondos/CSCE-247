/**
 * @author Brett Logeais
 * Purpose: user interface to the ticketing system
 */

import java.util.Scanner;

public class Dialogue {
	
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Purpose: shows login options
	 * @return Command: user-selected command
	 */
	public static Command welcome() {
		System.out.println("Welcome to TicketPlante\n\n"
				+ "Please enter:\n"
				+ "\t1) to Log In\n"
				+ "\t2) to Sign Up\n"
				+ "\t3) to Continue as Guest\n"
				+ "\t0) to Exit\n");
		int option = getUserCommand(3);
		if (option == 0) return null;
		if (option == 1) return new LogInCommand();
		if (option == 2) return new SignUpCommand();
		else {
			System.out.println("\n\t-------------------\n"
					+ "\tContinuing as Guest\n"
					+ "\t-------------------\n");
			UserInterface.user = new Account("Guest", "");
			UserInterface.setMenu(1);
			return null;
		}
	}
	
	/**
	 * Purpose: shows main menu options
	 * @return Command: user-selected command
	 */
	public static Command mainMenu() {
		if (UserInterface.user instanceof ManagerAccount) {
			System.out.println("Hello Manager " + UserInterface.user.getUsername() + "\n\n"
					+ "Please enter:\n"
					+ "\t1) to Add an Event\n"
					+ "\t2) to Edit an Event\n"
					+ "\t3) to Remove an Event\n"
					+ "\t0) to Log Out");
			int option = getUserCommand(3);
			if (option == 0) return new LogOutCommand();
			if (option == 1) return null;
			
		} else {
			System.out.println("Hello " + UserInterface.user.getUsername() + "\n\n"
					+ "Please enter:\n"
					+ "\t1) to Find Columbia Events\n"
					+ "\t2) to View Inventory\n"
					+ "\t0) to Log Out");
			int option = getUserCommand(2);
			if (option == 0) return new LogOutCommand();
			if (option == 1) return new ListEventsCommand();
			else {
				return null;
			}
		}
		return null;
	}
	
	
	/**
	 * Purpose: gets user input and checks for validity
	 * @param numCommands: number of commands available
	 * @return command: corrected user input
	 */
	public static int getUserCommand(int numCommands) {
		String input;
		int command = -1;
		while (command > numCommands || command < 0) {
			input = scanner.nextLine();
			try {
				command = Integer.parseInt(input);
			} catch (NumberFormatException ex) {
				System.out.println("\tERROR: Invalid Input");
			}
		}
		return command;
	}
	
	
	
	public static Account getLogIn() {
		System.out.println("Username:");
		String username = scanner.nextLine();
		System.out.println("Password:");
		String password = scanner.nextLine();
		return new Account(username, password);
	}
	
	public static boolean signUp() {
		System.out.println("Is this a Manager Account?\n\nEnter y if yes, enter if no\n");
		String response = scanner.nextLine();
		return response.equalsIgnoreCase("y");
	}
}
