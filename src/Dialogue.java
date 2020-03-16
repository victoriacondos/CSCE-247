import java.util.Scanner;

public class Dialogue {
	
	private static Scanner scanner = new Scanner(System.in);
	
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
	
	public static Command mainMenu() {
		System.out.println("Hello " + UserInterface.user.getUsername() + "\n\n"
				+ "Please enter:\n"
				+ "\t1) to Find Columbia Events\n"
				+ "\t2) to View Inventory\n"
				+ "\t0) to Log Out");
		int option = getUserCommand(2);
		if (option == 0) return new LogOutCommand();
		if (option == 1) return null;
		else {
			return null;
		}
	}
	
	
	
	public static int getUserCommand(int numCommands) {
		String input;
		int command = -1;
		while (command > numCommands || command < 0) {
			input = scanner.nextLine();
			command = Integer.parseInt(input);
		}
		return command;
	}
	
	
	
	public static Account logIn() {
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
